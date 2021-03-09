package Java_2_AdvancedLevel.lesson2;

public class MainClass {
    public static void main(String[] args) {

        String[][] array1 = {
                {"12", "123", "23", "98"},
                {"17", "34", "6", "7"},
                {"16", "9", "8", "9"},
                {"167", "91", "81", "19"},
        };
        String[][] array2 = {
                {"12", "123", "23", "98"},
                {"34", "6", "7"},
                {"16", "9", "8", "9"},
                {"167", "19"},
        };
        String[][] array3 = {
                {"12", "ccd", "23", "98"},
                {"17", "34", "hdd", "7"},
                {"16", "9", "8", "9"},
                {"167", "91", "81", "19"},
        };

        System.out.println("Результат работы массива №1: ");
        try {
            stringToIntArray(array1);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        System.out.println("Результат работы массива №2: ");
        try {
            stringToIntArray(array2);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        System.out.println("Результат работы массива №3: ");
        try {
            stringToIntArray(array3);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void stringToIntArray(String[][] array) throws MyArrayDataException, MyArraySizeException{

        if (array.length != 4) throw new MyArraySizeException("Массив не соответствует размеру 4х4");
        for (String[] a : array) {
            if (a.length != 4) throw new MyArraySizeException("Массив не соответствует размеру 4х4");
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Нечисловое значение в ячейке - " + i + "*" + j );
                }
            }
        }
        System.out.println("Сумма элементов массива равна " + sum);
    }
}
