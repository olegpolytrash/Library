package com.soft.library.dataBase.dao.impl;

import java.util.List;
import com.soft.library.dataBase.dao.BaseDao;
import com.soft.library.dataBase.model.Author;

import javax.persistence.EntityManager;

public class ElementDAOImpl<E> implements BaseDao<E> {
    private Class<E> elementClass;

    public ElementDAOImpl(Class<E> elementClass, EntityManager entityManager) {
        this.elementClass = elementClass;
        this.entityManager = entityManager;
    }

    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(E element) {
        entityManager.persist(element);
    }

    @Override
    public E getUpdatedEntity(E element) {
        return entityManager.merge(element);
    }

    @SuppressWarnings("unchecked")
    @Override
    public E findById(int elementId) {
        E element = null;
        element = (E) entityManager.find(elementClass, elementId);
        return element;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<E> getAll() {
        List<E> elements;
        elements = entityManager.createQuery("SELECT c FROM " + elementClass.getName() + " c").getResultList();
        return elements;
    }

    @Override
    public void remove(E element) {
        entityManager.remove(element);
    }
}
