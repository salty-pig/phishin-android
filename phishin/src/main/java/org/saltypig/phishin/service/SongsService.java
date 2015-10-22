package org.saltypig.phishin.service;

import com.google.gson.reflect.TypeToken;

import org.saltypig.phishin.Callback;
import org.saltypig.phishin.Result;
import org.saltypig.phishin.model.Song;

import java.lang.reflect.Type;
import java.util.List;

public class SongsService extends AbstractService<Song> {

    @Override
    protected Type getType() {
        return new TypeToken<Result<Song>>() {}.getType();
    }

    public void retrieveSongs(Callback<List<Song>> callback) {
        requestData("/songs", callback);
    }

}
