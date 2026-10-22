package com.kc.openset.pine.manager;

import android.app.Activity;
import android.view.View;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class ViewFinderUtils {
    static {
        OSETSDKProtected.interface11(4612);
    }

    public static native List<View> findFullyVisibleViewsByText(Activity activity, String str, boolean z, boolean z2);

    private static native void findFullyVisibleViewsByText(View view, String str, List<View> list, boolean z, boolean z2);

    public static native List<View> findInterstitialVisibleViewsByText(View view, String str, boolean z, boolean z2);
}
