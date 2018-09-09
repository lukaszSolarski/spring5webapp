package lukaszSolarski.springframework.spring5webapp.repositories;

import lukaszSolarski.springframework.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
