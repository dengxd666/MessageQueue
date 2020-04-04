package com.dg.disruptor;

import com.lmax.disruptor.RingBuffer;

public class DisruptorProducer {
    private int sum = 0 ;
    private final RingBuffer<UserEvent> ringBuffer;
    public DisruptorProducer(RingBuffer<UserEvent> ringBuffer){
        this.ringBuffer = ringBuffer;
    }
    public void publish(){
        Long sequnce = ringBuffer.next();
        try{
            UserEvent ue = ringBuffer.get(sequnce);
            ue.setAge(++sum);
            ue.setName("张三_"+ ++sum);
        }finally {
            System.out.println(":生产者生产完数据，等待消费者消费----");
            ringBuffer.publish(sequnce);
        }
    }
}
