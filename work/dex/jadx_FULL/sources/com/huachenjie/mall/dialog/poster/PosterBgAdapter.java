package com.huachenjie.mall.dialog.poster;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.PosterBackgroundBean;
import com.huachenjie.mall.databinding.MallItemPosterBgBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tR\u0016\u0010\u000e\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/mall/dialog/poster/PosterBgAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/mall/bean/PosterBackgroundBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/mall/databinding/MallItemPosterBgBinding;", "holder", "item", "", "convert", "", "posterNo", "e", "f", "Ljava/lang/String;", "selectedNo", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class PosterBgAdapter extends BaseQuickAdapter<PosterBackgroundBean, BaseDataBindingHolder<MallItemPosterBgBinding>> {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public String selectedNo;

    public PosterBgAdapter() {
        super(R.layout.mall_item_poster_bg, null, 2, null);
        this.selectedNo = "";
    }

    public final void e(@NotNull String posterNo) {
        Intrinsics.checkNotNullParameter(posterNo, "posterNo");
        this.selectedNo = posterNo;
        notifyDataSetChanged();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<MallItemPosterBgBinding> holder, @NotNull PosterBackgroundBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        MallItemPosterBgBinding mallItemPosterBgBinding = (MallItemPosterBgBinding) holder.getDataBinding();
        if (mallItemPosterBgBinding != null) {
            mallItemPosterBgBinding.l(item);
            mallItemPosterBgBinding.m(this.selectedNo);
            mallItemPosterBgBinding.executePendingBindings();
        }
    }
}
