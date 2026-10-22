package com.beizi.fusion;

import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class jl {
    public static boolean a(int i) {
        float fNextInt = new Random().nextInt(100);
        kh.c("BeiZisAd", "ratio = " + fNextInt + ",ratioCheckNum = " + i);
        return fNextInt < ((float) i);
    }
}
