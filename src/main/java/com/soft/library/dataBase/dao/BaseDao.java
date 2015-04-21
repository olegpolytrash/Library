package com.soft.library.dataBase.dao;

import com.soft.library.dataBase.model.StandardEntity;

import java.util.List;

/**
 * Base interface for all dao objects
 * @param <E> entity that is a subclass of the StandardEntity class
 */
public interface BaseDao <E extends StandardEntity> {
    /**
     * Find a row by it's id
     * @param id to search for
     * @return an object that represents the row found
     */
    E findById(int id);

    /**
     * Save a transient entity.
     * The entity and it's cascade dependencies must be transient, not detached.
     * @param entity new entity to save
     * @throws PersistentObjectException if entity or one of it's cascade dependencies are detached
     */
    void saveNewEntity(E entity);

    /**
     * Remove an entity
     * @param entity to remove
     */
    void remove(E entity);

    /**
     * Save a transient or detached entity. If the entity was detached, it will be updated.
     * For new entities saveNewEntity is more efficient.
     * @param entity new or existing entity to save.
     * @return persistent entity
     */
    E saveEntity(E entity);

    /**
     * Get all rows of the corresponding table.
     * @return objects that represent rows of the table
     */
    List<E> getAll();
}
