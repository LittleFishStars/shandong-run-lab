package com.beizi.fusion;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class ih implements kd {
    private final Context c;
    private jd d;
    private jd e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f27409a = "scope_loc";
    private final String b = "loc_last";
    private boolean f = false;
    private boolean g = false;
    private long h = 0;
    private boolean i = false;
    private boolean j = false;

    public static class a implements jd {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Location f27410a;

        private a(Location location) {
            this.f27410a = location;
        }

        @Override // com.beizi.fusion.jd
        public double a() {
            return this.f27410a.getLatitude();
        }

        @Override // com.beizi.fusion.jd
        public double b() {
            return this.f27410a.getLongitude();
        }

        @Override // com.beizi.fusion.jd
        public jd.a c() {
            return jd.a.WGS_84;
        }

        @Override // com.beizi.fusion.jd
        public long d() {
            return this.f27410a.getTime();
        }
    }

    public ih(Context context) {
        this.c = context.getApplicationContext();
    }

    private jd b(LocationManager locationManager) {
        List<String> providers = locationManager.getProviders(true);
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = providers.iterator();
        while (it.hasNext()) {
            Location lastKnownLocation = locationManager.getLastKnownLocation(it.next());
            if (lastKnownLocation != null) {
                arrayList.add(lastKnownLocation);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        Collections.sort(arrayList, new Comparator() { // from class: com.beizi.fusion.yq
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ih.a((Location) obj, (Location) obj2);
            }
        });
        return new a((Location) arrayList.get(0));
    }

    private jd c(LocationManager locationManager) {
        return this.i ? a(locationManager) : b(locationManager);
    }

    private boolean d() {
        return zk.b(this.c, "android.permission.ACCESS_COARSE_LOCATION");
    }

    private boolean e() {
        return zk.b(this.c, "android.permission.ACCESS_FINE_LOCATION");
    }

    private boolean f() {
        if (this.c != null) {
            return e() || d();
        }
        return false;
    }

    @Override // com.beizi.fusion.kd
    public jd a() {
        LocationManager locationManager;
        if (this.f && f() && c()) {
            if (this.e == null && (locationManager = (LocationManager) this.c.getSystemService(RequestParameters.SUBRESOURCE_LOCATION)) != null) {
                this.e = c(locationManager);
            }
            jd jdVar = this.e;
            if (jdVar != null) {
                return jdVar;
            }
        }
        return this.d;
    }

    private boolean c() {
        return System.currentTimeMillis() - r5.a(this.c, "scope_loc", "loc_last", 0L) > this.h;
    }

    private jd a(LocationManager locationManager) {
        Location lastKnownLocation;
        if (!this.g) {
            this.g = true;
            String bestProvider = locationManager.getBestProvider(new Criteria(), true);
            if (!TextUtils.isEmpty(bestProvider)) {
                lastKnownLocation = locationManager.getLastKnownLocation(bestProvider);
            } else if (e()) {
                lastKnownLocation = locationManager.getLastKnownLocation("gps");
            } else {
                lastKnownLocation = d() ? locationManager.getLastKnownLocation("network") : null;
            }
            if (lastKnownLocation != null) {
                return new a(lastKnownLocation);
            }
        }
        return null;
    }

    @Override // com.beizi.fusion.kd
    public void b() {
        this.f = true;
    }

    @Override // com.beizi.fusion.kd
    public void b(boolean z) {
        this.i = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(Location location, Location location2) {
        return Long.compare(location2.getTime(), location.getTime());
    }

    @Override // com.beizi.fusion.kd
    public void a(jd jdVar) {
        this.d = jdVar;
    }

    @Override // com.beizi.fusion.kd
    public void a(boolean z) {
        this.j = z;
    }
}
