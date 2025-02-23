package Transaksi;
import java.util.ArrayList;
import Book.Book;

public class Borrower{
	public ArrayList<Book> borrowerBook = new ArrayList<Book>();
	private String name;
	
	public Borrower(String nama) {
		this.name = nama;
	}

	public String getName() {
        return name;
    }
	
	public void displayBorrowedBooks(){
		System.out.println(this.name + "'s Borrowed Books:");
		for(Book book :  borrowerBook){
			book.printInfo();
			System.out.println("------------------------");
		}
	}

	public void AddBookBorrow(Book book){
		borrowerBook.add(book);
	}

	public void removeBook(Book book){
		borrowerBook.remove(book);
	}
}