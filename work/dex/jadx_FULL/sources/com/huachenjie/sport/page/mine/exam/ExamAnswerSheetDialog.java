package com.huachenjie.sport.page.mine.exam;

import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.common.base.data_binding.BaseVMBottomDialogFragment;
import com.huachenjie.common.base.data_binding.BaseVMDialogFragment;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.Question;
import com.zj.adlib.fx7;
import com.zj.adlib.i62;
import com.zj.adlib.ok0;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ExamAnswerSheetDialog extends BaseVMBottomDialogFragment<ExamAnswerSheetVM> {
    public GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 6);
    private OnItemClickListener onItemClickListener;

    public static ExamAnswerSheetDialog getInstance(Long l, int i, ArrayList<Question> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putLong("ExamCode", l.longValue());
        bundle.putInt("QuestionIndex", i);
        bundle.putParcelableArrayList("data", arrayList);
        ExamAnswerSheetDialog examAnswerSheetDialog = new ExamAnswerSheetDialog();
        examAnswerSheetDialog.setArguments(bundle);
        return examAnswerSheetDialog;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.dialog_bottom_exam_answer_sheet), Integer.valueOf(ok0.L), ((BaseVMDialogFragment) this).mState).a(Integer.valueOf(ok0.J), this.layoutManager);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMBottomDialogFragment
    public int getHeight() {
        return (int) (fx7.c() * 0.75f);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMBottomDialogFragment
    public int getWidth() {
        return -1;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    public void init(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            long j = arguments.getLong("ExamCode");
            ArrayList<Question> parcelableArrayList = arguments.getParcelableArrayList("data");
            ((ExamAnswerSheetVM) ((BaseVMDialogFragment) this).mState).h(Long.valueOf(j), parcelableArrayList, this.onItemClickListener);
            ((ExamAnswerSheetVM) ((BaseVMDialogFragment) this).mState).j.setValue(Integer.valueOf(parcelableArrayList.size()));
            ((ExamAnswerSheetVM) ((BaseVMDialogFragment) this).mState).i.setValue(Integer.valueOf(arguments.getInt("QuestionIndex", 0)));
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
        Q q = ((BaseVMDialogFragment) this).mState;
        if (q == 0 || ((ExamAnswerSheetVM) q).k.getValue() == null) {
            return;
        }
        ((ExamAnswerSheetVM) ((BaseVMDialogFragment) this).mState).k.getValue().setOnItemClickListener(onItemClickListener);
    }
}
