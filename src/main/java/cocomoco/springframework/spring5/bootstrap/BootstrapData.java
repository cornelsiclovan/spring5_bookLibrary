package cocomoco.springframework.spring5.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import cocomoco.springframework.spring5.model.Author;
import cocomoco.springframework.spring5.model.Book;
import cocomoco.springframework.spring5.model.Publisher;
import cocomoco.springframework.spring5.repositories.AuthorRepository;
import cocomoco.springframework.spring5.repositories.BookRepository;
import cocomoco.springframework.spring5.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner{

	private final AuthorRepository authorRepo;
	private final BookRepository bookRepo;
	private final PublisherRepository publisherRepo;

	public BootstrapData(AuthorRepository aR, BookRepository bR, PublisherRepository pR) {
		this.authorRepo = aR;
		this.bookRepo = bR;
		this.publisherRepo = pR;
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Author author1 = new Author("Eric", "Evans");
		Book book1 = new Book("Domain driven bla","123242");
	 	Publisher publisher1 = new Publisher("Vasilescu", "Cornel Grfsoreanu 9 sc.A");
		try
        { 
		 	author1.addBook(book1);
		 	book1.addAuthor(author1);
        } 
        catch(NullPointerException e) 
        { 
            System.out.print("Caught NullPointerException 1"); 
        } 
		      
		
		this.authorRepo.save(author1);
		this.bookRepo.save(book1);
		this.publisherRepo.save(publisher1);
		
		Author author2 = new Author("Rob", "Johnson");
		Book book2 = new Book("J2ee","2878234");
		
		
		
		try
        { 
			author2.addBook(book2);
			book2.addAuthor(author2); 
        } 
        catch(NullPointerException e) 
        { 
            System.out.print("Caught NullPointerException 2"); 
        } 
		
		this.authorRepo.save(author2);
		this.bookRepo.save(book2);

		System.out.println("\n");
		System.out.println("Number of books " + this.bookRepo.count());
	
		System.out.println("\n");
		System.out.println("Publisher" + this.publisherRepo.count());
	}
	
}
