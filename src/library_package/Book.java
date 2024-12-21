package library_package;

import java.util.Scanner;

public class Book {
public static Scanner scan = new Scanner(System.in);

int id;
String title;
String author;
String genre;
int availableCopies;
int loanCount;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getGenre() {
	return genre;
}
public void setGenre(String genre) {
	this.genre = genre;
}
public int getAvailableCopies() {
	return availableCopies;
}
public void setAvailableCopies(int avaliableCopies) {
	this.availableCopies = avaliableCopies;
}
public int getLoanCount() {
	return loanCount;
}
public void setLoanCount(int loanCount) {
	this.loanCount = loanCount;
}

public Book(int id, String title, String author, String genre, int avaliableCopies, int loanCount) {
	this.id = id;
	this.title = title;
	this.author = author;
	this.genre = genre;
	this.availableCopies = avaliableCopies;
	this.loanCount = loanCount;
}

public Book() {
	
}

// Método para atualizar a quantidade de cópias de um livro fornecido
public void updateQuantity(Book book) {
    int op; 
    int availableCopies = book.getAvailableCopies();
    do {
    	System.out.println("----------------------");
        System.out.println("Selecione uma opção:");
        System.out.println("1 - Incrementar valor");
        System.out.println("2 - Decrementar valor");
        System.out.println("0 - Sair");
        op = scan.nextInt();
        
        // Verifica a opção escolhida
        switch (op) {
            case 1:
                System.out.print("Digite o valor a incrementar: ");
                int increment = scan.nextInt();
                availableCopies += increment; // Incrementa o valor
                System.out.println("Quantidade atualizada: " + availableCopies);
                break;
            case 2:
                System.out.print("Digite o valor a decrementar: ");
                int decrement = scan.nextInt();
                if (decrement > availableCopies) {
                    System.out.println("Erro: Não há cópias suficientes para decrementar.");
                } else {
                    availableCopies -= decrement; // Decrementa o valor
                    System.out.println("Quantidade atualizada: " + availableCopies);
                }
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    } while (op != 0); // Sai do loop quando o usuário digitar 0
}

public String toString() {
	return "ID: " + id +  "  | Titulo: " + title + "  | Autor: " + author + "  | Genêro: " + genre + " | Cópias Disponíveis: "
			+ availableCopies;
}







}
