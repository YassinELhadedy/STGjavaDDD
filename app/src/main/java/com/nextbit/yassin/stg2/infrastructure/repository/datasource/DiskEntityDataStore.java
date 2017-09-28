package com.nextbit.yassin.stg2.infrastructure.repository.datasource;

import com.nextbit.yassin.stg2.infrastructure.cache.implement.EntityCache;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by yassin on 9/11/17.
 */

public class DiskEntityDataStore<T>implements IDataStoreRepository<T> {

    private final EntityCache entityCashe;
    public DiskEntityDataStore(EntityCache entityCashe) {
        this.entityCashe=entityCashe;

    }

    @Override
    public Observable<List<T>> getAll() {
        return entityCashe.getAll();
    }

    @Override
    public Observable<T> get(int userId) {

        return entityCashe.get(userId);
    }


}
