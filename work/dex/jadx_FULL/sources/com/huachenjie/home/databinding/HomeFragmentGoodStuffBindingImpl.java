package com.huachenjie.home.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.home.page.good_stuff.GoodStuffAdapter;
import com.huachenjie.home.page.good_stuff.GoodStuffVM;
import com.zj.adlib.xk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class HomeFragmentGoodStuffBindingImpl extends HomeFragmentGoodStuffBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34248a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9403a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9404a;

    public HomeFragmentGoodStuffBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f9403a, f34248a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f9404a;
            this.f9404a = 0L;
        }
        GoodStuffVM goodStuffVM = ((HomeFragmentGoodStuffBinding) this).f9402a;
        long j2 = j & 7;
        GoodStuffAdapter value = null;
        if (j2 != 0) {
            MutableLiveData<GoodStuffAdapter> mutableLiveDataJ = goodStuffVM != null ? goodStuffVM.j() : null;
            updateLiveDataRegistration(0, mutableLiveDataJ);
            if (mutableLiveDataJ != null) {
                value = mutableLiveDataJ.getValue();
            }
        }
        if (j2 != 0) {
            CommonBindingAdapter.g(((HomeFragmentGoodStuffBinding) this).f34247a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9404a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9404a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeFragmentGoodStuffBinding
    public void k(@Nullable GoodStuffVM goodStuffVM) {
        ((HomeFragmentGoodStuffBinding) this).f9402a = goodStuffVM;
        synchronized (this) {
            this.f9404a |= 2;
        }
        notifyPropertyChanged(xk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<GoodStuffAdapter> mutableLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9404a |= 1;
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
        if (xk0.p0 != i) {
            return false;
        }
        k((GoodStuffVM) obj);
        return true;
    }

    public HomeFragmentGoodStuffBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (RecyclerView) objArr[0]);
        this.f9404a = -1L;
        ((HomeFragmentGoodStuffBinding) this).f34247a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
