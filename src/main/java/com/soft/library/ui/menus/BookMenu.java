package com.soft.library.ui.menus;

import com.soft.library.ui.commandCore.CommandCollection;
import com.soft.library.ui.commandCore.IMenu;
import com.soft.library.ui.commandCore.Menu;
import com.soft.library.ui.commands.dataBaseCommands.bookCommands.*;

/**
 * Created by Oleg on 09.04.2015.
 */
public class BookMenu implements IMenu {
    @Override
    public void execute()  {
        CommandCollection bookCommandCollection = new CommandCollection();
        bookCommandCollection.addTask(new GetAllBooksCommand());
        bookCommandCollection.addTask(new GetBookByIdCommand());
        bookCommandCollection.addTask(new UpdateBookCommand());
        bookCommandCollection.addTask(new DeleteBookCommand());
        bookCommandCollection.addTask(new InsertBookCommand());
        
        new Menu(bookCommandCollection).runApplication();
    }

    @Override
    public String getName() {
        return "book commands";
    }
}
