package com.teamyar.teamyarTest.Repositorys.remote;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private static final  Retrofit retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(APIConst.BASE_URL)
                    .client(getOkHttp())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


    public static ApiInterface getInterface(){
        return  retrofit.create(ApiInterface.class);
    }


    private static OkHttpClient getOkHttp() {
        HttpLoginInterceptor loginInterceptor = new HttpLoginInterceptor();
        return new OkHttpClient()
                .newBuilder()
                .addInterceptor(loginInterceptor)
                .build();
    }

}
