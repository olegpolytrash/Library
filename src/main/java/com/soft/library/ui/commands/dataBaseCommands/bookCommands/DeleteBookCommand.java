package com.soft.library.ui.commands.dataBaseCommands.bookCommands;

import com.soft.library.dataBase.service.AuthorService;
import com.soft.library.dataBase.service.BookService;
import com.soft.library.dataBase.service.ValidData;
import com.soft.library.ui.commandCore.Command;

/**
 * Created by Oleg on 09.04.2015.
 */
public class DeleteBookCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Enter book title:");
        new BookService().deleteBook(ValidData.getWords());
    }
       
    @Override
    public String getName() {
        return "Delete book";
    }
}
