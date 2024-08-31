package org.example.user;

import org.example.order.OrderEntity;
import org.example.utilities.DbConnection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class UserRepository {


    public void addUser(UserEntity user) {
        SessionFactory sessionFactory = DbConnection.getFactory();
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


    public void removeUser(int id) {
        SessionFactory sessionFactory = DbConnection.getFactory();
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            UserEntity user = session.createQuery("Select u From UserEntity u where u.id = :id", UserEntity.class)
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


    public UserEntity findByNameObject(String name) {
        SessionFactory sessionFactory = DbConnection.getFactory();
        UserEntity user = null;
        try (Session session = sessionFactory.openSession()) {
            List<UserEntity>  users = session.createQuery("Select u From UserEntity u  where u.name = :name", UserEntity.class)
                    .setParameter("name", name)
                    .getResultList();

            if (!users.isEmpty()) {
                user = users.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public Boolean findByName(String name) {
        SessionFactory sessionFactory = DbConnection.getFactory();
        Boolean exist = false;
        try (Session session = sessionFactory.openSession()) {
            List<UserEntity> user = session.createQuery("Select u From UserEntity u where u.name = :name", UserEntity.class)
                    .setParameter("name", name)
                    .getResultList();
            exist = !user.isEmpty();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exist;
    }



    public Boolean findByPassword(String password) {
        SessionFactory sessionFactory = DbConnection.getFactory();
        Boolean exist = false;
        try (Session session = sessionFactory.openSession()) {
            List<UserEntity> user = session.createQuery("Select u From UserEntity u where u.password =:password", UserEntity.class)
                    .setParameter("password", password)
                    .getResultList();
            exist = !user.isEmpty();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exist;
    }


    public List<UserEntity> findAll() {
        SessionFactory sessionFactory = DbConnection.getFactory();
        List<UserEntity> list = null;
        try (Session session = sessionFactory.openSession()) {
            list = session.createQuery("Select u From UserEntity u", UserEntity.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void upDate(int id, UserEntity user) {
        SessionFactory sessionFactory = DbConnection.getFactory();
        Transaction transaction = null;
        UserEntity existinguser = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            existinguser = session.createQuery("Select u From UserEntity u where u.id =:id", UserEntity.class)
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
