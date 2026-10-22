package com.huachenjie.college.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.college.page.hw_health.HWHealthAdapter;
import com.huachenjie.college.page.hw_health.HWHealthVM;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.noober.background.view.BLRelativeLayout;
import com.zj.adlib.uk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class CollegeActivityHwHealthBindingImpl extends CollegeActivityHwHealthBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33555a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8338a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8339a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f8340a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLRelativeLayout f8341a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(4);
        f8338a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{2}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33555a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.college.R.id.tv_source, 3);
    }

    public CollegeActivityHwHealthBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f8338a, f33555a));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0031  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        BindingTitleBean value;
        synchronized (this) {
            j = this.f8339a;
            this.f8339a = 0L;
        }
        HWHealthVM hWHealthVM = ((CollegeActivityHwHealthBinding) this).f8336a;
        HWHealthAdapter value2 = null;
        if ((29 & j) != 0) {
            if ((j & 25) == 0) {
                value = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = hWHealthVM != null ? hWHealthVM.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value = mutableLiveDataI.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 28) != 0) {
                MutableLiveData<HWHealthAdapter> mutableLiveDataJ = hWHealthVM != null ? hWHealthVM.j() : null;
                updateLiveDataRegistration(2, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value2 = mutableLiveDataJ.getValue();
                }
            }
        } else {
            value = null;
        }
        if ((28 & j) != 0) {
            CommonBindingAdapter.g(this.f8340a, value2, false, false);
        }
        if ((j & 25) != 0) {
            ((CollegeActivityHwHealthBinding) this).f8337a.k(value);
        }
        ViewDataBinding.executeBindingsOn(((CollegeActivityHwHealthBinding) this).f8337a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f8339a != 0) {
                return true;
            }
            return ((CollegeActivityHwHealthBinding) this).f8337a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8339a = 16L;
        }
        ((CollegeActivityHwHealthBinding) this).f8337a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.college.databinding.CollegeActivityHwHealthBinding
    public void k(@Nullable HWHealthVM hWHealthVM) {
        ((CollegeActivityHwHealthBinding) this).f8336a = hWHealthVM;
        synchronized (this) {
            this.f8339a |= 8;
        }
        notifyPropertyChanged(uk0.p0);
        super.requestRebind();
    }

    public final boolean l(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != uk0.f45162a) {
            return false;
        }
        synchronized (this) {
            this.f8339a |= 2;
        }
        return true;
    }

    public final boolean m(MutableLiveData<HWHealthAdapter> mutableLiveData, int i) {
        if (i != uk0.f45162a) {
            return false;
        }
        synchronized (this) {
            this.f8339a |= 4;
        }
        return true;
    }

    public final boolean n(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != uk0.f45162a) {
            return false;
        }
        synchronized (this) {
            this.f8339a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return l((LayoutToolbarBindingBinding) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return m((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((CollegeActivityHwHealthBinding) this).f8337a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (uk0.p0 != i) {
            return false;
        }
        k((HWHealthVM) obj);
        return true;
    }

    public CollegeActivityHwHealthBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (LayoutToolbarBindingBinding) objArr[2], (TextView) objArr[3]);
        this.f8339a = -1L;
        BLRelativeLayout bLRelativeLayout = (BLRelativeLayout) objArr[0];
        this.f8341a = bLRelativeLayout;
        bLRelativeLayout.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[1];
        this.f8340a = recyclerView;
        recyclerView.setTag(null);
        setContainedBinding(((CollegeActivityHwHealthBinding) this).f8337a);
        setRootTag(view);
        invalidateAll();
    }
}
