package com.kc.openset.sdk.apiad;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public final /* synthetic */ class OSETAPIRewardADActivity$j$$ExternalSyntheticLambda0 implements Runnable {
    public final OSETAPIRewardADActivity.j f$0;
    public final Context f$1;
    public final Bitmap f$2;
    public final ImageView f$3;

    static {
        OSETSDKProtected.interface11(4805);
    }

    public /* synthetic */ OSETAPIRewardADActivity$j$$ExternalSyntheticLambda0(OSETAPIRewardADActivity.j jVar, Context context, Bitmap bitmap, ImageView imageView) {
        this.f$0 = jVar;
        this.f$1 = context;
        this.f$2 = bitmap;
        this.f$3 = imageView;
    }

    @Override // java.lang.Runnable
    public final native void run();
}
