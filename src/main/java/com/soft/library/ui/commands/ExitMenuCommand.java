package com.soft.library.ui.commands;

import com.soft.library.ui.commandCore.Command;

/**
 * Command for exiting from a menu.
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
