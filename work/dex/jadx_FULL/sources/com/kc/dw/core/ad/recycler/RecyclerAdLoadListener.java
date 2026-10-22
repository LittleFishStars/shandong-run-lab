package com.kc.dw.core.ad.recycler;

import com.kc.dw.core.utils.AdError;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface RecyclerAdLoadListener {
    void onLoadFail(AdError adError);

    void onLoadedSuccess(List<RecyclerAdData> list);
}
