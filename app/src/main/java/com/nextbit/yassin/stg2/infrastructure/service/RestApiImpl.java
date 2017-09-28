package com.nextbit.yassin.stg2.infrastructure.service;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.nextbit.yassin.stg2.domain.entity.Sheet;
import com.nextbit.yassin.stg2.domain.service.RestApi;
import com.nextbit.yassin.stg2.infrastructure.exception.NetworkConnectionException;
import com.nextbit.yassin.stg2.infrastructure.mapper.SheetJsonMapper;

import java.net.MalformedURLException;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Query;

/**
 * Created by yassin on 9/13/17.
 */

public class RestApiImpl implements RestApi<Sheet> {

    private final Context context;
    private final SheetJsonMapper sheetJsonMapper;

    public RestApiImpl(Context context, SheetJsonMapper sheetJsonMapper) {
        this.context = context;
        this.sheetJsonMapper = sheetJsonMapper;
    }


    @Override
    public Observable<List<Sheet>> getAnswers() {
        return Observable.create(emitter -> {
            if (isThereInternetConnection()) {
                try {
                    String responseUserEntities = getUserEntitiesFromApi();
                    if (responseUserEntities != null) {
                        emitter.onNext(sheetJsonMapper.transformSheetEntityCollection(
                                responseUserEntities));
                        emitter.onComplete();
                    } else {
                        emitter.onError(new NetworkConnectionException());
                    }
                } catch (Exception e) {
                    emitter.onError(new NetworkConnectionException(e.getCause()));
                }
            } else {
                emitter.onError(new NetworkConnectionException());
            }
        });
    }

    @Override
    public Observable<Sheet> getAnswers(@Query("tagged") int tags) {
        return null;
    }


    private String getUserEntitiesFromApi() throws MalformedURLException {
        return ApiConnection.createGET(API_URL_GET_USER_LIST).requestSyncCall();
    }

    private String getUserDetailsFromApi(int userId) throws MalformedURLException {
        String apiUrl = API_URL_GET_USER_DETAILS + userId + ".json";
        return ApiConnection.createGET(apiUrl).requestSyncCall();
    }

    /**
     * Checks if the device has any active internet connection.
     *
     * @return true device with internet connection, otherwise false.
     */
    private boolean isThereInternetConnection() {
        boolean isConnected;

        ConnectivityManager connectivityManager =
                (ConnectivityManager) this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        isConnected = (networkInfo != null && networkInfo.isConnectedOrConnecting());

        return isConnected;
    }
}
