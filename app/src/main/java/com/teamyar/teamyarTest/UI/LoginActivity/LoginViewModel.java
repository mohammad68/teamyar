package com.teamyar.teamyarTest.UI.LoginActivity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.teamyar.teamyarTest.Models.LoginPOJO;
import com.teamyar.teamyarTest.Repositorys.AuthRepository;

public class LoginViewModel extends AndroidViewModel {
    private final AuthRepository authRepository;
    public LiveData<LoginPOJO> login;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        authRepository = AuthRepository.getInstance();
        login = authRepository.login;
    }

    public void postLogin(String userName, String password){
        authRepository.postLogin(userName,password);
    }
}
