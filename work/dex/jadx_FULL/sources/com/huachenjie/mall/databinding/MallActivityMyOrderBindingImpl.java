package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.viewpager2.widget.ViewPager2;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.widget.SelectBoldTabLayout;
import com.huachenjie.mall.page.my_order.MyOrderVM;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallActivityMyOrderBindingImpl extends MallActivityMyOrderBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34821a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10300a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10301a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10302a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(4);
        f10300a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{1}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34821a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.mall.R.id.tab_layout, 2);
        sparseIntArray.put(com.huachenjie.mall.R.id.view_pager, 3);
    }

    public MallActivityMyOrderBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f10300a, f34821a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f10301a;
            this.f10301a = 0L;
        }
        MyOrderVM myOrderVM = ((MallActivityMyOrderBinding) this).f10299a;
        long j2 = j & 13;
        BindingTitleBean value = null;
        if (j2 != 0) {
            MutableLiveData<BindingTitleBean> mutableLiveDataI = myOrderVM != null ? myOrderVM.i() : null;
            updateLiveDataRegistration(0, mutableLiveDataI);
            if (mutableLiveDataI != null) {
                value = mutableLiveDataI.getValue();
            }
        }
        if (j2 != 0) {
            ((MallActivityMyOrderBinding) this).f10297a.k(value);
        }
        ViewDataBinding.executeBindingsOn(((MallActivityMyOrderBinding) this).f10297a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10301a != 0) {
                return true;
            }
            return ((MallActivityMyOrderBinding) this).f10297a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10301a = 8L;
        }
        ((MallActivityMyOrderBinding) this).f10297a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityMyOrderBinding
    public void k(@Nullable MyOrderVM myOrderVM) {
        ((MallActivityMyOrderBinding) this).f10299a = myOrderVM;
        synchronized (this) {
            this.f10301a |= 4;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean l(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10301a |= 2;
        }
        return true;
    }

    public final boolean m(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10301a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return m((MutableLiveData) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return l((LayoutToolbarBindingBinding) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((MallActivityMyOrderBinding) this).f10297a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 != i) {
            return false;
        }
        k((MyOrderVM) obj);
        return true;
    }

    public MallActivityMyOrderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (SelectBoldTabLayout) objArr[2], (LayoutToolbarBindingBinding) objArr[1], (ViewPager2) objArr[3]);
        this.f10301a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f10302a = linearLayout;
        linearLayout.setTag(null);
        setContainedBinding(((MallActivityMyOrderBinding) this).f10297a);
        setRootTag(view);
        invalidateAll();
    }
}
