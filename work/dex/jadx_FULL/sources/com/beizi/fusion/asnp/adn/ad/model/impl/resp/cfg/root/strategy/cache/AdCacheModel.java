package com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.strategy.cache;

import androidx.annotation.Nullable;
import com.aliyun.credentials.utils.AuthConstant;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.kg;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AdCacheModel extends ASNPJsonResponseModel {
    public static final int CACHE_DISABLE = 0;
    public static final int CACHE_ENABLE = 1;

    @kg(key = "advanceTime")
    private long advanceTime;

    @kg(key = "batchFetchCount")
    private int batchFetchCount;

    @kg(key = "cacheMaxQty")
    private int cacheMaxQty;

    @kg(key = "cacheRefreshInterval")
    private long cacheRefreshInterval;

    @kg(key = AuthConstant.INI_ENABLE)
    private int enable;

    @kg(key = HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME)
    private long localWaitTime;

    @kg(key = "priorityMode")
    private int priorityMode;

    public AdCacheModel(JSONObject jSONObject) {
        super(jSONObject);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && hashCode() == ((AdCacheModel) obj).hashCode();
    }

    public long getAdvanceTime() {
        return this.advanceTime;
    }

    public int getBatchFetchCount() {
        return this.batchFetchCount;
    }

    public int getCacheMaxQty() {
        return this.cacheMaxQty;
    }

    public long getCacheRefreshInterval() {
        return this.cacheRefreshInterval;
    }

    public int getEnable() {
        return this.enable;
    }

    public long getLocalWaitTime() {
        return this.localWaitTime;
    }

    public int getPriorityMode() {
        return this.priorityMode;
    }

    public int hashCode() {
        JSONObject jSONObject = this.mJsonObject;
        if (jSONObject == null) {
            return 0;
        }
        return jSONObject.toString().hashCode();
    }
}
