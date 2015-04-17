package com.soft.library.ui.commands.dataBaseCommands.publisherCommands;

import com.soft.library.ui.commandCore.Command;

/**
 * Created by Oleg on 09.04.2015.
 */
public class InsertPublisherCommand implements Command {

    @Override
    public void execute() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Type in publisher's name: ");
//        AdvPublisherService.addPublisher(scanner.nextLine());
    }

    @Override
    public String getName() {
        return "Insert an publisher";
    }
}
