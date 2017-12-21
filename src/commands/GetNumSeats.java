package commands;

import domain.Vehicle;
import services.VehicleService;

public class GetNumSeats extends AbstractCommand {

    public GetNumSeats(VehicleService vehicleService){
        super(vehicleService, (GET+WHITESPACE+NUMSEATS+WHITESPACE+ID));
    }

    @Override
    public boolean execute(String[] correctCommandSequenceList){
        boolean executionPerformed= false;
        for(String s : correctCommandSequenceList){
            System.out.println(s);
        }
        String vehicleId = correctCommandSequenceList[2];
        System.out.println("[GetNumSeats.Java] Getting numseats of "+ vehicleId);


        Vehicle vehicle =  this.getVehicleService().getVehicleByName(vehicleId.toString());

        if(vehicle != null){
            System.out.println(vehicle.toString());
            executionPerformed = true;
        }

        return executionPerformed;
    }
}
