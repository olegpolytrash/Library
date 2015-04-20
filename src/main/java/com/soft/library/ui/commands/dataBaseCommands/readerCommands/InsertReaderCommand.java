package com.soft.library.ui.commands.dataBaseCommands.readerCommands;

import java.sql.Date;
import java.util.Scanner;

import com.soft.library.dataBase.service.ReaderService;
import com.soft.library.dataBase.service.ValidData;
import com.soft.library.ui.commandCore.Command;

/**
 * Created by Oleg on 09.04.2015.
 */
public class InsertReaderCommand implements Command {

    @Override
    public void execute() {
        
        ReaderService aas = new ReaderService();
        String firstName, secName, mobile, address;
        Date birthDate;

        System.out.println("Type in Reader's first name: ");
        firstName = ValidData.getWords();
        System.out.println("Type in Reader's surname: ");
        secName = ValidData.getWords();
        System.out.println("Type in Reader's mobile: ");
        mobile = Integer.toString(ValidData.getDigit());
        System.out.println("Type in Reader's address: ");
        address = ValidData.getWords();
        
        //representing a date in in the format "yyyy-[m]m-[d]d"
        System.out.println("Type in Reader's birth date: ");
        birthDate = Date.valueOf((new Scanner(System.in)).nextLine());
        
        aas.addReader(firstName, secName, mobile, address, birthDate);
    }

    @Override
    public String getName() {
        return "Insert an reader";
    }
}
