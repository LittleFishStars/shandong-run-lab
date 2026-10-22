package com.kwad.sdk.core.imageloader.utils;

import android.graphics.Bitmap;
import androidx.annotation.IntRange;
import androidx.core.view.MotionEventCompat;
import com.zj.adlib.xd9;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class BlurUtils {
    public static Bitmap stackBlur(Bitmap bitmap, @IntRange(from = 1, to = 180) int i, boolean z) {
        Bitmap bitmapCopy;
        int i2 = i;
        if (z) {
            bitmapCopy = bitmap;
        } else {
            Bitmap.Config config = bitmap.getConfig();
            if (config == null) {
                config = Bitmap.Config.ARGB_8888;
            }
            bitmapCopy = bitmap.copy(config, true);
        }
        if (i2 <= 0) {
            return null;
        }
        int width = bitmapCopy.getWidth();
        int height = bitmapCopy.getHeight();
        int i3 = width * height;
        int[] iArr = new int[i3];
        bitmapCopy.getPixels(iArr, 0, width, 0, 0, width, height);
        int i4 = width - 1;
        int i5 = height - 1;
        int i6 = i2 + i2 + 1;
        int[] iArr2 = new int[i3];
        int[] iArr3 = new int[i3];
        int[] iArr4 = new int[i3];
        int[] iArr5 = new int[Math.max(width, height)];
        int i7 = (i6 + 1) >> 1;
        int i8 = i7 * i7;
        int i9 = i8 * 256;
        int[] iArr6 = new int[i9];
        for (int i10 = 0; i10 < i9; i10++) {
            iArr6[i10] = i10 / i8;
        }
        int[][] iArr7 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i6, 3);
        int i11 = i2 + 1;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < height) {
            Bitmap bitmap2 = bitmapCopy;
            int i15 = height;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = -i2;
            int i25 = 0;
            while (i24 <= i2) {
                int i26 = i5;
                int[] iArr8 = iArr5;
                int i27 = iArr[i13 + Math.min(i4, Math.max(i24, 0))];
                int[] iArr9 = iArr7[i24 + i2];
                iArr9[0] = (i27 & xd9.p) >> 16;
                iArr9[1] = (i27 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr9[2] = i27 & 255;
                int iAbs = i11 - Math.abs(i24);
                int i28 = iArr9[0];
                i25 += i28 * iAbs;
                int i29 = iArr9[1];
                i16 += i29 * iAbs;
                int i30 = iArr9[2];
                i17 += iAbs * i30;
                if (i24 > 0) {
                    i21 += i28;
                    i22 += i29;
                    i23 += i30;
                } else {
                    i18 += i28;
                    i19 += i29;
                    i20 += i30;
                }
                i24++;
                i5 = i26;
                iArr5 = iArr8;
            }
            int i31 = i5;
            int[] iArr10 = iArr5;
            int i32 = i2;
            int i33 = i25;
            int i34 = 0;
            while (i34 < width) {
                iArr2[i13] = iArr6[i33];
                iArr3[i13] = iArr6[i16];
                iArr4[i13] = iArr6[i17];
                int i35 = i33 - i18;
                int i36 = i16 - i19;
                int i37 = i17 - i20;
                int[] iArr11 = iArr7[((i32 - i2) + i6) % i6];
                int i38 = i18 - iArr11[0];
                int i39 = i19 - iArr11[1];
                int i40 = i20 - iArr11[2];
                if (i12 == 0) {
                    iArr10[i34] = Math.min(i34 + i2 + 1, i4);
                }
                int i41 = iArr[i14 + iArr10[i34]];
                int i42 = (i41 & xd9.p) >> 16;
                iArr11[0] = i42;
                int i43 = (i41 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr11[1] = i43;
                int i44 = i41 & 255;
                iArr11[2] = i44;
                int i45 = i21 + i42;
                int i46 = i22 + i43;
                int i47 = i23 + i44;
                i33 = i35 + i45;
                i16 = i36 + i46;
                i17 = i37 + i47;
                i32 = (i32 + 1) % i6;
                int[] iArr12 = iArr7[i32 % i6];
                int i48 = iArr12[0];
                i18 = i38 + i48;
                int i49 = iArr12[1];
                i19 = i39 + i49;
                int i50 = iArr12[2];
                i20 = i40 + i50;
                i21 = i45 - i48;
                i22 = i46 - i49;
                i23 = i47 - i50;
                i13++;
                i34++;
                iArr6 = iArr6;
            }
            i14 += width;
            i12++;
            bitmapCopy = bitmap2;
            height = i15;
            i5 = i31;
            iArr5 = iArr10;
        }
        Bitmap bitmap3 = bitmapCopy;
        int i51 = i5;
        int[] iArr13 = iArr5;
        int i52 = height;
        int[] iArr14 = iArr6;
        int i53 = 0;
        while (i53 < width) {
            int i54 = -i2;
            int i55 = i6;
            int[] iArr15 = iArr;
            int i56 = 0;
            int i57 = 0;
            int i58 = 0;
            int i59 = 0;
            int i60 = 0;
            int i61 = 0;
            int i62 = 0;
            int i63 = i54;
            int i64 = i54 * width;
            int i65 = 0;
            int i66 = 0;
            while (i63 <= i2) {
                int i67 = width;
                int iMax = Math.max(0, i64) + i53;
                int[] iArr16 = iArr7[i63 + i2];
                iArr16[0] = iArr2[iMax];
                iArr16[1] = iArr3[iMax];
                iArr16[2] = iArr4[iMax];
                int iAbs2 = i11 - Math.abs(i63);
                i65 += iArr2[iMax] * iAbs2;
                i66 += iArr3[iMax] * iAbs2;
                i56 += iArr4[iMax] * iAbs2;
                if (i63 > 0) {
                    i60 += iArr16[0];
                    i61 += iArr16[1];
                    i62 += iArr16[2];
                } else {
                    i57 += iArr16[0];
                    i58 += iArr16[1];
                    i59 += iArr16[2];
                }
                int i68 = i51;
                if (i63 < i68) {
                    i64 += i67;
                }
                i63++;
                i51 = i68;
                width = i67;
            }
            int i69 = width;
            int i70 = i51;
            int i71 = i2;
            int i72 = i53;
            int i73 = i52;
            int i74 = 0;
            while (i74 < i73) {
                iArr15[i72] = (iArr15[i72] & (-16777216)) | (iArr14[i65] << 16) | (iArr14[i66] << 8) | iArr14[i56];
                int i75 = i65 - i57;
                int i76 = i66 - i58;
                int i77 = i56 - i59;
                int[] iArr17 = iArr7[((i71 - i2) + i55) % i55];
                int i78 = i57 - iArr17[0];
                int i79 = i58 - iArr17[1];
                int i80 = i59 - iArr17[2];
                if (i53 == 0) {
                    iArr13[i74] = Math.min(i74 + i11, i70) * i69;
                }
                int i81 = iArr13[i74] + i53;
                int i82 = iArr2[i81];
                iArr17[0] = i82;
                int i83 = iArr3[i81];
                iArr17[1] = i83;
                int i84 = iArr4[i81];
                iArr17[2] = i84;
                int i85 = i60 + i82;
                int i86 = i61 + i83;
                int i87 = i62 + i84;
                i65 = i75 + i85;
                i66 = i76 + i86;
                i56 = i77 + i87;
                i71 = (i71 + 1) % i55;
                int[] iArr18 = iArr7[i71];
                int i88 = iArr18[0];
                i57 = i78 + i88;
                int i89 = iArr18[1];
                i58 = i79 + i89;
                int i90 = iArr18[2];
                i59 = i80 + i90;
                i60 = i85 - i88;
                i61 = i86 - i89;
                i62 = i87 - i90;
                i72 += i69;
                i74++;
                i2 = i;
            }
            i53++;
            i2 = i;
            i51 = i70;
            i52 = i73;
            i6 = i55;
            iArr = iArr15;
            width = i69;
        }
        int i91 = width;
        bitmap3.setPixels(iArr, 0, i91, 0, 0, i91, i52);
        return bitmap3;
    }
}
