package com.jenkov.javafxapp.plugins.plugin2;

import com.jenkov.javafxapp.bus.ComBus;
import com.jenkov.javafxapp.bus.EventPublisher;
import com.jenkov.javafxapp.bus.ServiceChannel;
import com.jenkov.javafxapp.plugins.IPlugin;
import com.jenkov.javafxapp.plugins.topmenu.AddMenuItemRequest;
import com.jenkov.javafxapp.plugins.topmenu.AddMenuItemResponse;

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

        ServiceChannel<String, String> service = comBus.getServiceBus().getOrCreateServiceChannel("service");

        String o = service.callService("Hey, what's up?", (String) null);

        System.out.println("Service replied: " + o);

        comBus.getEventBus().getOrCreateEventChannel("app/menu/menu1").registerSubscriber().onEvent((message) -> {
            System.out.println("Menu item selected: " + message);
        });

        ServiceChannel<AddMenuItemRequest, AddMenuItemResponse> menuService =
                comBus.getServiceBus().getOrCreateServiceChannel("app/topMenu");

        AddMenuItemRequest addMenuItemRequest = new AddMenuItemRequest();
        addMenuItemRequest.menu                   = "Plugin 2";
        addMenuItemRequest.menuItemText           = "Click on Menu Item for Plugin 2";
        addMenuItemRequest.menuItemEventChannelId = "plugin 2";

        AddMenuItemResponse response = menuService.callService(addMenuItemRequest, new AddMenuItemResponse());

        comBus.getEventBus().getOrCreateEventChannel("plugin 2").registerSubscriber().onEvent((event) -> {
            System.out.println("Plugin 2 menu item chosen: " + event);
        });


    }


}
