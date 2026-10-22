package com.byazt.kk;

import android.graphics.Path;
import android.graphics.PointF;
import com.byazt.jx.yp;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SWITCH_SUBID, 42})
public class i {
    public static final PointF c = new PointF();

    public static float c(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    public static int c(int i, int i2, float f) {
        return (int) (i + (f * (i2 - i)));
    }

    public static PointF c(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    private static int tt(int i, int i2) {
        int i3 = i / i2;
        return (((i ^ i2) >= 0) || i % i2 == 0) ? i3 : i3 - 1;
    }

    public static boolean ve(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }

    public static void c(yp ypVar, Path path) {
        path.reset();
        PointF pointFC = ypVar.c();
        path.moveTo(pointFC.x, pointFC.y);
        c.set(pointFC.x, pointFC.y);
        for (int i = 0; i < ypVar.ve().size(); i++) {
            com.byazt.nb.c cVar = ypVar.ve().get(i);
            PointF pointFC2 = cVar.c();
            PointF pointFTt = cVar.tt();
            PointF pointFVe = cVar.ve();
            PointF pointF = c;
            if (pointFC2.equals(pointF) && pointFTt.equals(pointFVe)) {
                path.lineTo(pointFVe.x, pointFVe.y);
            } else {
                path.cubicTo(pointFC2.x, pointFC2.y, pointFTt.x, pointFTt.y, pointFVe.x, pointFVe.y);
            }
            pointF.set(pointFVe.x, pointFVe.y);
        }
        if (ypVar.tt()) {
            path.close();
        }
    }

    public static float tt(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    public static int c(float f, float f2) {
        return c((int) f, (int) f2);
    }

    private static int c(int i, int i2) {
        return i - (i2 * tt(i, i2));
    }

    public static int c(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }
}
