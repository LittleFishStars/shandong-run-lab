package com.hailiang.advlib.ui.banner;

import com.hailiang.advlib.core.ICliBundle;
import com.hailiang.advlib.core.ICliUtils;
import com.hailiang.advlib.core.IMultiAdObject;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
public interface Banner {
    void OnBannerInit();

    void UpdateView(ICliBundle iCliBundle);

    void setADStateListener(IMultiAdObject.ADStateListener aDStateListener);

    void setPageUniqueId(int i);

    void setStateListener(ICliUtils.BannerStateListener bannerStateListener);

    void updateViewWithAds(Object obj);
}
