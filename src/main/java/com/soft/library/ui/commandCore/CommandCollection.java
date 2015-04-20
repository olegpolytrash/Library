package com.soft.library.ui.commandCore;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Class for managing collections of commands.
 */
public class CommandCollection {
    private Map<Integer, MenuOption> menu = new TreeMap<>();

    public void addTask(MenuOption task) {
        menu.put(menu.size() + 1, task);
    }

    public Set<Map.Entry<Integer, MenuOption>> getCommands() {
        return menu.entrySet();
    }

    public int getSize() {
        return menu.entrySet().size();
    }

    public MenuOption getByIndex(int index) {
        return menu.get(index);
    }
}
