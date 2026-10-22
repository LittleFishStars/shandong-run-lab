package com.huachenjie.works.adapter.search;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.works.R;
import com.huachenjie.works.databinding.WorksItemSearchFastLenovoBinding;
import com.zj.adlib.qk0;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¨\u0006\n"}, d2 = {"Lcom/huachenjie/works/adapter/search/SearchFastLenovoAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/works/databinding/WorksItemSearchFastLenovoBinding;", "()V", "convert", "", "holder", "item", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SearchFastLenovoAdapter extends BaseQuickAdapter<String, BaseDataBindingHolder<WorksItemSearchFastLenovoBinding>> {
    /* JADX WARN: Illegal instructions before constructor call */
    public SearchFastLenovoAdapter() {
        List list = null;
        super(R.layout.works_item_search_fast_lenovo, list, 2, list);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<WorksItemSearchFastLenovoBinding> holder, @NotNull String item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        WorksItemSearchFastLenovoBinding worksItemSearchFastLenovoBinding = (WorksItemSearchFastLenovoBinding) holder.getDataBinding();
        if (worksItemSearchFastLenovoBinding != null) {
            worksItemSearchFastLenovoBinding.setVariable(qk0.g, item);
            worksItemSearchFastLenovoBinding.executePendingBindings();
        }
    }
}
