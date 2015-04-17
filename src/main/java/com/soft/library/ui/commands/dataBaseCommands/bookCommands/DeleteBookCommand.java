package com.soft.library.ui.commands.dataBaseCommands.bookCommands;

import com.soft.library.ui.commandCore.Command;

/**
 * Created by Oleg on 09.04.2015.
 */
public class DeleteBookCommand implements Command {
    @Override
    public void execute() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter title:");
//        AdvBookService.deleteBook(scanner.nextLine());
    }
       
    @Override
    public String getName() {
        return "Delete book";
    }
}
