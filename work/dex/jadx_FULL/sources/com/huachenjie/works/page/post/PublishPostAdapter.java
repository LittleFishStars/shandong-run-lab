package com.huachenjie.works.page.post;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.PostCategoryBean;
import com.huachenjie.works.databinding.WorksItemPulishPostTagBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tR\u0016\u0010\u000e\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/works/page/post/PublishPostAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/works/bean/PostCategoryBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/works/databinding/WorksItemPulishPostTagBinding;", "holder", "item", "", "convert", "", "index", "e", "K", "I", "selIndex", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class PublishPostAdapter extends BaseQuickAdapter<PostCategoryBean, BaseDataBindingHolder<WorksItemPulishPostTagBinding>> {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int selIndex;

    public PublishPostAdapter() {
        super(R.layout.works_item_pulish_post_tag, null, 2, null);
        this.selIndex = -1;
    }

    public final void e(int index) {
        int i = this.selIndex;
        if (i == index) {
            return;
        }
        this.selIndex = index;
        if (i != -1) {
            notifyItemChanged(i + getHeaderLayoutCount());
        }
        notifyItemChanged(index + getHeaderLayoutCount());
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<WorksItemPulishPostTagBinding> holder, @NotNull PostCategoryBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        WorksItemPulishPostTagBinding worksItemPulishPostTagBinding = (WorksItemPulishPostTagBinding) holder.getDataBinding();
        if (worksItemPulishPostTagBinding != null) {
            worksItemPulishPostTagBinding.k(item);
            worksItemPulishPostTagBinding.getRoot().setSelected(this.selIndex == holder.getBindingAdapterPosition() - getHeaderLayoutCount());
            worksItemPulishPostTagBinding.executePendingBindings();
        }
    }
}
