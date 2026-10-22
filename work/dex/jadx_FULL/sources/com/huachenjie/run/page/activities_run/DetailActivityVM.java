package com.huachenjie.run.page.activities_run;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.bean.ActivityRunDetailBean;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.run.page.sunshine_home.SunshineSchoolRuleVM;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00068\u0006¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00068\u0006¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00068\u0006¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0017\u0010\u000bR\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00068\u0006¢\u0006\f\n\u0004\b\u001a\u0010\t\u001a\u0004\b\u001b\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/run/page/activities_run/DetailActivityVM;", "Lcom/huachenjie/run/page/sunshine_home/SunshineSchoolRuleVM;", "", "sunRunActivityCode", "", "y", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/BindingTitleBean;", y6b.f, "Landroidx/lifecycle/MutableLiveData;", "x", "()Landroidx/lifecycle/MutableLiveData;", "titleBean", "Lcom/huachenjie/run/page/activities_run/ActivityRuleAdapter;", y6b.g, "v", "adapter", "Lcom/huachenjie/common/bean/ActivityRunDetailBean;", "i", "t", "activityRunDetail", "", "j", "u", "activityRunDisWrapper", "", "k", "w", "canStartActivityRun", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
public final class DetailActivityVM extends SunshineSchoolRuleVM {

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<BindingTitleBean> titleBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<ActivityRuleAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<ActivityRunDetailBean> activityRunDetail = new MutableLiveData<>();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Float> activityRunDisWrapper = new MutableLiveData<>();

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> canStartActivityRun = new MutableLiveData<>(Boolean.FALSE);

    @NotNull
    public final MutableLiveData<ActivityRunDetailBean> t() {
        return this.activityRunDetail;
    }

    @NotNull
    public final MutableLiveData<Float> u() {
        return this.activityRunDisWrapper;
    }

    @NotNull
    public final MutableLiveData<ActivityRuleAdapter> v() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<Boolean> w() {
        return this.canStartActivityRun;
    }

    @NotNull
    public final MutableLiveData<BindingTitleBean> x() {
        return this.titleBean;
    }

    public final void y(@NotNull String sunRunActivityCode) {
        Intrinsics.checkNotNullParameter(sunRunActivityCode, "sunRunActivityCode");
        BaseViewModelExtKt.b(this, false, false, null, null, new DetailActivityVM$queryActivityRunDetail$1(sunRunActivityCode, this, null), 15, null);
    }
}
