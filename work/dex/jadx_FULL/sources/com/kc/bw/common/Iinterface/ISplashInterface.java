package com.kc.bw.common.Iinterface;

import android.view.ViewGroup;
import com.kc.bw.common.Ibase.IBaseInterface;
import com.kc.bw.common.Ilistener.XAdSplashListener;
import com.kc.bw.common.bean.WMAdSlot;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface ISplashInterface extends IBaseInterface<ISplashInterface> {
    void destroy();

    Map getAdInfo();

    void getBuyerIdWithAdSlotId(String str, IGetBuyerIdListener iGetBuyerIdListener);

    void load(WMAdSlot wMAdSlot, XAdSplashListener xAdSplashListener);

    void show(ViewGroup viewGroup);
}
