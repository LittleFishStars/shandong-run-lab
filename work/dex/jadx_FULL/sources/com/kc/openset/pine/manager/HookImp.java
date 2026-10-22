package com.kc.openset.pine.manager;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.hook.HookInterface;
import com.kc.openset.hook.LogoInfoBean;
import com.kc.openset.hook.SensitivityBean;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class HookImp implements HookInterface {
    private boolean isInit = false;

    static {
        OSETSDKProtected.interface11(4597);
    }

    public static native JSONObject toJson(ClickExtBean clickExtBean);

    @Override // com.kc.openset.hook.HookInterface
    public native void clearKsInterstitialView();

    @Override // com.kc.openset.hook.HookInterface
    public native void clearKsRewardSecondDialogView();

    @Override // com.kc.openset.hook.HookInterface
    public native String getClickExt(int i);

    @Override // com.kc.openset.hook.HookInterface
    public native void init(List<SensitivityBean> list);

    @Override // com.kc.openset.hook.HookInterface
    public native void initHap();

    @Override // com.kc.openset.hook.HookInterface
    public native void initKsInit();

    @Override // com.kc.openset.hook.HookInterface
    public native void initKsLoad();

    @Override // com.kc.openset.hook.HookInterface
    public native void initLogoInfo(List<LogoInfoBean> list);

    @Override // com.kc.openset.hook.HookInterface
    public native void initTaKu(double d, int i);
}
