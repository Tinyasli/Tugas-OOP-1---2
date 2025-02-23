package Transaksi;

import java.util.ArrayList;

import Book.Book;

public class Library {
	public ArrayList<Book> books = new ArrayList<Book>();
	
	public void addBook(Book book) {
		books.add(book);
		System.out.println("Book added to library: " + book.getTitle());
	}

	public void borrowBook(Borrower borrower, Book book) {
		books.remove(book);
		borrower.AddBookBorrow(book);
		System.out.println(borrower.getName() +" borrowed: " + book.getTitle());
	}

	public void returnBook(Borrower borrower, Book book) {
		// TODO Auto-generated method stub
		books.add(book);
		borrower.removeBook(book);
		System.out.println(borrower.getName() + " returned: " + book.getTitle());
	}

	public void displayLibraryBooks() {
		System.out.println("Books in Library:");
		for(Book book :  books) {
			book.printInfo();
			System.out.println("------------------------");
		}
	}

}
