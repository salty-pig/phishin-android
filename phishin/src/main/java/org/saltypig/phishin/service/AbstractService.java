package org.saltypig.phishin.service;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.saltypig.phishin.PhishinCallback;
import org.saltypig.phishin.ResultCollection;
import org.saltypig.phishin.ResultData;
import org.saltypig.phishin.exception.RequestException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public abstract class AbstractService<T> {

    private static final String TAG = AbstractService.class.getName();
    private static final Gson GSON;
    protected static final String PHISH = "http://phish.in/api/v1";

    private final OkHttpClient client = new OkHttpClient();

    static {
        GsonBuilder gsonBuilder = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd");
        GSON = gsonBuilder.create();
    }

    protected abstract String getEndpoint();

    protected abstract Type getDataType();

    protected abstract Type getCollectionDataType();

    void requestCollectionData(final PhishinCallback<List<T>> callback) {

        final Request request = new Request.Builder()
                .url(PHISH + getEndpoint())
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
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
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, e.getMessage(), e.getCause());
                callback.onFailure(e);
            }
        });

    }

    void requestData(final String id, final PhishinCallback<T> callback) {

        final Request request = new Request.Builder()
                .url(PHISH + getEndpoint() + "/" + id)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
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
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, e.getMessage(), e.getCause());
                callback.onFailure(e);
            }
        });

    }

}
