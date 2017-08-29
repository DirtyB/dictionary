package com.boristolstukha.dictionary.client.Commands;

import java.io.OutputStream;

public interface Command {

    void run() throws Exception;

    public void setOutputStream(OutputStream outputStream);

}
