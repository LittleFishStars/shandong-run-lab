package com.huachenjie.works.adapter.publish;

import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.publish.PubWorkLocationItemBean;
import com.huachenjie.works.databinding.WorksItemPubWorkMenuLocationBinding;
import com.zj.adlib.qk0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/works/adapter/publish/PubWorkMenuLocationAdapter;", "Lcom/huachenjie/works/adapter/publish/BasePubWorkMenuAdapter;", "Lcom/huachenjie/works/bean/publish/PubWorkLocationItemBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/works/databinding/WorksItemPubWorkMenuLocationBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "()V", "convert", "", "holder", "item", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PubWorkMenuLocationAdapter extends BasePubWorkMenuAdapter<PubWorkLocationItemBean, BaseDataBindingHolder<WorksItemPubWorkMenuLocationBinding>> implements LoadMoreModule {
    public PubWorkMenuLocationAdapter() {
        super(R.layout.works_item_pub_work_menu_location);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<WorksItemPubWorkMenuLocationBinding> holder, @NotNull PubWorkLocationItemBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        WorksItemPubWorkMenuLocationBinding worksItemPubWorkMenuLocationBinding = (WorksItemPubWorkMenuLocationBinding) holder.getDataBinding();
        if (worksItemPubWorkMenuLocationBinding != null) {
            worksItemPubWorkMenuLocationBinding.setVariable(qk0.g, item);
        }
        WorksItemPubWorkMenuLocationBinding worksItemPubWorkMenuLocationBinding2 = (WorksItemPubWorkMenuLocationBinding) holder.getDataBinding();
        if (worksItemPubWorkMenuLocationBinding2 != null) {
            worksItemPubWorkMenuLocationBinding2.executePendingBindings();
        }
    }
}
