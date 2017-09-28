package com.nextbit.yassin.stg2.infrastructure.repository;

import com.nextbit.yassin.stg2.domain.entity.Sheet;
import com.nextbit.yassin.stg2.domain.repository.IGenericRepositoryEntity;
import com.nextbit.yassin.stg2.infrastructure.repository.datasource.EntityDataStoreFactory;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by yassin on 9/11/17.
 */

public class SheetRepository extends Repository<Sheet> implements IGenericRepositoryEntity<Sheet> {
    public SheetRepository(EntityDataStoreFactory userDataStoreFactory) {
        super(userDataStoreFactory);
    }

    @Override
    public Observable<List<Sheet>> getAllOfEntity() {
        return getAll();
    }

    @Override
    public Observable<Sheet> getOfEntity(int userId)
    {
        return get(userId);
    }

    @Override
    public void addOfEntity(Sheet entity) {
        add(entity);

    }

    @Override
    public void deleteOfEntity(Sheet entity) {
        delete(entity);

    }

    @Override
    public void updateOfEntity(Sheet entity) {
        update(entity);

    }
}
