package com.nextbit.yassin.stg2.infrastructure.repository;

import com.nextbit.yassin.stg2.domain.repository.IGenericRepository;
import com.nextbit.yassin.stg2.infrastructure.repository.datasource.EntityDataStoreFactory;
import com.nextbit.yassin.stg2.infrastructure.repository.datasource.IDataStoreRepository;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by yassin on 9/6/17.
 */

public class Repository<T>implements IGenericRepository<T> {

    private final  EntityDataStoreFactory entityDataStoreFactory;

    public Repository(EntityDataStoreFactory entityDataStoreFactory) {
        this.entityDataStoreFactory = entityDataStoreFactory;
    }

    @Override
    public Observable<List<T>> getAll() {
        final IDataStoreRepository<T> iDataStoreRepository = this.entityDataStoreFactory.createCloudDataStore();


        return iDataStoreRepository.getAll();
    }

    @Override
    public Observable<T> get(int userId) {
        final IDataStoreRepository<T> iDataStoreRepository = this.entityDataStoreFactory.create(userId);


        return iDataStoreRepository.get(userId);
    }

    @Override
    public void add(T entity) {



        entityDataStoreFactory.entityCache.put(entity);



    }

    @Override
    public void delete(T entity) {
        //code implementation
        entityDataStoreFactory.entityCache.delete(entity);


    }

    @Override
    public void update(T entity) {
        //code implementation
        entityDataStoreFactory.entityCache.update(entity);


    }
}
