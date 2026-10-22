package com.zj.adlib;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class k99 {
    public static void a(View view, int i, int i2, int i3) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        float f = i;
        view.dispatchTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, f, view.getHeight() / 2, 0));
        long j = jUptimeMillis;
        while (true) {
            long j2 = j - jUptimeMillis;
            if (j2 >= i3) {
                view.dispatchTouchEvent(MotionEvent.obtain(jUptimeMillis, j, 1, i2, view.getHeight() / 2, 0));
                return;
            } else {
                view.dispatchTouchEvent(MotionEvent.obtain(jUptimeMillis, j, 2, (int) (((i2 - i) * (j2 / i3)) + f), view.getHeight() / 2, 0));
                j += 16;
            }
        }
    }
}
