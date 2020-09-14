package com.github.martinfrank.mdga.command;

import com.github.martinfrank.cli.Command;
import com.github.martinfrank.cli.Response;
import com.github.martinfrank.mdga.ConsoleApp;

import java.util.List;

public class ExitCommand extends Command<ConsoleApp> {

    public ExitCommand(ConsoleApp application) {
        super(application, "exit");
    }

    @Override
    public Response execute(List<String> parameter) {
        getApplication().getCommandInterpreter().stop();
        return Response.success();
    }
}
