package com.seriouscompany.testsystem.server.controller.entity;

public interface EntityDAO<T> {

    public void delete(T entity);
    public void create(T entity);

}
