package com.dg.disruptor;

import java.util.concurrent.ThreadFactory;

public class UserEventThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return new Thread(r);

    }
}
