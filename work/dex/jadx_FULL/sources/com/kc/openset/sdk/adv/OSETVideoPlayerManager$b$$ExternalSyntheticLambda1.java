package com.kc.openset.sdk.adv;

import android.graphics.Bitmap;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.util.ThreadUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public final /* synthetic */ class OSETVideoPlayerManager$b$$ExternalSyntheticLambda1 implements ThreadUtils.UICallBack {
    public final OSETVideoPlayerManager.b f$0;
    public final Bitmap f$1;

    static {
        OSETSDKProtected.interface11(4706);
    }

    public /* synthetic */ OSETVideoPlayerManager$b$$ExternalSyntheticLambda1(OSETVideoPlayerManager.b bVar, Bitmap bitmap) {
        this.f$0 = bVar;
        this.f$1 = bitmap;
    }

    @Override // com.kc.openset.util.ThreadUtils.UICallBack
    public final native void onUIThread();
}
