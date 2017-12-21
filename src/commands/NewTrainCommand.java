package commands;

import domain.Train;
import services.VehicleService;

public class NewTrainCommand extends AbstractCommand {
    public  NewTrainCommand(VehicleService vehicleService){
        super(vehicleService, (NEW+WHITESPACE+TRAIN+WHITESPACE+ID));
    }

    @Override
    public boolean execute(String[] correctCommandSequenceList){
        boolean executionPerformed = false;
        for(String s : correctCommandSequenceList){
            System.out.println("Add Train Command called: "+s);

        }
        // trainType = correctCommandSequenceList[2];
        String trainId = correctCommandSequenceList[2];
        System.out.println("[NewTrainCommand.Java] new train with type"  + " with id " + trainId);
        Train newTRain = this.getVehicleService().createTrain(trainId,"Sprinter", 2);
        if(newTRain != null){
            executionPerformed = true;
        }
        return executionPerformed;
    }
}
