package Homework3.Model;

import Homework3.Model.Interfaces.IChecker;
import Homework3.Model.Interfaces.IParser;

public class Checker implements IChecker {
    IParser parser;

    public Checker(IParser parser) {
        this.parser = parser;
    }

    @Override
    public int checkCountOfData(String[] data, int correctValue) {
        int size = data.length;
        if (size == correctValue) {
            return 0;
        } else if (size > correctValue) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public boolean checkData(String[] data) throws Exception {
        for (int i = 0; i < 3; i++)
            if (!checkName(data[i]))
                throw new Exception("Недопустимое значение ФИО");
        checkDate(data[3]);
        checkPhoneNumber(data[4]);
        checkSex(data[5]);
        return true;
    }

    private boolean checkName(String name) {
        return name != null && !name.chars().anyMatch(Character::isDigit);
    }

    private boolean checkDate(String date) throws Exception {
        System.out.println(date);
        if (date == null)
            throw new NullPointerException();
        date = date.replace(".", "/");
        String[] arrayDate = parser.parseOfData(date, "/");
        System.out.println(arrayDate.length);
        if (checkCountOfData(arrayDate, 3) != 0)
            throw new Exception("Неверный формат даты рождения");
        if (!checkRange(arrayDate[0], 1, 31))
            throw new Exception("Недопустимое значение дня рождения");
        if (!checkRange(arrayDate[1], 1, 12))
            throw new Exception("Недопустимое значение месяца рождения");
        if (!checkRange(arrayDate[2], 1900, 2023))
            throw new Exception("Недопустимое значение года рождения");

        String[] temp = parser.parseOfData(arrayDate[0], "");
        if (checkCountOfData(temp, 2) != 0)
            throw new Exception("Недопустимое значение дня рождения");

        temp = parser.parseOfData(arrayDate[1], "");
        if (checkCountOfData(temp, 2) != 0)
            throw new Exception("Недопустимое значение месяца рождения");

        return true;
    }

    private boolean checkPhoneNumber(String phoneNumber) throws Exception {
        if (!phoneNumber.chars().allMatch(Character::isDigit))
            throw new Exception("Неверный формат номера телефона");
        String[] arrayDate = parser.parseOfData(phoneNumber, "");
        if (checkCountOfData(arrayDate, 10) != 0)
            throw new Exception("Неверный формат номера телефона");
        return true;
    }

    private boolean checkSex(String sex) throws Exception {
        if (sex.equals("m") || sex.equals("f"))
            return true;
        throw new Exception("Некорректное значение пола");
    }

    private boolean checkRange(String value, int min, int max) {
        if (!value.chars().allMatch(Character::isDigit))
            return false;
        int number = Integer.parseInt(value);
        if (number >= min && number <= max)
            return true;
        else
            return false;
    }
}