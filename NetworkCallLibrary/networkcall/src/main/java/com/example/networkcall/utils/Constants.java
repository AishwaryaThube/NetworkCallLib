package com.example.networkcall.utils;

import java.util.HashMap;
import java.util.Map;

public interface Constants {
    String BASE_URL = "https://api.learn2crack.com/";

    String URL = "https://simplifiedcoding.net/demos/marvel/";

    //API fetch status
    String SUCCESS = "SUCCESS";
    String LOADING = "LOADING";
    String ERROR = "ERROR";

    //error message
    String API_ERROR = "An unexpected error has been occurred.";

    Map<String, String> headers = new HashMap<>();

}
