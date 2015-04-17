package com.soft.library.ui.commands.dataBaseCommands.authorCommands;

import java.util.Scanner;

import com.soft.library.dataBase.service.AdvAuthorService;
import com.soft.library.ui.commandCore.Command;

/**
 * Created by Oleg on 09.04.2015.
 */

public class InsertAuthorCommand implements Command {

    @Override
    public void execute() {
        AdvAuthorService aas = new AdvAuthorService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type in Author's name: ");
        aas.addAuthor(scanner.nextLine());
    }

    @Override
    public String getName() {
        return "Insert an author";
    }
}
