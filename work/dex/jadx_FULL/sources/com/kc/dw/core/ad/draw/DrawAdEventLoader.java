package com.kc.dw.core.ad.draw;

import android.content.Context;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class DrawAdEventLoader extends DrawCommonAdLoader {
    private static final String TAG = "DrawV3AdLoader";

    public DrawAdEventLoader(Context context, SsdAdSlot ssdAdSlot, DrawAdLoadListener drawAdLoadListener) {
        if (ssdAdSlot == null) {
            LogUtil.e(TAG, "MsAdSlot is null");
        } else {
            init(context, ssdAdSlot, drawAdLoadListener);
        }
    }
}
