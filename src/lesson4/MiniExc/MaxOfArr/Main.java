package lesson4.MiniExc.MaxOfArr;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        IsMore myMax = (Integer[] list)->{
            Integer max =list[0];
            for (int i = 1; i < list.length ; i++) {
                if (list[i]>max) max = list[i];
            }
            return max;
        };
        Random myRandom = new Random();
        Integer[] list = new Integer[5];
        for (int i = 0; i < list.length; i++) {
            list[i]=myRandom.nextInt(5);
            System.out.println(list[i]);
        }

        System.out.println("Максимальный элемент массива: "+findMax(myMax, list));
    }
    public static int findMax(IsMore lambda, Integer[] list){
        return lambda.findMax(list);
    }
}
