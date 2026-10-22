package com.huachenjie.works.page.details.video;

import androidx.coroutines.ViewDataBinding;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.base.view.ExpandableTextView;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.WorkDetailBean;
import com.huachenjie.works.databinding.WorksItemWorkDetailListBinding;
import com.huachenjie.works.databinding.WorksItemWorkListPictureBinding;
import com.huachenjie.works.databinding.WorksItemWorkListVideoBinding;
import com.huachenjie.works.page.details.video.WorkVideoListAdapter;
import com.zj.adlib.oz9;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¨\u0006\n"}, d2 = {"Lcom/huachenjie/works/page/details/video/WorkVideoListAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/huachenjie/works/bean/WorkDetailBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Landroidx/databinding/ViewDataBinding;", "()V", "convert", "", "holder", "item", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WorkVideoListAdapter extends BaseMultiItemQuickAdapter<WorkDetailBean, BaseDataBindingHolder<ViewDataBinding>> {
    /* JADX WARN: Illegal instructions before constructor call */
    public WorkVideoListAdapter() {
        List list = null;
        super(list, 1, list);
        addItemType(1, R.layout.works_item_work_list_picture);
        addItemType(2, R.layout.works_item_work_list_video);
    }

    public static final void f(WorkDetailBean workDetailBean, boolean z) {
        Intrinsics.checkNotNullParameter(workDetailBean, "$item");
        workDetailBean.setTextExpand(z);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<ViewDataBinding> holder, @NotNull final WorkDetailBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        if (dataBinding != null) {
            int itemType = item.getPostType();
            if (itemType == 1) {
                ((WorksItemWorkListPictureBinding) dataBinding).k(item);
            } else if (itemType == 2) {
                WorksItemWorkListVideoBinding worksItemWorkListVideoBinding = (WorksItemWorkListVideoBinding) dataBinding;
                worksItemWorkListVideoBinding.f14720a.setVisibility(0);
                WorksItemWorkDetailListBinding worksItemWorkDetailListBinding = worksItemWorkListVideoBinding.f14722a;
                if (worksItemWorkDetailListBinding != null) {
                    worksItemWorkDetailListBinding.f14702a.setOnQuantityChangeCallback(new Function2<Boolean, Integer, Unit>() { // from class: com.huachenjie.works.page.details.video.WorkVideoListAdapter$convert$1$2$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke(((Boolean) obj).booleanValue(), ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z, int i) {
                            item.setCollected(z, i);
                            oz9.f43864a.b(this.getContext(), item.getWorksNo(), z, i);
                        }
                    });
                    worksItemWorkDetailListBinding.f14711b.setOnQuantityChangeCallback(new Function2<Boolean, Integer, Unit>() { // from class: com.huachenjie.works.page.details.video.WorkVideoListAdapter$convert$1$2$1$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke(((Boolean) obj).booleanValue(), ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z, int i) {
                            item.setLiked(z, i);
                            oz9.f43864a.c(this.getContext(), item.getWorksNo(), z, i);
                        }
                    });
                    worksItemWorkDetailListBinding.f14699a.setExpandText(item.getCloseContent(), item.getExpandContent());
                    worksItemWorkDetailListBinding.f14699a.setOnExpandChangeListener(new ExpandableTextView.OnExpandChangeListener() { // from class: com.zj.adlib.a0a
                        @Override // com.huachenjie.base.view.ExpandableTextView.OnExpandChangeListener
                        public final void a(boolean z) {
                            WorkVideoListAdapter.f(item, z);
                        }
                    });
                }
                worksItemWorkListVideoBinding.k(item);
            }
            dataBinding.executePendingBindings();
        }
    }
}
