package com.soft.library.ui.commands.dataBaseCommands.publisherCommands;

import com.soft.library.dataBase.service.PublisherService;
import com.soft.library.dataBase.service.ValidData;
import com.soft.library.ui.commandCore.Command;

/**
 * Created by Oleg on 09.04.2015.
 */
public class UpdatePublisherCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Type in Publisher's old name: ");
        String oldName = ValidData.getWords();
        System.out.println("Type in Publisher's new name: ");
        String newName = ValidData.getWords();
        new PublisherService().updatePublishers(oldName, newName);
    }

    @Override
    public String getName() {
        return "Update an publisher";
    }
}
