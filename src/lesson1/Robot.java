package lesson1;

import java.util.Random;

public class Robot {
    private final double maxRun;
    private final double maxJump;

    public Robot() {
        this.maxRun = generateMaxRun();
        this.maxJump = generateMaxJump();
    }

    private double generateMaxRun() {
        Random randomRun = new Random();
        return randomRun.nextDouble() + randomRun.nextInt(200) + 300;
    }

    private double generateMaxJump() {
        Random randomJump = new Random();
        return randomJump.nextDouble() + randomJump.nextInt(10) + 2;
    }

    public boolean isJumpDone(double height) {
        return maxJump >= height;
    }

    public boolean isRunDone(double length) {
        return maxRun >= length;
    }
    public double getMaxJump() {
        return maxJump;
    }

    public double getMaxRun() {
        return maxRun;
    }
}
