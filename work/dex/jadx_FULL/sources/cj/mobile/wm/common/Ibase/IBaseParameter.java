package cj.mobile.wm.common.Ibase;

import android.content.Context;
import cj.mobile.wm.common.Iinterface.IGetBuyerIdListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface IBaseParameter<T> {
    int getAdHeight();

    String getAdSlotId();

    int getAdWidth();

    IGetBuyerIdListener getBuyerIdListener();

    Context getContext();

    T getExtraBean();

    String getServerBidToken();
}
