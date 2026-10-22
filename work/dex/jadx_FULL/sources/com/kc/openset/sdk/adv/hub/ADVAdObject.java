package com.kc.openset.sdk.adv.hub;

import android.content.Context;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.DummyBtnConfig;
import com.kc.openset.ad.config.AdType;
import com.kc.openset.sdk.adv.ADVRequestUtils;
import com.kc.openset.sdk.adv.listener.ADVBaseListener;
import com.kc.openset.sdk.apiad.ad_view.OSETAPIBaseAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public abstract class ADVAdObject {
    protected static final String TAG = OSETSDKProtected.getString2(2680);
    protected ADVBaseListener adListener;
    protected final AdType adType;
    protected com.kc.openset.sdk.adv.a advBean;
    protected com.kc.openset.sdk.apiad.tools.c apiAdData;
    protected WeakReference<OSETAPIBaseAd> baseAd;
    protected WeakReference<Context> context;
    protected DummyBtnConfig dummyBtnConfig;
    protected final String mPosId;
    protected final String mRequestId;
    private long startCacheTime;
    private int[] tiltSensorSen = {0, 0};
    protected String s2sToken = "";
    private boolean isClickCallback = true;
    private final ADVRequestUtils.AdvCallback advCallback = new a(this);
    private ADVRequestUtils advRequestUtils = new ADVRequestUtils();

    @Keep
    public class a implements ADVRequestUtils.AdvCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ADVAdObject f39845a;

        static {
            OSETSDKProtected.interface11(4739);
        }

        public a(ADVAdObject aDVAdObject) {
            this.f39845a = aDVAdObject;
        }

        @Override // com.kc.openset.sdk.adv.ADVRequestUtils.AdvCallback
        public native void onFail(int i, String str);

        @Override // com.kc.openset.sdk.adv.ADVRequestUtils.AdvCallback
        public native void onSuccess(com.kc.openset.sdk.adv.a aVar);
    }

    static {
        OSETSDKProtected.interface11(4740);
    }

    public ADVAdObject(Context context, String str, String str2, AdType adType) {
        this.context = new WeakReference<>(context);
        this.mRequestId = str;
        this.mPosId = str2;
        this.adType = adType;
    }

    public static native /* synthetic */ long access$002(ADVAdObject aDVAdObject, long j);

    public native void bidFail(int i, boolean z, boolean z2, String str);

    public native void bidSuccess(int i);

    public native void destroy();

    public native String getAPIPlat();

    public native com.kc.openset.sdk.adv.a getAdvBean();

    public native com.kc.openset.sdk.apiad.tools.c getApiAdData();

    public native Context getContext();

    public native DummyBtnConfig getDummyBtnConfig();

    public native int getEcpm();

    public native String getParentAdId();

    public native String getParentAdKey();

    public native int[] getTiltSensorSen();

    public abstract ADVBaseListener initADVListener(ADVBaseListener aDVBaseListener);

    public native boolean isClickCallback();

    public native boolean isUsable();

    public native void onAdLoadSuccess();

    public native void onPaused();

    public native void onResumed();

    public native void reportAdEvent(com.kc.openset.sdk.adv.report.b bVar);

    public native void setChangePrice(boolean z);

    public native void setClickCallback(boolean z);

    public native void setCommissionPrice(double d);

    public native void setDiscount(double d);

    public native void setDummyBtnConfig(DummyBtnConfig dummyBtnConfig);

    public native void setReplaceMaxNetwork(String str);

    public native void setReplaceMaxPrice(double d);

    public native void setReplacePrice(double d);

    public native void setS2SToken(String str);

    public native void setSubsidyRatio(double d);

    public native void setTiltSensorSen(int[] iArr);

    public native void setUpr(int i);

    public native void toLoad(ADVBaseListener aDVBaseListener);
}
