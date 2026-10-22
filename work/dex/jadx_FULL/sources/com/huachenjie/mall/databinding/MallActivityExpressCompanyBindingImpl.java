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
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.widget.CommonSearchView;
import com.huachenjie.mall.page.express_company.ExpressCompanyAdapter;
import com.huachenjie.mall.page.express_company.ExpressCompanyVM;
import com.zj.adlib.hk0;
import com.zj.adlib.xq8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallActivityExpressCompanyBindingImpl extends MallActivityExpressCompanyBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34794a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10213a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10214a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10215a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f10216a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f10217a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(5);
        f10213a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{3}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34794a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.mall.R.id.search_view, 4);
    }

    public MallActivityExpressCompanyBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f10213a, f34794a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0035  */
    /* JADX WARN: Code duplicated, block: B:25:0x0051  */
    /* JADX WARN: Code duplicated, block: B:34:0x006d  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        ExpressCompanyAdapter value;
        Integer value2;
        BindingTitleBean value3;
        synchronized (this) {
            j = this.f10214a;
            this.f10214a = 0L;
        }
        ExpressCompanyVM expressCompanyVM = ((MallActivityExpressCompanyBinding) this).f10212a;
        if ((59 & j) != 0) {
            if ((j & 49) == 0) {
                value2 = null;
            } else {
                MutableLiveData<Integer> mutableLiveDataK = expressCompanyVM != null ? expressCompanyVM.k() : null;
                updateLiveDataRegistration(0, mutableLiveDataK);
                if (mutableLiveDataK != null) {
                    value2 = mutableLiveDataK.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 50) == 0) {
                value3 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = expressCompanyVM != null ? expressCompanyVM.i() : null;
                updateLiveDataRegistration(1, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value3 = mutableLiveDataI.getValue();
                } else {
                    value3 = null;
                }
            }
            if ((j & 56) == 0) {
                value = null;
            } else {
                MutableLiveData<ExpressCompanyAdapter> mutableLiveDataJ = expressCompanyVM != null ? expressCompanyVM.j() : null;
                updateLiveDataRegistration(3, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value = mutableLiveDataJ.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            value = null;
            value2 = null;
            value3 = null;
        }
        if ((49 & j) != 0) {
            xq8.a(this.f10217a, value2, null);
        }
        if ((j & 56) != 0) {
            CommonBindingAdapter.g(this.f10216a, value, false, false);
        }
        if ((j & 50) != 0) {
            ((MallActivityExpressCompanyBinding) this).f34793a.k(value3);
        }
        ViewDataBinding.executeBindingsOn(((MallActivityExpressCompanyBinding) this).f34793a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10214a != 0) {
                return true;
            }
            return ((MallActivityExpressCompanyBinding) this).f34793a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10214a = 32L;
        }
        ((MallActivityExpressCompanyBinding) this).f34793a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityExpressCompanyBinding
    public void k(@Nullable ExpressCompanyVM expressCompanyVM) {
        ((MallActivityExpressCompanyBinding) this).f10212a = expressCompanyVM;
        synchronized (this) {
            this.f10214a |= 16;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean l(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10214a |= 4;
        }
        return true;
    }

    public final boolean m(MutableLiveData<ExpressCompanyAdapter> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10214a |= 8;
        }
        return true;
    }

    public final boolean n(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10214a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10214a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return o((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return l((LayoutToolbarBindingBinding) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return m((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((MallActivityExpressCompanyBinding) this).f34793a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 != i) {
            return false;
        }
        k((ExpressCompanyVM) obj);
        return true;
    }

    public MallActivityExpressCompanyBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (CommonSearchView) objArr[4], (LayoutToolbarBindingBinding) objArr[3]);
        this.f10214a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f10215a = linearLayout;
        linearLayout.setTag(null);
        StateLayout stateLayout = (StateLayout) objArr[1];
        this.f10217a = stateLayout;
        stateLayout.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[2];
        this.f10216a = recyclerView;
        recyclerView.setTag(null);
        setContainedBinding(((MallActivityExpressCompanyBinding) this).f34793a);
        setRootTag(view);
        invalidateAll();
    }
}
