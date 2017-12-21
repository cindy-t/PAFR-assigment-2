package main;

import services.*;
import domain.Train;
import domain.Wagon;

/**
 * Created by Cindy en Victor on 9-1-2017 and modfified on 21-12-2017.
 */
public class Main {
    public static void main(String [ ] args){

        ServiceProvider service = new ServiceProvider();
        service.getVehicleService().addObserver(service.getConsoleService());

        //adds a few trains and 1 wagon.
        Train train1 = service.getVehicleService().createTrain("tr1","Sprinter", 10);
        Train train2 = service.getVehicleService().createTrain("tr2","Intercity", 10);
        Wagon wagon1 = service.getVehicleService().createWagon("wg1","Passagier", 50);
        //Then adds 1 wagon to the first train
        train1.addWagon(wagon1);
        service.getCommandservice().findAndExecuteMatchingCommand("add wg1 to tr1");

        service.getConsoleService().startConsole();

    }
}
