public class ArrayDiff {

    public static void main(String[] args) {
        getArray();
    }

    /**
     Задача.
     Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
     и возвращающий новый массив,
     каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке.
     Если длины массивов не равны, необходимо как-то оповестить пользователя.
     */
    static void getArray() {
        try {
            int[] result = getDiffArray(new int[]{1, -2, 9, 1}, new int[]{5, 2, 0, 1});

            System.out.println("Разность элементов двух массивов");

            for (int е : result) {
                System.out.printf("%d \t", е);
            }

            System.out.println();

        } catch (CustomArraySizeException а) {
            System.out.println(а.getMessage());
            System.out.printf("Длина первого массива: %d\nДлина второго массива: %d\n", а.getLength1(), а.getLength2());
        }
    }

    /**
     Метод проверяет массивы на null
     проверяет равны ли длины массивов
     вычесляет разность двух массивов
     * @param array1 Первый массив
     * @param array2 Второй массив
     * @return Результат разности элементов двух массивов
     */
    static int[] getDiffArray(int[] array1, int[] array2) {
        if (array1 == null || array2 == null) {
            throw new NullPointerException("Оба массива должны существовать.");
        }

        if (array1.length != array2.length) {
            throw new CustomArraySizeException("Кол-во элементов массива должно быть одинаково.", array1.length, array2.length);
        }

        int[] res = new int[array1.length];

        for (int i = 0; i < array1.length; i++) {
            res[i] = array1[i] - array2[i];
        }

        return res;
    }
}

/**
 Свой класс обработки ошибок связанных с размером массива наследуемый от RuntimeException
 */
class CustomArraySizeException extends RuntimeException {

    int length1;
    int length2;

    /**
     @return возвращает значение поля length1
     */
    public int getLength1() {
        return length1;
    }

    /**
     @return возвращает значение поля length2
     */
    public int getLength2() {
        return length2;
    }

    /**
     Конструктор для расширения конструктора по умолчанию, для того чтоб передать в исключении
     дополнительные данные
     @param message Описание ошибки
     @param length1 Длина первого массива
     @param length2 Длина второго массива
     */
    public CustomArraySizeException(String message, int length1, int length2) {
        super(message);
        this.length1 = length1;
        this.length2 = length2;
    }
}