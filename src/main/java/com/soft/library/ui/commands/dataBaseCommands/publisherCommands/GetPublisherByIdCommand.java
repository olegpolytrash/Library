package com.soft.library.ui.commands.dataBaseCommands.publisherCommands;

import com.soft.library.ui.commandCore.Command;

/**
 * Created by Oleg on 09.04.2015.
 */
public class GetPublisherByIdCommand implements Command {
    @Override
    public void execute() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter id: ");
//        int publisherId = scanner.nextInt();
//        System.out.println(AdvPublisherService.getPublisherById(publisherId).getName());
    }

    @Override
    public String getName() {
        return "Get publisher by id";
    }
}
