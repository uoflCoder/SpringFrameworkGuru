package guru.springframework.Spring5WebApp.bootstrap;

import guru.springframework.Spring5WebApp.models.Author;
import guru.springframework.Spring5WebApp.models.Book;
import guru.springframework.Spring5WebApp.models.Publisher;
import guru.springframework.Spring5WebApp.repositories.AuthorRepository;
import guru.springframework.Spring5WebApp.repositories.BookRepository;
import guru.springframework.Spring5WebApp.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

//Component makes this a spring bean
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>
{
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;


    //This is getting autowired
    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository)
    {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        initData();
    }

    private void initData()
    {
        Author tylor = new Author("Tylor", "Cornett");
        Publisher publisher1 = new Publisher("1", "12815 beercross");
        Book book1 = new Book("Bohemian Rhapsody", "9999", publisher1);
        tylor.getBooks().add(book1);


        authorRepository.save(tylor);
        publisherRepository.save(publisher1);
        bookRepository.save(book1);

        Author ryan = new Author("Ryan", "Cornette");
        Publisher publisher2 = new Publisher("2", "1101 beermont");
        Book book2 = new Book("Scary Monsters and Nice Sprites", "1829192", publisher2);
        ryan.getBooks().add(book2);


        authorRepository.save(ryan);
        publisherRepository.save(publisher2);
        bookRepository.save(book2);

    }


}
