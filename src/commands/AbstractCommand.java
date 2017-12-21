package commands;

import services.VehicleService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractCommand {

    private String commandname = this.getClass().getSimpleName();
    private String commandPattern;

    //All String patterns
    private VehicleService vehicleService;
    protected static final String
            NEW 		= "new",
            DELETE		= "delete",
            REMOVE 		= "remove",
            ADD			= "add",
            TO			= "to",
            FROM		= "from",
            TYPE 		= "(train|wagon)",
            VIEW		= "view",
            VIEWTYPE    = "(textualdepot|log|imagetrain)",
            WHITESPACE 	= "(\t| |\r|\n|\u000C)+",
            ID 			= "[a-z][a-z|0-9]*",
            VEHICLETYPE	= "[A-Z|a-z][a-z|0-9]*",
            NUMBER		= "[0-9]+",
            NUMSEATS	= "numseats",
            GET 		= "get",
            CLEAR 		= "(clear|clr|cls)",
            EXIT		= "(exit|quit)",
            UNDO	    = "undo",
            WAGON       = "wagon",
            TRAIN       = "train";

    // CommandPattern check
    public AbstractCommand(VehicleService vehicleService, String pattern){
        this.vehicleService = vehicleService;
        System.out.println("Bestaat wel" + pattern);;
        this.commandPattern = pattern;
    }

    public VehicleService getVehicleService(){
        return this.vehicleService;
    }


    //Check for correct command
    public boolean executeIfCorrect(String input){
        boolean correctExecution = false;
        Pattern p = Pattern.compile(commandPattern);

        Matcher m = p.matcher(input);
        boolean hasBeenFound = m.find();

        if(hasBeenFound){
            System.out.println("Did match command: " + commandname);
            String[] currentCommandArray = input.split(WHITESPACE);
            if (execute(currentCommandArray)){
                correctExecution = true;
            }
        }else{
            System.out.println("Did not match command: " + commandname);
        }
        return(correctExecution);

    }

    public boolean execute(String[] correctCommandSequenceList){
        return false;
    }

    public String toString(){
        return(commandPattern.toString());
    }

}
