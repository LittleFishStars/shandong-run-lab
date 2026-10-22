package com.fl.saas.base.manager.loader;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.base.bidding.BiddingRequest;
import com.fl.saas.base.cache.AdCacheManager;
import com.fl.saas.base.cache.PreloadHelper;
import com.fl.saas.base.interfaces.AdMaterialJson;
import com.fl.saas.base.interfaces.PreloadDoneCallback;
import com.fl.saas.base.manager.api.AdapterGenerator;
import com.fl.saas.base.manager.api.LoadAPI;
import com.fl.saas.base.manager.api.ManagerInfoAPI;
import com.fl.saas.base.manager.api.ManagerLoader;
import com.fl.saas.base.manager.loader.AdViewManager;
import com.fl.saas.base.manager.loader.BaseLoader;
import com.fl.saas.base.rest.ConfigHelper;
import com.fl.saas.base.rest.ReportHelper;
import com.fl.saas.base.type.AdType;
import com.fl.saas.base.widget.AdInfo;
import com.fl.saas.common.listener.ApiSaaSListener;
import com.fl.saas.common.saas.bean.AdPlace;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.common.util.feature.Optional;
import com.fl.saas.common.util.feature.Supplier;
import com.fl.saas.config.exception.ErrorCodeConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class BaseLoader<T extends AdapterAPI> implements LoadAPI, ManagerInfoAPI, AdapterGenerator {
    private String key;
    private AdPlace mAdPlace;
    private int mAdType;

    @NonNull
    protected ManagerLoader<T> mLoader;

    @NonNull
    public final AdViewManager manager;
    private long trafficStartTime;
    private boolean isTrafficTimeReported = false;
    private boolean isHot = false;

    /* JADX INFO: renamed from: com.fl.saas.base.manager.loader.BaseLoader$1, reason: invalid class name */
    public class AnonymousClass1 implements ApiSaaSListener {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onSuccess$0(Context context) {
            PreloadHelper.getInstance().setPreLoadContext(context);
        }

        @Override // com.fl.saas.common.listener.ApiSaaSListener
        public void onFailed(String str) {
            BaseLoader.this.onLoadFailed(new YdError(ErrorCodeConstant.CONFIG_ERROR, str));
            LogcatUtil.d("YdSDK", "requestConfig, error: " + str);
        }

        @Override // com.fl.saas.common.listener.ApiSaaSListener
        public void onSuccess(AdPlace adPlace) {
            BaseLoader.this.mAdPlace = adPlace;
            BaseLoader.this.mAdPlace.isHot = BaseLoader.this.isHot;
            if (adPlace.isBidding()) {
                BaseLoader.this.manager.hasSdkBid();
                BaseLoader.this.reqSdkBidAd(adPlace);
            }
            BaseLoader.this.manager.requestSdkAd(adPlace);
            try {
                BaseLoader.this.mLoader.getContextOpt().ifPresent(new Consumer() { // from class: com.fl.saas.base.manager.loader.a
                    @Override // com.fl.saas.common.util.feature.Consumer
                    public final void accept(Object obj) {
                        BaseLoader.AnonymousClass1.lambda$onSuccess$0((Context) obj);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: com.fl.saas.base.manager.loader.BaseLoader$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$fl$saas$base$cache$AdCacheManager$CacheType;

        static {
            int[] iArr = new int[AdCacheManager.CacheType.values().length];
            $SwitchMap$com$fl$saas$base$cache$AdCacheManager$CacheType = iArr;
            try {
                iArr[AdCacheManager.CacheType.PLACE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$fl$saas$base$cache$AdCacheManager$CacheType[AdCacheManager.CacheType.SHARE_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public BaseLoader(@NonNull ManagerLoader<T> managerLoader, int i) {
        this.mLoader = managerLoader;
        this.mAdType = i;
        this.manager = new AdViewManager(this, i);
    }

    private Optional<AdSource> getValidAdSource() {
        return getValidAdapter().map(new Function() { // from class: com.zj.adlib.go0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return ((AdapterAPI) obj).getAdSource();
            }
        });
    }

    private AdapterAPI handleAdapterConfig(final AdapterAPI adapterAPI) {
        return (AdapterAPI) this.mLoader.getContextOpt().map(new Function() { // from class: com.zj.adlib.io0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return this.f17246a.lambda$handleAdapterConfig$2(adapterAPI, (Context) obj);
            }
        }).orElse(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AdInfo lambda$getAdInfo$5(AdSource adSource) {
        return AdInfo.create(adSource.mAdv_id, adSource.mTagid, adSource.test_id, adSource.is_contrast);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ AdapterAPI lambda$getValidAdapter$4(AdViewManager adViewManager) {
        try {
            return this.manager.getValidAdapter();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ AdapterAPI lambda$handleAdapterConfig$2(AdapterAPI adapterAPI, Context context) {
        try {
            return this.mLoader.bindAdapter(adapterAPI).setContext(context).setAdAdapter(this.manager);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadAdapter$0(AdapterAPI adapterAPI) {
        try {
            AdapterAPI adapterAPIHandleAdapterConfig = handleAdapterConfig(adapterAPI);
            if (adapterAPIHandleAdapterConfig != null) {
                adapterAPIHandleAdapterConfig.load();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ AdapterAPI lambda$popCacheAdapter$3(AdCacheManager.CacheType cacheType, String str, long j, Context context) {
        AdapterAPI placeCacheAd;
        int i = AnonymousClass3.$SwitchMap$com$fl$saas$base$cache$AdCacheManager$CacheType[cacheType.ordinal()];
        if (i != 1) {
            placeCacheAd = i != 2 ? null : AdCacheManager.getInstance().getCacheAd(this.mAdType, j);
        } else {
            placeCacheAd = AdCacheManager.getInstance().getPlaceCacheAd(this.mAdType, str, j);
        }
        if (placeCacheAd != null) {
            placeCacheAd = handleAdapterConfig(placeCacheAd);
            AdSource adSource = placeCacheAd.getAdSource();
            if (adSource != null) {
                adSource.isPopCacheAd = true;
                int i2 = adSource.price;
                if (i2 > 0) {
                    adSource.bidfloor = i2;
                }
            }
            placeCacheAd.clearCache();
        }
        return placeCacheAd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reqSdkBidAd$1(final AdPlace adPlace, Context context) {
        new BiddingRequest(this.key, context, new BiddingRequest.BiddingLoadEvent() { // from class: com.fl.saas.base.manager.loader.BaseLoader.2
            @Override // com.fl.saas.base.bidding.BiddingRequest.BiddingLoadEvent
            public void onFailed(YdError ydError) {
                BaseLoader.this.manager.onSDKBidFailed(ydError);
            }

            @Override // com.fl.saas.base.bidding.BiddingRequest.BiddingLoadEvent
            public void onStart() {
                BaseLoader.this.manager.sendMessageDelayed(6, adPlace.api_timeout);
            }

            @Override // com.fl.saas.base.bidding.BiddingRequest.BiddingLoadEvent
            public void onSucc(@NonNull AdSource adSource, Object obj) {
                BaseLoader.this.handleSDKBidAd(adSource, obj);
            }
        }).reqSdkBidAd(AdType.getType(getClass()), adPlace);
    }

    public void biddingResultUpload(boolean z, int i, int i2) {
        this.manager.biddingResultUpload(z, i, i2);
    }

    @Override // com.fl.saas.base.manager.api.ManagerInfoAPI
    public void destroy() {
        this.manager.destroy();
    }

    @Override // com.fl.saas.base.manager.api.ManagerInfoAPI
    public AdInfo getAdInfo() {
        return (AdInfo) getValidAdSource().map(new Function() { // from class: com.zj.adlib.so0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return BaseLoader.lambda$getAdInfo$5((AdSource) obj);
            }
        }).orElseGet(new Supplier() { // from class: com.zj.adlib.to0
            @Override // com.fl.saas.common.util.feature.Supplier
            public final Object get() {
                return AdInfo.createEmpty();
            }
        });
    }

    public AdPlace getAdPlace() {
        return this.mAdPlace;
    }

    @Override // com.fl.saas.base.manager.api.ManagerInfoAPI
    public int getEcpm() {
        AdPlace adPlace = this.mAdPlace;
        if (adPlace == null || adPlace.fill_price != 0) {
            return ((Integer) getValidAdSource().map(new Function() { // from class: com.zj.adlib.ko0
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return Integer.valueOf(((AdSource) obj).getAdvPrice());
                }
            }).orElse(0)).intValue();
        }
        return -1;
    }

    public String getMaterialJson() {
        AdapterAPI validAdapterOrNull = getValidAdapterOrNull();
        return validAdapterOrNull instanceof AdMaterialJson ? ((AdMaterialJson) validAdapterOrNull).getMaterialJson() : "";
    }

    public String getReqId() {
        return (String) getValidAdSource().map(new Function() { // from class: com.zj.adlib.oo0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return ((AdSource) obj).req_id;
            }
        }).orElse("");
    }

    public AdapterAPI getShowAdapter() {
        return this.manager.getValidAdapter();
    }

    public Optional<T> getValidAdapter() {
        return Optional.ofNullable(this.manager).map(new Function() { // from class: com.zj.adlib.mo0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return this.f43346a.lambda$getValidAdapter$4((AdViewManager) obj);
            }
        });
    }

    @NonNull
    public T getValidAdapterOrNull() {
        return getValidAdapter().orElse(null);
    }

    public abstract void handleSDKBidAd(@NonNull AdSource adSource, Object obj);

    @Override // com.fl.saas.base.manager.api.FailedLoader
    public boolean isFailedCallBack() {
        return this.mLoader.isFailedCallBack();
    }

    public void loadAdapter(final AdapterAPI adapterAPI) {
        DeviceUtil.postUI(new Runnable() { // from class: com.zj.adlib.eo0
            @Override // java.lang.Runnable
            public final void run() {
                this.f16364a.lambda$loadAdapter$0(adapterAPI);
            }
        });
    }

    public void loadConfig(String str) {
        this.trafficStartTime = System.currentTimeMillis();
        ConfigHelper.getInstance().requestConfig(this.isHot, this.mAdType, str, new AnonymousClass1(), this.trafficStartTime);
    }

    @Override // com.fl.saas.base.manager.api.FailedLoader
    public void onAdFailed(YdError ydError) {
        this.mLoader.onAdFailed(ydError);
    }

    @Override // com.fl.saas.base.interfaces.AdLoadEvent
    public void onLoadFailed(YdError ydError) {
        this.mLoader.onLoadFailed(ydError);
    }

    @Override // com.fl.saas.base.manager.api.AdapterGenerator
    @Nullable
    public AdapterAPI popCacheAdapter(final AdCacheManager.CacheType cacheType, final String str, final long j) {
        try {
            return (AdapterAPI) this.mLoader.getContextOpt().map(new Function() { // from class: com.zj.adlib.ro0
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f19388a.lambda$popCacheAdapter$3(cacheType, str, j, (Context) obj);
                }
            }).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.fl.saas.base.manager.api.LoadAPI
    public void preload(AdPlace adPlace, PreloadDoneCallback preloadDoneCallback) {
        if (adPlace == null || preloadDoneCallback == null) {
            return;
        }
        this.trafficStartTime = System.currentTimeMillis();
        if (adPlace.isBidding()) {
            this.manager.hasSdkBid();
            reqSdkBidAd(adPlace);
        }
        this.manager.preloadSdkAd(adPlace, preloadDoneCallback);
    }

    @Override // com.fl.saas.base.manager.api.AdapterGenerator
    public void pushCacheAdapter(AdCacheManager.CacheType cacheType, String str, long j, List<AdapterAPI> list) {
        try {
            int i = AnonymousClass3.$SwitchMap$com$fl$saas$base$cache$AdCacheManager$CacheType[cacheType.ordinal()];
            if (i == 1) {
                AdCacheManager.getInstance().addPlaceCacheAd(this.mAdType, str, j, list);
            } else if (i == 2) {
                AdCacheManager.getInstance().addCacheAd(this.mAdType, str, j, list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.fl.saas.base.manager.api.AdapterGenerator
    public void reportFullAd(AdSource adSource) {
        if (this.isTrafficTimeReported) {
            return;
        }
        ReportHelper.getInstance().reportFullAd(adSource, System.currentTimeMillis() - this.trafficStartTime);
        this.isTrafficTimeReported = true;
    }

    @Override // com.fl.saas.base.manager.api.AdapterGenerator
    public void reqSdkBidAd(final AdPlace adPlace) {
        this.mLoader.getContextOpt().ifPresent(new Consumer() { // from class: com.zj.adlib.qo0
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                this.f44253a.lambda$reqSdkBidAd$1(adPlace, (Context) obj);
            }
        });
    }

    @Override // com.fl.saas.base.manager.api.LoadAPI
    public void request(String str) {
        this.key = str;
        this.manager.setKey(str);
        LogcatUtil.d("YdSDK-API", "URL: http://ads.adfunlink.com:8080/server/newConfig");
        LogcatUtil.d("YdSDK-API", "请求的: appId:" + DeviceUtil.appId + "   posId:" + str);
        loadConfig(str);
    }

    public void selectBottomAd() {
        this.manager.selectBottomAdapter();
    }

    public void setHot(boolean z) {
        this.isHot = z;
    }
}
