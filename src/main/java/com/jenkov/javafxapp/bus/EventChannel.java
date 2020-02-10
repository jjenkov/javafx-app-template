package com.jenkov.javafxapp.bus;

import java.util.ArrayList;
import java.util.List;

public class EventChannel {

    protected List<EventSubscriber> subscribers = new ArrayList<>();

    public EventPublisher registerPublisher() {
        return new EventPublisher(this.subscribers);
    }

    public EventSubscriber registerSubscriber() {
        EventSubscriber subscriber = new EventSubscriber(this.subscribers);
        this.subscribers.add(subscriber);
        return subscriber;
    }
}
