package org.example.book;

import java.awt.print.Book;
import java.util.List;
import java.util.UUID;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(BookEntity book) {
        bookRepository.add(book);
    }

    public void removeBook(int id) {
        bookRepository.remove(id);
    }

    public BookEntity findById(int id) {
        return bookRepository.findById(id);
    }

    public BookEntity findByName(String name) {
        return bookRepository.findByName(name);
    }

    public List<BookEntity> findAll() {
        return bookRepository.findAll();
    }


    public List<BookEntity> bookXauthor(int id) {
        return bookRepository.bookXauthor(id);
    }

    public void upDate(int id, BookEntity book) {
        bookRepository.update(id, book);
    }
}
