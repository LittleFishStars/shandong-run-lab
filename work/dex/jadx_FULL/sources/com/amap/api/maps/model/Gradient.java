package com.amap.api.maps.model;

import android.graphics.Color;
import android.util.Log;
import com.amap.api.maps.AMapException;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class Gradient {
    private static final int DEFAULT_COLOR_MAP_SIZE = 1000;
    private boolean isAvailable;
    private int mColorMapSize;
    private int[] mColors;
    private float[] mStartPoints;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f26120a;
        private final int b;
        private final float c;

        public /* synthetic */ a(int i, int i2, float f, byte b) {
            this(i, i2, f);
        }

        private a(int i, int i2, float f) {
            this.f26120a = i;
            this.b = i2;
            this.c = f;
        }
    }

    public Gradient(int[] iArr, float[] fArr) {
        this(iArr, fArr, (byte) 0);
    }

    private HashMap<Integer, a> a() {
        HashMap<Integer, a> map = new HashMap<>(32);
        byte b = 0;
        if (this.mStartPoints[0] != 0.0f) {
            map.put(0, new a(Color.argb(0, Color.red(this.mColors[0]), Color.green(this.mColors[0]), Color.blue(this.mColors[0])), this.mColors[0], this.mColorMapSize * this.mStartPoints[0], b));
        }
        for (int i = 1; i < this.mColors.length; i++) {
            int i2 = i - 1;
            Integer numValueOf = Integer.valueOf((int) (this.mColorMapSize * this.mStartPoints[i2]));
            int[] iArr = this.mColors;
            int i3 = iArr[i2];
            int i4 = iArr[i];
            float f = this.mColorMapSize;
            float[] fArr = this.mStartPoints;
            map.put(numValueOf, new a(i3, i4, f * (fArr[i] - fArr[i2]), b));
        }
        float[] fArr2 = this.mStartPoints;
        if (fArr2[fArr2.length - 1] != 1.0f) {
            int length = fArr2.length - 1;
            Integer numValueOf2 = Integer.valueOf((int) (this.mColorMapSize * fArr2[length]));
            int i5 = this.mColors[length];
            map.put(numValueOf2, new a(i5, i5, this.mColorMapSize * (1.0f - this.mStartPoints[length]), b));
        }
        return map;
    }

    public int[] generateColorMap(double d) {
        HashMap<Integer, a> mapA = a();
        int[] iArr = new int[this.mColorMapSize];
        a aVar = mapA.get(0);
        int i = 0;
        for (int i2 = 0; i2 < this.mColorMapSize; i2++) {
            if (mapA.containsKey(Integer.valueOf(i2))) {
                aVar = mapA.get(Integer.valueOf(i2));
                i = i2;
            }
            iArr[i2] = a(aVar.f26120a, aVar.b, (i2 - i) / aVar.c);
        }
        if (d != 1.0d) {
            for (int i3 = 0; i3 < this.mColorMapSize; i3++) {
                int i4 = iArr[i3];
                iArr[i3] = Color.argb((int) (((double) Color.alpha(i4)) * d), Color.red(i4), Color.green(i4), Color.blue(i4));
            }
        }
        return iArr;
    }

    public int[] getColors() {
        return this.mColors;
    }

    public float[] getStartPoints() {
        return this.mStartPoints;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }

    private Gradient(int[] iArr, float[] fArr, byte b) {
        this.isAvailable = true;
        try {
            if (iArr == null || fArr == null) {
                throw new AMapException("colors and startPoints should not be null");
            }
            if (iArr.length != fArr.length) {
                throw new AMapException("colors and startPoints should be same length");
            }
            if (iArr.length == 0) {
                throw new AMapException("No colors have been defined");
            }
            for (int i = 1; i < fArr.length; i++) {
                if (fArr[i] < fArr[i - 1]) {
                    throw new AMapException("startPoints should be in increasing order");
                }
            }
            this.mColorMapSize = 1000;
            int[] iArr2 = new int[iArr.length];
            this.mColors = iArr2;
            this.mStartPoints = new float[fArr.length];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            System.arraycopy(fArr, 0, this.mStartPoints, 0, fArr.length);
            this.isAvailable = true;
        } catch (AMapException e) {
            this.isAvailable = false;
            Log.e("amap", e.getErrorMessage());
            e.printStackTrace();
        }
    }

    private static int a(int i, int i2, float f) {
        int iAlpha = (int) (((Color.alpha(i2) - Color.alpha(i)) * f) + Color.alpha(i));
        float[] fArr = new float[3];
        Color.RGBToHSV(Color.red(i), Color.green(i), Color.blue(i), fArr);
        float[] fArr2 = new float[3];
        Color.RGBToHSV(Color.red(i2), Color.green(i2), Color.blue(i2), fArr2);
        float f2 = fArr[0];
        float f3 = fArr2[0];
        if (f2 - f3 > 180.0f) {
            fArr2[0] = f3 + 360.0f;
        } else if (f3 - f2 > 180.0f) {
            fArr[0] = f2 + 360.0f;
        }
        float[] fArr3 = new float[3];
        for (int i3 = 0; i3 < 3; i3++) {
            float f4 = fArr2[i3];
            float f5 = fArr[i3];
            fArr3[i3] = ((f4 - f5) * f) + f5;
        }
        return Color.HSVToColor(iAlpha, fArr3);
    }
}
