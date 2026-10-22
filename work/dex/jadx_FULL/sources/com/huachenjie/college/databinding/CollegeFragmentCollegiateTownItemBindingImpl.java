package com.huachenjie.college.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.college.page.home.CollegeTownAdapter;
import com.huachenjie.college.page.home.CollegeTownItemVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.zj.adlib.uk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class CollegeFragmentCollegiateTownItemBindingImpl extends CollegeFragmentCollegiateTownItemBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33569a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8390a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8391a;

    public CollegeFragmentCollegiateTownItemBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f8390a, f33569a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f8391a;
            this.f8391a = 0L;
        }
        CollegeTownItemVM collegeTownItemVM = ((CollegeFragmentCollegiateTownItemBinding) this).f8389a;
        long j2 = j & 7;
        CollegeTownAdapter value = null;
        if (j2 != 0) {
            MutableLiveData<CollegeTownAdapter> mutableLiveDataI = collegeTownItemVM != null ? collegeTownItemVM.i() : null;
            updateLiveDataRegistration(0, mutableLiveDataI);
            if (mutableLiveDataI != null) {
                value = mutableLiveDataI.getValue();
            }
        }
        if (j2 != 0) {
            CommonBindingAdapter.g(((CollegeFragmentCollegiateTownItemBinding) this).f33568a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8391a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8391a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.college.databinding.CollegeFragmentCollegiateTownItemBinding
    public void k(@Nullable CollegeTownItemVM collegeTownItemVM) {
        ((CollegeFragmentCollegiateTownItemBinding) this).f8389a = collegeTownItemVM;
        synchronized (this) {
            this.f8391a |= 2;
        }
        notifyPropertyChanged(uk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<CollegeTownAdapter> mutableLiveData, int i) {
        if (i != uk0.f45162a) {
            return false;
        }
        synchronized (this) {
            this.f8391a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return l((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (uk0.p0 != i) {
            return false;
        }
        k((CollegeTownItemVM) obj);
        return true;
    }

    public CollegeFragmentCollegiateTownItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (RecyclerView) objArr[0]);
        this.f8391a = -1L;
        ((CollegeFragmentCollegiateTownItemBinding) this).f33568a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
