package cocomoco.springframework.spring5.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String isbn;

    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name="book_id"), inverseJoinColumns = @JoinColumn(name="author_id"))
    
    private Set<Author> authors;

    public Book() {}

    public Book(String title, String isbn) {
        this.title = title;
        this.isbn  = isbn;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<Author> getAuthors() {
        return this.authors;
    }

    public void setAuthrs(Set<Author> authors) {
        this.authors = authors;
    }
    
    public void addAuthor(Author author) {
    	if(this.authors == null) {
    		this.authors = new HashSet<Author>();
    		this.authors.add(author);
    	} else {
    		this.authors.add(author);
    	}
    }

    @Override
    public String toString(){
        return this.title;
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null || getClass() != o.getClass()) return false;
        
        Book book = (Book) o;

        return id != null ? id.equals(book.id) : book.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}