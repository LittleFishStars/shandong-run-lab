package com.byazt.zy;

import android.graphics.Path;
import android.graphics.PointF;
import com.hzchengdun.securityguard.SecExceptionCode;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SAFETOKEN_UNSUPPORTED, 34})
public class a implements sl, u, com.byazt.dg.c.InterfaceC0385c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.byazt.jx.tt f29254a;
    public final com.byazt.dg.c<?, PointF> n;
    public final String tt;
    public final com.byazt.dg.c<?, PointF> uj;
    public final com.byazt.ga.x ve;
    public boolean x;
    public final Path c = new Path();
    public final tt sp = new tt();

    public a(com.byazt.ga.x xVar, com.byazt.zk.ve veVar, com.byazt.jx.tt ttVar) {
        this.tt = ttVar.c();
        this.ve = xVar;
        com.byazt.dg.c<PointF, PointF> cVarC = ttVar.ve().c();
        this.uj = cVarC;
        com.byazt.dg.c<PointF, PointF> cVarC2 = ttVar.tt().c();
        this.n = cVarC2;
        this.f29254a = ttVar;
        veVar.c(cVarC);
        veVar.c(cVarC2);
        cVarC.c(this);
        cVarC2.c(this);
    }

    private void tt() {
        this.x = false;
        this.ve.invalidateSelf();
    }

    @Override // com.byazt.dg.c.InterfaceC0385c
    public void c() {
        tt();
    }

    @Override // com.byazt.zy.u
    public Path uj() {
        if (this.x) {
            return this.c;
        }
        this.c.reset();
        if (this.f29254a.n()) {
            this.x = true;
            return this.c;
        }
        PointF pointFSp = this.uj.sp();
        float f = pointFSp.x / 2.0f;
        float f2 = pointFSp.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = 0.55228f * f2;
        this.c.reset();
        if (this.f29254a.uj()) {
            float f5 = -f2;
            this.c.moveTo(0.0f, f5);
            float f6 = 0.0f - f3;
            float f7 = -f;
            float f8 = 0.0f - f4;
            this.c.cubicTo(f6, f5, f7, f8, f7, 0.0f);
            float f9 = f4 + 0.0f;
            this.c.cubicTo(f7, f9, f6, f2, 0.0f, f2);
            float f10 = f3 + 0.0f;
            this.c.cubicTo(f10, f2, f, f9, f, 0.0f);
            this.c.cubicTo(f, f8, f10, f5, 0.0f, f5);
        } else {
            float f11 = -f2;
            this.c.moveTo(0.0f, f11);
            float f12 = f3 + 0.0f;
            float f13 = 0.0f - f4;
            this.c.cubicTo(f12, f11, f, f13, f, 0.0f);
            float f14 = f4 + 0.0f;
            this.c.cubicTo(f, f14, f12, f2, 0.0f, f2);
            float f15 = 0.0f - f3;
            float f16 = -f;
            this.c.cubicTo(f15, f2, f16, f14, f16, 0.0f);
            this.c.cubicTo(f16, f13, f15, f11, 0.0f, f11);
        }
        PointF pointFSp2 = this.n.sp();
        this.c.offset(pointFSp2.x, pointFSp2.y);
        this.c.close();
        this.sp.c(this.c);
        this.x = true;
        return this.c;
    }

    @Override // com.byazt.zy.ve
    public void c(List<ve> list, List<ve> list2) {
        for (int i = 0; i < list.size(); i++) {
            ve veVar = list.get(i);
            if (veVar instanceof rl) {
                rl rlVar = (rl) veVar;
                if (rlVar.getType() == com.byazt.jx.my.c.SIMULTANEOUSLY) {
                    this.sp.c(rlVar);
                    rlVar.c(this);
                }
            }
        }
    }
}
