package com.kc.openset.sdk.apiad;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.util.ThreadUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public final /* synthetic */ class OSETAPIRewardADActivity$j$$ExternalSyntheticLambda1 implements ThreadUtils.UICallBack {
    public final OSETAPIRewardADActivity.j f$0;
    public final ImageView f$1;
    public final Bitmap f$2;

    static {
        OSETSDKProtected.interface11(4806);
    }

    public /* synthetic */ OSETAPIRewardADActivity$j$$ExternalSyntheticLambda1(OSETAPIRewardADActivity.j jVar, ImageView imageView, Bitmap bitmap) {
        this.f$0 = jVar;
        this.f$1 = imageView;
        this.f$2 = bitmap;
    }

    @Override // com.kc.openset.util.ThreadUtils.UICallBack
    public final native void onUIThread();
}
