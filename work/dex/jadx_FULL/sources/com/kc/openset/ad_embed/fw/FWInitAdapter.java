package com.kc.openset.ad_embed.fw;

import android.content.Context;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.model.AdBidLossReason;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.kc.openset.advertisers.bash.BaseInit;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class FWInitAdapter extends BaseInit {
    private static final String TAG = OSETSDKProtected.getString2(582);
    private Context mContext;

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.fw.FWInitAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements PtgAdSdk.Callback {
        final FWInitAdapter this$0;

        static {
            OSETSDKProtected.interface11(3909);
        }

        public AnonymousClass1(FWInitAdapter fWInitAdapter) {
            this.this$0 = fWInitAdapter;
        }

        @Override // com.kc.aw.lib.PtgAdSdk.Callback
        public native void fail(int i, String str);

        @Override // com.kc.aw.lib.PtgAdSdk.Callback
        public native void success();
    }

    static {
        OSETSDKProtected.interface11(3910);
    }

    public static native /* synthetic */ void access$000(FWInitAdapter fWInitAdapter, String str);

    public static native /* synthetic */ void access$100(FWInitAdapter fWInitAdapter, String str);

    public static native String getBidFailExtraInfo(AdBidLossReason adBidLossReason);

    public static native String[] getBidFailReason(boolean z, WinAdData winAdData);

    public static native String getBidSuccessExtraInfo(int i, double d);

    @Override // com.kc.openset.advertisers.bash.BaseInit
    public native String getCurrentVersion();

    @Override // com.kc.openset.advertisers.bash.BaseInit
    public native void init(String str, String str2);

    @Override // com.kc.openset.advertisers.bash.BaseInit
    public native void start(String str, String str2);
}
