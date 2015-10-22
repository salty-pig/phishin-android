package org.saltypig.phishin.service;

import android.util.Log;

import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.saltypig.phishin.PhishinCallback;
import org.saltypig.phishin.ResultCollection;
import org.saltypig.phishin.ResultData;
import org.saltypig.phishin.exception.RequestException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public abstract class AbstractService<T> {

    private static final String TAG = AbstractService.class.getName();
    private static final Gson GSON = new Gson();
    protected static final String PHISH = "http://phish.in/api/v1";

    private final OkHttpClient client = new OkHttpClient();

    protected abstract Type getDataType();

    protected abstract Type getCollectionDataType();

    void requestCollectionData(final String url, final PhishinCallback<List<T>> callback) {

        final Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Response response) throws IOException {
                if (response.isSuccessful()) {
                    Log.d(TAG, "enqueue - onResponse");
                    ResultCollection<T> result = GSON.fromJson(response.body().charStream(),
                            getCollectionDataType());
                    callback.onSuccess(result.getData());
                } else {
                    Exception e = new Exception(response.message());
                    Log.e(TAG, e.toString(), e.getCause());
                    callback.onFailure(e);
                }
            }

            @Override
            public void onFailure(Request request, IOException e) {
                Log.e(TAG, e.getMessage(), e.getCause());
                callback.onFailure(e);
            }
        });

    }

    void requestData(final String url, final PhishinCallback<T> callback) {

        final Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Response response) throws IOException {
                if (response.isSuccessful()) {
                    Log.d(TAG, "enqueue - onResponse");
                    ResultData<T> result = GSON.fromJson(response.body().charStream(),
                            getDataType());
                    callback.onSuccess(result.getData());
                } else {
                    RequestException e = new RequestException(response);
                    Log.e(TAG, e.toString(), e.getCause());
                    callback.onFailure(e);
                }
            }

            @Override
            public void onFailure(Request request, IOException e) {
                Log.e(TAG, e.getMessage(), e.getCause());
                callback.onFailure(e);
            }
        });

    }

}
