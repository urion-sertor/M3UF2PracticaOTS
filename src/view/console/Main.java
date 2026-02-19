package view.console;

import java.util.Scanner;
import model.validations.UserDataValidations;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author orioltorsan
 */
public class Main {

    static Scanner sc = new Scanner(System.in);
    static UserDataValidations uv = new UserDataValidations();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        System.out.println("Menu: ");
        System.out.println("1 - Check ID");
        System.out.println("2 - Check Format Date");
        System.out.println("3 - Calculate Age");
        System.out.println("4 - Check Postal Code");
        System.out.println("5 - Is Numeric");
        System.out.println("6 - Is Alphabetic");
        System.out.println("7 - Check Email");
        System.out.println("8 - Check Name");
        System.out.print("Enter an option: ");

        int option = sc.nextInt();
        sc.nextLine();

        switch (option) {
            case 1:
                System.out.println("");
                break;
            case 2:
                System.out.println("");
                break;
            case 3:
                System.out.println("");
                break;
            case 4:
                System.out.println("");
                break;
            case 5:
                System.out.println("");
                break;
            case 6:
                System.out.println("");
                break;
            case 7:
                System.out.println("");
                break;
            case 8:
                System.out.println("");
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
    }

}
