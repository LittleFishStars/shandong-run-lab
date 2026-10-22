package com.baidu.platform.core.route;

import com.amap.api.maps.AMap;
import com.baidu.mapapi.search.route.TransitRoutePlanOption;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class n extends com.baidu.platform.base.c {
    public n(TransitRoutePlanOption transitRoutePlanOption) {
        a(transitRoutePlanOption);
    }

    private void a(TransitRoutePlanOption transitRoutePlanOption) {
        this.c.a("qt", "bus");
        this.c.a("sy", transitRoutePlanOption.mPolicy.getInt() + "");
        this.c.a("ie", "utf-8");
        this.c.a("lrn", "20");
        this.c.a("version", "3");
        this.c.a("rp_format", "json");
        this.c.a("rp_filter", "mobile");
        this.c.a("ic_info", "2");
        this.c.a("exptype", "depall");
        this.c.a("sn", a(transitRoutePlanOption.mFrom));
        this.c.a(AMap.ENGLISH, a(transitRoutePlanOption.mTo));
        String str = transitRoutePlanOption.mCityName;
        if (str != null) {
            this.c.a("c", str);
        }
        if (TransitRoutePlanOption.TransitPolicy.EBUS_NO_SUBWAY == transitRoutePlanOption.mPolicy) {
            this.c.a("f", "[0,2,4,7,5,8,9,10,11]");
        }
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.w();
    }
}
