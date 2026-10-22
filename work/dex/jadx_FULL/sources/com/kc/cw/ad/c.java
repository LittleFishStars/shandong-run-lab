package com.kc.cw.ad;

import android.graphics.Matrix;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private C0970c f38721a;
    private C0970c b;

    /* JADX INFO: renamed from: com.kc.cw.ad.c$1, reason: invalid class name */
    @Keep
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final int[] f38722a;
        static final int[] b;

        static {
            int[] iArr = new int[a.values().length];
            b = iArr;
            try {
                iArr[a.LEFT_TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[a.LEFT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[a.LEFT_BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[a.CENTER_TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[a.CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[a.CENTER_BOTTOM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[a.RIGHT_TOP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[a.RIGHT_CENTER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                b[a.RIGHT_BOTTOM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr2 = new int[b.values().length];
            f38722a = iArr2;
            try {
                iArr2[b.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f38722a[b.FIT_XY.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f38722a[b.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f38722a[b.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f38722a[b.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f38722a[b.LEFT_TOP.ordinal()] = 6;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f38722a[b.LEFT_CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f38722a[b.LEFT_BOTTOM.ordinal()] = 8;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f38722a[b.CENTER_TOP.ordinal()] = 9;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f38722a[b.CENTER.ordinal()] = 10;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f38722a[b.CENTER_BOTTOM.ordinal()] = 11;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f38722a[b.RIGHT_TOP.ordinal()] = 12;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f38722a[b.RIGHT_CENTER.ordinal()] = 13;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f38722a[b.RIGHT_BOTTOM.ordinal()] = 14;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f38722a[b.LEFT_TOP_CROP.ordinal()] = 15;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f38722a[b.LEFT_CENTER_CROP.ordinal()] = 16;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f38722a[b.LEFT_BOTTOM_CROP.ordinal()] = 17;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f38722a[b.CENTER_TOP_CROP.ordinal()] = 18;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                f38722a[b.CENTER_CROP.ordinal()] = 19;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f38722a[b.CENTER_BOTTOM_CROP.ordinal()] = 20;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                f38722a[b.RIGHT_TOP_CROP.ordinal()] = 21;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                f38722a[b.RIGHT_CENTER_CROP.ordinal()] = 22;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                f38722a[b.RIGHT_BOTTOM_CROP.ordinal()] = 23;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                f38722a[b.START_INSIDE.ordinal()] = 24;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                f38722a[b.CENTER_INSIDE.ordinal()] = 25;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                f38722a[b.END_INSIDE.ordinal()] = 26;
            } catch (NoSuchFieldError unused35) {
            }
        }
    }

    @Keep
    public enum a {
        LEFT_TOP,
        LEFT_CENTER,
        LEFT_BOTTOM,
        CENTER_TOP,
        CENTER,
        CENTER_BOTTOM,
        RIGHT_TOP,
        RIGHT_CENTER,
        RIGHT_BOTTOM
    }

    @Keep
    public enum b {
        NONE,
        FIT_XY,
        FIT_START,
        FIT_CENTER,
        FIT_END,
        LEFT_TOP,
        LEFT_CENTER,
        LEFT_BOTTOM,
        CENTER_TOP,
        CENTER,
        CENTER_BOTTOM,
        RIGHT_TOP,
        RIGHT_CENTER,
        RIGHT_BOTTOM,
        LEFT_TOP_CROP,
        LEFT_CENTER_CROP,
        LEFT_BOTTOM_CROP,
        CENTER_TOP_CROP,
        CENTER_CROP,
        CENTER_BOTTOM_CROP,
        RIGHT_TOP_CROP,
        RIGHT_CENTER_CROP,
        RIGHT_BOTTOM_CROP,
        START_INSIDE,
        CENTER_INSIDE,
        END_INSIDE
    }

    /* JADX INFO: renamed from: com.kc.cw.ad.c$c, reason: collision with other inner class name */
    @Keep
    public static class C0970c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f38725a;
        private int b;

        public C0970c(int i, int i2) {
            this.f38725a = i;
            this.b = i2;
        }

        public int a() {
            return this.f38725a;
        }

        public int b() {
            return this.b;
        }
    }

    public c(C0970c c0970c, C0970c c0970c2) {
        this.f38721a = c0970c;
        this.b = c0970c2;
    }

    private Matrix a() {
        return a(this.b.a() / this.f38721a.a(), this.b.b() / this.f38721a.b(), a.LEFT_TOP);
    }

    private Matrix a(float f, float f2, float f3, float f4) {
        Matrix matrix = new Matrix();
        matrix.setScale(f, f2, f3, f4);
        return matrix;
    }

    private Matrix a(float f, float f2, a aVar) {
        switch (AnonymousClass1.b[aVar.ordinal()]) {
            case 1:
                return a(f, f2, 0.0f, 0.0f);
            case 2:
                return a(f, f2, 0.0f, this.f38721a.b() / 2.0f);
            case 3:
                return a(f, f2, 0.0f, this.f38721a.b());
            case 4:
                return a(f, f2, this.f38721a.a() / 2.0f, 0.0f);
            case 5:
                return a(f, f2, this.f38721a.a() / 2.0f, this.f38721a.b() / 2.0f);
            case 6:
                return a(f, f2, this.f38721a.a() / 2.0f, this.f38721a.b());
            case 7:
                return a(f, f2, this.f38721a.a(), 0.0f);
            case 8:
                return a(f, f2, this.f38721a.a(), this.f38721a.b() / 2.0f);
            case 9:
                return a(f, f2, this.f38721a.a(), this.f38721a.b());
            default:
                throw new IllegalArgumentException("Illegal PivotPoint");
        }
    }

    private Matrix a(a aVar) {
        float fA = this.f38721a.a() / this.b.a();
        float fB = this.f38721a.b() / this.b.b();
        float fMin = Math.min(fA, fB);
        return a(fMin / fA, fMin / fB, aVar);
    }

    private Matrix b() {
        return a(1.0f, 1.0f, a.LEFT_TOP);
    }

    private Matrix b(a aVar) {
        return a(this.b.a() / this.f38721a.a(), this.b.b() / this.f38721a.b(), aVar);
    }

    private Matrix c() {
        return a(a.LEFT_TOP);
    }

    private Matrix c(a aVar) {
        float fA = this.f38721a.a() / this.b.a();
        float fB = this.f38721a.b() / this.b.b();
        float fMax = Math.max(fA, fB);
        return a(fMax / fA, fMax / fB, aVar);
    }

    private Matrix d() {
        return a(a.CENTER);
    }

    private Matrix e() {
        return a(a.RIGHT_BOTTOM);
    }

    private Matrix f() {
        return (this.b.b() > this.f38721a.a() || this.b.b() > this.f38721a.b()) ? c() : b(a.LEFT_TOP);
    }

    private Matrix g() {
        return (this.b.b() > this.f38721a.a() || this.b.b() > this.f38721a.b()) ? d() : b(a.CENTER);
    }

    private Matrix h() {
        return (this.b.b() > this.f38721a.a() || this.b.b() > this.f38721a.b()) ? e() : b(a.RIGHT_BOTTOM);
    }

    public Matrix a(b bVar) {
        switch (AnonymousClass1.f38722a[bVar.ordinal()]) {
            case 1:
                return a();
            case 2:
                return b();
            case 3:
                return d();
            case 4:
                return c();
            case 5:
                return e();
            case 6:
                return b(a.LEFT_TOP);
            case 7:
                return b(a.LEFT_CENTER);
            case 8:
                return b(a.LEFT_BOTTOM);
            case 9:
                return b(a.CENTER_TOP);
            case 10:
                return b(a.CENTER);
            case 11:
                return b(a.CENTER_BOTTOM);
            case 12:
                return b(a.RIGHT_TOP);
            case 13:
                return b(a.RIGHT_CENTER);
            case 14:
                return b(a.RIGHT_BOTTOM);
            case 15:
                return c(a.LEFT_TOP);
            case 16:
                return c(a.LEFT_CENTER);
            case 17:
                return c(a.LEFT_BOTTOM);
            case 18:
                return c(a.CENTER_TOP);
            case 19:
                return c(a.CENTER);
            case 20:
                return c(a.CENTER_BOTTOM);
            case 21:
                return c(a.RIGHT_TOP);
            case 22:
                return c(a.RIGHT_CENTER);
            case 23:
                return c(a.RIGHT_BOTTOM);
            case 24:
                return f();
            case 25:
                return g();
            case 26:
                return h();
            default:
                return null;
        }
    }
}
