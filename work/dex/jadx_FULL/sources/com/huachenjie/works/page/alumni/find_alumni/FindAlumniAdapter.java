package com.huachenjie.works.page.alumni.find_alumni;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.SchoolMateBean;
import com.huachenjie.works.databinding.WorksItemFindAlumniBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/works/page/alumni/find_alumni/FindAlumniAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/works/bean/SchoolMateBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/works/databinding/WorksItemFindAlumniBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "()V", "convert", "", "holder", "item", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FindAlumniAdapter extends BaseQuickAdapter<SchoolMateBean, BaseDataBindingHolder<WorksItemFindAlumniBinding>> implements LoadMoreModule {
    /* JADX WARN: Illegal instructions before constructor call */
    public FindAlumniAdapter() {
        List list = null;
        super(R.layout.works_item_find_alumni, list, 2, list);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<WorksItemFindAlumniBinding> holder, @NotNull SchoolMateBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        WorksItemFindAlumniBinding worksItemFindAlumniBinding = (WorksItemFindAlumniBinding) holder.getDataBinding();
        if (worksItemFindAlumniBinding != null) {
            worksItemFindAlumniBinding.k(item);
            worksItemFindAlumniBinding.executePendingBindings();
        }
    }
}
