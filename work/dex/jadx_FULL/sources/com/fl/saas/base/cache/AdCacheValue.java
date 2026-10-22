package com.fl.saas.base.cache;

import com.fl.saas.base.base.AdapterAPI;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class AdCacheValue {
    private final AdapterAPI adapter;
    private final long cacheTime;
    private final String placeId;
    private final int price;

    public AdCacheValue(long j, String str, int i, AdapterAPI adapterAPI) {
        this.cacheTime = j;
        this.placeId = str;
        this.price = i;
        this.adapter = adapterAPI;
    }

    public AdapterAPI getAdapter() {
        return this.adapter;
    }

    public long getCacheTime() {
        return this.cacheTime;
    }

    public String getPlaceId() {
        return this.placeId;
    }

    public int getPrice() {
        return this.price;
    }
}
