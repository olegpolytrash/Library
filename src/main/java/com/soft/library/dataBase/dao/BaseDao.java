package com.soft.library.dataBase.dao;

import java.util.List;


public interface BaseDao  <E>{
    E findById(int id);
    void save(E entity);
    void remove(E entity);
    E getUpdatedEntity(E entity);
    List<E> getAll();
}
