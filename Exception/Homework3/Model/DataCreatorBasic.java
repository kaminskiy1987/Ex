package Homework3.Model;

import Homework3.Model.Interfaces.IDataCreator;

public class DataCreatorBasic implements IDataCreator {

    @Override
    public String createStringData(String[] arrayData) {
        String string = "";
        for (String s : arrayData) {
            string += "<" + s + ">";
        }
        return string + "\n";
    }

}