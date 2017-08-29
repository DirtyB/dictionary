package com.boristolstukha.dictionary.client.commands;

public class HelpCommand extends AbstractCommand {

    String[] lines =
    {
            "использование: java -jar dictionary-client.jar <хост>[:<порт>] <команда> <слово> [значения]",
            "",
            "get <слово>                                   возвращает значения слова",
            "add <слово> <значение1> [<значение2> ...]     добавляет в словарь указанные значения слова, сохраняя при это старые",
            "delete <слово> <значение1> [<значение2> ...]  удаляет из словаря указанные значения слова",
            ""
    };

    @Override
    public void run() throws Exception {
        for (String line: lines){
            outputStream.println(line);
        }
    }
}
