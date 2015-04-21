package com.soft.library.dataBase.dao.isolated;

import com.soft.library.dataBase.dao.BaseDao;
import com.soft.library.dataBase.dataBaseCore.JpaUtil;
import com.soft.library.dataBase.model.StandardEntity;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Abstract base class for all isolated entity dao classes.
 * This class provides general implementation of all BaseDao interface's methods.
 * All methods of this class are isolated, each of them runs in it's own transaction.
 * It's impossible to call a method of this class with a method of any other dao class in a single shared transaction.
 */
public abstract class BaseDaoIsolated<E extends StandardEntity> implements BaseDao<E> {
    private Class<E> elementClass;

    public BaseDaoIsolated(Class<E> elementClass) {
        this.elementClass = elementClass;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveNewEntity(E element) {
        EntityManager entityManager = JpaUtil.ENTITY_MANAGER_FACTORY.createEntityManager();
        entityManager.getTransaction().begin();

        try {
            entityManager.persist(element);
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }

        entityManager.getTransaction().commit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E saveEntity(E element) {
        EntityManager entityManager = JpaUtil.ENTITY_MANAGER_FACTORY.createEntityManager();
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

    /**
     * {@inheritDoc}
     */
    @Override
    public E findById(int elementId) {
        EntityManager entityManager = JpaUtil.ENTITY_MANAGER_FACTORY.createEntityManager();
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

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<E> getAll() {
        EntityManager entityManager = JpaUtil.ENTITY_MANAGER_FACTORY.createEntityManager();
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(E element) {
        EntityManager entityManager = JpaUtil.ENTITY_MANAGER_FACTORY.createEntityManager();
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
