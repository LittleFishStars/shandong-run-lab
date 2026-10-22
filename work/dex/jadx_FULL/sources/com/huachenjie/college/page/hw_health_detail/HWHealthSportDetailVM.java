package com.huachenjie.college.page.hw_health_detail;

import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.college.bean.HWHealthSportDetailBean;
import com.huachenjie.college.bean.HuaweiHealthDeductionOptionBean;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR#\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\t8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000eR%\u0010\u0019\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u00150\t8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0018\u0010\u000eR%\u0010\u001c\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u00150\t8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/college/page/hw_health_detail/HWHealthSportDetailVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", HWHealthSportDetailActivity.x, "", "k", "j", "dedPlanCode", "p", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/college/bean/HWHealthSportDetailBean;", "b", "Landroidx/lifecycle/MutableLiveData;", j.b, "()Landroidx/lifecycle/MutableLiveData;", "detailData", "", "Lcom/huachenjie/college/bean/HuaweiHealthDeductionOptionBean;", "c", "m", "deductionOptions", "", "kotlin.jvm.PlatformType", "d", "n", "deductionSubmitSuccess", "e", t.d, "deducting", "<init>", "()V", "college_release"}, k = 1, mv = {1, 8, 0})
public final class HWHealthSportDetailVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<HWHealthSportDetailBean> detailData = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<HuaweiHealthDeductionOptionBean>> deductionOptions = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> deductionSubmitSuccess;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> deducting;

    public HWHealthSportDetailVM() {
        Boolean bool = Boolean.FALSE;
        this.deductionSubmitSuccess = new MutableLiveData<>(bool);
        this.deducting = new MutableLiveData<>(bool);
    }

    public final void j(@NotNull String sportRecordCode) {
        Intrinsics.checkNotNullParameter(sportRecordCode, HWHealthSportDetailActivity.x);
        Boolean value = this.deducting.getValue();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(value, bool)) {
            return;
        }
        this.deducting.setValue(bool);
        BaseViewModelExtKt.b(this, true, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.college.page.hw_health_detail.HWHealthSportDetailVM$deductSunshineRun$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                MutableLiveData<Boolean> mutableLiveDataL = this.this$0.l();
                Boolean bool2 = Boolean.FALSE;
                mutableLiveDataL.setValue(bool2);
                return bool2;
            }
        }, null, new HWHealthSportDetailVM$deductSunshineRun$2(this, sportRecordCode, null), 10, null);
    }

    public final void k(@NotNull String sportRecordCode) {
        Intrinsics.checkNotNullParameter(sportRecordCode, HWHealthSportDetailActivity.x);
        BaseViewModelExtKt.b(this, false, false, null, null, new HWHealthSportDetailVM$fetchSportRecordDetail$1(sportRecordCode, this, null), 15, null);
    }

    @NotNull
    public final MutableLiveData<Boolean> l() {
        return this.deducting;
    }

    @NotNull
    public final MutableLiveData<List<HuaweiHealthDeductionOptionBean>> m() {
        return this.deductionOptions;
    }

    @NotNull
    public final MutableLiveData<Boolean> n() {
        return this.deductionSubmitSuccess;
    }

    @NotNull
    public final MutableLiveData<HWHealthSportDetailBean> o() {
        return this.detailData;
    }

    public final void p(@NotNull String sportRecordCode, @NotNull String dedPlanCode) {
        Intrinsics.checkNotNullParameter(sportRecordCode, HWHealthSportDetailActivity.x);
        Intrinsics.checkNotNullParameter(dedPlanCode, "dedPlanCode");
        Boolean value = this.deducting.getValue();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(value, bool)) {
            return;
        }
        this.deducting.setValue(bool);
        BaseViewModelExtKt.b(this, true, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.college.page.hw_health_detail.HWHealthSportDetailVM$submitDeductionPlan$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                MutableLiveData<Boolean> mutableLiveDataL = this.this$0.l();
                Boolean bool2 = Boolean.FALSE;
                mutableLiveDataL.setValue(bool2);
                return bool2;
            }
        }, null, new HWHealthSportDetailVM$submitDeductionPlan$2(sportRecordCode, dedPlanCode, this, null), 10, null);
    }
}
