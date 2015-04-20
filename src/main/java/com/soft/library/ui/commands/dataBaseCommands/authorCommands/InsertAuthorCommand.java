package com.soft.library.ui.commands.dataBaseCommands.authorCommands;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.soft.library.dataBase.model.Book;
import com.soft.library.dataBase.service.AuthorService;
import com.soft.library.dataBase.service.ValidData;
import com.soft.library.ui.commandCore.Command;

/**
 * Created by Oleg on 09.04.2015.
 */

public class InsertAuthorCommand implements Command {

    @Override
    public void execute() {
        AuthorService aas = new AuthorService();
        String authorName;

        System.out.println("Type in Author's name: ");
        authorName = ValidData.getWords();
        Set<String> books = ValidData
                .continiouslyTyping("Type in at least one book written by "
                        + "this author. Enter \"exit\" for quit");
        aas.addAuthor(authorName, books);
    }

    @Override
    public String getName() {
        return "Insert an author";
    }
}
