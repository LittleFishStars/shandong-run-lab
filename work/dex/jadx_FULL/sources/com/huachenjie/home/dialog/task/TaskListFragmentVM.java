package com.huachenjie.home.dialog.task;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.home.bean.DailyTasksBean;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR-\u0010\u0010\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r0\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/home/dialog/task/TaskListFragmentVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "k", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/home/dialog/task/TaskListAdapter;", "a", "Landroidx/lifecycle/MutableLiveData;", "i", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "Ljava/util/ArrayList;", "Lcom/huachenjie/home/bean/DailyTasksBean;", "Lkotlin/collections/ArrayList;", "b", "j", "taskList", "<init>", "()V", "home_release"}, k = 1, mv = {1, 8, 0})
public final class TaskListFragmentVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<TaskListAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<ArrayList<DailyTasksBean>> taskList = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<TaskListAdapter> i() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<ArrayList<DailyTasksBean>> j() {
        return this.taskList;
    }

    public final void k() {
        BaseViewModelExtKt.b(this, false, false, null, null, new TaskListFragmentVM$loadData$1(this, null), 15, null);
    }
}
