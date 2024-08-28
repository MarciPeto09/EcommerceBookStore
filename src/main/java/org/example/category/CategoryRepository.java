package org.example.category;

import org.example.book.BookEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class CategoryRepository {

    private SessionFactory sessionFactory;

    public CategoryRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addCategory(CategoryEntity category) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(category);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }


    public void removeCategory(UUID id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            CategoryEntity category = session.createQuery("Select s From CategoryEntity s where id = :id", CategoryEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();
            session.delete(category);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    public CategoryEntity findById(UUID id) {
        CategoryEntity category = null;
        try (Session session = sessionFactory.openSession()) {
            category = session.createQuery("Select s From CategoryEntity s  where id = :id", CategoryEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return category;
    }


    public List<CategoryEntity> findAll() {
        List<CategoryEntity> list = null;
        try (Session session = sessionFactory.openSession()) {
            list = session.createQuery("Select s From CategoryEntity s", CategoryEntity.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void upDate(UUID id, CategoryEntity category) {
        Transaction transaction = null;
        CategoryEntity existingCategory = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            existingCategory = session.createQuery("Select s From CategoryEntity s where id =:id", CategoryEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();
            existingCategory.setCategoryType(category.getCategoryType());
            existingCategory.setBooksForCategory(category.getBooksForCategory());
            session.update(existingCategory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
