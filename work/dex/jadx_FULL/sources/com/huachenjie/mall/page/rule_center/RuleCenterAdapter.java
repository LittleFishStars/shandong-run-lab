package com.huachenjie.mall.page.rule_center;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.RuleCenterBean;
import com.huachenjie.mall.databinding.MallItemRuleCenterBinding;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u001e\u0010\t\u001a\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014J\u0016\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\bJ\u0006\u0010\u0013\u001a\u00020\bR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/mall/page/rule_center/RuleCenterAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/mall/bean/RuleCenterBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/mall/databinding/MallItemRuleCenterBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "holder", "item", "", "convert", "Landroid/content/Context;", "context", "", "emptyLayoutId", y6b.f, "Landroid/view/View;", "view", y6b.g, "i", "f", "a", "Landroid/view/View;", "mEmptyView", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class RuleCenterAdapter extends BaseQuickAdapter<RuleCenterBean, BaseDataBindingHolder<MallItemRuleCenterBinding>> implements LoadMoreModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public View mEmptyView;

    public RuleCenterAdapter() {
        super(R.layout.mall_item_rule_center, null, 2, null);
    }

    public final void f() {
        removeEmptyView();
    }

    public final void g(@NotNull Context context, int emptyLayoutId) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mEmptyView = LayoutInflater.from(context).inflate(emptyLayoutId, (ViewGroup) null);
    }

    public final void h(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.mEmptyView = view;
    }

    public final void i() {
        View view;
        if (hasEmptyView() || (view = this.mEmptyView) == null || view.getParent() != null) {
            return;
        }
        setEmptyView(view);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<MallItemRuleCenterBinding> holder, @NotNull RuleCenterBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        MallItemRuleCenterBinding mallItemRuleCenterBinding = (MallItemRuleCenterBinding) holder.getDataBinding();
        if (mallItemRuleCenterBinding != null) {
            mallItemRuleCenterBinding.k(item);
            mallItemRuleCenterBinding.executePendingBindings();
        }
    }
}
