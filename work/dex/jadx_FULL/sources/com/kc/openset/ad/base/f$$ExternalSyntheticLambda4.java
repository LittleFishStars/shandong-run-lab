package com.kc.openset.ad.base;

import android.view.View;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.util.ThreadUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public final /* synthetic */ class f$$ExternalSyntheticLambda4 implements ThreadUtils.UICallBack {
    public final f f$0;
    public final View f$1;

    static {
        OSETSDKProtected.interface11(3816);
    }

    public /* synthetic */ f$$ExternalSyntheticLambda4(f fVar, View view) {
        this.f$0 = fVar;
        this.f$1 = view;
    }

    @Override // com.kc.openset.util.ThreadUtils.UICallBack
    public final native void onUIThread();
}
