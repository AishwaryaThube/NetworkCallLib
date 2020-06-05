package com.example.networkcall.network;

public interface DataSourceCallback<T> {
    void onAPIFetched(T data);
}
