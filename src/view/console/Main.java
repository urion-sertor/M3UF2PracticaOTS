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
                System.out.println("Documents:");
                System.out.println("1 - NIF");
                System.out.print("Enter an option: ");
                int typeDoc = sc.nextInt();
                sc.nextLine();
                System.out.print("ID: ");
                String id = sc.nextLine();

                if (uv.checkId(typeDoc, id)) {
                    System.out.println("Correcto");
                } else {
                    System.out.println("Incorrecto");
                }
                break;
                
            case 2:
                System.out.print("Introduce una fecha (DD/MM/YYYY): ");
                String date = sc.nextLine();

                if (uv.checkFormatDate(date)) {
                    System.out.println("Correcto");
                } else {
                    System.out.println("Incorrecto");
                }
                break;
                
            case 3:
                System.out.print("Introduce la fecha de nacimiento: ");
                String birthDate = sc.nextLine();
                int age = uv.calculateAge(birthDate);

                if (age == -1) {
                    System.out.println("Fecha no válida");
                } else {
                    System.out.println("Tienes " + age + " anios.");
                }
                break;
                
            case 4:
                System.out.print("Introduce tu codigo postal: ");
                String zip = sc.nextLine();

                if (uv.checkPostalCode(zip)) {
                    System.out.println("Correcto");
                } else {
                    System.out.println("Incorrecto");
                }
                break;
                
            case 5:
                System.out.print("Introduce un numero: ");
                String strNumber = sc.nextLine();

                if (uv.isNumeric(strNumber)) {
                    System.out.println("Correcto");
                } else {
                    System.out.println("Incorrecto");
                }
                break;
                
            case 6:
                System.out.print("Introduce una letra: ");
                String strLetter = sc.nextLine();

                if (uv.isAlphabetic(strLetter)) {
                    System.out.println("Correcto");
                } else {
                    System.out.println("Incorrecto");
                }
                break;
                
            case 7:
                System.out.print("Introduce tu correo: ");
                String email = sc.nextLine();

                if (uv.checkEmail(email)) {
                    System.out.println("Correcto");
                } else {
                    System.out.println("Incorrecto");
                }
                break;
                
            case 8:
                System.out.print("Introduce tu nombre: ");
                String name = sc.nextLine();

                if (uv.checkName(name)) {
                    System.out.println("Correcto");
                } else {
                    System.out.println("Incorrecto");
                }
                break;

            default:
                System.out.println("Invalid option.");
                break;
        }
    }
}
