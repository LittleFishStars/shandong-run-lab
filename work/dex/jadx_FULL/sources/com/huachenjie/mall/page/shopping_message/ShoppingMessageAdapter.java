package com.huachenjie.mall.page.shopping_message;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.MessageContactBean;
import com.huachenjie.mall.databinding.MallItemShoppingMessageBinding;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u001e\u0010\t\u001a\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\bJ\u0006\u0010\u000e\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0016\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/mall/page/shopping_message/ShoppingMessageAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/mall/bean/MessageContactBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/mall/databinding/MallItemShoppingMessageBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "holder", "item", "", "convert", "Landroid/view/View;", "view", y6b.f, "j", "f", "", "position", "i", "targetPosition", y6b.g, "a", "Landroid/view/View;", "mEmptyView", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class ShoppingMessageAdapter extends BaseQuickAdapter<MessageContactBean, BaseDataBindingHolder<MallItemShoppingMessageBinding>> implements LoadMoreModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public View mEmptyView;

    public ShoppingMessageAdapter() {
        super(R.layout.mall_item_shopping_message, null, 2, null);
    }

    public final void f() {
        removeEmptyView();
    }

    public final void g(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.mEmptyView = view;
    }

    public final void h(int position, int targetPosition) {
        if (position < 0 || position >= getData().size() || targetPosition < 0 || targetPosition >= getData().size()) {
            return;
        }
        if (position == targetPosition) {
            notifyItemChanged(targetPosition + getHeaderLayoutCount());
            return;
        }
        MessageContactBean messageContactBean = getData().get(position);
        getData().remove(position);
        getData().add(targetPosition, messageContactBean);
        notifyItemMoved(position + getHeaderLayoutCount(), getHeaderLayoutCount() + targetPosition);
        notifyItemChanged(targetPosition + getHeaderLayoutCount());
    }

    public final void i(int position) {
        h(position, 0);
        notifyItemChanged(getHeaderLayoutCount() + 0);
        if (getData().size() > 1) {
            notifyItemChanged(1);
        }
    }

    public final void j() {
        View view;
        if (hasEmptyView() || (view = this.mEmptyView) == null || view.getParent() != null) {
            return;
        }
        setEmptyView(view);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<MallItemShoppingMessageBinding> holder, @NotNull MessageContactBean item) {
        int i;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        int itemPosition = getItemPosition(item);
        if (itemPosition == 0 && itemPosition == getData().size() - 1) {
            i = R.drawable.mall_bg_shopping_message_one;
        } else if (itemPosition == 0) {
            i = R.drawable.mall_bg_shopping_message_header;
        } else {
            i = itemPosition == getData().size() + (-1) ? R.drawable.mall_bg_shopping_message_footer : R.drawable.mall_bg_shopping_message;
        }
        MallItemShoppingMessageBinding mallItemShoppingMessageBinding = (MallItemShoppingMessageBinding) holder.getDataBinding();
        if (mallItemShoppingMessageBinding != null) {
            mallItemShoppingMessageBinding.getRoot().setBackgroundResource(i);
            mallItemShoppingMessageBinding.k(item);
            mallItemShoppingMessageBinding.executePendingBindings();
        }
    }
}
