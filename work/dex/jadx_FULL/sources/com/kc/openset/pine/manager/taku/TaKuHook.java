package com.kc.openset.pine.manager.taku;

import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATBaseAdInternalAdapter;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.BaseAd;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.pine.Pine;
import com.kc.openset.pine.callback.MethodHook;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class TaKuHook {
    private static final String TAG = OSETSDKProtected.getString2(2221);
    private static final Map<String, List<TaKuNetworkBean>> sCacheMap;
    private static final Map<String, TaKuMaxAdInfo> sMaxPricMap;
    private static final ScheduledExecutorService sSingleThreadExecutor;
    private static double sSubsidyRatio;
    private static final Map<String, ATAdInfo> sTakuATAdInfoHashMap;
    private static int sTimeOut;
    private static final Map<String, Future<?>> sTimeoutTaskMap;

    /* JADX INFO: renamed from: com.kc.openset.pine.manager.taku.TaKuHook$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 extends MethodHook {
        static {
            OSETSDKProtected.interface11(4618);
        }

        public static native /* synthetic */ void lambda$beforeCall$0(String str);

        public static native /* synthetic */ void lambda$beforeCall$1(Object obj, String[] strArr, Pine.CallFrame callFrame, OSETATBiddingListener oSETATBiddingListener);

        @Override // com.kc.openset.pine.callback.MethodHook
        public native void afterCall(Pine.CallFrame callFrame) throws Throwable;

        @Override // com.kc.openset.pine.callback.MethodHook
        public native void beforeCall(Pine.CallFrame callFrame) throws Throwable;
    }

    @Keep
    public static class OSETATBiddingListener implements ATBiddingListener {
        private final ATBiddingListener atBiddingListener;

        static {
            OSETSDKProtected.interface11(4621);
        }

        public OSETATBiddingListener(ATBiddingListener aTBiddingListener) {
            this.atBiddingListener = aTBiddingListener;
        }

        public native ATBiddingListener getTakuATBiddingListener();

        /* JADX INFO: renamed from: lambda$onC2SBidResult$0$com-kc-openset-pine-manager-taku-TaKuHook$OSETATBiddingListener, reason: not valid java name */
        public native /* synthetic */ void m1036x546d1cf0(ATBiddingResult aTBiddingResult);

        /* JADX INFO: renamed from: lambda$onC2SBiddingResultWithCache$1$com-kc-openset-pine-manager-taku-TaKuHook$OSETATBiddingListener, reason: not valid java name */
        public native /* synthetic */ void m1037xc4f32f0b(ATBiddingResult aTBiddingResult, BaseAd baseAd);

        public native void onC2SBidResult(ATBiddingResult aTBiddingResult);

        public native void onC2SBiddingResultWithCache(ATBiddingResult aTBiddingResult, BaseAd baseAd);
    }

    static {
        OSETSDKProtected.interface11(4622);
        sSingleThreadExecutor = Executors.newSingleThreadScheduledExecutor();
        sCacheMap = new HashMap();
        sMaxPricMap = new HashMap();
        sTimeOut = 4000;
        sTakuATAdInfoHashMap = new ConcurrentHashMap();
        sTimeoutTaskMap = new HashMap();
    }

    public static native /* synthetic */ ScheduledExecutorService access$000();

    public static native /* synthetic */ Map access$100();

    public static native /* synthetic */ Map access$200();

    public static native /* synthetic */ int access$300();

    public static native /* synthetic */ void access$400(String str);

    public static native /* synthetic */ void access$500(ATBiddingResult aTBiddingResult, BaseAd baseAd, TaKuNetworkBean.MethodType methodType, OSETATBiddingListener oSETATBiddingListener, ATBiddingListener aTBiddingListener);

    private static native void callOriginalMethod(TaKuNetworkBean.MethodType methodType, ATBiddingListener aTBiddingListener, ATBiddingResult aTBiddingResult, BaseAd baseAd, OSETATBiddingListener oSETATBiddingListener, String str, ATBaseAdInternalAdapter aTBaseAdInternalAdapter);

    private static native void changePrice(String str, OSETATBiddingListener oSETATBiddingListener);

    private static native void dealATBiddingResult(ATBiddingResult aTBiddingResult, BaseAd baseAd, TaKuNetworkBean.MethodType methodType, OSETATBiddingListener oSETATBiddingListener, ATBiddingListener aTBiddingListener);

    private static native TaKuNetworkBean getTaKuNetworkBean(OSETATBiddingListener oSETATBiddingListener);

    public static native void init(double d, int i);

    public static native /* synthetic */ boolean lambda$callOriginalMethod$0(OSETATBiddingListener oSETATBiddingListener, TaKuNetworkBean taKuNetworkBean);

    private static native void notificationPrice(double d, TaKuMaxAdInfo taKuMaxAdInfo, ATBaseAdInternalAdapter aTBaseAdInternalAdapter);

    private static native void removeTaKuNetworkBean(OSETATBiddingListener oSETATBiddingListener);

    private static native void timeout(String str);
}
