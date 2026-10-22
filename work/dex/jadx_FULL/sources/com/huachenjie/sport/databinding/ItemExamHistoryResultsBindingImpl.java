package com.huachenjie.sport.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.binding_adapter.DrawablesBindingAdapter;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.ExamDetailData;
import com.huachenjie.sport.bean.ExamResultData;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ItemExamHistoryResultsBindingImpl extends ItemExamHistoryResultsBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36502a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13573a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13574a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final ItemExamInfoBinding f13575a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f13576a;

    @NonNull
    public final LinearLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f13577b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public final ItemExamInfoBinding f13578b;

    @NonNull
    public final LinearLayout c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @Nullable
    public final ItemExamInfoBinding f13579c;

    @Nullable
    public final ItemExamInfoBinding d;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(17);
        f13573a = includedLayouts;
        int i = R.layout.item_exam_info;
        includedLayouts.setIncludes(10, new String[]{"item_exam_info", "item_exam_info"}, new int[]{12, 13}, new int[]{i, i});
        includedLayouts.setIncludes(11, new String[]{"item_exam_info", "item_exam_info"}, new int[]{14, 15}, new int[]{i, i});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36502a = sparseIntArray;
        sparseIntArray.put(R.id.v_divider, 16);
    }

    public ItemExamHistoryResultsBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 17, f13573a, f36502a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String durationFmt;
        String submitTime;
        String examName;
        String str;
        String score;
        String startTimeFmt;
        String rightQuestionTotalFmt;
        boolean z;
        boolean z2;
        boolean z3;
        ExamResultData result;
        boolean zShowReviewResult;
        synchronized (this) {
            j = this.f13574a;
            this.f13574a = 0L;
        }
        ExamDetailData examDetailData = ((ItemExamHistoryResultsBinding) this).f13571a;
        long j2 = 3 & j;
        Integer num = null;
        if (j2 != 0) {
            if (examDetailData != null) {
                result = examDetailData.getResult();
                submitTime = examDetailData.getSubmitTime();
                examName = examDetailData.getExamName();
                zShowReviewResult = examDetailData.showReviewResult();
            } else {
                result = null;
                submitTime = null;
                examName = null;
                zShowReviewResult = false;
            }
            if (result != null) {
                String errorQuestionTotalFmt = result.getErrorQuestionTotalFmt();
                Integer scoreLevel = result.getScoreLevel();
                score = result.getScore();
                startTimeFmt = result.getStartTimeFmt();
                rightQuestionTotalFmt = result.getRightQuestionTotalFmt();
                durationFmt = result.getDurationFmt();
                str = errorQuestionTotalFmt;
                num = scoreLevel;
            } else {
                durationFmt = null;
                str = null;
                score = null;
                startTimeFmt = null;
                rightQuestionTotalFmt = null;
            }
            int iSafeUnbox = ViewDataBinding.safeUnbox(num);
            boolean z4 = iSafeUnbox == 1;
            z3 = iSafeUnbox == 2;
            z2 = zShowReviewResult;
            z = z4;
        } else {
            durationFmt = null;
            submitTime = null;
            examName = null;
            str = null;
            score = null;
            startTimeFmt = null;
            rightQuestionTotalFmt = null;
            z = false;
            z2 = false;
            z3 = false;
        }
        if ((j & 2) != 0) {
            ConstraintLayout constraintLayout = ((ItemExamHistoryResultsBinding) this).f13570a;
            DrawablesBindingAdapter.h(constraintLayout, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(constraintLayout, R.color.white)), 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 8.0f, 0.0f, 8.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            LinearLayout linearLayout = ((ItemExamHistoryResultsBinding) this).f13568a;
            DrawablesBindingAdapter.h(linearLayout, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(linearLayout, R.color.color_EFF3FC)), 0, 0.0f, 0.0f, 0.0f, 0.0f, 8.0f, 0.0f, 8.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            this.f13575a.k(Float.valueOf(12.0f));
            this.f13575a.l("考试用时：");
            this.f13578b.k(Float.valueOf(12.0f));
            this.f13578b.l("考试日期：");
            this.f13579c.k(Float.valueOf(12.0f));
            this.f13579c.l("答对：");
            this.d.k(Float.valueOf(12.0f));
            this.d.l("答错：");
            TextView textView = ((ItemExamHistoryResultsBinding) this).c;
            int i = R.color.color_8997A4;
            DrawablesBindingAdapter.h(textView, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(textView, i)), 0, 0.0f, 0.0f, 0.0f, 2.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            TextView textView2 = super.d;
            int i2 = R.color.color_main_v2;
            DrawablesBindingAdapter.h(textView2, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(textView2, i2)), 0, 0.0f, 0.0f, 0.0f, 2.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            TextView textView3 = this.e;
            DrawablesBindingAdapter.g(textView3, Integer.valueOf(ViewDataBinding.getColorFromResource(textView3, i2)), null, null, Integer.valueOf(ViewDataBinding.getColorFromResource(this.e, i)), null, null, null);
        }
        if (j2 != 0) {
            this.f13575a.setContent(durationFmt);
            this.f13578b.setContent(startTimeFmt);
            this.f13579c.setContent(rightQuestionTotalFmt);
            this.d.setContent(str);
            CommonBindingAdapter.l0(this.f13576a, z2);
            TextViewBindingAdapter.setText(((ItemExamHistoryResultsBinding) this).f13569a, examName);
            TextViewBindingAdapter.setText(((ItemExamHistoryResultsBinding) this).b, submitTime);
            CommonBindingAdapter.l0(((ItemExamHistoryResultsBinding) this).c, z);
            CommonBindingAdapter.l0(((ItemExamHistoryResultsBinding) this).f13572a, z2);
            CommonBindingAdapter.l0(super.d, z3);
            CommonBindingAdapter.e0(this.e, z3);
            TextViewBindingAdapter.setText(this.e, score);
        }
        ViewDataBinding.executeBindingsOn(this.f13575a);
        ViewDataBinding.executeBindingsOn(this.f13578b);
        ViewDataBinding.executeBindingsOn(this.f13579c);
        ViewDataBinding.executeBindingsOn(this.d);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f13574a != 0) {
                return true;
            }
            return this.f13575a.hasPendingBindings() || this.f13578b.hasPendingBindings() || this.f13579c.hasPendingBindings() || this.d.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13574a = 2L;
        }
        this.f13575a.invalidateAll();
        this.f13578b.invalidateAll();
        this.f13579c.invalidateAll();
        this.d.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ItemExamHistoryResultsBinding
    public void k(@Nullable ExamDetailData examDetailData) {
        ((ItemExamHistoryResultsBinding) this).f13571a = examDetailData;
        synchronized (this) {
            this.f13574a |= 1;
        }
        notifyPropertyChanged(ok0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f13575a.setLifecycleOwner(lifecycleOwner);
        this.f13578b.setLifecycleOwner(lifecycleOwner);
        this.f13579c.setLifecycleOwner(lifecycleOwner);
        this.d.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.g != i) {
            return false;
        }
        k((ExamDetailData) obj);
        return true;
    }

    public ItemExamHistoryResultsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[6], (LinearLayout) objArr[1], (TextView) objArr[2], (TextView) objArr[3], (TextView) objArr[9], (BLTextView) objArr[5], (TextView) objArr[8], (TextView) objArr[7], (View) objArr[16]);
        this.f13574a = -1L;
        ((ItemExamHistoryResultsBinding) this).f13570a.setTag(null);
        ((ItemExamHistoryResultsBinding) this).f13568a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13577b = constraintLayout;
        constraintLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[10];
        this.b = linearLayout;
        linearLayout.setTag(null);
        ItemExamInfoBinding itemExamInfoBinding = (ItemExamInfoBinding) objArr[12];
        this.f13575a = itemExamInfoBinding;
        setContainedBinding(itemExamInfoBinding);
        ItemExamInfoBinding itemExamInfoBinding2 = (ItemExamInfoBinding) objArr[13];
        this.f13578b = itemExamInfoBinding2;
        setContainedBinding(itemExamInfoBinding2);
        LinearLayout linearLayout2 = (LinearLayout) objArr[11];
        this.c = linearLayout2;
        linearLayout2.setTag(null);
        ItemExamInfoBinding itemExamInfoBinding3 = (ItemExamInfoBinding) objArr[14];
        this.f13579c = itemExamInfoBinding3;
        setContainedBinding(itemExamInfoBinding3);
        ItemExamInfoBinding itemExamInfoBinding4 = (ItemExamInfoBinding) objArr[15];
        this.d = itemExamInfoBinding4;
        setContainedBinding(itemExamInfoBinding4);
        BLView bLView = (BLView) objArr[4];
        this.f13576a = bLView;
        bLView.setTag(null);
        ((ItemExamHistoryResultsBinding) this).f13569a.setTag(null);
        ((ItemExamHistoryResultsBinding) this).b.setTag(null);
        ((ItemExamHistoryResultsBinding) this).c.setTag(null);
        ((ItemExamHistoryResultsBinding) this).f13572a.setTag(null);
        super.d.setTag(null);
        this.e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
