package com.nextbit.yassin.stg2.domain.executor;

import io.reactivex.Scheduler;

/**
 * Created by yassin on 9/17/17.
 */

public interface PostExecutionThread {
    Scheduler getScheduler();
}
