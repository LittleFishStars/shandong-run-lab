package com.huachenjie.common.run_component;

import com.huachenjie.common.base.BaseSimpleComponent;
import huachenjie.sdk.map.adapter.location.model.HCJGeoFence;
import huachenjie.sdk.map.adapter.map.HCJMap;
import huachenjie.sdk.map.adapter.map.model.CaocaoPolygon;
import huachenjie.sdk.map.adapter.map.model.CaocaoPolygonOptions;
import huachenjie.sdk.map.adapter.map.model.HCJCircle;
import huachenjie.sdk.map.adapter.map.model.HCJCircleOptions;
import huachenjie.sdk.map.lib_base.HCJLatLng;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class GeoFenceViewComponent extends BaseSimpleComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HCJMap f33879a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CaocaoPolygonOptions f8846a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HCJCircleOptions f8847a;
    public ConcurrentHashMap<String, Object> b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ConcurrentMap<String, HCJGeoFence> f8848a = new ConcurrentHashMap();

    public GeoFenceViewComponent(HCJMap map) {
        this.f33879a = map;
    }

    public void c(List<HCJGeoFence> geoFenceList) {
        this.f8848a.clear();
        for (HCJGeoFence hCJGeoFence : geoFenceList) {
            this.f8848a.putIfAbsent(hCJGeoFence.getFenceId(), hCJGeoFence);
        }
        g();
    }

    public final void d(HCJGeoFence fence, HCJCircleOptions circleOptions) {
        if (this.f33879a == null || fence.getRadius() <= 0.0f || fence.getCenter() == null) {
            return;
        }
        circleOptions.radius(fence.getRadius());
        circleOptions.center(new HCJLatLng(fence.getCenter().getLat(), fence.getCenter().getLng()));
        this.b.put(fence.getFenceId(), this.f33879a.addCircle(circleOptions));
    }

    public final void e(HCJGeoFence fence) {
        CaocaoPolygonOptions caocaoPolygonOptions;
        int type = fence.getType();
        if (type != 0) {
            if ((type == 1 || (type != 2 && type == 3)) && (caocaoPolygonOptions = this.f8846a) != null) {
                f(fence, caocaoPolygonOptions);
            }
        }
    }

    public final void f(HCJGeoFence fence, CaocaoPolygonOptions polygonOption) {
        List<List> pointList;
        if (this.f33879a == null || (pointList = fence.getPointList()) == null || pointList.isEmpty()) {
            return;
        }
        for (List list : pointList) {
            if (list != null) {
                polygonOption.addAll(list);
                this.b.put(fence.getFenceId(), this.f33879a.addPolygon(polygonOption));
            }
        }
    }

    public void g() {
        for (Map.Entry<String, HCJGeoFence> entry : this.f8848a.entrySet()) {
            String key = entry.getKey();
            HCJGeoFence value = entry.getValue();
            if (!this.b.containsKey(key)) {
                e(value);
            }
        }
    }

    public void h() {
        i();
    }

    public void i() {
        for (Map.Entry<String, Object> entry : this.b.entrySet()) {
            entry.getKey();
            if (entry.getValue() instanceof CaocaoPolygon) {
                ((CaocaoPolygon) entry.getValue()).remove();
            } else if (entry.getValue() instanceof HCJCircle) {
                ((HCJCircle) entry.getValue()).remove();
            }
        }
        this.b.clear();
    }

    public void j(HCJCircleOptions options) {
        this.f8847a = options;
    }

    public void k(CaocaoPolygonOptions options) {
        this.f8846a = options;
    }

    @Override // com.huachenjie.common.base.BaseSimpleComponent, com.huachenjie.common.base.ILifecycleCallback
    public void onDestroy() {
        h();
        super.onDestroy();
    }
}
