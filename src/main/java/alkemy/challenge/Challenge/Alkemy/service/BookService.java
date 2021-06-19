package alkemy.challenge.Challenge.Alkemy.service;

import alkemy.challenge.Challenge.Alkemy.model.Book;
import alkemy.challenge.Challenge.Alkemy.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }


    public Book save(Book book) {
        return bookRepository.save(book);
    }


    public double getPrice(long id) {

        Book book = bookRepository.findById(id).get();

        if (book.getEdition() < 3 && book.getEdition() > 5) {
            book.setPrice(book.getPrice() + book.getPrice() / 2);
        }

        return book.getPrice();
    }
}
