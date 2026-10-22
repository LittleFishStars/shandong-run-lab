package com.huachenjie.mall.page.goods_detail.item_binder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.binder.BaseItemBinder;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailShop;
import com.huachenjie.mall.databinding.MallItemGoodsDetailShopBinding;
import com.huachenjie.mall.databinding.MallItemGoodsDetailShopItemBinding;
import com.huachenjie.mall.external.bean.CommodityBean;
import com.huachenjie.mall.page.merchants.MerchantsActivity;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J.\u0010\f\u001a\u00020\u000b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\u001e\u0010\r\u001a\u00020\u000b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\tH\u0016R\u001b\u0010\u0016\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/mall/page/goods_detail/item_binder/ShopItemBinder;", "Lcom/chad/library/adapter/base/binder/BaseItemBinder;", "Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailShop;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/mall/databinding/MallItemGoodsDetailShopBinding;", "holder", "Landroid/view/View;", "view", "data", "", "position", "", "c", "a", "Landroid/view/ViewGroup;", "parent", "viewType", "d", "Lcom/huachenjie/mall/page/goods_detail/item_binder/ShopItemBinder$ShopItemAdapter;", "Lkotlin/Lazy;", "b", "()Lcom/huachenjie/mall/page/goods_detail/item_binder/ShopItemBinder$ShopItemAdapter;", "itemAdapter", "<init>", "()V", "ShopItemAdapter", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class ShopItemBinder extends BaseItemBinder<GoodsDetailShop, BaseDataBindingHolder<MallItemGoodsDetailShopBinding>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Lazy itemAdapter = LazyKt.lazy(ShopItemBinder$itemAdapter$2.INSTANCE);

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¨\u0006\n"}, d2 = {"Lcom/huachenjie/mall/page/goods_detail/item_binder/ShopItemBinder$ShopItemAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/mall/external/bean/CommodityBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/mall/databinding/MallItemGoodsDetailShopItemBinding;", "()V", "convert", "", "holder", "item", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ShopItemAdapter extends BaseQuickAdapter<CommodityBean, BaseDataBindingHolder<MallItemGoodsDetailShopItemBinding>> {
        public ShopItemAdapter() {
            super(R.layout.mall_item_goods_detail_shop_item, null, 2, null);
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        public void convert(@NotNull BaseDataBindingHolder<MallItemGoodsDetailShopItemBinding> holder, @NotNull CommodityBean item) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            Intrinsics.checkNotNullParameter(item, "item");
            MallItemGoodsDetailShopItemBinding mallItemGoodsDetailShopItemBinding = (MallItemGoodsDetailShopItemBinding) holder.getDataBinding();
            if (mallItemGoodsDetailShopItemBinding != null) {
                mallItemGoodsDetailShopItemBinding.k(item);
                mallItemGoodsDetailShopItemBinding.executePendingBindings();
            }
        }
    }

    public ShopItemBinder() {
        addChildClickViewIds(R.id.tv_go_shop);
    }

    @Override // com.chad.library.adapter.base.binder.BaseItemBinder
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void convert(@NotNull BaseDataBindingHolder<MallItemGoodsDetailShopBinding> holder, @NotNull GoodsDetailShop data) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(data, "data");
        b().setList(data.getGoodsList());
        MallItemGoodsDetailShopBinding mallItemGoodsDetailShopBinding = (MallItemGoodsDetailShopBinding) holder.getDataBinding();
        if (mallItemGoodsDetailShopBinding != null) {
            mallItemGoodsDetailShopBinding.m(data);
            mallItemGoodsDetailShopBinding.l(b());
            mallItemGoodsDetailShopBinding.executePendingBindings();
        }
    }

    public final ShopItemAdapter b() {
        return (ShopItemAdapter) this.itemAdapter.getValue();
    }

    @Override // com.chad.library.adapter.base.binder.BaseItemBinder
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onChildClick(@NotNull BaseDataBindingHolder<MallItemGoodsDetailShopBinding> holder, @NotNull View view, @NotNull GoodsDetailShop data, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        MerchantsActivity.Companion companion = MerchantsActivity.INSTANCE;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        companion.a(context, data.getDesc().getShopNo());
    }

    @Override // com.chad.library.adapter.base.binder.BaseItemBinder
    @NotNull
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public BaseDataBindingHolder<MallItemGoodsDetailShopBinding> onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.mall_item_goods_detail_shop, parent, false);
        ((RecyclerView) viewInflate.findViewById(R.id.recyclerView)).setLayoutManager(new LinearLayoutManager(parent.getContext(), 0, false));
        Intrinsics.checkNotNullExpressionValue(viewInflate, "view");
        return new BaseDataBindingHolder<>(viewInflate);
    }
}
