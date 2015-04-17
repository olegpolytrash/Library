package com.soft.library.ui.commands.dataBaseCommands.authorCommands;

import com.soft.library.dataBase.service.AdvAuthorService;
import com.soft.library.ui.commandCore.Command;

/**
 * Created by Oleg on 09.04.2015.
 */
public class GetAllAuthorsCommand implements Command {
    @Override
    public void execute() {
        AdvAuthorService aas = new AdvAuthorService();
        aas.printAuthors();
    }

    @Override
    public String getName() {
        return "Get all authors";
    }
}
