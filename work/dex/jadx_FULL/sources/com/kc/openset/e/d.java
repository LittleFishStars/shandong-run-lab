package com.kc.openset.e;

import android.app.Activity;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.util.notch.INotchScreen;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class d implements INotchScreen {
    static {
        OSETSDKProtected.interface11(4423);
    }

    private static native String a();

    @Override // com.kc.openset.util.notch.INotchScreen
    public native void getNotchRect(Activity activity, INotchScreen.NotchSizeCallback notchSizeCallback);

    @Override // com.kc.openset.util.notch.INotchScreen
    public native boolean hasNotch(Activity activity);

    @Override // com.kc.openset.util.notch.INotchScreen
    @Deprecated
    public native void setDisplayInNotch(Activity activity);
}
