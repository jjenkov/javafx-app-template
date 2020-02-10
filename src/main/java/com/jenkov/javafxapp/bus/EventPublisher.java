package com.jenkov.javafxapp.bus;

import java.util.List;

public class EventPublisher {
    protected List<EventSubscriber> subscribers = null;

    public EventPublisher(List<EventSubscriber> subscribers) {
        this.subscribers = subscribers;
    }

    public void publish(Object event){
        for(int i=0, n=this.subscribers.size(); i<n; i++){
            this.subscribers.get(i).notify(event);
        }
    }

}
