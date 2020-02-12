package com.jenkov.javafxapp.bus;

import java.util.List;
import java.util.function.Consumer;

public class EventSubscriber<ET> {
    protected List<EventSubscriber<ET>> subscribers = null;

    protected Consumer eventConsumer = null;

    public EventSubscriber(List<EventSubscriber<ET>> subscribers) {
        this.subscribers = subscribers;
    }

    /**
     * Called by EventPublisher. Do not call this method yourself
     * @param event
     */
    protected void notify(ET event){
        this.eventConsumer.accept(event);
    }

    public void onEvent(Consumer<ET> eventConsumer){
        this.eventConsumer = eventConsumer;
    }

    public void unregister(){
        this.subscribers.remove(this);
    }

}
