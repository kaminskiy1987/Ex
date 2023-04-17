package HomeWork2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task1 {
    public static void main(String[] args) {
        boolean isCheck = true;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (isCheck) {
            System.out.print("Введите дробное число: ");
            try {
                float floatNumber = Float.parseFloat(reader.readLine());
                System.out.printf("Введенное число равно %f\n", floatNumber);

                isCheck = false;
            } catch (IOException | NumberFormatException e) {
                System.out.println("Неверный ввод. Введите дробное число!");
            }
        }
    }
}