package org.xidian.lichen.backend.util;

public class RandomNumberGenerator {
    public static int randIntInRange(int min, int max) {
        int result = min + (int) (Math.random() * (max - min) + 1);
        return result;
    }

    public static double randDoubleInRange(int min, int max) {
        double result = (double) (min + Math.random() * (max - min));
        return result;
    }
}
