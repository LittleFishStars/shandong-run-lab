package com.baidu.mapapi.search.geocode;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.b;
import com.baidu.platform.core.geocode.IGeoCoder;
import com.baidu.platform.core.geocode.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class GeoCoder extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IGeoCoder f26529a = new a();
    private boolean b;

    private GeoCoder() {
    }

    public static GeoCoder newInstance() {
        BMapManager.init();
        return new GeoCoder();
    }

    public void destroy() {
        if (this.b) {
            return;
        }
        this.b = true;
        this.f26529a.destroy();
        BMapManager.destroy();
    }

    public boolean geocode(GeoCodeOption geoCodeOption) {
        IGeoCoder iGeoCoder = this.f26529a;
        if (iGeoCoder == null) {
            throw new IllegalStateException("BDMapSDKException: GeoCoder is null, please call newInstance() first.");
        }
        if (geoCodeOption == null || geoCodeOption.mAddress == null || geoCodeOption.mCity == null) {
            throw new IllegalArgumentException("BDMapSDKException: option or address or city can not be null");
        }
        return iGeoCoder.geocode(geoCodeOption);
    }

    public boolean reverseGeoCode(ReverseGeoCodeOption reverseGeoCodeOption) {
        if (this.f26529a == null) {
            throw new IllegalStateException("BDMapSDKException: GeoCoder is null, please call newInstance() first.");
        }
        if (reverseGeoCodeOption == null || reverseGeoCodeOption.getLocation() == null) {
            throw new IllegalArgumentException("BDMapSDKException: option or mLocation can not be null");
        }
        return this.f26529a.reverseGeoCode(reverseGeoCodeOption);
    }

    public void setOnGetGeoCodeResultListener(OnGetGeoCoderResultListener onGetGeoCoderResultListener) {
        IGeoCoder iGeoCoder = this.f26529a;
        if (iGeoCoder == null) {
            throw new IllegalStateException("BDMapSDKException: GeoCoder is null, please call newInstance() first.");
        }
        if (onGetGeoCoderResultListener == null) {
            throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
        }
        iGeoCoder.setOnGetGeoCodeResultListener(onGetGeoCoderResultListener);
    }
}
