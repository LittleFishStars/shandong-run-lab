package com.huachenjie.works.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.WorksDetailMenuBean;
import com.huachenjie.works.databinding.WorksItemWorksDetailMenuBinding;
import com.zj.adlib.qk0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¨\u0006\n"}, d2 = {"Lcom/huachenjie/works/adapter/WorksDetailMenuAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/works/bean/WorksDetailMenuBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/works/databinding/WorksItemWorksDetailMenuBinding;", "()V", "convert", "", "holder", "item", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WorksDetailMenuAdapter extends BaseQuickAdapter<WorksDetailMenuBean, BaseDataBindingHolder<WorksItemWorksDetailMenuBinding>> {
    public WorksDetailMenuAdapter() {
        super(R.layout.works_item_works_detail_menu, null, 2, null);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<WorksItemWorksDetailMenuBinding> holder, @NotNull WorksDetailMenuBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        WorksItemWorksDetailMenuBinding worksItemWorksDetailMenuBinding = (WorksItemWorksDetailMenuBinding) holder.getDataBinding();
        if (worksItemWorksDetailMenuBinding != null) {
            worksItemWorksDetailMenuBinding.setVariable(qk0.g, item);
            worksItemWorksDetailMenuBinding.executePendingBindings();
        }
    }
}
