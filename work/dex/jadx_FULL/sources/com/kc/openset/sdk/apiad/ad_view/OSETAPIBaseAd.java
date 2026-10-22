package com.kc.openset.sdk.apiad.ad_view;

import android.content.Context;
import android.view.View;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.sdk.adv.hub.ADVAdObject;
import com.kc.openset.sdk.adv.listener.ADVBaseListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public abstract class OSETAPIBaseAd {
    protected static final String TAG = OSETSDKProtected.getString2(2881);
    protected ADVAdObject adObject;
    protected com.kc.openset.sdk.adv.a advBean;
    protected com.kc.openset.sdk.apiad.tools.c apiAdData;
    private WeakReference<Context> context;
    protected ADVBaseListener adListener = com.kc.openset.sdk.apiad.tools.a.a().b(getRequestId());
    protected WeakReference<View> adView = new WeakReference<>(initAdView());

    static {
        OSETSDKProtected.interface11(4817);
    }

    public OSETAPIBaseAd(ADVAdObject aDVAdObject) {
        this.adObject = aDVAdObject;
        this.context = new WeakReference<>(aDVAdObject.getContext());
        this.advBean = aDVAdObject.getAdvBean();
        this.apiAdData = aDVAdObject.getApiAdData();
        com.kc.openset.sdk.apiad.tools.c cVar = this.apiAdData;
        if (cVar != null) {
            ADVBaseListener aDVBaseListener = this.adListener;
            cVar.H(aDVBaseListener == null ? "" : aDVBaseListener.getUserId());
        }
    }

    public native void destroy();

    public abstract ADVBaseListener getAdListener();

    public native View getAdView();

    public native String getAppInfo(com.kc.openset.sdk.apiad.tools.c cVar);

    public native Context getContext();

    public native String getRequestId();

    public native int[] getTiltSensorSen();

    public abstract View initAdView();

    public native boolean isReady();

    public native void onActivityPaused();

    public native void onActivityResumed();

    public abstract void onAdShow();

    public native void reportAdEvent(com.kc.openset.sdk.adv.report.b bVar);
}
