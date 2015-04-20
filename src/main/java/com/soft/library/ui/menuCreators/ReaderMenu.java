package com.soft.library.ui.menuCreators;

import com.soft.library.ui.commandCore.CommandCollection;
import com.soft.library.ui.commandCore.Menu;
import com.soft.library.ui.commandCore.MenuViewer;
import com.soft.library.ui.commands.dataBaseCommands.readerCommands.*;

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

        new MenuViewer(readerCommandCollection).showMenu();
    }

    @Override
    public String getName() {
        return "reader commands";
    }
}
