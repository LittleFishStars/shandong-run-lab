package com.baidu.platform.core.recommendstop;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.recommendstop.RecommendStopSearchOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class c extends com.baidu.platform.base.c {
    public c(RecommendStopSearchOption recommendStopSearchOption) {
        a(recommendStopSearchOption);
    }

    private void a(RecommendStopSearchOption recommendStopSearchOption) {
        if (recommendStopSearchOption != null && recommendStopSearchOption.mLocation != null) {
            LatLng latLng = new LatLng(recommendStopSearchOption.getLocation().latitude, recommendStopSearchOption.getLocation().longitude);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng = CoordTrans.gcjToBaidu(latLng);
            }
            this.c.a(RequestParameters.SUBRESOURCE_LOCATION, latLng.longitude + "," + latLng.latitude);
            this.c.a("station_info", recommendStopSearchOption.isNeedStationInfo() ? "1" : "0");
        }
        this.c.a("coordtype", "bd09ll");
        this.c.a("from", "android_map_sdk");
        this.c.a(com.alibaba.ariver.remotedebug.b.c.g, "json");
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.d();
    }
}
