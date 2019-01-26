package net.tecgurus.mobilepos.controllers.activities;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import net.tecgurus.mobilepos.R;
import net.tecgurus.mobilepos.controllers.requests.ClientesRequest;
import net.tecgurus.mobilepos.controllers.requests.LoginRequest;
import net.tecgurus.mobilepos.models.entities.ClienteEntity;
import net.tecgurus.mobilepos.models.requests.ClientesRequestModel;
import net.tecgurus.mobilepos.models.requests.LoginRequestModel;

import java.util.List;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity {

    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private Button btnLogin;


    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);
        btnLogin = findViewById(R.id.email_sign_in_button);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                try{

                    final LoginRequestModel loginRequestModel = new LoginRequestModel();
                    loginRequestModel.setUsuario(mEmailView.getText().toString().trim());
                    loginRequestModel.setPassword(mPasswordView.getText().toString().trim());

                    final LoginRequest loginRequest = new LoginRequest();
                    loginRequest.setLoginRequestModel(loginRequestModel);
                    loginRequest.setOnResult(new LoginRequest.OnResult() {
                        @Override
                        public void onLoginSuccess() {

                        }

                        @Override
                        public void onInvalidLogin() {

                        }
                    });
                    loginRequest.execute();

                }catch (Exception e){

                }
            }
        });
    }
}
