package com.kc.openset.ad;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.util.ThreadUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public final /* synthetic */ class OSETHttpUtils$$ExternalSyntheticLambda1 implements ThreadUtils.UICallBack {
    public final OSETHttpUtils.ICallBack f$0;
    public final b f$1;
    public final boolean f$2;
    public final String f$3;
    public final String f$4;

    static {
        OSETSDKProtected.interface11(3718);
    }

    public /* synthetic */ OSETHttpUtils$$ExternalSyntheticLambda1(OSETHttpUtils.ICallBack iCallBack, b bVar, boolean z, String str, String str2) {
        this.f$0 = iCallBack;
        this.f$1 = bVar;
        this.f$2 = z;
        this.f$3 = str;
        this.f$4 = str2;
    }

    @Override // com.kc.openset.util.ThreadUtils.UICallBack
    public final native void onUIThread();
}
