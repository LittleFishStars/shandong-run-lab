package com.zj.adlib;

import android.content.Context;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.huachenjie.common.bean.TargetPoints;
import com.huachenjie.run.bean.RunDetailEntity;
import com.huachenjie.run.bean.RunDetailFaceCheckInfoBean;
import com.huachenjie.run.map.RouteOverlay;
import huachenjie.sdk.map.adapter.map.HCJMap;
import huachenjie.sdk.map.adapter.map.model.CaocaoMarker;
import huachenjie.sdk.map.adapter.map.model.CaocaoPolyline;
import huachenjie.sdk.map.lib_base.HCJLatLng;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 !2\u00020\u0001:\u0001!B!\u0012\u0006\u0010*\u001a\u00020)\u0012\u0010\u0010,\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010+¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002R\u001a\u0010\u0012\u001a\u00020\r8\u0014X\u0094D¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\u00138\u0014X\u0094D¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R \u0010\u001c\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010\u001eR\u0014\u0010(\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010'¨\u0006/"}, d2 = {"Lcom/zj/adlib/bm7;", "Lcom/huachenjie/run/map/RouteOverlay;", "Lcom/huachenjie/run/bean/RunDetailEntity;", AliyunLogCommon.SubModule.RECORD, "", "v0", "w0", "h0", "r0", "s0", "", "index", "t0", "", "e", "F", "getRouteWidthDp", "()F", "routeWidthDp", "", "d", "Ljava/lang/String;", "getRouteColorHex", "()Ljava/lang/String;", "routeColorHex", "Lhuachenjie/sdk/map/adapter/map/model/CaocaoPolyline;", "b", "Lhuachenjie/sdk/map/adapter/map/model/CaocaoPolyline;", "replayPolyline", "i", "I", "replayIndex", "", "a", "J", "replayInterval", "j", "stepSize", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "replayTask", "Landroid/content/Context;", "context", "Lhuachenjie/sdk/map/adapter/map/HCJMap;", "map", "<init>", "(Landroid/content/Context;Lhuachenjie/sdk/map/adapter/map/HCJMap;)V", "run_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nRunDetailRouteOverlay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RunDetailRouteOverlay.kt\ncom/huachenjie/run/map/RunDetailRouteOverlay\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,127:1\n1#2:128\n1855#3,2:129\n766#3:131\n857#3,2:132\n1549#3:134\n1620#3,3:135\n*S KotlinDebug\n*F\n+ 1 RunDetailRouteOverlay.kt\ncom/huachenjie/run/map/RunDetailRouteOverlay\n*L\n57#1:129,2\n77#1:131\n77#1:132,2\n78#1:134\n78#1:135,3\n*E\n"})
public final class bm7 extends RouteOverlay {
    public static final long b = 5000;
    public static final long c = 17;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public long replayInterval;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Runnable replayTask;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public CaocaoPolyline<?, ?> replayPolyline;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final String routeColorHex;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final float routeWidthDp;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public int replayIndex;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public int stepSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bm7(@NotNull Context context, @Nullable HCJMap<?, ?> hCJMap) {
        super(context, hCJMap, 0, false, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.routeWidthDp = 4.0f;
        this.routeColorHex = xj7.f20670a;
        this.replayInterval = 17L;
        this.replayTask = new Runnable() { // from class: com.zj.adlib.am7
            @Override // java.lang.Runnable
            public final void run() {
                bm7.u0(this.f40556a);
            }
        };
    }

    public static final void u0(bm7 bm7Var) {
        Intrinsics.checkNotNullParameter(bm7Var, "this$0");
        bm7Var.t0(bm7Var.replayIndex);
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

    @Override // com.huachenjie.run.map.RouteOverlay
    public void h0() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            super.h0();
            this.replayPolyline = null;
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

    public final void r0(RunDetailEntity record) {
        int clockMode = record.getClockMode();
        List<TargetPoints> targetPoints = record.getTargetPoints();
        if (targetPoints == null) {
            targetPoints = CollectionsKt.emptyList();
        }
        for (TargetPoints targetPoints2 : targetPoints) {
            HCJLatLng hCJLatLng = new HCJLatLng(targetPoints2.getLat(), targetPoints2.getLng());
            if (clockMode == 1) {
                int type = targetPoints2.getType();
                if (type == 1) {
                    t(hCJLatLng, targetPoints2.getPassStatus(), null, targetPoints2.getNfcEnable());
                } else if (type == 2) {
                    z(hCJLatLng, targetPoints2.getPassStatus(), null, targetPoints2.getNfcEnable());
                }
            } else if (clockMode == 2 || clockMode == 3) {
                o(hCJLatLng, targetPoints2.getPassStatus(), targetPoints2.getSort(), null, targetPoints2.getNfcEnable());
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0040  */
    public final void s0(RunDetailEntity record) {
        boolean z;
        List<RunDetailFaceCheckInfoBean> faceCheckInfoList = record.getFaceCheckInfoList();
        if (faceCheckInfoList == null) {
            faceCheckInfoList = CollectionsKt.emptyList();
        }
        ArrayList<RunDetailFaceCheckInfoBean> arrayList = new ArrayList();
        Iterator<T> it = faceCheckInfoList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            RunDetailFaceCheckInfoBean runDetailFaceCheckInfoBean = (RunDetailFaceCheckInfoBean) next;
            if (!(runDetailFaceCheckInfoBean.getCheckLat() == 0.0f)) {
                z = (runDetailFaceCheckInfoBean.getCheckLng() > 0.0f ? 1 : (runDetailFaceCheckInfoBean.getCheckLng() == 0.0f ? 0 : -1)) == 0 ? false : true;
            }
            if (z) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        for (RunDetailFaceCheckInfoBean runDetailFaceCheckInfoBean2 : arrayList) {
            arrayList2.add(TuplesKt.to(Boolean.valueOf(runDetailFaceCheckInfoBean2.isRunFaceUpload()), new HCJLatLng(runDetailFaceCheckInfoBean2.getCheckLat(), runDetailFaceCheckInfoBean2.getCheckLng())));
        }
        if (!(!arrayList2.isEmpty())) {
            arrayList2 = null;
        }
        if (arrayList2 != null) {
            l(arrayList2);
        }
    }

    public final void t0(int index) {
        List<HCJLatLng> routePoints = getRoutePoints();
        if (routePoints != null) {
            if (!(!routePoints.isEmpty())) {
                routePoints = null;
            }
            if (routePoints == null || getMap() == null || this.stepSize == 0) {
                return;
            }
            if (index >= 0 && index < routePoints.size()) {
                if (this.replayPolyline == null) {
                    this.replayPolyline = addPolyline(newRoutePolylineOptions());
                }
                int i = index + this.stepSize;
                int iCoerceAtMost = RangesKt.coerceAtMost(i, routePoints.size());
                CaocaoPolyline<?, ?> caocaoPolyline = this.replayPolyline;
                if (caocaoPolyline != null) {
                    caocaoPolyline.setPoints(routePoints.subList(0, iCoerceAtMost));
                }
                if (i >= routePoints.size()) {
                    this.replayIndex = 0;
                } else {
                    this.replayIndex = i;
                    getMainHandler().postDelayed(this.replayTask, this.replayInterval);
                }
            }
        }
    }

    public final void v0(@Nullable RunDetailEntity record) {
        Object obj;
        List<HCJLatLng> pois;
        try {
            Result.Companion companion = Result.Companion;
            if (record == null || (pois = record.getPois()) == null) {
                return;
            }
            if (!(!pois.isEmpty())) {
                pois = null;
            }
            if (pois == null || getMap() == null) {
                return;
            }
            CaocaoMarker<?, ?> startMarker = getStartMarker();
            if (startMarker != null) {
                startMarker.remove();
            }
            CaocaoMarker<?, ?> endMarker = getEndMarker();
            if (endMarker != null) {
                endMarker.remove();
            }
            setStartMarker(null);
            setEndMarker(null);
            setRoute(pois);
            if (pois.size() > 1) {
                setStartPoint((HCJLatLng) CollectionsKt.first(pois));
                setEndPoint((HCJLatLng) CollectionsKt.last(pois));
                B();
            }
            r0(record);
            s0(record);
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

    public final void w0() {
        List<HCJLatLng> routePoints = getRoutePoints();
        if (routePoints != null) {
            if (!(!routePoints.isEmpty())) {
                routePoints = null;
            }
            if (routePoints == null) {
                return;
            }
            CaocaoPolyline<?, ?> routePolyline = getRoutePolyline();
            if (routePolyline != null) {
                routePolyline.setPoints(new ArrayList());
            }
            CaocaoPolyline<?, ?> caocaoPolyline = this.replayPolyline;
            if (caocaoPolyline != null) {
                caocaoPolyline.setPoints(new ArrayList());
            }
            long jCoerceAtLeast = RangesKt.coerceAtLeast(MathKt.roundToLong(5000.0d / ((double) routePoints.size())), 1L);
            if (17 / jCoerceAtLeast != 0) {
                jCoerceAtLeast = 17;
            }
            this.replayInterval = jCoerceAtLeast;
            this.stepSize = MathKt.roundToInt(((double) routePoints.size()) / RangesKt.coerceAtLeast(MathKt.roundToLong(5000.0d / jCoerceAtLeast), 1L));
            this.replayIndex = 0;
            getMainHandler().removeCallbacks(this.replayTask);
            getMainHandler().post(this.replayTask);
        }
    }
}
