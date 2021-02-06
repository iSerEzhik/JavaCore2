package lesson4.MiniExc.Search;

import java.util.Random;

    public class Main {
        public static void main(String[] args) {
            Random myRandom = new Random();
            Integer[] list = new Integer[5];
            for (int i = 0; i < list.length; i++) {
                list[i]=myRandom.nextInt(5);
                System.out.println(list[i]);
            }
            System.out.println("Номер цифры <<3>> в массиве: "+search(3, list));
        }
        public static int search(Integer n, Integer[] list){
            Search mySearch = (int x, int y) -> x==y;
            for (int i=0; i<list.length;i++){
                if (mySearch.search(n,list[i])) return i;
            }
            return -1;
        }

    }
