package org.example.book;

import org.example.author.AuthorEntity;
import org.hibernate.*;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class BookRepository {

    private SessionFactory sessionFactory;

    public BookRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addBook(BookEntity book){
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void removeBook(UUID id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            AuthorEntity author = session.createQuery("Select s From AuthorEntity s where id =:id", AuthorEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();
            session.delete(author);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public BookEntity findById(UUID id){
        BookEntity book = null;
        try(Session session = sessionFactory.openSession()){
             book = session.createQuery("Select s From BookEntity s where id =:id", BookEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();

        }catch(Exception e ){
            e.printStackTrace();
        }
        return book;
    }

    public List<BookEntity> findAll(){
        List<BookEntity> lista = null;
        try(Session session = sessionFactory.openSession()){
            lista = session.createQuery("Select s From BookEntity s",BookEntity.class).getResultList();

        }catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    }


    public void updateBook(UUID id,BookEntity book){
        Transaction transaction = null;
        BookEntity existingBook = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            existingBook.setTitle(book.getTitle());
            existingBook.setPrice(book.getPrice());
            existingBook.setListOfAuthorsXBook(book.getListOfAuthorsXBook());
            existingBook.setOrder(book.getOrder());
            existingBook.setCategory(book.getCategory());
            session.update(existingBook);
            transaction.commit();
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
