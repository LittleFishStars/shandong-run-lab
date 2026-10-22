package com.huachenjie.run.page.activities_run;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.common.bean.ActivityRunRule;
import com.huachenjie.run.R;
import com.huachenjie.run.databinding.RunItemActivityRuleBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¨\u0006\n"}, d2 = {"Lcom/huachenjie/run/page/activities_run/ActivityRuleAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/common/bean/ActivityRunRule;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/run/databinding/RunItemActivityRuleBinding;", "()V", "convert", "", "holder", "item", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ActivityRuleAdapter extends BaseQuickAdapter<ActivityRunRule, BaseDataBindingHolder<RunItemActivityRuleBinding>> {
    public ActivityRuleAdapter() {
        super(R.layout.run_item_activity_rule, null, 2, null);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<RunItemActivityRuleBinding> holder, @NotNull ActivityRunRule item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        RunItemActivityRuleBinding runItemActivityRuleBinding = (RunItemActivityRuleBinding) holder.getDataBinding();
        if (runItemActivityRuleBinding != null) {
            runItemActivityRuleBinding.k(item);
            runItemActivityRuleBinding.executePendingBindings();
        }
    }
}
