package com.revature.db;

public interface DAO<T, I> {

    int save(T t);

    T getByID(I id);

    //foo getAll();

    boolean remove(I id);

    boolean update(T t);


}
