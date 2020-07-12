package com.teamyar.teamyarTest.Repositorys;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.teamyar.teamyarTest.Repositorys.remote.APIConst;
import com.teamyar.teamyarTest.Repositorys.remote.ApiInterface;
import com.teamyar.teamyarTest.Models.LoginPOJO;
import com.teamyar.teamyarTest.Repositorys.remote.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthRepository {

    private static ApiInterface apiInterface = null;

    private final MutableLiveData<LoginPOJO> _login = new MutableLiveData<>();
    public LiveData<LoginPOJO> login = _login;

    private static AuthRepository authRepository;

    public static AuthRepository getInstance(){
        if(authRepository == null) authRepository = new AuthRepository();

        return  authRepository;
    }


    public AuthRepository(){
        apiInterface = RetrofitService.getInterface();
    }

    public void postLogin(String userName,String password){
       Call<LoginPOJO> loginCall =  apiInterface.login(
               APIConst.LONG_ID
               ,APIConst.M_ID
               ,userName
               ,password);

       loginCall.enqueue(new Callback<LoginPOJO>() {
           @Override
           public void onResponse(Call<LoginPOJO> call, Response<LoginPOJO> response) {
               _login.setValue(response.body());
           }

           @Override
           public void onFailure(Call<LoginPOJO> call, Throwable t) {
               _login.postValue(null);
           }
       });
    }







}
