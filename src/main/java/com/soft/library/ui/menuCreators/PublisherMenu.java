package com.soft.library.ui.menuCreators;

import com.soft.library.ui.commandCore.CommandCollection;
import com.soft.library.ui.commandCore.Menu;
import com.soft.library.ui.commandCore.MenuViewer;
import com.soft.library.ui.commands.dataBaseCommands.publisherCommands.*;

/**
 * Created by Oleg on 09.04.2015.
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

        new MenuViewer(publisherCommandCollection).showMenu();
    }

    @Override
    public String getName() {
        return "publisher commands";
    }
}
