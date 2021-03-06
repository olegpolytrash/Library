package com.soft.library.ui.commands.dataBaseCommands.bookCommands;

import com.soft.library.dataBase.service.BookService;
import com.soft.library.dataBase.service.ValidData;
import com.soft.library.ui.commandCore.Command;

/**
 * Created by Oleg on 09.04.2015.
 */
public class GetBookByIdCommand implements Command {
    @Override
    public void execute() {
        BookService aas = new BookService();
        System.out.println("Enter id: ");
        int bookId = ValidData.getDigit();
        System.out.println(aas.getBookById(bookId));
    }

    @Override
    public String getName() {
        return "Get book by id";
    }
}
