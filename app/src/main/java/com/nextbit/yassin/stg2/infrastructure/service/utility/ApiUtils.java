package com.nextbit.yassin.stg2.infrastructure.service.utility;

import com.nextbit.yassin.stg2.domain.service.RestApi;
import com.nextbit.yassin.stg2.infrastructure.service.retrofitclient.RetrofitClient;

/**
 * Created by yassin on 9/12/17.
 */

public class ApiUtils {

    public static final String BASE_URL = "https://www.superglide.com/2.2/";

    public static RestApi getSOService() {
        return RetrofitClient.getClient(BASE_URL).create(RestApi.class);
    }
}
