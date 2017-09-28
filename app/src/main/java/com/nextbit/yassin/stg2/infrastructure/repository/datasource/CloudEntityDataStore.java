package com.nextbit.yassin.stg2.infrastructure.repository.datasource;

import com.nextbit.yassin.stg2.domain.service.RestApi;
import com.nextbit.yassin.stg2.infrastructure.cache.implement.EntityCache;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by yassin on 9/11/17.
 */

public class CloudEntityDataStore<T>implements IDataStoreRepository<T> {
    private final RestApi restApi;
    private final EntityCache entityCache;

    public CloudEntityDataStore(RestApi restApi, EntityCache entityCache) {
        this.restApi = restApi;
        this.entityCache = entityCache;
    }

    @Override
    public Observable<List<T>> getAll() {

        return this.restApi.getAnswers();


    }

    @Override
    public Observable<T> get(int userId) {

        return this.restApi.getAnswers(userId).doOnNext(entityCache::put);


    }


//    public void loadAnswers() {
//        mService.getAnswers().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<SOAnswersResponse>() {
//                    @Override
//                    public void onCompleted() {
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                    }
//
//                    @Override
//                    public void onNext(SOAnswersResponse soAnswersResponse) {
//                        mAdapter.updateAnswers(soAnswersResponse.getItems());
//                    }
//                });
//    }


}
