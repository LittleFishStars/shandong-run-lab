package com.byazt.kk;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.provider.Settings;
import android.text.TextUtils;
import com.byazt.nr.m;
import com.byazt.zy.rl;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import javax.net.ssl.SSLException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SWITCH_SUBID, 72})
public final class da {
    public static final ThreadLocal<PathMeasure> c = new ThreadLocal<PathMeasure>() { // from class: com.byazt.kk.da.1
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public PathMeasure initialValue() {
            return new PathMeasure();
        }
    };
    public static final ThreadLocal<Path> tt = new ThreadLocal<Path>() { // from class: com.byazt.kk.da.2
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Path initialValue() {
            return new Path();
        }
    };
    public static final ThreadLocal<Path> ve = new ThreadLocal<Path>() { // from class: com.byazt.kk.da.3
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Path initialValue() {
            return new Path();
        }
    };
    public static final ThreadLocal<float[]> uj = new ThreadLocal<float[]>() { // from class: com.byazt.kk.da.4
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public float[] initialValue() {
            return new float[4];
        }
    };
    public static final float n = (float) (Math.sqrt(2.0d) / 2.0d);

    public static int c(float f, float f2, float f3, float f4) {
        int i = f != 0.0f ? (int) (f * 527.0f) : 17;
        if (f2 != 0.0f) {
            i = (int) (i * 31 * f2);
        }
        if (f3 != 0.0f) {
            i = (int) (i * 31 * f3);
        }
        return f4 != 0.0f ? (int) (i * 31 * f4) : i;
    }

    public static Path c(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 == null || pointF4 == null || (pointF3.length() == 0.0f && pointF4.length() == 0.0f)) {
            path.lineTo(pointF2.x, pointF2.y);
        } else {
            float f = pointF3.x + pointF.x;
            float f2 = pointF.y + pointF3.y;
            float f3 = pointF2.x;
            float f4 = f3 + pointF4.x;
            float f5 = pointF2.y;
            path.cubicTo(f, f2, f4, f5 + pointF4.y, f3, f5);
        }
        return path;
    }

    public static boolean c(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i < i4) {
            return false;
        }
        if (i > i4) {
            return true;
        }
        if (i2 < i5) {
            return false;
        }
        return i2 > i5 || i3 >= i6;
    }

    public static boolean tt(Matrix matrix) {
        float[] fArr = uj.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        return fArr[0] == fArr[2] || fArr[1] == fArr[3];
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static float c(Matrix matrix) {
        float[] fArr = uj.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f = n;
        fArr[2] = f;
        fArr[3] = f;
        matrix.mapPoints(fArr);
        return (float) Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1]);
    }

    public static void c(Path path, rl rlVar) {
        if (rlVar == null || rlVar.n()) {
            return;
        }
        c(path, ((com.byazt.dg.uj) rlVar.tt()).i() / 100.0f, ((com.byazt.dg.uj) rlVar.ve()).i() / 100.0f, ((com.byazt.dg.uj) rlVar.uj()).i() / 360.0f);
    }

    public static void c(Path path, float f, float f2, float f3) {
        com.byazt.ga.n.c("applyTrimPathIfNeeded");
        PathMeasure pathMeasure = c.get();
        Path path2 = tt.get();
        Path path3 = ve.get();
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f == 1.0f && f2 == 0.0f) {
            com.byazt.ga.n.tt("applyTrimPathIfNeeded");
            return;
        }
        if (length >= 1.0f && Math.abs((f2 - f) - 1.0f) >= 0.01d) {
            float f4 = f * length;
            float f5 = f2 * length;
            float f6 = f3 * length;
            float fMin = Math.min(f4, f5) + f6;
            float fMax = Math.max(f4, f5) + f6;
            if (fMin >= length && fMax >= length) {
                fMin = i.c(fMin, length);
                fMax = i.c(fMax, length);
            }
            if (fMin < 0.0f) {
                fMin = i.c(fMin, length);
            }
            if (fMax < 0.0f) {
                fMax = i.c(fMax, length);
            }
            if (fMin == fMax) {
                path.reset();
                com.byazt.ga.n.tt("applyTrimPathIfNeeded");
                return;
            }
            if (fMin >= fMax) {
                fMin -= length;
            }
            path2.reset();
            pathMeasure.getSegment(fMin, fMax, path2, true);
            if (fMax > length) {
                path3.reset();
                pathMeasure.getSegment(0.0f, fMax % length, path3, true);
                path2.addPath(path3);
            } else if (fMin < 0.0f) {
                path3.reset();
                pathMeasure.getSegment(fMin + length, length, path3, true);
                path2.addPath(path3);
            }
            path.set(path2);
            com.byazt.ga.n.tt("applyTrimPathIfNeeded");
            return;
        }
        com.byazt.ga.n.tt("applyTrimPathIfNeeded");
    }

    public static float c() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static float c(Context context) {
        return Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }

    public static Bitmap c(Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, true);
        bitmap.recycle();
        return bitmapCreateScaledBitmap;
    }

    public static boolean c(Throwable th) {
        return (th instanceof SocketException) || (th instanceof ClosedChannelException) || (th instanceof InterruptedIOException) || (th instanceof ProtocolException) || (th instanceof SSLException) || (th instanceof UnknownHostException) || (th instanceof UnknownServiceException);
    }

    public static void c(Canvas canvas, RectF rectF, Paint paint) {
        c(canvas, rectF, paint, 31);
    }

    public static void c(Canvas canvas, RectF rectF, Paint paint, int i) {
        com.byazt.ga.n.c("Utils#saveLayer");
        canvas.saveLayer(rectF, paint);
        com.byazt.ga.n.tt("Utils#saveLayer");
    }

    public static float c(String str, String str2, int i) {
        if (str2 != null) {
            try {
                if (str2.contains("%")) {
                    return (Integer.parseInt(str2.substring(0, str2.length() - 1)) / 100.0f) * i;
                }
                return Integer.parseInt(str2) * c();
            } catch (Throwable th) {
                m.c(th);
            }
        }
        if (TextUtils.equals("x", str) || TextUtils.equals("y", str)) {
            return 0.0f;
        }
        return i;
    }
}
