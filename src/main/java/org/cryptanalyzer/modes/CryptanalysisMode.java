package org.cryptanalyzer.modes;

public abstract class CryptanalysisMode {
    private String sourceFile;
    public CryptanalysisMode(String sourceFile){
        this.sourceFile = sourceFile;
    }

    public abstract void encrypt(int key);

    public abstract void decrypt(int key);

    public String getSourceFile() {
        return sourceFile;
    }


}
