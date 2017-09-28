package com.nextbit.yassin.stg2.domain.repository;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by yassin on 9/11/17.
 */

public interface IGenericRepositoryEntity<T> extends IGenericRepository<T>{

    Observable<List<T>> getAllOfEntity();
    Observable<T> getOfEntity(final int userId);


    void addOfEntity(T entity);
    void deleteOfEntity(T entity);
    void updateOfEntity(T entity);




}