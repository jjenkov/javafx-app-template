package com.jenkov.javafxapp.plugins.topmenu;

import com.jenkov.javafxapp.bus.ComBus;
import com.jenkov.javafxapp.bus.EventSubscriber;
import com.jenkov.javafxapp.bus.ServiceChannel;
import com.jenkov.javafxapp.plugins.IPlugin;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class TopMenuPlugin implements IPlugin {

    protected ComBus comBus = null;

    protected MenuBar menuBar = null;

    protected Map<String, Menu> menus = new HashMap<>();

    @Override
    public void init(ComBus comBus) {
        this.comBus = comBus;
    }

    @Override
    public void configure() {
        this.menuBar = new MenuBar();

        ServiceChannel<AddMenuItemRequest, AddMenuItemResponse> topMenuServiceChannel =
                comBus.getServiceBus().getOrCreateServiceChannel("app/topMenu");

        topMenuServiceChannel.setService((AddMenuItemRequest addMenuItemRequest, AddMenuItemResponse response) -> {
            System.out.println("AddMenuItemRequest = " + addMenuItemRequest);

            Menu menu = this.menus.get(addMenuItemRequest.menu);
            if(menu == null) {
                menu = new Menu(addMenuItemRequest.menu);
                this.menus.put(addMenuItemRequest.menu, menu);
                this.menuBar.getMenus().add(menu);
            }

            MenuItem menuItem = new MenuItem(addMenuItemRequest.menuItemText);
            menuItem.setOnAction((event) -> {
                comBus.getEventBus().getOrCreateEventChannel(addMenuItemRequest.menuItemEventChannelId).publish("Selected");
            });

            menu.getItems().add(menuItem);

            return new AddMenuItemResponse();
        });

        comBus.getEventBus().getOrCreateEventChannel("app/view/created", VBox.class).registerSubscriber().onEvent((VBox rootView) -> {
            System.out.println("Root View Created !");

            Menu menu = new Menu("Menu 1");
            MenuItem menuItem1 = new MenuItem("Item 1");
            MenuItem menuItem2 = new MenuItem("Item 2");

            menuItem1.setOnAction((event) -> {
                comBus.getEventBus().getOrCreateEventChannel("app/menu/menu1").publish("Selected");
            });

            menu.getItems().add(menuItem1);
            menu.getItems().add(menuItem2);

            menuBar.getMenus().add(menu);

            rootView.getChildren().add(0, menuBar);

        });

        comBus.getEventBus().getOrCreateEventChannel("app/stage/shown", Stage.class).registerSubscriber().onEvent((Stage stage) -> {
            System.out.println("Stage shown !");
        });

    }
}
