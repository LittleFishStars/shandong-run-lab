package com.zj.adlib;

import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.huachenjie.common.util.ActivityLifecycleManager;
import huachenjie.sdk.map.adapter.map.HCJMap;
import huachenjie.sdk.map.amap.ACameraUpdate;
import huachenjie.sdk.map.lib_base.HCJLatLng;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ$\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005J.\u0010\n\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0003J\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¨\u0006\u0010"}, d2 = {"Lcom/zj/adlib/sc1;", "", "", "Lhuachenjie/sdk/map/lib_base/HCJLatLng;", "pointList", "Lhuachenjie/sdk/map/adapter/map/HCJMap;", "aMap", "", "b", "centerPoint", "c", "Lcom/amap/api/maps/model/LatLng;", "Lcom/amap/api/maps/model/LatLngBounds;", "a", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nCameraUpdateUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CameraUpdateUtils.kt\ncom/huachenjie/common/util/amap/CameraUpdateUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,95:1\n1#2:96\n*E\n"})
public final class sc1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final sc1 f44659a = new sc1();

    public final LatLngBounds a(LatLng centerPoint, List<? extends HCJLatLng> pointList) {
        LatLngBounds.Builder builder = LatLngBounds.builder();
        int size = pointList.size();
        for (int i = 0; i < size; i++) {
            LatLng latLngA = gz3.f42014a.a(pointList.get(i));
            builder.include(latLngA);
            double d = 2;
            double d2 = centerPoint.latitude * d;
            Intrinsics.checkNotNull(latLngA);
            builder.include(new LatLng(d2 - latLngA.latitude, (centerPoint.longitude * d) - latLngA.longitude));
        }
        LatLngBounds latLngBoundsBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(latLngBoundsBuild, "builder.build()");
        return latLngBoundsBuild;
    }

    public final void b(@NotNull List<? extends HCJLatLng> pointList, @NotNull HCJMap<?, ?> aMap) {
        Intrinsics.checkNotNullParameter(pointList, "pointList");
        Intrinsics.checkNotNullParameter(aMap, "aMap");
        c(pointList, aMap, null);
    }

    public final void c(@NotNull List<? extends HCJLatLng> pointList, @NotNull HCJMap<?, ?> aMap, @Nullable HCJLatLng centerPoint) {
        LatLngBounds latLngBoundsA;
        Intrinsics.checkNotNullParameter(pointList, "pointList");
        Intrinsics.checkNotNullParameter(aMap, "aMap");
        if (pointList.isEmpty()) {
            return;
        }
        int size = pointList.size();
        if (centerPoint == null) {
            if (size == 1) {
                centerPoint = pointList.get(0);
            } else if (size >= 2) {
                double d = 2;
                centerPoint = new HCJLatLng((pointList.get(0).lat + pointList.get(1).lat) / d, (pointList.get(0).lng + pointList.get(1).lng) / d);
            }
        }
        if (centerPoint == null) {
            i4a.a("中心点查找失败");
            return;
        }
        LatLng latLngA = gz3.f42014a.a(centerPoint);
        if (latLngA == null || (latLngBoundsA = f44659a.a(latLngA, pointList)) == null) {
            return;
        }
        ACameraUpdate aCameraUpdate = new ACameraUpdate();
        aCameraUpdate.setReal(CameraUpdateFactory.newLatLngBounds(latLngBoundsA, ActivityLifecycleManager.l().m() != null ? cr2.c(ActivityLifecycleManager.l().m(), 75.0f) : 75));
        aMap.moveCamera(aCameraUpdate);
    }
}
