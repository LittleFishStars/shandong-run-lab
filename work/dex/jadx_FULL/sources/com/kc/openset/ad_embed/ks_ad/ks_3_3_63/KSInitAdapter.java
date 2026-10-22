package com.kc.openset.ad_embed.ks_ad.ks_3_3_63;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.kc.openset.advertisers.bash.BaseInit;
import com.kwad.sdk.api.KsInitCallback;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class KSInitAdapter extends BaseInit {
    private static final String TAG = OSETSDKProtected.getString2(766);

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.ks_ad.ks_3_3_63.KSInitAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements KsInitCallback {
        final KSInitAdapter this$0;

        static {
            OSETSDKProtected.interface11(3967);
        }

        public AnonymousClass1(KSInitAdapter kSInitAdapter) {
            this.this$0 = kSInitAdapter;
        }

        @Override // com.kwad.sdk.api.KsInitCallback
        public native void onFail(int i, String str);

        @Override // com.kwad.sdk.api.KsInitCallback
        public native void onSuccess();
    }

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.ks_ad.ks_3_3_63.KSInitAdapter$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements KsInitCallback {
        final KSInitAdapter this$0;

        static {
            OSETSDKProtected.interface11(3968);
        }

        public AnonymousClass2(KSInitAdapter kSInitAdapter) {
            this.this$0 = kSInitAdapter;
        }

        @Override // com.kwad.sdk.api.KsInitCallback
        public native void onFail(int i, String str);

        @Override // com.kwad.sdk.api.KsInitCallback
        public native void onSuccess();
    }

    static {
        OSETSDKProtected.interface11(3969);
    }

    public static native /* synthetic */ void access$000(KSInitAdapter kSInitAdapter, String str);

    public static native /* synthetic */ void access$100(KSInitAdapter kSInitAdapter, String str);

    public static native /* synthetic */ void access$200(KSInitAdapter kSInitAdapter, String str);

    public static native /* synthetic */ void access$300(KSInitAdapter kSInitAdapter, String str);

    public static native String getBidFailExtraInfo(AdExposureFailedReason adExposureFailedReason, int i);

    public static native String getBidSuccessExtraInfo(int i, int i2);

    public static native AdExposureFailedReason getBiddingFailReason(WinAdData winAdData);

    private native KsInitCallback getInitCallBack();

    public static native String getS2SRequestToken(KsScene ksScene);

    private native KsInitCallback getStartCallBack();

    @Override // com.kc.openset.advertisers.bash.BaseInit
    public native String getCurrentVersion();

    @Override // com.kc.openset.advertisers.bash.BaseInit
    public native void init(String str, String str2);

    @Override // com.kc.openset.advertisers.bash.BaseInit
    public native void start(String str, String str2);
}
