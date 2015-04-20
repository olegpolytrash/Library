package com.soft.library.ui.commands.dataBaseCommands.authorCommands;

import com.soft.library.dataBase.service.AuthorService;
import com.soft.library.ui.commandCore.Command;

/**
 * Created by Oleg on 09.04.2015.
 */
public class GetAllAuthorsCommand implements Command {
    @Override
    public void execute() {
        new AuthorService().printAuthors();
    }

    @Override
    public String getName() {
        return "Get all authors";
    }
}
