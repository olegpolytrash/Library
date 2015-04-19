package com.soft.library.ui.menus;

import com.soft.library.ui.commandCore.CommandCollection;
import com.soft.library.ui.commandCore.IMenu;
import com.soft.library.ui.commandCore.Menu;
import com.soft.library.ui.commands.dataBaseCommands.readerCommands.DeleteReaderCommand;
import com.soft.library.ui.commands.dataBaseCommands.readerCommands.GetAllReadersCommand;
import com.soft.library.ui.commands.dataBaseCommands.readerCommands.GetReaderByIdCommand;
import com.soft.library.ui.commands.dataBaseCommands.readerCommands.InsertReaderCommand;
import com.soft.library.ui.commands.dataBaseCommands.readerCommands.UpdateReaderAddressCommand;
import com.soft.library.ui.commands.dataBaseCommands.readerCommands.UpdateReaderBDateCommand;
import com.soft.library.ui.commands.dataBaseCommands.readerCommands.UpdateReaderMobileCommand;
import com.soft.library.ui.commands.dataBaseCommands.readerCommands.UpdateReaderNameCommand;

public class ReaderMenu implements IMenu {
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

        new Menu(readerCommandCollection).runApplication();
    }

    @Override
    public String getName() {
        return "reader commands";
    }
}
