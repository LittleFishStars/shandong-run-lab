package com.huachenjie.sport.page.mine.exam;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.ExamDetailData;
import com.huachenjie.sport.databinding.ItemExamHistoryResultsBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/sport/page/mine/exam/ExamHistoryResultsAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/sport/bean/ExamDetailData;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/sport/databinding/ItemExamHistoryResultsBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "()V", "convert", "", "holder", "item", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ExamHistoryResultsAdapter extends BaseQuickAdapter<ExamDetailData, BaseDataBindingHolder<ItemExamHistoryResultsBinding>> implements LoadMoreModule {
    public ExamHistoryResultsAdapter() {
        super(R.layout.item_exam_history_results, null, 2, null);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<ItemExamHistoryResultsBinding> holder, @NotNull ExamDetailData item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemExamHistoryResultsBinding itemExamHistoryResultsBinding = (ItemExamHistoryResultsBinding) holder.getDataBinding();
        if (itemExamHistoryResultsBinding != null) {
            itemExamHistoryResultsBinding.k(item);
            itemExamHistoryResultsBinding.executePendingBindings();
        }
    }
}
