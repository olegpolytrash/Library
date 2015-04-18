package com.soft.library.ui.commands.dataBaseCommands.bookCommands;

import java.util.Set;

import com.soft.library.dataBase.service.AdvBookService;
import com.soft.library.dataBase.service.ValidData;
import com.soft.library.ui.commandCore.Command;

/**
 * Created by Oleg on 09.04.2015.
 */
public class InsertBookCommand implements Command {

    @Override
    public void execute() {
        AdvBookService aas = new AdvBookService();
        String bookName;

        System.out.println("Type in Book's name: ");
        bookName = ValidData.getWords();
        System.out.println("Type in author who wrote this book: ");
        Set<String> books = ValidData
                .continiouslyTyping("Type in at least one author. Enter \"exit\" for quit");
        aas.addBook(bookName, books);
    }

    @Override
    public String getName() {
        return "Insert Book";
    }
}
