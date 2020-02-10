package com.jenkov.javafxapp.bus;

import java.util.ArrayList;
import java.util.List;

public class EventChannel {

    protected List<EventSubscriber> subscribers = new ArrayList<>();

    public void publish(Object event){
        for(int i=0, n=this.subscribers.size(); i<n; i++){
            this.subscribers.get(i).notify(event);
        }
    }

    public EventPublisher registerPublisher() {
        return new EventPublisher(this.subscribers);
    }

    public EventSubscriber registerSubscriber() {
        EventSubscriber subscriber = new EventSubscriber(this.subscribers);
        this.subscribers.add(subscriber);
        return subscriber;
    }
}
