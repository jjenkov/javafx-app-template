package com.jenkov.javafxapp.bus;

import java.util.HashMap;
import java.util.Map;

public class EventBus {

    protected Map<Object, EventChannel> channels = new HashMap<>();


    public <ET> EventChannel<ET> createEventChannel(Object key) {
        this.channels.put(key, new EventChannel());
        return this.channels.get(key);
    }

    public <ET> EventChannel<ET> createEventChannel(Object key, Class<ET> eventTypeClass) {
        return createEventChannel(key);
    }

    public <ET> EventChannel<ET> getEventChannel(Object key){
        return this.channels.get(key);
    }

    public <ET> EventChannel<ET> getEventChannel(Object key, Class<ET> eventClassType){
        return getEventChannel(key);
    }


    public <ET> EventChannel<ET> getOrCreateEventChannel(Object key) {
        EventChannel channel = this.channels.get(key);
        if(channel == null) {
            channel = new EventChannel();
            this.channels.put(key, channel);
        }
        return channel;
    }

    public <ET> EventChannel<ET> getOrCreateEventChannel(Object key, Class<ET> eventTypeClass) {
        return getOrCreateEventChannel(key);
    }


}
