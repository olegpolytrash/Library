package com.soft.library.ui.menuCreators;

import com.soft.library.ui.commandCore.CommandCollection;
import com.soft.library.ui.commandCore.Menu;
import com.soft.library.ui.commandCore.MenuViewer;
import com.soft.library.ui.commands.dataBaseCommands.bookCommands.*;

/**
 * Created by Oleg on 09.04.2015.
 */
public class BookMenu implements Menu {
    @Override
    public void execute()  {
        CommandCollection bookCommandCollection = new CommandCollection();
        bookCommandCollection.addTask(new GetAllBooksCommand());
        bookCommandCollection.addTask(new GetBookByIdCommand());
        bookCommandCollection.addTask(new UpdateBookCommand());
        bookCommandCollection.addTask(new DeleteBookCommand());
        bookCommandCollection.addTask(new InsertBookCommand());
        
        new MenuViewer(bookCommandCollection).showMenu();
    }

    @Override
    public String getName() {
        return "book commands";
    }
}
