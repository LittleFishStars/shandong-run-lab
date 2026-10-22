package com.kc.dw.platform.ad_adapter.reward;

import android.text.TextUtils;
import com.kc.dw.activity.SsdRewardVideoPlayerActivity;
import com.kc.dw.ad.nativ.i;
import com.kc.dw.core.ad.AdSlot;
import com.kc.dw.core.ad.AdType;
import com.kc.dw.core.loader.IAdLoadListener;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.g0;
import com.kc.dw.core.utils.j;
import com.kc.dw.core.utils.t0;
import com.kc.dw.core.utils.z;
import com.kc.dw.platform.ad_adapter.f;
import com.kc.dw.platform.ad_adapter.h;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class a implements com.kc.dw.ad.nativ.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IAdLoadListener f39529a;
    public h b;
    public i c;
    public boolean d;
    public com.kc.dw.platform.ad_adapter.a e;

    public a(h hVar, IAdLoadListener iAdLoadListener, i iVar) {
        this.b = hVar;
        this.f39529a = iAdLoadListener;
        this.c = iVar;
    }

    @Override // com.kc.dw.ad.z
    public void a(List<com.kc.dw.ad.nativ.d> list) {
        try {
            if (this.f39529a == null || list == null || list.isEmpty()) {
                return;
            }
            com.kc.dw.platform.ad_adapter.a aVar = new com.kc.dw.platform.ad_adapter.a(this.b, list.get(0), this.c, this);
            this.e = aVar;
            this.f39529a.onAdLoaded(aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.kc.dw.core.loader.a] */
    @Override // com.kc.dw.ad.z
    public void onADExposure() {
        try {
            if (com.kc.dw.core.utils.a.a((AdSlot) this.c)) {
                LogUtil.dev("AdListenerAdapter", "has exp. return");
                return;
            }
            if (this.d) {
                return;
            }
            this.d = true;
            this.c.setHasExposed(true);
            t0.a(this.b.getAdLoader().getPosId(), 3);
            String[] monitorUrl = this.b.f39477a.getMonitorUrl();
            g0.a(monitorUrl);
            if (monitorUrl != null) {
                LogUtil.d("AdListenerAdapter", "send onAdExposure");
                for (String str : monitorUrl) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(this.b.getContext(), g0.a(g0.a(str, this.c.getAct_type(), this.b instanceof c ? AdType.REWARD : AdType.FULL_SCREEN_VIDEO)), new j());
                    }
                }
            }
            IAdLoadListener iAdLoadListener = this.f39529a;
            if (iAdLoadListener != null) {
                iAdLoadListener.onAdExposure();
            }
            this.d = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kc.dw.ad.z
    public void onAdRenderFail(String str, int i) {
        try {
            if (this.b.f39477a.getErrorUrl() != null) {
                z.a(this.b.f39477a.getErrorUrl()[0], Integer.valueOf(i), str);
            }
            if (this.e != null) {
                SsdRewardVideoPlayerActivity.clearRewardMediaView();
            }
            try {
                SsdRewardVideoPlayerActivity.clearRewardMediaView();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            IAdLoadListener iAdLoadListener = this.f39529a;
            if (iAdLoadListener != null) {
                iAdLoadListener.onAdPlatformError(new f(str, Integer.valueOf(i)));
                this.f39529a.onAdRenderFail(str, i);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
