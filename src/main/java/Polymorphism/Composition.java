package Polymorphism;

import java.util.ArrayList;
import java.util.List;

class Book{
	String title;
	String author;
	Book(String title,String author){
		this.title=title;
		this.author=author;
		
	}
}
class Library{
	private final List<Book> book;
	Library(List<Book> book){
		this.book=book;
	}
	public List<Book> getTotalBooksinLibrary(){
		return book;
	}
}
public class Composition {
	public static void main(String[] args) {
		Book b1=new Book("Java","Json");
		Book b2=new Book("C","Hsdn");
		Book b3=new Book("PHP","ABC");
		
		List<Book> books=new ArrayList<>();
		books.add(b1);
		books.add(b2);
		books.add(b3);
		
		Library lib=new Library(books);
		for(Book book:books) {
			System.out.println("Title :" +book.title+ " Author :" +book.author);
			
		}
	}
}
