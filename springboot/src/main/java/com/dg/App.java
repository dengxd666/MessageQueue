package com.dg;

import com.dg.disruptor.*;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws  Exception
    {
        Disruptor<UserEvent> disruptor = DisruptorStarter.start();
        RingBuffer<UserEvent> ringBuffer = disruptor.getRingBuffer();

        //自己实现一个produce
      /*  DisruptorProducer producer =  new DisruptorProducer(ringBuffer);
        for(;;){
            producer.publish();
            Thread.sleep(1000);
        }*/

        //通过translator的方式
        UserEventProducerWithTranslator producer2 =
                new UserEventProducerWithTranslator(ringBuffer);
        for(;;){
            producer2.onData();
            Thread.sleep(1000);
        }
    }
}
