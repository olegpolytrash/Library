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
        
        System.out.println("Type in Author's name: ");
        authorName = ValidData.getWords();
        System.out.println("Type in books written by this author: ");
        Set<String> books = ValidData
                .continiouslyTyping("Type in at least one book. Enter \"exit\" for quit");
        aas.addAuthor(authorName, books);
    }

    @Override
    public String getName() {
        return "Insert an author";
    }
}
