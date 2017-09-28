package com.nextbit.yassin.stg2.domain.repository;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by yassin on 9/11/17.
 */

public interface IGenericRepository<T> {

    Observable<List<T>> getAll();
    Observable<T> get(final int userId);


    void add(T entity);
    void delete(T entity);
    void update(T entity);
}
