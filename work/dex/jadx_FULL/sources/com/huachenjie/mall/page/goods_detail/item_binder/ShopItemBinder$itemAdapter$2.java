package com.huachenjie.mall.page.goods_detail.item_binder;

import android.view.View;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.mall.page.goods_detail.GoodsDetailActivity;
import com.zj.adlib.y57;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/huachenjie/mall/page/goods_detail/item_binder/ShopItemBinder$ShopItemAdapter;", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class ShopItemBinder$itemAdapter$2 extends Lambda implements Function0<ShopItemBinder.ShopItemAdapter> {
    public static final ShopItemBinder$itemAdapter$2 INSTANCE = new ShopItemBinder$itemAdapter$2();

    public ShopItemBinder$itemAdapter$2() {
        super(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1$lambda$0(ShopItemBinder.ShopItemAdapter shopItemAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(shopItemAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        GoodsDetailActivity.INSTANCE.a(shopItemAdapter.getContext(), shopItemAdapter.getItem(i).getGoodsNo());
    }

    @NotNull
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final ShopItemBinder.ShopItemAdapter m540invoke() {
        final ShopItemBinder.ShopItemAdapter shopItemAdapter = new ShopItemBinder.ShopItemAdapter();
        y57.d(shopItemAdapter, 0L, new OnItemClickListener() { // from class: com.huachenjie.mall.page.goods_detail.item_binder.a
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ShopItemBinder$itemAdapter$2.invoke$lambda$1$lambda$0(shopItemAdapter, baseQuickAdapter, view, i);
            }
        }, 1, null);
        return shopItemAdapter;
    }
}
