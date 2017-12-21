package services;

public class ServiceProvider {

    private static VehicleService vehicleService = new VehicleService();
    private static CommandService commandservice = new CommandService();
    private static CommandFactory commandFactory = new CommandFactory(vehicleService);
    private static ConsoleService consoleService = new ConsoleService(commandservice);

    public ServiceProvider() {
        commandFactory.addAllCommands(commandservice);
    }

    public static VehicleService getVehicleService() {
        return vehicleService;
    }

    public static CommandService getCommandservice() {
        return commandservice;
    }

    public static ConsoleService getConsoleService() {
        return consoleService;
    }

    public static CommandFactory getCommandFactory() {
        return commandFactory;
    }


}