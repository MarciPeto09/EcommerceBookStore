package org.example;

import org.example.author.AuthorEntity;

import java.util.List;

public interface InterfaceRepository<T> {
    public void add(T object );
    public void remove(int id );
    public T findById(int id);
    public List<T> findAll();
    public void update(int id, T object);
}
