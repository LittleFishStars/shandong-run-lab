package com.baidu.platform.core.geocode;

import com.baidu.mapapi.search.geocode.GeoCodeOption;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class c extends com.baidu.platform.base.c {
    public c(GeoCodeOption geoCodeOption) {
        a(geoCodeOption);
    }

    private void a(GeoCodeOption geoCodeOption) {
        this.c.a("city", geoCodeOption.mCity);
        this.c.a("address", geoCodeOption.mAddress);
        this.c.a(com.alibaba.ariver.remotedebug.b.c.g, "json");
        this.c.a("ret_coordtype", "bd09ll");
        this.c.a("from", "android_map_sdk");
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.m();
    }
}
