package com.byazt.msx;

import com.byazt.aas.cu;
import com.byazt.bzd.t;
import com.byazt.ddx.uj;
import com.byazt.ete.h;
import com.byazt.ete.ic;
import com.byazt.ete.xd;
import com.byazt.iym.tt;
import com.byazt.jzl.a;
import com.byazt.lcf.TTBaseVideoActivity;
import com.byazt.ouz.NativeExpressView;
import com.byazt.ouz.yv;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 341, 20})
public class c extends tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f28799a;

    public c(TTBaseVideoActivity tTBaseVideoActivity, ic icVar, String str, boolean z, boolean z2) {
        super(tTBaseVideoActivity, icVar, str, z, z2);
    }

    @Override // com.byazt.iym.tt
    public void c(NativeExpressView nativeExpressView) {
        Map<String, Object> mapC = this.c.c(this.tt);
        if (nativeExpressView.getDynamicShowType() == 0) {
            yv.c(mapC, this.tt, nativeExpressView);
        } else {
            mapC.put("dynamic_show_type", Integer.valueOf(nativeExpressView.getDynamicShowType()));
            byte showDLFactorsEventParams = nativeExpressView.getShowDLFactorsEventParams();
            if (showDLFactorsEventParams != -1) {
                mapC.put("biz_type", Byte.valueOf(showDLFactorsEventParams));
            }
        }
        h hVarZo = this.tt.zo();
        Double dHd = null;
        if (hVarZo != null) {
            mapC.put("refresh_num", Integer.valueOf(hVarZo.ve()));
            if (this.f28799a) {
                dHd = this.c.hd();
            }
        }
        uj.c(this.tt, this.ve, mapC, dHd);
        nativeExpressView.getAdShowTime().c(1.0f, 11);
        com.byazt.pf.c.c().uj();
        cu.c(this.tt.eo());
    }

    @Override // com.byazt.iym.tt
    public a da() {
        a aVarC = xd.c(1, this.tt);
        aVarC.setCid(this.tt.uj());
        aVarC.setWidth(100);
        aVarC.setHeight(100);
        aVarC.setLogExtra(this.tt.w_());
        aVarC.setQuiet(this.uj);
        if (t.c(this.tt)) {
            aVarC.setAudio(true);
        }
        return aVarC;
    }

    public void ve(boolean z) {
        this.f28799a = z;
    }
}
