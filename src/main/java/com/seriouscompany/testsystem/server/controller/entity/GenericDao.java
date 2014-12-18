package com.seriouscompany.testsystem.server.controller.entity;

import java.util.List;

public interface GenericDao<T> {

    public void delete(T entity);
    public T find(Integer id);
    public void save(T entity);
    public List<T> findAll();

}
