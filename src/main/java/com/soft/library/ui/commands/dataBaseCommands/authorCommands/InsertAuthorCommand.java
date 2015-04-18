package com.soft.library.ui.commands.dataBaseCommands.authorCommands;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.soft.library.dataBase.model.Book;
import com.soft.library.dataBase.service.AdvAuthorService;
import com.soft.library.dataBase.service.ValidData;
import com.soft.library.ui.commandCore.Command;

/**
 * Created by Oleg on 09.04.2015.
 */

public class InsertAuthorCommand implements Command {

    @Override
    public void execute() {
        AdvAuthorService aas = new AdvAuthorService();
        String authorName;
        Set<String> books = new HashSet<String>();

        System.out.println("Type in Author's name: ");
        authorName = ValidData.getWords();
        System.out.println("Type in books written by this author: ");
        String temp = ValidData.getWords();

        while (!(temp.equalsIgnoreCase("exit")) || books.size() == 0) {
            System.out
                    .println("Type in at least one book. Enter \"exit\" for quit");
            temp = ValidData.getWords();
            if (!(temp.equalsIgnoreCase("exit"))) {
                books.add(temp);
            }
        }
        aas.addAuthor(authorName, books);
    }

    @Override
    public String getName() {
        return "Insert an author";
    }
}
