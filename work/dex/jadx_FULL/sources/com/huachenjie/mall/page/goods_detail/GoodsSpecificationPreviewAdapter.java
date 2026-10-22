package com.huachenjie.mall.page.goods_detail;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailSpecValue;
import com.huachenjie.mall.databinding.MallItemGoodsSpecificationPreviewBinding;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0014R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/mall/page/goods_detail/GoodsSpecificationPreviewAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailSpecValue;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/mall/databinding/MallItemGoodsSpecificationPreviewBinding;", "holder", "item", "", "convert", "", "K", "I", "f", "()I", y6b.f, "(I)V", "nameMargin", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class GoodsSpecificationPreviewAdapter extends BaseQuickAdapter<GoodsDetailSpecValue, BaseDataBindingHolder<MallItemGoodsSpecificationPreviewBinding>> {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int nameMargin;

    public GoodsSpecificationPreviewAdapter() {
        super(R.layout.mall_item_goods_specification_preview, null, 2, null);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final int getNameMargin() {
        return this.nameMargin;
    }

    public final void g(int i) {
        this.nameMargin = i;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<MallItemGoodsSpecificationPreviewBinding> holder, @NotNull GoodsDetailSpecValue item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        MallItemGoodsSpecificationPreviewBinding mallItemGoodsSpecificationPreviewBinding = (MallItemGoodsSpecificationPreviewBinding) holder.getDataBinding();
        if (mallItemGoodsSpecificationPreviewBinding != null) {
            mallItemGoodsSpecificationPreviewBinding.l(item);
            mallItemGoodsSpecificationPreviewBinding.m(Integer.valueOf(this.nameMargin));
            mallItemGoodsSpecificationPreviewBinding.executePendingBindings();
        }
    }
}
