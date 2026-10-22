package com.kc.openset.advertisers.hl;

import android.os.Bundle;
import com.hailiang.advlib.core.IMultiAdObject;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public final /* synthetic */ class HLNativeAdapter$$ExternalSyntheticLambda0 implements IMultiAdObject.ADStateListener {
    public final HLNativeAdapter f$0;

    static {
        OSETSDKProtected.interface11(4270);
    }

    @Override // com.hailiang.advlib.core.IMultiAdObject.ADStateListener
    public final native void onAdEvent(int i, Bundle bundle);
}
