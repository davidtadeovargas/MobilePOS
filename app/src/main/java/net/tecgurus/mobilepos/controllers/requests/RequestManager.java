package net.tecgurus.mobilepos.controllers.requests;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RequestManager {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private static RequestManager requestManager;



    private RequestManager(){
    }

    final public static RequestManager getInstances(){
        if(requestManager==null){
            requestManager = new RequestManager();
        }
        return requestManager;
    }

    final public String get(final String url) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();

    }


    final public String post(final String url, final String json) throws Exception {



        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
