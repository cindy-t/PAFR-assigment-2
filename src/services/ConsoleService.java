package services;

import controller.Observer;

import java.util.Scanner;

public class ConsoleService extends Observer{


    final String stopCommand = "STOP";
    final String consoleEndingMessage = "Exiting console application";
    CommandService commandservice;


    public ConsoleService(CommandService commandservice){
        this.commandservice = commandservice;
    }

    //Console, asks for input
    public void startConsole(){
        Scanner sc = new Scanner(System.in);
        String inputFromScanner = "";

        while(!inputFromScanner.equals(stopCommand)) {
            System.out.println("Put in next command: ");
            System.out.println(inputFromScanner);

            inputFromScanner = sc.nextLine();
            if(commandservice.findAndExecuteMatchingCommand(inputFromScanner)){
                System.out.println("Command successfully executed");
            }else{
                System.out.println("Command not recognised");
            }
        }
        System.out.println(consoleEndingMessage);
    }

    @Override
    public void update() {
        ServiceProvider.getVehicleService().printAllVehiclesPrinted();
    }
}
