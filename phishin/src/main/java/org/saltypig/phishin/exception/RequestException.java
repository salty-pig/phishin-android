package org.saltypig.phishin.exception;

import com.squareup.okhttp.Response;

public class RequestException extends Exception {

    private final int code;
    private final String url;
    private final String message;

    public RequestException(Response response) {
        this(response.code(), response.request().urlString(), response.message());
    }

    public RequestException(int code, String url, String message) {
        super(message);

        this.code = code;
        this.url = url;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "RequestException { code=" + this.code +
                ", message=" + this.message + ", url=" + this.url + " }";
    }

}
