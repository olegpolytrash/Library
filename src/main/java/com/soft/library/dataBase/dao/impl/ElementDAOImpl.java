package com.soft.library.dataBase.dao.impl;

import java.util.List;
import com.soft.library.dataBase.dao.BaseDao;
import com.soft.library.dataBase.model.Author;
import com.soft.library.dataBase.model.StandardDBEntity;

import javax.persistence.EntityManager;

public class ElementDAOImpl<E extends StandardDBEntity> implements BaseDao<E> {
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
    public void saveNewEntity(E element) {
        entityManager.persist(element);
    }

    @Override
    public E saveEntity(E element) {
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
