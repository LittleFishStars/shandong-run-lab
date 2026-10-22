package com.zj.adlib;

import android.content.Context;
import com.czhj.sdk.common.Database.SQLiteMTAHelper;
import com.huachenjie.common.bean.RunLatLng;
import com.huachenjie.run.map.RouteOverlay;
import huachenjie.sdk.map.adapter.map.HCJMap;
import huachenjie.sdk.map.adapter.map.model.CaocaoLatLngBounds;
import huachenjie.sdk.map.lib_base.HCJLatLng;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 $2\u00020\u0001:\u0001$B1\u0012\u0006\u0010(\u001a\u00020'\u0012\u0010\u0010*\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010)\u0012\u0006\u0010+\u001a\u00020\t\u0012\u0006\u0010,\u001a\u00020\t¢\u0006\u0004\b-\u0010.J\u0016\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002J\u0018\u0010\u000b\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tJ\u001a\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\u0005J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\u0012\u0010\u0013\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0002R\u001a\u0010\u0019\u001a\u00020\u00148\u0014X\u0094D¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001f\u001a\u00020\u001a8\u0014X\u0094D¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006/"}, d2 = {"Lcom/zj/adlib/dw8;", "Lcom/huachenjie/run/map/RouteOverlay;", "", "Lcom/huachenjie/common/bean/RunLatLng;", "path", "", "z0", "Lhuachenjie/sdk/map/lib_base/HCJLatLng;", "target", "", "padding", "r0", "x0", "u0", SQLiteMTAHelper.TABLE_POINT, "N", "v0", "w0", "y0", "t0", "", "e", "F", "getRouteWidthDp", "()F", "routeWidthDp", "", "d", "Ljava/lang/String;", "getRouteColorHex", "()Ljava/lang/String;", "routeColorHex", "c", "Lhuachenjie/sdk/map/lib_base/HCJLatLng;", "lastPoint", "Ljava/lang/Runnable;", "a", "Ljava/lang/Runnable;", "followTask", "Landroid/content/Context;", "context", "Lhuachenjie/sdk/map/adapter/map/HCJMap;", "map", "clockMode", "runScene", "<init>", "(Landroid/content/Context;Lhuachenjie/sdk/map/adapter/map/HCJMap;II)V", "run_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nSunshineRunOverlay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SunshineRunOverlay.kt\ncom/huachenjie/run/map/SunshineRunOverlay\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,88:1\n1#2:89\n1549#3:90\n1620#3,3:91\n*S KotlinDebug\n*F\n+ 1 SunshineRunOverlay.kt\ncom/huachenjie/run/map/SunshineRunOverlay\n*L\n34#1:90\n34#1:91,3\n*E\n"})
public final class dw8 extends RouteOverlay {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f41296a = 5000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final a f16159a = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Runnable followTask;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @Nullable
    public HCJLatLng lastPoint;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final String routeColorHex;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final float routeWidthDp;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/zj/adlib/dw8$a;", "", "", "FOLLOW_INTERVAL_MS", "J", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dw8(@NotNull Context context, @Nullable HCJMap<?, ?> hCJMap, int i, int i2) {
        super(context, hCJMap, i, i2 != 30);
        Intrinsics.checkNotNullParameter(context, "context");
        this.routeWidthDp = 4.0f;
        this.routeColorHex = xj7.f20670a;
        this.followTask = new Runnable() { // from class: com.zj.adlib.cw8
            @Override // java.lang.Runnable
            public final void run() {
                dw8.s0(this.f41055a);
            }
        };
        y0();
    }

    public static final void s0(dw8 dw8Var) {
        Intrinsics.checkNotNullParameter(dw8Var, "this$0");
        dw8Var.t0(dw8Var.lastPoint);
    }

    @Override // com.huachenjie.run.map.RouteOverlay
    public void N(@Nullable HCJLatLng point, int padding) {
        super.N(point, padding);
        this.lastPoint = point;
    }

    @Override // com.huachenjie.run.map.RouteOverlay
    @NotNull
    public String getRouteColorHex() {
        return this.routeColorHex;
    }

    @Override // com.huachenjie.run.map.RouteOverlay
    public float getRouteWidthDp() {
        return this.routeWidthDp;
    }

    public final void r0(@Nullable HCJLatLng target, int padding) {
        HCJMap<?, ?> map = getMap();
        if (map == null) {
            return;
        }
        getMainHandler().removeCallbacks(this.followTask);
        CaocaoLatLngBounds.Builder builderCreateLatLngBoundsBuilder = getMapAdapter().createLatLngBoundsBuilder();
        HCJLatLng hCJLatLng = this.lastPoint;
        if (hCJLatLng != null) {
            if (!xj7.a(hCJLatLng)) {
                hCJLatLng = null;
            }
            if (hCJLatLng != null) {
                Intrinsics.checkNotNullExpressionValue(builderCreateLatLngBoundsBuilder, "fitApproachingPoint$lambda$8");
                builderCreateLatLngBoundsBuilder.include(hCJLatLng);
            }
        }
        if (target != null) {
            if (!xj7.a(target)) {
                target = null;
            }
            if (target != null) {
                Intrinsics.checkNotNullExpressionValue(builderCreateLatLngBoundsBuilder, "fitApproachingPoint$lambda$8");
                builderCreateLatLngBoundsBuilder.include(target);
            }
        }
        CaocaoLatLngBounds caocaoLatLngBoundsBuild = builderCreateLatLngBoundsBuilder.build();
        if (caocaoLatLngBoundsBuild != null) {
            map.animateCamera(getMapAdapter().createCameraUpdateFactoryOption().newLatLngBounds(caocaoLatLngBoundsBuild, padding));
        }
    }

    public final void t0(HCJLatLng point) {
        HCJMap<?, ?> map;
        if (point != null) {
            if (!xj7.a(point)) {
                point = null;
            }
            if (point != null && (map = getMap()) != null) {
                map.animateCamera(getMapAdapter().createCameraUpdateFactoryOption().changeLatLng(point));
            }
        }
        y0();
    }

    public final void u0(int padding) {
        getMainHandler().removeCallbacks(this.followTask);
        N(this.lastPoint, padding);
        y0();
    }

    public final void v0() {
        getMainHandler().removeCallbacks(this.followTask);
    }

    public final void w0() {
        y0();
    }

    public final void x0() {
        getMainHandler().removeCallbacks(this.followTask);
        getMainHandler().post(this.followTask);
    }

    public final void y0() {
        getMainHandler().removeCallbacks(this.followTask);
        getMainHandler().postDelayed(this.followTask, 5000L);
    }

    public final void z0(@Nullable List<? extends RunLatLng> path) {
        Object obj;
        if (path != null) {
            if (!(getMap() != null)) {
                path = null;
            }
            if (path == null) {
                return;
            }
            try {
                Result.Companion companion = Result.Companion;
                List<? extends RunLatLng> list = path;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (RunLatLng runLatLng : list) {
                    arrayList.add(new HCJLatLng(runLatLng.lat, runLatLng.lng));
                }
                this.lastPoint = (HCJLatLng) CollectionsKt.lastOrNull(arrayList);
                setRoute(arrayList);
                obj = Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            Throwable th2 = Result.exceptionOrNull-impl(obj);
            if (th2 != null) {
                th2.printStackTrace();
            }
        }
    }
}
