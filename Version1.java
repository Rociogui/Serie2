/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.serie2;

/**
 *
 * @author Rocio Lopez
 */
public class Version1 {
    

    // Caracteres permitidos para generar contraseñas
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?";

    // Método para generar una contraseña aleatoria con los requisitos por defecto
    public static String generatePassword() {
        return generatePassword(8, true, true, true, true);
    }

    // Método para generar una contraseña aleatoria con requisitos personalizables
    public static String generatePassword(int length, boolean includeLowercase, boolean includeUppercase, boolean includeNumbers, boolean includeSpecialChars) {
        // Verifica que al menos un tipo de carácter esté habilitado
        if (!includeLowercase && !includeUppercase && !includeNumbers && !includeSpecialChars) {
            throw new IllegalArgumentException("Debe habilitar al menos un tipo de carácter en la contraseña.");
        }

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();
        String allCharacters = "";

        if (includeLowercase) {
            allCharacters += LOWERCASE_LETTERS;
            password.append(LOWERCASE_LETTERS.charAt(random.nextInt(LOWERCASE_LETTERS.length())));
        }
        if (includeUppercase) {
            allCharacters += UPPERCASE_LETTERS;
            password.append(UPPERCASE_LETTERS.charAt(random.nextInt(UPPERCASE_LETTERS.length())));
        }
        if (includeNumbers) {
            allCharacters += NUMBERS;
            password.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
        }
        if (includeSpecialChars) {
            allCharacters += SPECIAL_CHARACTERS;
            password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));
        }

        for (int i = password.length(); i < length; i++) {
            password.append(allCharacters.charAt(random.nextInt(allCharacters.length())));
        }

        // Mezcla los caracteres de la contraseña de manera aleatoria
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
        String defaultPassword = Version1.generatePassword();
        String customPassword = Version1.generatePassword(12, true, true, true, false);

        System.out.println("Contraseña por defecto: " + defaultPassword);
        System.out.println("Contraseña personalizada: " + customPassword);
    }
}

    