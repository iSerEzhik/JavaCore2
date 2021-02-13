package lesson5;

public class Main {
    static final int size = 1000000;
    static final int halfSize = size / 2;
    static float[] arr = new float[size];
    static float[] firstHalfArr = new float[halfSize];
    static float[] secondHalfArr = new float[halfSize];

    public static void main(String[] args) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        System.out.println("Время работы с целым массивом: "+workWithFullArr(arr));
        System.out.println("Время работы с двумя половинками : "+workWithHalfArrs(arr));


    }

    public static long workWithFullArr(float[] arr) {

        long time = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i]= (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return System.currentTimeMillis()-time;
    }
    public static long workWithHalfArrs(float[] arrs){
        long time = System.currentTimeMillis();
        System.arraycopy(arrs,0,firstHalfArr,0,halfSize);
        System.arraycopy(arrs,halfSize,secondHalfArr,0,halfSize);
        Thread workWithFirstArr = new Thread(()->{
            for (int i = 0; i < firstHalfArr.length; i++) {

                firstHalfArr[i]= (float)(firstHalfArr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread workWithSecondArr = new Thread(()->{
            for (int i = 0; i < secondHalfArr.length; i++) {
                secondHalfArr[i]= (float)(secondHalfArr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        try {

            workWithFirstArr.start();

            workWithSecondArr.start();
            workWithFirstArr.join();
            workWithSecondArr.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(firstHalfArr,0,arr,0,halfSize);
        System.arraycopy(secondHalfArr,0,arr,halfSize,halfSize);


        return System.currentTimeMillis()-time;

    }

}
