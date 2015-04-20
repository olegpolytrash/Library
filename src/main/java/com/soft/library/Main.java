package com.soft.library;

import com.soft.library.ui.menuCreators.MainMenu;

/**
 * Class for running application
 */
public class Main {
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        mainMenu.execute();
    }
}
