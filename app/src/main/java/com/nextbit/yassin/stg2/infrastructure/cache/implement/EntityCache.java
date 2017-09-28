package com.nextbit.yassin.stg2.infrastructure.cache.implement;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by yassin on 9/11/17.
 */

public interface EntityCache<T> {

    Observable<T> get(final int Id);

    Observable<List<T>> getAll();



    void put(T Entity);


    boolean isCached(final int Id);

    /**
     * Checks if the cache is expired.
     *
     * @return true, the cache is expired, otherwise false.
     */
    boolean isExpired();

    /**
     * Evict all elements of the cache.
     */
    void evictAll();

    void delete(T entity);
    void update(T entity);
}
