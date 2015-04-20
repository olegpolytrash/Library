package com.soft.library.dataBase.dao.oneOp;

import com.soft.library.dataBase.dao.BaseDao;
import com.soft.library.dataBase.dataBaseCore.JPAUtil;
import com.soft.library.dataBase.model.StandardDBEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class ElementDAO<E extends StandardDBEntity> implements BaseDao<E> {
    private Class<E> elementClass;

    public ElementDAO(Class<E> elementClass) {
        this.elementClass = elementClass;
    }

    @Override
    public void saveNewEntity(E element) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        try {
            entityManager.persist(element);
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }

        entityManager.getTransaction().commit();
    }

    @Override
    public E saveEntity(E element) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        E el;

        try {
            el = entityManager.merge(element);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }

        return el;
    }

    @Override
    public E findById(int elementId) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        E element;

        try {
            element = entityManager.find(elementClass, elementId);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }

        return element;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<E> getAll() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        List<E> elements;

        try {
            elements = entityManager.createQuery("SELECT c FROM " + elementClass.getName() + " c").getResultList();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }

        return elements;
    }

    @Override
    public void remove(E element) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        try {
            E el = entityManager.merge(element);
            entityManager.remove(el);
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }

        entityManager.getTransaction().commit();
    }
}
