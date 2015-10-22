package org.saltypig.phishin;

import java.util.List;

public class ResultCollection<T> extends Result {

    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}
