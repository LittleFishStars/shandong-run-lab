package com.byazt.nm;

import android.content.Context;
import com.byazt.omf.h;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 585, 46})
public class n extends tt {
    public com.byazt.ll.tt tt;
    public com.byazt.dv.tt ve;

    public n(com.byazt.db.tt ttVar) {
        super(ttVar);
    }

    private void c(h hVar, com.byazt.dj.tt.c cVar) {
        if (this.tt.yp() > 0.0f) {
            cVar.c(this.tt.u()).tt(this.tt.yp());
        } else {
            cVar.c(this.tt.u()).tt(0.0f);
        }
        new uj().c(this.ve.c(), hVar, cVar.c(), this);
    }

    private void tt(h hVar, com.byazt.dj.tt.c cVar) {
        new ve().c(this.ve.c(), hVar, cVar.c(), this);
    }

    @Override // com.byazt.sp.tt
    public void startLoad(Context context, com.byazt.dv.tt ttVar, com.byazt.ll.tt ttVar2, Map<String, Object> map) {
        h pluginCSJLoader;
        this.ve = ttVar;
        this.tt = ttVar2;
        if (ttVar2 == null) {
            notifyLoadFail(new com.byazt.pp.c("load ad fail adSlot is null"));
            return;
        }
        if (map == null || (pluginCSJLoader = getPluginCSJLoader(context.getApplicationContext())) == null) {
            return;
        }
        com.byazt.dj.tt.c cVarC = com.byazt.xf.tt.c(this.tt, this.ve, false);
        int iQy = this.tt.qy();
        int iGu = this.tt.gu();
        if (iQy > 0 && iGu > 0) {
            cVarC.c(iQy).tt(iGu);
        }
        Object obj = map.get("tt_ad_origin_type");
        if (obj == null) {
            notifyLoadFail(new com.byazt.pp.c("渲染类型错误"));
            return;
        }
        int iIntValue = ((Integer) obj).intValue();
        if (iIntValue == 1) {
            c(pluginCSJLoader, cVarC);
        } else if (iIntValue == 2) {
            tt(pluginCSJLoader, cVarC);
        } else {
            notifyLoadFail(new com.byazt.pp.c("渲染类型错误"));
        }
    }
}
