package com.kc.dw.platform.custom.recycler;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.kc.dw.ad.interstitial.c;
import com.kc.dw.ad.nativ.d;
import com.kc.dw.core.ad.AdType;
import com.kc.dw.core.ad.BaseAdSlot;
import com.kc.dw.core.ad.recycler.FeedAd;
import com.kc.dw.core.ad.recycler.FeedExpressAdInteractionListener;
import com.kc.dw.core.loader.b;
import com.kc.dw.core.router.log.bean.ClickAdState;
import com.kc.dw.core.router.log.bean.LoadResState;
import com.kc.dw.core.router.log.bean.ShowAdState;
import com.kc.dw.core.service.logrecord.a;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.f;
import com.kc.dw.core.utils.g0;
import com.kc.dw.core.utils.s1;
import com.kc.dw.platform.BasePlatformLoader;
import com.kc.dw.platform.ad_adapter.recycler.i;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class MsCustomRecyclerExpressAd extends FeedAd<FeedExpressAdInteractionListener> {
    private static final String TAG = "MsCustomRecyclerExpress";
    private BaseAdSlot baseAdSlot;

    private void initBaseAdSlot() {
        if (this instanceof i) {
            i iVar = (i) this;
            d dVar = iVar.f39495a;
            if ((dVar != null ? dVar.a() : null) != null) {
                d dVar2 = iVar.f39495a;
                this.baseAdSlot = dVar2 != null ? dVar2.a() : null;
            }
        }
    }

    public void callAdClicked() {
        initBaseAdSlot();
        b platformLoader = getPlatformLoader();
        ClickAdState clickAdState = new ClickAdState();
        BaseAdSlot baseAdSlot = this.baseAdSlot;
        int clkActType = baseAdSlot != null ? baseAdSlot.getClkActType() : -1;
        BaseAdSlot baseAdSlot2 = this.baseAdSlot;
        a.a(5, "e8", platformLoader, clickAdState.setData(clkActType, baseAdSlot2 != null ? baseAdSlot2.getClkPower() : -1));
        if (getPlatformLoader() != null && getPlatformLoader().getSdkAdInfo() != null && !TextUtils.isEmpty(getPlatformLoader().getSdkAdInfo().getClk())) {
            LogUtil.d(TAG, "send onAdClicked");
            c.a(com.kc.dw.base.a.getContext(), f.a(getPlatformLoader().getSdkAdInfo().getClk(), this));
        }
        if (getExpressAdInteractionListener() != null) {
            getExpressAdInteractionListener().onAdClicked();
        }
    }

    public void callAdClosed() {
        a.a(5, "click_close", getPlatformLoader());
        if (getExpressAdInteractionListener() != null) {
            getExpressAdInteractionListener().onAdClosed();
        }
    }

    public void callAdExposure() {
        if (com.kc.dw.core.utils.a.a(getPlatformLoader())) {
            return;
        }
        try {
            getPlatformLoader().getSdkAdInfo().getAppendInfo().setHasExposed(true);
        } catch (Exception unused) {
        }
        initBaseAdSlot();
        com.kc.dw.core.service.logrecord.util.c.d(getPlatformLoader());
        a.a(5, "s7", getPlatformLoader(), new ShowAdState().setSuccess(com.kc.dw.core.service.logrecord.b.a(this.baseAdSlot, getPlatformLoader().getSdkAdInfo(), AdType.FEED_MIX.value()), com.kc.dw.core.service.logrecord.b.a(this.baseAdSlot)));
        if (getPlatformLoader() != null && getPlatformLoader().getSdkAdInfo() != null && !TextUtils.isEmpty(getPlatformLoader().getSdkAdInfo().getImp())) {
            c.a(com.kc.dw.base.a.getContext(), g0.a(getPlatformLoader().getSdkAdInfo().getImp()));
        }
        if (getExpressAdInteractionListener() != null) {
            getExpressAdInteractionListener().onAdExposure();
        }
    }

    public void callRenderError(int i, String str) {
        LinkedHashMap<String, Long> eventTimes;
        b platformLoader = getPlatformLoader();
        if (platformLoader != null) {
            try {
                if (com.kc.dw.core.service.logrecord.util.c.a(platformLoader) != null) {
                    boolean z = false;
                    try {
                        if (!TextUtils.isEmpty("e4")) {
                            try {
                                eventTimes = platformLoader.getSdkAdInfo().getAppendInfo().getEventTimes(com.kc.dw.core.service.logrecord.b.a(platformLoader.getSdkAdInfo()));
                            } catch (Exception unused) {
                                eventTimes = null;
                            }
                            if (eventTimes != null && !eventTimes.isEmpty() && eventTimes.containsKey("e4")) {
                                int i2 = 0;
                                while (true) {
                                    if (i2 < 2) {
                                        String str2 = new String[]{"s4", "f4"}[i2];
                                        if (str2 != null && eventTimes.containsKey(str2)) {
                                            break;
                                        } else {
                                            i2++;
                                        }
                                    } else {
                                        z = true;
                                        break;
                                    }
                                }
                            }
                        }
                    } catch (Exception unused2) {
                    }
                    if (z) {
                        a.a(5, "f4", platformLoader, new LoadResState().setFail((i == com.kc.dw.core.exception.b.c.intValue() || i == -1) ? 2 : 3));
                    }
                }
            } catch (Exception unused3) {
            }
        }
        com.kc.dw.core.service.logrecord.util.c.b(getPlatformLoader());
        a.a(5, "f5", getPlatformLoader(), 2, str);
        if (getExpressAdInteractionListener() != null) {
            getExpressAdInteractionListener().onRenderError(i, str);
        }
    }

    public void callRenderSuccess() {
        com.kc.dw.core.service.logrecord.util.c.b(getPlatformLoader());
        if (!com.kc.dw.core.service.logrecord.b.a(getPlatformLoader(), "s5")) {
            a.a(5, "s5", getPlatformLoader());
        }
        if (getExpressAdInteractionListener() != null) {
            getExpressAdInteractionListener().onRenderSuccess();
        }
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public abstract View getExpressView();

    public boolean isNativeExpress() {
        return true;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public void render(Activity activity) {
        try {
            if (((BasePlatformLoader) getPlatformLoader()).getIsChangeAdapter() || getPlatformLoader() == null || getPlatformLoader().getSdkAdInfo() == null) {
                return;
            }
            s1.b(getPlatformLoader().getSdkAdInfo().getEventUrl());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
