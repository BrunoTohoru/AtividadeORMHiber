package com.mycompany.atividadelp3.dao;

import java.util.List;

public interface Dao<PK, T> {

    public void create(T entity);

    public T retrieve(PK pk);

    public void update(T entity);

    public void delete(PK pk);

    public List<T> findAll();
}
