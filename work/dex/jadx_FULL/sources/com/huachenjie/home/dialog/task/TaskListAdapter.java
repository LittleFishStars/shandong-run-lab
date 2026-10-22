package com.huachenjie.home.dialog.task;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.home.R;
import com.huachenjie.home.bean.DailyTasksBean;
import com.huachenjie.home.databinding.HomeItemTaskListBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¨\u0006\n"}, d2 = {"Lcom/huachenjie/home/dialog/task/TaskListAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/home/bean/DailyTasksBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/home/databinding/HomeItemTaskListBinding;", "()V", "convert", "", "holder", "item", "home_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TaskListAdapter extends BaseQuickAdapter<DailyTasksBean, BaseDataBindingHolder<HomeItemTaskListBinding>> {
    public TaskListAdapter() {
        super(R.layout.home_item_task_list, null, 2, null);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<HomeItemTaskListBinding> holder, @NotNull DailyTasksBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        HomeItemTaskListBinding homeItemTaskListBinding = (HomeItemTaskListBinding) holder.getDataBinding();
        if (homeItemTaskListBinding != null) {
            homeItemTaskListBinding.k(item);
            homeItemTaskListBinding.executePendingBindings();
        }
    }
}
