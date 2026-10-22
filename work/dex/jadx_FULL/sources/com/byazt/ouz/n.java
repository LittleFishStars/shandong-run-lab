package com.byazt.ouz;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.byazt.aas.pf;
import com.byazt.ete.ic;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 27, 46})
public class n extends com.byazt.hkv.c {
    public com.byazt.ete.gr da;
    public boolean sl;
    public int t;
    public int u;
    public int yp;

    public n(Context context, ic icVar, String str, int i) {
        super(context, icVar, str, i);
        this.t = 0;
        this.u = -1;
        this.yp = -1;
        this.sl = true;
        if (icVar == null) {
            return;
        }
        com.byazt.rv.c.c().c(icVar.hashCode() + icVar.qy()).put("is_express_ad", Boolean.TRUE);
    }

    @Override // com.byazt.hkv.tt, com.byazt.hkv.uj
    public void c(View view, com.byazt.ete.da daVar) {
        com.byazt.vis.c cVar = (com.byazt.vis.c) c(com.byazt.vis.c.class);
        cVar.c(c(cVar.ve(), daVar == null ? (byte) 0 : daVar.tt()));
        super.c(view, daVar);
    }

    @Override // com.byazt.hkv.uj
    public void n(int i) {
        this.t = i;
    }

    @Override // com.byazt.hkv.uj
    public void uj() {
        this.yp = 1;
        this.sl = false;
    }

    @Override // com.byazt.hkv.uj
    public void ve() {
        this.u = 1;
        this.sl = false;
    }

    public com.byazt.ete.i c(String str, byte b) {
        int i;
        int i2;
        String str2;
        String str3;
        String str4;
        String str5;
        int iVe;
        int iVe2;
        View viewDa = this.sp.da();
        int[] iArrC = pf.c(viewDa);
        if (iArrC == null || iArrC.length != 2) {
            i = 0;
            i2 = 0;
        } else {
            i = iArrC[0];
            i2 = iArrC[1];
            if (this.t == 0 && this.sl) {
                com.byazt.ete.da daVar = this.sp;
                daVar.c((pf.ve(this.f28610a, daVar.nu()) + i) - 0.5f);
                com.byazt.ete.da daVar2 = this.sp;
                daVar2.tt((pf.ve(this.f28610a, daVar2.rh()) + i2) - 0.5f);
                com.byazt.ete.da daVar3 = this.sp;
                daVar3.ve((pf.ve(this.f28610a, daVar3.my()) + i) - 0.5f);
                com.byazt.ete.da daVar4 = this.sp;
                daVar4.uj((pf.ve(this.f28610a, daVar4.gt()) + i2) - 0.5f);
            }
        }
        int[] iArrC2 = {-1, -1};
        int[] iArrVe = new int[2];
        com.byazt.ete.gr grVar = this.da;
        if (grVar == null || !this.sl) {
            str2 = "";
            str3 = str;
            str4 = "";
            str5 = str4;
        } else {
            this.sp.c(grVar.n);
            this.sp.tt(this.da.f28489a);
            if (this.t == 0) {
                iArrC2[0] = pf.ve(this.f28610a, this.da.sp) + i;
                iArrC2[1] = pf.ve(this.f28610a, this.da.x) + i2;
                iVe2 = pf.ve(this.f28610a, this.da.i);
                iVe = pf.ve(this.f28610a, this.da.da);
            } else {
                com.byazt.ete.gr grVar2 = this.da;
                iArrC2[0] = grVar2.sp;
                iArrC2[1] = grVar2.x;
                int i3 = grVar2.i;
                iVe = grVar2.da;
                iVe2 = i3;
            }
            str3 = TextUtils.isEmpty(str) ? this.da.sl : str;
            com.byazt.ete.gr grVar3 = this.da;
            str2 = grVar3.t;
            str5 = grVar3.u;
            str4 = grVar3.yp;
            iArrVe[0] = iVe2;
            iArrVe[1] = iVe;
            View viewI = this.sp.i();
            if (iVe2 == 0 && iVe == 0 && viewI != null) {
                iArrC2 = pf.c(viewI);
                iArrVe = pf.ve(viewI);
            }
        }
        this.t = 0;
        return new com.byazt.ete.i.c().a(this.sp.nu()).n(this.sp.rh()).uj(this.sp.my()).ve(this.sp.gt()).tt(this.sp.z()).c(this.sp.m()).tt(iArrC).c(iArrC2).ve(pf.ve(viewDa)).uj(iArrVe).uj(this.sp.n()).n(this.sp.a()).a(this.sp.sp()).ve(com.byazt.omf.x.m().tt() ? 1 : 2).c(this.sp.u()).c(str3).tt(str5).ve(str2).uj(str4).c(pf.a(this.f28610a)).tt(((com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new")).getDisplayDpi()).sp(this.u).x(this.yp).tt(pf.sp(this.f28610a)).n(this.sp.rl()).i(this.sp.qy()).tt(b).c(this.sp.ve()).c(com.byazt.wz.x.tt(this.c)).c();
    }

    @Override // com.byazt.hkv.uj
    public void c(com.byazt.ete.gr grVar) {
        this.da = grVar;
    }
}
