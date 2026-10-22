package com.zj.adlib;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import com.google.common.base.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class mwa {
    public static int a(byte[] bArr, int i) {
        byte b = bArr[i + 0];
        byte b2 = bArr[i + 1];
        byte b3 = bArr[i + 2];
        byte b4 = bArr[i + 3];
        return (b4 << a.B) | (b & 255) | (b2 << 8) | (b3 << a.r);
    }

    public static Bitmap b(InputStream inputStream) throws Exception {
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStream);
        byte[] bArrH = h(bitmapDecodeStream);
        if (!NinePatch.isNinePatchChunk(bArrH)) {
            return bitmapDecodeStream;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeStream, 1, 1, bitmapDecodeStream.getWidth() - 2, bitmapDecodeStream.getHeight() - 2);
        zwa.B(bitmapDecodeStream);
        if (Build.VERSION.SDK_INT >= 28) {
            Method declaredMethod = bitmapCreateBitmap.getClass().getDeclaredMethod("setNinePatchChunk", byte[].class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(bitmapCreateBitmap, bArrH);
        } else {
            Field declaredField = bitmapCreateBitmap.getClass().getDeclaredField("mNinePatchChunk");
            declaredField.setAccessible(true);
            declaredField.set(bitmapCreateBitmap, bArrH);
        }
        return bitmapCreateBitmap;
    }

    public static Drawable c(Context context, String str) throws Exception {
        Bitmap bitmapI = i(context, str);
        if (bitmapI.getNinePatchChunk() == null) {
            return new BitmapDrawable(context.getResources(), bitmapI);
        }
        Rect rect = new Rect();
        g(bitmapI.getNinePatchChunk(), rect);
        return new NinePatchDrawable(context.getResources(), bitmapI, bitmapI.getNinePatchChunk(), rect, null);
    }

    public static void d(Bitmap bitmap, byte[] bArr) {
        int width = bitmap.getWidth() - 2;
        int[] iArr = new int[width];
        bitmap.getPixels(iArr, 0, width, 1, bitmap.getHeight() - 1, width, 1);
        for (int i = 0; i < width; i++) {
            if (-16777216 == iArr[i]) {
                f(bArr, 12, i);
                break;
            }
        }
        for (int i2 = width - 1; i2 >= 0; i2--) {
            if (-16777216 == iArr[i2]) {
                f(bArr, 16, (width - i2) - 2);
                break;
            }
        }
        int height = bitmap.getHeight() - 2;
        int[] iArr2 = new int[height];
        bitmap.getPixels(iArr2, 0, 1, bitmap.getWidth() - 1, 0, 1, height);
        for (int i3 = 0; i3 < height; i3++) {
            if (-16777216 == iArr2[i3]) {
                f(bArr, 20, i3);
                break;
            }
        }
        for (int i4 = height - 1; i4 >= 0; i4--) {
            if (-16777216 == iArr2[i4]) {
                f(bArr, 24, (height - i4) - 2);
                return;
            }
        }
    }

    public static void e(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    public static void f(byte[] bArr, int i, int i2) {
        bArr[i + 0] = (byte) (i2 >> 0);
        bArr[i + 1] = (byte) (i2 >> 8);
        bArr[i + 2] = (byte) (i2 >> 16);
        bArr[i + 3] = (byte) (i2 >> 24);
    }

    public static void g(byte[] bArr, Rect rect) {
        rect.left = a(bArr, 12);
        rect.right = a(bArr, 16);
        rect.top = a(bArr, 20);
        rect.bottom = a(bArr, 24);
    }

    public static byte[] h(Bitmap bitmap) throws IOException {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < 32; i++) {
            byteArrayOutputStream.write(0);
        }
        int i2 = width - 2;
        int[] iArr = new int[i2];
        bitmap.getPixels(iArr, 0, width, 1, 0, i2, 1);
        boolean z = iArr[0] == -16777216;
        boolean z2 = iArr[i2 + (-1)] == -16777216;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            if (i3 != iArr[i5]) {
                i4++;
                e(byteArrayOutputStream, i5);
                i3 = iArr[i5];
            }
        }
        if (z2) {
            i4++;
            e(byteArrayOutputStream, i2);
        }
        int i6 = i4 + 1;
        if (z) {
            i6--;
        }
        if (z2) {
            i6--;
        }
        int i7 = height - 2;
        int[] iArr2 = new int[i7];
        bitmap.getPixels(iArr2, 0, 1, 0, 1, 1, i7);
        boolean z3 = iArr2[0] == -16777216;
        boolean z4 = iArr2[i7 + (-1)] == -16777216;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < i7; i10++) {
            if (i8 != iArr2[i10]) {
                i9++;
                e(byteArrayOutputStream, i10);
                i8 = iArr2[i10];
            }
        }
        if (z4) {
            i9++;
            e(byteArrayOutputStream, i7);
        }
        int i11 = i9 + 1;
        if (z3) {
            i11--;
        }
        if (z4) {
            i11--;
        }
        int i12 = 0;
        while (true) {
            int i13 = i6 * i11;
            if (i12 >= i13) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArray[0] = 1;
                byteArray[1] = (byte) i4;
                byteArray[2] = (byte) i9;
                byteArray[3] = (byte) i13;
                d(bitmap, byteArray);
                return byteArray;
            }
            e(byteArrayOutputStream, 1);
            i12++;
        }
    }

    public static Bitmap i(Context context, String str) throws Exception {
        InputStream inputStreamOpen = twa.b(context).open(str);
        Bitmap bitmapB = b(inputStreamOpen);
        inputStreamOpen.close();
        return bitmapB;
    }
}
