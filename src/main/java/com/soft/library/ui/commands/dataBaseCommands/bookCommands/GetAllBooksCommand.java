package com.soft.library.ui.commands.dataBaseCommands.bookCommands;

import com.soft.library.dataBase.service.AdvBookService;
import com.soft.library.ui.commandCore.Command;

/**
 * Created by Oleg on 09.04.2015.
 */
public class GetAllBooksCommand implements Command {
    @Override
    public void execute() {
        new AdvBookService().printBooks();
    }

    @Override
    public String getName() {
        return "Get all Books";
    }
}
