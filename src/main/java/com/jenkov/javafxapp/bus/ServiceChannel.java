package com.jenkov.javafxapp.bus;

import java.util.function.Function;

public class ServiceChannel {

    private Function service = null;

    public void setService(Function service) {
        this.service = service;
    }

    public Object callService(Object request){
        return this.service.apply(request);
    }

    public ServiceServer registerServer() {
        return new ServiceServer();
    }

    public ServiceClient registerClient() {
        return new ServiceClient();
    }

}
