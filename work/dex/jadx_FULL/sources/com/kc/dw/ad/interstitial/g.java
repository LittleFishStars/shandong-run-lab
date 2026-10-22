package com.kc.dw.ad.interstitial;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.android.arouter.utils.Consts;
import com.kc.dw.activity.SsdInterstitialActivity;
import com.kc.dw.core.ad.AdType;
import com.kc.dw.core.ad.interstitial.InterstitialCommonAdLoader;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.g0;
import com.kc.dw.core.utils.t0;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class g extends com.kc.dw.core.ad.a implements com.kc.dw.platform.ad_adapter.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.kc.dw.platform.ad_adapter.interstitial.b f39103a;
    public a b;
    public boolean c;
    public boolean d;
    public int e;
    public int f;
    public int g;
    public long h;
    public long i;
    public long j;

    public g(com.kc.dw.platform.ad_adapter.interstitial.b bVar, a aVar) {
        super(null, "SSD");
        this.e = 1;
        this.f39103a = bVar;
        this.b = aVar;
    }

    public static boolean a(g gVar, String str) {
        gVar.getClass();
        try {
            return str.equals(gVar.a().getVideo_cover());
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(Activity activity) {
        if (this.d) {
            LogUtil.e("NativeInterstitialAd", "ad has been called show");
            return;
        }
        this.d = true;
        a().getAct_type();
        LogUtil.d("NativeInterstitialAd", "create_type=" + a().getAdPatternType());
        LogUtil.d("NativeInterstitialAd", "actType=" + a().getAct_type());
        SsdInterstitialActivity.setSdkAd(this);
        SsdInterstitialActivity.setAdWrapper(this.f39103a);
        SsdInterstitialActivity.setMsAd(this);
        SsdInterstitialActivity.setAdListener(this.b);
        Intent intent = new Intent(activity, (Class<?>) SsdInterstitialActivity.class);
        intent.putExtra("isVideoAutoPlay", ((InterstitialCommonAdLoader) this.f39103a.getAdLoader()).getIsVideoAutoPlay());
        intent.putExtra("isClickToClose", ((InterstitialCommonAdLoader) this.f39103a.getAdLoader()).getIsClickToClose());
        intent.putExtra("act_type", a().getAct_type());
        intent.putExtra("layout_type", this.e);
        intent.putExtra("layout_width", this.g);
        intent.putExtra("layout_height", this.f);
        activity.startActivity(intent);
    }

    @Override // com.kc.dw.platform.ad_adapter.c
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public b a() {
        return (b) this.f39103a.f39477a;
    }

    public void d() {
        com.kc.dw.platform.ad_adapter.interstitial.b bVar = this.f39103a;
        if (bVar == null || bVar.getLoaderListener() == null || this.c) {
            return;
        }
        this.c = true;
        t0.a(((b) this.f39103a.f39477a).getPosId(), 3);
        a().getMonitorUrl();
        String[] strArrB = g0.b(a().getMonitorUrl(), this.h + Consts.DOT + this.i + Consts.DOT + this.j);
        try {
            g0.a(strArrB, this.adView.findViewById(R.id.ssd_activity_sdk_interstitial_mediaContainer), (View) null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (strArrB != null) {
            for (String str : strArrB) {
                if (!TextUtils.isEmpty(str)) {
                    int act_type = a().getAct_type();
                    if ((act_type & 2) == 2) {
                        act_type = (act_type - 2) | 1;
                    }
                    c.a(this.f39103a.getContext(), g0.a(g0.a(str, act_type, AdType.INTERSTITIAL)));
                }
            }
        }
        if (getInteractionListener() != null) {
            getInteractionListener().onAdExposure();
        }
    }

    @Override // com.kc.dw.platform.ad_adapter.c
    public AdType getAdType() {
        return AdType.INTERSTITIAL;
    }

    @Override // com.kc.dw.platform.ad_adapter.c
    public Context getContext() {
        if (getAdView() != null) {
            getAdView().getContext();
        }
        return this.f39103a.getContext();
    }

    @Override // com.kc.dw.platform.ad_adapter.c
    public int getInteractionType() {
        return ((b) this.f39103a.f39477a).getInteractionType();
    }

    @Override // com.kc.dw.core.ad.a
    public boolean isAutoRender() {
        com.kc.dw.platform.ad_adapter.interstitial.b bVar = this.f39103a;
        return bVar != null ? bVar.isAutoRender() : super.isAutoRender();
    }
}
