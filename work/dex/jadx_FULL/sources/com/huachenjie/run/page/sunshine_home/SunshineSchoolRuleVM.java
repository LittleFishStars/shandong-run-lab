package com.huachenjie.run.page.sunshine_home;

import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.bean.GeoFenceDetail;
import com.huachenjie.common.bean.SemesterBean;
import com.huachenjie.common.bean.SunshineRunDetail;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.run.bean.RunPlanBean;
import com.huachenjie.run.page.activities_run.ReadyActivity;
import com.kuaishou.weapon.p0.t;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b7\u00108J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0004R\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R%\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00060\u00060\f8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R#\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\f8\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011R\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\f8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011R\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\f8\u0006¢\u0006\f\n\u0004\b \u0010\u000f\u001a\u0004\b!\u0010\u0011R\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\f8\u0006¢\u0006\f\n\u0004\b$\u0010\u000f\u001a\u0004\b%\u0010\u0011R\"\u0010(\u001a\u00020\u00068\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010,\u001a\u00020\u00068\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010'\u001a\u0004\b,\u0010)\"\u0004\b-\u0010+R$\u00104\u001a\u0004\u0018\u00010.8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0011\u00106\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b5\u0010)¨\u00069"}, d2 = {"Lcom/huachenjie/run/page/sunshine_home/SunshineSchoolRuleVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "sportType", "", "r", "", "i", "", "schoolCode", "s", "j", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/SunshineRunDetail;", "a", "Landroidx/lifecycle/MutableLiveData;", "n", "()Landroidx/lifecycle/MutableLiveData;", ReadyActivity.y, "kotlin.jvm.PlatformType", "b", j.b, "isActivity", "", "Lcom/huachenjie/common/bean/GeoFenceDetail;", "c", t.d, "geoFenceListData", "d", "q", "isShowMorningCount", "Lcom/huachenjie/common/bean/SemesterBean;", "e", "m", "selectedSemester", "Lcom/huachenjie/run/bean/RunPlanBean;", "f", "k", ReadyActivity.x, "Z", "isRequestSunshineDetail", "()Z", "setRequestSunshineDetail", "(Z)V", "isRequestGeoFenceList", "setRequestGeoFenceList", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "getCompleteGeoFenceRunnable", "()Ljava/lang/Runnable;", "setCompleteGeoFenceRunnable", "(Ljava/lang/Runnable;)V", "completeGeoFenceRunnable", "p", "isCurrentSemester", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
public class SunshineSchoolRuleVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public Runnable completeGeoFenceRunnable;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean isRequestSunshineDetail;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    public boolean isRequestGeoFenceList;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<SunshineRunDetail> sunshineRunDetail = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isActivity = new MutableLiveData<>(Boolean.FALSE);

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<GeoFenceDetail>> geoFenceListData = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isShowMorningCount = new MutableLiveData<>();

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<SemesterBean> selectedSemester = new MutableLiveData<>();

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<RunPlanBean> currentRunPlan = new MutableLiveData<>();

    @Nullable
    public final Runnable getCompleteGeoFenceRunnable() {
        return this.completeGeoFenceRunnable;
    }

    public final boolean i(int sportType) {
        if (this.sunshineRunDetail.getValue() != null) {
            return false;
        }
        if (this.isRequestSunshineDetail) {
            return true;
        }
        r(sportType);
        return true;
    }

    /* JADX INFO: renamed from: isRequestGeoFenceList, reason: from getter */
    public final boolean getIsRequestGeoFenceList() {
        return this.isRequestGeoFenceList;
    }

    /* JADX INFO: renamed from: isRequestSunshineDetail, reason: from getter */
    public final boolean getIsRequestSunshineDetail() {
        return this.isRequestSunshineDetail;
    }

    public final void j() {
        BaseViewModelExtKt.b(this, false, false, null, null, new SunshineSchoolRuleVM$getCurrentActivity$1(this, null), 13, null);
    }

    @NotNull
    public final MutableLiveData<RunPlanBean> k() {
        return this.currentRunPlan;
    }

    @NotNull
    public final MutableLiveData<List<GeoFenceDetail>> l() {
        return this.geoFenceListData;
    }

    @NotNull
    public final MutableLiveData<SemesterBean> m() {
        return this.selectedSemester;
    }

    @NotNull
    public final MutableLiveData<SunshineRunDetail> n() {
        return this.sunshineRunDetail;
    }

    @NotNull
    public final MutableLiveData<Boolean> o() {
        return this.isActivity;
    }

    public final boolean p() {
        if (this.selectedSemester.getValue() == null) {
            return true;
        }
        SemesterBean value = this.selectedSemester.getValue();
        return value != null && value.getStatus() == 1;
    }

    @NotNull
    public final MutableLiveData<Boolean> q() {
        return this.isShowMorningCount;
    }

    public void r(int sportType) {
        this.isRequestSunshineDetail = true;
        SemesterBean value = this.selectedSemester.getValue();
        String semesterCode = value != null ? value.getSemesterCode() : null;
        String str = semesterCode == null ? "" : semesterCode;
        RunPlanBean value2 = this.currentRunPlan.getValue();
        String runPlanCode = value2 != null ? value2.getRunPlanCode() : null;
        BaseViewModelExtKt.b(this, false, false, null, null, new SunshineSchoolRuleVM$queryRunDetail$1(str, runPlanCode == null ? "" : runPlanCode, sportType, this, null), 15, null);
    }

    public final void s(@NotNull String schoolCode) {
        Intrinsics.checkNotNullParameter(schoolCode, "schoolCode");
        this.isRequestGeoFenceList = true;
        BaseViewModelExtKt.b(this, true, false, null, null, new SunshineSchoolRuleVM$querySchoolFences$1(this, schoolCode, null), 14, null);
    }

    public final void setCompleteGeoFenceRunnable(@Nullable Runnable runnable) {
        this.completeGeoFenceRunnable = runnable;
    }

    public final void setRequestGeoFenceList(boolean z) {
        this.isRequestGeoFenceList = z;
    }

    public final void setRequestSunshineDetail(boolean z) {
        this.isRequestSunshineDetail = z;
    }
}
