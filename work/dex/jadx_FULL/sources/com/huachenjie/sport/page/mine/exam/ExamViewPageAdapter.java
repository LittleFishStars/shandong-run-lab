package com.huachenjie.sport.page.mine.exam;

import androidx.annotation.NonNull;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.Question;
import com.huachenjie.sport.databinding.ItemExamQuestionBinding;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ExamViewPageAdapter extends BaseQuickAdapter<Question, BaseDataBindingHolder<ItemExamQuestionBinding>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f36671a;

    public ExamViewPageAdapter(Long l) {
        super(R.layout.item_exam_question);
        this.f36671a = l;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NonNull BaseDataBindingHolder<ItemExamQuestionBinding> baseDataBindingHolder, Question question) {
        ItemExamQuestionBinding itemExamQuestionBinding = (ItemExamQuestionBinding) baseDataBindingHolder.getDataBinding();
        if (itemExamQuestionBinding != null) {
            ExamQuestionAdapter examQuestionAdapterF = itemExamQuestionBinding.f();
            if (examQuestionAdapterF == null) {
                examQuestionAdapterF = new ExamQuestionAdapter(this.f36671a);
            }
            examQuestionAdapterF.e(question);
            itemExamQuestionBinding.k(examQuestionAdapterF);
            itemExamQuestionBinding.executePendingBindings();
        }
    }
}
