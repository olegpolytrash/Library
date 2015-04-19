package com.soft.library.ui.commands.dataBaseCommands.readerCommands;

import com.soft.library.dataBase.service.AdvReaderService;
import com.soft.library.dataBase.service.ValidData;
import com.soft.library.ui.commandCore.Command;

public class UpdateReaderBDateCommand implements Command{

    @Override
    public void execute() {
        String oldBDate, newBDate;

        System.out.println("Type in Reader's old birth date: ");
        oldBDate = ValidData.getWords();
        System.out.println("Type in Reader's new birth date: ");
        newBDate = ValidData.getWords();

        new AdvReaderService().updateReaderBDate(oldBDate, newBDate);
    }

    @Override
    public String getName() {
        return "Update reader's birth date";
    }
}
