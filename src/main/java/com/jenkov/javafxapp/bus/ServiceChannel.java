package com.jenkov.javafxapp.bus;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ServiceChannel<RQT, RST>{

    private BiFunction<RQT, RST, RST> service = null;

    public void setService(BiFunction<RQT, RST, RST> service) {
        this.service = service;
    }

    public RST callService(RQT request, RST response){
        return this.service.apply(request, response);
    }

    public ServiceServer registerServer() {
        return new ServiceServer();
    }

    public ServiceClient registerClient() {
        return new ServiceClient();
    }

}
