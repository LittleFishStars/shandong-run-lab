package com.fl.saas.common.util;

import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class RandomUtils {
    private static final Random random = new Random();

    public static boolean getRandomBoolean() {
        return random.nextBoolean();
    }

    public static double getRandomDouble(double d, double d2) {
        return (random.nextDouble() * (d2 - d)) + d;
    }

    public static int getRandomInt(int i) {
        if (i <= 0) {
            return 0;
        }
        return random.nextInt(i);
    }

    public static int getRandomInt(int i, int i2) {
        int i3 = (i2 - i) + 1;
        return i3 <= 0 ? i : random.nextInt(i3) + i;
    }
}
