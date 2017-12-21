package commands;

import domain.Wagon;
import domain.WagonEnum;
import services.VehicleService;

public class NewWagonCommand extends AbstractCommand {
    public  NewWagonCommand(VehicleService vehicleService){
        super(vehicleService, (NEW+WHITESPACE+WAGON+WHITESPACE+ID+WHITESPACE+VEHICLETYPE+WHITESPACE+NUMSEATS+WHITESPACE+NUMBER));
    }

    @Override
    public boolean execute(String[] correctCommandSequenceList){
        boolean executionPerformed = false;
        Wagon newWagon = null;
        for(String s : correctCommandSequenceList){
            System.out.println(s);
        }
        String wagonId = correctCommandSequenceList[2];
        String typeId = correctCommandSequenceList[3];
        int numSeats = Integer.parseInt(correctCommandSequenceList[5]);
        System.out.println("[NewWagonCommand.Java] new wagon with id " + wagonId + " and " + numSeats + " seats");

        if(this.getVehicleService().checkWagonType(typeId)){
             newWagon = this.getVehicleService().createWagon(wagonId,typeId,numSeats);
        }else{
            String allWagonTypes = "";
            for(WagonEnum wagontype : WagonEnum.values()){
                allWagonTypes += " " + wagontype;
            }
            WagonEnum[] names = WagonEnum.values();
            System.out.println("WagonType needs to be part of: " + allWagonTypes);
        }

        if(newWagon != null){
            executionPerformed = true;
            System.out.println("");
        }

        return executionPerformed;
    }
}
