package com.kc.openset.util.s;

import android.content.Context;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.plugin.BaseDpOpt;
import com.kc.openset.plugin.DpOptResultListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class OSETUtilImp extends BaseDpOpt {
    static {
        OSETSDKProtected.interface11(5036);
    }

    @Override // com.kc.openset.plugin.BaseDpOpt
    public native String getDpOptSdkVersion();

    @Override // com.kc.openset.plugin.BaseDpOpt
    public native void openDeeplink(Context context, String str, String str2, DpOptResultListener dpOptResultListener);

    @Override // com.kc.openset.plugin.BaseDpOpt
    public native void s1(Context context, String str, String str2, int i);

    @Override // com.kc.openset.plugin.BaseDpOpt
    public native boolean s2(Context context, String str, String str2);
}
