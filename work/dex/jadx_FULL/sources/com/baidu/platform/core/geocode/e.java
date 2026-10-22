package com.baidu.platform.core.geocode;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.amap.api.maps.AMap;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.base.LanguageType;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.bykv.vk.component.ttvideo.player.MediaFormat;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class e extends com.baidu.platform.base.c {
    public e(ReverseGeoCodeOption reverseGeoCodeOption) {
        a(reverseGeoCodeOption);
    }

    private void a(ReverseGeoCodeOption reverseGeoCodeOption) {
        if (reverseGeoCodeOption.getLocation() != null) {
            LatLng latLng = new LatLng(reverseGeoCodeOption.getLocation().latitude, reverseGeoCodeOption.getLocation().longitude);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng = CoordTrans.gcjToBaidu(latLng);
            }
            this.c.a(RequestParameters.SUBRESOURCE_LOCATION, latLng.latitude + "," + latLng.longitude);
        }
        if (reverseGeoCodeOption.getLanguage() == LanguageType.LanguageTypeEnglish) {
            this.c.a(MediaFormat.KEY_LANGUAGE, AMap.ENGLISH);
        } else {
            this.c.a(MediaFormat.KEY_LANGUAGE, "zh-CN");
        }
        this.c.a("coordtype", "bd09ll");
        this.c.a("page_index", String.valueOf(reverseGeoCodeOption.getPageNum()));
        this.c.a("page_size", String.valueOf(reverseGeoCodeOption.getPageSize()));
        this.c.a("pois", "1");
        this.c.a("extensions_poi", "1");
        this.c.a("extensions_town", "true");
        if (reverseGeoCodeOption.getExtensionsRoad()) {
            this.c.a("extensions_road", "true");
        } else {
            this.c.a("extensions_road", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        }
        String poiType = reverseGeoCodeOption.getPoiType();
        if (!TextUtils.isEmpty(poiType)) {
            this.c.a("poi_types", poiType);
        }
        this.c.a(com.alibaba.ariver.remotedebug.b.c.g, "jsonaes");
        this.c.a("from", "android_map_sdk");
        this.c.a("latest_admin", String.valueOf(reverseGeoCodeOption.getLatestAdmin()));
        this.c.a("radius", String.valueOf(reverseGeoCodeOption.getRadius()));
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.s();
    }
}
