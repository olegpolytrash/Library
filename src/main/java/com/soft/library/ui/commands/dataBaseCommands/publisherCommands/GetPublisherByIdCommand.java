package com.soft.library.ui.commands.dataBaseCommands.publisherCommands;

import com.soft.library.dataBase.service.AdvPublisherService;
import com.soft.library.dataBase.service.ValidData;
import com.soft.library.ui.commandCore.Command;

/**
 * Created by Oleg on 09.04.2015.
 */
public class GetPublisherByIdCommand implements Command {
    @Override
    public void execute() {
        AdvPublisherService aas = new AdvPublisherService();
        System.out.println("Enter id: ");
        int publisherId = ValidData.getDigit();
        System.out.println(aas.getPublisherById(publisherId));
    }

    @Override
    public String getName() {
        return "Get publisher by id";
    }
}
