package com.huachenjie.run.page.run_reward;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/run/page/run_reward/RunRewardListVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "semesterCode", "runPlanCode", "", "type", "", t.d, "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/run/page/run_reward/RunRewardListAdapter;", "a", "Landroidx/lifecycle/MutableLiveData;", "k", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "K", "I", "pageNum", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
public final class RunRewardListVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<RunRewardListAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pageNum = 1;

    @NotNull
    public final MutableLiveData<RunRewardListAdapter> k() {
        return this.adapter;
    }

    public final void l(@NotNull String semesterCode, @NotNull String runPlanCode, int type) {
        Intrinsics.checkNotNullParameter(semesterCode, "semesterCode");
        Intrinsics.checkNotNullParameter(runPlanCode, "runPlanCode");
        BaseViewModelExtKt.b(this, this.pageNum == 1, false, null, null, new RunRewardListVM$loadData$1(this, semesterCode, runPlanCode, type, null), 14, null);
    }
}
