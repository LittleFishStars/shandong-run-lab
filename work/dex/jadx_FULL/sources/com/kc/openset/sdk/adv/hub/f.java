package com.kc.openset.sdk.adv.hub;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.config.AdType;
import com.kc.openset.sdk.adv.listener.ADVBaseListener;
import com.kc.openset.sdk.adv.listener.ADVSPlashListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class f extends ADVAdObject {
    static {
        OSETSDKProtected.interface11(4756);
    }

    public f(Context context, String str, String str2) {
        super(context, str, str2, AdType.AD_TYPE_SPLASH);
    }

    public native void a(Activity activity, ViewGroup viewGroup);

    public native void a(ADVSPlashListener aDVSPlashListener);

    @Override // com.kc.openset.sdk.adv.hub.ADVAdObject
    public native ADVBaseListener initADVListener(ADVBaseListener aDVBaseListener);

    @Override // com.kc.openset.sdk.adv.hub.ADVAdObject
    public native void onAdLoadSuccess();
}
