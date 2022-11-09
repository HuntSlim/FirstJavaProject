package guru.springframework.spring5webapp.controllers;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class BookServiceImpl implements BookService
{
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    @Override
    public void updateBook(Book book){
        bookRepository.save(book);
    }

    @Override
    public Book getBook(int id){
        Optional<Book> optional = bookRepository.findById();
        Book book = optional.get();
        return book;
    }

    @Override
    public List<Book> getbooks(){
        return (List<Book>)bookRepository.findAll();
    }

    @Override
    public boolean deleteBook(int id){
        return bookRepository.existsById(Math.toIntExact(Long.valueOf(id)));
    }
}
