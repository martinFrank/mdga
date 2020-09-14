package com.github.martinfrank.mdga.command;

import com.github.martinfrank.cli.Command;
import com.github.martinfrank.cli.Response;
import com.github.martinfrank.mdga.ConsoleApp;

import java.util.List;

public class StartGameCommand extends Command<ConsoleApp> {

    public StartGameCommand(ConsoleApp application) {
        super(application, "start");
    }

    @Override
    public Response execute(List<String> parameter) {
        try {
            getApplication().getMdga().reStart();
            getApplication().printBoard();
        } catch (Exception e) {
            return Response.fail("could not start game");
        }
        return Response.success();
    }
}
