package com.autonavi.base.ae.gmap.glanimation;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class AbstractAdglAnimationParam {
    protected float mult;
    protected float normalizedTime;
    protected int interpolationType = 0;
    protected float factor = 1.0f;
    protected boolean hasCheckedParam = false;
    protected boolean needToCaculate = false;
    protected boolean hasFromValue = false;
    protected boolean hasToValue = false;

    public static float bounce(float f) {
        return f * f * 8.0f;
    }

    public abstract void checkParam();

    public float getCurMult() {
        return this.mult;
    }

    public int getInterpolatorType() {
        return this.interpolationType;
    }

    public boolean needToCaculate() {
        if (!this.hasCheckedParam) {
            checkParam();
        }
        return this.hasCheckedParam && this.needToCaculate;
    }

    public void reset() {
        this.interpolationType = 0;
        this.factor = 1.0f;
        this.hasCheckedParam = false;
        this.needToCaculate = false;
        this.hasFromValue = false;
        this.hasToValue = false;
    }

    public void setInterpolatorType(int i, float f) {
        this.interpolationType = i;
        this.factor = f;
    }

    public void setNormalizedTime(float f) {
        double dPow;
        float fBounce;
        float f2;
        this.normalizedTime = f;
        switch (this.interpolationType) {
            case 0:
                break;
            case 1:
                dPow = Math.pow(f, this.factor * 2.0f);
                f = (float) dPow;
                break;
            case 2:
                float f3 = this.factor;
                if (f3 != 1.0f) {
                    f = (float) (1.0d - Math.pow(1.0f - f, f3 * 2.0f));
                } else {
                    float f4 = 1.0f - f;
                    f = 1.0f - (f4 * f4);
                }
                break;
            case 3:
                dPow = (Math.cos(((double) (f + 1.0f)) * 3.141592653589793d) / 2.0d) + 0.5d;
                f = (float) dPow;
                break;
            case 4:
                float f5 = f * 1.1226f;
                if (f5 >= 0.3535f) {
                    if (f5 < 0.7408f) {
                        fBounce = bounce(f5 - 0.54719f);
                        f2 = 0.7f;
                    } else if (f5 < 0.9644f) {
                        fBounce = bounce(f5 - 0.8526f);
                        f2 = 0.9f;
                    } else {
                        fBounce = bounce(f5 - 1.0435f);
                        f2 = 0.95f;
                    }
                    f = fBounce + f2;
                } else {
                    f = bounce(f5);
                }
                break;
            case 5:
                float f6 = f - 1.0f;
                f = (f6 * f6 * ((f6 * 3.0f) + 2.0f)) + 1.0f;
                break;
            case 6:
                if (f < 0.0f) {
                    f = 0.0f;
                } else if (f < 0.25f) {
                    f *= 4.0f;
                } else if (f < 0.5f) {
                    f = 2.0f - (f * 4.0f);
                } else if (f >= 0.75f) {
                    f = f > 1.0f ? 0.0f : 4.0f - (f * 4.0f);
                } else {
                    f = (f * 4.0f) - 2.0f;
                }
                break;
            default:
                f = 0.0f;
                break;
        }
        this.mult = f;
    }
}
