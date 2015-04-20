package com.soft.library.ui.commands.dataBaseCommands.readerCommands;

import com.soft.library.dataBase.service.ReaderService;
import com.soft.library.dataBase.service.ValidData;
import com.soft.library.ui.commandCore.Command;

/**
 * Created by Oleg on 09.04.2015.
 */
public class UpdateReaderNameCommand implements Command {
    @Override
    public void execute() {
        String oldFirstName, newFirstName, oldSecName, newSecName;

        System.out.println("Type in Reader's old First name: ");
        oldFirstName = ValidData.getWords();
        System.out.println("Type in Reader's new First name: ");
        newFirstName = ValidData.getWords();
        System.out.println("Type in Reader's old Second name: ");
        oldSecName = ValidData.getWords();
        System.out.println("Type in Reader's new Second name: ");
        newSecName = ValidData.getWords();

        new ReaderService().updateReaderName(oldFirstName, newFirstName,
                oldSecName, newSecName);
    }

    @Override
    public String getName() {
        return "Update an reader's name";
    }
}
