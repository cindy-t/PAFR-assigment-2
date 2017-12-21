package commands;

import services.VehicleService;

public class NewCommand extends AbstractCommand {
    public  NewCommand(VehicleService vehicleService){
        super(vehicleService, (NEW+WHITESPACE+TYPE));
    }

}
