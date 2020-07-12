package com.teamyar.teamyarTest.Repositorys.remote;

import android.webkit.CookieManager;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

public class HttpLoginInterceptor implements Interceptor {

    private final String SET_COOKIE = "Set-Cookie";

    @Override
    public Response intercept(Chain chain) throws IOException {

        Response originalResponse = chain.proceed(chain.request());
        if(!originalResponse.headers(SET_COOKIE).isEmpty()){
            for(String header : originalResponse.headers(SET_COOKIE)){
               CookieManager.getInstance().setCookie(APIConst.BASE_URL,header);
            }
        }

        return  originalResponse;
    }
}
