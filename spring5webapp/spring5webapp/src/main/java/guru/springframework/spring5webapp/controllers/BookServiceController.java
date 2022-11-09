package guru.springframework.spring5webapp.controllers;
import guru.springframework.spring5webapp.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class BookServiceController {
    @Autowired
    private BookService bookService;
    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public ResponseEntity<Object> createBook(@RequestBody Book book){
        book = bookService.createBook(book);
        return new ResponseEntity<>("Book is created Successfully with id"+book.getId(), HttpStatus.CREATED);
    }
    @RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
        public ResponseEntity<Object> updateBook(@PathVariable("id") int id,
        @RequestBody Book book){
        boolean isBookExist = bookService.isBookExist(id);
        if(isBookExist){
            book.setId((long) id);
            bookService.updateBook(book);
            return new ResponseEntity<>("Book is added Successfully", HttpStatus.OK);
        }
        else{
            throw new BookNotFoundExeption();
        }
    }
    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getBook(@PathVariable("id") int id)
    {
        boolean isBookExist = bookService.isBookExist(id);
        if (isBookExist){
            Book book =bookService.geteBook(id);
            return new ResponseEntity<>(book, HttpStatus.OK);
        }
        else{
            throw new BookNotFoundExeption();
        }
    }
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ResponseEntity<Object> getBooks()
    {
        List<Book> bookList = bookService.getBooks();
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ResponseEntity<Object> deleteBook(@PathVariable("id") int id)
    {
        boolean isBookExist = bookService.isBookExist(id);
        if(isBookExist){
            bookService.deleteBook(id);
            return new ResponseEntity<>("Book is deleted Successfully", HttpStatus.OK);
        }
        else{
            throw new BookNotFoundExeption();
        }
   }
}
