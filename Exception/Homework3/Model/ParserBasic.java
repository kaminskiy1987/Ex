package Homework3.Model;

import java.util.ArrayList;

import Homework3.Model.Interfaces.IParser;

public class ParserBasic implements IParser {

    @Override
    public String[] parseOfData(String data, String chars) {
        String[] arrayData = data.split(chars);
        return arrayData;
    }

}