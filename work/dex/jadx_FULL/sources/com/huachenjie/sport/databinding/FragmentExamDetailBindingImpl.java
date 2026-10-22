package com.huachenjie.sport.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
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
import com.huachenjie.sport.bean.ExamStatus;
import com.huachenjie.sport.page.mine.exam.ExamDetailActivity;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class FragmentExamDetailBindingImpl extends FragmentExamDetailBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36475a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13475a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13476a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f13477a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f13478a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f13479a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final ItemExamInfoBinding f13480a;

    @Nullable
    public final ItemExamInfoBinding b;

    @Nullable
    public final ItemExamInfoBinding c;

    @Nullable
    public final ItemExamInfoBinding d;

    @Nullable
    public final ItemExamInfoBinding e;

    @Nullable
    public final ItemExamInfoBinding f;

    @Nullable
    public final ItemExamInfoBinding g;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ExamDetailActivity.a f36476a;

        public a a(ExamDetailActivity.a aVar) {
            this.f36476a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36476a.c(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(14);
        f13475a = includedLayouts;
        int i = R.layout.item_exam_info;
        includedLayouts.setIncludes(4, new String[]{"item_exam_info", "item_exam_info", "item_exam_info", "item_exam_info", "item_exam_info", "item_exam_info", "item_exam_info"}, new int[]{7, 8, 9, 10, 11, 12, 13}, new int[]{i, i, i, i, i, i, i});
        f36475a = null;
    }

    public FragmentExamDetailBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 14, f13475a, f36475a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int triangleRes;
        String str;
        boolean z;
        String str2;
        boolean z2;
        boolean z3;
        String str3;
        String str4;
        int i;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        a aVarA;
        ExamResultData result;
        String passScore;
        String examDesc;
        ExamStatus examStatusEnum;
        String examTimeFmt;
        String examTypeName;
        String examStandardFmt;
        String examLocation;
        String examName;
        boolean zShowRetest;
        String semesterName;
        String showName;
        synchronized (this) {
            j = this.f13476a;
            this.f13476a = 0L;
        }
        ExamDetailData examDetailData = ((FragmentExamDetailBinding) this).f13472a;
        ExamDetailActivity.a aVar = ((FragmentExamDetailBinding) this).f13473a;
        long j2 = j & 5;
        if (j2 != 0) {
            if (examDetailData != null) {
                passScore = examDetailData.getPassScore();
                examDesc = examDetailData.getExamDesc();
                examStatusEnum = examDetailData.getExamStatusEnum();
                examTimeFmt = examDetailData.getExamTimeFmt();
                examTypeName = examDetailData.getExamTypeName();
                examStandardFmt = examDetailData.getExamStandardFmt();
                examLocation = examDetailData.getExamLocation();
                examName = examDetailData.getExamName();
                zShowRetest = examDetailData.showRetest();
                semesterName = examDetailData.getSemesterName();
                result = examDetailData.getResult();
            } else {
                result = null;
                passScore = null;
                examDesc = null;
                examStatusEnum = null;
                examTimeFmt = null;
                examTypeName = null;
                examStandardFmt = null;
                examLocation = null;
                examName = null;
                zShowRetest = false;
                semesterName = null;
            }
            z = examStatusEnum == ExamStatus.InExam;
            boolean z4 = result == null;
            if (j2 != 0) {
                j |= z ? 16L : 8L;
            }
            if (examStatusEnum != null) {
                triangleRes = examStatusEnum.getTriangleRes();
                int buttonColor = examStatusEnum.getButtonColor();
                showName = examStatusEnum.getShowName();
                i = buttonColor;
            } else {
                triangleRes = 0;
                showName = null;
                i = 0;
            }
            str = z ? "进入考试" : "未开始考试";
            str2 = showName;
            str5 = examTimeFmt;
            str6 = examTypeName;
            str7 = examStandardFmt;
            str8 = examLocation;
            str9 = examName;
            str10 = semesterName;
            str3 = passScore;
            str4 = examDesc;
            z2 = zShowRetest;
            z3 = z4;
        } else {
            triangleRes = 0;
            str = null;
            z = false;
            str2 = null;
            z2 = false;
            z3 = false;
            str3 = null;
            str4 = null;
            i = 0;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
            str9 = null;
            str10 = null;
        }
        long j3 = j & 6;
        if (j3 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f13479a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f13479a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if ((j & 5) != 0) {
            DrawablesBindingAdapter.e(((FragmentExamDetailBinding) this).f36474a, triangleRes);
            DrawablesBindingAdapter.e(((FragmentExamDetailBinding) this).b, triangleRes);
            CommonBindingAdapter.l0(this.f13478a, z3);
            this.f13480a.setContent(str5);
            this.b.setContent(str10);
            this.c.setContent(str6);
            this.d.setContent(str8);
            this.e.setContent(str7);
            this.f.setContent(str3);
            this.g.setContent(str4);
            TextViewBindingAdapter.setText(((FragmentExamDetailBinding) this).f13471a, str2);
            DrawablesBindingAdapter.h(((FragmentExamDetailBinding) this).f13471a, 0, Integer.valueOf(i), 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 8.0f, 0.0f, 8.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            CommonBindingAdapter.l0(((FragmentExamDetailBinding) this).f13474b, z2);
            CommonBindingAdapter.e0(((FragmentExamDetailBinding) this).f13474b, z);
            TextViewBindingAdapter.setText(((FragmentExamDetailBinding) this).f13474b, str);
            TextViewBindingAdapter.setText(super.c, str9);
        }
        if ((j & 4) != 0) {
            LinearLayout linearLayout = this.f13477a;
            int i2 = R.color.white;
            DrawablesBindingAdapter.h(linearLayout, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(linearLayout, i2)), 0, 0.0f, 0.0f, 0.0f, 8.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            this.f13480a.l("考试时间：");
            this.b.l("学期：");
            this.c.l("考试性质：");
            this.d.l("考试地点：");
            this.e.l("考试标准：");
            this.f.l("合格标准：");
            this.g.l("考试说明：");
            TextView textView = ((FragmentExamDetailBinding) this).f13474b;
            DrawablesBindingAdapter.h(textView, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(textView, R.color.color_main_v2)), 0, 0.0f, 0.0f, 0.0f, 8.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(((FragmentExamDetailBinding) this).f13474b, R.color.color_D7D7D7)), 0, 0.0f, 0.0f, 0.0f, 8.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            TextView textView2 = ((FragmentExamDetailBinding) this).f13474b;
            DrawablesBindingAdapter.g(textView2, Integer.valueOf(ViewDataBinding.getColorFromResource(textView2, i2)), null, null, Integer.valueOf(ViewDataBinding.getColorFromResource(((FragmentExamDetailBinding) this).f13474b, R.color.color_333333)), null, null, null);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(((FragmentExamDetailBinding) this).f13474b, aVarA, null);
        }
        ViewDataBinding.executeBindingsOn(this.f13480a);
        ViewDataBinding.executeBindingsOn(this.b);
        ViewDataBinding.executeBindingsOn(this.c);
        ViewDataBinding.executeBindingsOn(this.d);
        ViewDataBinding.executeBindingsOn(this.e);
        ViewDataBinding.executeBindingsOn(this.f);
        ViewDataBinding.executeBindingsOn(this.g);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f13476a != 0) {
                return true;
            }
            return this.f13480a.hasPendingBindings() || this.b.hasPendingBindings() || this.c.hasPendingBindings() || this.d.hasPendingBindings() || this.e.hasPendingBindings() || this.f.hasPendingBindings() || this.g.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13476a = 4L;
        }
        this.f13480a.invalidateAll();
        this.b.invalidateAll();
        this.c.invalidateAll();
        this.d.invalidateAll();
        this.e.invalidateAll();
        this.f.invalidateAll();
        this.g.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.FragmentExamDetailBinding
    public void l(@Nullable ExamDetailActivity.a aVar) {
        ((FragmentExamDetailBinding) this).f13473a = aVar;
        synchronized (this) {
            this.f13476a |= 2;
        }
        notifyPropertyChanged(ok0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.FragmentExamDetailBinding
    public void m(@Nullable ExamDetailData examDetailData) {
        ((FragmentExamDetailBinding) this).f13472a = examDetailData;
        synchronized (this) {
            this.f13476a |= 1;
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
        this.f13480a.setLifecycleOwner(lifecycleOwner);
        this.b.setLifecycleOwner(lifecycleOwner);
        this.c.setLifecycleOwner(lifecycleOwner);
        this.d.setLifecycleOwner(lifecycleOwner);
        this.e.setLifecycleOwner(lifecycleOwner);
        this.f.setLifecycleOwner(lifecycleOwner);
        this.g.setLifecycleOwner(lifecycleOwner);
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

    public FragmentExamDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[2], (ImageView) objArr[3], (TextView) objArr[5], (TextView) objArr[6], (TextView) objArr[1]);
        this.f13476a = -1L;
        ((FragmentExamDetailBinding) this).f36474a.setTag(null);
        ((FragmentExamDetailBinding) this).b.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13478a = constraintLayout;
        constraintLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[4];
        this.f13477a = linearLayout;
        linearLayout.setTag(null);
        ItemExamInfoBinding itemExamInfoBinding = (ItemExamInfoBinding) objArr[7];
        this.f13480a = itemExamInfoBinding;
        setContainedBinding(itemExamInfoBinding);
        ItemExamInfoBinding itemExamInfoBinding2 = (ItemExamInfoBinding) objArr[8];
        this.b = itemExamInfoBinding2;
        setContainedBinding(itemExamInfoBinding2);
        ItemExamInfoBinding itemExamInfoBinding3 = (ItemExamInfoBinding) objArr[9];
        this.c = itemExamInfoBinding3;
        setContainedBinding(itemExamInfoBinding3);
        ItemExamInfoBinding itemExamInfoBinding4 = (ItemExamInfoBinding) objArr[10];
        this.d = itemExamInfoBinding4;
        setContainedBinding(itemExamInfoBinding4);
        ItemExamInfoBinding itemExamInfoBinding5 = (ItemExamInfoBinding) objArr[11];
        this.e = itemExamInfoBinding5;
        setContainedBinding(itemExamInfoBinding5);
        ItemExamInfoBinding itemExamInfoBinding6 = (ItemExamInfoBinding) objArr[12];
        this.f = itemExamInfoBinding6;
        setContainedBinding(itemExamInfoBinding6);
        ItemExamInfoBinding itemExamInfoBinding7 = (ItemExamInfoBinding) objArr[13];
        this.g = itemExamInfoBinding7;
        setContainedBinding(itemExamInfoBinding7);
        ((FragmentExamDetailBinding) this).f13471a.setTag(null);
        ((FragmentExamDetailBinding) this).f13474b.setTag(null);
        super.c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
