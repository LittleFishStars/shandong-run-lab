package com.baidu.platform.core.route;

import com.amap.api.maps.AMap;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.route.IndoorRoutePlanOption;
import com.baidu.platform.comapi.basestruct.GeoPoint;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class f extends com.baidu.platform.base.c {
    public f(IndoorRoutePlanOption indoorRoutePlanOption) {
        a(indoorRoutePlanOption);
    }

    private void a(IndoorRoutePlanOption indoorRoutePlanOption) {
        this.c.a("qt", "indoornavi");
        this.c.a("rp_format", "json");
        this.c.a("version", "1");
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(indoorRoutePlanOption.mFrom.getLocation());
        if (geoPointLl2mc != null) {
            this.c.a("sn", (String.format("%f,%f", Double.valueOf(geoPointLl2mc.getLongitudeE6()), Double.valueOf(geoPointLl2mc.getLatitudeE6())) + "|" + indoorRoutePlanOption.mFrom.getFloor()).replaceAll(" ", ""));
        }
        GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(indoorRoutePlanOption.mTo.getLocation());
        if (geoPointLl2mc2 != null) {
            this.c.a(AMap.ENGLISH, (String.format("%f,%f", Double.valueOf(geoPointLl2mc2.getLongitudeE6()), Double.valueOf(geoPointLl2mc2.getLatitudeE6())) + "|" + indoorRoutePlanOption.mTo.getFloor()).replaceAll(" ", ""));
        }
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.q();
    }
}
