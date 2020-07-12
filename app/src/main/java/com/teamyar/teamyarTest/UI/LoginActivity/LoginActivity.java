package com.teamyar.teamyarTest.UI.LoginActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.teamyar.teamyarTest.R;
import com.teamyar.teamyarTest.UI.WebViewActivity.WebViewActivity;




public class LoginActivity extends AppCompatActivity  {

    private final String OK_RESPONSE = "ok";
    private LoginViewModel loginViewModel;
    private EditText edtEmail;
    private EditText edtPass;
    private Button btnLogin;
    private ProgressBar prgLoading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bindViews();

        /** put email and password to http post request by auth repository
         * @see com.teamyar.teamyarTest.Repositorys.AuthRepository
         */
        btnLogin.setOnClickListener(v -> { if(isValidForm()){
            loading(true);
            loginViewModel.postLogin(edtEmail.getText().toString(),edtPass.getText().toString());
         }});

        //p
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

        /**
         * set cookie by HttpLoginInterceptor class
         * @see com.teamyar.teamyarTest.Repositorys.remote.HttpLoginInterceptor
         */
        loginViewModel.login.observe(this, loginPOJO -> {
               loading(false);

                if(loginPOJO != null){//checking http request result
                        String message = loginPOJO.getMessage();
                        if(message!= null){

                            if(message.equals(OK_RESPONSE)){
                                Toast.makeText(this,getString(R.string.login_successful),Toast.LENGTH_LONG).show();
                                startActivity(new Intent(this,WebViewActivity.class));
                                finish();
                            }else{
                                Toast.makeText(this,message,Toast.LENGTH_LONG).show();
                            }
                        }else{
                            showGlobalError();
                        }


                }else{ // failed http Request
                    showGlobalError();
                }
        });
    }

    private void showGlobalError() {
        Toast.makeText(this,getString(R.string.error),Toast.LENGTH_LONG).show();
    }

    private void bindViews() {
        btnLogin = findViewById(R.id.btnLogin);
        edtPass = findViewById(R.id.edtPass);
        edtEmail = findViewById(R.id.edtEmail);
        prgLoading = findViewById(R.id.prg);
    }

    private boolean isValidForm() {
        return true;
    }
    private void loading(boolean isLoading){
        edtEmail.setEnabled(!isLoading);
        edtPass.setEnabled(!isLoading);
        btnLogin.setEnabled(!isLoading);
        prgLoading.setVisibility(isLoading? View.VISIBLE : View.INVISIBLE);
    }
}

