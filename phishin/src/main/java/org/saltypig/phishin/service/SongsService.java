package org.saltypig.phishin.service;

import com.google.gson.reflect.TypeToken;

import org.saltypig.phishin.PhishinCallback;
import org.saltypig.phishin.ResultCollection;
import org.saltypig.phishin.ResultData;
import org.saltypig.phishin.model.Song;

import java.lang.reflect.Type;
import java.util.List;

public class SongsService extends AbstractService<Song> {

    @Override
    public String getEndpoint() {
        return "/songs";
    }

    @Override
    protected Type getDataType() {
        return new TypeToken<ResultData<Song>>() {
        }.getType();
    }

    @Override
    protected Type getCollectionDataType() {
        return new TypeToken<ResultCollection<Song>>() {
        }.getType();
    }

    public void retrieveSongs(PhishinCallback<List<Song>> callback) {
        requestCollectionData(callback);
    }

    public void retrieveSong(String id, PhishinCallback<Song> callback) {
        requestData(id, callback);
    }

}
