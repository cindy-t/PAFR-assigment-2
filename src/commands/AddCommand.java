package commands;

import domain.Train;
import domain.Wagon;
import services.VehicleService;

public class AddCommand extends AbstractCommand {

    public AddCommand(VehicleService vehicleService){
        super(vehicleService, (ADD+WHITESPACE+ID+WHITESPACE+TO+WHITESPACE+ID));
    }


    // Has to receive the correct IDs from the CommandService yet using arrayids [1] and [3]
    @Override
    public boolean execute(String[] correctCommandSequenceList){
        boolean executionPerformed = false;

        for(String s : correctCommandSequenceList){
            System.out.println(s);
        }
        String wagonName = correctCommandSequenceList[1];
        String trainName = correctCommandSequenceList[3];

        System.out.println("[AddCommand.Java] Adding "+ wagonName + " to " + trainName);

        Train train = this.getVehicleService().getTrainByName(trainName);
        Wagon wagon = this.getVehicleService().getWagonByName(wagonName);


        if(train != null & wagon != null){
            this.getVehicleService().addWagonByName(train,wagon);
            executionPerformed = true;
        }

        return executionPerformed;
    }

}
