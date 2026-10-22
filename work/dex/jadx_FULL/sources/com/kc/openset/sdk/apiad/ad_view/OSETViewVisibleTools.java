package com.kc.openset.sdk.apiad.ad_view;

import android.view.View;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class OSETViewVisibleTools {

    @Keep
    public interface OSETOnViewVisibleListener {
        void onVisibility(boolean z);
    }

    static {
        OSETSDKProtected.interface11(4819);
    }

    public static native boolean a(View view);
}
