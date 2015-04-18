package com.soft.library.ui.commands.dataBaseCommands.authorCommands;

import com.soft.library.dataBase.service.AdvAuthorService;
import com.soft.library.dataBase.service.ValidData;
import com.soft.library.ui.commandCore.Command;

/**
 * Created by Oleg on 09.04.2015.
 */
public class UpdateAuthorCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Type in Author's old name: ");
        String oldName = ValidData.getWords();
        System.out.println("Type in Author's new name: ");
        String newName = ValidData.getWords();
        new AdvAuthorService().updateAuthors(oldName, newName);
        
    }

    @Override
    public String getName() {
        return "Update an author";
    }
}
