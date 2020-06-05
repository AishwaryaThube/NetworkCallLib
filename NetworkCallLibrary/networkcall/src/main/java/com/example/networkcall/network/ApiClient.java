package com.example.networkcall.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.networkcall.utils.Constants.BASE_URL;

public class ApiClient {
   public static ApiInterface getClient() {
       HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
       logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
       OkHttpClient client = new OkHttpClient.Builder()
               .addInterceptor(logging)
               .build();
       return new Retrofit.Builder()
               .baseUrl(BASE_URL)
               .client(client)
               .addConverterFactory(GsonConverterFactory.create())
               .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
               .build()
               .create(ApiInterface.class);
    }
}


