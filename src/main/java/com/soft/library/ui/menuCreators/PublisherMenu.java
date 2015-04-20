package com.soft.library.ui.menuCreators;

import com.soft.library.ui.commandCore.CommandCollection;
import com.soft.library.ui.commandCore.Menu;
import com.soft.library.ui.commandCore.ConsoleMenuViewer;
import com.soft.library.ui.commands.dataBaseCommands.publisherCommands.*;

/**
 * Menu for commands that can be applied to the Publisher table
 */
public class PublisherMenu implements Menu {
    @Override
    public void execute()  {
        CommandCollection publisherCommandCollection = new CommandCollection();
        publisherCommandCollection.addTask(new GetAllPublishersCommand());
        publisherCommandCollection.addTask(new GetPublisherByIdCommand());
        publisherCommandCollection.addTask(new DeletePublisherCommand());
        publisherCommandCollection.addTask(new UpdatePublisherCommand());
        publisherCommandCollection.addTask(new InsertPublisherCommand());

        new ConsoleMenuViewer(publisherCommandCollection).showMenu();
    }

    @Override
    public String getName() {
        return "publisher commands";
    }
}
