package com.soft.library.ui.menus;

import com.soft.library.ui.commandCore.CommandCollection;
import com.soft.library.ui.commandCore.IMenu;
import com.soft.library.ui.commandCore.Menu;

/**
 * Created by Oleg on 09.04.2015.
 */
public class MainMenu implements IMenu {
    @Override
    public void execute()  {
        CommandCollection menuCollection = new CommandCollection();
        menuCollection.addTask(new BookMenu());
        menuCollection.addTask(new AuthorMenu());
        menuCollection.addTask(new PublisherMenu());
        menuCollection.addTask(new ReaderMenu());

        new Menu(menuCollection).runApplication();
    }

    @Override
    public String getName() {
        return "menu commands";
    }
}
