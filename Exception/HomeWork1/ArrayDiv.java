public class ArrayDiv {

    public static void main(String[] args) {
        getArray();
    }

    /**
     Задача.
     Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
     и возвращающий новый массив,
     каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке.
     Если длины массивов не равны,
     необходимо как-то оповестить пользователя.
     Важно: При выполнении метода единственное исключение,
     которое пользователь может увидеть - RuntimeException, т.е. ваше.
     */
    static void getArray() {
        double[] result = getDivideArray(new int[]{-6, 2, 9, 6}, new int[]{2, 2, 10, 4});

        System.out.println("Частное элементов двух массивов");

        for (double e : result) {
            System.out.printf("%s \t", e);
        }
    }

    /**
     Метод
     1) проверяет массивы на null
     2) проверяет равны ли длины массивов
     3) вычисляет разность двух массивов
     * @param array1 Первый массив
     * @param array2 Второй массив
     * @return Результат разности элементов двух массивов
     */
    static double[] getDivideArray(int[] array1, int[] array2) {
        if (array1 == null || array2 == null) {
            throw new RuntimeException("Оба массива должны существовать.");
        }

        if (array1.length != array2.length) {
            throw new RuntimeException(
                    String.format("Кол-во элементов массива должно быть одинаково.", array1.length, array2.length));
        }

        double[] result = new double[array1.length];

        for (int i = 0; i < array1.length; i++) {
            if (array2[i] == 0)
                throw new RuntimeException(
                        String.format("\n\nДелить на ноль нельзя!!!\nНоль в массиве 2, находится под индексом №: [%d]\n", i));
            result[i] = (double)array1[i] / array2[i];
        }

        return result;
    }
}