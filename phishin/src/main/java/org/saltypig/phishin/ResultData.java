package org.saltypig.phishin;

public class ResultData<T> extends Result {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
