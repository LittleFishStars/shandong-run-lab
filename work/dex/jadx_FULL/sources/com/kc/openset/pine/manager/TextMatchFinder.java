package com.kc.openset.pine.manager;

import android.app.Activity;
import android.view.View;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class TextMatchFinder {
    static {
        OSETSDKProtected.interface11(4610);
    }

    public static native List<View> findViewsByExactText(Activity activity, String str);

    private static native void findViewsByExactText(View view, String str, List<View> list);
}
