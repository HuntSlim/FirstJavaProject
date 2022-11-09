package guru.springframework.spring5webapp.controllers;
import guru.springframework.spring5webapp.domain.Book;

import java.util.List;

public interface BookService {
    public abstract Book createBook(Book book);
    public abstract void updateBook(Book book);
    public abstract Book geteBook(int id);
    public abstract List<Book> getBooks();

    Book getBook(int id);

    List<Book> getbooks();

    public abstract boolean deleteBook(int id);
    public abstract boolean isBookExist(int id);
}
