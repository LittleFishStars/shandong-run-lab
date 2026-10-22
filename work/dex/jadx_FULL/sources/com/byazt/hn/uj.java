package com.byazt.hn;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 25, 15})
public final class uj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f28618a;
    public final tt c;
    public final float[] da;
    public final float[] i;
    public int m;
    public final float[] n;
    public int nu;
    public int rh;
    public final float[] sl;
    public final float[] sp;
    public final float[] t;
    public final tt.ve tt;
    public final int[] u;
    public final float[] uj;
    public final tt.uj[] ve;
    public final float[] x;
    public int yp;
    public final float[] z;

    public uj(tt ttVar) {
        this.c = ttVar;
        this.tt = ttVar.c();
        tt.uj[] ujVarArr = (tt.uj[]) ttVar.tt().toArray(new tt.uj[0]);
        this.ve = ujVarArr;
        this.uj = new float[600];
        this.n = new float[600];
        this.f28618a = new float[600];
        this.sp = new float[600];
        this.x = new float[600];
        this.i = new float[600];
        this.da = new float[600];
        this.sl = new float[600];
        this.t = new float[600];
        this.u = new int[600];
        this.z = new float[ujVarArr.length];
        int iNanoTime = (int) (System.nanoTime() ^ ((long) System.identityHashCode(this)));
        this.m = iNanoTime == 0 ? 305441741 : iNanoTime;
    }

    private float ve() {
        int i = this.m;
        int i2 = i ^ (i << 13);
        int i3 = i2 ^ (i2 >>> 17);
        int i4 = i3 ^ (i3 << 5);
        if (i4 == 0) {
            i4 = -1640531527;
        }
        this.m = i4;
        return (i4 >>> 8) * 5.9604645E-8f;
    }

    public void c(int i, int i2) {
        this.nu = i;
        this.rh = i2;
    }

    public tt tt() {
        return this.c;
    }

    public void update(float f) {
        if (this.nu <= 0 || this.rh <= 0 || this.ve.length == 0) {
            return;
        }
        c(f);
        tt(f);
    }

    private void tt(float f) {
        tt.uj[] ujVarArr = this.ve;
        float[] fArr = this.z;
        for (int i = 0; i < ujVarArr.length; i++) {
            tt.uj ujVar = ujVarArr[i];
            float f2 = ujVar.tt;
            if (f2 > 0.0f) {
                fArr[i] = fArr[i] + (f2 * f);
                while (true) {
                    float f3 = fArr[i];
                    if (f3 < 1.0f || this.yp >= 600) {
                        break;
                    }
                    fArr[i] = f3 - 1.0f;
                    c(i, ujVar);
                }
                if (this.yp >= 600) {
                    fArr[i] = 0.0f;
                }
            }
        }
    }

    public tt.uj[] c() {
        return this.ve;
    }

    private void c(float f) {
        float[] fArr = this.uj;
        float[] fArr2 = this.n;
        float[] fArr3 = this.f28618a;
        float[] fArr4 = this.sp;
        float[] fArr5 = this.x;
        float[] fArr6 = this.i;
        float[] fArr7 = this.sl;
        float[] fArr8 = this.t;
        int i = 0;
        while (i < this.yp) {
            float f2 = fArr5[i] + f;
            if (f2 >= fArr6[i]) {
                c(i);
            } else {
                float f3 = fArr7[i] + (fArr8[i] * f);
                if (f3 <= 0.0f) {
                    c(i);
                } else {
                    if (f3 > 1.0f) {
                        f3 = 1.0f;
                    }
                    fArr5[i] = f2;
                    fArr7[i] = f3;
                    fArr[i] = fArr[i] + (fArr3[i] * f);
                    fArr2[i] = fArr2[i] + (fArr4[i] * f);
                    i++;
                }
            }
        }
    }

    private void tt(int i) {
        float fC = this.tt.i.c(this.nu);
        float fC2 = this.tt.da.c(this.rh);
        float f = fC < 0.0f ? 0.0f : fC;
        float f2 = fC2 < 0.0f ? 0.0f : fC2;
        float fC3 = this.tt.sp.c(this.nu);
        float fC4 = this.tt.x.c(this.rh);
        float f3 = f / 2.0f;
        float f4 = fC3 - f3;
        float f5 = f2 / 2.0f;
        float f6 = fC4 - f5;
        tt.ve veVar = this.tt;
        int i2 = veVar.uj;
        int i3 = veVar.n;
        if (i2 == 2) {
            if (i3 == 1) {
                c(i, f4, f6, f, f2);
                return;
            } else {
                this.uj[i] = f4 + (ve() * f);
                this.n[i] = f6 + (ve() * f2);
                return;
            }
        }
        if (i2 == 3 || i2 == 4) {
            float fVe = ve() * 6.2831855f;
            float fSqrt = i3 == 1 ? 1.0f : (float) Math.sqrt(ve());
            double d = fVe;
            this.uj[i] = fC3 + (((float) Math.cos(d)) * f3 * fSqrt);
            this.n[i] = fC4 + (((float) Math.sin(d)) * f5 * fSqrt);
            return;
        }
        if (i2 == 1) {
            this.uj[i] = f4 + (ve() * f);
            this.n[i] = fC4;
        } else {
            this.uj[i] = fC3;
            this.n[i] = fC4;
        }
    }

    private void c(int i) {
        int i2 = this.yp - 1;
        this.yp = i2;
        if (i != i2) {
            float[] fArr = this.uj;
            fArr[i] = fArr[i2];
            float[] fArr2 = this.n;
            fArr2[i] = fArr2[i2];
            float[] fArr3 = this.f28618a;
            fArr3[i] = fArr3[i2];
            float[] fArr4 = this.sp;
            fArr4[i] = fArr4[i2];
            float[] fArr5 = this.x;
            fArr5[i] = fArr5[i2];
            float[] fArr6 = this.i;
            fArr6[i] = fArr6[i2];
            float[] fArr7 = this.da;
            fArr7[i] = fArr7[i2];
            float[] fArr8 = this.sl;
            fArr8[i] = fArr8[i2];
            float[] fArr9 = this.t;
            fArr9[i] = fArr9[i2];
            int[] iArr = this.u;
            iArr[i] = iArr[i2];
        }
    }

    private void c(int i, tt.uj ujVar) {
        int i2 = this.yp;
        this.yp = i2 + 1;
        float fC = c(ujVar.ve, ujVar.uj);
        if (fC < 0.01f) {
            fC = 0.01f;
        }
        float fC2 = c(ujVar.n, ujVar.f28616a);
        if (fC2 < 0.0f) {
            fC2 = 0.0f;
        }
        float fC3 = c(ujVar.sp, ujVar.x);
        if (fC3 < 0.0f) {
            fC3 = 0.0f;
        }
        float fVe = ve() * 6.2831855f;
        float radians = (float) Math.toRadians(ujVar.i);
        if (radians > 0.0f) {
            fVe += (ve() - 0.5f) * radians;
        }
        float fVe2 = 1.0f - (ujVar.da > 0.0f ? ve() * ujVar.da : 0.0f);
        if (fVe2 < 0.0f) {
            fVe2 = 0.0f;
        }
        this.x[i2] = 0.0f;
        this.i[i2] = fC;
        this.da[i2] = fC2;
        double d = fVe;
        this.f28618a[i2] = ((float) Math.cos(d)) * fC3;
        this.sp[i2] = ((float) Math.sin(d)) * fC3;
        this.sl[i2] = fVe2;
        this.t[i2] = ujVar.sl;
        this.u[i2] = i;
        tt(i2);
    }

    private void c(int i, float f, float f2, float f3, float f4) {
        float f5 = f3 + f4;
        float f6 = f5 * 2.0f;
        if (f6 <= 0.0f) {
            this.uj[i] = f;
            this.n[i] = f2;
            return;
        }
        float fVe = ve() * f6;
        if (fVe < f3) {
            this.uj[i] = f + fVe;
            this.n[i] = f2;
            return;
        }
        if (fVe < f5) {
            this.uj[i] = f + f3;
            this.n[i] = f2 + (fVe - f3);
            return;
        }
        float f7 = 2.0f * f3;
        if (fVe < f7 + f4) {
            this.uj[i] = (f + f3) - ((fVe - f3) - f4);
            this.n[i] = f2 + f4;
        } else {
            this.uj[i] = f;
            this.n[i] = (f2 + f4) - ((fVe - f7) - f4);
        }
    }

    private float c(float f, float f2) {
        return f2 <= 0.0f ? f : f + (((ve() * 2.0f) - 1.0f) * f2);
    }

    public void c(a aVar) {
        int i = this.yp;
        aVar.c(600);
        aVar.c = i;
        System.arraycopy(this.uj, 0, aVar.ve, 0, i);
        System.arraycopy(this.n, 0, aVar.uj, 0, i);
        System.arraycopy(this.da, 0, aVar.n, 0, i);
        System.arraycopy(this.sl, 0, aVar.f28613a, 0, i);
        System.arraycopy(this.x, 0, aVar.sp, 0, i);
        System.arraycopy(this.u, 0, aVar.x, 0, i);
        aVar.tt = this.tt.f28617a;
    }
}
