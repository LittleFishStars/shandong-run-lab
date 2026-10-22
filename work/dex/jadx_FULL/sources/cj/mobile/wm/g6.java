package cj.mobile.wm;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class g6 {
    public static int dexa(int i) {
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

    public static Bitmap.Config dexa(Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
    }

    public static Bitmap dexa(Bitmap bitmap, Bitmap bitmap2, int i, int i2) {
        float width;
        float height;
        if (bitmap2 == null) {
            return null;
        }
        if (bitmap2.getWidth() == i && bitmap2.getHeight() == i2) {
            return bitmap2;
        }
        Matrix matrix = new Matrix();
        float width2 = 0.0f;
        if (bitmap2.getWidth() * i2 > bitmap2.getHeight() * i) {
            width = i2 / bitmap2.getHeight();
            width2 = (i - (bitmap2.getWidth() * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = i / bitmap2.getWidth();
            height = (i2 - (bitmap2.getHeight() * width)) * 0.5f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (width2 + 0.5f), (int) (height + 0.5f));
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(i, i2, dexa(bitmap2));
        }
        dexa(bitmap2, bitmap);
        new Canvas(bitmap).drawBitmap(bitmap2, matrix, new Paint(6));
        return bitmap;
    }

    public static Bitmap dexa(Bitmap bitmap, r3 r3Var, int i) {
        Matrix matrix = new Matrix();
        dexa(i, matrix);
        if (matrix.isIdentity()) {
            return bitmap;
        }
        RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        matrix.mapRect(rectF);
        int iRound = Math.round(rectF.width());
        int iRound2 = Math.round(rectF.height());
        Bitmap.Config configDexa = dexa(bitmap);
        Bitmap bitmapDexa = r3Var.dexa(iRound, iRound2, configDexa);
        if (bitmapDexa == null) {
            bitmapDexa = Bitmap.createBitmap(iRound, iRound2, configDexa);
        }
        matrix.postTranslate(-rectF.left, -rectF.top);
        new Canvas(bitmapDexa).drawBitmap(bitmap, matrix, new Paint(6));
        return bitmapDexa;
    }

    public static Bitmap dexa(Bitmap bitmap, r3 r3Var, int i, int i2) {
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            if (Log.isLoggable(com.ipd.dsp.internal.q.j0.f38501a, 2)) {
                Log.v(com.ipd.dsp.internal.q.j0.f38501a, "requested target size matches input, returning input");
            }
            return bitmap;
        }
        float fMin = Math.min(i / bitmap.getWidth(), i2 / bitmap.getHeight());
        int width = (int) (bitmap.getWidth() * fMin);
        int height = (int) (bitmap.getHeight() * fMin);
        if (bitmap.getWidth() == width && bitmap.getHeight() == height) {
            if (Log.isLoggable(com.ipd.dsp.internal.q.j0.f38501a, 2)) {
                Log.v(com.ipd.dsp.internal.q.j0.f38501a, "adjusted target size matches input, returning input");
            }
            return bitmap;
        }
        Bitmap.Config configDexa = dexa(bitmap);
        Bitmap bitmapDexa = r3Var.dexa(width, height, configDexa);
        if (bitmapDexa == null) {
            bitmapDexa = Bitmap.createBitmap(width, height, configDexa);
        }
        dexa(bitmap, bitmapDexa);
        if (Log.isLoggable(com.ipd.dsp.internal.q.j0.f38501a, 2)) {
            Log.v(com.ipd.dsp.internal.q.j0.f38501a, "request: " + i + "x" + i2);
            Log.v(com.ipd.dsp.internal.q.j0.f38501a, "toFit:   " + bitmap.getWidth() + "x" + bitmap.getHeight());
            Log.v(com.ipd.dsp.internal.q.j0.f38501a, "toReuse: " + bitmapDexa.getWidth() + "x" + bitmapDexa.getHeight());
            StringBuilder sb = new StringBuilder();
            sb.append("minPct:   ");
            sb.append(fMin);
            Log.v(com.ipd.dsp.internal.q.j0.f38501a, sb.toString());
        }
        Canvas canvas = new Canvas(bitmapDexa);
        Matrix matrix = new Matrix();
        matrix.setScale(fMin, fMin);
        canvas.drawBitmap(bitmap, matrix, new Paint(6));
        return bitmapDexa;
    }

    public static void dexa(int i, Matrix matrix) {
        switch (i) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                return;
            case 3:
                matrix.setRotate(180.0f);
                return;
            case 4:
                matrix.setRotate(180.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                return;
            case 7:
                matrix.setRotate(-90.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                return;
            default:
                return;
        }
        matrix.postScale(-1.0f, 1.0f);
    }

    @TargetApi(12)
    public static void dexa(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap2 != null) {
            bitmap2.setHasAlpha(bitmap.hasAlpha());
        }
    }
}
