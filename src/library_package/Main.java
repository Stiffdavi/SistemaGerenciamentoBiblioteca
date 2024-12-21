package library_package;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Library manager = new Library();
        Scanner scan = new Scanner(System.in);
        int op;

        do {
            System.out.println("=== Menu Principal ===");
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Cadastrar Leitor");
            System.out.println("3. Registrar Empréstimo");
            System.out.println("4. Registrar Devolução");
            System.out.println("5. Exibir Livros Disponíveis");
            System.out.println("6. Exibir Histórico de Leitor");
            System.out.println("7. Exibir Livros Mais Emprestados");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            op = scan.nextInt();
            scan.nextLine(); 

            switch (op) {
                case 1:
                    manager.registerBook();
                    break;
                case 2:
                    manager.registerReader();
                    break;
                case 3:
                    System.out.println("Digite o ID do livro para empréstimo:");
                    int bookId = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Digite o ID do leitor:");
                    int readerId = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Digite a data do empréstimo:");
                    String date = scan.nextLine();
                    manager.registerLoan(readerId, bookId, date);
                    break;
                case 4:
                    System.out.println("Digite o ID do empréstimo:");
                    int loanId = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Digite a data da devolução:");
                    String returnDate = scan.nextLine();
                    manager.registerReturn(loanId, returnDate);
                    break;
                case 5:
                    manager.displayAvailableBooks();
                    break;
                case 6:
                	System.out.println("Digite o ID do leitor que deseja ver o histórico:");
                    readerId = scan.nextInt();
                    scan.nextLine();
                	manager.displayReaderHistory(readerId);
                    break;
                case 7:
                    manager.displayMostBorrowedBooks();
                    break;
                case 0:
                    System.out.println("Saindo do sistema, até logo!");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }

        } while (op != 0);
	}
}
