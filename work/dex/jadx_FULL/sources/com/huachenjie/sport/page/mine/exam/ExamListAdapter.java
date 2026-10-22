package com.huachenjie.sport.page.mine.exam;

import androidx.annotation.NonNull;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.ExamListData;
import com.huachenjie.sport.databinding.ItemExamListBinding;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ExamListAdapter extends BaseQuickAdapter<ExamListData, BaseDataBindingHolder<ItemExamListBinding>> {
    public ExamListAdapter() {
        super(R.layout.item_exam_list);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NonNull BaseDataBindingHolder<ItemExamListBinding> baseDataBindingHolder, ExamListData examListData) {
        ItemExamListBinding itemExamListBinding = (ItemExamListBinding) baseDataBindingHolder.getDataBinding();
        if (itemExamListBinding != null) {
            itemExamListBinding.k(examListData);
            itemExamListBinding.executePendingBindings();
        }
    }
}
