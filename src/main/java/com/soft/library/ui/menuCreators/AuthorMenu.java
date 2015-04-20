package com.soft.library.ui.menuCreators;

import com.soft.library.ui.commandCore.CommandCollection;
import com.soft.library.ui.commandCore.Menu;
import com.soft.library.ui.commandCore.ConsoleMenuViewer;
import com.soft.library.ui.commands.dataBaseCommands.authorCommands.*;

/**
 * Menu for commands that can be applied to the author table
 */
public class AuthorMenu implements Menu {
    @Override
    public void execute()  {
        CommandCollection authorCommandCollection = new CommandCollection();
        authorCommandCollection.addTask(new GetAllAuthorsCommand());
        authorCommandCollection.addTask(new GetAuthorByIdCommand());
        authorCommandCollection.addTask(new DeleteAuthorCommand());
        authorCommandCollection.addTask(new UpdateAuthorCommand());
        authorCommandCollection.addTask(new InsertAuthorCommand());

        new ConsoleMenuViewer(authorCommandCollection).showMenu();
    }

    @Override
    public String getName() {
        return "author commands";
    }
}
