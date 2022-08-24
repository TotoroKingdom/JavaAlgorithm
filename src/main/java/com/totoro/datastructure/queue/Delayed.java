package com.totoro.datastructure.queue;

import java.util.concurrent.TimeUnit;

/**
 * @author:totoro
 * @createDate:2022/8/24
 * @description:
 */
public interface Delayed extends Comparable<Delayed>{

    long getDelay(TimeUnit unit);
}
