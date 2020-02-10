package com.jenkov.javafxapp.bus;

import java.util.HashMap;
import java.util.Map;

public class ServiceBus {

    protected Map<Object, ServiceChannel> channels = new HashMap<>();


    public ServiceChannel createServiceChannel(Object key) {
        ServiceChannel serviceChannel = new ServiceChannel();
        this.channels.put(key, serviceChannel);
        return serviceChannel;
    }

    public ServiceChannel getServiceChannel(Object key){
        return this.channels.get(key);
    }

    public ServiceChannel getOrCreateServiceChannel(Object key) {
        ServiceChannel serviceChannel = this.channels.get(key);
        if(serviceChannel == null) {
            serviceChannel = new ServiceChannel();
            this.channels.put(key, serviceChannel);
        }
        return serviceChannel;
    }

}
