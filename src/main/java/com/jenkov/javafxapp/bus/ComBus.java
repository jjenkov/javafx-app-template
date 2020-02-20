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


    public void publish(Object eventChannelId, Object event) {
        getEventBus().getOrCreateEventChannel(eventChannelId).publish(event);
    }

    public <RQT, RST> RST call(Object serviceChannelId, RQT request, RST response){
        ServiceChannel<RQT, RST> serviceChannel = getServiceBus().getOrCreateServiceChannel(serviceChannelId);
        return serviceChannel.callService(request, response);
    }


}
