package com.soft.library.dataBase.dao.shared;

import com.soft.library.dataBase.dao.BaseDao;
import com.soft.library.dataBase.model.StandardEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class BaseDaoShared<E extends StandardEntity> implements BaseDao<E> {
    private Class<E> elementClass;

    public BaseDaoShared(Class<E> elementClass, EntityManager entityManager) {
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
