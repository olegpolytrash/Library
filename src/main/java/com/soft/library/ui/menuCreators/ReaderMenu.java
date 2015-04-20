package com.soft.library.ui.menuCreators;

import com.soft.library.ui.commandCore.CommandCollection;
import com.soft.library.ui.commandCore.Menu;
import com.soft.library.ui.commandCore.ConsoleMenuViewer;
import com.soft.library.ui.commands.dataBaseCommands.readerCommands.*;

/**
 * Menu for commands that can be applied to the Reader table
 */
public class ReaderMenu implements Menu {
    @Override
    public void execute()  {
        CommandCollection readerCommandCollection = new CommandCollection();
        readerCommandCollection.addTask(new DeleteReaderCommand());
        readerCommandCollection.addTask(new GetAllReadersCommand());
        readerCommandCollection.addTask(new GetReaderByIdCommand());
        readerCommandCollection.addTask(new InsertReaderCommand());
        readerCommandCollection.addTask(new UpdateReaderAddressCommand());
        readerCommandCollection.addTask(new UpdateReaderBDateCommand());
        readerCommandCollection.addTask(new UpdateReaderMobileCommand());
        readerCommandCollection.addTask(new UpdateReaderNameCommand());

        new ConsoleMenuViewer(readerCommandCollection).showMenu();
    }

    @Override
    public String getName() {
        return "reader commands";
    }
}
