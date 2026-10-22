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
import com.huachenjie.sport.bean.ExamAttendFlag;
import com.huachenjie.sport.bean.ExamDetailData;
import com.huachenjie.sport.bean.ExamResultData;
import com.huachenjie.sport.page.mine.exam.ExamDetailActivity;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class FragmentExamResultBindingImpl extends FragmentExamResultBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36478a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13487a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13488a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f13489a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f13490a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final ItemExamInfoBinding f13491a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f13492a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f13493a;

    @Nullable
    public final ItemExamInfoBinding b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLView f13494b;

    @NonNull
    public final LinearLayout c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @Nullable
    public final ItemExamInfoBinding f13495c;

    @NonNull
    public final LinearLayout d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @Nullable
    public final ItemExamInfoBinding f13496d;

    @NonNull
    public final LinearLayout e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @Nullable
    public final ItemExamInfoBinding f13497e;

    @NonNull
    public final LinearLayout f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    @Nullable
    public final ItemExamInfoBinding f13498f;

    @NonNull
    public final TextView g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    @Nullable
    public final ItemExamInfoBinding f13499g;

    @Nullable
    public final ItemExamInfoBinding h;

    @Nullable
    public final ItemExamInfoBinding i;

    @Nullable
    public final ItemExamInfoBinding j;

    @Nullable
    public final ItemExamInfoBinding k;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ExamDetailActivity.a f36479a;

        public a a(ExamDetailActivity.a aVar) {
            this.f36479a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36479a.c(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ExamDetailActivity.a f36480a;

        public b a(ExamDetailActivity.a aVar) {
            this.f36480a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36480a.b(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(29);
        f13487a = includedLayouts;
        int i = R.layout.item_exam_info;
        includedLayouts.setIncludes(10, new String[]{"item_exam_info", "item_exam_info"}, new int[]{17, 18}, new int[]{i, i});
        includedLayouts.setIncludes(11, new String[]{"item_exam_info", "item_exam_info"}, new int[]{19, 20}, new int[]{i, i});
        includedLayouts.setIncludes(12, new String[]{"item_exam_info", "item_exam_info", "item_exam_info", "item_exam_info", "item_exam_info", "item_exam_info", "item_exam_info"}, new int[]{21, 22, 23, 24, 25, 26, 27}, new int[]{i, i, i, i, i, i, i});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36478a = sparseIntArray;
        sparseIntArray.put(R.id.v_divider, 28);
    }

    public FragmentExamResultBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 29, f13487a, f36478a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String durationFmt;
        String str;
        String str2;
        boolean z;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        boolean z2;
        boolean z3;
        boolean z4;
        String str10;
        boolean z5;
        String str11;
        boolean z6;
        String str12;
        String str13;
        a aVarA;
        b bVar;
        ExamResultData result;
        String passScore;
        String examDesc;
        String examTimeFmt;
        String examTypeName;
        String examStandardFmt;
        ExamAttendFlag examAttendFlagEnum;
        boolean zShowReviewResult;
        String examLocation;
        String examName;
        boolean zShowRetest;
        String retestTimes;
        String semesterName;
        String startTimeFmt;
        String errorQuestionTotalFmt;
        String score;
        Integer scoreLevel;
        String rightQuestionTotalFmt;
        synchronized (this) {
            j = this.f13488a;
            this.f13488a = 0L;
        }
        ExamDetailData examDetailData = ((FragmentExamResultBinding) this).f13484a;
        ExamDetailActivity.a aVar = ((FragmentExamResultBinding) this).f13485a;
        long j2 = 5 & j;
        if (j2 != 0) {
            if (examDetailData != null) {
                passScore = examDetailData.getPassScore();
                examDesc = examDetailData.getExamDesc();
                examTimeFmt = examDetailData.getExamTimeFmt();
                examTypeName = examDetailData.getExamTypeName();
                examStandardFmt = examDetailData.getExamStandardFmt();
                examAttendFlagEnum = examDetailData.getExamAttendFlagEnum();
                zShowReviewResult = examDetailData.showReviewResult();
                examLocation = examDetailData.getExamLocation();
                examName = examDetailData.getExamName();
                zShowRetest = examDetailData.showRetest();
                retestTimes = examDetailData.formatRetestTimes();
                semesterName = examDetailData.getSemesterName();
                result = examDetailData.getResult();
            } else {
                result = null;
                passScore = null;
                examDesc = null;
                examTimeFmt = null;
                examTypeName = null;
                examStandardFmt = null;
                examAttendFlagEnum = null;
                zShowReviewResult = false;
                examLocation = null;
                examName = null;
                zShowRetest = false;
                retestTimes = null;
                semesterName = null;
            }
            boolean z7 = examAttendFlagEnum == ExamAttendFlag.NotStart;
            boolean z8 = result != null;
            if (result != null) {
                startTimeFmt = result.getStartTimeFmt();
                errorQuestionTotalFmt = result.getErrorQuestionTotalFmt();
                score = result.getScore();
                scoreLevel = result.getScoreLevel();
                rightQuestionTotalFmt = result.getRightQuestionTotalFmt();
                durationFmt = result.getDurationFmt();
            } else {
                durationFmt = null;
                startTimeFmt = null;
                errorQuestionTotalFmt = null;
                score = null;
                scoreLevel = null;
                rightQuestionTotalFmt = null;
            }
            int iSafeUnbox = ViewDataBinding.safeUnbox(scoreLevel);
            boolean z9 = iSafeUnbox == 1;
            boolean z10 = iSafeUnbox == 2;
            str = semesterName;
            str3 = startTimeFmt;
            str13 = score;
            str12 = examDesc;
            str5 = examStandardFmt;
            str11 = retestTimes;
            str8 = examTimeFmt;
            z5 = zShowReviewResult;
            z2 = z10;
            str6 = passScore;
            str4 = examLocation;
            z6 = zShowRetest;
            z3 = z7;
            z = z8;
            str10 = examName;
            z4 = z9;
            str9 = examTypeName;
            str2 = errorQuestionTotalFmt;
            str7 = rightQuestionTotalFmt;
        } else {
            durationFmt = null;
            str = null;
            str2 = null;
            z = false;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
            str9 = null;
            z2 = false;
            z3 = false;
            z4 = false;
            str10 = null;
            z5 = false;
            str11 = null;
            z6 = false;
            str12 = null;
            str13 = null;
        }
        long j3 = j & 6;
        if (j3 == 0 || aVar == null) {
            aVarA = null;
            bVar = null;
        } else {
            b bVar2 = this.f13490a;
            if (bVar2 == null) {
                bVar2 = new b();
                this.f13490a = bVar2;
            }
            b bVarA = bVar2.a(aVar);
            a aVar2 = this.f13489a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f13489a = aVar2;
            }
            aVarA = aVar2.a(aVar);
            bVar = bVarA;
        }
        if ((j & 4) != 0) {
            ConstraintLayout constraintLayout = ((FragmentExamResultBinding) this).f13483a;
            int i = R.color.white;
            DrawablesBindingAdapter.h(constraintLayout, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(constraintLayout, i)), 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 8.0f, 0.0f, 8.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            LinearLayout linearLayout = ((FragmentExamResultBinding) this).f13481a;
            DrawablesBindingAdapter.h(linearLayout, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(linearLayout, i)), 0, 0.0f, 0.0f, 0.0f, 8.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            LinearLayout linearLayout2 = ((FragmentExamResultBinding) this).b;
            DrawablesBindingAdapter.h(linearLayout2, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(linearLayout2, R.color.color_EFF3FC)), 0, 0.0f, 0.0f, 0.0f, 0.0f, 8.0f, 0.0f, 8.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            this.f13491a.k(Float.valueOf(12.0f));
            this.f13491a.l("考试用时：");
            this.b.k(Float.valueOf(12.0f));
            this.b.l("考试日期：");
            this.f13495c.k(Float.valueOf(12.0f));
            this.f13495c.l("答对：");
            this.f13496d.k(Float.valueOf(12.0f));
            this.f13496d.l("答错：");
            this.f13497e.l("考试时间：");
            this.f13498f.l("学期：");
            this.f13499g.l("考试性质：");
            this.h.l("考试地点：");
            this.i.l("考试标准：");
            this.j.l("合格标准：");
            this.k.l("考试说明：");
            TextView textView = ((FragmentExamResultBinding) this).f13486b;
            int i2 = R.color.color_8997A4;
            DrawablesBindingAdapter.h(textView, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(textView, i2)), 0, 0.0f, 0.0f, 0.0f, 2.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            TextView textView2 = ((FragmentExamResultBinding) this).c;
            DrawablesBindingAdapter.h(textView2, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(textView2, R.color.color_F03E4F)), 0, 0.0f, 0.0f, 0.0f, 2.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            TextView textView3 = ((FragmentExamResultBinding) this).d;
            int i3 = R.color.color_main_v2;
            DrawablesBindingAdapter.h(textView3, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(textView3, i3)), 0, 0.0f, 0.0f, 0.0f, 2.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            TextView textView4 = ((FragmentExamResultBinding) this).e;
            DrawablesBindingAdapter.g(textView4, Integer.valueOf(ViewDataBinding.getColorFromResource(textView4, i3)), null, null, Integer.valueOf(ViewDataBinding.getColorFromResource(((FragmentExamResultBinding) this).e, i2)), null, null, null);
            TextView textView5 = ((FragmentExamResultBinding) this).f;
            DrawablesBindingAdapter.h(textView5, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(textView5, i3)), 0, 0.0f, 0.0f, 0.0f, 22.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(((FragmentExamResultBinding) this).f, R.color.color_D7D7D7)), 0, 0.0f, 0.0f, 0.0f, 22.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            TextView textView6 = ((FragmentExamResultBinding) this).f;
            DrawablesBindingAdapter.g(textView6, Integer.valueOf(ViewDataBinding.getColorFromResource(textView6, i)), null, null, Integer.valueOf(ViewDataBinding.getColorFromResource(((FragmentExamResultBinding) this).f, R.color.color_333333)), null, null, null);
        }
        if (j2 != 0) {
            CommonBindingAdapter.l0(this.c, z);
            this.f13491a.setContent(durationFmt);
            this.b.setContent(str3);
            this.f13495c.setContent(str7);
            this.f13496d.setContent(str2);
            this.f13497e.setContent(str8);
            this.f13498f.setContent(str);
            this.f13499g.setContent(str9);
            this.h.setContent(str4);
            this.i.setContent(str5);
            this.j.setContent(str6);
            this.k.setContent(str12);
            boolean z11 = z6;
            CommonBindingAdapter.l0(this.f13493a, z11);
            CommonBindingAdapter.l0(this.f, z11);
            TextViewBindingAdapter.setText(this.g, str11);
            boolean z12 = z5;
            CommonBindingAdapter.l0(this.f13494b, z12);
            CommonBindingAdapter.l0(this.f13492a, z12);
            TextViewBindingAdapter.setText(((FragmentExamResultBinding) this).f13482a, str10);
            CommonBindingAdapter.l0(((FragmentExamResultBinding) this).f13486b, z4);
            CommonBindingAdapter.l0(((FragmentExamResultBinding) this).c, z3);
            boolean z13 = z2;
            CommonBindingAdapter.l0(((FragmentExamResultBinding) this).d, z13);
            CommonBindingAdapter.e0(((FragmentExamResultBinding) this).e, z13);
            TextViewBindingAdapter.setText(((FragmentExamResultBinding) this).e, str13);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.f13492a, bVar, null);
            CommonBindingAdapter.q(((FragmentExamResultBinding) this).f, aVarA, null);
        }
        ViewDataBinding.executeBindingsOn(this.f13491a);
        ViewDataBinding.executeBindingsOn(this.b);
        ViewDataBinding.executeBindingsOn(this.f13495c);
        ViewDataBinding.executeBindingsOn(this.f13496d);
        ViewDataBinding.executeBindingsOn(this.f13497e);
        ViewDataBinding.executeBindingsOn(this.f13498f);
        ViewDataBinding.executeBindingsOn(this.f13499g);
        ViewDataBinding.executeBindingsOn(this.h);
        ViewDataBinding.executeBindingsOn(this.i);
        ViewDataBinding.executeBindingsOn(this.j);
        ViewDataBinding.executeBindingsOn(this.k);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f13488a != 0) {
                return true;
            }
            return this.f13491a.hasPendingBindings() || this.b.hasPendingBindings() || this.f13495c.hasPendingBindings() || this.f13496d.hasPendingBindings() || this.f13497e.hasPendingBindings() || this.f13498f.hasPendingBindings() || this.f13499g.hasPendingBindings() || this.h.hasPendingBindings() || this.i.hasPendingBindings() || this.j.hasPendingBindings() || this.k.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13488a = 4L;
        }
        this.f13491a.invalidateAll();
        this.b.invalidateAll();
        this.f13495c.invalidateAll();
        this.f13496d.invalidateAll();
        this.f13497e.invalidateAll();
        this.f13498f.invalidateAll();
        this.f13499g.invalidateAll();
        this.h.invalidateAll();
        this.i.invalidateAll();
        this.j.invalidateAll();
        this.k.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.FragmentExamResultBinding
    public void l(@Nullable ExamDetailActivity.a aVar) {
        ((FragmentExamResultBinding) this).f13485a = aVar;
        synchronized (this) {
            this.f13488a |= 2;
        }
        notifyPropertyChanged(ok0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.FragmentExamResultBinding
    public void m(@Nullable ExamDetailData examDetailData) {
        ((FragmentExamResultBinding) this).f13484a = examDetailData;
        synchronized (this) {
            this.f13488a |= 1;
        }
        notifyPropertyChanged(ok0.o);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f13491a.setLifecycleOwner(lifecycleOwner);
        this.b.setLifecycleOwner(lifecycleOwner);
        this.f13495c.setLifecycleOwner(lifecycleOwner);
        this.f13496d.setLifecycleOwner(lifecycleOwner);
        this.f13497e.setLifecycleOwner(lifecycleOwner);
        this.f13498f.setLifecycleOwner(lifecycleOwner);
        this.f13499g.setLifecycleOwner(lifecycleOwner);
        this.h.setLifecycleOwner(lifecycleOwner);
        this.i.setLifecycleOwner(lifecycleOwner);
        this.j.setLifecycleOwner(lifecycleOwner);
        this.k.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.o == i) {
            m((ExamDetailData) obj);
        } else {
            if (ok0.k != i) {
                return false;
            }
            l((ExamDetailActivity.a) obj);
        }
        return true;
    }

    public FragmentExamResultBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[5], (LinearLayout) objArr[12], (LinearLayout) objArr[1], (TextView) objArr[2], (TextView) objArr[8], (TextView) objArr[9], (TextView) objArr[7], (TextView) objArr[6], (TextView) objArr[16], (View) objArr[28]);
        this.f13488a = -1L;
        ((FragmentExamResultBinding) this).f13483a.setTag(null);
        ((FragmentExamResultBinding) this).f13481a.setTag(null);
        ((FragmentExamResultBinding) this).b.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.c = linearLayout;
        linearLayout.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[10];
        this.d = linearLayout2;
        linearLayout2.setTag(null);
        ItemExamInfoBinding itemExamInfoBinding = (ItemExamInfoBinding) objArr[17];
        this.f13491a = itemExamInfoBinding;
        setContainedBinding(itemExamInfoBinding);
        ItemExamInfoBinding itemExamInfoBinding2 = (ItemExamInfoBinding) objArr[18];
        this.b = itemExamInfoBinding2;
        setContainedBinding(itemExamInfoBinding2);
        LinearLayout linearLayout3 = (LinearLayout) objArr[11];
        this.e = linearLayout3;
        linearLayout3.setTag(null);
        ItemExamInfoBinding itemExamInfoBinding3 = (ItemExamInfoBinding) objArr[19];
        this.f13495c = itemExamInfoBinding3;
        setContainedBinding(itemExamInfoBinding3);
        ItemExamInfoBinding itemExamInfoBinding4 = (ItemExamInfoBinding) objArr[20];
        this.f13496d = itemExamInfoBinding4;
        setContainedBinding(itemExamInfoBinding4);
        ItemExamInfoBinding itemExamInfoBinding5 = (ItemExamInfoBinding) objArr[21];
        this.f13497e = itemExamInfoBinding5;
        setContainedBinding(itemExamInfoBinding5);
        ItemExamInfoBinding itemExamInfoBinding6 = (ItemExamInfoBinding) objArr[22];
        this.f13498f = itemExamInfoBinding6;
        setContainedBinding(itemExamInfoBinding6);
        ItemExamInfoBinding itemExamInfoBinding7 = (ItemExamInfoBinding) objArr[23];
        this.f13499g = itemExamInfoBinding7;
        setContainedBinding(itemExamInfoBinding7);
        ItemExamInfoBinding itemExamInfoBinding8 = (ItemExamInfoBinding) objArr[24];
        this.h = itemExamInfoBinding8;
        setContainedBinding(itemExamInfoBinding8);
        ItemExamInfoBinding itemExamInfoBinding9 = (ItemExamInfoBinding) objArr[25];
        this.i = itemExamInfoBinding9;
        setContainedBinding(itemExamInfoBinding9);
        ItemExamInfoBinding itemExamInfoBinding10 = (ItemExamInfoBinding) objArr[26];
        this.j = itemExamInfoBinding10;
        setContainedBinding(itemExamInfoBinding10);
        ItemExamInfoBinding itemExamInfoBinding11 = (ItemExamInfoBinding) objArr[27];
        this.k = itemExamInfoBinding11;
        setContainedBinding(itemExamInfoBinding11);
        BLView bLView = (BLView) objArr[13];
        this.f13493a = bLView;
        bLView.setTag(null);
        LinearLayout linearLayout4 = (LinearLayout) objArr[14];
        this.f = linearLayout4;
        linearLayout4.setTag(null);
        TextView textView = (TextView) objArr[15];
        this.g = textView;
        textView.setTag(null);
        BLView bLView2 = (BLView) objArr[3];
        this.f13494b = bLView2;
        bLView2.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[4];
        this.f13492a = bLTextView;
        bLTextView.setTag(null);
        ((FragmentExamResultBinding) this).f13482a.setTag(null);
        ((FragmentExamResultBinding) this).f13486b.setTag(null);
        ((FragmentExamResultBinding) this).c.setTag(null);
        ((FragmentExamResultBinding) this).d.setTag(null);
        ((FragmentExamResultBinding) this).e.setTag(null);
        ((FragmentExamResultBinding) this).f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
