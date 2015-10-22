package org.saltypig.phishin;

import com.google.gson.annotations.SerializedName;

public abstract class Result {

    private boolean success;

    @SerializedName("total_entries")
    private int totalEntries;

    @SerializedName("total_pages")
    private int totalPages;

    private int page;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getTotalEntries() {
        return totalEntries;
    }

    public void setTotalEntries(int totalEntries) {
        this.totalEntries = totalEntries;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

}
