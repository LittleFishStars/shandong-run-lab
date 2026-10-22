package com.zj.adlib;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.FloatRange;
import androidx.camera.video.AudioStats;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class up5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PointF f45199a = new PointF();

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static double b(double d, double d2, double d3) {
        return Math.max(d2, Math.min(d3, d));
    }

    public static float c(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    public static int d(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    public static boolean e(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }

    public static int f(int i, int i2) {
        int i3 = i / i2;
        return (((i ^ i2) >= 0) || i % i2 == 0) ? i3 : i3 - 1;
    }

    public static int g(float f, float f2) {
        return h((int) f, (int) f2);
    }

    public static int h(int i, int i2) {
        return i - (i2 * f(i, i2));
    }

    public static void i(g88 g88Var, Path path) {
        path.reset();
        PointF pointFB = g88Var.b();
        path.moveTo(pointFB.x, pointFB.y);
        f45199a.set(pointFB.x, pointFB.y);
        for (int i = 0; i < g88Var.a().size(); i++) {
            py1 py1Var = g88Var.a().get(i);
            PointF pointFA = py1Var.a();
            PointF pointFB2 = py1Var.b();
            PointF pointFC = py1Var.c();
            PointF pointF = f45199a;
            if (pointFA.equals(pointF) && pointFB2.equals(pointFC)) {
                path.lineTo(pointFC.x, pointFC.y);
            } else {
                path.cubicTo(pointFA.x, pointFA.y, pointFB2.x, pointFB2.y, pointFC.x, pointFC.y);
            }
            pointF.set(pointFC.x, pointFC.y);
        }
        if (g88Var.d()) {
            path.close();
        }
    }

    public static double j(double d, double d2, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) double d3) {
        return d + (d3 * (d2 - d));
    }

    public static float k(float f, float f2, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f3) {
        return f + (f3 * (f2 - f));
    }

    public static int l(int i, int i2, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f) {
        return (int) (i + (f * (i2 - i)));
    }

    public static void m(ds4 ds4Var, int i, List<ds4> list, ds4 ds4Var2, KeyPathElementContent keyPathElementContent) {
        if (ds4Var.c(keyPathElementContent.getName(), i)) {
            list.add(ds4Var2.a(keyPathElementContent.getName()).j(keyPathElementContent));
        }
    }
}
