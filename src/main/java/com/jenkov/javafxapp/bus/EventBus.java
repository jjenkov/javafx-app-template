package com.jenkov.javafxapp.bus;

import java.util.HashMap;
import java.util.Map;

public class EventBus {

    protected Map<Object, EventChannel> channels = new HashMap<>();


    public EventChannel createEventChannel(Object key) {
        this.channels.put(key, new EventChannel());
        return this.channels.get(key);
    }

    public EventChannel getEventChannel(Object key){
        return this.channels.get(key);
    }

    public EventChannel getOrCreateEventChannel(Object key) {
        EventChannel channel = this.channels.get(key);
        if(channel == null) {
            channel = new EventChannel();
            this.channels.put(key, channel);
        }
        return channel;
    }


}
