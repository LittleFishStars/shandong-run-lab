package com.huachenjie.mall.page.video_enter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.MyCourseOrEpisodesBean;
import com.huachenjie.mall.databinding.MallItemPurchasedVideoGoodsBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/mall/page/video_enter/PurchasedVideoGoodsAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/mall/bean/MyCourseOrEpisodesBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/mall/databinding/MallItemPurchasedVideoGoodsBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "()V", "convert", "", "holder", "item", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PurchasedVideoGoodsAdapter extends BaseQuickAdapter<MyCourseOrEpisodesBean, BaseDataBindingHolder<MallItemPurchasedVideoGoodsBinding>> implements LoadMoreModule {
    public PurchasedVideoGoodsAdapter() {
        super(R.layout.mall_item_purchased_video_goods, null, 2, null);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<MallItemPurchasedVideoGoodsBinding> holder, @NotNull MyCourseOrEpisodesBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        MallItemPurchasedVideoGoodsBinding mallItemPurchasedVideoGoodsBinding = (MallItemPurchasedVideoGoodsBinding) holder.getDataBinding();
        if (mallItemPurchasedVideoGoodsBinding != null) {
            mallItemPurchasedVideoGoodsBinding.k(item);
            mallItemPurchasedVideoGoodsBinding.executePendingBindings();
        }
    }
}
