package com.nextbit.yassin.stg2.infrastructure.repository;

import com.nextbit.yassin.stg2.domain.entity.Runner;
import com.nextbit.yassin.stg2.domain.repository.IGenericRepositoryEntity;
import com.nextbit.yassin.stg2.infrastructure.repository.datasource.EntityDataStoreFactory;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by yassin on 9/11/17.
 */

public class RunnerRepository extends Repository<Runner> implements IGenericRepositoryEntity<Runner> {

    public RunnerRepository(EntityDataStoreFactory userDataStoreFactory) {
        super(userDataStoreFactory);
    }

    @Override
    public Observable<List<Runner>> getAllOfEntity() {
        return getAll();
    }

    @Override
    public Observable<Runner> getOfEntity(int userId) {

        return   get(userId);
    }

    @Override
    public void addOfEntity(Runner entity) {

        add(entity);

    }

    @Override
    public void deleteOfEntity(Runner entity) {
        delete(entity);

    }

    @Override
    public void updateOfEntity(Runner entity) {
        update(entity);

    }
}
