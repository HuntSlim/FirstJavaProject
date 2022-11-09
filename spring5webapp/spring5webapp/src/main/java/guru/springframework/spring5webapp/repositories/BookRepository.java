package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;


public interface BookRepository extends CrudRepository<Book, Integer> {

    Optional<Book> findById();
}
