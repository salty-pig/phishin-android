package org.saltypig.phishin.service;

import com.google.gson.reflect.TypeToken;

import org.saltypig.phishin.PhishinCallback;
import org.saltypig.phishin.ResultCollection;
import org.saltypig.phishin.ResultData;
import org.saltypig.phishin.model.Song;

import java.lang.reflect.Type;
import java.util.List;

public class SongsService extends AbstractService<Song> {

    private static String endpoint = "/songs";

    @Override
    protected Type getDataType() {
        return new TypeToken<ResultData<Song>>() {}.getType();
    }

    @Override
    protected Type getCollectionDataType() {
        return new TypeToken<ResultCollection<Song>>() {}.getType();
    }

    public void retrieveSongs(PhishinCallback<List<Song>> callback) {
        StringBuffer url = new StringBuffer(PHISH);
        url.append(endpoint);

        requestCollectionData(url.toString(), callback);
    }

    public void retrieveSongs(String id, PhishinCallback<Song> callback) {
        StringBuffer url = new StringBuffer(PHISH);
        url.append(endpoint);
        url.append("/");
        url.append(id);

        requestData(url.toString(), callback);
    }

}
