package com.byazt.tp;

import android.content.Context;
import com.byazt.ete.ic;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 436, 54})
public class ve extends tt {
    public ve(Context context, ic icVar, com.byazt.dj.tt ttVar) {
        super(context, icVar, ttVar);
    }

    @Override // com.byazt.tp.tt
    public void c(Context context, ic icVar, com.byazt.dj.tt ttVar) {
        if (context == null) {
            return;
        }
        ((tt) this).c = new BannerExpressVideoView(context, icVar, ttVar);
    }

    @Override // com.byazt.ouz.tt
    public com.byazt.ua.c getVideoModel() {
        WeakReference<BannerExpressBackupView> weakReference = this.sp;
        if (weakReference != null && weakReference.get() != null) {
            return this.sp.get().getVideoModel();
        }
        c cVar = ((tt) this).c;
        if (cVar != null) {
            return ((BannerExpressVideoView) cVar).getVideoModel();
        }
        return null;
    }

    @Override // com.byazt.ouz.tt, com.byazt.nc.yp
    public void setVideoAdListener(com.byazt.ft.ve veVar) {
        c cVar = ((tt) this).c;
        if (cVar != null) {
            cVar.setVideoAdListener(veVar);
        }
    }
}
