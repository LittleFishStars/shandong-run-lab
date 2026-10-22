package com.amap.api.fence;

import android.app.PendingIntent;
import android.content.Context;
import com.amap.api.location.DPoint;
import com.autonavi.aps.amapapi.utils.b;
import com.zj.adlib.mha;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class GeoFenceClient {
    public static final int GEOFENCE_IN = 1;
    public static final int GEOFENCE_OUT = 2;
    public static final int GEOFENCE_STAYED = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f26076a;
    mha b;

    public GeoFenceClient(Context context) {
        this.f26076a = null;
        this.b = null;
        try {
            if (context == null) {
                throw new IllegalArgumentException("Context参数不能为null");
            }
            Context applicationContext = context.getApplicationContext();
            this.f26076a = applicationContext;
            this.b = a(applicationContext);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "<init>");
        }
    }

    private static mha a(Context context) {
        return new mha(context);
    }

    public void addGeoFence(DPoint dPoint, float f, String str) {
        try {
            this.b.n(dPoint, f, str);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "addGeoFence round");
        }
    }

    public PendingIntent createPendingIntent(String str) {
        try {
            return this.b.d(str);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "creatPendingIntent");
            return null;
        }
    }

    public List<GeoFence> getAllGeoFence() {
        ArrayList arrayList = new ArrayList();
        try {
            return this.b.B();
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "getGeoFenceList");
            return arrayList;
        }
    }

    public boolean isPause() {
        try {
            return this.b.Z();
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "isPause");
            return true;
        }
    }

    public void pauseGeoFence() {
        try {
            this.b.S();
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "pauseGeoFence");
        }
    }

    public void removeGeoFence() {
        try {
            this.b.g();
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "removeGeoFence");
        }
    }

    public void resumeGeoFence() {
        try {
            this.b.W();
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "resumeGeoFence");
        }
    }

    public void setActivateAction(int i) {
        try {
            this.b.h(i);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "setActivatesAction");
        }
    }

    public void setGeoFenceAble(String str, boolean z) {
        try {
            this.b.s(str, z);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "setGeoFenceAble");
        }
    }

    public void setGeoFenceListener(GeoFenceListener geoFenceListener) {
        try {
            this.b.l(geoFenceListener);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "setGeoFenceListener");
        }
    }

    public void addGeoFence(List<DPoint> list, String str) {
        try {
            this.b.t(list, str);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "addGeoFence polygon");
        }
    }

    public boolean removeGeoFence(GeoFence geoFence) {
        try {
            return this.b.v(geoFence);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "removeGeoFence1");
            return false;
        }
    }

    public void addGeoFence(String str, String str2, DPoint dPoint, float f, int i, String str3) {
        try {
            this.b.q(str, str2, dPoint, f, i, str3);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "addGeoFence searche");
        }
    }

    public void addGeoFence(String str, String str2, String str3, int i, String str4) {
        try {
            this.b.r(str, str2, str3, i, str4);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "addGeoFence searche");
        }
    }

    public void addGeoFence(String str, String str2) {
        try {
            this.b.p(str, str2);
        } catch (Throwable th) {
            b.a(th, "GeoFenceClient", "addGeoFence district");
        }
    }
}
