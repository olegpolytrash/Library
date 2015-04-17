package com.soft.library.ui.commands.dataBaseCommands.publisherCommands;

import com.soft.library.ui.commandCore.Command;

/**
 * Created by Oleg on 09.04.2015.
 */
public class DeletePublisherCommand implements Command {
    @Override
    public void execute() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter title:");
//        AdvPublisherService.deletePublisher(scanner.nextLine());
    }

    @Override
    public String getName() {
        return "Delete publisher";
    }
}
