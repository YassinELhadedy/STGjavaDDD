package com.nextbit.yassin.stg2.infrastructure.service;

import android.support.annotation.Nullable;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.OkHttpClient.Builder;

/**
 * Created by yassin on 9/13/17.
 */

public class ApiConnection implements Callable<String> {

    private static final String CONTENT_TYPE_LABEL = "Content-Type";
    private static final String CONTENT_TYPE_VALUE_JSON = "application/json; charset=utf-8";

    private URL url;
    private String response;

    private ApiConnection(String url) throws MalformedURLException {
        this.url = new URL(url);
    }

    static ApiConnection createGET(String url) throws MalformedURLException {
        return new ApiConnection(url);
    }


    @Nullable
    String requestSyncCall() {
        connectToApi();
        return response;
    }

    private void connectToApi() {
        OkHttpClient okHttpClient = this.createClient();
        final Request request = new Request.Builder()
                .url(this.url)
                .addHeader(CONTENT_TYPE_LABEL, CONTENT_TYPE_VALUE_JSON)
                .get()
                .build();

        try {
            this.response = okHttpClient.newCall(request).execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private OkHttpClient createClient() {
//        final OkHttpClient okHttpClient = new OkHttpClient();
////        okHttpClient.setReadTimeout(10000, TimeUnit.MILLISECONDS);
////        okHttpClient.setConnectTimeout(15000, TimeUnit.MILLISECONDS);

        Builder b = new Builder();
        b.readTimeout(10000, TimeUnit.MILLISECONDS);
        b.connectTimeout(15000, TimeUnit.MILLISECONDS);
// set other properties

        OkHttpClient client = b.build();
// now you can use client`

        return client;
    }

    @Override public String call() throws Exception {
        return requestSyncCall();
    }
}
