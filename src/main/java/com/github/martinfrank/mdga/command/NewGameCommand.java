package com.github.martinfrank.mdga.command;

import com.github.martinfrank.cli.Command;
import com.github.martinfrank.cli.Response;
import com.github.martinfrank.mdga.ConsoleApp;
import com.github.martinfrank.mdga.MdgaSetup;

import java.util.List;

public class NewGameCommand extends Command<ConsoleApp> {

    private static final String DEMO = "demo";

    public NewGameCommand(ConsoleApp application) {
        super(application, "newgame");
    }

    @Override
    public Response execute(List<String> parameter) {
        MdgaSetup setup;
        try {
            setup = isDemo(parameter) ? MdgaSetup.demoSetup() :
                    MdgaSetup.singlePlayerSetup(parseInput(parameter));

        } catch (Exception e) {
            return Response.fail("invalid parameter for command (should be '2', '3', '4' or 'demo')");
        }
        try {
            getApplication().getMdga().setup(setup);
        } catch (Exception e) {
            return Response.fail("could not setup game");
        }
        return Response.success();
    }

    private int parseInput(List<String> parameter) {
        if (parameter == null || parameter.size() != 1) {
            throw new IllegalArgumentException();
        }
        int value = Integer.parseInt(parameter.get(0));
        if (value != 2 && value != 3 && value != 4) {
            throw new IllegalArgumentException();
        }
        return value;
    }

    private boolean isDemo(List<String> parameter) {
        if (parameter == null || parameter.size() != 1) {
            return false;
        }
        return DEMO.equalsIgnoreCase(parameter.get(0));
    }
}
