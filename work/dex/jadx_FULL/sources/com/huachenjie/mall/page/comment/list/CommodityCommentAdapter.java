package com.huachenjie.mall.page.comment.list;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.CommodityCommentBean;
import com.huachenjie.mall.databinding.MallItemCommodityCommentBinding;
import com.zj.adlib.y6b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u001e\u0010\t\u001a\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\bJ\u0006\u0010\u000e\u001a\u00020\bR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/mall/page/comment/list/CommodityCommentAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/mall/bean/CommodityCommentBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/mall/databinding/MallItemCommodityCommentBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "holder", "item", "", "convert", "Landroid/view/View;", "view", y6b.f, y6b.g, "f", "a", "Landroid/view/View;", "mEmptyView", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class CommodityCommentAdapter extends BaseQuickAdapter<CommodityCommentBean, BaseDataBindingHolder<MallItemCommodityCommentBinding>> implements LoadMoreModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public View mEmptyView;

    /* JADX WARN: Illegal instructions before constructor call */
    public CommodityCommentAdapter() {
        List list = null;
        super(R.layout.mall_item_commodity_comment, list, 2, list);
    }

    public final void f() {
        removeEmptyView();
    }

    public final void g(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.mEmptyView = view;
    }

    public final void h() {
        View view;
        if (hasEmptyView() || (view = this.mEmptyView) == null || view.getParent() != null) {
            return;
        }
        setEmptyView(view);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<MallItemCommodityCommentBinding> holder, @NotNull CommodityCommentBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        MallItemCommodityCommentBinding mallItemCommodityCommentBinding = (MallItemCommodityCommentBinding) holder.getDataBinding();
        if (mallItemCommodityCommentBinding != null) {
            int evaluate = item.getEvaluate();
            if (evaluate == 1) {
                mallItemCommodityCommentBinding.f34984a.setBackgroundResource(R.drawable.mall_ic_commodity_comment_bad);
                mallItemCommodityCommentBinding.f34984a.setText("差评");
            } else if (evaluate == 2) {
                mallItemCommodityCommentBinding.f34984a.setBackgroundResource(R.drawable.mall_ic_commodity_comment_medium);
                mallItemCommodityCommentBinding.f34984a.setText("中评");
            } else if (evaluate == 3) {
                mallItemCommodityCommentBinding.f34984a.setBackgroundResource(R.drawable.mall_ic_commodity_comment_good);
                mallItemCommodityCommentBinding.f34984a.setText("好评");
            }
            mallItemCommodityCommentBinding.k(item);
            mallItemCommodityCommentBinding.executePendingBindings();
        }
    }
}
