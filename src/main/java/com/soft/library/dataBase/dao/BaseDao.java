package com.soft.library.dataBase.dao;

import com.soft.library.dataBase.model.StandardEntity;

import java.util.List;


public interface BaseDao  <E extends StandardEntity> {
    E findById(int id);

    /**
     * Save a transient entity.
     * The entity and it's cascade dependencies must be transient, not detached.
     * @param entity new entity to save
     * @throws PersistentObjectException if entity or one of it's cascade dependencies are detached
     */
    void saveNewEntity(E entity);
    void remove(E entity);

    /**
     * Save a transient or detached entity. If the entity was detached, it will be updated.
     * For new entities saveNewEntity is more efficient.
     * @param entity new or existing entity to save.
     * @return persistent entity
     */
    E saveEntity(E entity);

    List<E> getAll();
}
