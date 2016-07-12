package org.saltypig.phishin.service;

import com.google.gson.reflect.TypeToken;

import org.saltypig.phishin.PhishinCallback;
import org.saltypig.phishin.ResultCollection;
import org.saltypig.phishin.ResultData;
import org.saltypig.phishin.model.Track;

import java.lang.reflect.Type;
import java.util.List;

public class TracksService extends AbstractService<Track> {

    @Override
    public String getEndpoint() {
        return "/tracks";
    }

    @Override
    protected Type getDataType() {
        return new TypeToken<ResultData<Track>>() {
        }.getType();
    }

    @Override
    protected Type getCollectionDataType() {
        return new TypeToken<ResultCollection<Track>>() {
        }.getType();
    }

    public void retrieveTracks(PhishinCallback<List<Track>> callback) {
        requestCollectionData(callback);
    }

    public void retrieveTrack(String id, PhishinCallback<Track> callback) {
        requestData(id, callback);
    }

}
