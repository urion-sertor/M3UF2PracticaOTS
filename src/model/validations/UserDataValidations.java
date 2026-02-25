/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.validations;

import java.util.Scanner;

/**
 *
 * @author orioltorsan
 */

// Hecho por Oriol Torres y Nil Borràs

public class UserDataValidations {

    /** 
     * 1. boolean checkId (int typeDoc, String id): Debe validar si el NIF (tipo de documento 1) recibido es correcto o no. 
     * Si es correcto retornará true, en caso contrario false. De momento si el tipo de documento es otro se devolverá false.
     * 
     * @param typeDoc, el tipo de documento del que se revisa el formato. El usuario lo escoge.
     * @param id, el número del documento. El usuario lo introduce.
     * @return si el número de documento concuerda con el formato que el tipo de documento establece.
     */
    public boolean checkId(int typeDoc, String id) {
        if (typeDoc != 1) {
            return false;
        }
        
        if (id.length() != 9) {
            return false;
        }
        
        String numbers = id.substring(0, 8);
        char letter = id.charAt(8);
        
        if (!isNumeric(numbers) || !isAlphabetic(String.valueOf(letter))) {
            return false;
        }
        
        return true;
    }

    /** 2. boolean checkFormatDate(String date): Debe validar que el formato de la fecha y su valor es correcto. 
     *  El formato esperado es “dd/mm”aaaa”. Si es correcto retornará true, en caso contrario false. 
     *  Usa la función split de la clase String.
     *
     *  @param date, una fecha introducida por el usuario.
     *  @return si la fecha introducida cumple el formato de fecha establecido.
     */
    public boolean checkFormatDate(String date) {
        String[] ddmmyy = date.split("/");

        if (ddmmyy.length != 3) {
            return false;
        }

        if (!isNumeric(ddmmyy[0]) || !isNumeric(ddmmyy[1]) || !isNumeric(ddmmyy[2])) {
            return false;
        }

        int day = Integer.parseInt(ddmmyy[0]);
        int month = Integer.parseInt(ddmmyy[1]);
        int year = Integer.parseInt(ddmmyy[2]);

        if (day < 1 || day > 31) {
            return false;
        }
        if (month < 1 || month > 12) {
            return false;
        }
        if (year < 1000 || year > 9999) {
            return false;
        }

        return true;
    }

    /**
     * 3. int calculateAge(String birthDate): Debe calcular la edad en base a la fecha de nacimiento. 
     * Previamente debe validarse que la fecha sea correcta. 
     * En caso de que la fecha sea coherente se devolverá la edad calculada, en caso contrario devolveremos -1.
     * 
     * @param birthDate, una fecha introducida por el usuario.
     * @return la edad tras restar el año actual al año de la fecha.
    */
    public int calculateAge(String birthDate) {
        if (checkFormatDate(birthDate) == false) {
            return -1;
        }

        String[] ddmmyy = birthDate.split("/");
        int yearBirth = Integer.parseInt(ddmmyy[2]);

        int yearCurrent = 2026;
        int age = yearCurrent - yearBirth;

        if (age < 0 || age > 120) {
            return -1;
        }

        return age;
    }

    /** 
     * 4. boolean checkPostalCode(String zip): Debe validar que el formato del código postal sea correcto. 
     * El formato esperado es nnnnn (5 números). Si es correcto retornará true, en caso contrario false. 
     * 
     * @param zip, el código postal.
     * @return si el número introducido cumple el formato de código postal.
     */
    public boolean checkPostalCode(String zip) {
        if (zip.length() != 5) {
            return false;
        }

        if (!isNumeric(zip)) {
            return false;
        }

        return true;
    }

    /**
     * 5. boolean isNumeric(String str): Debe Validar que el contenido del String es numérico. 
     * Si lo es retornará true, en caso contrario false. 
     * 
     * @param str, el String introducido por el usuario.
     * @return si el String introducido por el usuario cumple las condiciones de ser un número.
     */    
    public boolean isNumeric(String str) {
        if (str == null || str.equals("")) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c < '0' || c > '9') {
                return false;
            }
        }

        return true;
    }

    /**
     * 6. boolean isAlphabetic(String str): Debe Validar que el contenido del String solo tenga letras. 
     * Si es así retornará true, en caso contrario false. 
     * 
     * @param str, el String introducido pir el usuario.
     * @return si el String introducido por el ususario cumple las condiciones de ser una letra.
     */
    public boolean isAlphabetic(String str) {
        if (str == null || str.equals("")) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
                return false;
            }
        }

        return true;
    }
    
    /**
     * 7. boolean checkEmail(String email): Debe validar que el formato del correo se corresponde con un correo electronico (debe contener una @ y la terminación debe ser .com, .es, …). 
     * Si es correcto retornará true, en caso contrario false. 
     * 
     * @param email, el correo introducido por el usuario.
     * @return si el correo introducido cumple las condiciones de ser un correo.
     */
    public boolean checkEmail (String email) {
        if (!email.contains("@")) {
            return false;
        }
        
        if (!email.endsWith(".com") && !email.endsWith(".es") && !email.endsWith(".org") && !email.endsWith(".net")) {
            return false;
        }
        
        return true;
    }
    
    /**
     * 8. boolean checkName(String name): Debe validar que el nombre tiene una longitud lógica y que no contenga números. 
     * Si es correcto retornará true, en caso contrario false. 
     * 
     * @param name, que es el nombre introducido por el usuario.
     * @return si el nombre cumple las condiciones de ser un nombre.
     */
    public boolean checkName(String name) {
        if (!isAlphabetic(name)) {
            return false;
        }
        
        if (name.length() < 2 || name.length() > 50) {
            return false;
        }
        
        return true;
    }
}
