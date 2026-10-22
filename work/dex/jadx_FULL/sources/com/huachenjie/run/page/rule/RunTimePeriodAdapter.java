package com.huachenjie.run.page.rule;

import androidx.coroutines.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.common.bean.RunTimeAreaData;
import com.huachenjie.run.R;
import com.huachenjie.run.databinding.RunItemRunTimePeriodBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\n"}, d2 = {"Lcom/huachenjie/run/page/rule/RunTimePeriodAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/common/bean/RunTimeAreaData;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/run/databinding/RunItemRunTimePeriodBinding;", "()V", "convert", "", "helper", "item", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RunTimePeriodAdapter extends BaseQuickAdapter<RunTimeAreaData, BaseDataBindingHolder<RunItemRunTimePeriodBinding>> {
    /* JADX WARN: Illegal instructions before constructor call */
    public RunTimePeriodAdapter() {
        List list = null;
        super(R.layout.run_item_run_time_period, list, 2, list);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<RunItemRunTimePeriodBinding> helper, @Nullable RunTimeAreaData item) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        if (helper.getDataBinding() == null) {
            return;
        }
        ViewDataBinding dataBinding = helper.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.huachenjie.run.databinding.RunItemRunTimePeriodBinding");
        ((RunItemRunTimePeriodBinding) dataBinding).f11975a.bindData(item);
    }
}
