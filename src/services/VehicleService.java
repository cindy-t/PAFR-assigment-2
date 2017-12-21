package services;

import controller.Observer;
import domain.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleService {
    private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>(); //Holds all vehicles at this moment
    private List<Observer> observers = new ArrayList<Observer>();

    public ArrayList<Vehicle> getVehicles(){
        return vehicles;
    }

    public Train createTrain(String name, String type, int seats){
        Train train = null;
        if (!checkIfNameExists(name)){
            int id = getNextID(); // Get next ID from vehicles list
            for (TrainEnum traintype : TrainEnum.values()){
                if (traintype.toString().equals(type)){
                    train = new Train(id, name, type, seats);
                    vehicles.add(train);
                }
            }
        }
        notifyAllObserver();
        return train;
    }

    public Wagon createWagon(String name, String type, int seats){
        Wagon wagon = null;
        if (!checkIfNameExists(name)) {
            int id = getNextID(); // Get next ID from vehicles list
            if (checkWagonType(type)) {
                wagon = new Wagon(id, name, type, seats);
                vehicles.add(wagon);
            }
        }
        notifyAllObserver();
        return wagon;
    }
    public boolean checkIfNameExists(String vehicleName){
        boolean result = false;
        if (!vehicles.isEmpty()){
            for (Vehicle v : getVehicles()) {
                if (v.getName() == vehicleName) {
                    result = true;
                }
            }
        }
        return result;
    }
    //Checks if array is empty or not and assigns correct next id
    private int getNextID(){
        if (vehicles.isEmpty()){
            return 1;
        }else{
            return vehicles.size() + 1;
        }
    }

    public Vehicle getVehicleByID(int vehicleID){
        Vehicle vehicle = null;
        for (Vehicle v : getVehicles()){
            if(v.getId() == vehicleID){
                vehicle = v;
            }
        }
        return vehicle;
    }

    public Vehicle getVehicleByName(String vehicleName){
        Vehicle vehicle = null;
        for (Vehicle v : getVehicles()){
            if(v.getName().equals(vehicleName)){
                vehicle = v;

            }
        }
        return vehicle;
    }

    public boolean checkWagonType(String type){
        boolean check = false;
        for(WagonEnum wagontype : WagonEnum.values()){
            if (wagontype.toString().equals(type)) {
                check = true;
            }
        }
        return check;
    }

    public void addWagonByName(Train train, Wagon wagon){
        train.addWagon(wagon);
        System.out.println("[VehicleService] addWagonByName was called in VehicleService and returned: " + wagon);
        notifyAllObserver();
    }

    public void removeWagonByName(Train train, Wagon wagon){
        train.removeWagon(wagon);
        System.out.println("[VehicleService] removeWagonByName was called in VehicleService and returned: " + wagon);
        notifyAllObserver();
    }

    public Wagon getWagonByName(String trainName){
        Vehicle returnedVehicle = getVehicleByName(trainName);
        Wagon wagon  = castToWagonIfWagon(returnedVehicle);
        System.out.println("getWagonByName was called in VehicleService and returned: " + wagon);
        return wagon;
    }

    public Train getTrainByName(String trainName){
        Vehicle returnedVehicle = getVehicleByName(trainName);
        Train train  = castToTrainIfTrain(returnedVehicle);
        System.out.println("getTrainByName was called in VehicleService and returned: " + train);
        return train;
    }
    
    public boolean deleteVehicle(Vehicle vehicle){
        boolean result = false;
        while(vehicles.contains(vehicle)){
            System.out.println("deleteTrain was called in VehicleService and "+ vehicle.getId() +" will be deleted");
            vehicles.remove(vehicle);
            result = true;
            notifyAllObserver();
        }
        return result;
    }

    //Observers
    public void addObserver(Observer o){
        observers.add(o);
    }
    public void removeObserver(Observer o){
        observers.remove(o);
    }

    public void notifyAllObserver() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public Train castToTrainIfTrain(Vehicle vehicle){
        Train train = null;
        if(vehicle instanceof Train) {
            train = (Train)vehicle;
        }
        return train;
    }
    public Wagon castToWagonIfWagon(Vehicle vehicle){
        Wagon wagon = null;
        if(vehicle instanceof Wagon) {
            wagon = (Wagon)vehicle;
        }
        return wagon;

    }

    public void printAllVehiclesPrinted(){
        for (Vehicle vehicle : this.getVehicles()){
            System.out.println(vehicle);
        }
    }


}


