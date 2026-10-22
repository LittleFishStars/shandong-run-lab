package com.zj.adlib;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.binder.BaseItemBinder;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailOneGoodsComment;
import com.huachenjie.mall.databinding.MallItemGoodsDetailCommentBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¨\u0006\u0010"}, d2 = {"Lcom/zj/adlib/zo1;", "Lcom/chad/library/adapter/base/binder/BaseItemBinder;", "Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailOneGoodsComment;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/mall/databinding/MallItemGoodsDetailCommentBinding;", "holder", "data", "", "a", "Landroid/view/ViewGroup;", "parent", "", "viewType", "b", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class zo1 extends BaseItemBinder<GoodsDetailOneGoodsComment, BaseDataBindingHolder<MallItemGoodsDetailCommentBinding>> {
    @Override // com.chad.library.adapter.base.binder.BaseItemBinder
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void convert(@NotNull BaseDataBindingHolder<MallItemGoodsDetailCommentBinding> holder, @NotNull GoodsDetailOneGoodsComment data) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(data, "data");
        MallItemGoodsDetailCommentBinding mallItemGoodsDetailCommentBinding = (MallItemGoodsDetailCommentBinding) holder.getDataBinding();
        if (mallItemGoodsDetailCommentBinding != null) {
            mallItemGoodsDetailCommentBinding.k(data);
            mallItemGoodsDetailCommentBinding.executePendingBindings();
        }
    }

    @Override // com.chad.library.adapter.base.binder.BaseItemBinder
    @NotNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BaseDataBindingHolder<MallItemGoodsDetailCommentBinding> onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.mall_item_goods_detail_comment, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "view");
        return new BaseDataBindingHolder<>(viewInflate);
    }
}
