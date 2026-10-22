package com.byazt.zy;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.camera.video.AudioStats;
import com.hzchengdun.securityguard.SecExceptionCode;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SAFETOKEN_UNSUPPORTED, 215})
public class yp implements sl, u, com.byazt.dg.c.InterfaceC0385c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f29265a;
    public final com.byazt.dg.c<?, Float> da;
    public final com.byazt.dg.c<?, Float> i;
    public final boolean n;
    public final com.byazt.dg.c<?, Float> sl;
    public final com.byazt.dg.c<?, Float> sp;
    public final com.byazt.dg.c<?, Float> t;
    public final String tt;
    public final com.byazt.dg.c<?, Float> u;
    public final com.byazt.jx.da.c uj;
    public final com.byazt.ga.x ve;
    public final com.byazt.dg.c<?, PointF> x;
    public boolean z;
    public final Path c = new Path();
    public final tt yp = new tt();

    /* JADX INFO: renamed from: com.byazt.zy.yp$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SAFETOKEN_UNSUPPORTED, 212})
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[com.byazt.jx.da.c.values().length];
            c = iArr;
            try {
                iArr[com.byazt.jx.da.c.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[com.byazt.jx.da.c.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public yp(com.byazt.ga.x xVar, com.byazt.zk.ve veVar, com.byazt.jx.da daVar) {
        this.ve = xVar;
        this.tt = daVar.c();
        com.byazt.jx.da.c type = daVar.getType();
        this.uj = type;
        this.n = daVar.i();
        this.f29265a = daVar.da();
        com.byazt.dg.c<Float, Float> cVarC = daVar.tt().c();
        this.sp = cVarC;
        com.byazt.dg.c<PointF, PointF> cVarC2 = daVar.ve().c();
        this.x = cVarC2;
        com.byazt.dg.c<Float, Float> cVarC3 = daVar.uj().c();
        this.i = cVarC3;
        com.byazt.dg.c<Float, Float> cVarC4 = daVar.a().c();
        this.sl = cVarC4;
        com.byazt.dg.c<Float, Float> cVarC5 = daVar.x().c();
        this.u = cVarC5;
        com.byazt.jx.da.c cVar = com.byazt.jx.da.c.STAR;
        if (type == cVar) {
            this.da = daVar.n().c();
            this.t = daVar.sp().c();
        } else {
            this.da = null;
            this.t = null;
        }
        veVar.c(cVarC);
        veVar.c(cVarC2);
        veVar.c(cVarC3);
        veVar.c(cVarC4);
        veVar.c(cVarC5);
        if (type == cVar) {
            veVar.c(this.da);
            veVar.c(this.t);
        }
        cVarC.c(this);
        cVarC2.c(this);
        cVarC3.c(this);
        cVarC4.c(this);
        cVarC5.c(this);
        if (type == cVar) {
            this.da.c(this);
            this.t.c(this);
        }
    }

    private void n() {
        int iFloor = (int) Math.floor(this.sp.sp().floatValue());
        com.byazt.dg.c<?, Float> cVar = this.i;
        double radians = Math.toRadians((cVar == null ? AudioStats.AUDIO_AMPLITUDE_NONE : cVar.sp().floatValue()) - 90.0d);
        double d = iFloor;
        float fFloatValue = this.u.sp().floatValue() / 100.0f;
        float fFloatValue2 = this.sl.sp().floatValue();
        double d2 = fFloatValue2;
        float fCos = (float) (Math.cos(radians) * d2);
        float fSin = (float) (Math.sin(radians) * d2);
        this.c.moveTo(fCos, fSin);
        double d3 = (float) (6.283185307179586d / d);
        double d4 = radians + d3;
        double dCeil = Math.ceil(d);
        int i = 0;
        while (i < dCeil) {
            float fCos2 = (float) (Math.cos(d4) * d2);
            double d5 = dCeil;
            float fSin2 = (float) (d2 * Math.sin(d4));
            if (fFloatValue != 0.0f) {
                double dAtan2 = (float) (Math.atan2(fSin, fCos) - 1.5707963267948966d);
                float fCos3 = (float) Math.cos(dAtan2);
                float fSin3 = (float) Math.sin(dAtan2);
                double dAtan3 = (float) (Math.atan2(fSin2, fCos2) - 1.5707963267948966d);
                float f = fFloatValue2 * fFloatValue * 0.25f;
                this.c.cubicTo(fCos - (fCos3 * f), fSin - (fSin3 * f), fCos2 + (((float) Math.cos(dAtan3)) * f), fSin2 + (f * ((float) Math.sin(dAtan3))), fCos2, fSin2);
            } else {
                this.c.lineTo(fCos2, fSin2);
            }
            d4 += d3;
            i++;
            fSin = fSin2;
            fCos = fCos2;
            dCeil = d5;
            d2 = d2;
            d3 = d3;
        }
        PointF pointFSp = this.x.sp();
        this.c.offset(pointFSp.x, pointFSp.y);
        this.c.close();
    }

    private void tt() {
        this.z = false;
        this.ve.invalidateSelf();
    }

    private void ve() {
        float f;
        float f2;
        double d;
        float fSin;
        float f3;
        float f4;
        float f5;
        float fFloatValue = this.sp.sp().floatValue();
        com.byazt.dg.c<?, Float> cVar = this.i;
        double radians = Math.toRadians((cVar == null ? AudioStats.AUDIO_AMPLITUDE_NONE : cVar.sp().floatValue()) - 90.0d);
        double d2 = fFloatValue;
        float f6 = (float) (6.283185307179586d / d2);
        if (this.f29265a) {
            f6 *= -1.0f;
        }
        float f7 = f6 / 2.0f;
        float f8 = fFloatValue - ((int) fFloatValue);
        if (f8 != 0.0f) {
            radians += (double) ((1.0f - f8) * f7);
        }
        float fFloatValue2 = this.sl.sp().floatValue();
        float fFloatValue3 = this.da.sp().floatValue();
        com.byazt.dg.c<?, Float> cVar2 = this.t;
        float fFloatValue4 = cVar2 != null ? cVar2.sp().floatValue() / 100.0f : 0.0f;
        com.byazt.dg.c<?, Float> cVar3 = this.u;
        float fFloatValue5 = cVar3 != null ? cVar3.sp().floatValue() / 100.0f : 0.0f;
        if (f8 != 0.0f) {
            f3 = ((fFloatValue2 - fFloatValue3) * f8) + fFloatValue3;
            double d3 = f3;
            float fCos = (float) (d3 * Math.cos(radians));
            fSin = (float) (d3 * Math.sin(radians));
            this.c.moveTo(fCos, fSin);
            d = radians + ((double) ((f6 * f8) / 2.0f));
            f = fCos;
            f2 = f7;
        } else {
            double d4 = fFloatValue2;
            float fCos2 = (float) (Math.cos(radians) * d4);
            float fSin2 = (float) (d4 * Math.sin(radians));
            this.c.moveTo(fCos2, fSin2);
            f = fCos2;
            f2 = f7;
            d = radians + ((double) f2);
            fSin = fSin2;
            f3 = 0.0f;
        }
        double dCeil = Math.ceil(d2) * 2.0d;
        int i = 0;
        float f9 = f2;
        float f10 = f;
        boolean z = false;
        while (true) {
            double d5 = i;
            if (d5 >= dCeil) {
                PointF pointFSp = this.x.sp();
                this.c.offset(pointFSp.x, pointFSp.y);
                this.c.close();
                return;
            }
            float f11 = z ? fFloatValue2 : fFloatValue3;
            float f12 = (f3 == 0.0f || d5 != dCeil - 2.0d) ? f9 : (f6 * f8) / 2.0f;
            if (f3 == 0.0f || d5 != dCeil - 1.0d) {
                f3 = f11;
            }
            double d6 = f3;
            double d7 = dCeil;
            float fCos3 = (float) (d6 * Math.cos(d));
            float fSin3 = (float) (d6 * Math.sin(d));
            if (fFloatValue4 == 0.0f && fFloatValue5 == 0.0f) {
                this.c.lineTo(fCos3, fSin3);
                f4 = fFloatValue4;
                f5 = fFloatValue5;
            } else {
                f4 = fFloatValue4;
                double dAtan2 = (float) (Math.atan2(fSin, f10) - 1.5707963267948966d);
                float fCos4 = (float) Math.cos(dAtan2);
                float fSin4 = (float) Math.sin(dAtan2);
                f5 = fFloatValue5;
                double dAtan3 = (float) (Math.atan2(fSin3, fCos3) - 1.5707963267948966d);
                float fCos5 = (float) Math.cos(dAtan3);
                float fSin5 = (float) Math.sin(dAtan3);
                float f13 = z ? f4 : f5;
                float f14 = z ? f5 : f4;
                float f15 = (z ? fFloatValue3 : fFloatValue2) * f13 * 0.47829f;
                float f16 = fCos4 * f15;
                float f17 = f15 * fSin4;
                float f18 = (z ? fFloatValue2 : fFloatValue3) * f14 * 0.47829f;
                float f19 = fCos5 * f18;
                float f20 = f18 * fSin5;
                if (f8 != 0.0f) {
                    if (i == 0) {
                        f16 *= f8;
                        f17 *= f8;
                    } else if (d5 == d7 - 1.0d) {
                        f19 *= f8;
                        f20 *= f8;
                    }
                }
                this.c.cubicTo(f10 - f16, fSin - f17, fCos3 + f19, fSin3 + f20, fCos3, fSin3);
            }
            d += (double) f12;
            z = !z;
            i++;
            f10 = fCos3;
            fSin = fSin3;
            fFloatValue5 = f5;
            fFloatValue4 = f4;
            f3 = f3;
            f6 = f6;
            dCeil = d7;
        }
    }

    @Override // com.byazt.dg.c.InterfaceC0385c
    public void c() {
        tt();
    }

    @Override // com.byazt.zy.u
    public Path uj() {
        if (this.z) {
            return this.c;
        }
        this.c.reset();
        if (this.n) {
            this.z = true;
            return this.c;
        }
        int i = AnonymousClass1.c[this.uj.ordinal()];
        if (i == 1) {
            ve();
        } else if (i == 2) {
            n();
        }
        this.c.close();
        this.yp.c(this.c);
        this.z = true;
        return this.c;
    }

    @Override // com.byazt.zy.ve
    public void c(List<ve> list, List<ve> list2) {
        for (int i = 0; i < list.size(); i++) {
            ve veVar = list.get(i);
            if (veVar instanceof rl) {
                rl rlVar = (rl) veVar;
                if (rlVar.getType() == com.byazt.jx.my.c.SIMULTANEOUSLY) {
                    this.yp.c(rlVar);
                    rlVar.c(this);
                }
            }
        }
    }
}
