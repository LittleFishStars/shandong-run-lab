package com.kc.openset.ad.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import androidx.camera.video.AudioStats;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huachenjie.base.interact.bean.WorksInteractEventBean;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.DummyBtnConfig;
import com.kc.openset.ad.NativeViewConfig;
import com.kc.openset.ad.base.bridge.AdBridge;
import com.kc.openset.ad.base.bridge.BridgeInterface;
import com.kc.openset.ad.bid.BidAdInfo;
import com.kc.openset.ad.config.AdType;
import com.kc.openset.ad.listener.AdLoadCacheListener;
import com.kc.openset.ad.listener.OSETBaseListener;
import com.kc.openset.bean.InitConfigBean;
import com.kc.openset.bean.OSETLogUploadBean;
import com.kc.openset.bean.Orientation;
import com.kc.openset.hook.AdSensorConfigBean;
import com.kc.openset.sdk.adv.OSETQDNativeViewAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public abstract class BaseAdLoad implements AdCoreAction, AdSensorConfigBean.OnFlowFinishedListener {
    private static final int BANNER_IMG_RADIUS = 20;
    private static final int BID_AD_EXCEPTION_DEFAULT_PRICE = -1;
    private static final int BID_AD_IS_NULL_DEFAULT_PRICE = -1000;
    private static final int BID_AD_LOAD_FAIL_DEFAULT_PRICE = -1001;
    private static final int DEFAULT_AD_CACHE_TIME = 3000000;
    private static final int DEFAULT_REQUEST_TIMEOUT = 5000;
    private static final int FLOW_FINISH_DELAY_TIME = 0;
    private static final int HANDLER_WHAT_SHOW_TIME_RECORD = 101;
    private static final int LOAD_WAIT_TIME = 100;
    private static final int TWO_KS_LOAD_DELAY_TIME = 50;
    protected SSActivityLifecycleCallbacks activityLifeCycle;
    private WeakReference<Activity> activityWeakReference;
    private AdBridge adBridge;
    protected AdLoadCacheListener adLoadCacheListener;
    private WeakReference<Context> contextWeakReference;
    private String localClassName;
    private BidAdInfo mBidAdInfo;
    protected boolean mIsTriggered;
    private String mReplaceMaxNetwork;
    private double mReplaceMaxPrice;
    private String mUserId;
    private int showActivityHashCode;
    private String showLocalClassName;
    com.kc.openset.ad.e sortBean;
    private long startCacheTime;
    private long startTime;
    String verifyStr;
    protected static final String BIDDING_RESULT_TYPE_FAIL = OSETSDKProtected.getString2(434);
    protected static final String BIDDING_RESULT_TYPE_SUCCESS = OSETSDKProtected.getString2(WorksInteractEventBean.EVENT_TYPE_COMMENT_ALUMNI_SAY_NOTIFY_UNLIKE);
    private static final String TAG = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_AV_NO_SYNC_THRESHOLD);
    boolean timeOut = false;
    boolean isClick = false;
    private boolean loadSuccess = false;
    private int mShowTime = 0;
    private final Handler initDelayHandler = new a(this, Looper.getMainLooper());
    private boolean isPreLoad = false;
    private boolean mIsImp = false;
    private double mReplacePlace = -1.0d;
    private boolean mIsReplacePrice = false;
    private double mSubsidyRatio = AudioStats.AUDIO_AMPLITUDE_NONE;
    private String encryptionAdInfo = "";
    private String adInfo = "";
    private final List<String> deepLinkList = new ArrayList();

    @Keep
    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final BaseAdLoad f39622a;

        static {
            OSETSDKProtected.interface11(3748);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BaseAdLoad baseAdLoad, Looper looper) {
            super(looper);
            this.f39622a = baseAdLoad;
        }

        @Override // android.os.Handler
        public native void handleMessage(Message message);
    }

    @Keep
    public class b implements BridgeInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final BaseAdLoad f39623a;

        static {
            OSETSDKProtected.interface11(3749);
        }

        public b(BaseAdLoad baseAdLoad) {
            this.f39623a = baseAdLoad;
        }

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native void doAdClick(View view);

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native void doAdClose(View view);

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native void doAdDetailViewClosed();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native void doAdImp(View view);

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native void doAdLoadFailed(String str, String str2);

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native void doAdLoadSuccess();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native void doAdRenderFail(View view, String str, String str2);

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native void doAdRenderSuccess(View view);

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native void doAdReward();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native void doAdShowFail(String str, String str2);

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native void doAdSkip();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native void doAdVideoComplete(View view);

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native void doAdVideoContinuePlay(View view);

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native void doAdVideoEnd();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native void doAdVideoPause(View view);

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native void doAdVideoStart();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native void doAdVideoStart(View view);

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native void doBidFail(String str);

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native void doBidSuccess(String str);

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native Map<String, Object> getADNServicesInfo();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native Activity getActivity();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native int getAdObjIsNullBidDefaultPrice();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native double getAdWhRatio();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native int[] getAdWhSize();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native int getBannerImgRadius();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native double getCommissionPrice();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native Context getContext();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native int getDefaultCacheTime();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native int getDefaultLoadTimeout();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native double getDiscount();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native DummyBtnConfig getDummyBtnConfig();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native String getErrorTypeLoad();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native String getErrorTypeOther();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native String getErrorTypePlay();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native int getExceptionBidDefaultPrice();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native String getMediaUid();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native Orientation getOrientation();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native String getPosId();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native int getPrice();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native String getReplaceMaxNetwork();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native double getReplaceMaxPrice();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native double getReplacePrice();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native String getRequestId();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native String getSsAdId();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native long getStartCacheTime();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native double getSubsidyRatio();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native int[] getTiltSensorSen();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native String getToken();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native int getUpr();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native String getUserId();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native boolean isChangePrice();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native boolean isClickCallback();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native boolean isFilter();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native boolean isLoadSuccess();

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native void requestErrorLogUpLoad(String str, String str2);

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native void requestErrorLogUpLoad(String str, String str2, String str3);

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native void updateParentAdKey(String str);

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native void updateSonPlat(String str);

        @Override // com.kc.openset.ad.base.bridge.BridgeInterface
        public native void viewLoadToShow(View view);
    }

    @Keep
    public class c extends SSActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final BaseAdLoad f39624a;

        static {
            OSETSDKProtected.interface11(3750);
        }

        public c(BaseAdLoad baseAdLoad) {
            this.f39624a = baseAdLoad;
        }

        @Override // com.kc.openset.ad.base.SSActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public native void onActivityDestroyed(Activity activity);

        @Override // com.kc.openset.ad.base.SSActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public native void onActivityPaused(Activity activity);

        @Override // com.kc.openset.ad.base.SSActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public native void onActivityResumed(Activity activity);
    }

    @Keep
    public class d extends SSActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final BaseAdLoad f39625a;

        static {
            OSETSDKProtected.interface11(3751);
        }

        public d(BaseAdLoad baseAdLoad) {
            this.f39625a = baseAdLoad;
        }

        @Override // com.kc.openset.ad.base.SSActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public native void onActivityDestroyed(Activity activity);

        @Override // com.kc.openset.ad.base.SSActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public native void onActivityPaused(Activity activity);

        @Override // com.kc.openset.ad.base.SSActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public native void onActivityResumed(Activity activity);
    }

    @Keep
    public static /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final int[] f39626a;

        static {
            OSETSDKProtected.interface11(3752);
            int[] iArr = new int[InitConfigBean.InitStatus.values().length];
            f39626a = iArr;
            try {
                iArr[InitConfigBean.InitStatus.INIT_STATUS_INIT_FAIL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f39626a[InitConfigBean.InitStatus.INIT_STATUS_INITIALIZING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f39626a[InitConfigBean.InitStatus.INIT_STATUS_STARTING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f39626a[InitConfigBean.InitStatus.INIT_STATUS_INIT_SUCCESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f39626a[InitConfigBean.InitStatus.INIT_STATUS_START_FAIL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f39626a[InitConfigBean.InitStatus.INIT_STATUS_START_SUCCESS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f39626a[InitConfigBean.InitStatus.INIT_STATUS_NORMAL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    static {
        OSETSDKProtected.interface11(3753);
    }

    public static native /* synthetic */ int access$002(BaseAdLoad baseAdLoad, int i);

    public static native /* synthetic */ int access$008(BaseAdLoad baseAdLoad);

    public static native /* synthetic */ Handler access$100(BaseAdLoad baseAdLoad);

    public static native /* synthetic */ AdBridge access$1000(BaseAdLoad baseAdLoad);

    public static native /* synthetic */ void access$1100(BaseAdLoad baseAdLoad);

    public static native /* synthetic */ int access$200(BaseAdLoad baseAdLoad);

    public static native /* synthetic */ boolean access$302(BaseAdLoad baseAdLoad, boolean z);

    public static native /* synthetic */ void access$400(BaseAdLoad baseAdLoad, View view);

    public static native /* synthetic */ void access$500(BaseAdLoad baseAdLoad);

    public static native /* synthetic */ void access$600(BaseAdLoad baseAdLoad, String str);

    public static native /* synthetic */ void access$700(BaseAdLoad baseAdLoad, String str);

    public static native /* synthetic */ int access$800(BaseAdLoad baseAdLoad);

    public static native /* synthetic */ String access$900(BaseAdLoad baseAdLoad);

    private native void bidFail(BidAdInfo bidAdInfo, boolean z);

    private native void bidSuccess(BidAdInfo bidAdInfo);

    private native void bindBridgeInterface();

    public static native Field findFieldRecursive(Class<?> cls, String str);

    private native Application.ActivityLifecycleCallbacks getActivityLifeCycle();

    private native String getAdFront();

    private native int getBannerImgRadius();

    private native String getEncryptionKSAdInfo();

    private native String getHLAdInfo();

    private native String getKSAdInfo();

    private native String getLastMethodName();

    private native String getNetworkS2SInfo();

    private native List<String> getPlayCardInfoList(JSONObject jSONObject);

    private native String getRawEcpm();

    private native String getS2SToken();

    private native String getTag();

    private native boolean hapCheck();

    private native boolean isCheatingFlow();

    private native boolean isFilter();

    private native boolean isLoadByActivity();

    private native void loadKsAd(InitConfigBean initConfigBean, String str);

    private native void loadSuccessNext();

    private native void onShowActivityDestroyed();

    private native void registerActivityLifeCycleOfSensor(View view);

    private native void registerActivityLifeCycleOfSensorByName(String str);

    private native void replaceLogo();

    private native boolean showByChecked(Activity activity, ViewGroup viewGroup, OSETBaseListener oSETBaseListener);

    private native void toLoadAd();

    private native void toLoadKsAd(InitConfigBean initConfigBean);

    private native void toShowAd(Activity activity, ViewHolderManager.ViewHolder viewHolder);

    private native void unRegisterActivityLifeCycleOfSensor();

    private native void updateParentAdKey(String str);

    private native void updateSonPlat(String str);

    public native void adActionLog(Class<?> cls);

    public native void bidResultTrack(String str, String str2);

    @Override // com.kc.openset.ad.base.AdCoreAction
    public native void biddingFail(BidAdInfo bidAdInfo, boolean z);

    @Override // com.kc.openset.ad.base.AdCoreAction
    public native void biddingFail(com.kc.openset.ad.d dVar, boolean z);

    @Override // com.kc.openset.ad.base.AdCoreAction
    public native void biddingSuccess(BidAdInfo bidAdInfo);

    @Override // com.kc.openset.ad.base.AdCoreAction
    public native void biddingSuccess(com.kc.openset.ad.d dVar);

    public abstract void bindListener(OSETBaseListener oSETBaseListener);

    public native void clickTrackLogUpLoad();

    public native void closeTrackLogUpLoad();

    @Override // com.kc.openset.ad.base.AdCoreAction
    public native void destroy();

    public native void destroyAd();

    public abstract void doAdClick(View view);

    public abstract void doAdClose(View view);

    public native void doAdDetailViewClosed();

    public abstract void doAdImp(View view);

    public native void doAdLoadFailed(int i);

    public native void doAdLoadFailed(int i, String str);

    public native void doAdLoadFailed(String str);

    public native void doAdLoadFailed(String str, String str2);

    public native void doAdLoadSuccess();

    public native void doAdRenderFail(View view, String str, String str2);

    public native void doAdRenderSuccess(View view);

    public native void doAdReward();

    public native void doAdShowFail(String str, String str2);

    public native void doAdSkip();

    public native void doAdVideoComplete(View view);

    public native void doAdVideoContinuePlay(View view);

    public native void doAdVideoEnd();

    public native void doAdVideoPause(View view);

    public native void doAdVideoStart();

    public native void doAdVideoStart(View view);

    public abstract void doBidFail(String str);

    public abstract void doBidSuccess(String str);

    public native Map<String, Object> getADNServicesInfo();

    public native Activity getActivity();

    public native int getAdHeight();

    public native String getAdInfo();

    public native int getAdLoadAdFailBidDefaultPrice();

    public native Object getAdObj();

    public native int getAdObjIsNullBidDefaultPrice();

    public native String getAdSpotId();

    public native String getAdTitle();

    public abstract AdType getAdType();

    public native String getAdUserName();

    public native double getAdWhRatio();

    public native int getAdWidth();

    public native String getAdvertisers();

    public native String getCategory();

    public native Context getContext();

    public native int getDefaultCacheTime();

    public native int getDefaultLoadTimeout();

    public native double getDiscount();

    public native int getDiscountPrice();

    public native DummyBtnConfig getDummyBtnConfig();

    @Override // com.kc.openset.ad.base.AdCoreAction
    public native int getEcpm();

    public native String getEncryptionAdInfo();

    public native String getErrorTypeLoad();

    public native String getErrorTypeOther();

    public native String getErrorTypePlay();

    public native int getExceptionBidDefaultPrice();

    public native String getLogTag();

    public native String getMediaUid();

    public native Orientation getOrientation();

    public native double getP();

    public native String getParentAdId();

    public native String getParentRequestId();

    public native String getPosId();

    public native int getPrice();

    public native double getQDEcpm();

    public native OSETQDNativeViewAd getQDNativeViewAd();

    public native String getRawPrice();

    public native String getReplaceMaxNetwork();

    public native double getReplaceMaxPrice();

    public native String getRequestId();

    @Override // com.kc.openset.ad.base.AdCoreAction
    public native String getS2SInfo();

    public native String getSsAdId();

    public native long getStartCacheTime();

    public native double getSubsidyRatio();

    public native int[] getTiltSensorSen();

    public native String getToken();

    public native int getUpr();

    public native double getUprDouble();

    public native String getUserId();

    public native void impTrackLogUpLoad();

    public native void init(Activity activity, Context context, com.kc.openset.ad.e eVar, AdBridge adBridge, AdLoadCacheListener adLoadCacheListener, boolean z);

    public native boolean isBidding();

    public native boolean isBindActivityLifeCycle();

    public native boolean isCallbackClick();

    public native boolean isClickCallback();

    public native boolean isDealWithByAdvertisers();

    public native boolean isImp();

    public native boolean isInitBeforeLoad();

    public native boolean isLoadSuccess();

    public native boolean isReplacePrice();

    @Override // com.kc.openset.ad.base.AdCoreAction
    public native boolean isUsable();

    /* JADX INFO: renamed from: lambda$doAdLoadFailed$5$com-kc-openset-ad-base-BaseAdLoad, reason: not valid java name */
    public native /* synthetic */ void m1009lambda$doAdLoadFailed$5$comkcopensetadbaseBaseAdLoad();

    /* JADX INFO: renamed from: lambda$doAdShowFail$6$com-kc-openset-ad-base-BaseAdLoad, reason: not valid java name */
    public native /* synthetic */ void m1010lambda$doAdShowFail$6$comkcopensetadbaseBaseAdLoad(String str, String str2);

    /* JADX INFO: renamed from: lambda$loadAd$1$com-kc-openset-ad-base-BaseAdLoad, reason: not valid java name */
    public native /* synthetic */ void m1011lambda$loadAd$1$comkcopensetadbaseBaseAdLoad();

    /* JADX INFO: renamed from: lambda$loadAd$2$com-kc-openset-ad-base-BaseAdLoad, reason: not valid java name */
    public native /* synthetic */ void m1012lambda$loadAd$2$comkcopensetadbaseBaseAdLoad();

    /* JADX INFO: renamed from: lambda$loadSuccessNext$4$com-kc-openset-ad-base-BaseAdLoad, reason: not valid java name */
    public native /* synthetic */ void m1013lambda$loadSuccessNext$4$comkcopensetadbaseBaseAdLoad(com.kc.openset.ad.d dVar);

    /* JADX INFO: renamed from: lambda$onFlowFinish$0$com-kc-openset-ad-base-BaseAdLoad, reason: not valid java name */
    public native /* synthetic */ void m1014lambda$onFlowFinish$0$comkcopensetadbaseBaseAdLoad();

    /* JADX INFO: renamed from: lambda$toLoadKsAd$3$com-kc-openset-ad-base-BaseAdLoad, reason: not valid java name */
    public native /* synthetic */ void m1015lambda$toLoadKsAd$3$comkcopensetadbaseBaseAdLoad(InitConfigBean initConfigBean, String str);

    @Override // com.kc.openset.ad.base.AdCoreAction
    public native void loadAd();

    public native void logError(String str, String str2, String str3, String str4);

    public native void markReplacePrice();

    public native void markTimeOut();

    @Override // com.kc.openset.hook.AdSensorConfigBean.OnFlowFinishedListener
    public native void onFlowFinish();

    public native void onShowActivityPaused();

    public native void onShowActivityResumed();

    public native void report(OSETLogUploadBean oSETLogUploadBean);

    public native void requestErrorLogUpLoad(String str, String str2, String str3);

    public native void requestResultLogUpLoad(OSETLogUploadBean.ResultType resultType, String str, String str2);

    public native void requestSuccessLogUpLoad();

    public native void setP(double d2);

    public native void setReplaceMaxNetwork(String str);

    public native void setReplaceMaxPrice(double d2);

    public native void setSubsidyRatio(double d2);

    public native void setUserId(String str);

    @Override // com.kc.openset.ad.base.AdCoreAction
    public native boolean showAd(Activity activity, ViewGroup viewGroup, OSETBaseListener oSETBaseListener);

    @Override // com.kc.openset.ad.base.AdCoreAction
    public native boolean showAd(Activity activity, NativeViewConfig nativeViewConfig, OSETBaseListener oSETBaseListener);

    public abstract void showFailNotifyClient(String str, String str2);

    public abstract void skipNotifyClient();

    public native void skipTrackLogUpLoad();

    public native void toShowAd(Activity activity);

    public native void toShowAd(Activity activity, ViewGroup viewGroup);

    public native void unregisterActivityLifecycle();

    public native void viewLoadToShow(View view);
}
