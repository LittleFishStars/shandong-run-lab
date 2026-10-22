package com.kc.dw.core.ad.paster;

import android.content.Context;
import android.view.ViewGroup;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class PasterAdEventLoader extends PasterCommonAdLoader {
    private static final String TAG = "PasterV3AdLoader";

    public PasterAdEventLoader(Context context, ViewGroup viewGroup, SsdAdSlot ssdAdSlot, PasterAdLoadListener pasterAdLoadListener) {
        if (ssdAdSlot == null) {
            LogUtil.e(TAG, "MsAdSlot is null");
        } else {
            init(context, ssdAdSlot, pasterAdLoadListener);
            this.containerView = viewGroup;
        }
    }
}
