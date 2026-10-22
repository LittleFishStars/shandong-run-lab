package com.huachenjie.run.component;

import com.amap.api.fence.GeoFence;
import com.huachenjie.common.base.BaseSimpleComponent;
import com.huachenjie.common.bean.GeoFenceDetail;
import huachenjie.sdk.map.adapter.map.HCJMap;
import huachenjie.sdk.map.adapter.map.model.CaocaoPolygon;
import huachenjie.sdk.map.adapter.map.model.CaocaoPolygonOptions;
import huachenjie.sdk.map.lib_base.HCJLatLng;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\u0010\u0010\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\r¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0005\u001a\u00020\u00042\u0010\u0010\u0003\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\t\u001a\u00020\u0004H\u0016J \u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u000e\u0010\u000b\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002H\u0002R\u001e\u0010\u0010\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR \u0010\u0012\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0011R \u0010\u0015\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/huachenjie/run/component/ActivityFenceViewComponent;", "Lcom/huachenjie/common/base/BaseSimpleComponent;", "Lhuachenjie/sdk/map/adapter/map/model/CaocaoPolygonOptions;", "options", "", "e", "Lcom/huachenjie/common/bean/GeoFenceDetail;", "geoFence", "c", "onDestroy", GeoFence.BUNDLE_KEY_FENCE, "polygonOption", "d", "Lhuachenjie/sdk/map/adapter/map/HCJMap;", "a", "Lhuachenjie/sdk/map/adapter/map/HCJMap;", "mMap", "Lhuachenjie/sdk/map/adapter/map/model/CaocaoPolygonOptions;", "mPolylineOptions", "Lhuachenjie/sdk/map/adapter/map/model/CaocaoPolygon;", "Lhuachenjie/sdk/map/adapter/map/model/CaocaoPolygon;", "mPolygon", "<init>", "(Lhuachenjie/sdk/map/adapter/map/HCJMap;)V", "run_release"}, k = 1, mv = {1, 8, 0})
public final class ActivityFenceViewComponent extends BaseSimpleComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public final HCJMap<?, ?> mMap;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public CaocaoPolygon<?, ?> mPolygon;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public CaocaoPolygonOptions<?, ?> mPolylineOptions;

    public ActivityFenceViewComponent(@Nullable HCJMap<?, ?> hCJMap) {
        this.mMap = hCJMap;
    }

    public final void c(@NotNull GeoFenceDetail geoFence) {
        CaocaoPolygonOptions<?, ?> caocaoPolygonOptions;
        Intrinsics.checkNotNullParameter(geoFence, "geoFence");
        if (this.mMap == null || (caocaoPolygonOptions = this.mPolylineOptions) == null) {
            return;
        }
        Intrinsics.checkNotNull(caocaoPolygonOptions);
        d(geoFence, caocaoPolygonOptions);
    }

    public final void d(GeoFenceDetail fence, CaocaoPolygonOptions<?, ?> polygonOption) {
        List<HCJLatLng> fenceList = fence.getFenceList();
        if (fenceList == null || fenceList.isEmpty()) {
            return;
        }
        polygonOption.addAll(fence.getFenceList());
        HCJMap<?, ?> hCJMap = this.mMap;
        this.mPolygon = hCJMap != null ? hCJMap.addPolygon(polygonOption) : null;
    }

    public final void e(@Nullable CaocaoPolygonOptions<?, ?> options) {
        this.mPolylineOptions = options;
    }

    @Override // com.huachenjie.common.base.BaseSimpleComponent, com.huachenjie.common.base.ILifecycleCallback
    public void onDestroy() {
        CaocaoPolygon<?, ?> caocaoPolygon = this.mPolygon;
        if (caocaoPolygon != null) {
            caocaoPolygon.remove();
        }
        super.onDestroy();
    }
}
