package com.jenkov.javafxapp.plugins;

import com.jenkov.javafxapp.bus.ComBus;

import java.util.ArrayList;
import java.util.List;

public class PluginManager {

    protected List<IPlugin> plugins = new ArrayList<>();

    public PluginManager addPlugin(IPlugin plugin) {
        this.plugins.add(plugin);
        return this;
    }

    public PluginManager initPlugins(ComBus comBus) {
        for(int i=0; i<plugins.size(); i++) {
            plugins.get(i).init(comBus);
        }
        return this;
    }

    public PluginManager configurePlugins() {
        for(int i=0; i<plugins.size(); i++) {
            plugins.get(i).configure();
        }
        return this;
    }



}
