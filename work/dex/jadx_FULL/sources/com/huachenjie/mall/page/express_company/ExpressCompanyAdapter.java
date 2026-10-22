package com.huachenjie.mall.page.express_company;

import androidx.coroutines.ViewDataBinding;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.ExpressCompanyBean;
import com.huachenjie.mall.databinding.MallItemExpressCompanyBinding;
import com.huachenjie.mall.databinding.MallItemExpressCompanyNameBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¨\u0006\n"}, d2 = {"Lcom/huachenjie/mall/page/express_company/ExpressCompanyAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/huachenjie/mall/bean/ExpressCompanyBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Landroidx/databinding/ViewDataBinding;", "()V", "convert", "", "holder", "item", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ExpressCompanyAdapter extends BaseMultiItemQuickAdapter<ExpressCompanyBean, BaseDataBindingHolder<? extends ViewDataBinding>> {
    /* JADX WARN: Illegal instructions before constructor call */
    public ExpressCompanyAdapter() {
        List list = null;
        super(list, 1, list);
        addItemType(1, R.layout.mall_item_express_company_name);
        addItemType(0, R.layout.mall_item_express_company);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<? extends ViewDataBinding> holder, @NotNull ExpressCompanyBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        if (dataBinding != null) {
            if (dataBinding instanceof MallItemExpressCompanyBinding) {
                ((MallItemExpressCompanyBinding) dataBinding).k(item);
            } else if (dataBinding instanceof MallItemExpressCompanyNameBinding) {
                ((MallItemExpressCompanyNameBinding) dataBinding).k(item);
            }
            dataBinding.executePendingBindings();
        }
    }
}
