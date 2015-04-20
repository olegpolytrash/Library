package com.soft.library.ui.commands.dataBaseCommands.publisherCommands;

import com.soft.library.dataBase.service.AdvPublisherService;
import com.soft.library.dataBase.service.ValidData;
import com.soft.library.ui.commandCore.Command;

/**
 * Created by Oleg on 09.04.2015.
 */
public class InsertPublisherCommand implements Command {

    @Override
    public void execute() {
        AdvPublisherService aas = new AdvPublisherService();
        String publisherName;

        System.out.println("Type in Publisher's name: ");
        publisherName = ValidData.getWords();
        aas.addPublisher(publisherName);
    }

    @Override
    public String getName() {
        return "Insert an publisher";
    }
}
