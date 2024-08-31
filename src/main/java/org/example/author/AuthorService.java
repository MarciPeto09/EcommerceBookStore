package org.example.author;

import java.util.*;

public class AuthorService {
    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void addAuthor(AuthorEntity author) {
        authorRepository.add(author);
    }

    public void removeAuthor(int id) {
        authorRepository.remove(id);
    }

    public AuthorEntity findById(int id) {
        return authorRepository.findById(id);
    }

    public List<AuthorEntity> findAll() {
        return authorRepository.findAll();
    }

    public void upDatedAuthor(int id, AuthorEntity author) {
        authorRepository.update(id, author);
    }
}
