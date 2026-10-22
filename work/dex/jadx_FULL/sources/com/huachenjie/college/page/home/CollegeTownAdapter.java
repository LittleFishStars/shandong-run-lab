package com.huachenjie.college.page.home;

import androidx.coroutines.ViewDataBinding;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.college.R;
import com.huachenjie.college.bean.RecommendItemBean;
import com.huachenjie.college.databinding.CollegeItemTownRecommendBinding;
import com.huachenjie.college.databinding.CollegeItemTownRecommendEmptyBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/college/page/home/CollegeTownAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/huachenjie/college/bean/RecommendItemBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Landroidx/databinding/ViewDataBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "()V", "convert", "", "holder", "item", "college_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CollegeTownAdapter extends BaseMultiItemQuickAdapter<RecommendItemBean, BaseDataBindingHolder<ViewDataBinding>> implements LoadMoreModule {
    /* JADX WARN: Illegal instructions before constructor call */
    public CollegeTownAdapter() {
        List list = null;
        super(list, 1, list);
        addItemType(0, R.layout.college_item_town_recommend);
        addItemType(1, R.layout.college_item_town_recommend_empty);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<ViewDataBinding> holder, @NotNull RecommendItemBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        if (dataBinding != null) {
            int itemType = item.getItemType();
            if (itemType == 0) {
                ((CollegeItemTownRecommendBinding) dataBinding).k(item);
            } else if (itemType == 1) {
                ((CollegeItemTownRecommendEmptyBinding) dataBinding).k(item);
            }
            dataBinding.executePendingBindings();
        }
    }
}
