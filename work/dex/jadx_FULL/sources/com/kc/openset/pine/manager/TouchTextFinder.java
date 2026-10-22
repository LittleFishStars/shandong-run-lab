package com.kc.openset.pine.manager;

import android.app.Activity;
import android.view.View;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class TouchTextFinder {
    static {
        OSETSDKProtected.interface11(4611);
    }

    public static native List<String> findTextsAtPoint(Activity activity, int i, int i2);

    private static native void findTextsAtPoint(View view, int i, int i2, List<String> list);
}
