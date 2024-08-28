package org.example.author;

import java.util.*;

public class AuthorService {
    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void addAuthor(AuthorEntity author) {
        authorRepository.addAuthor(author);
    }

    public void removeAuthor(UUID id) {
        authorRepository.removeAuthor(id);
    }

    public AuthorEntity findById(UUID id) {
        return authorRepository.findById(id);
    }

    public List<AuthorEntity> findAll() {
        return authorRepository.findAll();
    }

    public void upDatedAuthor(UUID id, AuthorEntity author){
        authorRepository.updateAuthor(id, author);
    }
}
