package cj.mobile.wm.common.Iinterface;

import android.view.ViewGroup;
import cj.mobile.wm.common.Ibase.IBaseInterface;
import cj.mobile.wm.common.Ilistener.XAdSplashListener;
import cj.mobile.wm.common.bean.WMAdSlot;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface ISplashInterface extends IBaseInterface<ISplashInterface> {
    void destroy();

    Map getAdInfo();

    void getBuyerIdWithAdSlotId(String str, IGetBuyerIdListener iGetBuyerIdListener);

    void load(WMAdSlot wMAdSlot, XAdSplashListener xAdSplashListener);

    void show(ViewGroup viewGroup);
}
