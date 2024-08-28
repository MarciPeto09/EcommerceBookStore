package org.example.author;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.lang.reflect.Executable;
import java.util.*;

public class AuthorRepository {

    private SessionFactory sessionFactory;

    public AuthorRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addAuthor(AuthorEntity author) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(author);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw e;
        }
    }

    public void removeAuthor(UUID id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            AuthorEntity author = session.createQuery("Select s From AuthorEntity s where id =:id", AuthorEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();
            session.delete(author);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw e;
        }
    }

    public AuthorEntity findById(UUID id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            AuthorEntity author = session.createQuery("Select s From AuthorEntity s where id = :id", AuthorEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();
            transaction.commit();
            return author;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw e;
        }
    }


    public List<AuthorEntity> findAll() {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            List<AuthorEntity> list = session.createQuery("Select s From AuthorEntity s", AuthorEntity.class)
                    .getResultList();
            transaction.commit();
            return list;
        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw e;

        }

    }

    public void updateAuthor(UUID id, AuthorEntity updatedAuthor) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            AuthorEntity existingAuthor = session.get(AuthorEntity.class, id);
            if (existingAuthor != null) {
                existingAuthor.setName(updatedAuthor.getName());
                existingAuthor.setSurname(updatedAuthor.getSurname());
                existingAuthor.setNationality(updatedAuthor.getNationality());
                existingAuthor.setBirthday(updatedAuthor.getBirthday());
                existingAuthor.setListOfBookXAuthor(updatedAuthor.getListOfBookXAuthor());
                session.update(existingAuthor);
                transaction.commit();
            } else {
                transaction.rollback();
                throw new RuntimeException("Author not found with id: " + id);
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw e;
        }
    }
}