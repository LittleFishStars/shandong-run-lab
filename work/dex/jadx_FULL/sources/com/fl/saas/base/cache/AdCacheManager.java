package com.fl.saas.base.cache;

import android.content.Context;
import android.text.TextUtils;
import com.fl.saas.api.AdParams;
import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.base.base.BaseBuilder;
import com.fl.saas.base.bidding.BiddingResult;
import com.fl.saas.base.cache.AdCacheManager;
import com.fl.saas.base.cache.AdCacheValue;
import com.fl.saas.base.interfaces.PreloadDoneCallback;
import com.fl.saas.base.manager.MixNativeManager;
import com.fl.saas.base.manager.api.ManagerAPI;
import com.fl.saas.base.rest.ConfigHelper;
import com.fl.saas.base.type.AdType;
import com.fl.saas.common.saas.bean.AdPlace;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.saas.bean.PreAdPlace;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class AdCacheManager {
    private static final String TAG = "YdSDK-Cache";
    private static volatile AdCacheManager instance;
    private int advId;
    private List<String> globalCachePosition;
    private AdapterAPI interstitialAdapter;
    private int price;
    private int secondPrice;
    private final Map<Integer, AdPlace> adPlaces = new ConcurrentHashMap();
    private final Map<Integer, List<AdCacheValue>> adCache = new ConcurrentHashMap();
    private final Map<Integer, List<AdCacheValue>> adPlaceCache = new ConcurrentHashMap();

    public enum CacheType {
        PLACE_CACHE,
        SHARE_CACHE
    }

    private AdCacheManager() {
    }

    private void clearInvalid(List<AdCacheValue> list, long j) {
        if (list != null) {
            Iterator<AdCacheValue> it = list.iterator();
            while (it.hasNext()) {
                AdCacheValue next = it.next();
                if (next == null || next.getCacheTime() < 0 || DeviceUtil.getBootTime() < next.getCacheTime() || DeviceUtil.getBootTime() - next.getCacheTime() > j) {
                    it.remove();
                    if (next != null && next.getAdapter() != null) {
                        next.getAdapter().clearCache();
                        next.getAdapter().destroy();
                    }
                }
            }
        }
    }

    private int getAdvId(AdCacheValue adCacheValue) {
        AdapterAPI adapter;
        if (adCacheValue == null || (adapter = adCacheValue.getAdapter()) == null) {
            return 0;
        }
        return adapter.getAdSource().getAdv_id();
    }

    public static AdCacheManager getInstance() {
        if (instance == null) {
            synchronized (AdCacheManager.class) {
                if (instance == null) {
                    instance = new AdCacheManager();
                }
            }
        }
        return instance;
    }

    private int getPrice(AdCacheValue adCacheValue) {
        if (adCacheValue != null) {
            return adCacheValue.getPrice();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$addCacheAd$0(AdCacheValue adCacheValue, AdCacheValue adCacheValue2) {
        return Integer.compare(adCacheValue2.getPrice(), adCacheValue.getPrice());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$addPlaceCacheAd$1(AdCacheValue adCacheValue, AdCacheValue adCacheValue2) {
        return Integer.compare(adCacheValue2.getPrice(), adCacheValue.getPrice());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$loadCacheAd$2() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$loadCacheAd$3() {
    }

    public void addAdPlace(List<PreAdPlace> list) {
        if (list != null) {
            for (PreAdPlace preAdPlace : list) {
                this.adPlaces.put(Integer.valueOf(preAdPlace.getPosition()), preAdPlace.getAdPlace());
            }
        }
        LogcatUtil.d(TAG, "addAdPlace" + list);
    }

    public void addCacheAd(int i, String str, long j, List<AdapterAPI> list) {
        AdapterAPI adapter;
        LogcatUtil.d(TAG, "addCacheAd:" + i + "  placeId:" + str);
        if (list == null || TextUtils.isEmpty(str)) {
            return;
        }
        List<AdCacheValue> vector = this.adCache.get(Integer.valueOf(i));
        if (vector == null) {
            vector = new Vector<>();
        }
        clearInvalid(vector, j);
        for (AdapterAPI adapterAPI : list) {
            if (adapterAPI != null && adapterAPI.getAdSource().getAdvPrice() > 0) {
                adapterAPI.setCache();
                adapterAPI.getAdSource().isCacheAd = true;
                vector.add(new AdCacheValue(adapterAPI.getAdSource().getCatchTime(), str, adapterAPI.getAdSource().getAdvPrice(), adapterAPI));
            }
        }
        Collections.sort(vector, new Comparator() { // from class: com.zj.adlib.mu
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AdCacheManager.lambda$addCacheAd$0((AdCacheValue) obj, (AdCacheValue) obj2);
            }
        });
        int maxCacheCount = getMaxCacheCount(i);
        if (vector.size() > maxCacheCount) {
            for (int i2 = maxCacheCount; i2 < vector.size(); i2++) {
                AdCacheValue adCacheValue = vector.get(i2);
                if (adCacheValue != null && (adapter = adCacheValue.getAdapter()) != null) {
                    AdSource adSource = adapter.getAdSource();
                    if ((adapter instanceof BiddingResult) && (adSource.isC2SBidAd || adSource.isApiBidAd)) {
                        ((BiddingResult) adapter).biddingResult(false, getPrice(vector.get(0)), getPrice(vector.get(1)), getAdvId(vector.get(1)));
                    }
                }
            }
            vector.subList(maxCacheCount, vector.size()).clear();
        }
        this.adCache.put(Integer.valueOf(i), vector);
    }

    public void addPlaceCacheAd(int i, String str, long j, List<AdapterAPI> list) {
        AdapterAPI adapter;
        LogcatUtil.d(TAG, "addPlaceCacheAd:" + i + "  placeId:" + str);
        if (list == null || TextUtils.isEmpty(str)) {
            return;
        }
        List<AdCacheValue> vector = this.adPlaceCache.get(Integer.valueOf(i));
        if (vector == null) {
            vector = new Vector<>();
        }
        clearInvalid(vector, j);
        for (AdapterAPI adapterAPI : list) {
            if (adapterAPI != null && adapterAPI.getAdSource().getAdvPrice() > 0) {
                adapterAPI.setCache();
                adapterAPI.getAdSource().isCacheAd = true;
                vector.add(new AdCacheValue(adapterAPI.getAdSource().getCatchTime(), str, adapterAPI.getAdSource().getAdvPrice(), adapterAPI));
            }
        }
        Collections.sort(vector, new Comparator() { // from class: com.zj.adlib.nu
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AdCacheManager.lambda$addPlaceCacheAd$1((AdCacheValue) obj, (AdCacheValue) obj2);
            }
        });
        int maxCacheCount = getMaxCacheCount(i);
        if (vector.size() > maxCacheCount) {
            for (int i2 = maxCacheCount; i2 < vector.size(); i2++) {
                AdCacheValue adCacheValue = vector.get(i2);
                if (adCacheValue != null && (adapter = adCacheValue.getAdapter()) != null) {
                    AdSource adSource = adapter.getAdSource();
                    if ((adapter instanceof BiddingResult) && (adSource.isC2SBidAd || adSource.isApiBidAd)) {
                        ((BiddingResult) adapter).biddingResult(false, getPrice(vector.get(0)), getPrice(vector.get(1)), getAdvId(vector.get(1)));
                    }
                }
            }
            vector.subList(maxCacheCount, vector.size()).clear();
        }
        this.adPlaceCache.put(Integer.valueOf(i), vector);
    }

    public void clearInterstitialAdapter(boolean z) {
        AdapterAPI adapterAPI = this.interstitialAdapter;
        if (adapterAPI != null) {
            if (z) {
                if (adapterAPI instanceof BiddingResult) {
                    ((BiddingResult) adapterAPI).biddingResult(false, this.price, this.secondPrice, this.advId);
                }
                this.interstitialAdapter.destroy();
            }
            this.interstitialAdapter = null;
        }
    }

    public AdapterAPI getCacheAd(int i, long j) {
        LogcatUtil.d(TAG, "getCacheAd:" + i);
        List<AdCacheValue> list = this.adCache.get(Integer.valueOf(i));
        clearInvalid(list, j);
        if (list != null && !list.isEmpty()) {
            AdCacheValue adCacheValue = null;
            for (AdCacheValue adCacheValue2 : list) {
                if (adCacheValue2 != null && (adCacheValue == null || adCacheValue2.getPrice() > adCacheValue2.getPrice())) {
                    adCacheValue = adCacheValue2;
                }
            }
            if (adCacheValue != null) {
                list.remove(adCacheValue);
                return adCacheValue.getAdapter();
            }
        }
        return null;
    }

    public AdapterAPI getInterstitialAdapter() {
        return this.interstitialAdapter;
    }

    public int getMaxCacheCount(int i) {
        AdPlace adPlace;
        if (!this.adPlaces.containsKey(Integer.valueOf(i)) || (adPlace = this.adPlaces.get(Integer.valueOf(i))) == null) {
            return 1;
        }
        return adPlace.cache_queue_length;
    }

    public AdapterAPI getPlaceCacheAd(int i, String str, long j) {
        LogcatUtil.d(TAG, "getPlaceCacheAd:" + i + "  placeId:" + str);
        List<AdCacheValue> list = this.adPlaceCache.get(Integer.valueOf(i));
        clearInvalid(list, j);
        if (list != null && !list.isEmpty()) {
            AdCacheValue adCacheValue = null;
            for (AdCacheValue adCacheValue2 : list) {
                if (adCacheValue2 != null && adCacheValue2.getPlaceId().equals(str) && (adCacheValue == null || adCacheValue2.getPrice() > adCacheValue2.getPrice())) {
                    adCacheValue = adCacheValue2;
                }
            }
            if (adCacheValue != null) {
                list.remove(adCacheValue);
                return adCacheValue.getAdapter();
            }
        }
        return null;
    }

    public boolean isGlobalCache(int i) {
        List<String> list = this.globalCachePosition;
        if (list != null) {
            return list.contains(String.valueOf(i));
        }
        return false;
    }

    public boolean isHasPublicCache(int i) {
        return this.adPlaces.get(Integer.valueOf(i)) != null;
    }

    public void loadCacheAd(int i) {
        BaseBuilder<?> baseBuilderCreateDefaultBuilder;
        LogcatUtil.d(TAG, "loadCacheAd:" + i);
        Context context = PreloadHelper.getInstance().getContext();
        AdPlace adPlace = this.adPlaces.get(Integer.valueOf(i));
        if (adPlace == null || context == null) {
            return;
        }
        if (i == 10) {
            String str = adPlace.place_id;
            String reqID = DeviceUtil.getReqID(str);
            AdPlace adPlaceCloneObject = adPlace.cloneObject(reqID);
            ConfigHelper.getInstance().sdkTrafficReq(reqID, str, adPlace.group_id, adPlace.test_id, adPlaceCloneObject.track_id, true, 0L);
            new MixNativeManager(context, new AdParams.Builder(adPlace.place_id).build(), null).preload(adPlaceCloneObject, new PreloadDoneCallback() { // from class: com.zj.adlib.ku
                @Override // com.fl.saas.base.interfaces.PreloadDoneCallback
                public final void preloadDone() {
                    AdCacheManager.lambda$loadCacheAd$2();
                }
            });
            return;
        }
        AdType adTypeFromPosition = AdType.fromPosition(i);
        if (adTypeFromPosition != null) {
            String str2 = adPlace.place_id;
            String reqID2 = DeviceUtil.getReqID(str2);
            AdPlace adPlaceCloneObject2 = adPlace.cloneObject(reqID2);
            ConfigHelper.getInstance().sdkTrafficReq(reqID2, str2, adPlace.group_id, adPlace.test_id, adPlaceCloneObject2.track_id, true, 0L);
            ManagerAPI managerAPI = (ManagerAPI) adTypeFromPosition.createManager();
            if (managerAPI == null || (baseBuilderCreateDefaultBuilder = adTypeFromPosition.createDefaultBuilder(context)) == null) {
                return;
            }
            managerAPI.preload(baseBuilderCreateDefaultBuilder, adPlaceCloneObject2, new PreloadDoneCallback() { // from class: com.zj.adlib.lu
                @Override // com.fl.saas.base.interfaces.PreloadDoneCallback
                public final void preloadDone() {
                    AdCacheManager.lambda$loadCacheAd$3();
                }
            });
        }
    }

    public void setGlobalCachePosition(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        this.globalCachePosition = Arrays.asList(strArr);
    }

    public void setInterstitialAdapter(AdapterAPI adapterAPI, int i, int i2, int i3) {
        this.interstitialAdapter = adapterAPI;
        this.price = i;
        this.secondPrice = i2;
        this.advId = i3;
    }
}
