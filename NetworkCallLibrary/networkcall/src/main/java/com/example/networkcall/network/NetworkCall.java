package com.example.networkcall.network;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.networkcall.RXJavaHelper;
import com.example.networkcall.utils.Constants;

import io.reactivex.Single;
import io.reactivex.observers.DisposableSingleObserver;

import static com.example.networkcall.utils.Constants.API_ERROR;

public class NetworkCall<T> implements Constants {
    private static final String TAG = NetworkCall.class.getSimpleName();
    Single<T> single;

    public MutableLiveData<Resource<T>> apiCall(Single<T> single, DataSourceCallback callback) {
        return apiCall(single, callback, new MutableLiveData());
    }

    public MutableLiveData<Resource<T>> apiCall(Single<T> single, final DataSourceCallback callback, final MutableLiveData<Resource<T>> result) {
        this.single = single;
        result.postValue((Resource<T>) Resource.loading(null));
        //fetch api
        RXJavaHelper.getInstance().dispose(single, new DisposableSingleObserver<T>() {
            @Override
            public void onSuccess(T value) {
                if (value != null) {
                    if (callback != null) {
                        callback.onAPIFetched(value);
                        result.postValue(Resource.success(value));
                        Log.d("RespInNetworkCall",value.toString());
                    }
                } else {
                    result.postValue(Resource.<T>error(API_ERROR));
                }
            }

            @Override
            public void onError(Throwable e) {
                result.postValue(Resource.<T>error(e.getLocalizedMessage()));
            }
        });
        return result;
    }
}
