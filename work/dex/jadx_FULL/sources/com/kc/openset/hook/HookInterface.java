package com.kc.openset.hook;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public interface HookInterface {
    void clearKsInterstitialView();

    void clearKsRewardSecondDialogView();

    String getClickExt(int i);

    void init(List<SensitivityBean> list);

    void initHap();

    void initKsInit();

    void initKsLoad();

    void initLogoInfo(List<LogoInfoBean> list);

    void initTaKu(double d, int i);
}
