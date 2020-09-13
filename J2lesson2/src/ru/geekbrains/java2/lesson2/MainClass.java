package ru.geekbrains.java2.lesson2;

import java.util.Arrays;

public class MainClass {
    /*
    1. Есть строка вида: "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0"; (другими словами матрица 4x4).
    Написать метод, на вход которого подаётся такая строка, метод должен преобразовать строку
    в двумерный массив типа String[][];
     */

    /*
    2. Преобразовать все элементы массива в числа типа int, просуммировать, поделить полученную
    сумму на 2, и вернуть результат;
     */

    /*
    3. Ваши методы должны бросить исключения в случаях:
    Если размер матрицы, полученной из строки, не равен 4x4;
    Если в одной из ячеек полученной матрицы не число; (например символ или слово)
     */

    /*
    4. В методе main необходимо вызвать полученные методы, обработать возможные исключения и вывести
    результат расчета.
     */

    /*
    5. * Написать собственные классы исключений для каждого из случаев
     */
    static String[][] convertResult;

    public static void main(String[] args){
        String str = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
            try {
                convertResult = convertTpArray(str);
                showArray(convertResult);
                int task2 = calculate(convertResult);
                System.out.println(task2);
            } catch (IndexOutOfBoundsException e){
                e.printStackTrace();
            } catch (NumberFormatException e){
                e.printStackTrace();
            }
    }

    private static String[][] convertTpArray(String originalString) throws IndexOutOfBoundsException{
        String[] stringArrayX = originalString.split("\n");
        String[] stringArrayY = stringArrayX[0].split(" ");
        int countX = stringArrayX.length;
        int countY = stringArrayY.length;
        if(countY != countX)
            throw new notSquareArrayException("not square array exception", countX,countY);
        String[][] result = new String[countX][countY];
        String[] stringArray = new String[countY];
        for (int x = 0; x < countX; x++){
            stringArray = stringArrayX[x].split(" ");
            for (int y = 0; y < countY; y++){
                result[x][y] = stringArray[y];
            }
        }
        return result;
    }

    private static int calculate(String[][] array) throws IndexOutOfBoundsException, NumberFormatException{
        int x = array.length;
        int y = array[0].length;
        int res = 0;
        for (int i = 0; i < x; i++){
            for (int z = 0; z < y; z++){
                res+=Integer.parseInt(array[i][z]);
            }
        }
        res /= 2;
        return res;
    }

    private static void showArray (String[][] array) throws IndexOutOfBoundsException{
        for (int i = 0; i < array.length; i++){
            for (int z = 0; z < array[i].length; z++) {
                System.out.print(array[i][z] + " ");
            }
            System.out.println();
        }
    }



}
