package lesson1;

import java.util.Random;

public class Wall {
    private final double height;

    public Wall() {
        height = generateWallHeight();
    }

    private double generateWallHeight() {
        Random randomHeight = new Random();
        return randomHeight.nextDouble() + randomHeight.nextInt(12) + 1;
    }

    public double getHeight() {
        return height;
    }
}
