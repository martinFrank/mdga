package com.github.martinfrank.mdga;

import com.github.martinfrank.cli.*;
import com.github.martinfrank.mdga.command.EndTurnCommand;
import com.github.martinfrank.mdga.command.ExitCommand;
import com.github.martinfrank.mdga.command.NewGameCommand;
import com.github.martinfrank.mdga.command.StartGameCommand;

import java.io.IOException;

public class ConsoleApp implements CommandProvider, CommandInterpreterProvider {

    private final CommandInterpreter commandInterpreter;
    private final DefaultCommandList commandList;
    private final Mdga mdga;
    private final BoardPrinter bordPrinter;

    public ConsoleApp() throws IOException {
        commandInterpreter = new CommandInterpreter(this);
        commandList = new DefaultCommandList();
        commandList.add(new ExitCommand(this));
        commandList.add(new NewGameCommand(this));
        commandList.add(new StartGameCommand(this));
        commandList.add(new EndTurnCommand(this));
        mdga = new Mdga();
        mdga.setup(new MdgaSetup());
        bordPrinter = new BoardPrinter();
        bordPrinter.print(mdga.getBoard());
    }

    public static void main(String[] args) throws IOException {
        ConsoleApp consoleApp = new ConsoleApp();
        consoleApp.getCommandInterpreter().start();
    }

    @Override
    public CommandList getCommands() {
        return commandList;
    }

    @Override
    public CommandInterpreter getCommandInterpreter() {
        return commandInterpreter;
    }

    public Mdga getMdga() {
        return mdga;
    }

    public void printBoard() {
        bordPrinter.print(mdga.getBoard());
    }
}
