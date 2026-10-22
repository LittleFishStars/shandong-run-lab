package com.beizi.fusion;

import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class nl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Random f27565a = new Random();

    public static float a(float f) {
        float f2 = 1.05f * f;
        float fNextFloat = ((1.0f - f27565a.nextFloat()) * (f2 - f)) + f;
        if (fNextFloat <= f) {
            return f + Float.MIN_NORMAL;
        }
        return fNextFloat > f2 ? f2 : fNextFloat;
    }
}
