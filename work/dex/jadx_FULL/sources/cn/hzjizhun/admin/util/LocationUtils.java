package cn.hzjizhun.admin.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import cn.hzjizhun.admin.JZAdSdk;
import cn.hzjizhun.admin.base.ad.RcSdk;
import com.alibaba.sdk.android.oss.common.RequestParameters;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class LocationUtils {
    private static LocationUtils mUtils;
    private LocationManager locationManager;
    private float mLongitude;
    private String locationProvider = "network";
    private float mLatitude = 0.0f;
    private boolean mIsLoadLocation = true;
    private boolean mIsInitLoadLocation = true;
    private boolean mIsAdLoadLocation = false;
    private volatile boolean mIsNeedLoadLocation = false;
    public LocationListener locationListener = new a();

    public class a implements LocationListener {
        public a() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (location != null) {
                LocationUtils.this.setLocation(location);
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    public static LocationUtils getInstance() {
        if (mUtils == null) {
            synchronized (LocationUtils.class) {
                if (mUtils == null) {
                    mUtils = new LocationUtils();
                }
            }
        }
        return mUtils;
    }

    @SuppressLint({"MissingPermission"})
    private void requestLocation(Context context) {
        try {
            if (this.mIsNeedLoadLocation) {
                return;
            }
            this.mIsNeedLoadLocation = true;
            LocationManager locationManager = (LocationManager) context.getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
            this.locationManager = locationManager;
            locationManager.getProviders(true);
            Criteria criteria = new Criteria();
            criteria.setAccuracy(1);
            criteria.setPowerRequirement(1);
            criteria.setAltitudeRequired(false);
            criteria.setBearingRequired(false);
            criteria.setSpeedRequired(false);
            criteria.setCostAllowed(true);
            String bestProvider = this.locationManager.getBestProvider(criteria, true);
            this.locationProvider = bestProvider;
            Location lastKnownLocation = this.locationManager.getLastKnownLocation(bestProvider);
            if (lastKnownLocation != null) {
                setLocation(lastKnownLocation);
            } else {
                this.locationManager.requestLocationUpdates(this.locationProvider, 3000L, 1.0f, this.locationListener);
            }
        } catch (Throwable unused) {
        }
    }

    private void setLatitude(float f) {
        this.mLatitude = f;
    }

    private void setLongitude(float f) {
        this.mLongitude = f;
    }

    public float getLatitude() {
        return this.mLatitude;
    }

    public void getLocation(Context context) {
        if (context != null) {
            try {
                if (this.mIsLoadLocation) {
                    if ((this.mIsInitLoadLocation || this.mIsAdLoadLocation) && !this.mIsNeedLoadLocation && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0 && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                        requestLocation(context);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public float getLongitude() {
        return this.mLongitude;
    }

    public boolean isLoadLocation() {
        return this.mIsLoadLocation;
    }

    public void notAllowLoadLocation() {
        this.mIsLoadLocation = false;
    }

    @SuppressLint({"MissingPermission"})
    public void onDestroy() {
        try {
            LocationManager locationManager = this.locationManager;
            if (locationManager == null && this.locationListener == null) {
                return;
            }
            locationManager.removeUpdates(this.locationListener);
        } catch (Throwable unused) {
        }
    }

    public void setBaseLocation(float f, float f2) {
        try {
            RcSdk.setLocation(f, f2);
        } catch (Throwable unused) {
        }
    }

    public void setIsAdLoadLocation(boolean z) {
        this.mIsAdLoadLocation = z;
        if (z) {
            getLocation(JZAdSdk.getInstance().getContext());
        }
    }

    public void setIsInitLoadLocation(boolean z) {
        this.mIsInitLoadLocation = z;
    }

    public void setLocation(Location location) {
        if (location == null) {
            return;
        }
        try {
            float longitude = (float) location.getLongitude();
            float latitude = (float) location.getLatitude();
            setLongitude(longitude);
            setLatitude(latitude);
            setBaseLocation(longitude, latitude);
        } catch (Throwable unused) {
        }
    }

    public void setLocation(float f, float f2) {
        try {
            this.mIsLoadLocation = false;
            setLongitude(f);
            setLatitude(f2);
            setBaseLocation(f, f2);
        } catch (Throwable unused) {
        }
    }
}
