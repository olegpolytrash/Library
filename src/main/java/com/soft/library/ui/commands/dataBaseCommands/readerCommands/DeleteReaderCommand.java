package com.soft.library.ui.commands.dataBaseCommands.readerCommands;

import com.soft.library.dataBase.service.ReaderService;
import com.soft.library.dataBase.service.ValidData;
import com.soft.library.ui.commandCore.Command;

/**
 * Created by Oleg on 09.04.2015.
 */
public class DeleteReaderCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Enter reader title:");
        new ReaderService().deleteReader(ValidData.getWords());
    }

    @Override
    public String getName() {
        return "Delete reader";
    }
}
