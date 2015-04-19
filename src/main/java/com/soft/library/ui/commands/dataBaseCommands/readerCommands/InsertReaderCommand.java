package com.soft.library.ui.commands.dataBaseCommands.readerCommands;

import java.sql.Date;

import com.soft.library.dataBase.service.AdvReaderService;
import com.soft.library.dataBase.service.ValidData;
import com.soft.library.ui.commandCore.Command;

/**
 * Created by Oleg on 09.04.2015.
 */
public class InsertReaderCommand implements Command {

    @Override
    public void execute() {
        AdvReaderService aas = new AdvReaderService();
        String firstName, secName, mobile, address;
        Date birthDate;

        System.out.println("Type in Reader's first name: ");
        firstName = ValidData.getWords();
        System.out.println("Type in Reader's surname: ");
        secName = ValidData.getWords();
        System.out.println("Type in Reader's mobile: ");
        mobile = ValidData.getWords();
        System.out.println("Type in Reader's address: ");
        address = ValidData.getWords();
        System.out.println("Type in Reader's birth date: ");
        birthDate = Date.valueOf(ValidData.getWords());
        
        aas.addReader(firstName, secName, mobile, address, birthDate);
    }

    @Override
    public String getName() {
        return "Insert an reader";
    }
}
