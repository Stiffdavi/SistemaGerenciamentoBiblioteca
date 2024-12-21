package library_package;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
	List<Book> books;
	List<Reader> readers;
	List<Loan> loans;
	
	 public Library() {
	        books = new ArrayList<>(); 
	        readers = new ArrayList<>(); 
	        loans = new ArrayList<>(); 
	    }
	Scanner scan = new Scanner(System.in);
	
	  int nextBookId = 1;
	  int nextReaderId = 1;
	  int nextLoanId = 1;
	
	 // Cadastro de Livros
	  public void registerBook() {
	        System.out.println("Digite o título do livro:");
	        String title = scan.nextLine();
	        
	        System.out.println("Digite o autor do livro:");
	        String author = scan.nextLine();
	        
	        System.out.println("Digite o gênero do livro:");
	        String genre = scan.nextLine();
	        
	        System.out.println("Digite a quantidade de cópias disponíveis:");
	        int availableCopies = scan.nextInt();
	        scan.nextLine(); 
	        
	        

	        Book book = new Book(nextBookId, title, author, genre, availableCopies, 0);
	        books.add(book);
	        System.out.println("Livro cadastrado com sucesso!");
	        System.out.println(book);
	        nextBookId++;
	    }
	
    // Cadastro de Leitores
	  public void registerReader() {
	        System.out.println("Digite o nome do leitor:");
	        String name = scan.nextLine();
	        
	        System.out.println("Digite o telefone do leitor:");
	        String phone = scan.nextLine();

	        Reader reader = new Reader(nextReaderId, name, phone);
	        readers.add(reader);
	        System.out.println("Leitor cadastrado com sucesso!");
	        System.out.println(reader);
	        nextReaderId++;
	    }
	
	// Registro de Empréstimos
	  public void registerLoan(int readerId, int bookId, String loanDate) {
		  Reader reader = null;
		  for (Reader r : readers) {
		      if (r.getId() == readerId) {
		          reader = r;
		          break;
		      }
		  }

		  Book book = null;
		  for (Book b : books) {
		      if (b.getId() == bookId) {
		          book = b;
		          break;
		      }
		  }
		  
		  if (reader == null) {
	            System.out.println("Erro: Leitor não encontrado.");
	            return;
	        }
	        
	        if (book == null) {
	            System.out.println("Erro: Livro não encontrado.");
	            return;
	        }

	        if (book.getAvailableCopies() <= 0) {
	            System.out.println("Erro: Não há cópias disponíveis para este livro.");
	            return;
	        }

	        book.setAvailableCopies(book.getAvailableCopies() - 1);
	        book.setLoanCount(book.getLoanCount() + 1);
	        Loan loan = new Loan(nextLoanId, reader, book, loanDate);
	        loans.add(loan);
	        nextLoanId++;
	        System.out.println("Empréstimo registrado com sucesso para: " + reader.getName());
	  }
	  
	  // Registro de Devoluções
	    public void registerReturn(int loanId, String returnDate) {
	        Loan loan = null;
	        for (Loan l : loans) {
	            if (l.getLoanId() == loanId) {
	                loan = l;
	                break;
	            }
	        }

	        if (loan == null) {
	            System.out.println("Erro: Empréstimo não encontrado.");
	            return;
	        }

	        loan.setReturnDate(returnDate);
	        Book book = loan.getBook();
	        book.setAvailableCopies(book.getAvailableCopies() + 1);
	        System.out.println("Devolução registrada com sucesso. Livro: " + book.getTitle());
	  
}
	 // Relatórios

	    public void displayAvailableBooks() {
	        System.out.println("Livros disponíveis:");
	        for (Book book : books) {
	            if (book.getAvailableCopies() > 0) {
	                System.out.println("- " + book.getTitle() + " (Cópias disponíveis: " + book.getAvailableCopies() + ")");
	            }
	        }
	    }

	    public void displayReaderHistory(int readerId) {
	        Reader reader = null;
	        for (Reader r : readers) {
	            if (r.getId() == readerId) {
	                reader = r;
	                break;
	            }
	        }

	        if (reader == null) {
	            System.out.println("Erro: Leitor não encontrado.");
	            return;
	        }

	        System.out.println("Histórico de empréstimos para: " + reader.getName());
	        for (Loan loan : loans) {
	            if (loan.getReader().getId() == readerId) {
	                System.out.println("- Livro: " + loan.getBook().getTitle() + ", Data de Empréstimo: " + loan.getLoanDate());
	            }
	        }
	    }
	    public void displayMostBorrowedBooks() {
	        System.out.println("Livros mais emprestados:");

	        // Bubble Sort 
	        for (int i = 0; i < books.size() - 1; i++) {
	            for (int j = 0; j < books.size() - 1 - i; j++) {
	                if (books.get(j).getLoanCount() < books.get(j + 1).getLoanCount()) {
	                    // Troca os livros de posição
	                    Book temp = books.get(j);
	                    books.set(j, books.get(j + 1));
	                    books.set(j + 1, temp);
	                }
	            }
	        }

	        // Exibe os livros ordenados
	        for (Book book : books) {
	            System.out.println("- " + book.getTitle() + " (Empréstimos: " + book.getLoanCount() + ")");
	        }
	    
}
}
  