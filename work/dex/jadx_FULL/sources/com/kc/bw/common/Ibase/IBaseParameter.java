package com.kc.bw.common.Ibase;

import android.content.Context;
import com.kc.bw.common.Iinterface.IGetBuyerIdListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface IBaseParameter<T> {
    int getAdHeight();

    String getAdSlotId();

    int getAdWidth();

    IGetBuyerIdListener getBuyerIdListener();

    Context getContext();

    T getExtraBean();

    String getServerBidToken();
}
