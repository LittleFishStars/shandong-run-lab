package com.byazt.zy;

import android.graphics.PointF;
import com.hzchengdun.securityguard.SecExceptionCode;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SAFETOKEN_UNSUPPORTED, 137})
public class nu implements my, com.byazt.dg.c.InterfaceC0385c {
    public final com.byazt.ga.x c;
    public final String tt;
    public com.byazt.jx.yp uj;
    public final com.byazt.dg.c<Float, Float> ve;

    public nu(com.byazt.ga.x xVar, com.byazt.zk.ve veVar, com.byazt.jx.u uVar) {
        this.c = xVar;
        this.tt = uVar.c();
        com.byazt.dg.c<Float, Float> cVarC = uVar.tt().c();
        this.ve = cVarC;
        veVar.c(cVarC);
        cVarC.c(this);
    }

    @Override // com.byazt.dg.c.InterfaceC0385c
    public void c() {
        this.c.invalidateSelf();
    }

    @Override // com.byazt.zy.ve
    public void c(List<ve> list, List<ve> list2) {
    }

    public com.byazt.dg.c<Float, Float> tt() {
        return this.ve;
    }

    private com.byazt.jx.yp tt(com.byazt.jx.yp ypVar) {
        List<com.byazt.nb.c> listVe = ypVar.ve();
        boolean zTt = ypVar.tt();
        int size = listVe.size() - 1;
        int i = 0;
        while (size >= 0) {
            com.byazt.nb.c cVar = listVe.get(size);
            com.byazt.nb.c cVar2 = listVe.get(c(size - 1, listVe.size()));
            PointF pointFVe = (size != 0 || zTt) ? cVar2.ve() : ypVar.c();
            i = (((size != 0 || zTt) ? cVar2.tt() : pointFVe).equals(pointFVe) && cVar.c().equals(pointFVe) && !(!ypVar.tt() && size == 0 && size == listVe.size() - 1)) ? i + 2 : i + 1;
            size--;
        }
        com.byazt.jx.yp ypVar2 = this.uj;
        if (ypVar2 == null || ypVar2.ve().size() != i) {
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(new com.byazt.nb.c());
            }
            this.uj = new com.byazt.jx.yp(new PointF(0.0f, 0.0f), false, arrayList);
        }
        this.uj.c(zTt);
        return this.uj;
    }

    @Override // com.byazt.zy.my
    public com.byazt.jx.yp c(com.byazt.jx.yp ypVar) {
        List<com.byazt.nb.c> listVe = ypVar.ve();
        if (listVe.size() <= 2) {
            return ypVar;
        }
        float fFloatValue = this.ve.sp().floatValue();
        if (fFloatValue == 0.0f) {
            return ypVar;
        }
        com.byazt.jx.yp ypVarTt = tt(ypVar);
        ypVarTt.c(ypVar.c().x, ypVar.c().y);
        List<com.byazt.nb.c> listVe2 = ypVarTt.ve();
        boolean zTt = ypVar.tt();
        int i = 0;
        int i2 = 0;
        while (i < listVe.size()) {
            com.byazt.nb.c cVar = listVe.get(i);
            com.byazt.nb.c cVar2 = listVe.get(c(i - 1, listVe.size()));
            com.byazt.nb.c cVar3 = listVe.get(c(i - 2, listVe.size()));
            PointF pointFVe = (i != 0 || zTt) ? cVar2.ve() : ypVar.c();
            PointF pointFTt = (i != 0 || zTt) ? cVar2.tt() : pointFVe;
            PointF pointFC = cVar.c();
            PointF pointFVe2 = cVar3.ve();
            PointF pointFVe3 = cVar.ve();
            boolean z = !ypVar.tt() && i == 0 && i == listVe.size() + (-1);
            if (pointFTt.equals(pointFVe) && pointFC.equals(pointFVe) && !z) {
                float f = pointFVe.x;
                float f2 = f - pointFVe2.x;
                float f3 = pointFVe.y;
                float f4 = f3 - pointFVe2.y;
                float f5 = pointFVe3.x - f;
                float f6 = pointFVe3.y - f3;
                float fHypot = (float) Math.hypot(f2, f4);
                float fHypot2 = (float) Math.hypot(f5, f6);
                float fMin = Math.min(fFloatValue / fHypot, 0.5f);
                float fMin2 = Math.min(fFloatValue / fHypot2, 0.5f);
                float f7 = pointFVe.x;
                float f8 = ((pointFVe2.x - f7) * fMin) + f7;
                float f9 = pointFVe.y;
                float f10 = ((pointFVe2.y - f9) * fMin) + f9;
                float f11 = ((pointFVe3.x - f7) * fMin2) + f7;
                float f12 = ((pointFVe3.y - f9) * fMin2) + f9;
                float f13 = f8 - ((f8 - f7) * 0.5519f);
                float f14 = f10 - ((f10 - f9) * 0.5519f);
                float f15 = f11 - ((f11 - f7) * 0.5519f);
                float f16 = f12 - ((f12 - f9) * 0.5519f);
                com.byazt.nb.c cVar4 = listVe2.get(c(i2 - 1, listVe2.size()));
                com.byazt.nb.c cVar5 = listVe2.get(i2);
                cVar4.tt(f8, f10);
                cVar4.ve(f8, f10);
                if (i == 0) {
                    ypVarTt.c(f8, f10);
                }
                cVar5.c(f13, f14);
                i2++;
                com.byazt.nb.c cVar6 = listVe2.get(i2);
                cVar5.tt(f15, f16);
                cVar5.ve(f11, f12);
                cVar6.c(f11, f12);
            } else {
                com.byazt.nb.c cVar7 = listVe2.get(c(i2 - 1, listVe2.size()));
                com.byazt.nb.c cVar8 = listVe2.get(i2);
                cVar7.tt(cVar2.tt().x, cVar2.tt().y);
                cVar7.ve(cVar2.ve().x, cVar2.ve().y);
                cVar8.c(cVar.c().x, cVar.c().y);
            }
            i2++;
            i++;
            listVe = listVe;
        }
        return ypVarTt;
    }

    private static int tt(int i, int i2) {
        int i3 = i / i2;
        return ((i ^ i2) >= 0 || i2 * i3 == i) ? i3 : i3 - 1;
    }

    private static int c(int i, int i2) {
        return i - (tt(i, i2) * i2);
    }
}
