package com.kc.openset.sdk.adv.hub;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.config.AdType;
import com.kc.openset.sdk.adv.listener.ADVBaseListener;
import com.kc.openset.sdk.adv.listener.ADVNativeListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class c extends ADVAdObject {
    static {
        OSETSDKProtected.interface11(4744);
    }

    public c(Context context, String str, String str2) {
        super(context, str, str2, AdType.AD_TYPE_NATIVE);
    }

    public native View a(Activity activity);

    public native void a(ADVNativeListener aDVNativeListener);

    @Override // com.kc.openset.sdk.adv.hub.ADVAdObject
    public native ADVBaseListener initADVListener(ADVBaseListener aDVBaseListener);
}
