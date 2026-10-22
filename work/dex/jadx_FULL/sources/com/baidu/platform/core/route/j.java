package com.baidu.platform.core.route;

import android.text.TextUtils;
import com.amap.api.maps.AMap;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.base.LanguageType;
import com.baidu.mapapi.search.route.MassTransitRoutePlanOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.bykv.vk.component.ttvideo.player.MediaFormat;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class j extends com.baidu.platform.base.c {
    public j(MassTransitRoutePlanOption massTransitRoutePlanOption) {
        a(massTransitRoutePlanOption);
    }

    private void a(MassTransitRoutePlanOption massTransitRoutePlanOption) {
        LatLng location = massTransitRoutePlanOption.mFrom.getLocation();
        if (location != null) {
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                location = CoordTrans.gcjToBaidu(location);
            }
            this.c.a("origin", location.latitude + "," + location.longitude);
        } else {
            this.c.a("origin", massTransitRoutePlanOption.mFrom.getName());
        }
        if (massTransitRoutePlanOption.mFrom.getCity() != null) {
            this.c.a("origin_region", massTransitRoutePlanOption.mFrom.getCity());
        }
        if (!TextUtils.isEmpty(massTransitRoutePlanOption.mFrom.getPoiId())) {
            this.c.a("origin_uid", massTransitRoutePlanOption.mFrom.getPoiId());
        }
        LatLng location2 = massTransitRoutePlanOption.mTo.getLocation();
        if (location2 != null) {
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                location2 = CoordTrans.gcjToBaidu(location2);
            }
            this.c.a("destination", location2.latitude + "," + location2.longitude);
        } else {
            this.c.a("destination", massTransitRoutePlanOption.mTo.getName());
        }
        if (massTransitRoutePlanOption.mTo.getCity() != null) {
            this.c.a("destination_region", massTransitRoutePlanOption.mTo.getCity());
        }
        if (!TextUtils.isEmpty(massTransitRoutePlanOption.mTo.getPoiId())) {
            this.c.a("destination_uid", massTransitRoutePlanOption.mTo.getPoiId());
        }
        this.c.a("tactics_incity", massTransitRoutePlanOption.mTacticsIncity.getInt() + "");
        this.c.a("tactics_intercity", massTransitRoutePlanOption.mTacticsIntercity.getInt() + "");
        this.c.a("trans_type_intercity", massTransitRoutePlanOption.mTransTypeIntercity.getInt() + "");
        this.c.a("page_index", massTransitRoutePlanOption.mPageIndex + "");
        this.c.a("page_size", massTransitRoutePlanOption.mPageSize + "");
        this.c.a("coord_type", massTransitRoutePlanOption.mCoordType);
        this.c.a(com.alibaba.ariver.remotedebug.b.c.g, "json");
        this.c.a("from", "android_map_sdk");
        this.c.a("sub_version", "151100");
        if (massTransitRoutePlanOption.mLanguageType == LanguageType.LanguageTypeEnglish) {
            this.c.a(MediaFormat.KEY_LANGUAGE, AMap.ENGLISH);
        }
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.n();
    }
}
