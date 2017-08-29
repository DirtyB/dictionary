package com.boristolstukha.dictionary.client.commands;

import java.io.OutputStream;

public interface Command {

    void run() throws Exception;

    public void setOutputStream(OutputStream outputStream);

}
