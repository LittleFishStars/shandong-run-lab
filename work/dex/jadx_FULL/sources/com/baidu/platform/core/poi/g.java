package com.baidu.platform.core.poi;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.amap.api.maps.AMap;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.search.base.InputLanguageType;
import com.baidu.mapapi.search.base.LanguageType;
import com.baidu.mapapi.search.poi.PoiBoundSearchOption;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiFilter;
import com.baidu.mapapi.search.poi.PoiNearbySearchOption;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.bykv.vk.component.ttvideo.player.MediaFormat;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class g extends com.baidu.platform.base.c {
    public g(PoiNearbySearchOption poiNearbySearchOption) {
        a(poiNearbySearchOption);
    }

    private void a(PoiNearbySearchOption poiNearbySearchOption) {
        PoiFilter poiFilter;
        if (poiNearbySearchOption == null) {
            return;
        }
        this.c.a("query", poiNearbySearchOption.mKeyword);
        if (poiNearbySearchOption.mLanguageType == LanguageType.LanguageTypeEnglish) {
            this.c.a(MediaFormat.KEY_LANGUAGE, AMap.ENGLISH);
        }
        InputLanguageType inputLanguageType = poiNearbySearchOption.mInputLanguageType;
        if (inputLanguageType != null) {
            this.c.a("from_language", inputLanguageType.getValue());
        }
        LatLng latLng = poiNearbySearchOption.mLocation;
        if (latLng != null) {
            LatLng latLng2 = new LatLng(latLng.latitude, latLng.longitude);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng2 = CoordTrans.gcjToBaidu(latLng2);
            }
            if (latLng2 != null) {
                this.c.a(RequestParameters.SUBRESOURCE_LOCATION, latLng2.latitude + "," + latLng2.longitude);
            }
        }
        this.c.a("photo_show", poiNearbySearchOption.isShowPhoto() ? "true" : AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        this.c.a("radius", poiNearbySearchOption.mRadius + "");
        this.c.a(com.alibaba.ariver.remotedebug.b.c.g, "json");
        this.c.a("extensions_adcode", poiNearbySearchOption.isExtendAdcode() ? "true" : AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        this.c.a("page_num", poiNearbySearchOption.mPageNum + "");
        this.c.a("page_size", poiNearbySearchOption.mPageCapacity + "");
        this.c.a("scope", poiNearbySearchOption.mScope + "");
        this.c.a("tag", poiNearbySearchOption.mTag);
        if (poiNearbySearchOption.mRadiusLimit) {
            this.c.a("radius_limit", "true");
        } else {
            this.c.a("radius_limit", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        }
        if (poiNearbySearchOption.mScope != 2 || (poiFilter = poiNearbySearchOption.mPoiFilter) == null || TextUtils.isEmpty(poiFilter.toString())) {
            return;
        }
        this.c.a("filter", poiNearbySearchOption.mPoiFilter.toString());
    }

    public g(PoiCitySearchOption poiCitySearchOption) {
        a(poiCitySearchOption);
    }

    public g(PoiBoundSearchOption poiBoundSearchOption) {
        a(poiBoundSearchOption);
    }

    private void a(PoiCitySearchOption poiCitySearchOption) {
        PoiFilter poiFilter;
        if (poiCitySearchOption == null) {
            return;
        }
        this.c.a("query", poiCitySearchOption.mKeyword);
        if (poiCitySearchOption.mLanguageType == LanguageType.LanguageTypeEnglish) {
            this.c.a(MediaFormat.KEY_LANGUAGE, AMap.ENGLISH);
        }
        InputLanguageType inputLanguageType = poiCitySearchOption.mInputLanguageType;
        if (inputLanguageType != null) {
            this.c.a("from_language", inputLanguageType.getValue());
        }
        this.c.a("photo_show", poiCitySearchOption.isShowPhoto() ? "true" : AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        this.c.a("region", poiCitySearchOption.mCity);
        this.c.a(com.alibaba.ariver.remotedebug.b.c.g, "json");
        this.c.a("extensions_adcode", poiCitySearchOption.isExtendAdcode() ? "true" : AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        this.c.a("page_num", poiCitySearchOption.mPageNum + "");
        this.c.a("page_size", poiCitySearchOption.mPageCapacity + "");
        this.c.a("scope", poiCitySearchOption.mScope + "");
        this.c.a("tag", poiCitySearchOption.mTag);
        if (poiCitySearchOption.getCenter() != null) {
            LatLng latLng = new LatLng(poiCitySearchOption.getCenter().latitude, poiCitySearchOption.getCenter().longitude);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng = CoordTrans.gcjToBaidu(latLng);
            }
            if (latLng != null) {
                this.c.a("center", latLng.latitude + "," + latLng.longitude);
            }
        }
        if (poiCitySearchOption.getViewBound() != null && poiCitySearchOption.getViewBound().southwest != null && poiCitySearchOption.getViewBound().northeast != null) {
            LatLng latLng2 = new LatLng(poiCitySearchOption.getViewBound().southwest.latitude, poiCitySearchOption.getViewBound().southwest.longitude);
            LatLng latLng3 = new LatLng(poiCitySearchOption.getViewBound().northeast.latitude, poiCitySearchOption.getViewBound().northeast.longitude);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng2 = CoordTrans.gcjToBaidu(latLng2);
                latLng3 = CoordTrans.gcjToBaidu(latLng3);
            }
            if (latLng2 != null && latLng3 != null) {
                this.c.a("view_bound", latLng2.latitude + "," + latLng2.longitude + "," + latLng3.latitude + "," + latLng3.longitude);
            }
        }
        if (poiCitySearchOption.getFilterDistance() > 0) {
            this.c.a("view_distance", poiCitySearchOption.getFilterDistance() + "");
        }
        if (poiCitySearchOption.mIsCityLimit) {
            this.c.a("city_limit", "true");
        } else {
            this.c.a("city_limit", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        }
        if (poiCitySearchOption.mScope != 2 || (poiFilter = poiCitySearchOption.mPoiFilter) == null || TextUtils.isEmpty(poiFilter.toString())) {
            return;
        }
        this.c.a("filter", poiCitySearchOption.mPoiFilter.toString());
    }

    private void a(PoiBoundSearchOption poiBoundSearchOption) {
        PoiFilter poiFilter;
        LatLng latLng;
        if (poiBoundSearchOption == null) {
            return;
        }
        this.c.a("query", poiBoundSearchOption.mKeyword);
        if (poiBoundSearchOption.mLanguageType == LanguageType.LanguageTypeEnglish) {
            this.c.a(MediaFormat.KEY_LANGUAGE, AMap.ENGLISH);
        }
        InputLanguageType inputLanguageType = poiBoundSearchOption.mInputLanguageType;
        if (inputLanguageType != null) {
            this.c.a("from_language", inputLanguageType.getValue());
        }
        this.c.a("photo_show", poiBoundSearchOption.isShowPhoto() ? "true" : AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        this.c.a("tag", poiBoundSearchOption.mTag);
        LatLngBounds latLngBounds = poiBoundSearchOption.mBound;
        if (latLngBounds != null && (latLng = latLngBounds.southwest) != null && latLngBounds.northeast != null) {
            LatLng latLng2 = new LatLng(latLng.latitude, latLng.longitude);
            LatLng latLng3 = poiBoundSearchOption.mBound.northeast;
            LatLng latLng4 = new LatLng(latLng3.latitude, latLng3.longitude);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng2 = CoordTrans.gcjToBaidu(latLng2);
                latLng4 = CoordTrans.gcjToBaidu(latLng4);
            }
            if (latLng2 != null && latLng4 != null) {
                this.c.a("bounds", latLng2.latitude + "," + latLng2.longitude + "," + latLng4.latitude + "," + latLng4.longitude);
            }
        }
        this.c.a(com.alibaba.ariver.remotedebug.b.c.g, "json");
        this.c.a("extensions_adcode", poiBoundSearchOption.isExtendAdcode() ? "true" : AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        this.c.a("scope", poiBoundSearchOption.mScope + "");
        this.c.a("page_num", poiBoundSearchOption.mPageNum + "");
        this.c.a("page_size", poiBoundSearchOption.mPageCapacity + "");
        if (poiBoundSearchOption.mScope != 2 || (poiFilter = poiBoundSearchOption.mPoiFilter) == null || TextUtils.isEmpty(poiFilter.toString())) {
            return;
        }
        this.c.a("filter", poiBoundSearchOption.mPoiFilter.toString());
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.u();
    }
}
