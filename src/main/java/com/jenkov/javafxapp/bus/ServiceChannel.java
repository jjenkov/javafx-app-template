package com.jenkov.javafxapp.bus;

import java.util.function.Function;

public class ServiceChannel<RQT, RST>{

    private Function<RQT, RST> service = null;

    public void setService(Function<RQT, RST> service) {
        this.service = service;
    }

    public RST callService(RQT request){
        return this.service.apply(request);
    }

    public ServiceServer registerServer() {
        return new ServiceServer();
    }

    public ServiceClient registerClient() {
        return new ServiceClient();
    }

}
