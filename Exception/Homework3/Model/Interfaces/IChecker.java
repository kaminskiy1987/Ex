package Homework3.Model.Interfaces;

public interface IChecker {
    public int checkCountOfData(String[] data, int correctValue);

    public boolean checkData(String[] data) throws Exception;
}