package Homework3.Model;

import java.io.FileWriter;
import java.io.IOException;

import Homework3.Model.Interfaces.IWriter;

public class Writer implements IWriter {
    public void WriteInFile(String path, String result) throws IOException {
        try (FileWriter fileWriter = new FileWriter(path, true)) {
            fileWriter.write(result);
        } catch (IOException ex) {
            throw ex;
        }
    }
}