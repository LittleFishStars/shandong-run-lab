package com.huachenjie.sport.page.mine.exam;

import androidx.annotation.NonNull;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.Question;
import com.huachenjie.sport.databinding.ItemExamAnswerSheetBinding;
import com.zj.adlib.a63;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ExamAnswerSheetAdapter extends BaseQuickAdapter<Question, BaseDataBindingHolder<ItemExamAnswerSheetBinding>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f36650a;

    public ExamAnswerSheetAdapter(long j) {
        super(R.layout.item_exam_answer_sheet);
        this.f36650a = j;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NonNull BaseDataBindingHolder<ItemExamAnswerSheetBinding> baseDataBindingHolder, Question question) {
        Set<Long> set;
        ItemExamAnswerSheetBinding itemExamAnswerSheetBinding = (ItemExamAnswerSheetBinding) baseDataBindingHolder.getDataBinding();
        Map<Long, Set<Long>> mapD = a63.d(Long.valueOf(this.f36650a));
        if (itemExamAnswerSheetBinding != null) {
            boolean z = false;
            if (mapD != null && (set = mapD.get(question.getQuestionCode())) != null && set.size() > 0) {
                z = true;
            }
            itemExamAnswerSheetBinding.l(Integer.valueOf(baseDataBindingHolder.getBindingAdapterPosition() + 1));
            itemExamAnswerSheetBinding.setChecked(Boolean.valueOf(z));
            itemExamAnswerSheetBinding.executePendingBindings();
        }
    }
}
