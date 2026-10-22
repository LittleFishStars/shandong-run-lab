package com.huachenjie.works.adapter;

import android.view.LayoutInflater;
import android.view.View;
import androidx.coroutines.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.works.R;
import com.huachenjie.works.adapter.publish.BasePubWorkMenuAdapter;
import com.huachenjie.works.bean.MultipleActivityBean;
import com.huachenjie.works.databinding.WorksHeadActivityListBinding;
import com.huachenjie.works.databinding.WorksItemActivityListBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/huachenjie/works/adapter/ActivityListAdapter;", "Lcom/huachenjie/works/adapter/publish/BasePubWorkMenuAdapter;", "Lcom/huachenjie/works/bean/MultipleActivityBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/works/databinding/WorksItemActivityListBinding;", "()V", "convert", "", "holder", "item", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ActivityListAdapter extends BasePubWorkMenuAdapter<MultipleActivityBean, BaseDataBindingHolder<WorksItemActivityListBinding>> {
    public ActivityListAdapter() {
        super(R.layout.works_item_activity_list);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        View root = ((WorksHeadActivityListBinding) DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.works_head_activity_list, recyclerView, false)).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "inflate<WorksHeadActivit… false\n            ).root");
        BaseQuickAdapter.setHeaderView$default(this, root, 0, 0, 6, null);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<WorksItemActivityListBinding> holder, @NotNull MultipleActivityBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        WorksItemActivityListBinding worksItemActivityListBinding = (WorksItemActivityListBinding) holder.getDataBinding();
        if (worksItemActivityListBinding != null) {
            worksItemActivityListBinding.k(item);
            worksItemActivityListBinding.executePendingBindings();
        }
    }
}
