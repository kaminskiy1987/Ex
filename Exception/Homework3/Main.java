package Homework3;

import Homework3.Controller.ControllerBasic;
import Homework3.Controller.IController;
import Homework3.Model.Checker;
import Homework3.Model.ConsoleReaderBasic;
import Homework3.Model.DataCreatorBasic;
import Homework3.Model.ParserBasic;
import Homework3.Model.Writer;
import Homework3.Model.Interfaces.IChecker;
import Homework3.Model.Interfaces.IConsoleReader;
import Homework3.Model.Interfaces.IDataCreator;
import Homework3.Model.Interfaces.IParser;
import Homework3.Model.Interfaces.IWriter;
import Homework3.View.ConsoleViewBasic;
import Homework3.View.IView;

public class Main {
    public static void main(String[] args) {
        IParser parser = new ParserBasic();
        IConsoleReader consoleReader = new ConsoleReaderBasic();
        IView view = new ConsoleViewBasic();
        IChecker checker = new Checker(parser);
        IWriter writer = new Writer();
        IDataCreator dataCreator = new DataCreatorBasic();
        IController controller = new ControllerBasic(checker, consoleReader, view, parser, writer, dataCreator);

        controller.runAlgorithm();
    }
}