package com.jenkov.javafxapp.bus;

import java.util.List;
import java.util.function.Consumer;

public class EventSubscriber {
    protected List<EventSubscriber> subscribers = null;

    protected Consumer eventConsumer = null;

    public EventSubscriber(List<EventSubscriber> subscribers) {
        this.subscribers = subscribers;
    }

    /**
     * Called by EventPublisher. Do not call this method yourself
     * @param event
     */
    protected void notify(Object event){
        this.eventConsumer.accept(event);
    }

    public void onEvent(Consumer eventConsumer){
        this.eventConsumer = eventConsumer;
    }

    public void unregister(){
        this.subscribers.remove(this);
    }

}
