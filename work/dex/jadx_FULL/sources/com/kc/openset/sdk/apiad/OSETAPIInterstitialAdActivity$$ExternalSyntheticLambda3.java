package com.kc.openset.sdk.apiad;

import android.graphics.Bitmap;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.util.ThreadUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public final /* synthetic */ class OSETAPIInterstitialAdActivity$$ExternalSyntheticLambda3 implements ThreadUtils.UICallBack {
    public final OSETAPIInterstitialAdActivity f$0;
    public final Bitmap f$1;

    static {
        OSETSDKProtected.interface11(4777);
    }

    public /* synthetic */ OSETAPIInterstitialAdActivity$$ExternalSyntheticLambda3(OSETAPIInterstitialAdActivity oSETAPIInterstitialAdActivity, Bitmap bitmap) {
        this.f$0 = oSETAPIInterstitialAdActivity;
        this.f$1 = bitmap;
    }

    @Override // com.kc.openset.util.ThreadUtils.UICallBack
    public final native void onUIThread();
}
