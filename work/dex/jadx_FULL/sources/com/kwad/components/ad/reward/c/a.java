package com.kwad.components.ad.reward.c;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.webview.jshandler.j;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ae;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class a {
    private static volatile a vb;
    private g uj;

    @Nullable
    private b vc;
    private volatile boolean vd = false;
    private volatile boolean ve = false;
    private List<WeakReference<j>> vf = new CopyOnWriteArrayList();

    private a() {
    }

    public static a ih() {
        if (vb == null) {
            synchronized (a.class) {
                if (vb == null) {
                    vb = new a();
                }
            }
        }
        return vb;
    }

    private synchronized boolean ij() {
        b bVar = this.vc;
        return bVar != null && bVar.vj == b.vg;
    }

    private boolean isNeoScan() {
        AdGlobalConfigInfo adGlobalConfigInfo = this.uj.mAdResultData.adGlobalConfigInfo;
        return adGlobalConfigInfo != null && adGlobalConfigInfo.neoPageType == 1;
    }

    public final void R(Context context) {
        boolean zIj = ij();
        com.kwad.sdk.core.d.c.d("CurrentExtraRewardHolder", "checkStatusAndToast isCurrentHadExtra: " + zIj + ", hadToast: " + this.ve);
        if (this.ve || !zIj) {
            return;
        }
        this.ve = true;
        ae.V(context, "恭喜获得第2份奖励");
    }

    public final synchronized void a(AdTemplate adTemplate, b bVar) {
        if (adTemplate == null) {
            return;
        }
        com.kwad.sdk.core.d.c.d("CurrentExtraRewardHolder", "updateExtraReward: " + bVar.toJson().toString());
        this.vc = bVar;
        if (bVar.vj == b.vg && !this.vd) {
            this.vd = true;
            c.a(this.vc, com.kwad.components.ad.reward.e.f.O(adTemplate.getUniqueId()));
            com.kwad.sdk.core.adlog.c.l(adTemplate, isNeoScan());
        }
        for (WeakReference<j> weakReference : this.vf) {
            if (weakReference.get() == null) {
                this.vf.remove(weakReference);
            } else {
                b bVarIi = ii();
                com.kwad.sdk.core.d.c.d("CurrentExtraRewardHolder", "GetNativeDataHandler callback: " + bVarIi.toJson().toString());
                weakReference.get().a(bVarIi);
            }
        }
    }

    public final synchronized void e(AdTemplate adTemplate, int i) {
        com.kwad.sdk.core.d.c.d("CurrentExtraRewardHolder", "updateExtraReward: " + i);
        g gVar = this.uj;
        if (gVar != null && gVar.hi() && i == b.STATUS_NONE) {
            com.kwad.sdk.core.d.c.d("CurrentExtraRewardHolder", "updateExtraReward: cant update to status 2");
            return;
        }
        b bVarIi = ih().ii();
        bVarIi.ak(i);
        ih().a(adTemplate, bVarIi);
    }

    @NonNull
    public final synchronized b ii() {
        if (this.vc == null) {
            b bVarIl = c.il();
            this.vc = bVarIl;
            bVarIl.vj = 0;
        }
        com.kwad.sdk.core.d.c.d("CurrentExtraRewardHolder", "getCurrentExtraReward: " + this.vc.vj);
        return this.vc;
    }

    public final synchronized void reset() {
        this.vc = null;
        this.ve = false;
        this.vd = false;
        this.uj = null;
    }

    public final void setCallerContext(g gVar) {
        this.uj = gVar;
    }

    public final void a(j jVar) {
        com.kwad.sdk.core.d.c.d("CurrentExtraRewardHolder", "addGetNativeHandler: " + jVar);
        if (jVar != null) {
            this.vf.add(new WeakReference<>(jVar));
        }
    }
}
