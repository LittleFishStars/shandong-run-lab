package com.huachenjie.mall.page.goods_detail;

import com.chad.library.adapter.base.BaseBinderAdapter;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailOneGoodsComment;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailPicture;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailShop;
import com.huachenjie.mall.page.goods_detail.item_binder.PictureItemBinder;
import com.huachenjie.mall.page.goods_detail.item_binder.ShopItemBinder;
import com.zj.adlib.kr6;
import com.zj.adlib.zo1;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/huachenjie/mall/page/goods_detail/GoodsDetailAdapter;", "Lcom/chad/library/adapter/base/BaseBinderAdapter;", "()V", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGoodsDetailAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GoodsDetailAdapter.kt\ncom/huachenjie/mall/page/goods_detail/GoodsDetailAdapter\n+ 2 BaseBinderAdapter.kt\ncom/chad/library/adapter/base/BaseBinderAdapter\n*L\n1#1,22:1\n57#2,3:23\n57#2,3:26\n57#2,3:29\n57#2,3:32\n*S KotlinDebug\n*F\n+ 1 GoodsDetailAdapter.kt\ncom/huachenjie/mall/page/goods_detail/GoodsDetailAdapter\n*L\n17#1:23,3\n18#1:26,3\n19#1:29,3\n20#1:32,3\n*E\n"})
public final class GoodsDetailAdapter extends BaseBinderAdapter {
    /* JADX WARN: Illegal instructions before constructor call */
    public GoodsDetailAdapter() {
        List list = null;
        super(list, 1, list);
        addItemBinder(GoodsDetailOneGoodsComment.class, new zo1(), null);
        addItemBinder(GoodsDetailShop.class, new ShopItemBinder(), null);
        addItemBinder(String.class, new kr6(), null);
        addItemBinder(GoodsDetailPicture.class, new PictureItemBinder(), null);
    }
}
