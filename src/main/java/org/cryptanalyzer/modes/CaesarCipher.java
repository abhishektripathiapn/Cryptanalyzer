package org.cryptanalyzer.modes;

import java.io.*;
import java.nio.file.Path;

public class CaesarCipher extends CryptanalysisMode{

    public CaesarCipher(String sourceFile) {
        super(sourceFile);
    }
    @Override
    public void encrypt(int key) {
        String sourceFile = this.getSourceFile();
        String destinationFile = "D:\\AbhiProject\\Cryptanalyzer\\src\\main\\java\\org\\cryptanalyzer\\files\\ResultingFile.txt";
        //Reading data from source provided by the user and writing it in the destination file.
        try(FileReader fileReader = new FileReader(sourceFile);
            FileWriter fileWriter = new FileWriter(destinationFile))
        {
            int data;
            while ((data = fileReader.read()) != -1)
            {
                fileWriter.write((char) (data + key));
            }
            System.out.println("Your data is encrypted. You can check in:- " + Path.of(destinationFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void decrypt(int key) {
        String sourceFile = this.getSourceFile();
        String destinationFile = "D:\\AbhiProject\\Cryptanalyzer\\src\\main\\java\\org\\cryptanalyzer\\files\\ResultingFile.txt";
        //Reading data from source provided by the user and writing it in the destination file.
        try(FileReader fileReader = new FileReader(sourceFile);
            FileWriter fileWriter = new FileWriter(destinationFile))
        {
            int data;
            while ((data = fileReader.read()) != -1)
            {
                fileWriter.write((char) (data - key));
            }
            System.out.println("Your data is encrypted. You can check in:- " + Path.of(destinationFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
