package com.kc.openset.ad;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.camera.video.AudioStats;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.config.AdType;
import com.kc.openset.ad.config.AdapterType;
import com.kc.openset.ad.config.DataType;
import com.kc.openset.ad.listener.AdLoadCacheListener;
import com.kc.openset.ad.listener.BaseAdLoadListener;
import com.kc.openset.bean.OSETLogUploadBean;
import com.kc.openset.util.h;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public abstract class BaseAdCache {
    private static final long CLICK_TIME_INTERVAL = 500;
    public static final int DEFAULT_CACHE_NUMBER = 5;
    private static final int DEFAULT_GROUP_TIME_OUT = 6000;
    private static final int DEFAULT_RECORD_LOW_PRICE = -1000;
    private static final int DEFAULT_TOTAL_TIME_OUT = 60000;
    public static final double NORMAL_MAX_PRICE = -9999.0d;
    private static final String TAG = OSETSDKProtected.getString2(com.google.common.math.c.f6376a);
    private static final int TYPE_GROUP_TIME_OUT = 100;
    private static final int TYPE_TOTAL_TIME_OUT = 101;
    private static WeakReference<Context> mContext;
    private static WeakReference<Activity> mLoadActivity;
    private Queue<com.kc.openset.ad.c> adSortInfoBeans;
    private DataType dataType;
    protected BaseAdLoadListener mBaseAdLoadListener;
    private com.kc.openset.ad.d optimizationCacheData;
    private long startTime;
    String mPosId = "";
    AdSize adSize = null;
    private boolean isPreLoad = false;
    private final List<com.kc.openset.ad.d> mBiddingList = new ArrayList();
    private final List<com.kc.openset.ad.d> mDataList = new ArrayList();
    private boolean afterLoadingShow = false;
    private int currentBiddingBestPrice = -1000;
    private int mCurrentNumberOfSingleTask = 0;
    private final h mCacheSortList = new h();
    private int mCacheSortNumber = 5;
    private int groupTimeOut = 6000;
    private int totalTimeOut = 60000;
    private ArrayList<com.kc.openset.ad.e> currentLoadGroup = new ArrayList<>();
    private final com.kc.openset.ad.a adFactory = new com.kc.openset.ad.a();
    private final AtomicInteger mAtoTaskCompletedNumber = new AtomicInteger(0);
    private final AtomicBoolean mAtoHasSuccessData = new AtomicBoolean(false);
    private boolean isStarted = false;
    private long lastShowTime = 0;
    private boolean isOptimization = false;
    private boolean isLoadSuccess = false;
    private double mMaxPrice = -9999.0d;
    private double mSubsidyRatio = AudioStats.AUDIO_AMPLITUDE_NONE;
    private String mMaxNetwork = "";
    private final Handler timeOutHandler = new a(this, Looper.getMainLooper());
    private boolean isLoad = false;
    final AdLoadCacheListener adS2SLoadListener = new c(this);
    final AdLoadCacheListener adLoadListener = new d(this);

    @Keep
    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final BaseAdCache f39607a;

        static {
            OSETSDKProtected.interface11(3707);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BaseAdCache baseAdCache, Looper looper) {
            super(looper);
            this.f39607a = baseAdCache;
        }

        @Override // android.os.Handler
        public native void handleMessage(Message message);
    }

    @Keep
    public class b implements OSETHttpUtils.ICallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final BaseAdCache f39608a;

        static {
            OSETSDKProtected.interface11(3708);
        }

        public b(BaseAdCache baseAdCache) {
            this.f39608a = baseAdCache;
        }

        @Override // com.kc.openset.ad.OSETHttpUtils.ICallBack
        public native void onLoadFail(String str, String str2);

        @Override // com.kc.openset.ad.OSETHttpUtils.ICallBack
        public native void onSuccess(com.kc.openset.ad.b bVar);
    }

    @Keep
    public class c implements AdLoadCacheListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final BaseAdCache f39609a;

        static {
            OSETSDKProtected.interface11(3709);
        }

        public c(BaseAdCache baseAdCache) {
            this.f39609a = baseAdCache;
        }

        @Override // com.kc.openset.ad.listener.AdLoadCacheListener
        public native void onFail(String str, String str2);

        @Override // com.kc.openset.ad.listener.AdLoadCacheListener
        public native void onFail(String str, String str2, com.kc.openset.ad.d dVar);

        @Override // com.kc.openset.ad.listener.AdLoadCacheListener
        public native void onSuccess(com.kc.openset.ad.d dVar);

        @Override // com.kc.openset.ad.listener.AdLoadCacheListener
        public native void onTimeOut(com.kc.openset.ad.d dVar);
    }

    @Keep
    public class d implements AdLoadCacheListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final BaseAdCache f39610a;

        static {
            OSETSDKProtected.interface11(3710);
        }

        public d(BaseAdCache baseAdCache) {
            this.f39610a = baseAdCache;
        }

        @Override // com.kc.openset.ad.listener.AdLoadCacheListener
        public native void onFail(String str, String str2);

        @Override // com.kc.openset.ad.listener.AdLoadCacheListener
        public native void onFail(String str, String str2, com.kc.openset.ad.d dVar);

        @Override // com.kc.openset.ad.listener.AdLoadCacheListener
        public native void onSuccess(com.kc.openset.ad.d dVar);

        @Override // com.kc.openset.ad.listener.AdLoadCacheListener
        public native void onTimeOut(com.kc.openset.ad.d dVar);
    }

    @Keep
    public static /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final int[] f39611a;

        static {
            OSETSDKProtected.interface11(3711);
            int[] iArr = new int[DataType.values().length];
            f39611a = iArr;
            try {
                iArr[DataType.BIDDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f39611a[DataType.FP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f39611a[DataType.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        OSETSDKProtected.interface11(3712);
    }

    public static native /* synthetic */ ArrayList access$000(BaseAdCache baseAdCache);

    public static native /* synthetic */ void access$100(BaseAdCache baseAdCache, com.kc.openset.ad.e eVar, String str, String str2, OSETLogUploadBean.ResultType resultType, String str3);

    public static native /* synthetic */ AtomicInteger access$1000(BaseAdCache baseAdCache);

    public static native /* synthetic */ int access$1100(BaseAdCache baseAdCache);

    public static native /* synthetic */ void access$1200(BaseAdCache baseAdCache, String str, String str2, String str3, OSETLogUploadBean.ResultType resultType, String str4);

    public static native /* synthetic */ DataType access$1300(BaseAdCache baseAdCache);

    public static native /* synthetic */ void access$1400(BaseAdCache baseAdCache);

    public static native /* synthetic */ void access$1500(BaseAdCache baseAdCache);

    public static native /* synthetic */ AtomicBoolean access$1600(BaseAdCache baseAdCache);

    public static native /* synthetic */ void access$1700(BaseAdCache baseAdCache, com.kc.openset.ad.d dVar);

    public static native /* synthetic */ void access$1800(BaseAdCache baseAdCache, com.kc.openset.ad.d dVar);

    public static native /* synthetic */ void access$200(BaseAdCache baseAdCache);

    public static native /* synthetic */ Handler access$300(BaseAdCache baseAdCache);

    public static native /* synthetic */ Queue access$400(BaseAdCache baseAdCache);

    public static native /* synthetic */ Queue access$402(BaseAdCache baseAdCache, Queue queue);

    public static native /* synthetic */ int access$500(BaseAdCache baseAdCache);

    public static native /* synthetic */ int access$502(BaseAdCache baseAdCache, int i);

    public static native /* synthetic */ int access$600(BaseAdCache baseAdCache);

    public static native /* synthetic */ int access$602(BaseAdCache baseAdCache, int i);

    public static native /* synthetic */ int access$700(BaseAdCache baseAdCache);

    public static native /* synthetic */ int access$702(BaseAdCache baseAdCache, int i);

    public static native /* synthetic */ h access$800(BaseAdCache baseAdCache);

    public static native /* synthetic */ void access$900(BaseAdCache baseAdCache, com.kc.openset.ad.c cVar);

    private native void biddingAdFail();

    private native void biddingAdSuccess(com.kc.openset.ad.d dVar);

    private native void dealWithBiddingData();

    private native Context getContext();

    private native Activity getLoadActivity();

    private native void groupLoadComplete();

    private native boolean isCanShow();

    private native void load();

    private native void loadAd(com.kc.openset.ad.c cVar);

    private native boolean loadCheck(BaseAdLoadListener baseAdLoadListener);

    private native void loadS2SAd(com.kc.openset.ad.c cVar, com.kc.openset.ad.e eVar);

    private native void loadSuccess();

    private native void loadSuccessCallback(com.kc.openset.ad.d dVar, double d2);

    private native void loadTimeOut();

    private native void markImpUser();

    private native void markRequestUser();

    private native void normalAdFail();

    private native void normalAdSuccess(com.kc.openset.ad.d dVar);

    private native void removeList(String str, String str2, String str3, OSETLogUploadBean.ResultType resultType, String str4);

    private native void requestResultLogUpLoad(com.kc.openset.ad.e eVar, String str, String str2, OSETLogUploadBean.ResultType resultType, String str3);

    private native void startGetDevicesInfo();

    private native void toBiddingWithNormal();

    private native void toGetAd();

    public native void bindOtherData(com.kc.openset.ad.e eVar);

    public abstract void callBackLoadSuccess(com.kc.openset.ad.d dVar, com.kc.openset.ad.d dVar2);

    public native void callSuccessListener(double d2, String str, double d3);

    public native AdSize getAdSize();

    public abstract AdType getAdType();

    public abstract AdapterType getAdapterType();

    public native String getS2SInfo();

    public native String getTag();

    public native void loadAd(BaseAdLoadListener baseAdLoadListener);

    public native void loadFailForClient(String str, String str2);

    public native void loadS2SAd(String str, BaseAdLoadListener baseAdLoadListener);

    public native BaseAdCache setActivity(Activity activity);

    public native void setAdSize(AdSize adSize);

    public native void setInitContext(Context context);

    public native void setOptimization(boolean z);

    public native BaseAdCache setPosId(String str);

    public native BaseAdCache setPreLoad(boolean z);

    public native BaseAdCache setUserId(String str);

    public native void startLoad();
}
