package com.jenkov.javafxapp.bus;

import java.util.List;

public class EventPublisher<ET> {
    protected List<EventSubscriber<ET>> subscribers = null;

    public EventPublisher(List<EventSubscriber<ET>> subscribers) {
        this.subscribers = subscribers;
    }

    public void publish(ET event){
        for(int i=0, n=this.subscribers.size(); i<n; i++){
            this.subscribers.get(i).notify(event);
        }
    }

}
