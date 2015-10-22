package org.saltypig.phishin;

import java.io.Serializable;

/**
 * A handler for consuming the data/result of an operation.
 *
 * @param <T> The data type of the operation
 */
public interface Callback<T> extends Serializable {

    /**
     * Called when operation completes with success.
     *
     * @param data The received data of the operation.
     */
    void onSuccess(T data);

    /**
     * Invoked when an operation has failed.
     *
     * @param e The exception to give more insights on why the operation has failed.
     */
    void onFailure(Exception e);
}
