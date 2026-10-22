package com.kc.dw.platform.custom.ca.intertitial;

import android.app.Activity;
import android.content.Context;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.recycler.MsCustomRecyclerFeedAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface IIntertitialChangeAd<T> {
    void createIntertitialAd(Context context, MsCustomRecyclerFeedAd msCustomRecyclerFeedAd, SsdAdSlot ssdAdSlot, CustomInfo customInfo);

    void showAd(Activity activity);
}
