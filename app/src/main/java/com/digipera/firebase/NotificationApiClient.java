package com.digipera.firebase;

import com.digipera.firebase.model.TransactionPostData;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public class NotificationApiClient {

    private static final String BASE_URL = "https://fcm.googleapis.com/fcm/";

    private static NotificationApiService service = null;


    public static NotificationApiService getAPIService() {
        if (service == null) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(logging);  // <-- this is the important line!

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())// remove for String response
                    .build();
            service = retrofit.create(NotificationApiService.class);
        }
        return service;
    }

    public interface NotificationApiService {

        @Headers({"Content-Type: application/json"})
        @POST("send")
        Call<FcmResponse> sendData(@Body TransactionPostData postData, @Header("Authorization") String token);


    }

}
