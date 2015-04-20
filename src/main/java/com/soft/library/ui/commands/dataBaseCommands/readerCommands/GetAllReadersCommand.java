package com.soft.library.ui.commands.dataBaseCommands.readerCommands;

import com.soft.library.dataBase.service.AdvReaderService;
import com.soft.library.ui.commandCore.Command;

/**
 * Created by Oleg on 09.04.2015.
 */
public class GetAllReadersCommand implements Command {
    @Override
    public void execute() {
        new AdvReaderService().printReaders();
    }

    @Override
    public String getName() {
        return "Get all readers";
    }
}
