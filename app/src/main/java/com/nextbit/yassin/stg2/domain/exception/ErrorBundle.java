package com.nextbit.yassin.stg2.domain.exception;

/**
 * Created by yassin on 9/13/17.
 */

public interface ErrorBundle {
    Exception getException();

    String getErrorMessage();
}
