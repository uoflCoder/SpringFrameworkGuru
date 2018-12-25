package guru.springframework.Spring5WebApp.repositories;

import guru.springframework.Spring5WebApp.models.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Long>
{
}
