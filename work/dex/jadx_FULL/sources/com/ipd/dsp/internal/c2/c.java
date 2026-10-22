package com.ipd.dsp.internal.c2;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.Log;
import androidx.core.view.MotionEventCompat;
import com.zj.adlib.xd9;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class c {
    public static Bitmap a(Context context, Bitmap bitmap, int i, boolean z) {
        float width = z ? 150.0f / bitmap.getWidth() : 1.0f;
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() * width), Math.round(bitmap.getHeight() * width), false);
        RenderScript renderScriptCreate = RenderScript.create(context);
        Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateScaledBitmap);
        Allocation allocationCreateTyped = Allocation.createTyped(renderScriptCreate, allocationCreateFromBitmap.getType());
        ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
        Log.i("rsBlue", "input type = " + allocationCreateFromBitmap.getElement().getDataType());
        scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
        scriptIntrinsicBlurCreate.setRadius((float) i);
        scriptIntrinsicBlurCreate.forEach(allocationCreateTyped);
        allocationCreateTyped.copyTo(bitmapCreateScaledBitmap);
        renderScriptCreate.destroy();
        return bitmapCreateScaledBitmap;
    }

    public static Bitmap a(Bitmap bitmap, int i) {
        int i2 = i;
        float width = 150.0f / bitmap.getWidth();
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() * width), Math.round(bitmap.getHeight() * width), false);
        if (i2 <= 0) {
            return null;
        }
        int width2 = bitmapCreateScaledBitmap.getWidth();
        int height = bitmapCreateScaledBitmap.getHeight();
        int i3 = width2 * height;
        int[] iArr = new int[i3];
        bitmapCreateScaledBitmap.getPixels(iArr, 0, width2, 0, 0, width2, height);
        int i4 = width2 - 1;
        int i5 = height - 1;
        int i6 = i2 + i2;
        int i7 = i6 + 1;
        int[] iArr2 = new int[i3];
        int[] iArr3 = new int[i3];
        int[] iArr4 = new int[i3];
        int[] iArr5 = new int[Math.max(width2, height)];
        int i8 = (i6 + 2) >> 1;
        int i9 = i8 * i8;
        int i10 = i9 * 256;
        int[] iArr6 = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            iArr6[i11] = i11 / i9;
        }
        int[][] iArr7 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i7, 3);
        int i12 = i2 + 1;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i13 < height) {
            Bitmap bitmap2 = bitmapCreateScaledBitmap;
            int i16 = -i2;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int i25 = 0;
            while (i16 <= i2) {
                int i26 = i5;
                int i27 = height;
                int i28 = iArr[i14 + Math.min(i4, Math.max(i16, 0))];
                int[] iArr8 = iArr7[i16 + i2];
                iArr8[0] = (i28 & xd9.p) >> 16;
                iArr8[1] = (i28 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr8[2] = i28 & 255;
                int iAbs = i12 - Math.abs(i16);
                int i29 = iArr8[0];
                i19 += i29 * iAbs;
                int i30 = iArr8[1];
                i18 += i30 * iAbs;
                int i31 = iArr8[2];
                i17 += iAbs * i31;
                if (i16 > 0) {
                    i23 += i29;
                    i24 += i30;
                    i25 += i31;
                } else {
                    i22 += i29;
                    i21 += i30;
                    i20 += i31;
                }
                i16++;
                height = i27;
                i5 = i26;
            }
            int i32 = i5;
            int i33 = height;
            int i34 = i2;
            int i35 = 0;
            while (i35 < width2) {
                iArr2[i14] = iArr6[i19];
                iArr3[i14] = iArr6[i18];
                iArr4[i14] = iArr6[i17];
                int i36 = i19 - i22;
                int i37 = i18 - i21;
                int i38 = i17 - i20;
                int[] iArr9 = iArr7[((i34 - i2) + i7) % i7];
                int i39 = i22 - iArr9[0];
                int i40 = i21 - iArr9[1];
                int i41 = i20 - iArr9[2];
                if (i13 == 0) {
                    iArr5[i35] = Math.min(i35 + i2 + 1, i4);
                }
                int i42 = iArr[i15 + iArr5[i35]];
                int i43 = (i42 & xd9.p) >> 16;
                iArr9[0] = i43;
                int i44 = (i42 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr9[1] = i44;
                int i45 = i42 & 255;
                iArr9[2] = i45;
                int i46 = i23 + i43;
                int i47 = i24 + i44;
                int i48 = i25 + i45;
                i19 = i36 + i46;
                i18 = i37 + i47;
                i17 = i38 + i48;
                i34 = (i34 + 1) % i7;
                int[] iArr10 = iArr7[i34 % i7];
                int i49 = iArr10[0];
                i22 = i39 + i49;
                int i50 = iArr10[1];
                i21 = i40 + i50;
                int i51 = iArr10[2];
                i20 = i41 + i51;
                i23 = i46 - i49;
                i24 = i47 - i50;
                i25 = i48 - i51;
                i14++;
                i35++;
                iArr6 = iArr6;
            }
            i15 += width2;
            i13++;
            bitmapCreateScaledBitmap = bitmap2;
            height = i33;
            i5 = i32;
        }
        Bitmap bitmap3 = bitmapCreateScaledBitmap;
        int i52 = i5;
        int i53 = height;
        int[] iArr11 = iArr6;
        int i54 = 0;
        while (i54 < width2) {
            int i55 = -i2;
            int i56 = i55 * width2;
            int i57 = 0;
            int i58 = 0;
            int i59 = 0;
            int i60 = 0;
            int i61 = 0;
            int i62 = 0;
            int i63 = 0;
            int i64 = 0;
            int i65 = 0;
            while (i55 <= i2) {
                int[] iArr12 = iArr5;
                int iMax = Math.max(0, i56) + i54;
                int[] iArr13 = iArr7[i55 + i2];
                iArr13[0] = iArr2[iMax];
                iArr13[1] = iArr3[iMax];
                iArr13[2] = iArr4[iMax];
                int iAbs2 = i12 - Math.abs(i55);
                i59 += iArr2[iMax] * iAbs2;
                i58 += iArr3[iMax] * iAbs2;
                i57 += iArr4[iMax] * iAbs2;
                if (i55 > 0) {
                    i63 += iArr13[0];
                    i64 += iArr13[1];
                    i65 += iArr13[2];
                } else {
                    i62 += iArr13[0];
                    i61 += iArr13[1];
                    i60 += iArr13[2];
                }
                int i66 = i52;
                if (i55 < i66) {
                    i56 += width2;
                }
                i55++;
                i52 = i66;
                iArr5 = iArr12;
            }
            int[] iArr14 = iArr5;
            int i67 = i52;
            int i68 = i2;
            int i69 = i54;
            int i70 = i53;
            int i71 = 0;
            while (i71 < i70) {
                iArr[i69] = (iArr[i69] & (-16777216)) | (iArr11[i59] << 16) | (iArr11[i58] << 8) | iArr11[i57];
                int i72 = i59 - i62;
                int i73 = i58 - i61;
                int i74 = i57 - i60;
                int[] iArr15 = iArr7[((i68 - i2) + i7) % i7];
                int i75 = i62 - iArr15[0];
                int i76 = i61 - iArr15[1];
                int i77 = i60 - iArr15[2];
                if (i54 == 0) {
                    iArr14[i71] = Math.min(i71 + i12, i67) * width2;
                }
                int i78 = iArr14[i71] + i54;
                int i79 = iArr2[i78];
                iArr15[0] = i79;
                int i80 = iArr3[i78];
                iArr15[1] = i80;
                int i81 = iArr4[i78];
                iArr15[2] = i81;
                int i82 = i63 + i79;
                int i83 = i64 + i80;
                int i84 = i65 + i81;
                i59 = i72 + i82;
                i58 = i73 + i83;
                i57 = i74 + i84;
                i68 = (i68 + 1) % i7;
                int[] iArr16 = iArr7[i68];
                int i85 = iArr16[0];
                i62 = i75 + i85;
                int i86 = iArr16[1];
                i61 = i76 + i86;
                int i87 = iArr16[2];
                i60 = i77 + i87;
                i63 = i82 - i85;
                i64 = i83 - i86;
                i65 = i84 - i87;
                i69 += width2;
                i71++;
                i2 = i;
            }
            i54++;
            i2 = i;
            i53 = i70;
            i52 = i67;
            iArr5 = iArr14;
        }
        bitmap3.setPixels(iArr, 0, width2, 0, 0, width2, i53);
        return bitmap3;
    }
}
