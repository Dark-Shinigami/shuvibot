package core;

import commands.Command;

import java.util.HashMap;

/**
 *
 *  @author Dârkness
 *  @version 06.03.2018
 *
 */

public class commandHandler {

    public static final commandParser parse = new commandParser();
    public static HashMap<String, Command> commands = new HashMap<>();

    public static void handleCommand(commandParser.commandContainer cmd){

        if(commands.containsKey(cmd.invoke)){

            boolean safe = commands.get(cmd.invoke).called(cmd.args, cmd.event);

            if(!safe){
                commands.get(cmd.invoke).action(cmd.args, cmd.event);
                commands.get(cmd.invoke).executed(safe, cmd.event);
            } else {
                commands.get(cmd.invoke).executed(safe, cmd.event);
            }

        }else{
            cmd.event.getGuild().getTextChannels().get(0).sendMessage("Sorry Senpai! Command is not registerd! Try Again:flushed:");
        }
    }

}
