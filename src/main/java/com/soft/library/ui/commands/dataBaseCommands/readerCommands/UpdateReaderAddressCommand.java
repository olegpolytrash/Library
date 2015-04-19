package com.soft.library.ui.commands.dataBaseCommands.readerCommands;

import com.soft.library.dataBase.service.AdvReaderService;
import com.soft.library.dataBase.service.ValidData;
import com.soft.library.ui.commandCore.Command;

public class UpdateReaderAddressCommand implements Command {
    @Override
    public void execute() {
        String oldAddress, newAddress;

        System.out.println("Type in Reader's old address: ");
        oldAddress = ValidData.getWords();
        System.out.println("Type in Reader's new address: ");
        newAddress = ValidData.getWords();

        new AdvReaderService().updateReaderAddress(oldAddress, newAddress);
    }

    @Override
    public String getName() {
        return "Update an reader's address";
    }
}
