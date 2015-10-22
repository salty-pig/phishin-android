package org.saltypig.phishin.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Song {

    private long id;
    private String title;

    @SerializedName("alias_for")
    private String aliasFor;

    @SerializedName("tracks_count")
    private int tracksCount;

    private String slug;

    private List<Track> tracks;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAliasFor() {
        return aliasFor;
    }

    public void setAliasFor(String aliasFor) {
        this.aliasFor = aliasFor;
    }

    public int getTracksCount() {
        return tracksCount;
    }

    public void setTracksCount(int tracksCount) {
        this.tracksCount = tracksCount;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Song song = (Song) o;

        return id == song.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

}
