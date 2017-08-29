package com.boristolstukha.dictionary.client.Commands;

import java.io.OutputStream;
import java.io.PrintStream;

public abstract class AbstractCommand implements Command{

    protected PrintStream outputStream = System.out;

    @Override
    public void setOutputStream(OutputStream outputStream){
        this.outputStream = new PrintStream(outputStream);
    }

}
