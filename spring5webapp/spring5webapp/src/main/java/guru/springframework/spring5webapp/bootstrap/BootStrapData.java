package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("MaleziLLP");
        publisher.setCity("Nairobi");
        publisher.setCountry("Kenya");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count:" + publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Book waswahili = new Book("Mkuu", "123123");
        eric.getBooks().add(waswahili);
        waswahili.getAuthors().add(eric);

        waswahili.setPublisher(publisher);
        publisher.getBooks().add(waswahili);

        authorRepository.save(eric);
        bookRepository.save(waswahili);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Jhonson");
        Book noEJB = new Book("J2EE Development Without EJB", "325267");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Number of Books:" + bookRepository.count());
        System.out.println("Number of Books:" + publisher.getBooks().size());

    }
}
