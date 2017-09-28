package com.nextbit.yassin.stg2.infrastructure.repository;

import com.nextbit.yassin.stg2.domain.entity.Shipment;
import com.nextbit.yassin.stg2.domain.repository.IGenericRepositoryEntity;
import com.nextbit.yassin.stg2.infrastructure.repository.datasource.EntityDataStoreFactory;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by yassin on 9/11/17.
 */

public class ShipmentRepository extends Repository<Shipment> implements IGenericRepositoryEntity<Shipment> {
    public ShipmentRepository(EntityDataStoreFactory userDataStoreFactory) {
        super(userDataStoreFactory);
    }

    @Override
    public Observable<List<Shipment>> getAllOfEntity() {
        return getAll();
    }

    @Override
    public Observable<Shipment> getOfEntity(int userId) {

        return   get(userId);
    }

    @Override
    public void addOfEntity(Shipment entity) {
        add(entity);

    }

    @Override
    public void deleteOfEntity(Shipment entity) {
        delete(entity);

    }

    @Override
    public void updateOfEntity(Shipment entity) {
        update(entity);

    }
}
