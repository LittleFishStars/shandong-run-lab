package com.kc.dw.platform.ad_adapter.recycler;

import android.text.TextUtils;
import com.kc.dw.core.ad.AdType;
import com.kc.dw.core.ad.recycler.RecyclerAdListener;
import com.kc.dw.core.ad.recycler.RecyclerMixCommonAdLoader;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.g0;
import com.kc.dw.core.utils.t0;
import com.kc.dw.core.utils.z;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class c implements com.kc.dw.ad.nativ.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerAdListener f39487a;
    public e b;
    public volatile boolean c;

    public c(e eVar, RecyclerAdListener recyclerAdListener) {
        this.b = eVar;
        this.f39487a = recyclerAdListener;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0020  */
    @Override // com.kc.dw.ad.z
    public void a(List<com.kc.dw.ad.nativ.d> list) {
        boolean z;
        List<com.kc.dw.ad.nativ.d> list2 = list;
        try {
            if (this.f39487a == null || list2 == null) {
                return;
            }
            int drawing = ((com.kc.dw.ad.nativ.i) this.b.f39477a).getDrawing();
            if (this.b.getAdLoader() instanceof RecyclerMixCommonAdLoader) {
                z = true;
                if (drawing == 1) {
                    z = false;
                }
            } else {
                z = false;
            }
            LogUtil.dev("MeishuAdListenerAdapter", "isPreRender：" + z);
            ArrayList arrayList = new ArrayList();
            for (com.kc.dw.ad.nativ.d dVar : list2) {
                arrayList.add(z ? new i(this.b, dVar) : new q(this.b, dVar));
            }
            this.f39487a.onAdReady(arrayList);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kc.dw.ad.z
    public void onADExposure() {
        LogUtil.d("MeishuAdListenerAdapter", "onADExposure----------");
        try {
            if (this.c) {
                return;
            }
            this.c = true;
            t0.a(((com.kc.dw.ad.nativ.i) this.b.f39477a).getPosId(), 3);
            String[] monitorUrl = ((com.kc.dw.ad.nativ.i) this.b.f39477a).getMonitorUrl();
            if (monitorUrl != null) {
                LogUtil.d("MeishuAdListenerAdapter", "send onADExposure");
                for (String str : monitorUrl) {
                    if (!TextUtils.isEmpty(str)) {
                        int act_type = ((com.kc.dw.ad.nativ.i) this.b.f39477a).getAct_type();
                        if ((act_type & 2) == 2) {
                            act_type = (act_type - 2) | 1;
                        }
                        z.a(this.b.getContext(), g0.a(g0.a(str, act_type, AdType.FEED_MIX)), new com.kc.dw.core.utils.j());
                    }
                }
            }
            RecyclerAdListener recyclerAdListener = this.f39487a;
            if (recyclerAdListener != null) {
                recyclerAdListener.onAdExposure();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kc.dw.ad.z
    public void onAdRenderFail(String str, int i) {
        try {
            if (((com.kc.dw.ad.nativ.i) this.b.f39477a).getErrorUrl() != null) {
                z.a(((com.kc.dw.ad.nativ.i) this.b.f39477a).getErrorUrl()[0], Integer.valueOf(i), str);
            }
            RecyclerAdListener recyclerAdListener = this.f39487a;
            if (recyclerAdListener != null) {
                recyclerAdListener.onAdPlatformError(new com.kc.dw.platform.ad_adapter.f(str, Integer.valueOf(i)));
                this.f39487a.onAdRenderFail(str, i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
