package org.saltypig.phishin.service;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.framed.Header;

import org.saltypig.phishin.Result;
import org.saltypig.phishin.model.Song;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public abstract class AbstractService<T> {

    private static final String TAG = AbstractService.class.getName();
    private static final String PHISH = "http://phish.in/api/v1";
    private static final Gson GSON = new Gson();

    private final OkHttpClient client = new OkHttpClient();

    protected abstract Type getType();

    protected void requestData(String endpoint, final org.saltypig.phishin.Callback<List<T>> callback) {
        StringBuffer url = new StringBuffer(PHISH);
        url.append(endpoint);

        final Request request = new Request.Builder()
                .url(url.toString())
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Response response) throws IOException {
                Log.d(TAG, "enqueue - onResponse");
                Result<T> result = GSON.fromJson(response.body().charStream(), getType());
                callback.onSuccess(result.getData());
            }

            @Override
            public void onFailure(Request request, IOException e) {
                Log.e(TAG, e.getMessage(), e.getCause());
            }
        });

    }

}
