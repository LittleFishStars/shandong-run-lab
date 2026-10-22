package com.huachenjie.mall.page.apply_refund;

import android.view.ViewGroup;
import androidx.coroutines.ViewDataBinding;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.ApplyRefundFileBean;
import com.huachenjie.mall.databinding.MallItemApplyRefundPicAddBinding;
import com.huachenjie.mall.databinding.MallItemApplyRefundPicBinding;
import com.zj.adlib.fx7;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\b\u001a\u00020\u00072\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0014R\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/mall/page/apply_refund/ApplyRefundFileAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/huachenjie/mall/bean/ApplyRefundFileBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Landroidx/databinding/ViewDataBinding;", "holder", "item", "", "convert", "", "a", "Lkotlin/Lazy;", "f", "()I", "itemSideLength", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class ApplyRefundFileAdapter extends BaseMultiItemQuickAdapter<ApplyRefundFileBean, BaseDataBindingHolder<? extends ViewDataBinding>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Lazy itemSideLength;

    public ApplyRefundFileAdapter() {
        super(null, 1, null);
        addItemType(1, R.layout.mall_item_apply_refund_pic);
        addItemType(2, R.layout.mall_item_apply_refund_pic_add);
        this.itemSideLength = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.mall.page.apply_refund.ApplyRefundFileAdapter$itemSideLength$2
            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m497invoke() {
                return Integer.valueOf((int) ((fx7.j() - SizeUtils.b(74.0f)) / 3.0f));
            }
        });
    }

    public final int f() {
        return ((Number) this.itemSideLength.getValue()).intValue();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<? extends ViewDataBinding> holder, @NotNull ApplyRefundFileBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        layoutParams.width = f();
        layoutParams.height = f();
        ViewDataBinding dataBinding = holder.getDataBinding();
        if (dataBinding != null) {
            if (dataBinding instanceof MallItemApplyRefundPicBinding) {
                ((MallItemApplyRefundPicBinding) dataBinding).k(item);
            } else if (dataBinding instanceof MallItemApplyRefundPicAddBinding) {
                ((MallItemApplyRefundPicAddBinding) dataBinding).k(item);
            }
            dataBinding.executePendingBindings();
        }
    }
}
