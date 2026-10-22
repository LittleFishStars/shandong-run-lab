package com.ipd.dsp.internal.q;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.ipd.dsp.Dsp;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f38501a = "TransformationUtils";
    public static final int b = 6;
    public static final int d = 7;
    public static final Paint f;
    public static final Set<String> g;
    public static final Lock h;
    public static final Paint c = new Paint(6);
    public static final Paint e = new Paint(7);

    public class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f38502a;

        public a(int i) {
            this.f38502a = i;
        }

        @Override // com.ipd.dsp.internal.q.j0.c
        public void a(Canvas canvas, Paint paint, RectF rectF) {
            float f = this.f38502a;
            canvas.drawRoundRect(rectF, f, f, paint);
        }
    }

    public class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f38503a;
        public final /* synthetic */ float b;
        public final /* synthetic */ float c;
        public final /* synthetic */ float d;

        public b(float f, float f2, float f3, float f4) {
            this.f38503a = f;
            this.b = f2;
            this.c = f3;
            this.d = f4;
        }

        @Override // com.ipd.dsp.internal.q.j0.c
        public void a(Canvas canvas, Paint paint, RectF rectF) {
            Path path = new Path();
            float f = this.f38503a;
            float f2 = this.b;
            float f3 = this.c;
            float f4 = this.d;
            path.addRoundRect(rectF, new float[]{f, f, f2, f2, f3, f3, f4, f4}, Path.Direction.CW);
            canvas.drawPath(path, paint);
        }
    }

    public interface c {
        void a(Canvas canvas, Paint paint, RectF rectF);
    }

    public static final class d implements Lock {
        @Override // java.util.concurrent.locks.Lock
        public void lock() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
        }

        @Override // java.util.concurrent.locks.Lock
        @NonNull
        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock() {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock(long j, @NonNull TimeUnit timeUnit) throws InterruptedException {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public void unlock() {
        }
    }

    static {
        HashSet hashSet = new HashSet(Arrays.asList("XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"));
        g = hashSet;
        h = hashSet.contains(Build.MODEL) ? new ReentrantLock() : new d();
        Paint paint = new Paint(7);
        f = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    public static int a(int i) {
        switch (i) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public static Lock a() {
        return h;
    }

    public static Bitmap b(@NonNull com.ipd.dsp.internal.j.e eVar, @NonNull Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.e(f38501a, "requested target size too big for input, fit centering instead");
            }
            return d(eVar, bitmap, i, i2);
        }
        if (Dsp.isDebugLogEnable()) {
            com.ipd.dsp.internal.c2.k.e(f38501a, "requested target size larger or equal to input, returning input");
        }
        return bitmap;
    }

    public static boolean b(int i) {
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public static Bitmap c(@NonNull com.ipd.dsp.internal.j.e eVar, @NonNull Bitmap bitmap, int i, int i2) {
        int iMin = Math.min(i, i2);
        float f2 = iMin;
        float f3 = f2 / 2.0f;
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        float fMax = Math.max(f2 / width, f2 / height);
        float f4 = width * fMax;
        float f5 = fMax * height;
        float f6 = (f2 - f4) / 2.0f;
        float f7 = (f2 - f5) / 2.0f;
        RectF rectF = new RectF(f6, f7, f4 + f6, f5 + f7);
        Bitmap bitmapA = a(eVar, bitmap);
        Bitmap bitmapA2 = eVar.a(iMin, iMin, a(bitmap));
        bitmapA2.setHasAlpha(true);
        Lock lock = h;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmapA2);
            canvas.drawCircle(f3, f3, f3, e);
            canvas.drawBitmap(bitmapA, (Rect) null, rectF, f);
            a(canvas);
            lock.unlock();
            if (!bitmapA.equals(bitmap)) {
                eVar.a(bitmapA);
            }
            return bitmapA2;
        } catch (Throwable th) {
            h.unlock();
            throw th;
        }
    }

    public static Bitmap d(@NonNull com.ipd.dsp.internal.j.e eVar, @NonNull Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() != i || bitmap.getHeight() != i2) {
            float fMin = Math.min(i / bitmap.getWidth(), i2 / bitmap.getHeight());
            int iRound = Math.round(bitmap.getWidth() * fMin);
            int iRound2 = Math.round(bitmap.getHeight() * fMin);
            if (bitmap.getWidth() != iRound || bitmap.getHeight() != iRound2) {
                Bitmap bitmapA = eVar.a((int) (bitmap.getWidth() * fMin), (int) (bitmap.getHeight() * fMin), b(bitmap));
                a(bitmap, bitmapA);
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.e(f38501a, "request: " + i + "x" + i2);
                    com.ipd.dsp.internal.c2.k.e(f38501a, "toFit:   " + bitmap.getWidth() + "x" + bitmap.getHeight());
                    com.ipd.dsp.internal.c2.k.e(f38501a, "toReuse: " + bitmapA.getWidth() + "x" + bitmapA.getHeight());
                    StringBuilder sb = new StringBuilder();
                    sb.append("minPct:   ");
                    sb.append(fMin);
                    com.ipd.dsp.internal.c2.k.e(f38501a, sb.toString());
                }
                Matrix matrix = new Matrix();
                matrix.setScale(fMin, fMin);
                a(bitmap, bitmapA, matrix);
                return bitmapA;
            }
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.e(f38501a, "adjusted target size matches input, returning input");
            }
        } else if (Dsp.isDebugLogEnable()) {
            com.ipd.dsp.internal.c2.k.e(f38501a, "requested target size matches input, returning input");
            return bitmap;
        }
        return bitmap;
    }

    public static Bitmap a(@NonNull com.ipd.dsp.internal.j.e eVar, @NonNull Bitmap bitmap, int i, int i2) {
        float width;
        float width2;
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float height = 0.0f;
        if (bitmap.getWidth() * i2 > bitmap.getHeight() * i) {
            width = i2 / bitmap.getHeight();
            width2 = (i - (bitmap.getWidth() * width)) * 0.5f;
        } else {
            width = i / bitmap.getWidth();
            height = (i2 - (bitmap.getHeight() * width)) * 0.5f;
            width2 = 0.0f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (width2 + 0.5f), (int) (height + 0.5f));
        Bitmap bitmapA = eVar.a(i, i2, b(bitmap));
        a(bitmap, bitmapA);
        a(bitmap, bitmapA, matrix);
        return bitmapA;
    }

    public static Bitmap b(@NonNull com.ipd.dsp.internal.j.e eVar, @NonNull Bitmap bitmap, int i) {
        com.ipd.dsp.internal.d0.m.a(i > 0, "roundingRadius must be greater than 0.");
        return a(eVar, bitmap, new a(i));
    }

    @NonNull
    public static Bitmap.Config b(@NonNull Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
    }

    public static void a(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }

    public static Bitmap a(@NonNull Bitmap bitmap, int i) {
        if (i != 0) {
            try {
                Matrix matrix = new Matrix();
                matrix.setRotate(i);
                return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } catch (Exception e2) {
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.b(f38501a, "Exception when trying to orient image", e2);
                }
            }
        }
        return bitmap;
    }

    public static Bitmap a(@NonNull com.ipd.dsp.internal.j.e eVar, @NonNull Bitmap bitmap, int i) {
        if (!b(i)) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        a(i, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        matrix.mapRect(rectF);
        Bitmap bitmapA = eVar.a(Math.round(rectF.width()), Math.round(rectF.height()), b(bitmap));
        matrix.postTranslate(-rectF.left, -rectF.top);
        bitmapA.setHasAlpha(bitmap.hasAlpha());
        a(bitmap, bitmapA, matrix);
        return bitmapA;
    }

    public static Bitmap a(@NonNull com.ipd.dsp.internal.j.e eVar, @NonNull Bitmap bitmap) {
        Bitmap.Config configA = a(bitmap);
        if (configA.equals(bitmap.getConfig())) {
            return bitmap;
        }
        Bitmap bitmapA = eVar.a(bitmap.getWidth(), bitmap.getHeight(), configA);
        new Canvas(bitmapA).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return bitmapA;
    }

    @NonNull
    public static Bitmap.Config a(@NonNull Bitmap bitmap) {
        Bitmap.Config config = Bitmap.Config.RGBA_F16;
        return config.equals(bitmap.getConfig()) ? config : Bitmap.Config.ARGB_8888;
    }

    @Deprecated
    public static Bitmap a(@NonNull com.ipd.dsp.internal.j.e eVar, @NonNull Bitmap bitmap, int i, int i2, int i3) {
        return b(eVar, bitmap, i3);
    }

    public static Bitmap a(@NonNull com.ipd.dsp.internal.j.e eVar, @NonNull Bitmap bitmap, float f2, float f3, float f4, float f5) {
        return a(eVar, bitmap, new b(f2, f3, f4, f5));
    }

    public static Bitmap a(@NonNull com.ipd.dsp.internal.j.e eVar, @NonNull Bitmap bitmap, c cVar) {
        Bitmap.Config configA = a(bitmap);
        Bitmap bitmapA = a(eVar, bitmap);
        Bitmap bitmapA2 = eVar.a(bitmapA.getWidth(), bitmapA.getHeight(), configA);
        bitmapA2.setHasAlpha(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmapA, tileMode, tileMode);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        RectF rectF = new RectF(0.0f, 0.0f, bitmapA2.getWidth(), bitmapA2.getHeight());
        Lock lock = h;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmapA2);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            cVar.a(canvas, paint, rectF);
            a(canvas);
            lock.unlock();
            if (!bitmapA.equals(bitmap)) {
                eVar.a(bitmapA);
            }
            return bitmapA2;
        } catch (Throwable th) {
            h.unlock();
            throw th;
        }
    }

    public static void a(Canvas canvas) {
        canvas.setBitmap(null);
    }

    public static void a(@NonNull Bitmap bitmap, @NonNull Bitmap bitmap2, Matrix matrix) {
        h.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, c);
            a(canvas);
        } finally {
            h.unlock();
        }
    }

    @VisibleForTesting
    public static void a(int i, Matrix matrix) {
        switch (i) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.setRotate(180.0f);
                break;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                break;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                break;
        }
    }
}
