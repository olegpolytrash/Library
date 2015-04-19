package com.soft.library.ui.commands.dataBaseCommands.readerCommands;

import com.soft.library.dataBase.service.AdvReaderService;
import com.soft.library.dataBase.service.ValidData;
import com.soft.library.ui.commandCore.Command;

public class UpdateReaderMobileCommand implements Command {

    @Override
    public void execute() {
        String oldMobile, newMobile;

        System.out.println("Type in Reader's old mobile: ");
        oldMobile = ValidData.getWords();
        System.out.println("Type in Reader's new mobile: ");
        newMobile = ValidData.getWords();

        new AdvReaderService().updateReaderMobile(oldMobile, newMobile);
    }

    @Override
    public String getName() {
        return "Update an reader's mobile";
    }
}
