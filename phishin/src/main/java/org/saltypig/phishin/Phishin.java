package org.saltypig.phishin;

import org.saltypig.phishin.model.Show;
import org.saltypig.phishin.model.Song;
import org.saltypig.phishin.model.Track;
import org.saltypig.phishin.service.ShowsService;
import org.saltypig.phishin.service.SongsService;
import org.saltypig.phishin.service.TracksService;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class Phishin {

    private static Retrofit retrofit;

    static {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://phish.in/api/v1")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private Phishin() {
    }

    public static void songs(PhishinCallback<List<Song>> callback) {
        new SongsService().retrieveSongs(callback);
    }

    public static void songs(String id, PhishinCallback<Song> callback) {
        new SongsService().retrieveSongs(id, callback);
    }

    public static void shows(PhishinCallback<List<Show>> callback) {
        new ShowsService().retrieveShows(callback);
    }

    public static void shows(String id, PhishinCallback<Show> callback) {
        new ShowsService().retrieveShows(id, callback);
    }

    public static void tracks(Callback<Track> callback) {
        TracksService service = retrofit.create(TracksService.class);
        service.tracks().enqueue(callback);
    }

}
