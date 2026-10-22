package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import androidx.camera.video.AudioStats;
import androidx.collection.LongSparseArray;
import com.amap.api.maps.AMapException;
import com.autonavi.amap.mapcore.DPoint;
import com.zj.adlib.cwa;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class HeatmapTileProvider implements TileProvider {
    public static final Gradient DEFAULT_GRADIENT;
    private static final int[] DEFAULT_GRADIENT_COLORS;
    private static final float[] DEFAULT_GRADIENT_START_POINTS;
    private static final int DEFAULT_MAX_ZOOM = 11;
    private static final int DEFAULT_MIN_ZOOM = 5;
    public static final double DEFAULT_OPACITY = 0.6d;
    public static final int DEFAULT_RADIUS = 12;
    private static final int MAX_RADIUS = 50;
    private static final int MAX_ZOOM_LEVEL = 21;
    private static final int MIN_RADIUS = 10;
    private static final int SCREEN_SIZE = 1280;
    private static final int TILE_DIM = 256;
    private cwa mBounds;
    private int[] mColorMap;
    private Collection<WeightedLatLng> mData;
    private Gradient mGradient;
    private double[] mKernel;
    private double[] mMaxIntensity;
    private double mOpacity;
    private int mRadius;
    private a mTree;

    public static class Builder {
        private Collection<WeightedLatLng> data;
        private int radius = 12;
        private Gradient gradient = HeatmapTileProvider.DEFAULT_GRADIENT;
        private double opacity = 0.6d;

        public HeatmapTileProvider build() {
            Collection<WeightedLatLng> collection = this.data;
            if (collection != null && collection.size() != 0) {
                try {
                    return new HeatmapTileProvider(this, (byte) 0);
                } catch (Throwable th) {
                    th.printStackTrace();
                    return null;
                }
            }
            try {
                throw new AMapException("No input points.");
            } catch (AMapException e) {
                Log.e("amap", e.getErrorMessage());
                e.printStackTrace();
                return null;
            }
        }

        public Builder data(Collection<LatLng> collection) {
            return weightedData(HeatmapTileProvider.c(collection));
        }

        public Builder gradient(Gradient gradient) {
            this.gradient = gradient;
            return this;
        }

        public Builder radius(int i) {
            this.radius = Math.max(10, Math.min(i, 50));
            return this;
        }

        public Builder transparency(double d) {
            this.opacity = Math.max(AudioStats.AUDIO_AMPLITUDE_NONE, Math.min(d, 1.0d));
            return this;
        }

        public Builder weightedData(Collection<WeightedLatLng> collection) {
            this.data = collection;
            return this;
        }
    }

    static {
        int[] iArr = {Color.rgb(102, 225, 0), Color.rgb(255, 0, 0)};
        DEFAULT_GRADIENT_COLORS = iArr;
        float[] fArr = {0.2f, 1.0f};
        DEFAULT_GRADIENT_START_POINTS = fArr;
        DEFAULT_GRADIENT = new Gradient(iArr, fArr);
    }

    public /* synthetic */ HeatmapTileProvider(Builder builder, byte b) {
        this(builder);
    }

    private void b(Collection<WeightedLatLng> collection) {
        try {
            ArrayList arrayList = new ArrayList();
            for (WeightedLatLng weightedLatLng : collection) {
                double d = weightedLatLng.latLng.latitude;
                if (d < 85.0d && d > -85.0d) {
                    arrayList.add(weightedLatLng);
                }
            }
            this.mData = arrayList;
            cwa cwaVarD = d(arrayList);
            this.mBounds = cwaVarD;
            this.mTree = new a(cwaVarD);
            Iterator<WeightedLatLng> it = this.mData.iterator();
            while (it.hasNext()) {
                this.mTree.a(it.next());
            }
            this.mMaxIntensity = a(this.mRadius);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Collection<WeightedLatLng> c(Collection<LatLng> collection) {
        ArrayList arrayList = new ArrayList();
        Iterator<LatLng> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new WeightedLatLng(it.next()));
        }
        return arrayList;
    }

    private static cwa d(Collection<WeightedLatLng> collection) {
        Iterator<WeightedLatLng> it = collection.iterator();
        WeightedLatLng next = it.next();
        double d = next.getPoint().x;
        double d2 = next.getPoint().x;
        double d3 = d;
        double d4 = d2;
        double d5 = next.getPoint().y;
        double d6 = next.getPoint().y;
        while (it.hasNext()) {
            WeightedLatLng next2 = it.next();
            double d7 = next2.getPoint().x;
            double d8 = next2.getPoint().y;
            if (d7 < d3) {
                d3 = d7;
            }
            if (d7 > d4) {
                d4 = d7;
            }
            if (d8 < d5) {
                d5 = d8;
            }
            if (d8 > d6) {
                d6 = d8;
            }
        }
        return new cwa(d3, d4, d5, d6);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:14:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:16:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:18:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:21:0x00d9 A[LOOP:0: B:19:0x00d3->B:21:0x00d9, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:25:0x0102 A[LOOP:1: B:23:0x00fc->B:25:0x0102, LOOP_END] */
    @Override // com.amap.api.maps.model.TileProvider
    public Tile getTile(int i, int i2, int i3) {
        double d;
        double d2;
        cwa cwaVar;
        cwa cwaVar2;
        Collection<WeightedLatLng> collectionA;
        double[][] dArr;
        double dPow = 1.0d / Math.pow(2.0d, i3);
        int i4 = this.mRadius;
        double d3 = (((double) i4) * dPow) / 256.0d;
        double d4 = ((2.0d * d3) + dPow) / ((double) ((i4 * 2) + 256));
        double d5 = (((double) i) * dPow) - d3;
        double d6 = (((double) (i + 1)) * dPow) + d3;
        double d7 = (((double) i2) * dPow) - d3;
        double d8 = (((double) (i2 + 1)) * dPow) + d3;
        Collection<WeightedLatLng> arrayList = new ArrayList<>();
        if (d5 >= AudioStats.AUDIO_AMPLITUDE_NONE) {
            d = 1.0d;
            if (d6 > 1.0d) {
                arrayList = this.mTree.a(new cwa(AudioStats.AUDIO_AMPLITUDE_NONE, d6 - 1.0d, d7, d8));
            } else {
                d2 = 0.0d;
            }
            cwaVar = new cwa(d5, d6, d7, d8);
            cwaVar2 = this.mBounds;
            if (!cwaVar.d(new cwa(cwaVar2.f41056a - d3, cwaVar2.c + d3, cwaVar2.b - d3, cwaVar2.d + d3))) {
                return TileProvider.NO_TILE;
            }
            collectionA = this.mTree.a(cwaVar);
            if (collectionA.isEmpty()) {
                return TileProvider.NO_TILE;
            }
            int i5 = this.mRadius;
            dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, (i5 * 2) + 256, (i5 * 2) + 256);
            for (WeightedLatLng weightedLatLng : collectionA) {
                DPoint point = weightedLatLng.getPoint();
                int i6 = (int) ((point.x - d5) / d4);
                int i7 = (int) ((point.y - d7) / d4);
                double[] dArr2 = dArr[i6];
                dArr2[i7] = dArr2[i7] + weightedLatLng.intensity;
            }
            for (WeightedLatLng weightedLatLng2 : arrayList) {
                DPoint point2 = weightedLatLng2.getPoint();
                int i8 = (int) (((point2.x + d2) - d5) / d4);
                int i9 = (int) ((point2.y - d7) / d4);
                double[] dArr3 = dArr[i8];
                dArr3[i9] = dArr3[i9] + weightedLatLng2.intensity;
            }
            return a(a(a(dArr, this.mKernel), this.mColorMap, this.mMaxIntensity[i3]));
        }
        arrayList = this.mTree.a(new cwa(d5 + 1.0d, 1.0d, d7, d8));
        d = -1.0d;
        d2 = d;
        cwaVar = new cwa(d5, d6, d7, d8);
        cwaVar2 = this.mBounds;
        if (!cwaVar.d(new cwa(cwaVar2.f41056a - d3, cwaVar2.c + d3, cwaVar2.b - d3, cwaVar2.d + d3))) {
            return TileProvider.NO_TILE;
        }
        collectionA = this.mTree.a(cwaVar);
        if (collectionA.isEmpty()) {
            return TileProvider.NO_TILE;
        }
        int i10 = this.mRadius;
        dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, (i10 * 2) + 256, (i10 * 2) + 256);
        while (r1.hasNext()) {
            DPoint point3 = weightedLatLng.getPoint();
            int i11 = (int) ((point3.x - d5) / d4);
            int i12 = (int) ((point3.y - d7) / d4);
            double[] dArr4 = dArr[i11];
            dArr4[i12] = dArr4[i12] + weightedLatLng.intensity;
        }
        while (r1.hasNext()) {
            DPoint point4 = weightedLatLng2.getPoint();
            int i13 = (int) (((point4.x + d2) - d5) / d4);
            int i14 = (int) ((point4.y - d7) / d4);
            double[] dArr5 = dArr[i13];
            dArr5[i14] = dArr5[i14] + weightedLatLng2.intensity;
        }
        return a(a(a(dArr, this.mKernel), this.mColorMap, this.mMaxIntensity[i3]));
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileHeight() {
        return 256;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileWidth() {
        return 256;
    }

    private HeatmapTileProvider(Builder builder) {
        this.mData = builder.data;
        this.mRadius = builder.radius;
        Gradient gradient = builder.gradient;
        this.mGradient = gradient;
        if (gradient == null || !gradient.isAvailable()) {
            this.mGradient = DEFAULT_GRADIENT;
        }
        this.mOpacity = builder.opacity;
        int i = this.mRadius;
        this.mKernel = a(i, ((double) i) / 3.0d);
        a(this.mGradient);
        b(this.mData);
    }

    private void a(Gradient gradient) {
        this.mGradient = gradient;
        this.mColorMap = gradient.generateColorMap(this.mOpacity);
    }

    private double[] a(int i) {
        int i2;
        double[] dArr = new double[21];
        int i3 = 5;
        while (true) {
            if (i3 >= 11) {
                break;
            }
            dArr[i3] = a(this.mData, this.mBounds, i, (int) (Math.pow(2.0d, i3) * 1280.0d));
            if (i3 == 5) {
                for (int i4 = 0; i4 < i3; i4++) {
                    dArr[i4] = dArr[i3];
                }
            }
            i3++;
        }
        for (i2 = 11; i2 < 21; i2++) {
            dArr[i2] = dArr[10];
        }
        return dArr;
    }

    private static Tile a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return Tile.obtain(256, 256, byteArrayOutputStream.toByteArray());
    }

    private static double[] a(int i, double d) {
        double[] dArr = new double[(i * 2) + 1];
        for (int i2 = -i; i2 <= i; i2++) {
            dArr[i2 + i] = Math.exp(((double) ((-i2) * i2)) / ((2.0d * d) * d));
        }
        return dArr;
    }

    private static double[][] a(double[][] dArr, double[] dArr2) {
        int iFloor = (int) Math.floor(((double) dArr2.length) / 2.0d);
        int length = dArr.length;
        int i = length - (iFloor * 2);
        int i2 = 1;
        int i3 = (iFloor + i) - 1;
        double[][] dArr3 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, length);
        int i4 = 0;
        while (true) {
            double d = AudioStats.AUDIO_AMPLITUDE_NONE;
            if (i4 >= length) {
                break;
            }
            int i5 = 0;
            while (i5 < length) {
                double d2 = dArr[i4][i5];
                if (d2 != d) {
                    int i6 = i4 + iFloor;
                    if (i3 < i6) {
                        i6 = i3;
                    }
                    int i7 = i6 + 1;
                    int i8 = i4 - iFloor;
                    for (int i9 = iFloor > i8 ? iFloor : i8; i9 < i7; i9++) {
                        double[] dArr4 = dArr3[i9];
                        dArr4[i5] = dArr4[i5] + (dArr2[i9 - i8] * d2);
                    }
                }
                i5++;
                d = AudioStats.AUDIO_AMPLITUDE_NONE;
            }
            i4++;
        }
        double[][] dArr5 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i, i);
        int i10 = iFloor;
        while (i10 < i3 + 1) {
            int i11 = 0;
            while (i11 < length) {
                double d3 = dArr3[i10][i11];
                if (d3 != AudioStats.AUDIO_AMPLITUDE_NONE) {
                    int i12 = i11 + iFloor;
                    if (i3 < i12) {
                        i12 = i3;
                    }
                    int i13 = i12 + i2;
                    int i14 = i11 - iFloor;
                    for (int i15 = iFloor > i14 ? iFloor : i14; i15 < i13; i15++) {
                        double[] dArr6 = dArr5[i10 - iFloor];
                        int i16 = i15 - iFloor;
                        dArr6[i16] = dArr6[i16] + (dArr2[i15 - i14] * d3);
                    }
                }
                i11++;
                i2 = 1;
            }
            i10++;
            i2 = 1;
        }
        return dArr5;
    }

    private static Bitmap a(double[][] dArr, int[] iArr, double d) {
        int i = iArr[iArr.length - 1];
        double length = ((double) (iArr.length - 1)) / d;
        int length2 = dArr.length;
        int[] iArr2 = new int[length2 * length2];
        for (int i2 = 0; i2 < length2; i2++) {
            for (int i3 = 0; i3 < length2; i3++) {
                double d2 = dArr[i3][i2];
                int i4 = (i2 * length2) + i3;
                int i5 = (int) (d2 * length);
                if (d2 != AudioStats.AUDIO_AMPLITUDE_NONE) {
                    if (i5 < iArr.length) {
                        iArr2[i4] = iArr[i5];
                    } else {
                        iArr2[i4] = i;
                    }
                } else {
                    iArr2[i4] = 0;
                }
            }
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(length2, length2, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.setPixels(iArr2, 0, length2, 0, 0, length2, length2);
        return bitmapCreateBitmap;
    }

    private static double a(Collection<WeightedLatLng> collection, cwa cwaVar, int i, int i2) {
        double d = cwaVar.f41056a;
        double d2 = cwaVar.c;
        double d3 = cwaVar.b;
        double d4 = d2 - d;
        double d5 = cwaVar.d - d3;
        if (d4 <= d5) {
            d4 = d5;
        }
        double d6 = ((double) ((int) (((double) (i2 / (i * 2))) + 0.5d))) / d4;
        LongSparseArray longSparseArray = new LongSparseArray();
        double dDoubleValue = AudioStats.AUDIO_AMPLITUDE_NONE;
        for (WeightedLatLng weightedLatLng : collection) {
            double d7 = weightedLatLng.getPoint().x;
            int i3 = (int) ((weightedLatLng.getPoint().y - d3) * d6);
            long j = (int) ((d7 - d) * d6);
            LongSparseArray longSparseArray2 = (LongSparseArray) longSparseArray.get(j);
            if (longSparseArray2 == null) {
                longSparseArray2 = new LongSparseArray();
                longSparseArray.put(j, longSparseArray2);
            }
            long j2 = i3;
            Double dValueOf = (Double) longSparseArray2.get(j2);
            if (dValueOf == null) {
                dValueOf = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
            }
            LongSparseArray longSparseArray3 = longSparseArray;
            double d8 = d;
            Double dValueOf2 = Double.valueOf(dValueOf.doubleValue() + weightedLatLng.intensity);
            longSparseArray2.put(j2, dValueOf2);
            if (dValueOf2.doubleValue() > dDoubleValue) {
                dDoubleValue = dValueOf2.doubleValue();
            }
            longSparseArray = longSparseArray3;
            d = d8;
        }
        return dDoubleValue;
    }
}
