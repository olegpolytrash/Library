/**
 * 
 */
package com.soft.library.dataBase.service;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @author rd
 *
 */
public class ValidData {

    /**
     * Return String from user input which contains only symbols and spaces, and
     * is at lest 3 symbols long,
     *
     */
    @SuppressWarnings("resource")
    public static String getWords() {

        String regx = "^[a-zA-Z\\s]{3,}$";
        Scanner sc = new Scanner(System.in);
        String result = "";

        while (!(Pattern.matches(regx, result = sc.nextLine()))) {
            System.out.println("Try again");
        }
        return result.trim();

    }

    /**
     * Return String from user input which contains only one digit,
     *
     */
    @SuppressWarnings("resource")
    public static int getDigit() {
        String regx = "^\\s*\\d{1}\\s*$";
        Scanner sc = new Scanner(System.in);
        String result = "";

        while (!(Pattern.matches(regx, result = sc.nextLine()))) {
            System.out.println("Try again");
        }
        return Integer.parseInt(result.trim());
    }

    public static Set<String> continiouslyTyping(String helloMessage) {
        Set<String> names = new HashSet<String>();
        String temp = ValidData.getWords();

        while (!(temp.equalsIgnoreCase("exit")) || names.size() == 0) {
            System.out.println(helloMessage);
            temp = ValidData.getWords();
            if (!(temp.equalsIgnoreCase("exit"))) {
                names.add(temp);
            }
        }
        return names;
    }
}
