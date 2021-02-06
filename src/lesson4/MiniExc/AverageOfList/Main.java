package lesson4.MiniExc.AverageOfList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {


    public static void main(String[] args) {
        AverageInterface myLambdaAverage = (List<Integer> list) -> {
            int sum = 0;
            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                sum += list.get(i).intValue();
                count++;
            }
            return (Double) ((double)sum / (double) count);
        };
        List<Integer> list;
        list = setList(15);
        outputList(list);
        System.out.println("Среднее значение списка: "+averageOfList(list, myLambdaAverage));

    }

    public static List<Integer> setList(int n) {
        Random num = new Random();
        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            newList.add(num.nextInt(25) + 1);
        }
        return newList;
    }

    public static void outputList(List<Integer> list) {
        System.out.println("Эллементы списка: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("------------------");
    }
    public static double averageOfList (List<Integer> list, AverageInterface lambda){
        return lambda.average(list);
    }
}
