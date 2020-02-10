package com.jenkov.javafxapp.plugins.plugin2;

import com.jenkov.javafxapp.bus.ComBus;
import com.jenkov.javafxapp.bus.EventPublisher;
import com.jenkov.javafxapp.bus.ServiceChannel;
import com.jenkov.javafxapp.plugins.IPlugin;

public class Plugin2 implements IPlugin {
    protected ComBus comBus = null;

    @Override
    public void init(ComBus comBus) {
        this.comBus = comBus;
        System.out.println("Plugin 2 initialized");
    }

    @Override
    public void configure() {
        System.out.println("Plugin 2 configured");

        EventPublisher publisher = comBus.getEventBus().getOrCreateEventChannel("config").registerPublisher();

        publisher.publish("Plugin 2 produced config event");

        comBus.getEventBus().getOrCreateEventChannel("config").publish("Plugin 2 produced a 2nd config event");

        ServiceChannel service = comBus.getServiceBus().getOrCreateServiceChannel("service");

        Object o = service.callService("Hey, what's up?");

        System.out.println("Service replied: " + o);


    }


}
