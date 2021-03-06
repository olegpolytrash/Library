package com.soft.library.ui.commands.dataBaseCommands.bookCommands;

import com.soft.library.dataBase.service.BookService;
import com.soft.library.dataBase.service.ValidData;
import com.soft.library.ui.commandCore.Command;

import java.util.Set;

/**
 * Created by Oleg on 09.04.2015.
 */
public class InsertBookCommand implements Command {

    @Override
    public void execute() {
        BookService aas = new BookService();
        String bookName;

        System.out.println("Type in Book's name: ");
        bookName = ValidData.getWords();
        Set<String> books = ValidData
                .continiouslyTyping("Type in at least one author who wrote"
                        + " this book. Enter \"exit\" for quit");
        aas.addBook(bookName, books);
    }

    @Override
    public String getName() {
        return "Insert Book";
    }
}
