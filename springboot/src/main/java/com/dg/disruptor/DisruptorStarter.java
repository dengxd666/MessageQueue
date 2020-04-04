package com.dg.disruptor;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public final class DisruptorStarter {
    public  static Disruptor start(){
        Executor ex = Executors.newCachedThreadPool();
        EventFactory factory  = new UserEventFactory();
        int buffszie =  8; //2的幂 数组index算是 序号&(size-1)

        /*Disruptor<UserEvent> disruptor =
                new Disruptor(factory,buffszie,ex);*/

        ThreadFactory threadFactory1 = DaemonThreadFactory.INSTANCE;
        UserEventThreadFactory threadFactory = new UserEventThreadFactory();
        Disruptor<UserEvent> disruptor =
                new Disruptor(factory,buffszie,threadFactory);
        UserEventHandler handler =  new UserEventHandler();
        UserEventHandler2 handler2 =  new UserEventHandler2();
        disruptor.handleEventsWith(handler,handler2);
        disruptor.start();
        System.out.println("disruptor is  start");
        return disruptor;
    }
}
