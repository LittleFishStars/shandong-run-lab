package com.kc.openset.sdk.apiad.ad_view;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.util.ThreadUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public final /* synthetic */ class c$f$$ExternalSyntheticLambda1 implements ThreadUtils.UICallBack {
    public final ImageView f$0;
    public final Bitmap f$1;

    static {
        OSETSDKProtected.interface11(4859);
    }

    public /* synthetic */ c$f$$ExternalSyntheticLambda1(ImageView imageView, Bitmap bitmap) {
        this.f$0 = imageView;
        this.f$1 = bitmap;
    }

    @Override // com.kc.openset.util.ThreadUtils.UICallBack
    public final native void onUIThread();
}
