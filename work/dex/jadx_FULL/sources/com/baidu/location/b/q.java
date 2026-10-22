package com.baidu.location.b;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<c> f26385a = new CopyOnWriteArrayList();
    private LocationManager b = null;
    private b c = null;
    private boolean d = false;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static q f26386a = new q();
    }

    public class b implements LocationListener {
        private b() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (location == null) {
                return;
            }
            try {
                Iterator<c> it = q.this.f26385a.iterator();
                while (it.hasNext()) {
                    it.next().a(location);
                }
            } catch (Exception unused) {
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

    public interface c {
        void a(Location location);
    }

    public static q a() {
        return a.f26386a;
    }

    public void a(Context context, Looper looper) {
        try {
            if (this.b == null) {
                this.b = (LocationManager) context.getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
            }
            if (this.c == null) {
                this.c = new b();
            }
            LocationManager locationManager = this.b;
            if (locationManager == null || !locationManager.isProviderEnabled("network")) {
                return;
            }
            this.b.requestLocationUpdates("network", 1000L, 0.0f, this.c, looper);
        } catch (Exception unused) {
        }
    }

    public void a(c cVar) {
        if (cVar == null) {
            return;
        }
        this.f26385a.remove(cVar);
        if (this.f26385a.size() == 0 && this.d) {
            b();
            this.d = false;
        }
    }

    public void a(c cVar, Context context, Looper looper) {
        if (cVar == null) {
            return;
        }
        if (!this.f26385a.contains(cVar)) {
            this.f26385a.add(cVar);
        }
        if (this.f26385a.size() != 1 || this.d) {
            return;
        }
        a(context, looper);
        this.d = true;
    }

    public void b() {
        LocationManager locationManager;
        b bVar = this.c;
        if (bVar == null || (locationManager = this.b) == null) {
            return;
        }
        locationManager.removeUpdates(bVar);
        this.c = null;
    }
}
