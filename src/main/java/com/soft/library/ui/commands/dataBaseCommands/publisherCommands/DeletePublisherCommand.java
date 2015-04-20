package com.soft.library.ui.commands.dataBaseCommands.publisherCommands;

import com.soft.library.dataBase.service.PublisherService;
import com.soft.library.dataBase.service.ValidData;
import com.soft.library.ui.commandCore.Command;

/**
 * Created by Oleg on 09.04.2015.
 */
public class DeletePublisherCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Enter publisher title:");
        new PublisherService().deletePublisher(ValidData.getWords());
    }

    @Override
    public String getName() {
        return "Delete publisher";
    }
}
