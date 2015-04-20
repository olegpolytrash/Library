package com.soft.library.ui.commands.dataBaseCommands.authorCommands;

import java.util.Scanner;

import com.soft.library.dataBase.service.AuthorService;
import com.soft.library.dataBase.service.ValidData;
import com.soft.library.ui.commandCore.Command;

/**
 * Created by Oleg on 09.04.2015.
 */
public class DeleteAuthorCommand implements Command {
    @Override
    public void execute() {
        
        System.out.println("Enter Author's name:");
        new AuthorService().deleteAuthor(ValidData.getWords());
    }

    @Override
    public String getName() {
        return "Delete author";
    }
}
