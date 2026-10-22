package com.huachenjie.common.map;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.amap.api.fence.GeoFence;
import com.huachenjie.common.base.BaseComponent;
import com.huachenjie.common.bean.GeoFenceDetail;
import com.igexin.sdk.PushConsts;
import com.zj.adlib.r90;
import huachenjie.sdk.map.adapter.location.HCJGeoFenceManager;
import huachenjie.sdk.map.adapter.location.callback.HCJGeoFenceListener;
import huachenjie.sdk.map.adapter.location.model.HCJGeoFence;
import huachenjie.sdk.map.adapter.map.HCJMap;
import huachenjie.sdk.map.adapter.map.model.CaocaoPolygon;
import huachenjie.sdk.map.adapter.map.model.CaocaoPolygonOptions;
import huachenjie.sdk.map.adapter.map.model.HCJCircle;
import huachenjie.sdk.map.adapter.map.model.HCJCircleOptions;
import huachenjie.sdk.map.lib_base.HCJLatLng;
import huachenjie.sdk.map.locationentry.HCJLocationEntry;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class GeoFenceComponent<T> extends BaseComponent<T> {
    public static final String f = "school_geofence_action";
    public static final String g = "sensitive_geofence_action";
    public static final String h = "valid_geofence_action";
    public static final String i = "GeoFenceComponent";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public GeoFenceActionListener f33825a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public GeoFenceReceiver f8788a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f8789a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HCJGeoFenceManager f8790a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HCJMap f8791a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CaocaoPolygonOptions f8792a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HCJCircleOptions f8793a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<String, GeoFenceDetail> f8794a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile ConcurrentMap<String, HCJGeoFence> f8795a;
    public Map<String, HCJLatLng> b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ConcurrentHashMap<String, Object> f8796b;
    public Map<String, HCJLatLng> c;

    public interface GeoFenceActionListener {
        void a(String customerId);

        void b(String customerId);
    }

    public static class GeoFenceReceiver extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<GeoFenceComponent> f33826a;

        public GeoFenceReceiver(GeoFenceComponent component) {
            if (component != null) {
                this.f33826a = new WeakReference<>(component);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Bundle extras;
            GeoFenceComponent geoFenceComponent;
            if ((intent.getAction().equals("school_geofence_action") || intent.getAction().equals("valid_geofence_action") || intent.getAction().equals("sensitive_geofence_action")) && (extras = intent.getExtras()) != null) {
                String string = extras.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                int i = extras.getInt("event");
                WeakReference<GeoFenceComponent> weakReference = this.f33826a;
                if (weakReference == null || (geoFenceComponent = weakReference.get()) == null) {
                    return;
                }
                geoFenceComponent.o(i, string);
            }
        }
    }

    public static class a implements HCJGeoFenceListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<GeoFenceComponent> f33827a;

        public a(GeoFenceComponent component) {
            if (component != null) {
                this.f33827a = new WeakReference<>(component);
            }
        }

        public void onGeoFenceCreateFinished(List<HCJGeoFence> geoFenceList, int errorCode, String customerId) {
            GeoFenceComponent geoFenceComponent;
            WeakReference<GeoFenceComponent> weakReference = this.f33827a;
            if (weakReference == null || (geoFenceComponent = weakReference.get()) == null) {
                return;
            }
            if (errorCode == 0) {
                geoFenceComponent.h(geoFenceList, customerId);
            } else {
                geoFenceComponent.g(errorCode, customerId);
            }
        }
    }

    public GeoFenceComponent(T context) {
        super(context);
    }

    public void A() {
        if (this.f8788a == null || b() == null) {
            return;
        }
        try {
            b().unregisterReceiver(this.f8788a);
            this.f8788a = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.huachenjie.common.base.BaseComponent
    public void bindData() {
    }

    @Override // com.huachenjie.common.base.BaseComponent
    public void findViews() {
        this.f8794a = new HashMap();
        this.b = new HashMap();
        this.c = new HashMap();
        this.f8796b = new ConcurrentHashMap<>();
        this.f8795a = new ConcurrentHashMap();
        this.f8790a = HCJLocationEntry.getInstance().createGeoFenceManager();
    }

    public final void g(int errorCode, String customerId) {
    }

    public final void h(List<HCJGeoFence> geoFenceList, String customerId) {
        for (HCJGeoFence hCJGeoFence : geoFenceList) {
            this.f8795a.putIfAbsent(hCJGeoFence.getFenceId(), hCJGeoFence);
        }
        n();
    }

    public void i() {
        if (this.f8789a == null) {
            this.f8789a = new a(this);
        }
        for (Map.Entry<String, GeoFenceDetail> entry : this.f8794a.entrySet()) {
            this.f8790a.addPolygonGeoFence(b(), entry.getValue().getFenceList(), entry.getKey(), "school_geofence_action", this.f8789a);
        }
        for (Map.Entry<String, HCJLatLng> entry2 : this.b.entrySet()) {
            this.f8790a.addCircleGeoFence(b(), entry2.getValue(), r90.g().getValidDistance(), entry2.getKey(), "valid_geofence_action", this.f8789a);
        }
        for (Map.Entry<String, HCJLatLng> entry3 : this.c.entrySet()) {
            this.f8790a.addCircleGeoFence(b(), entry3.getValue(), r90.g().getSensitiveDistance(), entry3.getKey(), "sensitive_geofence_action", this.f8789a);
        }
    }

    @Override // com.huachenjie.common.base.BaseComponent
    public void initListeners() {
    }

    public void j() {
        t();
        this.f8795a.clear();
    }

    public final void k(HCJGeoFence fence, HCJCircleOptions circleOptions) {
        if (this.f8791a == null || fence.getRadius() <= 0.0f || fence.getCenter() == null) {
            return;
        }
        circleOptions.radius(fence.getRadius());
        circleOptions.center(new HCJLatLng(fence.getCenter().getLat(), fence.getCenter().getLng()));
        this.f8796b.put(fence.getFenceId(), this.f8791a.addCircle(circleOptions));
    }

    public final void l(HCJGeoFence fence) {
        CaocaoPolygonOptions caocaoPolygonOptions;
        int type = fence.getType();
        if (type != 0) {
            if ((type == 1 || (type != 2 && type == 3)) && (caocaoPolygonOptions = this.f8792a) != null) {
                m(fence, caocaoPolygonOptions);
            }
        }
    }

    public final void m(HCJGeoFence fence, CaocaoPolygonOptions polygonOption) {
        List<List> pointList;
        if (this.f8791a == null || (pointList = fence.getPointList()) == null || pointList.isEmpty()) {
            return;
        }
        for (List list : pointList) {
            if (list != null) {
                polygonOption.addAll(list);
                this.f8796b.put(fence.getFenceId(), this.f8791a.addPolygon(polygonOption));
            }
        }
    }

    public void n() {
        for (Map.Entry<String, HCJGeoFence> entry : this.f8795a.entrySet()) {
            String key = entry.getKey();
            HCJGeoFence value = entry.getValue();
            if (!this.f8796b.containsKey(key)) {
                l(value);
            }
        }
    }

    public final void o(int status, String customerID) {
        GeoFenceActionListener geoFenceActionListener;
        if (status != 1) {
            if (status == 2 && (geoFenceActionListener = this.f33825a) != null) {
                geoFenceActionListener.a(customerID);
                return;
            }
            return;
        }
        GeoFenceActionListener geoFenceActionListener2 = this.f33825a;
        if (geoFenceActionListener2 != null) {
            geoFenceActionListener2.b(customerID);
        }
    }

    @Override // com.huachenjie.common.base.BaseComponent, com.huachenjie.common.base.ILifecycleCallback
    public void onDestroy() {
        super.onDestroy();
        t();
        A();
        this.f8789a = null;
    }

    public void p(Map<String, GeoFenceDetail> map) {
        this.f8794a = map;
    }

    public void q(Map<String, HCJLatLng> map) {
        this.c = map;
    }

    public void r(Map<String, HCJLatLng> map) {
        this.b = map;
    }

    public void s() {
        if (this.f8788a == null) {
            this.f8788a = new GeoFenceReceiver(this);
            IntentFilter intentFilter = new IntentFilter(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
            intentFilter.addAction("school_geofence_action");
            intentFilter.addAction("valid_geofence_action");
            intentFilter.addAction("sensitive_geofence_action");
            if (b() != null) {
                b().registerReceiver(this.f8788a, intentFilter);
            }
        }
    }

    public void t() {
        this.f8790a.removeUniqueGeoFence();
        u();
    }

    public void u() {
        for (Map.Entry<String, Object> entry : this.f8796b.entrySet()) {
            entry.getKey();
            if (entry.getValue() instanceof CaocaoPolygon) {
                ((CaocaoPolygon) entry.getValue()).remove();
            } else if (entry.getValue() instanceof HCJCircle) {
                ((HCJCircle) entry.getValue()).remove();
            }
        }
        this.f8796b.clear();
    }

    public void v(HCJCircleOptions options) {
        this.f8793a = options;
    }

    public void w(GeoFenceActionListener listener) {
        this.f33825a = listener;
    }

    public void y(HCJMap map) {
        this.f8791a = map;
    }

    public void z(CaocaoPolygonOptions options) {
        this.f8792a = options;
    }
}
