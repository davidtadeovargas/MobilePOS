package net.tecgurus.mobilepos.controllers.requests;

import com.google.gson.Gson;

import net.tecgurus.mobilepos.models.entities.ClienteEntity;
import net.tecgurus.mobilepos.models.requests.LoginRequestModel;

import java.util.List;

public class LoginRequest extends Request {

    private OnResult onResult;
    private LoginRequestModel loginRequestModel;


    @Override
    protected void onResult(String result) {

        final Gson gson = new Gson();
        final LoginRequestModel loginRequestModel = gson.fromJson(result,LoginRequestModel.class);
        if(loginRequestModel.isResult()){
            if(onResult!=null){
                onResult.onLoginSuccess();
            }
        }
        else{
            if(onResult!=null){
                onResult.onInvalidLogin();
            }
        }
    }

    @Override
    public void execute() throws Exception {

        final Gson gson = new Gson();
        final String json = gson.toJson(this.loginRequestModel);
        final String result = this.requestManager.post("http://localhost:8080/login",json);
        this.onResult(result);
    }

    public void setLoginRequestModel(LoginRequestModel loginRequestModel) {
        this.loginRequestModel = loginRequestModel;
    }

    public void setOnResult(OnResult onResult) {
        this.onResult = onResult;
    }

    public interface OnResult{
        void onLoginSuccess();
        void onInvalidLogin();
    }
}
