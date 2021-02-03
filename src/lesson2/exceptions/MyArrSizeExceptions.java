package lesson2.exceptions;

public class MyArrSizeExceptions extends IllegalArgumentException {
    public MyArrSizeExceptions(){
        super();
    }


    @Override
    public void printStackTrace() {
        System.out.println("Неверный размер массива!!!");
    }
}
