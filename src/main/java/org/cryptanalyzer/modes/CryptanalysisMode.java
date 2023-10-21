package org.cryptanalyzer.modes;

public abstract class CryptanalysisMode {
    String sourceFile;
    public abstract void encrypt(String sourceFile);
    public abstract void decrypt(String sourceFile);
}
