package com.kc.openset.sdk.apiad.ad_view;

import android.widget.ImageView;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.util.ThreadUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public final /* synthetic */ class b$$ExternalSyntheticLambda0 implements ThreadUtils.UICallBack {
    public final b f$0;
    public final ImageView f$1;

    static {
        OSETSDKProtected.interface11(4832);
    }

    public /* synthetic */ b$$ExternalSyntheticLambda0(b bVar, ImageView imageView) {
        this.f$0 = bVar;
        this.f$1 = imageView;
    }

    @Override // com.kc.openset.util.ThreadUtils.UICallBack
    public final native void onUIThread();
}
