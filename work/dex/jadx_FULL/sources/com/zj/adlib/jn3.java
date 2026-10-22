package com.zj.adlib;

import android.content.Context;
import com.huachenjie.run.map.RouteOverlay;
import huachenjie.sdk.map.adapter.map.HCJMap;
import huachenjie.sdk.map.lib_base.HCJLatLng;
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
@Metadata(d1 = {"\u0000/\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\r\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB!\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0010\u0010\u0014\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0005J\b\u0010\t\u001a\u00020\u0005H\u0002R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/zj/adlib/jn3;", "Lcom/huachenjie/run/map/RouteOverlay;", "", "Lhuachenjie/sdk/map/lib_base/HCJLatLng;", "path", "", "v0", "s0", "t0", "u0", "c", "Lhuachenjie/sdk/map/lib_base/HCJLatLng;", "lastPoint", "com/zj/adlib/jn3$b", "a", "Lcom/zj/adlib/jn3$b;", "followTask", "Landroid/content/Context;", "context", "Lhuachenjie/sdk/map/adapter/map/HCJMap;", "map", "<init>", "(Landroid/content/Context;Lhuachenjie/sdk/map/adapter/map/HCJMap;)V", "run_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nFreeRunOverlay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FreeRunOverlay.kt\ncom/huachenjie/run/map/FreeRunOverlay\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,50:1\n1#2:51\n*E\n"})
public final class jn3 extends RouteOverlay {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f42622a = 10000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final a f17437a = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final b followTask;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @Nullable
    public HCJLatLng lastPoint;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/zj/adlib/jn3$a;", "", "", "FOLLOW_INTERVAL_MS", "J", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/zj/adlib/jn3$b", "Ljava/lang/Runnable;", "", "run", "run_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nFreeRunOverlay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FreeRunOverlay.kt\ncom/huachenjie/run/map/FreeRunOverlay$followTask$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,50:1\n1#2:51\n*E\n"})
    public static final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HCJLatLng hCJLatLng = jn3.this.lastPoint;
            if (hCJLatLng != null) {
                if (!xj7.a(hCJLatLng)) {
                    hCJLatLng = null;
                }
                HCJLatLng hCJLatLng2 = hCJLatLng;
                if (hCJLatLng2 != null) {
                    RouteOverlay.p0(jn3.this, hCJLatLng2, 18.0f, false, 4, null);
                }
            }
            jn3.this.u0();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jn3(@NotNull Context context, @Nullable HCJMap<?, ?> hCJMap) {
        super(context, hCJMap, 0, false, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.followTask = new b();
        u0();
    }

    public final void s0() {
        getMainHandler().removeCallbacks(this.followTask);
    }

    public final void t0() {
        u0();
    }

    public final void u0() {
        getMainHandler().removeCallbacks(this.followTask);
        getMainHandler().postDelayed(this.followTask, 10000L);
    }

    public final void v0(@Nullable List<? extends HCJLatLng> path) {
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
                this.lastPoint = (HCJLatLng) CollectionsKt.lastOrNull(path);
                setRoute(path);
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
