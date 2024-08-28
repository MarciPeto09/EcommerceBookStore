package org.example.book;

import java.awt.print.Book;
import java.util.List;
import java.util.UUID;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(BookEntity book){
        bookRepository.addBook(book);
    }

    public void removeBook(UUID id){
        bookRepository.removeBook(id);
    }

    public BookEntity findById(UUID id){
        return bookRepository.findById(id);
    }

    public List<BookEntity> findAll(){
        return bookRepository.findAll();
    }

    public void upDate(UUID id, BookEntity book){
        bookRepository.updateBook(id, book);
    }
}
