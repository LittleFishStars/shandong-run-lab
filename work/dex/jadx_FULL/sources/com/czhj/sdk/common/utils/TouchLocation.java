package com.czhj.sdk.common.utils;

import android.view.MotionEvent;
import android.view.View;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class TouchLocation implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f29453a;
    private final int b;

    public TouchLocation(int i, int i2) {
        this.f29453a = i;
        this.b = i2;
    }

    public static TouchLocation getTouchLocation(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null) {
            return null;
        }
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new TouchLocation(rawX - iArr[0], rawY - iArr[1]);
    }

    public int getX() {
        return this.f29453a;
    }

    public int getY() {
        return this.b;
    }
}
