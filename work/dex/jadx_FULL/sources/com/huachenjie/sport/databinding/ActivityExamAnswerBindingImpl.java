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
import androidx.p002lifecycle.MutableLiveData;
import androidx.viewpager2.widget.ViewPager2;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.binding_adapter.DrawablesBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.sport.bean.ExamQuestionData;
import com.huachenjie.sport.bean.ExamQuestionType;
import com.huachenjie.sport.bean.Question;
import com.huachenjie.sport.page.mine.exam.ExamAnswerActivity;
import com.huachenjie.sport.page.mine.exam.ExamAnswerVM;
import com.huachenjie.sport.page.mine.exam.ExamViewPageAdapter;
import com.zj.adlib.ok0;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ActivityExamAnswerBindingImpl extends ActivityExamAnswerBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36391a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13211a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13212a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f13213a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f13214a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f13215a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f13216a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ExamAnswerActivity.c f36392a;

        public a a(ExamAnswerActivity.c cVar) {
            this.f36392a = cVar;
            if (cVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36392a.b(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ExamAnswerActivity.c f36393a;

        public b a(ExamAnswerActivity.c cVar) {
            this.f36393a = cVar;
            if (cVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36393a.a(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(14);
        f13211a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{7}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36391a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.sport.R.id.cl_bottom, 8);
        sparseIntArray.put(com.huachenjie.sport.R.id.tv_question_split, 9);
        sparseIntArray.put(com.huachenjie.sport.R.id.iv_submit_icon, 10);
        sparseIntArray.put(com.huachenjie.sport.R.id.tv_submit_title, 11);
        sparseIntArray.put(com.huachenjie.sport.R.id.iv_answer_sheet_icon, 12);
        sparseIntArray.put(com.huachenjie.sport.R.id.tv_answer_sheet_title, 13);
    }

    public ActivityExamAnswerBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 14, f13211a, f36391a));
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0091  */
    /* JADX WARN: Code duplicated, block: B:53:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:65:0x00cf  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String showName;
        String strValueOf;
        String strValueOf2;
        BindingTitleBean value;
        ExamViewPageAdapter value2;
        a aVarA;
        b bVarA;
        synchronized (this) {
            j = this.f13212a;
            this.f13212a = 0L;
        }
        ViewPager2.OnPageChangeCallback onPageChangeCallback = ((ActivityExamAnswerBinding) this).f13205a;
        ExamAnswerVM examAnswerVM = ((ActivityExamAnswerBinding) this).f13208a;
        ExamAnswerActivity.c cVar = ((ActivityExamAnswerBinding) this).f13207a;
        long j2 = 288 & j;
        if ((351 & j) != 0) {
            if ((j & 321) != 0) {
                MutableLiveData<Integer> mutableLiveData = examAnswerVM != null ? examAnswerVM.m : null;
                updateLiveDataRegistration(0, mutableLiveData);
                strValueOf = String.valueOf(ViewDataBinding.safeUnbox(mutableLiveData != null ? mutableLiveData.getValue() : null));
            } else {
                strValueOf = null;
            }
            if ((j & 322) != 0) {
                MutableLiveData<ExamQuestionData> mutableLiveData2 = examAnswerVM != null ? examAnswerVM.k : null;
                updateLiveDataRegistration(1, mutableLiveData2);
                ExamQuestionData value3 = mutableLiveData2 != null ? mutableLiveData2.getValue() : null;
                List<Question> questions = value3 != null ? value3.getQuestions() : null;
                strValueOf2 = String.valueOf(questions != null ? questions.size() : 0);
            } else {
                strValueOf2 = null;
            }
            if ((j & 324) == 0) {
                value = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveData3 = examAnswerVM != null ? examAnswerVM.i : null;
                updateLiveDataRegistration(2, mutableLiveData3);
                if (mutableLiveData3 != null) {
                    value = mutableLiveData3.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 328) == 0) {
                value2 = null;
            } else {
                MutableLiveData<ExamViewPageAdapter> mutableLiveData4 = examAnswerVM != null ? examAnswerVM.n : null;
                updateLiveDataRegistration(3, mutableLiveData4);
                if (mutableLiveData4 != null) {
                    value2 = mutableLiveData4.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 336) == 0) {
                showName = null;
            } else {
                MutableLiveData<ExamQuestionType> mutableLiveData5 = examAnswerVM != null ? examAnswerVM.l : null;
                updateLiveDataRegistration(4, mutableLiveData5);
                ExamQuestionType value4 = mutableLiveData5 != null ? mutableLiveData5.getValue() : null;
                if (value4 != null) {
                    showName = value4.getShowName();
                } else {
                    showName = null;
                }
            }
        } else {
            showName = null;
            strValueOf = null;
            strValueOf2 = null;
            value = null;
            value2 = null;
        }
        long j3 = j & 384;
        if (j3 == 0 || cVar == null) {
            aVarA = null;
            bVarA = null;
        } else {
            b bVar = this.f13216a;
            if (bVar == null) {
                bVar = new b();
                this.f13216a = bVar;
            }
            bVarA = bVar.a(cVar);
            a aVar = this.f13215a;
            if (aVar == null) {
                aVar = new a();
                this.f13215a = aVar;
            }
            aVarA = aVar.a(cVar);
        }
        if ((j & 324) != 0) {
            this.f13214a.k(value);
        }
        if ((j & 321) != 0) {
            TextViewBindingAdapter.setText(((ActivityExamAnswerBinding) this).f13210b, strValueOf);
        }
        if ((322 & j) != 0) {
            TextViewBindingAdapter.setText(this.c, strValueOf2);
        }
        if ((336 & j) != 0) {
            TextViewBindingAdapter.setText(this.e, showName);
        }
        if ((256 & j) != 0) {
            View view = ((ActivityExamAnswerBinding) this).f36390a;
            int i = com.huachenjie.sport.R.color.color_main_v2;
            DrawablesBindingAdapter.h(view, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(view, i)), 0, 0.0f, 0.0f, 0.0f, 0.0f, 13.0f, 13.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            View view2 = ((ActivityExamAnswerBinding) this).b;
            DrawablesBindingAdapter.h(view2, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(view2, i)), 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 13.0f, 13.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            CommonBindingAdapter.N(((ActivityExamAnswerBinding) this).f13206a, 2);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(((ActivityExamAnswerBinding) this).f36390a, bVarA, null);
            CommonBindingAdapter.q(((ActivityExamAnswerBinding) this).b, aVarA, null);
        }
        if (j2 != 0) {
            CommonBindingAdapter.K(((ActivityExamAnswerBinding) this).f13206a, onPageChangeCallback);
        }
        if ((j & 328) != 0) {
            CommonBindingAdapter.t(((ActivityExamAnswerBinding) this).f13206a, value2);
        }
        ViewDataBinding.executeBindingsOn(this.f13214a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f13212a != 0) {
                return true;
            }
            return this.f13214a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13212a = 256L;
        }
        this.f13214a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActivityExamAnswerBinding
    public void m(@Nullable ExamAnswerActivity.c cVar) {
        ((ActivityExamAnswerBinding) this).f13207a = cVar;
        synchronized (this) {
            this.f13212a |= 128;
        }
        notifyPropertyChanged(ok0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActivityExamAnswerBinding
    public void n(@Nullable ExamAnswerVM examAnswerVM) {
        ((ActivityExamAnswerBinding) this).f13208a = examAnswerVM;
        synchronized (this) {
            this.f13212a |= 64;
        }
        notifyPropertyChanged(ok0.L);
        super.requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActivityExamAnswerBinding
    public void o(@Nullable ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        ((ActivityExamAnswerBinding) this).f13205a = onPageChangeCallback;
        synchronized (this) {
            this.f13212a |= 32;
        }
        notifyPropertyChanged(ok0.N);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return q((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return s((MutableLiveData) obj, i2);
        }
        if (i == 3) {
            return t((MutableLiveData) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return r((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<ExamQuestionData> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13212a |= 2;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13212a |= 1;
        }
        return true;
    }

    public final boolean r(MutableLiveData<ExamQuestionType> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13212a |= 16;
        }
        return true;
    }

    public final boolean s(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13212a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f13214a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.N == i) {
            o((ViewPager2.OnPageChangeCallback) obj);
        } else if (ok0.L == i) {
            n((ExamAnswerVM) obj);
        } else {
            if (ok0.k != i) {
                return false;
            }
            m((ExamAnswerActivity.c) obj);
        }
        return true;
    }

    public final boolean t(MutableLiveData<ExamViewPageAdapter> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13212a |= 8;
        }
        return true;
    }

    public ActivityExamAnswerBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (ConstraintLayout) objArr[8], (ImageView) objArr[12], (ImageView) objArr[10], (TextView) objArr[13], (TextView) objArr[3], (TextView) objArr[4], (TextView) objArr[9], (TextView) objArr[1], (TextView) objArr[11], (View) objArr[6], (View) objArr[5], (ViewPager2) objArr[2]);
        this.f13212a = -1L;
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[7];
        this.f13214a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f13213a = linearLayout;
        linearLayout.setTag(null);
        ((ActivityExamAnswerBinding) this).f13210b.setTag(null);
        this.c.setTag(null);
        this.e.setTag(null);
        ((ActivityExamAnswerBinding) this).f36390a.setTag(null);
        ((ActivityExamAnswerBinding) this).b.setTag(null);
        ((ActivityExamAnswerBinding) this).f13206a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
