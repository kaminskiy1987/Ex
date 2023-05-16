package Homework3.Model.Interfaces;

import java.io.IOException;

public interface IWriter {
    public void WriteInFile(String path, String result) throws IOException;
}