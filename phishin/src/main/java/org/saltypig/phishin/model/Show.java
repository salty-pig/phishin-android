package org.saltypig.phishin.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Show {

    private long id;
    private String data;
    private long duration;
    private boolean incomplete;
    private boolean missing;
    private boolean sbd;
    private boolean remastered;
    @SerializedName("tour_id")
    private long tourId;
    @SerializedName("venue_id")
    private long venueId;
    @SerializedName("likes_count")
    private long likes;
    @SerializedName("taper_notes")
    private String taperNotes;
    private String location;
    private Venue venue;

    private List<String> tags;
    private List<Track> tracks;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public boolean isIncomplete() {
        return incomplete;
    }

    public void setIncomplete(boolean incomplete) {
        this.incomplete = incomplete;
    }

    public boolean isMissing() {
        return missing;
    }

    public void setMissing(boolean missing) {
        this.missing = missing;
    }

    public boolean isSbd() {
        return sbd;
    }

    public void setSbd(boolean sbd) {
        this.sbd = sbd;
    }

    public boolean isRemastered() {
        return remastered;
    }

    public void setRemastered(boolean remastered) {
        this.remastered = remastered;
    }

    public long getTourId() {
        return tourId;
    }

    public void setTourId(long tourId) {
        this.tourId = tourId;
    }

    public long getVenueId() {
        return venueId;
    }

    public void setVenueId(long venueId) {
        this.venueId = venueId;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public String getTaperNotes() {
        return taperNotes;
    }

    public void setTaperNotes(String taperNotes) {
        this.taperNotes = taperNotes;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
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

        Show show = (Show) o;

        return id == show.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

}
