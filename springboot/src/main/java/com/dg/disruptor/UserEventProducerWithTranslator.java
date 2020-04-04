package com.dg.disruptor;

import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.RingBuffer;
import java.nio.ByteBuffer;

public class UserEventProducerWithTranslator {
    private final RingBuffer<UserEvent> ringBuffer;
    private static  int sum = 0 ;
    public UserEventProducerWithTranslator(RingBuffer<UserEvent> ringBuffer)
    {
        this.ringBuffer = ringBuffer;
    }

    private static final EventTranslator<UserEvent> TRANSLATOR =
            new EventTranslator<UserEvent>()
            {
                public void translateTo(UserEvent event, long sequence)
                {
                    event.setAge(++sum);
                    event.setName("张三_"+ ++sum);
                }
            };

    public void onData()
    {
        ringBuffer.publishEvent(TRANSLATOR);
    }
}
