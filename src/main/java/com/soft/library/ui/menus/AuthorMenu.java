package com.soft.library.ui.menus;

import com.soft.library.ui.commandCore.CommandCollection;
import com.soft.library.ui.commandCore.IMenu;
import com.soft.library.ui.commandCore.Menu;
import com.soft.library.ui.commands.dataBaseCommands.authorCommands.*;

/**
 * Created by Oleg on 09.04.2015.
 */
public class AuthorMenu implements IMenu {
    @Override
    public void execute()  {
        CommandCollection authorCommandCollection = new CommandCollection();
        authorCommandCollection.addTask(new GetAllAuthorsCommand());
        authorCommandCollection.addTask(new GetAuthorByIdCommand());
        authorCommandCollection.addTask(new DeleteAuthorCommand());
        authorCommandCollection.addTask(new UpdateAuthorCommand());
        authorCommandCollection.addTask(new InsertAuthorCommand());

        new Menu(authorCommandCollection).runApplication();
    }

    @Override
    public String getName() {
        return "author commands";
    }
}
