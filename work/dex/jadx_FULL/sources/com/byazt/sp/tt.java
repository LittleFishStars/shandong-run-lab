package com.byazt.sp;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.eu.n;
import com.byazt.nr.m;
import com.byazt.omf.x;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 91, 13})
public abstract class tt extends com.byazt.fb.uj implements com.byazt.db.c, com.byazt.db.tt {
    public com.byazt.db.tt c;
    public boolean tt = false;
    public boolean ve = false;

    public tt(com.byazt.db.tt ttVar) {
        this.c = ttVar;
    }

    @Override // com.byazt.db.c
    public final void adnStartLoad(final Context context, final com.byazt.dv.tt ttVar, final com.byazt.ll.tt ttVar2, final Map<String, Object> map) {
        if (ttVar == null || !(TextUtils.equals(MediationConstant.ADN_MINTEGRAL, ttVar.u()) || TextUtils.equals("baidu", ttVar.u()))) {
            c(context, ttVar, ttVar2, map);
        } else {
            n.ve(new Runnable() { // from class: com.byazt.sp.tt.1
                @Override // java.lang.Runnable
                public void run() {
                    tt.this.c(context, ttVar, ttVar2, map);
                }
            });
        }
    }

    @Override // com.byazt.fb.uj
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        return null;
    }

    @Override // com.byazt.db.c
    public String getBiddingToken(Context context, com.byazt.dv.tt ttVar, com.byazt.ll.tt ttVar2) {
        return null;
    }

    public boolean hasNotifyFail() {
        return this.ve;
    }

    public boolean hasNotifySuccess() {
        return this.tt;
    }

    @Override // com.byazt.db.tt
    public void nativeDislikeClick(com.byazt.yl.ve veVar, String str) {
        com.byazt.db.tt ttVar = this.c;
        if (ttVar != null) {
            ttVar.nativeDislikeClick(veVar, str);
        }
    }

    @Override // com.byazt.db.tt
    public void notifyLoadFail(com.byazt.pp.c cVar) {
        this.ve = true;
        if (this.tt) {
            return;
        }
        this.tt = true;
        com.byazt.db.tt ttVar = this.c;
        if (ttVar != null) {
            ttVar.notifyLoadFail(cVar);
        }
    }

    public void notifyLoadSuccess(com.byazt.yl.ve veVar) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(veVar);
        notifyLoadSuccess(arrayList);
    }

    public void notifyVideoCache(com.byazt.yl.ve veVar, com.byazt.pp.c cVar) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(veVar);
        notifyVideoCache(arrayList, cVar);
    }

    public abstract void startLoad(Context context, com.byazt.dv.tt ttVar, com.byazt.ll.tt ttVar2, Map<String, Object> map);

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, com.byazt.dv.tt ttVar, com.byazt.ll.tt ttVar2, Map<String, Object> map) {
        this.tt = false;
        this.ve = false;
        if (x.m().lr()) {
            startLoad(context, ttVar, ttVar2, map);
            c(ttVar);
            return;
        }
        try {
            startLoad(context, ttVar, ttVar2, map);
            c(ttVar);
        } catch (Throwable th) {
            notifyLoadFail(new com.byazt.pp.c(com.byazt.qe.tt.c(th)));
            m.c(th);
        }
    }

    @Override // com.byazt.db.tt
    public void notifyLoadSuccess(List<com.byazt.yl.ve> list) {
        if (this.tt) {
            return;
        }
        this.tt = true;
        com.byazt.db.tt ttVar = this.c;
        if (ttVar != null) {
            ttVar.notifyLoadSuccess(list);
        }
    }

    @Override // com.byazt.db.tt
    public void notifyVideoCache(List<com.byazt.yl.ve> list, com.byazt.pp.c cVar) {
        com.byazt.db.tt ttVar;
        if (this.ve || (ttVar = this.c) == null) {
            return;
        }
        ttVar.notifyVideoCache(list, cVar);
    }

    private void c(com.byazt.dv.tt ttVar) {
        if (ttVar != null) {
            com.byazt.xx.ve.tt(ttVar.u(), ttVar.tt(), ttVar.t());
        }
    }
}
