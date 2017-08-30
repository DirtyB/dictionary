package com.boristolstukha.dictionary.client.commands;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.OutputStream;
import java.io.PrintStream;

public abstract class AbstractCommand implements Command{

    protected Log logger = LogFactory.getLog(this.getClass());

    protected PrintStream outputStream = System.out;

    @Override
    public void setOutputStream(OutputStream outputStream){
        this.outputStream = new PrintStream(outputStream);
    }

}
