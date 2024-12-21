package library_package;

public class Loan {
int LoanId;
Reader reader;
Book book;
String loanDate;
String returnDate;

public int getLoanId() {
	return LoanId;
}
public void setLoanId(int loanId) {
	LoanId = loanId;
}
public Reader getReader() {
	return reader;
}
public void setReader(Reader reader) {
	this.reader = reader;
}
public Book getBook() {
	return book;
}
public void setBook(Book book) {
	this.book = book;
}
public String getLoanDate() {
	return loanDate;
}
public void setLoanDate(String loanDate) {
	this.loanDate = loanDate;
}
public String getReturnDate() {
	return returnDate;
}
public void setReturnDate(String returnDate) {
	this.returnDate = returnDate;
}

public Loan(int loanId, Reader reader, Book book, String loanDate, String returnDate) {
	LoanId = loanId;
	this.reader = reader;
	this.book = book;
	this.loanDate = loanDate;
	this.returnDate = returnDate;
}

public Loan(int loanId, Reader reader, Book book, String loanDate) {
	LoanId = loanId;
	this.reader = reader;
	this.book = book;
	this.loanDate = loanDate;
}

public Loan() {
}

//Atualiza a data de devolução do livro
public boolean registerReturn(Loan loan, String returnDate) {
 
    // Atualiza a data de devolução
    loan.setReturnDate(returnDate);
    System.out.println("Data de devolução registrada com sucesso.");
    return true;
}

public String toString() {
	if (returnDate == null) {
	return "Loan: " + LoanId + " | Leitor: " + reader + " | Livro" + book + " | Data do Empréstimo: " + loanDate
			+ " | Data da Devolução: -";
	}
	else {
		return "Loan: " + LoanId + " | Leitor: " + reader + " | Livro" + book + " | Data do Empréstimo: " + loanDate
				+ " | Data da Devolução: " + returnDate;
	}
}





}
