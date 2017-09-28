package com.nextbit.yassin.stg2.test;

import com.nextbit.yassin.stg2.domain.entity.Runner;
import com.nextbit.yassin.stg2.infrastructure.cache.implement.RunnerCache;
import com.nextbit.yassin.stg2.infrastructure.repository.RunnerRepository;
import com.nextbit.yassin.stg2.infrastructure.repository.datasource.EntityDataStoreFactory;

/**
 * Created by yassin on 9/18/17.
 */

public class TestMain {

    public static void main(String[] args){
        System.out.println("yassin");
        EntityDataStoreFactory dataStoreFactory=new EntityDataStoreFactory(null,new RunnerCache(null));
        RunnerRepository repository=new RunnerRepository(dataStoreFactory);
        repository.addOfEntity(new Runner());
    }
}
