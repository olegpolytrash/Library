package com.soft.library.ui.menus;

import com.soft.library.ui.commandCore.CommandCollection;
import com.soft.library.ui.commandCore.IMenu;
import com.soft.library.ui.commandCore.Menu;
import com.soft.library.ui.commands.dataBaseCommands.publisherCommands.*;

/**
 * Created by Oleg on 09.04.2015.
 */
public class PublisherMenu implements IMenu {
    @Override
    public void execute()  {
        CommandCollection publisherCommandCollection = new CommandCollection();
        publisherCommandCollection.addTask(new GetAllPublishersCommand());
        publisherCommandCollection.addTask(new GetPublisherByIdCommand());
        publisherCommandCollection.addTask(new DeletePublisherCommand());
        publisherCommandCollection.addTask(new UpdatePublisherCommand());
        publisherCommandCollection.addTask(new InsertPublisherCommand());

        new Menu(publisherCommandCollection).runApplication();
    }

    @Override
    public String getName() {
        return "publisher commands";
    }
}
