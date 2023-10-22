package org.cryptanalyzer.modes;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Substitution extends CryptanalysisMode{
    private final String ALPHABET;
    private final String SUBSTITUTION;
    private final Map<Character,Character> ENCODE_MAP;
    private final Map<Character,Character> DECODE_MAP;
    //whenever the object of Substitution class is created this block will be executed before the object creation;
    {
        ALPHABET = " .abcdefghijklmnopqrstuvwxyz,ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        SUBSTITUTION = "MNBVCXZLKJHGFDSAQWERTYUIOP .,lkjhgfdsazxcvbnmpoiuytrewq";
        DECODE_MAP = new HashMap<>();
        ENCODE_MAP = new HashMap<>();
        for (int i = 0; i < ALPHABET.length(); i++) {
            ENCODE_MAP.put(ALPHABET.charAt(i),SUBSTITUTION.charAt(i));
            DECODE_MAP.put(SUBSTITUTION.charAt(i),ALPHABET.charAt(i));
        }
    }
    public Substitution(String sourceFile) {
        super(sourceFile);
    }

    @Override
    public void encrypt(int key) {
        String sourceFile = getSourceFile();
        String resultingFile = "D:\\AbhiProject\\Cryptanalyzer\\src\\main\\java\\org\\cryptanalyzer\\files\\ResultingFile.txt";

        try(FileReader fileReader = new FileReader(sourceFile);
            FileWriter writer = new FileWriter(resultingFile)){
            int i = 0;
            while((i = fileReader.read()) != -1 ){
                char iTochar = (char) i;
                // decode the message by putting the replacement character in place of the original character
                char characterInFile = ENCODE_MAP.containsKey(iTochar)? ENCODE_MAP.get(iTochar) : iTochar;
                writer.write(characterInFile);
            }
            System.out.println("Your data is encrypted. You can check in:- " + Path.of(resultingFile));
        }catch (IOException e){
          throw new RuntimeException();
        }
    }

    @Override
    public void decrypt(int key) {
        String sourceFile = getSourceFile();
        String resultingFile = "D:\\AbhiProject\\Cryptanalyzer\\src\\main\\java\\org\\cryptanalyzer\\files\\ResultingFile.txt";

        try(FileReader fileReader = new FileReader(sourceFile);
            FileWriter writer = new FileWriter(resultingFile)){
            int i = 0;
            while((i = fileReader.read()) != -1 ){
                char iTochar = (char) i;
                // decode the message by putting the replacement character in place of the original character
                char characterInFile = DECODE_MAP.containsKey(iTochar)? DECODE_MAP.get(iTochar) : iTochar;
                writer.write(characterInFile);
            }
            System.out.println("Your data is decrypted. You can check in:- " + Path.of(resultingFile));
        }catch (IOException e){
            throw new RuntimeException();
        }
    }

}
