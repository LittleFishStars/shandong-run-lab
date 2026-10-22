package com.kc.openset.hook;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.util.ErrorManager;
import com.kc.openset.util.LogUtils;
import com.kc.openset.util.TrackUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class HookManager {
    private static final String TAG = OSETSDKProtected.getString2(1747);
    private static volatile HookManager instance;
    private HookInterface hookInterface;

    static {
        OSETSDKProtected.interface11(4442);
    }

    private HookManager() {
        try {
            Object objNewInstance = Class.forName(OSETSDKProtected.getString2("1748")).newInstance();
            if (objNewInstance instanceof HookInterface) {
                this.hookInterface = (HookInterface) objNewInstance;
            }
        } catch (Exception e) {
            String trackStr = TrackUtils.getTrackStr(e);
            ErrorManager.requestErrorMessage(ErrorManager.SS_ERROR_CODE_PINE_INIT_ERROR, trackStr);
            LogUtils.writeE(OSETSDKProtected.getString2(1747), OSETSDKProtected.getString2(1749) + trackStr);
        }
    }

    private native boolean checkPass();

    public static native HookManager getInstance();

    public native void clearKsInterstitialView();

    public native void clearKsRewardSecondDialogView();

    public native String getClickExt(int i);

    public native void init(List<SensitivityBean> list);

    public native void initHap();

    public native void initKsInit();

    public native void initKsLoad();

    public native void initLogo(List<LogoInfoBean> list);

    public native void initTaKu(double d, int i);
}
