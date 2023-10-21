package org.cryptanalyzer.modes;

public class BruteForce extends CryptanalysisMode{
    public BruteForce(String sourceFile) {
        super(sourceFile);
    }

    @Override
    public void encrypt(int key) {
        System.out.println("encryption not allowed in Brute Force mode.");
    }

    @Override
    public void decrypt(int key) {

    }
}
