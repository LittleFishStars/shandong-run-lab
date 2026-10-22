package com.huachenjie.mall.external.page.share_goods;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.mall.R;
import com.huachenjie.mall.databinding.MallItemSelectGoodsBinding;
import com.huachenjie.mall.external.bean.SelectGoodsBean;
import com.noober.background.drawable.DrawableCreator;
import com.zj.adlib.jj8;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/mall/external/page/share_goods/SelectGoodsAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/mall/external/bean/SelectGoodsBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/mall/databinding/MallItemSelectGoodsBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "()V", "convert", "", "holder", "item", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SelectGoodsAdapter extends BaseQuickAdapter<SelectGoodsBean, BaseDataBindingHolder<MallItemSelectGoodsBinding>> implements LoadMoreModule {
    public SelectGoodsAdapter() {
        super(R.layout.mall_item_select_goods, null, 2, null);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<MallItemSelectGoodsBinding> holder, @NotNull SelectGoodsBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        MallItemSelectGoodsBinding mallItemSelectGoodsBinding = (MallItemSelectGoodsBinding) holder.getDataBinding();
        if (mallItemSelectGoodsBinding != null) {
            DrawableCreator.Builder cornersRadius = new DrawableCreator.Builder().setSolidColor(-1).setCornersRadius(jj8.a(20.0f));
            if (item.getChecked()) {
                cornersRadius.setStrokeWidth(jj8.a(2.0f)).setStrokeColor(-10155284);
            } else {
                cornersRadius.setStrokeWidth(0.0f);
            }
            mallItemSelectGoodsBinding.getRoot().setBackground(cornersRadius.build());
            mallItemSelectGoodsBinding.k(item);
            mallItemSelectGoodsBinding.executePendingBindings();
        }
    }
}
