package cocomoco.springframework.spring5.repositories;
import org.springframework.data.repository.CrudRepository;

import cocomoco.springframework.spring5.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{
	
}