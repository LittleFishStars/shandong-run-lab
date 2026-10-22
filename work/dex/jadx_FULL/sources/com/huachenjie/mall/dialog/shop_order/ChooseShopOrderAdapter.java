package com.huachenjie.mall.dialog.shop_order;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroupKt;
import androidx.coroutines.DataBindingUtil;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.base.bean.MyOrderBean;
import com.huachenjie.base.bean.OrderGoodsBean;
import com.huachenjie.mall.R;
import com.huachenjie.mall.databinding.MallItemChooseShopOrderBinding;
import com.huachenjie.mall.databinding.MallItemMyOrderGoodsBinding;
import com.zj.adlib.hk0;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/mall/dialog/shop_order/ChooseShopOrderAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/base/bean/MyOrderBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/mall/databinding/MallItemChooseShopOrderBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "()V", "convert", "", "holder", "item", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ChooseShopOrderAdapter extends BaseQuickAdapter<MyOrderBean, BaseDataBindingHolder<MallItemChooseShopOrderBinding>> implements LoadMoreModule {
    public ChooseShopOrderAdapter() {
        super(R.layout.mall_item_choose_shop_order, null, 2, null);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<MallItemChooseShopOrderBinding> holder, @NotNull MyOrderBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        MallItemChooseShopOrderBinding mallItemChooseShopOrderBinding = (MallItemChooseShopOrderBinding) holder.getDataBinding();
        if (mallItemChooseShopOrderBinding != null) {
            mallItemChooseShopOrderBinding.k(item);
            LinearLayout linearLayout = mallItemChooseShopOrderBinding.f34980a;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "llGoods");
            List list = SequencesKt.toList(ViewGroupKt.getChildren(linearLayout));
            List<OrderGoodsBean> goodsList = item.getGoodsList();
            int size = goodsList.size();
            int i = 0;
            while (i < size) {
                MallItemMyOrderGoodsBinding mallItemMyOrderGoodsBinding = i >= list.size() ? (MallItemMyOrderGoodsBinding) DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.mall_item_my_order_goods, mallItemChooseShopOrderBinding.f34980a, true) : (MallItemMyOrderGoodsBinding) DataBindingUtil.getBinding((View) list.get(i));
                if (mallItemMyOrderGoodsBinding != null) {
                    mallItemMyOrderGoodsBinding.setVariable(hk0.t, goodsList.get(i));
                }
                i++;
            }
            int size2 = list.size();
            for (int size3 = goodsList.size(); size3 < size2; size3++) {
                mallItemChooseShopOrderBinding.f34980a.removeView((View) list.get(size3));
            }
            mallItemChooseShopOrderBinding.executePendingBindings();
        }
    }
}
