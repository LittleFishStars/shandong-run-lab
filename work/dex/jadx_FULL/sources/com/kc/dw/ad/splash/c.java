package com.kc.dw.ad.splash;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.gson.Gson;
import com.kc.dw.ad.nativ.NormalMediaView;
import com.kc.dw.core.ad.AdSlot;
import com.kc.dw.core.ad.AdType;
import com.kc.dw.core.ad.splash.SplashAd;
import com.kc.dw.core.router.log.bean.ShowAdState;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.SdkHandler;
import com.kc.dw.core.utils.q;
import com.kc.dw.core.utils.s1;
import com.kc.dw.platform.ad_adapter.splash.j;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class c extends SplashAd implements com.kc.dw.ad.splash.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f39168a;
    public d b;
    public SplashSkipView c;
    public NormalMediaView d;
    public SsdSplashRootView e;
    public boolean f;
    public boolean g;
    public boolean h;
    public List<b> i;

    @Keep
    public class a extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f39169a;

        public a(c cVar) {
            this.f39169a = cVar;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            SplashSkipView splashSkipView = this.f39169a.c;
            if (splashSkipView != null) {
                splashSkipView.c();
            }
        }
    }

    @Keep
    public interface b {
        void a(ViewGroup viewGroup);
    }

    public c(d dVar, j jVar, boolean z) {
        super(null, "SSD");
        this.i = new ArrayList();
        this.b = dVar;
        this.f39168a = jVar;
    }

    @Override // com.kc.dw.platform.ad_adapter.c
    public AdSlot a() {
        return this.b;
    }

    public void c() {
        if (this.adContainer == null) {
            String[] errorUrl = this.b.getErrorUrl();
            Integer num = com.kc.dw.core.exception.b.c;
            SdkHandler.getInstance().runOnUiThread(new q(errorUrl, num.intValue(), "开屏容器为空"));
            com.kc.dw.core.service.logrecord.a.a(5, "f7", this.f39168a, new ShowAdState().setFail(1, num.intValue(), "开屏容器为空"));
        }
        if (this.f || this.adContainer == null) {
            try {
                s1.a(this.b.getErrorUrl(), 12, 9000002, "广告重复展示");
                com.kc.dw.core.service.logrecord.a.a(5, "f7", this.f39168a, new ShowAdState().setFail(1, 9000002, "广告重复展示"));
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        View view = this.adView;
        if (view != null && view.getParent() != null && (this.adView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.adView.getParent()).removeView(this.adView);
        }
        this.adContainer.addView(this.adView);
        this.e.setVisibility(0);
        try {
            Gson gson = new Gson();
            HashMap map = new HashMap();
            map.put("stepNum", 5);
            map.put("msg", "attach to the container");
            map.put("creativeType", Integer.valueOf(this.b.getAdPatternType()));
            map.put("adView", this.adView != null ? 1 : 0);
            s1.a(this.b.getErrorUrl(), gson.toJson(map));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.e.post(new a(this));
        this.f = true;
    }

    @Override // com.kc.dw.platform.ad_adapter.c
    public AdType getAdType() {
        return AdType.SPLASH;
    }

    @Override // com.kc.dw.platform.ad_adapter.c
    public Context getContext() {
        return this.adView.getContext();
    }

    @Override // com.kc.dw.platform.ad_adapter.c
    public int getInteractionType() {
        return this.b.getInteractionType();
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.ad.IAd
    public void setAdView(View view) {
        this.adView = view;
    }

    @Override // com.kc.dw.core.ad.splash.SplashAd, com.kc.dw.core.ad.splash.ISplashAd
    public void showAd(ViewGroup viewGroup) {
        setAdContainer(viewGroup);
        LogUtil.d("c", "开屏容器 width=" + viewGroup.getWidth() + ",开屏容器 height=" + viewGroup.getHeight());
        List<b> list = this.i;
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<b> it = this.i.iterator();
        while (it.hasNext()) {
            it.next().a(viewGroup);
        }
        this.i.clear();
    }
}
