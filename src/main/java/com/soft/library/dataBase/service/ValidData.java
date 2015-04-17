/**
 * 
 */
package com.soft.library.dataBase.service;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author rd
 *
 */
public class ValidData {
    
    /**
     * Return String from user input which contains only symbols and spaces, 
     * and is at lest 3 symbols long,
     *
     */
    @SuppressWarnings("resource")
    public static String getString() {

        String regx = "^[a-zA-Z\\s]{3,}$";
        Scanner sc = new Scanner(System.in);
        String result = "";

        while (!(Pattern.matches(regx, result = sc.nextLine()))) {
            System.out.println("Try again");
        }
        return result;

    }
    /**
     * Return String from user input which contains only one digit, 
     *
     */
    @SuppressWarnings("resource")
    public static int getInteger() {
        String regx = "^\\s*\\d{1}\\s*$";
        Scanner sc = new Scanner(System.in);
        String result = "";

        while (!(Pattern.matches(regx, result = sc.nextLine()))) {
            System.out.println("Try again");
        }
        return Integer.parseInt(result.trim());
    }
}
