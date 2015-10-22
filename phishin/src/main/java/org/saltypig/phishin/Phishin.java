package org.saltypig.phishin;

import org.saltypig.phishin.model.Song;
import org.saltypig.phishin.service.SongsService;

import java.util.List;

public final class Phishin {

    private Phishin() {
    }

    public static void songs(PhishinCallback<List<Song>> callback) {
        new SongsService().retrieveSongs(callback);
    }

    public static void songs(String id, PhishinCallback<Song> callback) {
        new SongsService().retrieveSongs(id, callback);
    }

}
