package cocomoco.springframework.spring5.repositories;

import org.springframework.data.repository.CrudRepository;

import cocomoco.springframework.spring5.model.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
