package org.example.user;

import org.example.order.OrderEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class UserRepository {
    private SessionFactory sessionFactory;

    public UserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addUser(UserEntity user) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }


    public void removeUser(UUID id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            UserEntity user = session.createQuery("Select s From OrderEntity s where id = :id", UserEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();
            session.delete(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    public UserEntity findById(UUID id) {
        UserEntity user = null;
        try (Session session = sessionFactory.openSession()) {
            user = session.createQuery("Select s From CategoryEntity s  where id = :id", UserEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }


    public List<UserEntity> findAll() {
        List<UserEntity> list = null;
        try (Session session = sessionFactory.openSession()) {
            list = session.createQuery("Select s From CategoryEntity s", UserEntity.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void upDate(UUID id, UserEntity user) {
        Transaction transaction = null;
        UserEntity existinguser = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            existinguser = session.createQuery("Select s From CategoryEntity s where id =:id", UserEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();
            existinguser.setDateOfRegistration(user.getDateOfRegistration());
            existinguser.setEmail(user.getEmail());
            existinguser.setName(user.getName());
            existinguser.setOrders(user.getOrders());
            existinguser.setPassword(user.getPassword());
            existinguser.setSurname(user.getSurname());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
