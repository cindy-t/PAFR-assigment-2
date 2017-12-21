package services;


import commands.*;

public class CommandFactory {

    private VehicleService vehicleService;

    public CommandFactory(VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }

    public void addAllCommands(CommandService commandService){
        commandService.addCommandToList(new AddCommand(vehicleService));
        commandService.addCommandToList(new DelCommand(vehicleService));
        commandService.addCommandToList(new GetNumSeats(vehicleService));
        commandService.addCommandToList(new NewTrainCommand(vehicleService));
        commandService.addCommandToList(new NewWagonCommand(vehicleService));
        commandService.addCommandToList(new RemoveCommand(vehicleService));
    }

}
