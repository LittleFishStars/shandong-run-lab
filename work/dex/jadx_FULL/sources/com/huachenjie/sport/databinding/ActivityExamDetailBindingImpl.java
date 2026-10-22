package com.huachenjie.sport.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.sport.bean.ExamDetailData;
import com.huachenjie.sport.page.mine.exam.ExamDetailActivity;
import com.huachenjie.sport.page.mine.exam.ExamDetailVM;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ActivityExamDetailBindingImpl extends ActivityExamDetailBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36395a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13218a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13219a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f13220a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f13221a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final FragmentExamDetailBinding f13222a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final FragmentExamResultBinding f13223a;

    @NonNull
    public final ConstraintLayout b;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(5);
        f13218a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{2}, new int[]{R.layout.layout_toolbar_binding});
        includedLayouts.setIncludes(1, new String[]{"fragment_exam_detail", "fragment_exam_result"}, new int[]{3, 4}, new int[]{com.huachenjie.sport.R.layout.fragment_exam_detail, com.huachenjie.sport.R.layout.fragment_exam_result});
        f36395a = null;
    }

    public ActivityExamDetailBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f13218a, f36395a));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0031  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        ExamDetailData value;
        synchronized (this) {
            j = this.f13219a;
            this.f13219a = 0L;
        }
        ExamDetailVM examDetailVM = ((ActivityExamDetailBinding) this).f13217a;
        ExamDetailActivity.a aVar = ((ActivityExamDetailBinding) this).f36394a;
        BindingTitleBean value2 = null;
        if ((23 & j) != 0) {
            if ((j & 21) == 0) {
                value = null;
            } else {
                MutableLiveData<ExamDetailData> mutableLiveData = examDetailVM != null ? examDetailVM.j : null;
                updateLiveDataRegistration(0, mutableLiveData);
                if (mutableLiveData != null) {
                    value = mutableLiveData.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 22) != 0) {
                MutableLiveData<BindingTitleBean> mutableLiveData2 = examDetailVM != null ? examDetailVM.i : null;
                updateLiveDataRegistration(1, mutableLiveData2);
                if (mutableLiveData2 != null) {
                    value2 = mutableLiveData2.getValue();
                }
            }
        } else {
            value = null;
        }
        long j2 = 24 & j;
        if ((22 & j) != 0) {
            this.f13221a.k(value2);
        }
        if (j2 != 0) {
            this.f13222a.l(aVar);
            this.f13223a.l(aVar);
        }
        if ((j & 21) != 0) {
            this.f13222a.m(value);
            this.f13223a.m(value);
        }
        ViewDataBinding.executeBindingsOn(this.f13221a);
        ViewDataBinding.executeBindingsOn(this.f13222a);
        ViewDataBinding.executeBindingsOn(this.f13223a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f13219a != 0) {
                return true;
            }
            return this.f13221a.hasPendingBindings() || this.f13222a.hasPendingBindings() || this.f13223a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13219a = 16L;
        }
        this.f13221a.invalidateAll();
        this.f13222a.invalidateAll();
        this.f13223a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActivityExamDetailBinding
    public void l(@Nullable ExamDetailActivity.a aVar) {
        ((ActivityExamDetailBinding) this).f36394a = aVar;
        synchronized (this) {
            this.f13219a |= 8;
        }
        notifyPropertyChanged(ok0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActivityExamDetailBinding
    public void m(@Nullable ExamDetailVM examDetailVM) {
        ((ActivityExamDetailBinding) this).f13217a = examDetailVM;
        synchronized (this) {
            this.f13219a |= 4;
        }
        notifyPropertyChanged(ok0.L);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<ExamDetailData> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13219a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13219a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((MutableLiveData) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return o((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f13221a.setLifecycleOwner(lifecycleOwner);
        this.f13222a.setLifecycleOwner(lifecycleOwner);
        this.f13223a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.L == i) {
            m((ExamDetailVM) obj);
        } else {
            if (ok0.k != i) {
                return false;
            }
            l((ExamDetailActivity.a) obj);
        }
        return true;
    }

    public ActivityExamDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2);
        this.f13219a = -1L;
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[2];
        this.f13221a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13220a = constraintLayout;
        constraintLayout.setTag(null);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) objArr[1];
        this.b = constraintLayout2;
        constraintLayout2.setTag(null);
        FragmentExamDetailBinding fragmentExamDetailBinding = (FragmentExamDetailBinding) objArr[3];
        this.f13222a = fragmentExamDetailBinding;
        setContainedBinding(fragmentExamDetailBinding);
        FragmentExamResultBinding fragmentExamResultBinding = (FragmentExamResultBinding) objArr[4];
        this.f13223a = fragmentExamResultBinding;
        setContainedBinding(fragmentExamResultBinding);
        setRootTag(view);
        invalidateAll();
    }
}
