package Homework3.Model;

import java.util.Scanner;

import Homework3.Model.Interfaces.IConsoleReader;

public class ConsoleReaderBasic implements IConsoleReader {

    @Override
    public String getStringFromConsole() throws Exception {
        Scanner scanner = new Scanner(System.in, "Cp866");
        String str = scanner.nextLine();
        if (!str.equals("")) {
            return str;
        } else {
            throw new Exception("Вы ввели пустую строку");
        }
    }

}