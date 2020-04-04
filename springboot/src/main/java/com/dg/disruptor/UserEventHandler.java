package com.dg.disruptor;

import com.lmax.disruptor.EventHandler;

public class UserEventHandler implements EventHandler<UserEvent> {
    @Override
    public void onEvent(UserEvent userEvent, long l, boolean b) throws Exception {
        System.out.println( "---当前序号----:" + l);
        System.out.println(Thread.currentThread().getName()+"：消费者消费数据："  + userEvent);

    }
}
