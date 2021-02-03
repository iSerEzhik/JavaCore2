package lesson1;

import java.util.Random;

public class Dog {
    private final double maxRun;
    private final double maxJump;

    public Dog() {
        maxRun = generateMaxRun();
        maxJump = generateMaxJump();
    }

    private double generateMaxRun() {
        Random randomRun = new Random();
        return randomRun.nextDouble() + randomRun.nextInt(200) + 100;
    }

    private double generateMaxJump() {
        Random randomJump = new Random();
        return randomJump.nextDouble() + randomJump.nextInt(2) + 0.5;
    }

    public boolean isJumpDone(double height) {
        return maxJump >= height;
    }

    public boolean isRunDone(double length) {
        return maxRun >= length;
    }

    public double getMaxRun() {
        return maxRun;
    }

    public double getMaxJump() {
        return maxJump;
    }
}
