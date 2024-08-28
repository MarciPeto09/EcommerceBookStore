package org.example.order;

import org.example.category.CategoryEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class OrderRepository {
    private SessionFactory sessionFactory;

    public OrderRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addOrder(OrderEntity order) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(order);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }


    public void removeOrder(UUID id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            OrderEntity order = session.createQuery("Select s From OrderEntity s where id = :id", OrderEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();
            session.delete(order);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    public OrderEntity findById(UUID id) {
        OrderEntity order = null;
        try (Session session = sessionFactory.openSession()) {
            order = session.createQuery("Select s From CategoryEntity s  where id = :id", OrderEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }


    public List<OrderEntity> findAll() {
        List<OrderEntity> list = null;
        try (Session session = sessionFactory.openSession()) {
            list = session.createQuery("Select s From CategoryEntity s", OrderEntity.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void upDate(UUID id, OrderEntity order) {
        Transaction transaction = null;
        OrderEntity existingOrder = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            existingOrder = session.createQuery("Select s From CategoryEntity s where id =:id", OrderEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();
            existingOrder.setAdress(order.getAdress());
            existingOrder.setData(order.getData());
            existingOrder.setUser(order.getUser());
            existingOrder.setBooks(order.getBooks());
            existingOrder.setStatus(order.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
