package com.nextbit.yassin.stg2.domain.service;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by yassin on 9/12/17.
 */

public interface RestApi<T> {
    String API_BASE_URL =
            "https://raw.githubusercontent.com/android10/Sample-Data/master/Android-CleanArchitecture/";

    /** Api url for getting all users */
    String API_URL_GET_USER_LIST = API_BASE_URL + "users.json";
    /** Api url for getting a user profile: Remember to concatenate id + 'json' */
    String API_URL_GET_USER_DETAILS = API_BASE_URL + "user_";


    @GET("/answers?order=desc&sort=activity&site=runnersheet")
    Observable<List<T>> getAnswers();

    @GET("/answers?order=desc&sort=activity&site=runnersheet")
    Observable<T> getAnswers(@Query("tagged") int tags);
}
