package com.huachenjie.common.run_component;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.amap.api.fence.GeoFence;
import com.huachenjie.common.base.BaseSimpleComponent;
import com.huachenjie.common.bean.CommonConfig;
import com.huachenjie.common.bean.GeoFenceDetail;
import com.igexin.sdk.PushConsts;
import huachenjie.sdk.map.adapter.location.HCJGeoFenceManager;
import huachenjie.sdk.map.adapter.location.callback.HCJGeoFenceListener;
import huachenjie.sdk.map.adapter.location.model.HCJGeoFence;
import huachenjie.sdk.map.lib_base.HCJLatLng;
import huachenjie.sdk.map.locationentry.HCJLocationEntry;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class GeoFenceComponentV2 extends BaseSimpleComponent {
    public static final String f = "school_geofence_action";
    public static final String g = "sensitive_geofence_action";
    public static final String h = "valid_geofence_action";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f33876a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public GeoFenceActionListener f8840a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public GeoFenceCreateListener f8841a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public GeoFenceReceiver f8842a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f8843a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HCJGeoFenceManager f8844a;

    public interface GeoFenceActionListener {
        void a(String customerId);

        void b(String customerId);
    }

    public interface GeoFenceCreateListener {
        void a(String customerId, List<HCJGeoFence> geoFenceList);

        void fail(String customerId);
    }

    public static class GeoFenceReceiver extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<GeoFenceComponentV2> f33877a;

        public GeoFenceReceiver(GeoFenceComponentV2 component) {
            if (component != null) {
                this.f33877a = new WeakReference<>(component);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Bundle extras;
            GeoFenceComponentV2 geoFenceComponentV2;
            if ((intent.getAction().equals("school_geofence_action") || intent.getAction().equals("valid_geofence_action") || intent.getAction().equals("sensitive_geofence_action")) && (extras = intent.getExtras()) != null) {
                String string = extras.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                int i = extras.getInt("event");
                WeakReference<GeoFenceComponentV2> weakReference = this.f33877a;
                if (weakReference == null || (geoFenceComponentV2 = weakReference.get()) == null) {
                    return;
                }
                geoFenceComponentV2.f(i, string);
            }
        }
    }

    public class a implements HCJGeoFenceListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public WeakReference<GeoFenceComponentV2> f8845a;

        public a(GeoFenceComponentV2 component) {
            if (component != null) {
                this.f8845a = new WeakReference<>(component);
            }
        }

        public void onGeoFenceCreateFinished(List<HCJGeoFence> geoFenceList, int errorCode, String customerId) {
            WeakReference<GeoFenceComponentV2> weakReference;
            if (GeoFenceComponentV2.this.f8841a == null || (weakReference = this.f8845a) == null || weakReference.get() == null) {
                return;
            }
            if (errorCode == 0) {
                GeoFenceComponentV2.this.f8841a.a(customerId, geoFenceList);
            } else {
                GeoFenceComponentV2.this.f8841a.fail(customerId);
            }
        }
    }

    public GeoFenceComponentV2(Context mContext) {
        this.f33876a = mContext;
        initData();
    }

    public void e(Map<String, GeoFenceDetail> fenceDetailMap, Map<String, HCJLatLng> validPointMap, Map<String, HCJLatLng> sensitivePointMap, CommonConfig config) {
        if (this.f8843a == null) {
            this.f8843a = new a(this);
        }
        for (Map.Entry<String, GeoFenceDetail> entry : fenceDetailMap.entrySet()) {
            this.f8844a.addPolygonGeoFence(this.f33876a, entry.getValue().getFenceList(), entry.getKey(), "school_geofence_action", this.f8843a);
        }
        for (Map.Entry<String, HCJLatLng> entry2 : validPointMap.entrySet()) {
            this.f8844a.addCircleGeoFence(this.f33876a, entry2.getValue(), config.getValidDistance(), entry2.getKey(), "valid_geofence_action", this.f8843a);
        }
        for (Map.Entry<String, HCJLatLng> entry3 : sensitivePointMap.entrySet()) {
            this.f8844a.addCircleGeoFence(this.f33876a, entry3.getValue(), config.getSensitiveDistance(), entry3.getKey(), "sensitive_geofence_action", this.f8843a);
        }
        g();
    }

    public final void f(int status, String customerID) {
        GeoFenceActionListener geoFenceActionListener;
        if (status != 1) {
            if (status == 2 && (geoFenceActionListener = this.f8840a) != null) {
                geoFenceActionListener.a(customerID);
                return;
            }
            return;
        }
        GeoFenceActionListener geoFenceActionListener2 = this.f8840a;
        if (geoFenceActionListener2 != null) {
            geoFenceActionListener2.b(customerID);
        }
    }

    public final void g() {
        if (this.f8842a == null) {
            this.f8842a = new GeoFenceReceiver(this);
            IntentFilter intentFilter = new IntentFilter(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
            intentFilter.addAction("school_geofence_action");
            intentFilter.addAction("valid_geofence_action");
            intentFilter.addAction("sensitive_geofence_action");
            this.f33876a.registerReceiver(this.f8842a, intentFilter);
        }
    }

    public void h() {
        this.f8844a.removeUniqueGeoFence();
    }

    public void i(GeoFenceActionListener listener) {
        this.f8840a = listener;
    }

    public final void initData() {
        this.f8844a = HCJLocationEntry.getInstance().createGeoFenceManager();
    }

    public void j(GeoFenceCreateListener listener) {
        this.f8841a = listener;
    }

    public void k() {
        GeoFenceReceiver geoFenceReceiver = this.f8842a;
        if (geoFenceReceiver != null) {
            try {
                this.f33876a.unregisterReceiver(geoFenceReceiver);
                this.f8842a = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.huachenjie.common.base.BaseSimpleComponent, com.huachenjie.common.base.ILifecycleCallback
    public void onDestroy() {
        this.f8840a = null;
        this.f8841a = null;
        h();
        k();
        this.f33876a = null;
        super.onDestroy();
    }
}
