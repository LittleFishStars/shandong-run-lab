package com.byazt.zy;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.hzchengdun.securityguard.SecExceptionCode;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SAFETOKEN_UNSUPPORTED, 133})
public class z implements sl, u, com.byazt.dg.c.InterfaceC0385c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.byazt.dg.c<?, PointF> f29266a;
    public final com.byazt.ga.x n;
    public boolean sl;
    public final com.byazt.dg.c<?, PointF> sp;
    public final boolean uj;
    public final String ve;
    public final com.byazt.dg.c<?, Float> x;
    public final Path c = new Path();
    public final RectF tt = new RectF();
    public final tt i = new tt();
    public com.byazt.dg.c<Float, Float> da = null;

    public z(com.byazt.ga.x xVar, com.byazt.zk.ve veVar, com.byazt.jx.sl slVar) {
        this.ve = slVar.c();
        this.uj = slVar.n();
        this.n = xVar;
        com.byazt.dg.c<PointF, PointF> cVarC = slVar.uj().c();
        this.f29266a = cVarC;
        com.byazt.dg.c<PointF, PointF> cVarC2 = slVar.ve().c();
        this.sp = cVarC2;
        com.byazt.dg.c<Float, Float> cVarC3 = slVar.tt().c();
        this.x = cVarC3;
        veVar.c(cVarC);
        veVar.c(cVarC2);
        veVar.c(cVarC3);
        cVarC.c(this);
        cVarC2.c(this);
        cVarC3.c(this);
    }

    private void tt() {
        this.sl = false;
        this.n.invalidateSelf();
    }

    @Override // com.byazt.dg.c.InterfaceC0385c
    public void c() {
        tt();
    }

    @Override // com.byazt.zy.u
    public Path uj() {
        com.byazt.dg.c<Float, Float> cVar;
        if (this.sl) {
            return this.c;
        }
        this.c.reset();
        if (this.uj) {
            this.sl = true;
            return this.c;
        }
        PointF pointFSp = this.sp.sp();
        float f = pointFSp.x / 2.0f;
        float f2 = pointFSp.y / 2.0f;
        com.byazt.dg.c<?, Float> cVar2 = this.x;
        float fI = cVar2 == null ? 0.0f : ((com.byazt.dg.uj) cVar2).i();
        if (fI == 0.0f && (cVar = this.da) != null) {
            fI = Math.min(cVar.sp().floatValue(), Math.min(f, f2));
        }
        float fMin = Math.min(f, f2);
        if (fI > fMin) {
            fI = fMin;
        }
        PointF pointFSp2 = this.f29266a.sp();
        this.c.moveTo(pointFSp2.x + f, (pointFSp2.y - f2) + fI);
        this.c.lineTo(pointFSp2.x + f, (pointFSp2.y + f2) - fI);
        if (fI > 0.0f) {
            RectF rectF = this.tt;
            float f3 = pointFSp2.x;
            float f4 = fI * 2.0f;
            float f5 = pointFSp2.y;
            rectF.set((f3 + f) - f4, (f5 + f2) - f4, f3 + f, f5 + f2);
            this.c.arcTo(this.tt, 0.0f, 90.0f, false);
        }
        this.c.lineTo((pointFSp2.x - f) + fI, pointFSp2.y + f2);
        if (fI > 0.0f) {
            RectF rectF2 = this.tt;
            float f6 = pointFSp2.x;
            float f7 = pointFSp2.y;
            float f8 = fI * 2.0f;
            rectF2.set(f6 - f, (f7 + f2) - f8, (f6 - f) + f8, f7 + f2);
            this.c.arcTo(this.tt, 90.0f, 90.0f, false);
        }
        this.c.lineTo(pointFSp2.x - f, (pointFSp2.y - f2) + fI);
        if (fI > 0.0f) {
            RectF rectF3 = this.tt;
            float f9 = pointFSp2.x;
            float f10 = pointFSp2.y;
            float f11 = fI * 2.0f;
            rectF3.set(f9 - f, f10 - f2, (f9 - f) + f11, (f10 - f2) + f11);
            this.c.arcTo(this.tt, 180.0f, 90.0f, false);
        }
        this.c.lineTo((pointFSp2.x + f) - fI, pointFSp2.y - f2);
        if (fI > 0.0f) {
            RectF rectF4 = this.tt;
            float f12 = pointFSp2.x;
            float f13 = fI * 2.0f;
            float f14 = pointFSp2.y;
            rectF4.set((f12 + f) - f13, f14 - f2, f12 + f, (f14 - f2) + f13);
            this.c.arcTo(this.tt, 270.0f, 90.0f, false);
        }
        this.c.close();
        this.i.c(this.c);
        this.sl = true;
        return this.c;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    /* JADX WARN: Code duplicated, block: B:12:0x0029  */
    /* JADX WARN: Code duplicated, block: B:18:0x0031 A[SYNTHETIC] */
    @Override // com.byazt.zy.ve
    public void c(List<ve> list, List<ve> list2) {
        for (int i = 0; i < list.size(); i++) {
            ve veVar = list.get(i);
            if (veVar instanceof rl) {
                rl rlVar = (rl) veVar;
                if (rlVar.getType() == com.byazt.jx.my.c.SIMULTANEOUSLY) {
                    this.i.c(rlVar);
                    rlVar.c(this);
                } else if (veVar instanceof nu) {
                    this.da = ((nu) veVar).tt();
                }
            } else if (veVar instanceof nu) {
                this.da = ((nu) veVar).tt();
            }
        }
    }
}
