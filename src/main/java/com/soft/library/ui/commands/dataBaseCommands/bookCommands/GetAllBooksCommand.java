package com.soft.library.ui.commands.dataBaseCommands.bookCommands;

import com.soft.library.dataBase.service.BookService;
import com.soft.library.ui.commandCore.Command;

/**
 * Created by Oleg on 09.04.2015.
 */
public class GetAllBooksCommand implements Command {
    @Override
    public void execute() {
        new BookService().printBooks();
    }

    @Override
    public String getName() {
        return "Get all Books";
    }
}
