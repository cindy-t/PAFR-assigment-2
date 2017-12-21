package services;

import commands.AbstractCommand;

import java.util.ArrayList;

public class CommandService {

    private ArrayList<AbstractCommand> abstractCommands;

    public CommandService(){
        abstractCommands = new ArrayList<AbstractCommand>();
    }

    public void addCommandToList(AbstractCommand abstractCommand){
        abstractCommands.add(abstractCommand);
    }
    public ArrayList<AbstractCommand> getCommandList(){
        return abstractCommands;
    }


    public boolean findAndExecuteMatchingCommand(String commandInput){
        boolean didItWork = false;

        System.out.println("Current input: "+ commandInput);
        for (AbstractCommand abstractCommand : this.getCommandList()){
            didItWork = abstractCommand.executeIfCorrect(commandInput);
            if(didItWork){
                System.out.println("[CommandService]");
                break;
            }
        }
        return didItWork;

    }

    public boolean executeCommand(){
        boolean state = false;
        return state;
    }

}
