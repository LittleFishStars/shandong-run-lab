package com.kc.dw.core.ad.recycler;

import android.content.Context;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class RecyclerMixAdEventLoader extends RecyclerMixCommonAdLoader {
    private static final String TAG = "RecyclerMixV3AdLoader";

    public RecyclerMixAdEventLoader(Context context, SsdAdSlot ssdAdSlot, RecyclerAdLoadListener recyclerAdLoadListener) {
        if (ssdAdSlot == null) {
            LogUtil.e(TAG, "MsAdSlot is null");
        } else {
            this.fetchCount = ssdAdSlot.getFetchCount() <= 0 ? 1 : ssdAdSlot.getFetchCount();
            init(context, ssdAdSlot, new RecyclerAdEventAdapter(recyclerAdLoadListener));
        }
    }
}
