package Book;

public class Book {
	private String title;
    private String isbn;
    private Author author;

    public Book(String title, String isbn, Author author) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public Author getAuthor() {
        return author;
    }
    
    public void printInfo() {
    	System.out.println("Title: " + this.title);
    	System.out.println("ISBN: " + this.isbn);
    	System.out.println("Author: " + this.author.getName());
    	System.out.println("Biography: "  + author.getBiography());
    	
    }
}


