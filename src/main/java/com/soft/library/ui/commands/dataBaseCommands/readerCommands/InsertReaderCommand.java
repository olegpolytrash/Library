package com.soft.library.ui.commands.dataBaseCommands.readerCommands;

//import java.sql.Date;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

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
        java.sql.Date birthDate;

        System.out.println("Type in Reader's first name: ");
//        firstName = ValidData.getWords();
        firstName = "rn1";
        System.out.println("Type in Reader's surname: ");
//        secName = ValidData.getWords();
        secName = "rs1";
        System.out.println("Type in Reader's mobile: ");
//        mobile = Integer.toString(ValidData.getDigit());
        mobile = "rmob";
        System.out.println("Type in Reader's address: ");
//        address = ValidData.getWords();
        address = "a1";
        System.out.println("Type in Reader's birth date: ");
        
        aas.addReader(firstName, secName, mobile, address, new Date(123123));
    }

    @Override
    public String getName() {
        return "Insert an reader";
    }
}
