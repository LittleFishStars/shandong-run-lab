package com.baidu.platform.core.building;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.building.BuildingSearchOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class c extends com.baidu.platform.base.c {
    public c(BuildingSearchOption buildingSearchOption) {
        a(buildingSearchOption);
    }

    private void a(BuildingSearchOption buildingSearchOption) {
        if (buildingSearchOption == null) {
            return;
        }
        LatLng latLng = buildingSearchOption.getLatLng();
        if (latLng != null) {
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng = CoordTrans.gcjToBaidu(latLng);
            }
            this.c.a("latitude", latLng.latitude + "");
            this.c.a("longitude", latLng.longitude + "");
        }
        this.c.a("coord_type", "bd09ll");
        this.c.a("from", "android_map_sdk");
        this.c.a(com.alibaba.ariver.remotedebug.b.c.g, "json");
        this.c.a("data_set", "building");
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.e();
    }
}
