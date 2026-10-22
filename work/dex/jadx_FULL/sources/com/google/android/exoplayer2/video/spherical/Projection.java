package com.google.android.exoplayer2.video.spherical;

import com.zj.adlib.sb0;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class Projection {
    public static final int b = 0;
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 2;
    public static final int f = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f31187a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final a f5368a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f5369a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final a f5370b;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface DrawMode {
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b[] f31188a;

        public a(b... bVarArr) {
            this.f31188a = bVarArr;
        }

        public b a(int i) {
            return this.f31188a[i];
        }

        public int b() {
            return this.f31188a.length;
        }
    }

    public static final class b {
        public static final int c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31189a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final float[] f5371a;
        public final int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final float[] f5372b;

        public b(int i, float[] fArr, float[] fArr2, int i2) {
            this.f31189a = i;
            sb0.a(((long) fArr.length) * 2 == ((long) fArr2.length) * 3);
            this.f5371a = fArr;
            this.f5372b = fArr2;
            this.b = i2;
        }

        public int a() {
            return this.f5371a.length / 3;
        }
    }

    public Projection(a aVar, int i) {
        this(aVar, aVar, i);
    }

    public static Projection a(float f2, int i, int i2, float f3, float f4, int i3) {
        int i4;
        int i5;
        int i6;
        float[] fArr;
        int i7;
        int i8 = i;
        int i9 = i2;
        sb0.a(f2 > 0.0f);
        sb0.a(i8 >= 1);
        sb0.a(i9 >= 1);
        sb0.a(f3 > 0.0f && f3 <= 180.0f);
        sb0.a(f4 > 0.0f && f4 <= 360.0f);
        float radians = (float) Math.toRadians(f3);
        float radians2 = (float) Math.toRadians(f4);
        float f5 = radians / i8;
        float f6 = radians2 / i9;
        int i10 = i9 + 1;
        int i11 = ((i10 * 2) + 2) * i8;
        float[] fArr2 = new float[i11 * 3];
        float[] fArr3 = new float[i11 * 2];
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < i8) {
            float f7 = radians / 2.0f;
            float f8 = (i12 * f5) - f7;
            int i15 = i12 + 1;
            float f9 = (i15 * f5) - f7;
            int i16 = 0;
            while (i16 < i10) {
                float f10 = f8;
                int i17 = i15;
                int i18 = 0;
                int i19 = 2;
                while (i18 < i19) {
                    float f11 = i16 * f6;
                    float f12 = f6;
                    int i20 = i13 + 1;
                    int i21 = i16;
                    double d2 = f2;
                    float f13 = f5;
                    double d3 = (f11 + 3.1415927f) - (radians2 / 2.0f);
                    int i22 = i18;
                    double d4 = i18 == 0 ? f10 : f9;
                    float[] fArr4 = fArr3;
                    float f14 = f9;
                    fArr2[i13] = -((float) (Math.sin(d3) * d2 * Math.cos(d4)));
                    int i23 = i20 + 1;
                    int i24 = i12;
                    fArr2[i20] = (float) (d2 * Math.sin(d4));
                    int i25 = i23 + 1;
                    fArr2[i23] = (float) (d2 * Math.cos(d3) * Math.cos(d4));
                    int i26 = i14 + 1;
                    fArr4[i14] = f11 / radians2;
                    int i27 = i26 + 1;
                    fArr4[i26] = ((i24 + i22) * f13) / radians;
                    if (i21 == 0 && i22 == 0) {
                        i4 = i2;
                        i5 = i21;
                        i6 = i22;
                    } else {
                        i4 = i2;
                        i5 = i21;
                        i6 = i22;
                        if (i5 != i4 || i6 != 1) {
                            fArr = fArr4;
                            i7 = 2;
                        }
                        i14 = i27;
                        i13 = i25;
                        i18 = i6 + 1;
                        i9 = i4;
                        i16 = i5;
                        fArr3 = fArr;
                        i19 = i7;
                        i12 = i24;
                        i10 = i10;
                        f6 = f12;
                        f5 = f13;
                        f9 = f14;
                    }
                    System.arraycopy(fArr2, i25 - 3, fArr2, i25, 3);
                    i25 += 3;
                    fArr = fArr4;
                    i7 = 2;
                    System.arraycopy(fArr, i27 - 2, fArr, i27, 2);
                    i27 += 2;
                    i14 = i27;
                    i13 = i25;
                    i18 = i6 + 1;
                    i9 = i4;
                    i16 = i5;
                    fArr3 = fArr;
                    i19 = i7;
                    i12 = i24;
                    i10 = i10;
                    f6 = f12;
                    f5 = f13;
                    f9 = f14;
                }
                float f15 = f5;
                int i28 = i16;
                int i29 = i9;
                int i30 = i28 + 1;
                f8 = f10;
                i15 = i17;
                i10 = i10;
                f5 = f15;
                f9 = f9;
                i9 = i29;
                i16 = i30;
            }
            i8 = i;
            i12 = i15;
        }
        return new Projection(new a(new b(0, fArr2, fArr3, 1)), i3);
    }

    public static Projection b(int i) {
        return a(50.0f, 36, 72, 180.0f, 360.0f, i);
    }

    public Projection(a aVar, a aVar2, int i) {
        this.f5368a = aVar;
        this.f5370b = aVar2;
        this.f31187a = i;
        this.f5369a = aVar == aVar2;
    }
}
