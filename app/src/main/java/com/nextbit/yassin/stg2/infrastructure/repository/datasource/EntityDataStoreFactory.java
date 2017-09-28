package com.nextbit.yassin.stg2.infrastructure.repository.datasource;

import android.content.Context;

import com.google.gson.Gson;
import com.nextbit.yassin.stg2.domain.service.RestApi;
import com.nextbit.yassin.stg2.infrastructure.cache.implement.EntityCache;
import com.nextbit.yassin.stg2.infrastructure.mapper.SheetJsonMapper;
import com.nextbit.yassin.stg2.infrastructure.service.RestApiImpl;

/**
 * Created by yassin on 9/11/17.
 */

public class EntityDataStoreFactory {
    private final Context context;
    public final EntityCache entityCache;//must be declare this of interfacetype and creation of one of implemented

    public EntityDataStoreFactory(Context context, EntityCache entityCashe) {
        this.context = context.getApplicationContext();
        this.entityCache = entityCashe;
    }

    public IDataStoreRepository create(int userId) {

        //entityCashe.get(11);
       // return new DiskEntityDataStore(this.entityCashe);
//        return new CloudEntityDataStore();



        if (!this.entityCache.isExpired() && this.entityCache.isCached(userId)) {

IDataStoreRepository iDataStoreRepository= new DiskEntityDataStore(this.entityCache);
            return iDataStoreRepository;
        } else {

            createCloudDataStore();


        }
        return null;



    }

    public IDataStoreRepository createCloudDataStore(){

        Gson gson=new Gson();

        SheetJsonMapper sheetJsonMapper=new SheetJsonMapper(gson);

        final RestApi restApi = new RestApiImpl(this.context, sheetJsonMapper);
        return new CloudEntityDataStore(restApi,entityCache);


    }


}
