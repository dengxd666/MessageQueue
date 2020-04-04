package com.dg.disruptor;

import com.lmax.disruptor.EventFactory;

public class UserEventFactory implements EventFactory<UserEvent> {
    @Override
    public UserEvent newInstance() {
        return new UserEvent();
    }
}
