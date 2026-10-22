package com.huachenjie.mall.page.express;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import androidx.coroutines.ViewDataBinding;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.ExpressLogisticsBean;
import com.huachenjie.mall.databinding.MallItemExpressLogisticsBinding;
import com.huachenjie.mall.databinding.MallItemExpressLogisticsSimpleBinding;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\b\u001a\u00020\u00072\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0014R\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/mall/page/express/ExpressLogisticsAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/huachenjie/mall/bean/ExpressLogisticsBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Landroidx/databinding/ViewDataBinding;", "holder", "item", "", "convert", "", "a", "Lkotlin/Lazy;", "f", "()F", "SIZE_DP20", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class ExpressLogisticsAdapter extends BaseMultiItemQuickAdapter<ExpressLogisticsBean, BaseDataBindingHolder<? extends ViewDataBinding>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Lazy SIZE_DP20;

    public ExpressLogisticsAdapter() {
        super(null, 1, null);
        this.SIZE_DP20 = LazyKt.lazy(new Function0<Float>() { // from class: com.huachenjie.mall.page.express.ExpressLogisticsAdapter$SIZE_DP20$2
            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Float m521invoke() {
                return Float.valueOf(SizeUtils.b(20.0f) * 1.0f);
            }
        });
        addItemType(0, R.layout.mall_item_express_logistics);
        addItemType(1, R.layout.mall_item_express_logistics_simple);
    }

    public final float f() {
        return ((Number) this.SIZE_DP20.getValue()).floatValue();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<? extends ViewDataBinding> holder, @NotNull ExpressLogisticsBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        item.setPosition(getItemPosition(item));
        item.setAllPosition(getData().size());
        ViewDataBinding dataBinding = holder.getDataBinding();
        if (dataBinding != null) {
            if (dataBinding instanceof MallItemExpressLogisticsBinding) {
                ((MallItemExpressLogisticsBinding) dataBinding).k(item);
            } else if (dataBinding instanceof MallItemExpressLogisticsSimpleBinding) {
                ((MallItemExpressLogisticsSimpleBinding) dataBinding).k(item);
            }
            dataBinding.executePendingBindings();
            Drawable background = dataBinding.getRoot().getBackground();
            if (background instanceof GradientDrawable) {
                if (item.isFirstPosition() && item.isLastPosition()) {
                    ((GradientDrawable) background).setCornerRadii(new float[]{f(), f(), f(), f(), f(), f(), f(), f()});
                    return;
                }
                if (item.isFirstPosition()) {
                    ((GradientDrawable) background).setCornerRadii(new float[]{f(), f(), f(), f(), 0.0f, 0.0f, 0.0f, 0.0f});
                } else if (item.isLastPosition()) {
                    ((GradientDrawable) background).setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, f(), f(), f(), f()});
                } else {
                    ((GradientDrawable) background).setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f});
                }
            }
        }
    }
}
