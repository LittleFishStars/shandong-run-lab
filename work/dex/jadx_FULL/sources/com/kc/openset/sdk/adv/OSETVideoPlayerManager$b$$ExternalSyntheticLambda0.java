package com.kc.openset.sdk.adv;

import android.graphics.Bitmap;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public final /* synthetic */ class OSETVideoPlayerManager$b$$ExternalSyntheticLambda0 implements Runnable {
    public final OSETVideoPlayerManager.b f$0;
    public final Bitmap f$1;

    static {
        OSETSDKProtected.interface11(4705);
    }

    public /* synthetic */ OSETVideoPlayerManager$b$$ExternalSyntheticLambda0(OSETVideoPlayerManager.b bVar, Bitmap bitmap) {
        this.f$0 = bVar;
        this.f$1 = bitmap;
    }

    @Override // java.lang.Runnable
    public final native void run();
}
