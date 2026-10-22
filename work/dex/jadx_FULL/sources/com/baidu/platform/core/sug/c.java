package com.baidu.platform.core.sug;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.amap.api.maps.AMap;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.base.LanguageType;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.bykv.vk.component.ttvideo.player.MediaFormat;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class c extends com.baidu.platform.base.c {
    public c(SuggestionSearchOption suggestionSearchOption) {
        a(suggestionSearchOption);
    }

    private void a(SuggestionSearchOption suggestionSearchOption) {
        this.c.a("query", suggestionSearchOption.mKeyword);
        this.c.a("region", suggestionSearchOption.mCity);
        LatLng latLng = suggestionSearchOption.mLocation;
        if (latLng != null) {
            LatLng latLng2 = new LatLng(latLng.latitude, latLng.longitude);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng2 = CoordTrans.gcjToBaidu(latLng2);
            }
            this.c.a(RequestParameters.SUBRESOURCE_LOCATION, latLng2.latitude + "," + latLng2.longitude);
        }
        if (suggestionSearchOption.mCityLimit.booleanValue()) {
            this.c.a("city_limit", "true");
        } else {
            this.c.a("city_limit", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        }
        if (suggestionSearchOption.mLanguageType == LanguageType.LanguageTypeEnglish) {
            this.c.a(MediaFormat.KEY_LANGUAGE, AMap.ENGLISH);
        }
        if (suggestionSearchOption.mHotWord) {
            this.c.a("hotword", "true");
        } else {
            this.c.a("hotword", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        }
        this.c.a("from", "android_map_sdk");
        this.c.a(com.alibaba.ariver.remotedebug.b.c.g, "json");
        this.c.a("extensions_adcode", suggestionSearchOption.isExtendAdcode() ? "true" : AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.l();
    }
}
