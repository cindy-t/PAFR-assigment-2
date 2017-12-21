package commands;

import services.VehicleService;

public class ExitCommand extends AbstractCommand {

    public ExitCommand(VehicleService vehicleService){
        super(vehicleService, (EXIT));
    }
}
