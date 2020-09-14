package com.github.martinfrank.mdga.command;

import com.github.martinfrank.cli.Command;
import com.github.martinfrank.cli.Response;
import com.github.martinfrank.mdga.ConsoleApp;

import java.util.List;

public class EndTurnCommand extends Command<ConsoleApp> {

    public EndTurnCommand(ConsoleApp application) {
        super(application, "endturn");
    }

    @Override
    public Response execute(List<String> parameter) {
        try {
            getApplication().getMdga().changePlayer();
            getApplication().printBoard();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.fail("could not end turn");
        }
        return Response.success();
    }
}
