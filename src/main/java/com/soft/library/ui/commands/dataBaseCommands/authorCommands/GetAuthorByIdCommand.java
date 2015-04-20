package com.soft.library.ui.commands.dataBaseCommands.authorCommands;

import com.soft.library.dataBase.service.AuthorService;
import com.soft.library.dataBase.service.ValidData;
import com.soft.library.ui.commandCore.Command;

/**
 * Created by Oleg on 09.04.2015.
 */
public class GetAuthorByIdCommand implements Command {
    @Override
    public void execute() {

        AuthorService aas = new AuthorService();
        System.out.println("Enter id: ");
        int authorId = ValidData.getDigit();
        System.out.println(aas.getAuthorById(authorId));
    }

    @Override
    public String getName() {
        return "Get author by id";
    }
}
