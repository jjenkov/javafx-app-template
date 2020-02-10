package com.jenkov.javafxapp.bus;

public class ComBus {

    protected EventBus   eventBus   = new EventBus();
    protected ServiceBus serviceBus = new ServiceBus();

    public EventBus getEventBus() {
        return this.eventBus;
    }

    public ServiceBus getServiceBus() {
        return serviceBus;
    }



}
