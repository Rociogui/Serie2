/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.serie2;

/**
 *
 * @author Rocio Lopez
 */
public class Version2 {

    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?";

    public static String generatePassword(int config, boolean par1, boolean par2, boolean par3, boolean par4) {
        if (config.isRestrictMinDigits()) {
            // Si restrictMinDigits es verdadero, usamos las políticas personalizadas
            return generateCustomPassword(config);
        } else {
            // Si restrictMinDigits es falso, usamos las políticas por defecto (Versión 1)
            return generateDefaultPassword();
        }
    }

    private static String generateDefaultPassword() {
        return generatePassword(8, true, true, true, true);
    }

    private static String generateCustomPassword(PasswordConfigDTO config) {
        if (config.getMinLength() < 8) {
            throw new IllegalArgumentException("La longitud mínima debe ser al menos 8.");
        }

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();
        String allCharacters = "";

        if (config.isRestrictMinLowerCaseLetters()) {
            allCharacters += LOWERCASE_LETTERS;
            password.append(LOWERCASE_LETTERS.charAt(random.nextInt(LOWERCASE_LETTERS.length())));
        }
        if (config.isRestrictMinUpperCaseLetters()) {
            allCharacters += UPPERCASE_LETTERS;
            password.append(UPPERCASE_LETTERS.charAt(random.nextInt(UPPERCASE_LETTERS.length())));
        }
        if (config.isRestrictMinDigits()) {
            allCharacters += NUMBERS;
            password.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
        }
        if (config.isRestrictMinNonAlphanumericCharacters()) {
            allCharacters += SPECIAL_CHARACTERS;
            password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));
        }

        for (int i = password.length(); i < config.getMinLength(); i++) {
            password.append(allCharacters.charAt(random.nextInt(allCharacters.length())));
        }

        char[] passwordArray = password.toString().toCharArray();
        for (int i = 0; i < passwordArray.length; i++) {
            int index = random.nextInt(passwordArray.length);
            char temp = passwordArray[i];
            passwordArray[i] = passwordArray[index];
            passwordArray[index] = temp;
        }

        return new String(passwordArray);
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        PasswordConfigDTO config = new PasswordConfigDTO(true, 3, true, 2, true, 2, true, 1, 12);
        String customPassword = Version2.generatePassword(config, true, true, true, true);

        System.out.println("Contraseña personalizada: " + customPassword);
    }

        private static String generatePassword(PasswordConfigDTO config, boolean b, boolean b0, boolean b1, boolean b2) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private static String generateCustomPassword(int config) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }

   
