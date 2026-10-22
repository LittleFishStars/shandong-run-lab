package com.fl.saas.base.manager.api;

import androidx.annotation.Nullable;
import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.base.cache.AdCacheManager;
import com.fl.saas.common.saas.bean.AdPlace;
import com.fl.saas.common.saas.bean.AdSource;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface AdapterGenerator extends FailedLoader {
    @Nullable
    AdapterAPI popCacheAdapter(AdCacheManager.CacheType cacheType, String str, long j);

    void pushCacheAdapter(AdCacheManager.CacheType cacheType, String str, long j, List<AdapterAPI> list);

    void reportFullAd(AdSource adSource);

    void reqSdkBidAd(AdPlace adPlace);

    void requestAd(AdSource adSource);
}
