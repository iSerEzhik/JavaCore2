package lesson2;

import lesson2.exceptions.MyArrSizeExceptions;
import lesson2.exceptions.MyArrayDataException;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[][] first = new String[4][4];
        String[][] second = new String[5][5];
        try {
            checkArray(first);
        } catch (MyArrSizeExceptions myArrSizeExceptions) {
            myArrSizeExceptions.printStackTrace();
        }
        try {
            checkArray(second);
        } catch (MyArrSizeExceptions myArrSizeExceptions) {
            myArrSizeExceptions.printStackTrace();
        }
        first = setArray();
        outputArr(first);
        System.out.println();
        System.out.println("\n"+sumNumFromArr(first));
    }

    public static void checkArray(String[][] arrForCheck) throws MyArrSizeExceptions {
        if (arrForCheck[0].length * arrForCheck.length > 16) {
            throw new MyArrSizeExceptions();
        } else System.out.println("True!");
    }


    public static int sumNumFromArr(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    Integer num = Integer.valueOf(arr[i][j]);
                    sum += num;
                } catch (NumberFormatException e) {
                    try {
                        throw new MyArrayDataException("В ячейке ["+i+"]["+j+"] находится не число!!!");
                    } catch (MyArrayDataException dataException){
                        dataException.printStackTrace();
                    }

                }
            }
        }
        return sum;
    }

    public static String[][] setArray() {
        Random choice = new Random();
        String[][] arr = new String[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                switch (choice.nextInt(2)) {
                    case 0: {
                        arr[i][j]="";
                        for (int k = 0; k < 2; k++) {
                            arr[i][j] += "" + (char) ('a' + choice.nextInt(26));
                        }
                        break;
                    }
                    case 1: {
                        arr[i][j] = "" + (choice.nextInt(10));
                    }

                }
            }
        }
        return arr;
    }

    public static void outputArr(String[][] arrForOutput) {
        for (String[] line : arrForOutput) {
            System.out.println();
            for (String element : line) {
                System.out.print(element + " ");
            }
        }
    }

}
