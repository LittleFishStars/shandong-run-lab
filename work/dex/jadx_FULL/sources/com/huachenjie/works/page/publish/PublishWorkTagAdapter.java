package com.huachenjie.works.page.publish;

import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.WorksTagBean;
import com.huachenjie.works.databinding.WorksItemPulishWorkTagBinding;
import com.huachenjie.works.page.publish.PublishWorkTagAdapter;
import com.zj.adlib.y6b;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J \u0010\r\u001a\u00020\u00072\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000bJ\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u0016\u0010\u0016\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/works/page/publish/PublishWorkTagAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/works/bean/WorksTagBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/works/databinding/WorksItemPulishWorkTagBinding;", "holder", "item", "", "convert", "", GoodsSpecificationPreviewActivity.z, "", "defaultIndex", y6b.f, "index", "j", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "onDetachedFromRecyclerView", "K", "I", "selIndex", "b", "Landroidx/recyclerview/widget/RecyclerView;", "rvList", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class PublishWorkTagAdapter extends BaseQuickAdapter<WorksTagBean, BaseDataBindingHolder<WorksItemPulishWorkTagBinding>> {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int selIndex;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @Nullable
    public RecyclerView rvList;

    public PublishWorkTagAdapter() {
        super(R.layout.works_item_pulish_work_tag, null, 2, null);
        this.selIndex = -1;
    }

    public static /* synthetic */ void h(PublishWorkTagAdapter publishWorkTagAdapter, Collection collection, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        publishWorkTagAdapter.g(collection, i);
    }

    public static final void i(PublishWorkTagAdapter publishWorkTagAdapter) {
        Intrinsics.checkNotNullParameter(publishWorkTagAdapter, "this$0");
        RecyclerView recyclerView = publishWorkTagAdapter.rvList;
        RecyclerView.LayoutManager layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
        if (layoutManager != null) {
            layoutManager.scrollToPosition(publishWorkTagAdapter.selIndex);
        }
    }

    public static final void k(PublishWorkTagAdapter publishWorkTagAdapter) {
        Intrinsics.checkNotNullParameter(publishWorkTagAdapter, "this$0");
        RecyclerView recyclerView = publishWorkTagAdapter.rvList;
        if (recyclerView != null) {
            recyclerView.smoothScrollToPosition(publishWorkTagAdapter.selIndex);
        }
    }

    public final void g(@Nullable Collection<WorksTagBean> list, int defaultIndex) {
        if (defaultIndex >= (list != null ? list.size() : 0)) {
            return;
        }
        this.selIndex = defaultIndex;
        super.setList(list);
        RecyclerView recyclerView = this.rvList;
        if (recyclerView != null) {
            recyclerView.post(new Runnable() { // from class: com.zj.adlib.d47
                @Override // java.lang.Runnable
                public final void run() {
                    PublishWorkTagAdapter.i(this.f41103a);
                }
            });
        }
    }

    public final void j(int index) {
        int i = this.selIndex;
        if (index == i) {
            return;
        }
        this.selIndex = index;
        notifyItemChanged(i);
        notifyItemChanged(this.selIndex);
        RecyclerView recyclerView = this.rvList;
        if (recyclerView != null) {
            recyclerView.post(new Runnable() { // from class: com.zj.adlib.e47
                @Override // java.lang.Runnable
                public final void run() {
                    PublishWorkTagAdapter.k(this.f41343a);
                }
            });
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.rvList = recyclerView;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.rvList = null;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<WorksItemPulishWorkTagBinding> holder, @NotNull WorksTagBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        WorksItemPulishWorkTagBinding worksItemPulishWorkTagBinding = (WorksItemPulishWorkTagBinding) holder.getDataBinding();
        if (worksItemPulishWorkTagBinding != null) {
            worksItemPulishWorkTagBinding.k(item);
            worksItemPulishWorkTagBinding.getRoot().setSelected(this.selIndex == holder.getAbsoluteAdapterPosition());
            worksItemPulishWorkTagBinding.executePendingBindings();
        }
    }
}
