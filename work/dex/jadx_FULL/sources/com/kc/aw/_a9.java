package com.kc.aw;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import androidx.core.view.MotionEventCompat;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.xd9;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _a9 {
    public static Bitmap _a(Bitmap bitmap) {
        float f = 10;
        int iRound = Math.round(bitmap.getWidth() / f);
        int iRound2 = Math.round(bitmap.getHeight() / f);
        try {
            return ThumbnailUtils.extractThumbnail(_b(ThumbnailUtils.extractThumbnail(bitmap, iRound, iRound2)), iRound * 2, iRound2 * 2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Bitmap _b(Bitmap bitmap) {
        int i;
        Bitmap bitmap2;
        Bitmap bitmapCopy = bitmap.copy(bitmap.getConfig(), true);
        int width = bitmapCopy.getWidth();
        int height = bitmapCopy.getHeight();
        int i2 = width * height;
        int[] iArr = new int[i2];
        bitmapCopy.getPixels(iArr, 0, width, 0, 0, width, height);
        int i3 = width - 1;
        int i4 = height - 1;
        int[] iArr2 = new int[i2];
        int[] iArr3 = new int[i2];
        int[] iArr4 = new int[i2];
        int[] iArr5 = new int[Math.max(width, height)];
        int[] iArr6 = new int[173056];
        int i5 = 0;
        for (int i6 = 0; i6 < 173056; i6++) {
            iArr6[i6] = i6 / 676;
        }
        int[][] iArr7 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 51, 3);
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            i = 25;
            if (i7 >= height) {
                break;
            }
            int i10 = i5;
            int i11 = i10;
            int i12 = i11;
            int i13 = i12;
            int i14 = i13;
            int i15 = i14;
            int i16 = i15;
            int i17 = i16;
            int i18 = -25;
            int i19 = i17;
            while (true) {
                bitmap2 = bitmapCopy;
                if (i18 > 25) {
                    break;
                }
                int i20 = iArr[Math.min(i3, Math.max(i18, i5)) + i8];
                int[] iArr8 = iArr7[i18 + 25];
                iArr8[i5] = (i20 & xd9.p) >> 16;
                iArr8[1] = (i20 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr8[2] = i20 & 255;
                int iAbs = 26 - Math.abs(i18);
                int i21 = iArr8[i5];
                i10 += i21 * iAbs;
                int i22 = iArr8[1];
                i13 = (i22 * iAbs) + i13;
                int i23 = iArr8[2];
                i14 = (iAbs * i23) + i14;
                if (i18 > 0) {
                    i19 += i21;
                    i11 += i22;
                    i12 += i23;
                } else {
                    i15 += i21;
                    i16 += i22;
                    i17 += i23;
                }
                i18++;
                bitmapCopy = bitmap2;
            }
            int i24 = i5;
            int i25 = 25;
            while (i24 < width) {
                iArr2[i8] = iArr6[i10];
                iArr3[i8] = iArr6[i13];
                iArr4[i8] = iArr6[i14];
                int[] iArr9 = iArr7[((i25 - 25) + 51) % 51];
                int i26 = iArr9[i5];
                int i27 = iArr9[1];
                int i28 = iArr9[2];
                if (i7 == 0) {
                    iArr5[i24] = Math.min(i24 + 25 + 1, i3);
                }
                int i29 = iArr[iArr5[i24] + i9];
                int i30 = (i29 & xd9.p) >> 16;
                iArr9[0] = i30;
                int i31 = (i29 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr9[1] = i31;
                int i32 = i29 & 255;
                iArr9[2] = i32;
                int i33 = i19 + i30;
                int i34 = i11 + i31;
                int i35 = i32 + i12;
                i25 = (i25 + 1) % 51;
                int[] iArr10 = iArr7[i25 % 51];
                int i36 = iArr10[0];
                int i37 = iArr10[1];
                int i38 = iArr10[2];
                int i39 = i35 - i38;
                i14 = (i14 - i17) + i35;
                i13 = (i13 - i16) + i34;
                i10 = (i10 - i15) + i33;
                i8++;
                i24++;
                i15 = (i15 - i26) + i36;
                i16 = (i16 - i27) + i37;
                i17 = (i17 - i28) + i38;
                i19 = i33 - i36;
                i11 = i34 - i37;
                i5 = 0;
                i12 = i39;
            }
            i9 += width;
            i7++;
            bitmapCopy = bitmap2;
        }
        int i40 = i5;
        while (i40 < width) {
            int i41 = width * (-25);
            int i42 = i5;
            int i43 = i42;
            int i44 = i43;
            int i45 = i44;
            int i46 = i45;
            int i47 = i46;
            int i48 = i47;
            int i49 = i48;
            int i50 = i49;
            for (int i51 = -25; i51 <= i; i51++) {
                int iMax = Math.max(i5, i41) + i40;
                int[] iArr11 = iArr7[i51 + 25];
                iArr11[i5] = iArr2[iMax];
                iArr11[1] = iArr3[iMax];
                iArr11[2] = iArr4[iMax];
                int iAbs2 = 26 - Math.abs(i51);
                i45 = (iArr2[iMax] * iAbs2) + i45;
                i46 = (iArr3[iMax] * iAbs2) + i46;
                i47 = (iArr4[iMax] * iAbs2) + i47;
                if (i51 > 0) {
                    i42 += iArr11[i5];
                    i43 += iArr11[1];
                    i44 += iArr11[2];
                } else {
                    i48 += iArr11[i5];
                    i49 += iArr11[1];
                    i50 += iArr11[2];
                }
                if (i51 < i4) {
                    i41 += width;
                }
            }
            int i52 = i40;
            int i53 = i;
            int i54 = i5;
            while (i54 < height) {
                iArr[i52] = (iArr[i52] & (-16777216)) | (iArr6[i45] << 16) | (iArr6[i46] << 8) | iArr6[i47];
                int[] iArr12 = iArr7[((i53 - 25) + 51) % 51];
                int i55 = iArr12[i5];
                int i56 = iArr12[1];
                int i57 = iArr12[2];
                if (i40 == 0) {
                    iArr5[i54] = Math.min(i54 + 26, i4) * width;
                }
                int i58 = iArr5[i54] + i40;
                int i59 = iArr2[i58];
                iArr12[i5] = i59;
                int i60 = iArr3[i58];
                iArr12[1] = i60;
                int i61 = iArr4[i58];
                iArr12[2] = i61;
                int i62 = i42 + i59;
                int i63 = i43 + i60;
                int i64 = i44 + i61;
                i45 = (i45 - i48) + i62;
                i46 = (i46 - i49) + i63;
                i53 = (i53 + 1) % 51;
                int[] iArr13 = iArr7[i53];
                int i65 = iArr13[i5];
                i48 = (i48 - i55) + i65;
                int i66 = iArr13[1];
                i49 = (i49 - i56) + i66;
                int i67 = iArr13[2];
                i42 = i62 - i65;
                i52 += width;
                i54++;
                i47 = (i47 - i50) + i64;
                i43 = i63 - i66;
                i44 = i64 - i67;
                i50 = (i50 - i57) + i67;
            }
            i40++;
            i = 25;
        }
        bitmapCopy.setPixels(iArr, 0, width, 0, 0, width, height);
        return bitmapCopy;
    }
}
