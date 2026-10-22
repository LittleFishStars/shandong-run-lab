package com.huachenjie.sport.page.mine.exam;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.ExamQuestionData;
import com.huachenjie.sport.bean.ExamQuestionType;
import com.huachenjie.sport.bean.Option;
import com.huachenjie.sport.bean.Question;
import com.huachenjie.sport.databinding.ItemExamQuestionMultipleOptionBinding;
import com.huachenjie.sport.databinding.ItemExamQuestionNameBinding;
import com.huachenjie.sport.databinding.ItemExamQuestionSingleOptionBinding;
import com.zj.adlib.a63;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ExamQuestionAdapter extends BaseMultiItemQuickAdapter<a, BaseDataBindingHolder<? extends ViewBinding>> implements OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Question f36669a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Long f13763a;

    public ExamQuestionAdapter(Long l) {
        this.f13763a = l;
        addItemType(1, R.layout.item_exam_question_name);
        addItemType(2, R.layout.item_exam_question_single_option);
        addItemType(3, R.layout.item_exam_question_multiple_option);
        setOnItemClickListener(this);
    }

    public void e(Question question) {
        this.f36669a = question;
        Map<Long, Set<Long>> mapD = a63.d(this.f13763a);
        Set<Long> hashSet = mapD == null ? null : mapD.get(question.getQuestionCode());
        if (hashSet == null) {
            hashSet = new HashSet<>();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a(1, question.getQuestionName()));
        if (question.getOptions() != null) {
            ExamQuestionType questionTypeEnum = question.getQuestionTypeEnum();
            for (Option option : question.getOptions()) {
                a aVar = new a(questionTypeEnum == ExamQuestionType.Multiple ? 3 : 2, option.getOptionName(), hashSet.contains(option.getQuestionOptionsCode()));
                aVar.f36670a = option;
                arrayList.add(aVar);
            }
        }
        setList(arrayList);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.listener.OnItemClickListener
    @SuppressLint({"NotifyDataSetChanged"})
    public void onItemClick(@NonNull BaseQuickAdapter<?, ?> baseQuickAdapter, @NonNull View view, int i) {
        ExamQuestionData examQuestionDataE;
        if (this.f36669a.getOptions() == null || this.f36669a.getOptions().size() <= i - 1 || i == 0 || (examQuestionDataE = a63.e(this.f13763a)) == null || examQuestionDataE.getRemainingTime() == null || examQuestionDataE.getRemainingTime().intValue() <= 0) {
            return;
        }
        Map mapD = a63.d(this.f13763a);
        if (mapD == null) {
            mapD = new HashMap();
        }
        Set hashSet = (Set) mapD.get(this.f36669a.getQuestionCode());
        if (hashSet == null) {
            hashSet = new HashSet();
        }
        if (this.f36669a.getQuestionTypeEnum() == ExamQuestionType.Multiple || ((a) getItem(i)).f13764a) {
            Option option = ((a) getItem(i)).f36670a;
            ((a) getItem(i)).f13764a = true ^ ((a) getItem(i)).f13764a;
            if (((a) getItem(i)).f13764a) {
                hashSet.add(option.getQuestionOptionsCode());
            } else {
                hashSet.remove(option.getQuestionOptionsCode());
            }
        } else {
            for (int i2 = 1; i2 < getData().size(); i2++) {
                Option option2 = ((a) getItem(i2)).f36670a;
                if (i2 == i) {
                    ((a) getItem(i2)).f13764a = true;
                    hashSet.add(option2.getQuestionOptionsCode());
                } else {
                    ((a) getItem(i2)).f13764a = false;
                    hashSet.remove(option2.getQuestionOptionsCode());
                }
            }
        }
        if (hashSet.isEmpty()) {
            mapD.remove(this.f36669a.getQuestionCode());
        } else {
            mapD.put(this.f36669a.getQuestionCode(), hashSet);
        }
        a63.g(this.f13763a, mapD);
        notifyDataSetChanged();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NonNull BaseDataBindingHolder<? extends ViewBinding> baseDataBindingHolder, a aVar) {
        ViewDataBinding dataBinding = baseDataBindingHolder.getDataBinding();
        if (dataBinding != null) {
            if (dataBinding instanceof ItemExamQuestionNameBinding) {
                ((ItemExamQuestionNameBinding) dataBinding).i(aVar.f);
            } else if (dataBinding instanceof ItemExamQuestionSingleOptionBinding) {
                ItemExamQuestionSingleOptionBinding itemExamQuestionSingleOptionBinding = (ItemExamQuestionSingleOptionBinding) dataBinding;
                itemExamQuestionSingleOptionBinding.k(aVar.f);
                itemExamQuestionSingleOptionBinding.setChecked(Boolean.valueOf(aVar.f13764a));
            } else if (dataBinding instanceof ItemExamQuestionMultipleOptionBinding) {
                ItemExamQuestionMultipleOptionBinding itemExamQuestionMultipleOptionBinding = (ItemExamQuestionMultipleOptionBinding) dataBinding;
                itemExamQuestionMultipleOptionBinding.k(aVar.f);
                itemExamQuestionMultipleOptionBinding.setChecked(Boolean.valueOf(aVar.f13764a));
            }
            dataBinding.executePendingBindings();
        }
    }

    public static class a implements MultiItemEntity {
        public static final int L = 1;
        public static final int M = 2;
        public static final int N = 3;
        public final int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Option f36670a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f13764a;
        public final String f;

        public a(int i, String str, boolean z) {
            this.K = i;
            this.f = str;
            this.f13764a = z;
        }

        @Override // com.chad.library.adapter.base.entity.MultiItemEntity
        /* JADX INFO: renamed from: getItemType */
        public int getPostType() {
            return this.K;
        }

        public a(int i, String str) {
            this.K = i;
            this.f = str;
        }
    }
}
