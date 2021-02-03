package lesson1;

import java.util.Random;

public class Track {
    private final double length;

    public Track() {
        length = generateTrackLength();
    }

    private double generateTrackLength() {
        Random randomLength = new Random();
        return randomLength.nextDouble() + randomLength.nextInt(500) + 100;
    }

    public double getLength() {
        return length;
    }
}
