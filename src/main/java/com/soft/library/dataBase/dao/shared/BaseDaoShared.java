package com.soft.library.dataBase.dao.shared;

import com.soft.library.dataBase.dao.BaseDao;
import com.soft.library.dataBase.model.StandardEntity;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Class for the Base entity dao methods.
 * All methods of this class can be used in a shared transaction with other methods.
 */
public class BaseDaoShared<E extends StandardEntity> implements BaseDao<E> {
    private Class<E> elementClass;
    private EntityManager entityManager;

    public BaseDaoShared(Class<E> elementClass, EntityManager entityManager) {
        this.elementClass = elementClass;
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveNewEntity(E element) {
        entityManager.persist(element);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E saveEntity(E element) {
        return entityManager.merge(element);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public E findById(int elementId) {
        E element = null;
        element = (E) entityManager.find(elementClass, elementId);
        return element;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<E> getAll() {
        List<E> elements;
        elements = entityManager.createQuery("SELECT c FROM " + elementClass.getName() + " c").getResultList();
        return elements;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(E element) {
            entityManager.remove(element);
    }
}
