package controller;

import services.VehicleService;

public abstract class Observer {

    protected VehicleService vehicleService;

    public abstract void update();

}
