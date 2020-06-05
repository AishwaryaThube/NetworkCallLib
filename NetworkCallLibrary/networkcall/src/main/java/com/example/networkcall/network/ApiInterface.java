package com.example.networkcall.network;

import com.google.gson.JsonElement;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Url;

public interface ApiInterface {
    @GET
    Single<JsonElement> getData(@Url String url, @HeaderMap Map<String, String> headers);

    @POST
    Single<JsonElement> postData(@Url String url, @HeaderMap Map<String, String> headers, @Body HashMap<String, String> body);

    @DELETE
    Single<JsonElement> deleteData(@Url String url, @HeaderMap Map<String, String> headers, @Body HashMap<String, String> body);

    @PUT
    Single<JsonElement> putData(@Url String url, @HeaderMap Map<String, String> headers, @Body HashMap<String, String> body);

    @PATCH
    Single<JsonElement> patchData(@Url String url, @HeaderMap Map<String, String> headers, @Body HashMap<String, String> body);
}
