package lukaszSolarski.springframework.spring5webapp.bootstrap;

import lukaszSolarski.springframework.spring5webapp.model.Author;
import lukaszSolarski.springframework.spring5webapp.model.Book;
import lukaszSolarski.springframework.spring5webapp.model.Publisher;
import lukaszSolarski.springframework.spring5webapp.repositories.AuthorRepository;
import lukaszSolarski.springframework.spring5webapp.repositories.BookRepository;
import lukaszSolarski.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Author eric = new Author("Eric", "Evans");
        Publisher publisher = new Publisher("Harper Collins", "USA");
        Book ddd = new Book("Domain Driven Design", "1234", publisher);

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher);

        authorRepository.save(eric);
        publisherRepository.save(publisher);
        bookRepository.save(ddd);


        Author rod = new Author("Rod", "Johnson");
        publisher = new Publisher("Worx", "UK");
        Book noEJB = new Book("J2EE Development without EJB", "9876", publisher);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(publisher);

        authorRepository.save(rod);
        publisherRepository.save(publisher);
        bookRepository.save(noEJB);
    }
}
