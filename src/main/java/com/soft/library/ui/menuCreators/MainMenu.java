package com.soft.library.ui.menuCreators;

import com.soft.library.ui.commandCore.CommandCollection;
import com.soft.library.ui.commandCore.Menu;
import com.soft.library.ui.commandCore.ConsoleMenuViewer;

/**
 * Created by Oleg on 09.04.2015.
 */
public class MainMenu implements Menu {
    @Override
    public void execute()  {
        CommandCollection menuCollection = new CommandCollection();
        menuCollection.addTask(new BookMenu());
        menuCollection.addTask(new AuthorMenu());
        menuCollection.addTask(new PublisherMenu());
        menuCollection.addTask(new ReaderMenu());

        new ConsoleMenuViewer(menuCollection).showMenu();
    }

    @Override
    public String getName() {
        return "menu commands";
    }
}
