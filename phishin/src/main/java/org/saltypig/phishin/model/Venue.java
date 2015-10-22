package org.saltypig.phishin.model;

import com.google.gson.annotations.SerializedName;

public class Venue {

    private long id;
    private String name;
    private String pastNames;
    private String latitude;
    private String longitude;
    @SerializedName("shows_count")
    private int showsCount;
    private String location;
    private String slug;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPastNames() {
        return pastNames;
    }

    public void setPastNames(String pastNames) {
        this.pastNames = pastNames;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public int getShowsCount() {
        return showsCount;
    }

    public void setShowsCount(int showsCount) {
        this.showsCount = showsCount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Venue venue = (Venue) o;

        return id == venue.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

}
