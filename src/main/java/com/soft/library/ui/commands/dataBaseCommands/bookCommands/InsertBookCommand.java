package com.soft.library.ui.commands.dataBaseCommands.bookCommands;

import com.soft.library.ui.commandCore.Command;

/**
 * Created by Oleg on 09.04.2015.
 */
public class InsertBookCommand implements Command {

    @Override
    public void execute() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Type in title: ");
//        AdvBookService.addBook(scanner.nextLine());
    }

    @Override
    public String getName() {
        return "Insert Book";
    }
}
