package cocomoco.springframework.spring5.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books; 

    public Author() {}

    public Author(String fName, String lName) {
        this.firstName = fName;
        this.lastName  = lName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setFirstName(String fName) {
        this.firstName = fName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lName) {
        this.lastName = lName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Set<Book> getBooks() {
        return this.books;
    }

    public void addBook(Book book) {
    	if(this.books == null) {
    		this.books = new HashSet<Book>();
    		this.books.add(book);
    	} else {
    		this.books.add(book);
    	}
    }
    
    public String toString() {
        return this.firstName;
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null || getClass() != o.getClass()) return false;
        
        Author author = (Author) o;

        return id != null ? id.equals(author.id) : author.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}