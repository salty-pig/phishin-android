package org.saltypig.phishin.service;

import com.google.gson.reflect.TypeToken;

import org.saltypig.phishin.PhishinCallback;
import org.saltypig.phishin.ResultCollection;
import org.saltypig.phishin.ResultData;
import org.saltypig.phishin.model.Show;

import java.lang.reflect.Type;
import java.util.List;

public class ShowsService extends AbstractService<Show> {

    private static String endpoint = "/shows";

    @Override
    protected Type getDataType() {
        return new TypeToken<ResultData<Show>>() {}.getType();
    }

    @Override
    protected Type getCollectionDataType() {
        return new TypeToken<ResultCollection<Show>>() {}.getType();
    }

    public void retrieveShows(PhishinCallback<List<Show>> callback) {
        StringBuffer url = new StringBuffer(PHISH);
        url.append(endpoint);

        requestCollectionData(url.toString(), callback);
    }

    public void retrieveShows(String id, PhishinCallback<Show> callback) {
        StringBuffer url = new StringBuffer(PHISH);
        url.append(endpoint);
        url.append("/");
        url.append(id);

        requestData(url.toString(), callback);
    }

}
