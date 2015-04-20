package com.soft.library.ui.commands.dataBaseCommands.readerCommands;

import com.soft.library.dataBase.service.ReaderService;
import com.soft.library.dataBase.service.ValidData;
import com.soft.library.ui.commandCore.Command;

/**
 * Created by Oleg on 09.04.2015.
 */
public class GetReaderByIdCommand implements Command {
    @Override
    public void execute() {
        ReaderService aas = new ReaderService();
        System.out.println("Enter id: ");
        int readerId = ValidData.getDigit();
        System.out.println(aas.getReaderById(readerId));
    }

    @Override
    public String getName() {
        return "Get reader by id";
    }
}
