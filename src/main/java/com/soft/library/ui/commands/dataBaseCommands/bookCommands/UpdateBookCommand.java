package com.soft.library.ui.commands.dataBaseCommands.bookCommands;

import com.soft.library.dataBase.service.BookService;
import com.soft.library.dataBase.service.ValidData;
import com.soft.library.ui.commandCore.Command;

/**
 * Created by Oleg on 09.04.2015.
 */
public class UpdateBookCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Type in Book's old name: ");
        String oldName = ValidData.getWords();
        System.out.println("Type in Book's new name: ");
        String newName = ValidData.getWords();
        new BookService().updateBooks(oldName, newName);
    }

    @Override
    public String getName() {
        return "Update a book";
    }
}
