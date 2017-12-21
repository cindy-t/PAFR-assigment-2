package commands;

import domain.Train;
import domain.Wagon;
import services.VehicleService;

public class RemoveCommand extends AbstractCommand {
    public RemoveCommand(VehicleService vehicleService){
        super(vehicleService, (REMOVE+WHITESPACE+ID+WHITESPACE+FROM+WHITESPACE+ID));
    }

    @Override
    public boolean execute(String[] correctCommandSequenceList){
        boolean executionPerformed = false;
        for(String s : correctCommandSequenceList){
            System.out.println(s);
        }
        String wagonName = correctCommandSequenceList[1];
        String trainName = correctCommandSequenceList[3];

        Train train = this.getVehicleService().getTrainByName(trainName);
        Wagon wagon = this.getVehicleService().getWagonByName(wagonName);

        if(train != null & wagon != null){
            this.getVehicleService().removeWagonByName(train,wagon);
            executionPerformed = true;
        }

        System.out.println("[RemoveCommand.Java] Removing "+ wagonName + " from " + trainName);
        this.getVehicleService();
        return executionPerformed;
    }
}
