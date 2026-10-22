package com.huachenjie.sport.page.mine.exam;

import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.sport.bean.Question;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ExamAnswerSheetVM extends BaseVM {
    public MutableLiveData<Integer> i = new MutableLiveData<>(1);
    public MutableLiveData<Integer> j = new MutableLiveData<>(1);
    public MutableLiveData<ExamAnswerSheetAdapter> k = new MutableLiveData<>();

    public void h(Long l, ArrayList<Question> arrayList, OnItemClickListener onItemClickListener) {
        ExamAnswerSheetAdapter value = this.k.getValue();
        if (value == null) {
            value = new ExamAnswerSheetAdapter(l.longValue());
        }
        value.setOnItemClickListener(onItemClickListener);
        value.setList(arrayList);
        this.k.setValue(value);
    }
}
