package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.os.Handler;
import com.amap.api.col.p0003l.ax;
import com.amap.api.col.p0003l.ay;
import com.amap.api.col.p0003l.fo;
import com.amap.api.col.p0003l.m;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapException;
import com.zj.adlib.a7b;
import com.zj.adlib.n4b;
import com.zj.adlib.nna;
import com.zj.adlib.xwa;
import com.zj.adlib.zwa;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class OfflineMapManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    nna f26140a;
    ay b;
    private Context c;
    private OfflineMapDownloadListener d;
    private OfflineLoadedListener e;
    private Handler f;
    private Handler g;

    public interface OfflineLoadedListener {
        void onVerifyComplete();
    }

    public interface OfflineMapDownloadListener {
        void onCheckUpdate(boolean z, String str);

        void onDownload(int i, int i2, String str);

        void onRemove(boolean z, String str, String str2);
    }

    public OfflineMapManager(Context context, OfflineMapDownloadListener offlineMapDownloadListener) throws Exception {
        m mVarA = fo.a(context, zwa.t());
        if (mVarA.f26036a != fo.c.SuccessCode) {
            throw new Exception(mVarA.f1069a);
        }
        this.d = offlineMapDownloadListener;
        this.c = context.getApplicationContext();
        this.f = new Handler(this.c.getMainLooper());
        this.g = new Handler(this.c.getMainLooper());
        a(context);
        n4b.a().c(this.c);
    }

    public final void destroy() {
        try {
            ay ayVar = this.b;
            if (ayVar != null) {
                ayVar.z();
            }
            b();
            Handler handler = this.f;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.f = null;
            Handler handler2 = this.g;
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages(null);
            }
            this.g = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void downloadByCityCode(String str) throws AMapException {
        try {
            this.b.B(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void downloadByCityName(String str) throws AMapException {
        try {
            this.b.x(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void downloadByProvinceName(String str) throws AMapException {
        try {
            a();
            OfflineMapProvince itemByProvinceName = getItemByProvinceName(str);
            if (itemByProvinceName == null) {
                throw new AMapException(AMapException.ERROR_INVALID_PARAMETER);
            }
            Iterator<OfflineMapCity> it = itemByProvinceName.getCityList().iterator();
            while (it.hasNext()) {
                final String city = it.next().getCity();
                this.g.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            OfflineMapManager.this.b.x(city);
                        } catch (AMapException e) {
                            a7b.m(e, "OfflineMapManager", "downloadByProvinceName");
                        }
                    }
                });
            }
        } catch (Throwable th) {
            if (th instanceof AMapException) {
                throw th;
            }
            a7b.m(th, "OfflineMapManager", "downloadByProvinceName");
        }
    }

    public final ArrayList<OfflineMapCity> getDownloadOfflineMapCityList() {
        return this.f26140a.s();
    }

    public final ArrayList<OfflineMapProvince> getDownloadOfflineMapProvinceList() {
        return this.f26140a.t();
    }

    public final ArrayList<OfflineMapCity> getDownloadingCityList() {
        return this.f26140a.u();
    }

    public final ArrayList<OfflineMapProvince> getDownloadingProvinceList() {
        return this.f26140a.v();
    }

    public final OfflineMapCity getItemByCityCode(String str) {
        return this.f26140a.a(str);
    }

    public final OfflineMapCity getItemByCityName(String str) {
        return this.f26140a.m(str);
    }

    public final OfflineMapProvince getItemByProvinceName(String str) {
        return this.f26140a.r(str);
    }

    public final ArrayList<OfflineMapCity> getOfflineMapCityList() {
        return this.f26140a.n();
    }

    public final ArrayList<OfflineMapProvince> getOfflineMapProvinceList() {
        return this.f26140a.b();
    }

    public final void pause() {
        this.b.v();
    }

    public final void pauseByName(String str) {
        this.b.u(str);
    }

    public final void remove(String str) {
        try {
            if (this.b.m(str)) {
                this.b.q(str);
                return;
            }
            OfflineMapProvince offlineMapProvinceR = this.f26140a.r(str);
            if (offlineMapProvinceR != null && offlineMapProvinceR.getCityList() != null) {
                Iterator<OfflineMapCity> it = offlineMapProvinceR.getCityList().iterator();
                while (it.hasNext()) {
                    final String city = it.next().getCity();
                    this.g.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            OfflineMapManager.this.b.q(city);
                        }
                    });
                }
                return;
            }
            OfflineMapDownloadListener offlineMapDownloadListener = this.d;
            if (offlineMapDownloadListener != null) {
                offlineMapDownloadListener.onRemove(false, str, "没有该城市");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void restart() {
    }

    public final void setOnOfflineLoadedListener(OfflineLoadedListener offlineLoadedListener) {
        this.e = offlineLoadedListener;
    }

    public final void stop() {
        this.b.s();
    }

    public final void updateOfflineCityByCode(String str) throws AMapException {
        OfflineMapCity itemByCityCode = getItemByCityCode(str);
        if (itemByCityCode == null || itemByCityCode.getCity() == null) {
            throw new AMapException(AMapException.ERROR_INVALID_PARAMETER);
        }
        a(itemByCityCode.getCity());
    }

    public final void updateOfflineCityByName(String str) throws AMapException {
        a(str);
    }

    public final void updateOfflineMapProvinceByName(String str) throws AMapException {
        a(str);
    }

    private void a(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.c = applicationContext;
        ay.c = false;
        ay ayVarB = ay.b(applicationContext);
        this.b = ayVarB;
        ayVarB.g(new ay.a() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.1
            @Override // com.amap.api.col.3l.ay.a
            public final void a(final ax axVar) {
                if (OfflineMapManager.this.d == null || axVar == null) {
                    return;
                }
                OfflineMapManager.this.f.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            OfflineMapManager.this.d.onDownload(axVar.c().d(), axVar.getcompleteCode(), axVar.getCity());
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }

            @Override // com.amap.api.col.3l.ay.a
            public final void b(final ax axVar) {
                if (OfflineMapManager.this.d == null || axVar == null) {
                    return;
                }
                OfflineMapManager.this.f.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            if (!axVar.c().equals(axVar.g) && !axVar.c().equals(axVar.f25880a)) {
                                OfflineMapManager.this.d.onCheckUpdate(false, axVar.getCity());
                                return;
                            }
                            OfflineMapManager.this.d.onCheckUpdate(true, axVar.getCity());
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }

            @Override // com.amap.api.col.3l.ay.a
            public final void c(final ax axVar) {
                if (OfflineMapManager.this.d == null || axVar == null) {
                    return;
                }
                OfflineMapManager.this.f.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.1.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            if (axVar.c().equals(axVar.f25880a)) {
                                OfflineMapManager.this.d.onRemove(true, axVar.getCity(), "");
                            } else {
                                OfflineMapManager.this.d.onRemove(false, axVar.getCity(), "");
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }

            @Override // com.amap.api.col.3l.ay.a
            public final void a() {
                if (OfflineMapManager.this.e != null) {
                    OfflineMapManager.this.f.post(new Runnable() { // from class: com.amap.api.maps.offlinemap.OfflineMapManager.1.4
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                OfflineMapManager.this.e.onVerifyComplete();
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            }
        });
        try {
            this.b.d();
            this.f26140a = this.b.f722a;
            xwa.k(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void b() {
        this.d = null;
    }

    private void a(String str) throws AMapException {
        this.b.h(str);
    }

    public OfflineMapManager(Context context, OfflineMapDownloadListener offlineMapDownloadListener, AMap aMap) {
        this.d = offlineMapDownloadListener;
        this.c = context.getApplicationContext();
        this.f = new Handler(this.c.getMainLooper());
        this.g = new Handler(this.c.getMainLooper());
        try {
            a(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a() throws AMapException {
        if (!zwa.h0(this.c)) {
            throw new AMapException(AMapException.ERROR_CONNECTION);
        }
    }
}
