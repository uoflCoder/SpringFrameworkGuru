package guru.springframework.Spring5WebApp.repositories;

import guru.springframework.Spring5WebApp.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>
{

}
