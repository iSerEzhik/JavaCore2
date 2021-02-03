package lesson1;

import java.text.DecimalFormat;
import java.util.Random;

public class Main {
    public static Object[] members = new Object[5];
    public static Object[] barriers = new Object[5];
    public static DecimalFormat format = new DecimalFormat("###.##");

    public static void main(String[] args) {

        members = setMembers(members.length);
        barriers = setBarriers(barriers.length);
        boolean check = true;
        for (int numMember = 0; numMember < members.length; numMember++) {
            System.out.println("----------------------------------------------------");
            if (members[numMember] instanceof Cat) {
                for (int numBarrier = 0; numBarrier < barriers.length; numBarrier++) {
                    if (barriers[numBarrier] instanceof Wall) {
                        if (((Cat) members[numMember]).isJumpDone(((Wall) barriers[numBarrier]).getHeight())) {
                            System.out.println("Препятствие " + (numBarrier + 1) + " Wall пройдено участником №" + (numMember + 1) + " Cat!");
                            check = true;
                        } else {
                            System.out.println("Препятствие " + (numBarrier + 1) + " Wall не пройдено участником №" + (numMember + 1) + " Cat! Поэтому он сходит с дистанции");
                            check = false;
                        }
                    } else {
                        if (((Cat) members[numMember]).isRunDone(((Track) barriers[numBarrier]).getLength())) {
                            System.out.println("Препятствие " + (numBarrier + 1) + " Track пройдено участником №" + (numMember + 1) + " Cat!");
                            check = true;
                        } else {
                            System.out.println("Препятствие " + (numBarrier + 1) + " Track не пройдено участником №" + (numMember + 1) + " Cat! Поэтому он сходит с дистанции!");
                            check = false;
                        }
                    }
                    if (!check) break;
                }

            } else if (members[numMember] instanceof Dog) {
                for (int numBarrier = 0; numBarrier < barriers.length; numBarrier++) {
                    if (barriers[numBarrier] instanceof Wall) {
                        if (((Dog) members[numMember]).isJumpDone(((Wall) barriers[numBarrier]).getHeight())) {
                            System.out.println("Препятствие " + (numBarrier + 1) + " Wall пройдено участником №" + (numMember + 1) + " Dog!");
                            check = true;
                        } else {
                            System.out.println("Препятствие  " + (numBarrier + 1) + " Wall не пройдено участником №" + (numMember + 1) + " Dog! Поэтому он сходит с дистанции");
                            check = false;
                        }

                    } else {
                        if (((Dog) members[numMember]).isRunDone(((Track) barriers[numBarrier]).getLength())) {
                            System.out.println("Препятствие " + (numBarrier + 1) + " Track пройдено участником №" + (numMember + 1) + " Dog!");
                            check = true;
                        } else {
                            System.out.println("Препятствие " + (numBarrier + 1) + " Track не пройдено участником №" + (numMember + 1) + " Dog! Поэтому он сходит с дистанции!");
                            check = false;

                        }

                    }
                    if (!check) break;
                }

            } else {
                for (int numBarrier = 0; numBarrier < barriers.length; numBarrier++) {
                    if (barriers[numBarrier] instanceof Wall) {
                        if (((Robot) members[numMember]).isJumpDone(((Wall) barriers[numBarrier]).getHeight())) {
                            System.out.println("Препятствие " + (numBarrier + 1) + " Wall пройдено участником №" + (numMember + 1) + " Robot!");
                            check = true;
                        } else {
                            System.out.println("Препятствие " + (numBarrier + 1) + " Wall  не пройдено участником №" + (numMember + 1) + " Robot! Поэтому он сходит с дистанции");
                            check = false;

                        }
                    } else {
                        if (((Robot) members[numMember]).isRunDone(((Track) barriers[numBarrier]).getLength())) {
                            System.out.println("Препятствие " + (numBarrier + 1) + " Track пройдено участником №" + (numMember + 1) + " Robot!");
                            check = true;
                        } else {
                            System.out.println("Препятствие " + (numBarrier + 1) + " Track " + " не пройдено участником №" + (numMember + 1) + " Robot! Поэтому он сходит с дистанции!");
                            check = false;

                        }

                    }
                    if (!check) break;
                }
            }
            if (check) System.out.println("Дистанция пройдена полностью!!!!");
            System.out.println("------------------------------------------------------");
        }
    }



    public static Object[] setMembers(int quanMembers) {
        Object[] arrMembers = new Object[quanMembers];
        Random randomChoice = new Random();
        for (int number = 0; number < quanMembers; number++) {
            System.out.println("▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼");
            System.out.print("Участник № " + (number + 1) + " ");
            switch (randomChoice.nextInt(3)) {
                case 0: {
                    arrMembers[number] = new Cat();
                    System.out.println(arrMembers[number].getClass().getName().replaceAll("lesson1.", ""));
                    System.out.println("Высота прыжка: " + format.format(((Cat) arrMembers[number]).getMaxJump()));
                    System.out.println("Длина бега: " + format.format(((Cat) arrMembers[number]).getMaxRun()));
                    break;
                }
                case 1: {
                    arrMembers[number] = new Dog();
                    System.out.println(arrMembers[number].getClass().getName().replaceAll("lesson1.", ""));
                    System.out.println("Высота прыжка: " + format.format(((Dog) arrMembers[number]).getMaxJump()));
                    System.out.println("Длина бега: " + format.format(((Dog) arrMembers[number]).getMaxRun()));
                    break;
                }
                case 2: {
                    arrMembers[number] = new Robot();
                    System.out.println(arrMembers[number].getClass().getName().replaceAll("lesson1.", ""));
                    System.out.println("Высота прыжка: " + format.format(((Robot) arrMembers[number]).getMaxJump()));
                    System.out.println("Длина бега: " + format.format(((Robot) arrMembers[number]).getMaxRun()));
                    break;
                }
            }
            System.out.println("▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲");
        }
        return arrMembers;
    }

    public static Object[] setBarriers(int quanBarriers) {
        Object[] arrBarriers = new Object[quanBarriers];
        Random randomChoice = new Random();
        for (int number = 0; number < quanBarriers; number++) {
            System.out.println("▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼▼");
            System.out.print("Препятствие № " + (number + 1) + " ");
            switch (randomChoice.nextInt(2)) {
                case 0: {
                    arrBarriers[number] = new Wall();
                    System.out.println(arrBarriers[number].getClass().getName().replaceAll("lesson1.", ""));
                    System.out.println("Высота стены: " + format.format(((Wall) arrBarriers[number]).getHeight()));
                    break;
                }
                case 1: {
                    arrBarriers[number] = new Track();
                    System.out.println(arrBarriers[number].getClass().getName().replaceAll("lesson1.", ""));
                    System.out.println("Длина трека: " + format.format(((Track) arrBarriers[number]).getLength()));
                    break;
                }
            }
            System.out.println("▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲▲");
        }
        return arrBarriers;
    }

    public static void justCheck(Object forCheck) {
        System.out.println(forCheck instanceof Cat);
    }
}
