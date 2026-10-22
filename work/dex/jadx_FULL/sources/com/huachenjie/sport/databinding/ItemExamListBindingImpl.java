package com.huachenjie.sport.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.binding_adapter.DrawablesBindingAdapter;
import com.huachenjie.common.widget.CheckTextView;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.ExamListData;
import com.huachenjie.sport.bean.ExamStatus;
import com.huachenjie.sport.bean.ExamType;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ItemExamListBindingImpl extends ItemExamListBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36506a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13587a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13588a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f13589a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CheckTextView f13590a;

    @NonNull
    public final View b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f13591b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36506a = sparseIntArray;
        sparseIntArray.put(R.id.iv_time_icon, 8);
        sparseIntArray.put(R.id.v_divider, 9);
    }

    public ItemExamListBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, f13587a, f36506a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zSafeUnbox;
        String examName;
        String showName;
        String semesterName;
        String examTimeFmt;
        String examTypeName;
        int buttonColor;
        ExamStatus examStatusEnum;
        Boolean currentSemester;
        ExamType examTypeEnum;
        synchronized (this) {
            j = this.f13588a;
            this.f13588a = 0L;
        }
        ExamListData examListData = ((ItemExamListBinding) this).f13586a;
        long j2 = 3 & j;
        int iconRes = 0;
        if (j2 != 0) {
            if (examListData != null) {
                examStatusEnum = examListData.getExamStatusEnum();
                semesterName = examListData.getSemesterName();
                examTimeFmt = examListData.getExamTimeFmt();
                examTypeName = examListData.getExamTypeName();
                currentSemester = examListData.getCurrentSemester();
                examTypeEnum = examListData.getExamTypeEnum();
                examName = examListData.getExamName();
            } else {
                examName = null;
                examStatusEnum = null;
                semesterName = null;
                examTimeFmt = null;
                examTypeName = null;
                currentSemester = null;
                examTypeEnum = null;
            }
            if (examStatusEnum != null) {
                buttonColor = examStatusEnum.getButtonColor();
                showName = examStatusEnum.getShowName();
            } else {
                showName = null;
                buttonColor = 0;
            }
            zSafeUnbox = ViewDataBinding.safeUnbox(currentSemester);
            if (examTypeEnum != null) {
                iconRes = examTypeEnum.getIconRes();
            }
        } else {
            zSafeUnbox = false;
            examName = null;
            showName = null;
            semesterName = null;
            examTimeFmt = null;
            examTypeName = null;
            buttonColor = 0;
        }
        if (j2 != 0) {
            DrawablesBindingAdapter.e(((ItemExamListBinding) this).b, iconRes);
            TextViewBindingAdapter.setText(this.f13591b, examTimeFmt);
            TextViewBindingAdapter.setText(this.c, examTypeName);
            CommonBindingAdapter.z(this.f13590a, zSafeUnbox);
            TextViewBindingAdapter.setText(this.f13590a, semesterName);
            this.f13590a.setChecked(zSafeUnbox);
            TextViewBindingAdapter.setText(this.d, showName);
            DrawablesBindingAdapter.h(this.d, 0, Integer.valueOf(buttonColor), 0, 0.0f, 0.0f, 0.0f, 2.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            TextViewBindingAdapter.setText(((ItemExamListBinding) this).f13585a, examName);
        }
        if ((j & 2) != 0) {
            View view = this.b;
            DrawablesBindingAdapter.h(view, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(view, R.color.white)), 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 8.0f, 0.0f, 8.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            CheckTextView checkTextView = this.f13590a;
            DrawablesBindingAdapter.g(checkTextView, Integer.valueOf(ViewDataBinding.getColorFromResource(checkTextView, R.color.color_666666)), Integer.valueOf(ViewDataBinding.getColorFromResource(this.f13590a, R.color.color_main_v2)), null, null, null, null, null);
            TextView textView = ((ItemExamListBinding) this).f13585a;
            DrawablesBindingAdapter.h(textView, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(textView, R.color.color_EFF3FC)), 0, 0.0f, 0.0f, 0.0f, 0.0f, 8.0f, 0.0f, 8.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13588a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13588a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ItemExamListBinding
    public void k(@Nullable ExamListData examListData) {
        ((ItemExamListBinding) this).f13586a = examListData;
        synchronized (this) {
            this.f13588a |= 1;
        }
        notifyPropertyChanged(ok0.o);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.o != i) {
            return false;
        }
        k((ExamListData) obj);
        return true;
    }

    public ItemExamListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[8], (ImageView) objArr[4], (TextView) objArr[1], (View) objArr[9]);
        this.f13588a = -1L;
        ((ItemExamListBinding) this).b.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13589a = constraintLayout;
        constraintLayout.setTag(null);
        View view2 = (View) objArr[2];
        this.b = view2;
        view2.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.f13591b = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[5];
        this.c = textView2;
        textView2.setTag(null);
        CheckTextView checkTextView = (CheckTextView) objArr[6];
        this.f13590a = checkTextView;
        checkTextView.setTag(null);
        TextView textView3 = (TextView) objArr[7];
        this.d = textView3;
        textView3.setTag(null);
        ((ItemExamListBinding) this).f13585a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
