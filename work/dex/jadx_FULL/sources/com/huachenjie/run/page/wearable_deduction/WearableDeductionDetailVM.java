package com.huachenjie.run.page.wearable_deduction;

import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.run.bean.WearableDeductionSummaryBean;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00078\u0006¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R%\u0010\u001e\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u001a0\u001a0\u00078\u0006¢\u0006\f\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001d\u0010\f¨\u0006!"}, d2 = {"Lcom/huachenjie/run/page/wearable_deduction/WearableDeductionDetailVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "q", j.b, "n", "p", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/run/page/wearable_deduction/WearableDeductionDetailAdapter;", "b", "Landroidx/lifecycle/MutableLiveData;", "j", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "Lcom/huachenjie/run/bean/WearableDeductionSummaryBean;", "c", "m", "summary", "", "K", "I", "k", "()I", "r", "(I)V", "pageNum", "", "kotlin.jvm.PlatformType", "d", t.d, "runPlanCode", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
public final class WearableDeductionDetailVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<WearableDeductionDetailAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<WearableDeductionSummaryBean> summary = new MutableLiveData<>();

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pageNum = 1;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> runPlanCode = new MutableLiveData<>("");

    @NotNull
    public final MutableLiveData<WearableDeductionDetailAdapter> j() {
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
    public final MutableLiveData<WearableDeductionSummaryBean> m() {
        return this.summary;
    }

    public final void n() {
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.run.page.wearable_deduction.WearableDeductionDetailVM$loadSummary$1
            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                return Boolean.FALSE;
            }
        }, null, new WearableDeductionDetailVM$loadSummary$2(this, null), 11, null);
    }

    public final void o() {
        this.pageNum++;
        p();
    }

    public final void p() {
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.run.page.wearable_deduction.WearableDeductionDetailVM$queryPageList$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                BaseLoadMoreModule loadMoreModule;
                Intrinsics.checkNotNullParameter(resultException, o.f);
                if (this.this$0.getPageNum() == 1) {
                    WearableDeductionDetailAdapter value = this.this$0.j().getValue();
                    if (value != null) {
                        value.h();
                    }
                    WearableDeductionDetailAdapter value2 = this.this$0.j().getValue();
                    if (value2 != null) {
                        value2.setList(null);
                    }
                } else {
                    WearableDeductionDetailVM wearableDeductionDetailVM = this.this$0;
                    wearableDeductionDetailVM.r(wearableDeductionDetailVM.getPageNum() - 1);
                }
                WearableDeductionDetailAdapter value3 = this.this$0.j().getValue();
                if (value3 != null && (loadMoreModule = value3.getLoadMoreModule()) != null) {
                    BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
                }
                return Boolean.FALSE;
            }
        }, null, new WearableDeductionDetailVM$queryPageList$2(this, null), 11, null);
    }

    public final void q() {
        this.pageNum = 1;
        n();
        p();
    }

    public final void r(int i) {
        this.pageNum = i;
    }
}
