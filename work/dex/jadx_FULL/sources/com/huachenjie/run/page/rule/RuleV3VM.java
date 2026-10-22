package com.huachenjie.run.page.rule;

import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.RunTimeAreaData;
import com.huachenjie.common.bean.SchoolRule;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.y6b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010)R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R0\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\u000eR0\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\u000eR0\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\u000eR(\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\u000eR(\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0005\u001a\u0004\b\u001c\u0010\u0007\"\u0004\b\u001d\u0010\u000eR(\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00160\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0005\u001a\u0004\b\u001f\u0010\u0007\"\u0004\b \u0010\u000eR(\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\"\u0010\u000eR(\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00160\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b$\u0010\u000eR(\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b&\u0010\u000e¨\u0006*"}, d2 = {"Lcom/huachenjie/run/page/rule/RuleV3VM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/SchoolRule;", "i", "Landroidx/lifecycle/MutableLiveData;", t.d, "()Landroidx/lifecycle/MutableLiveData;", "mRule", "", "Lcom/huachenjie/common/bean/RunTimeAreaData;", "j", "k", "u", "(Landroidx/lifecycle/MutableLiveData;)V", "mEverydayGroup", "q", j.o, "mWorkdayGroup", "p", "y", "mWeekendGroup", "Lcom/huachenjie/run/page/rule/RunTimePeriodAdapter;", "m", "v", "mRunTimeEverydayAdp", "Lcom/google/android/flexbox/FlexboxLayoutManager;", "n", y6b.g, "r", "flexLayoutMgr01", j.b, "x", "mRunTimeWorkdayAdp", "s", "flexLayoutMgr02", "w", "mRunTimeWeekendAdp", "t", "flexLayoutMgr03", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
public class RuleV3VM extends BaseVM {

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<SchoolRule> mRule = new MutableLiveData<>();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<List<RunTimeAreaData>> mEverydayGroup = new MutableLiveData<>();

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<List<RunTimeAreaData>> mWorkdayGroup = new MutableLiveData<>();

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<List<RunTimeAreaData>> mWeekendGroup = new MutableLiveData<>();

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<RunTimePeriodAdapter> mRunTimeEverydayAdp = new MutableLiveData<>();

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<FlexboxLayoutManager> flexLayoutMgr01 = new MutableLiveData<>();

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<RunTimePeriodAdapter> mRunTimeWorkdayAdp = new MutableLiveData<>();

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<FlexboxLayoutManager> flexLayoutMgr02 = new MutableLiveData<>();

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<RunTimePeriodAdapter> mRunTimeWeekendAdp = new MutableLiveData<>();

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<FlexboxLayoutManager> flexLayoutMgr03 = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<FlexboxLayoutManager> h() {
        return this.flexLayoutMgr01;
    }

    @NotNull
    public final MutableLiveData<FlexboxLayoutManager> i() {
        return this.flexLayoutMgr02;
    }

    @NotNull
    public final MutableLiveData<FlexboxLayoutManager> j() {
        return this.flexLayoutMgr03;
    }

    @NotNull
    public final MutableLiveData<List<RunTimeAreaData>> k() {
        return this.mEverydayGroup;
    }

    @NotNull
    public final MutableLiveData<SchoolRule> l() {
        return this.mRule;
    }

    @NotNull
    public final MutableLiveData<RunTimePeriodAdapter> m() {
        return this.mRunTimeEverydayAdp;
    }

    @NotNull
    public final MutableLiveData<RunTimePeriodAdapter> n() {
        return this.mRunTimeWeekendAdp;
    }

    @NotNull
    public final MutableLiveData<RunTimePeriodAdapter> o() {
        return this.mRunTimeWorkdayAdp;
    }

    @NotNull
    public final MutableLiveData<List<RunTimeAreaData>> p() {
        return this.mWeekendGroup;
    }

    @NotNull
    public final MutableLiveData<List<RunTimeAreaData>> q() {
        return this.mWorkdayGroup;
    }

    public final void r(@NotNull MutableLiveData<FlexboxLayoutManager> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.flexLayoutMgr01 = mutableLiveData;
    }

    public final void s(@NotNull MutableLiveData<FlexboxLayoutManager> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.flexLayoutMgr02 = mutableLiveData;
    }

    public final void t(@NotNull MutableLiveData<FlexboxLayoutManager> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.flexLayoutMgr03 = mutableLiveData;
    }

    public final void u(@NotNull MutableLiveData<List<RunTimeAreaData>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.mEverydayGroup = mutableLiveData;
    }

    public final void v(@NotNull MutableLiveData<RunTimePeriodAdapter> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.mRunTimeEverydayAdp = mutableLiveData;
    }

    public final void w(@NotNull MutableLiveData<RunTimePeriodAdapter> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.mRunTimeWeekendAdp = mutableLiveData;
    }

    public final void x(@NotNull MutableLiveData<RunTimePeriodAdapter> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.mRunTimeWorkdayAdp = mutableLiveData;
    }

    public final void y(@NotNull MutableLiveData<List<RunTimeAreaData>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.mWeekendGroup = mutableLiveData;
    }

    public final void z(@NotNull MutableLiveData<List<RunTimeAreaData>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.mWorkdayGroup = mutableLiveData;
    }
}
