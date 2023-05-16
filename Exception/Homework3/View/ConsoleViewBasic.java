package Homework3.View;

public class ConsoleViewBasic implements IView {

    @Override
    public void showText(String text) {
        System.out.println(text);
    }

}