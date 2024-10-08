package org.example.book;

import jakarta.persistence.NoResultException;
import org.example.InterfaceRepository;
import org.example.author.AuthorEntity;
import org.example.utilities.DbConnection;
import org.hibernate.*;
import org.hibernate.Transaction;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookRepository implements InterfaceRepository<BookEntity> {

    @Override
    public void add(BookEntity book){
        SessionFactory sessionFactory = DbConnection.getFactory();
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
    @Override
    public void remove(int id) {
        SessionFactory sessionFactory = DbConnection.getFactory();
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            BookEntity book = session.createQuery("Select s From BookEntity s where id =:id", BookEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();
            session.delete(book);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public BookEntity findById(int id){
        SessionFactory sessionFactory = DbConnection.getFactory();
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


    public BookEntity findByName(String title){
        SessionFactory sessionFactory = DbConnection.getFactory();
        BookEntity book = null;
        try(Session session = sessionFactory.openSession()){
            book = session.createQuery("SELECT s FROM BookEntity s WHERE LOWER(TRIM(s.title)) = :title", BookEntity.class)
                    .setParameter("title", title.trim().toLowerCase())
                    .getSingleResult();

        }catch (NoResultException e) {
            System.out.println("This book does not exist!");
        }catch(Exception e ){
            e.printStackTrace();
        }
        return book;
    }





    public List<BookEntity> bookXauthor(int authorId) {
        SessionFactory sessionFactory = DbConnection.getFactory();
        List<BookEntity> list = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            list = session.createQuery(
                            "SELECT b FROM BookEntity b JOIN b.listOfAuthorsXBook a WHERE a.id = :authorId",
                            BookEntity.class
                    )
                    .setParameter("authorId", authorId)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<BookEntity> findAll(){
        SessionFactory sessionFactory = DbConnection.getFactory();
        List<BookEntity> lista = null;
        try(Session session = sessionFactory.openSession()){
            lista = session.createQuery("Select s From BookEntity s",BookEntity.class).getResultList();

        }catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void update(int id,BookEntity book){
        SessionFactory sessionFactory = DbConnection.getFactory();
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
