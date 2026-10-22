package com.facebook.drawee.generic;

import com.zj.adlib.ax6;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class RoundingParams {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RoundingMethod f1622a = RoundingMethod.BITMAP_ONLY;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1623a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float[] f1624a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f1621a = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f29975a = 0.0f;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f1625b = 0;
    public float b = 0.0f;

    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public static RoundingParams a() {
        return new RoundingParams().u(true);
    }

    public static RoundingParams b(float f, float f2, float f3, float f4) {
        return new RoundingParams().p(f, f2, f3, f4);
    }

    public static RoundingParams c(float[] fArr) {
        return new RoundingParams().q(fArr);
    }

    public static RoundingParams d(float f) {
        return new RoundingParams().r(f);
    }

    public int e() {
        return this.f1625b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.f1623a == roundingParams.f1623a && this.f1621a == roundingParams.f1621a && Float.compare(roundingParams.f29975a, this.f29975a) == 0 && this.f1625b == roundingParams.f1625b && Float.compare(roundingParams.b, this.b) == 0 && this.f1622a == roundingParams.f1622a) {
            return Arrays.equals(this.f1624a, roundingParams.f1624a);
        }
        return false;
    }

    public float f() {
        return this.f29975a;
    }

    public float[] g() {
        return this.f1624a;
    }

    public final float[] h() {
        if (this.f1624a == null) {
            this.f1624a = new float[8];
        }
        return this.f1624a;
    }

    public int hashCode() {
        RoundingMethod roundingMethod = this.f1622a;
        int iHashCode = (((roundingMethod != null ? roundingMethod.hashCode() : 0) * 31) + (this.f1623a ? 1 : 0)) * 31;
        float[] fArr = this.f1624a;
        int iHashCode2 = (((iHashCode + (fArr != null ? Arrays.hashCode(fArr) : 0)) * 31) + this.f1621a) * 31;
        float f = this.f29975a;
        int iFloatToIntBits = (((iHashCode2 + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31) + this.f1625b) * 31;
        float f2 = this.b;
        return iFloatToIntBits + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0);
    }

    public int i() {
        return this.f1621a;
    }

    public float j() {
        return this.b;
    }

    public boolean k() {
        return this.f1623a;
    }

    public RoundingMethod l() {
        return this.f1622a;
    }

    public RoundingParams m(int i, float f) {
        ax6.e(f >= 0.0f, "the border width cannot be < 0");
        this.f29975a = f;
        this.f1625b = i;
        return this;
    }

    public RoundingParams n(int i) {
        this.f1625b = i;
        return this;
    }

    public RoundingParams o(float f) {
        ax6.e(f >= 0.0f, "the border width cannot be < 0");
        this.f29975a = f;
        return this;
    }

    public RoundingParams p(float f, float f2, float f3, float f4) {
        float[] fArrH = h();
        fArrH[1] = f;
        fArrH[0] = f;
        fArrH[3] = f2;
        fArrH[2] = f2;
        fArrH[5] = f3;
        fArrH[4] = f3;
        fArrH[7] = f4;
        fArrH[6] = f4;
        return this;
    }

    public RoundingParams q(float[] fArr) {
        ax6.i(fArr);
        ax6.e(fArr.length == 8, "radii should have exactly 8 values");
        System.arraycopy(fArr, 0, h(), 0, 8);
        return this;
    }

    public RoundingParams r(float f) {
        Arrays.fill(h(), f);
        return this;
    }

    public RoundingParams s(int i) {
        this.f1621a = i;
        this.f1622a = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public RoundingParams t(float f) {
        ax6.e(f >= 0.0f, "the padding cannot be < 0");
        this.b = f;
        return this;
    }

    public RoundingParams u(boolean z) {
        this.f1623a = z;
        return this;
    }

    public RoundingParams v(RoundingMethod roundingMethod) {
        this.f1622a = roundingMethod;
        return this;
    }
}
