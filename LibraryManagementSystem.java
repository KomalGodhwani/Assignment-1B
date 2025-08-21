import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean available;

    
    public Book(String title, String author, String isbn, boolean available) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = available;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    
    @Override
    public String toString() {
        return "Book{" +
                "Title='" + title + '\'' +
                ", Author='" + author + '\'' +
                ", ISBN='" + isbn + '\'' +
                ", Available=" + available +
                '}';
    }
}

class Library {
    private List<Book> books;

   
    public Library() {
        books = new ArrayList<>();
    }

 
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

  
    public void removeBook(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
        System.out.println("Book with ISBN " + isbn + " removed.");
    }

    public Book searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

  
    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library.");
        } else {
            System.out.println("Books in Library:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}


public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        
        Book b1 = new Book("Java Basics", "James Gosling", "1111", true);
        Book b2 = new Book("Java Advance", "Komal", "2222", true);
        Book b3 = new Book("Python ", "Guido van Rossum", "3333", true);

        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);

        
        library.listBooks();

      
        System.out.println("\nSearching for 'Spring Boot Guide'");
        Book found = library.searchBook("Spring Boot Guide");
        System.out.println(found != null ? "Found: " + found : "Book not found");

        
        System.out.println("\nRemoving book with ISBN 2222");
        library.removeBook("2222");

       
        library.listBooks();
    }
}
