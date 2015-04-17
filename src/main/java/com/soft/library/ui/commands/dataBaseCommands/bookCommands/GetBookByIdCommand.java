package com.soft.library.ui.commands.dataBaseCommands.bookCommands;

import com.soft.library.ui.commandCore.Command;

/**
 * Created by Oleg on 09.04.2015.
 */
public class GetBookByIdCommand implements Command {
    @Override
    public void execute() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter id: ");
//        int bookId = scanner.nextInt();
//        System.out.println(AdvBookService.getBookById(bookId).getName());
    }

    @Override
    public String getName() {
        return "Get book by id";
    }
}
