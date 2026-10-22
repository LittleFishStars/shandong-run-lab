package com.huachenjie.mall.dialog.cancel_reason;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.OrderReasonBean;
import com.huachenjie.mall.databinding.MallItemCancelReasonBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¨\u0006\n"}, d2 = {"Lcom/huachenjie/mall/dialog/cancel_reason/CancelReasonAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/mall/bean/OrderReasonBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/mall/databinding/MallItemCancelReasonBinding;", "()V", "convert", "", "holder", "item", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CancelReasonAdapter extends BaseQuickAdapter<OrderReasonBean, BaseDataBindingHolder<MallItemCancelReasonBinding>> {
    /* JADX WARN: Illegal instructions before constructor call */
    public CancelReasonAdapter() {
        List list = null;
        super(R.layout.mall_item_cancel_reason, list, 2, list);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<MallItemCancelReasonBinding> holder, @NotNull OrderReasonBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        MallItemCancelReasonBinding mallItemCancelReasonBinding = (MallItemCancelReasonBinding) holder.getDataBinding();
        if (mallItemCancelReasonBinding != null) {
            mallItemCancelReasonBinding.k(item);
            mallItemCancelReasonBinding.executePendingBindings();
        }
    }
}
