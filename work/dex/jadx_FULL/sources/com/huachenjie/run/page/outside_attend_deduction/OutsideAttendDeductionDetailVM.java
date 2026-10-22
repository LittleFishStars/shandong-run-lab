package com.huachenjie.run.page.outside_attend_deduction;

import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R%\u0010\u0019\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u00150\u00068\u0006¢\u0006\f\n\u0004\b\u0017\u0010\t\u001a\u0004\b\u0018\u0010\u000bR%\u0010\u001c\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u00150\u00068\u0006¢\u0006\f\n\u0004\b\u001a\u0010\t\u001a\u0004\b\u001b\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/run/page/outside_attend_deduction/OutsideAttendDeductionDetailVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "p", "n", j.b, "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/run/page/outside_attend_deduction/OutsideAttendDeductionDetailAdapter;", "b", "Landroidx/lifecycle/MutableLiveData;", "j", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "", "K", "I", "k", "()I", "q", "(I)V", "pageNum", "", "kotlin.jvm.PlatformType", "c", "m", "semesterCode", "d", t.d, "runPlanCode", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
public final class OutsideAttendDeductionDetailVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<OutsideAttendDeductionDetailAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pageNum = 1;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> semesterCode = new MutableLiveData<>("");

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> runPlanCode = new MutableLiveData<>("");

    @NotNull
    public final MutableLiveData<OutsideAttendDeductionDetailAdapter> j() {
        return this.adapter;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    @NotNull
    public final MutableLiveData<String> l() {
        return this.runPlanCode;
    }

    @NotNull
    public final MutableLiveData<String> m() {
        return this.semesterCode;
    }

    public final void n() {
        this.pageNum++;
        o();
    }

    public final void o() {
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.run.page.outside_attend_deduction.OutsideAttendDeductionDetailVM$queryPageList$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                BaseLoadMoreModule loadMoreModule;
                Intrinsics.checkNotNullParameter(resultException, o.f);
                if (this.this$0.getPageNum() == 1) {
                    OutsideAttendDeductionDetailAdapter value = this.this$0.j().getValue();
                    if (value != null) {
                        value.h();
                    }
                    OutsideAttendDeductionDetailAdapter value2 = this.this$0.j().getValue();
                    if (value2 != null) {
                        value2.setList(null);
                    }
                } else {
                    OutsideAttendDeductionDetailVM outsideAttendDeductionDetailVM = this.this$0;
                    outsideAttendDeductionDetailVM.q(outsideAttendDeductionDetailVM.getPageNum() - 1);
                }
                OutsideAttendDeductionDetailAdapter value3 = this.this$0.j().getValue();
                if (value3 != null && (loadMoreModule = value3.getLoadMoreModule()) != null) {
                    BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
                }
                return Boolean.FALSE;
            }
        }, null, new OutsideAttendDeductionDetailVM$queryPageList$2(this, null), 11, null);
    }

    public final void p() {
        this.pageNum = 1;
        o();
    }

    public final void q(int i) {
        this.pageNum = i;
    }
}
