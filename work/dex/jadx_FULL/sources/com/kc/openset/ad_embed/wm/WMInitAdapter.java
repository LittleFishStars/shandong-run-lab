package com.kc.openset.ad_embed.wm;

import android.content.Context;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.bw.appsdkdex.WMAdSdk;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.kc.openset.advertisers.bash.BaseInit;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class WMInitAdapter extends BaseInit {
    private static final String TAG = OSETSDKProtected.getString2(884);
    private Context mContext;

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.wm.WMInitAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements WMAdSdk.IInitCallback {
        final WMInitAdapter this$0;

        static {
            OSETSDKProtected.interface11(4185);
        }

        public AnonymousClass1(WMInitAdapter wMInitAdapter) {
            this.this$0 = wMInitAdapter;
        }

        @Override // com.kc.bw.appsdkdex.WMAdSdk.IInitCallback
        public native void onFail(String str);

        @Override // com.kc.bw.appsdkdex.WMAdSdk.IInitCallback
        public native void onSuccess();
    }

    static {
        OSETSDKProtected.interface11(4186);
    }

    public static native /* synthetic */ void access$000(WMInitAdapter wMInitAdapter, String str);

    public static native /* synthetic */ void access$100(WMInitAdapter wMInitAdapter, String str);

    public static native String getBidFailExtraInfo(WinAdData winAdData);

    public static native String getBidSuccessExtraInfo(int i, double d);

    @Override // com.kc.openset.advertisers.bash.BaseInit
    public native String getCurrentVersion();

    @Override // com.kc.openset.advertisers.bash.BaseInit
    public native void init(String str, String str2);

    @Override // com.kc.openset.advertisers.bash.BaseInit
    public native void start(String str, String str2);
}
