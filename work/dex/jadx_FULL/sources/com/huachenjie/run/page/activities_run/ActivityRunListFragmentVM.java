package com.huachenjie.run.page.activities_run;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/run/page/activities_run/ActivityRunListFragmentVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "currentSemester", "", "j", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/run/page/activities_run/ActivityRunListAdapter;", "a", "Landroidx/lifecycle/MutableLiveData;", "i", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
public final class ActivityRunListFragmentVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<ActivityRunListAdapter> adapter = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<ActivityRunListAdapter> i() {
        return this.adapter;
    }

    public final void j(boolean currentSemester) {
        BaseViewModelExtKt.b(this, true, false, null, null, new ActivityRunListFragmentVM$queryList$1(currentSemester, this, null), 14, null);
    }
}
