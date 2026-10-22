package com.kc.dw.core.utils;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import androidx.camera.video.AudioStats;
import androidx.core.content.ContextCompat;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class GPSUtils {
    public LocationListener locationListener = new a(this);
    private LocationManager locationManager;
    private Context mContext;
    private b mOnLocationListener;

    @Keep
    public class a implements LocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final GPSUtils f39341a;

        public a(GPSUtils gPSUtils) {
            this.f39341a = gPSUtils;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (this.f39341a.mOnLocationListener != null) {
                this.f39341a.mOnLocationListener.a(location);
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

    @Keep
    public interface b {
        void a(Location location);
    }

    public GPSUtils(Context context) {
        this.mContext = context;
    }

    public double[] getL() {
        Location location = getLocation();
        return location != null ? new double[]{location.getLatitude(), location.getLongitude()} : new double[]{AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE};
    }

    public Location getLocation() {
        try {
            if (ContextCompat.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") != 0 && ContextCompat.checkSelfPermission(this.mContext, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
                return null;
            }
            LocationManager locationManager = (LocationManager) this.mContext.getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
            this.locationManager = locationManager;
            List<String> providers = locationManager.getProviders(true);
            if (!providers.contains("gps") && !providers.contains("network")) {
                return null;
            }
            Iterator<String> it = providers.iterator();
            Location location = null;
            while (it.hasNext()) {
                Location lastKnownLocation = this.locationManager.getLastKnownLocation(it.next());
                if (lastKnownLocation != null && (location == null || lastKnownLocation.getAccuracy() < location.getAccuracy())) {
                    location = lastKnownLocation;
                }
            }
            return location;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void removeListener() {
        this.locationManager.removeUpdates(this.locationListener);
    }
}
