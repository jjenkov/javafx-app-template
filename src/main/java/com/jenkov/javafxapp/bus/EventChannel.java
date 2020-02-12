package com.jenkov.javafxapp.bus;

import java.util.ArrayList;
import java.util.List;

public class EventChannel<ET> {

    protected List<EventSubscriber<ET>> subscribers = new ArrayList<>();

    public void publish(ET event){
        for(int i=0, n=this.subscribers.size(); i<n; i++){
            this.subscribers.get(i).notify(event);
        }
    }

    //todo will this be necessary in the future? Or will the publish() method be enough?
    public EventPublisher<ET> registerPublisher() {
        return new EventPublisher(this.subscribers);
    }

    public EventSubscriber<ET> registerSubscriber() {
        EventSubscriber subscriber = new EventSubscriber(this.subscribers);
        this.subscribers.add(subscriber);
        return subscriber;
    }
}
