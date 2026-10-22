package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Bundle;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.model.MyLocationStyle;
import com.google.android.exoplayer2.source.rtsp.d;
import com.zj.adlib.zwa;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class a implements AMapLocationListener, LocationSource {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f681a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AMapLocationClient f683a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AMapLocationClientOption f684a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LocationSource.OnLocationChangedListener f685a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bundle f682a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f686a = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f25872a = 2000;

    public a(Context context) {
        this.f681a = context;
    }

    public final void a(int i) {
        if (i == 1 || i == 0) {
            c(true);
        } else {
            c(false);
        }
    }

    @Override // com.amap.api.maps.LocationSource
    public final void activate(LocationSource.OnLocationChangedListener onLocationChangedListener) {
        this.f685a = onLocationChangedListener;
        if (fo.a(this.f681a, zwa.t()).f26036a == fo.c.SuccessCode && this.f683a == null) {
            try {
                this.f683a = new AMapLocationClient(this.f681a);
                this.f684a = new AMapLocationClientOption();
                this.f683a.setLocationListener(this);
                this.f684a.setInterval(this.f25872a);
                this.f684a.setOnceLocation(this.f686a);
                this.f684a.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
                this.f684a.setNeedAddress(false);
                this.f683a.setLocationOption(this.f684a);
                this.f683a.startLocation();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void b(long j) {
        AMapLocationClientOption aMapLocationClientOption = this.f684a;
        if (aMapLocationClientOption != null && this.f683a != null && aMapLocationClientOption.getInterval() != j) {
            this.f684a.setInterval(j);
            this.f683a.setLocationOption(this.f684a);
        }
        this.f25872a = j;
    }

    public final void c(boolean z) {
        AMapLocationClient aMapLocationClient;
        if (this.f684a != null && (aMapLocationClient = this.f683a) != null) {
            try {
                aMapLocationClient.onDestroy();
                AMapLocationClient aMapLocationClient2 = new AMapLocationClient(this.f681a);
                this.f683a = aMapLocationClient2;
                aMapLocationClient2.setLocationListener(this);
                this.f684a.setOnceLocation(z);
                this.f684a.setNeedAddress(false);
                if (!z) {
                    this.f684a.setInterval(this.f25872a);
                }
                this.f683a.setLocationOption(this.f684a);
                this.f683a.startLocation();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.f686a = z;
    }

    @Override // com.amap.api.maps.LocationSource
    public final void deactivate() {
        this.f685a = null;
        AMapLocationClient aMapLocationClient = this.f683a;
        if (aMapLocationClient != null) {
            aMapLocationClient.stopLocation();
            this.f683a.onDestroy();
        }
        this.f683a = null;
    }

    @Override // com.amap.api.location.AMapLocationListener
    public final void onLocationChanged(AMapLocation aMapLocation) {
        try {
            if (this.f685a == null || aMapLocation == null) {
                return;
            }
            Bundle extras = aMapLocation.getExtras();
            this.f682a = extras;
            if (extras == null) {
                this.f682a = new Bundle();
            }
            this.f682a.putInt("errorCode", aMapLocation.getErrorCode());
            this.f682a.putString(MyLocationStyle.ERROR_INFO, aMapLocation.getErrorInfo());
            this.f682a.putInt(MyLocationStyle.LOCATION_TYPE, aMapLocation.getLocationType());
            this.f682a.putFloat("Accuracy", aMapLocation.getAccuracy());
            this.f682a.putString("AdCode", aMapLocation.getAdCode());
            this.f682a.putString("Address", aMapLocation.getAddress());
            this.f682a.putString("AoiName", aMapLocation.getAoiName());
            this.f682a.putString("City", aMapLocation.getCity());
            this.f682a.putString("CityCode", aMapLocation.getCityCode());
            this.f682a.putString("Country", aMapLocation.getCountry());
            this.f682a.putString("District", aMapLocation.getDistrict());
            this.f682a.putString("Street", aMapLocation.getStreet());
            this.f682a.putString("StreetNum", aMapLocation.getStreetNum());
            this.f682a.putString("PoiName", aMapLocation.getPoiName());
            this.f682a.putString("Province", aMapLocation.getProvince());
            this.f682a.putFloat(d.z, aMapLocation.getSpeed());
            this.f682a.putString("Floor", aMapLocation.getFloor());
            this.f682a.putFloat("Bearing", aMapLocation.getBearing());
            this.f682a.putString("BuildingId", aMapLocation.getBuildingId());
            this.f682a.putDouble("Altitude", aMapLocation.getAltitude());
            aMapLocation.setExtras(this.f682a);
            this.f685a.onLocationChanged(aMapLocation);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
