package com.jenkov.javafxapp.plugins;

import com.jenkov.javafxapp.bus.ComBus;

public interface IPlugin {

    public void init(ComBus comBus) ;
    public void configure();


}
