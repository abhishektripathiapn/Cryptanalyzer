package org.cryptanalyzer;

import org.cryptanalyzer.Exceptions.IllegalMethodException;
import org.cryptanalyzer.modes.BruteForce;
import org.cryptanalyzer.modes.CaesarCipher;
import org.cryptanalyzer.modes.CryptanalysisMode;
import org.cryptanalyzer.modes.Substitution;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, IllegalMethodException {
        Scanner scanner = new Scanner(System.in);
        //Taking file path as a input
        System.out.println("Hello, this is a program for 'Cryptanalysis'.");
        System.out.print("Please enter your .txt file's Absolute Path:- ");
        String sourceFile = scanner.nextLine();

        System.out.println("Which of the following techniques you want to use (1-3):-\n1. Substitution\n2. BruteForce\n3. CaesarCipher");
        int optionSelected = scanner.nextByte();
        scanner.nextLine(); //to consume the nextLine character
        //Creating object of the different cryptanalysis method
        CryptanalysisMode method;
         method = switch (optionSelected){
             case 1 -> new Substitution(sourceFile);
             case 2 -> new BruteForce(sourceFile);
             case 3 -> new CaesarCipher(sourceFile);
             default -> throw new IllegalMethodException("Illegal method selected " + optionSelected + " it must be in range (inclusive) 1-3.");
        };

        System.out.println("What do you want to do?(1 or 2)\n1. Encrypt \n2. Decrypt");
        byte mode = scanner.nextByte();
        scanner.nextLine();

        switch (mode){
            case 1 -> method.encrypt(sourceFile);
            case 2 -> method.decrypt(sourceFile);
            default -> throw new IllegalMethodException("Illegal mode " + mode + " selected it must be 1 or 2.");
        }

        String destinationFile = "D:\\AbhiProject\\Cryptanalyzer\\src\\main\\java\\org\\cryptanalyzer\\files\\TextToEncrypt.txt";


    }
}
