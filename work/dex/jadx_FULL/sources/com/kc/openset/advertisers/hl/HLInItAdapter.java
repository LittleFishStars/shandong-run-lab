package com.kc.openset.advertisers.hl;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.advertisers.bash.BaseInit;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class HLInItAdapter extends BaseInit {
    private static final String TAG = OSETSDKProtected.getString2(1052);

    static {
        OSETSDKProtected.interface11(4266);
    }

    public static native String getBidFailExtraInfo(int i, String str, String str2);

    public static native String getBidSuccessExtraInfo(int i);

    public static native String getErrorCode(String str);

    public static native String getS2SRequestToken(String str, int i);

    @Override // com.kc.openset.advertisers.bash.BaseInit
    public native String getCurrentVersion();

    @Override // com.kc.openset.advertisers.bash.BaseInit
    public native void init(String str, String str2);

    /* JADX INFO: renamed from: lambda$start$0$com-kc-openset-advertisers-hl-HLInItAdapter, reason: not valid java name */
    public native /* synthetic */ void m1025lambda$start$0$comkcopensetadvertisershlHLInItAdapter();

    @Override // com.kc.openset.advertisers.bash.BaseInit
    public native void start(String str, String str2);
}
