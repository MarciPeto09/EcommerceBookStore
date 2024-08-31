package org.example.order;

import org.example.InterfaceRepository;
import org.example.user.UserEntity;
import org.example.utilities.DbConnection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository implements InterfaceRepository<OrderEntity> {


    @Override
    public void add(OrderEntity order) {
        SessionFactory sessionFactory = DbConnection.getFactory();
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

    @Override
    public void remove(int id) {
        SessionFactory sessionFactory = DbConnection.getFactory();
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            OrderEntity order = session.createQuery("Select s From OrderEntity s where id = :id", OrderEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();
            session.remove(order);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public OrderEntity findById(int id) {
        SessionFactory sessionFactory = DbConnection.getFactory();
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

    @Override
    public List<OrderEntity> findAll() {
        SessionFactory sessionFactory = DbConnection.getFactory();
        List<OrderEntity> list = null;
        try (Session session = sessionFactory.openSession()) {
            list = session.createQuery("Select s From OrderEntity s", OrderEntity.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<OrderEntity> orderOfUser(UserEntity user) {
        SessionFactory sessionFactory = DbConnection.getFactory();
        List<OrderEntity> list = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            list = session.createQuery("select o from OrderEntity o where o.user.id = :userId", OrderEntity.class)
                    .setParameter("userId", user.getId())
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void update(int id, OrderEntity order) {
        SessionFactory sessionFactory = DbConnection.getFactory();
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
