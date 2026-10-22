package com.zj.adlib;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.Image;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.odml.image.ImageProperties;
import com.google.android.odml.image.MlImage;
import com.google.android.odml.image.a;
import com.google.android.odml.image.b;
import com.google.android.odml.image.c;
import com.google.mlkit.vision.common.InputImage;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@KeepForSdk
public class eq1 {
    @Nullable
    @KeepForSdk
    public static InputImage a(@NonNull MlImage mlImage) {
        InputImage inputImageA;
        Integer numValueOf;
        ImageProperties imageProperties = mlImage.g().get(0);
        int iB = imageProperties.b();
        if (iB != 1) {
            inputImageA = null;
            if (iB == 2) {
                ByteBuffer byteBufferA = b.a(mlImage);
                int iA = imageProperties.a();
                if (iA != 4) {
                    numValueOf = iA != 5 ? null : Integer.valueOf(InputImage.f);
                } else {
                    numValueOf = 17;
                }
                if (numValueOf != null) {
                    h(numValueOf.intValue(), 3, SystemClock.elapsedRealtime(), mlImage.getHeight(), mlImage.getWidth(), byteBufferA.limit(), mlImage.j());
                    inputImageA = InputImage.c(byteBufferA, mlImage.getWidth(), mlImage.getHeight(), mlImage.j(), numValueOf.intValue());
                }
            } else if (iB == 3) {
                Image imageA = c.a(mlImage);
                h(imageA.getFormat(), 5, SystemClock.elapsedRealtime(), mlImage.getHeight(), mlImage.getWidth(), imageA.getFormat() == 256 ? imageA.getPlanes()[0].getBuffer().limit() : (imageA.getPlanes()[0].getBuffer().limit() * 3) / 2, mlImage.j());
                inputImageA = InputImage.e(imageA, mlImage.j());
            }
        } else {
            Bitmap bitmapA = a.a(mlImage);
            h(-1, 1, SystemClock.elapsedRealtime(), mlImage.getHeight(), mlImage.getWidth(), bitmapA.getAllocationByteCount(), mlImage.j());
            inputImageA = InputImage.a(bitmapA, mlImage.j());
        }
        if (inputImageA != null) {
            ogd.a();
        }
        return inputImageA;
    }

    @KeepForSdk
    public static int b(@InputImage.ImageFormat int i) {
        int i2 = 17;
        if (i != 17) {
            i2 = 35;
            if (i != 35) {
                i2 = InputImage.f;
                if (i != 842094169) {
                    return 0;
                }
            }
        }
        return i2;
    }

    @KeepForSdk
    public static int c(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 90) {
            return 1;
        }
        if (i == 180) {
            return 2;
        }
        if (i == 270) {
            return 3;
        }
        throw new IllegalArgumentException("Invalid rotation: " + i);
    }

    @KeepForSdk
    public static void d(@NonNull Point[] pointArr, @NonNull Matrix matrix) {
        int length = pointArr.length;
        float[] fArr = new float[length + length];
        for (int i = 0; i < pointArr.length; i++) {
            Point point = pointArr[i];
            int i2 = i + i;
            fArr[i2] = point.x;
            fArr[i2 + 1] = point.y;
        }
        matrix.mapPoints(fArr);
        for (int i3 = 0; i3 < pointArr.length; i3++) {
            int i4 = i3 + i3;
            pointArr[i3].set((int) fArr[i4], (int) fArr[i4 + 1]);
        }
    }

    @KeepForSdk
    public static void e(@NonNull PointF pointF, @NonNull Matrix matrix) {
        float[] fArr = {pointF.x, pointF.y};
        matrix.mapPoints(fArr);
        pointF.set(fArr[0], fArr[1]);
    }

    @KeepForSdk
    public static void f(@NonNull List<PointF> list, @NonNull Matrix matrix) {
        int size = list.size();
        float[] fArr = new float[size + size];
        for (int i = 0; i < list.size(); i++) {
            int i2 = i + i;
            fArr[i2] = list.get(i).x;
            fArr[i2 + 1] = list.get(i).y;
        }
        matrix.mapPoints(fArr);
        for (int i3 = 0; i3 < list.size(); i3++) {
            int i4 = i3 + i3;
            list.get(i3).set(fArr[i4], fArr[i4 + 1]);
        }
    }

    @KeepForSdk
    public static void g(@NonNull Rect rect, @NonNull Matrix matrix) {
        RectF rectF = new RectF(rect);
        matrix.mapRect(rectF);
        rect.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
    }

    public static void h(int i, int i2, long j, int i3, int i4, int i5, int i6) {
        igd.b(cgd.b("vision-common"), i, i2, j, i3, i4, i5, i6);
    }
}
