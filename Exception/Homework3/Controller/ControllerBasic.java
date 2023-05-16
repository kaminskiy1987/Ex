package Homework3.Controller;

import java.util.ArrayList;

import Homework3.Model.Interfaces.IChecker;
import Homework3.Model.Interfaces.IConsoleReader;
import Homework3.Model.Interfaces.IDataCreator;
import Homework3.Model.Interfaces.IParser;
import Homework3.Model.Interfaces.IWriter;
import Homework3.View.IView;

public class ControllerBasic implements IController {
    IChecker checker;
    IConsoleReader consoleReader;
    IView view;
    IParser parser;
    IWriter writer;
    IDataCreator dataCreator;

    public ControllerBasic(IChecker checker, IConsoleReader consoleReader, IView view, IParser parser, IWriter writer,
            IDataCreator dataCreator) {
        this.checker = checker;
        this.consoleReader = consoleReader;
        this.view = view;
        this.parser = parser;
        this.writer = writer;
        this.dataCreator = dataCreator;
    }

    @Override
    public void runAlgorithm() {
        String menu = "\nВведите данные:\n"
                + "Фамилия Имя Отчество датарождения(dd.mm.yyyy) номертелефона(9 цифр) пол(m - муж, f - жен)\n"
                + "Пример формата ввода данных:"
                + "Иванов Иван Иванович 20.02.2012 9261234567 m\n"
                + "Или введите X для выхода";
        while (true) {
            view.showText(menu);
            try {
                String answerString = consoleReader.getStringFromConsole();
                if (answerString.equals("X"))
                    return;
                else {
                    String[] data = parser.parseOfData(answerString, " ");
                    int choice = checker.checkCountOfData(data, 6);
                    switch (choice) {
                        case 0:
                            checker.checkData(data);
                            String path = "HomeWork003/DataBase/" + data[0] + ".txt";
                            writer.WriteInFile(path, dataCreator.createStringData(data));
                            view.showText("Данные успешно добавлены");
                            break;
                        case -1:
                            view.showText("Ошибка:\nКоличество переданных значение меньше требуемого");
                            break;
                        case 1:
                            view.showText("Ошибка:\nКоличество переданных значение больше требуемого");
                            break;
                    }
                }
            } catch (Exception e) {
                view.showText("Ошибка:\n" + e.getMessage());
            }
        }
    }
}