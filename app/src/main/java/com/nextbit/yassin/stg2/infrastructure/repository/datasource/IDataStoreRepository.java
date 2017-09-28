package com.nextbit.yassin.stg2.infrastructure.repository.datasource;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by yassin on 9/11/17.
 */

public interface IDataStoreRepository<T> {
    public abstract Observable<List<T>> getAll();
    public abstract Observable<T> get(final int userId);



}
