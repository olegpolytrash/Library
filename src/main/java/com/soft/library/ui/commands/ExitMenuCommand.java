package com.soft.library.ui.commands;

import com.soft.library.ui.commandCore.Command;

/**
 * Created by Oleg on 09.04.2015.
 */
public class ExitMenuCommand implements Command {
    @Override
    public void execute() {
        // not needed for this class
    }

    @Override
    public String getName() {
        return "Exit menu";
    }
}
