package com.huachenjie.mall.page.goods_detail;

import android.widget.TextView;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailSpecValue;
import com.huachenjie.mall.databinding.MallItemGoodsSpecificationBinding;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import com.noober.background.drawable.DrawableCreator;
import com.zj.adlib.ar6;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tR\u0016\u0010\u000e\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/mall/page/goods_detail/GoodsSpecificationAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailSpecValue;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/mall/databinding/MallItemGoodsSpecificationBinding;", "holder", "item", "", "convert", "", "position", "e", "K", "I", "selIndex", "<init>", "(I)V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class GoodsSpecificationAdapter extends BaseQuickAdapter<GoodsDetailSpecValue, BaseDataBindingHolder<MallItemGoodsSpecificationBinding>> {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int selIndex;

    public GoodsSpecificationAdapter(int i) {
        super(R.layout.mall_item_goods_specification, null, 2, null);
        this.selIndex = i;
    }

    public final void e(int position) {
        int i = this.selIndex;
        if (position == i) {
            this.selIndex = -1;
            notifyItemChanged(position);
        } else {
            this.selIndex = position;
            notifyItemChanged(i);
            notifyItemChanged(this.selIndex);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<MallItemGoodsSpecificationBinding> holder, @NotNull GoodsDetailSpecValue item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        MallItemGoodsSpecificationBinding mallItemGoodsSpecificationBinding = (MallItemGoodsSpecificationBinding) holder.getDataBinding();
        if (mallItemGoodsSpecificationBinding != null) {
            mallItemGoodsSpecificationBinding.k(item);
            if (this.selIndex == holder.getLayoutPosition()) {
                mallItemGoodsSpecificationBinding.f10831a.setBackground(new DrawableCreator.Builder().setCornersRadius(SizeUtils.b(8.0f)).setSolidColor(-2426625).setStrokeColor(-16002049).setStrokeWidth(SizeUtils.b(1.0f)).build());
                mallItemGoodsSpecificationBinding.f10829a.setTextColor(RunIndexRecordAdapter.K);
                TextView textView = mallItemGoodsSpecificationBinding.f10829a;
                textView.setTypeface(textView.getTypeface(), 1);
            } else {
                mallItemGoodsSpecificationBinding.f10831a.setBackground(new DrawableCreator.Builder().setCornersRadius(SizeUtils.b(8.0f)).setSolidColor(ar6.E).setStrokeColor(-1710619).setStrokeWidth(SizeUtils.b(1.0f)).build());
                mallItemGoodsSpecificationBinding.f10829a.setTextColor(-13877680);
                TextView textView2 = mallItemGoodsSpecificationBinding.f10829a;
                textView2.setTypeface(textView2.getTypeface(), 0);
            }
            mallItemGoodsSpecificationBinding.executePendingBindings();
        }
    }
}
