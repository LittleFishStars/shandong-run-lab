package com.huachenjie.run.page.activities_run;

import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.bean.GeoFenceDetail;
import com.huachenjie.run.page.activities_run.ActivityReadyVM;
import com.huachenjie.run.page.sunshine_home.SunshineSchoolRuleVM;
import com.zj.adlib.y6b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001f\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\tR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/run/page/activities_run/ActivityReadyVM;", "Lcom/huachenjie/run/page/sunshine_home/SunshineSchoolRuleVM;", "", "v", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/BindingTitleBean;", y6b.f, "Landroidx/lifecycle/MutableLiveData;", "y", "()Landroidx/lifecycle/MutableLiveData;", "titleBean", "Lcom/huachenjie/common/bean/GeoFenceDetail;", y6b.g, "w", "activityFence", "", "f", "Ljava/lang/String;", "x", "()Ljava/lang/String;", j.o, "(Ljava/lang/String;)V", "activityFenceCode", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nActivityReadyVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityReadyVM.kt\ncom/huachenjie/run/page/activities_run/ActivityReadyVM\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,36:1\n288#2,2:37\n*S KotlinDebug\n*F\n+ 1 ActivityReadyVM.kt\ncom/huachenjie/run/page/activities_run/ActivityReadyVM\n*L\n27#1:37,2\n*E\n"})
public final class ActivityReadyVM extends SunshineSchoolRuleVM {

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<BindingTitleBean> titleBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<GeoFenceDetail> activityFence = new MutableLiveData<>();

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public String activityFenceCode = "";

    public ActivityReadyVM() {
        setCompleteGeoFenceRunnable(new Runnable() { // from class: com.zj.adlib.xt
            @Override // java.lang.Runnable
            public final void run() {
                ActivityReadyVM.u(this.f45896a);
            }
        });
    }

    public static final void u(ActivityReadyVM activityReadyVM) {
        Intrinsics.checkNotNullParameter(activityReadyVM, "this$0");
        activityReadyVM.v();
    }

    public final void v() {
        List<GeoFenceDetail> value = l().getValue();
        Object obj = null;
        if (value != null) {
            for (Object obj2 : value) {
                if (Intrinsics.areEqual(((GeoFenceDetail) obj2).getFenceCode(), this.activityFenceCode)) {
                    obj = obj2;
                    break;
                }
            }
            obj = (GeoFenceDetail) obj;
        }
        if (obj == null) {
            return;
        }
        this.activityFence.setValue((GeoFenceDetail) obj);
    }

    @NotNull
    public final MutableLiveData<GeoFenceDetail> w() {
        return this.activityFence;
    }

    @NotNull
    /* JADX INFO: renamed from: x, reason: from getter */
    public final String getActivityFenceCode() {
        return this.activityFenceCode;
    }

    @NotNull
    public final MutableLiveData<BindingTitleBean> y() {
        return this.titleBean;
    }

    public final void z(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.activityFenceCode = str;
    }
}
