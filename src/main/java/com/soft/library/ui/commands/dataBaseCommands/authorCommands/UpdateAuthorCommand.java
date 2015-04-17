package com.soft.library.ui.commands.dataBaseCommands.authorCommands;

import com.soft.library.ui.commandCore.Command;

/**
 * Created by Oleg on 09.04.2015.
 */
public class UpdateAuthorCommand implements Command {
    @Override
    public void execute() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Type in Author's old name, new name: ");
//        String newName = scanner.nextLine();
//        String oldName = newName.substring(0, newName.indexOf(','));
//        newName = newName.substring(newName.indexOf(' ')).trim();
//        AdvAuthorService.updateAuthors(oldName, newName);
    }

    @Override
    public String getName() {
        return "Update an author";
    }
}
