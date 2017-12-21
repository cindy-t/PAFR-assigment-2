package commands;


import services.VehicleService;

public class DelCommand extends AbstractCommand {

    public  DelCommand(VehicleService vehicleService){
        super(vehicleService, (DELETE+WHITESPACE+ID));
    }

    @Override
    public boolean execute(String[] correctCommandSequenceList){
        boolean executionPerformed = false;
        for(String s : correctCommandSequenceList){
            System.out.println(s);
        }
        String vehicleId = correctCommandSequenceList[1];
        System.out.println("[DelCommand.Java] Deleting id"+ vehicleId);
        executionPerformed = this.getVehicleService().deleteVehicle(getVehicleService().getVehicleByName(vehicleId.toString()));

        return executionPerformed;
    }
}
