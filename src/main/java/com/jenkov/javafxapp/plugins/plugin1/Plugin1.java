package com.jenkov.javafxapp.plugins.plugin1;

import com.jenkov.javafxapp.bus.ComBus;
import com.jenkov.javafxapp.bus.EventSubscriber;
import com.jenkov.javafxapp.bus.ServiceChannel;
import com.jenkov.javafxapp.plugins.IPlugin;

public class Plugin1 implements IPlugin {

    protected ComBus comBus = null;

    @Override
    public void init(ComBus comBus) {
        this.comBus = comBus;
        System.out.println("Plugin 1 initialized");
    }

    @Override
    public void configure() {
        System.out.println("Plugin 1 configured");

        EventSubscriber eventSubscriber = comBus.getEventBus().getOrCreateEventChannel("config").registerSubscriber();

        eventSubscriber.onEvent((event) -> {
            System.out.println("Event received: " + event);
        });


        ServiceChannel service = comBus.getServiceBus().getOrCreateServiceChannel("service");
        service.setService((text) -> {
            System.out.println("Service called with: " + text);
            return "Thanks!";
        });

    }

}
