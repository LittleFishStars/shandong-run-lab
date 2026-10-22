package com.kc.openset.plugin.opt;

import android.content.Context;
import com.hzchengdun.securityguard.SecExceptionCode;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.plugin.BaseDpOpt;
import com.kc.openset.plugin.DpOptResultListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class DpOptImp extends BaseDpOpt {
    private static final String TAG = OSETSDKProtected.getString2(SecExceptionCode.SEC_ERROR_UNIFIED_SECURITY_GET_UMT_FAILED);

    static {
        OSETSDKProtected.interface11(4685);
    }

    private native void performStrongJump(Context context, String str, String str2, DpOptResultListener dpOptResultListener);

    @Override // com.kc.openset.plugin.BaseDpOpt
    public native String getDpOptSdkVersion();

    @Override // com.kc.openset.plugin.BaseDpOpt
    public native void openDeeplink(Context context, String str, String str2, DpOptResultListener dpOptResultListener);
}
