package com.teamyar.teamyarTest.Repositorys.remote;

import com.teamyar.teamyarTest.Models.LoginPOJO;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface ApiInterface {
    @FormUrlEncoded
    @POST(APIConst.LOGIN)
    Call<LoginPOJO> login(
            @Query("lang_id") int langId
           ,@Query("m_id") int mID
           ,@Field("login") String userName
           ,@Field("password") String password);
}
