package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.mall.page.address.modify.ShippingAddressModifyActivity;
import com.huachenjie.mall.page.address.modify.ShippingAddressModifyAdapter;
import com.huachenjie.mall.page.address.modify.ShippingAddressModifyVM;
import com.noober.background.view.BLView;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallActivityShippingAddressModifyBindingImpl extends MallActivityShippingAddressModifyBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34873a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10438a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10439a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10440a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f10441a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f10442a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f10443a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f10444a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ShippingAddressModifyActivity.a f34874a;

        public a a(ShippingAddressModifyActivity.a aVar) {
            this.f34874a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34874a.a(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(6);
        f10438a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{5}, new int[]{R.layout.layout_toolbar_binding});
        f34873a = null;
    }

    public MallActivityShippingAddressModifyBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f10438a, f34873a));
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0063  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a3  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zSafeUnbox;
        boolean zSafeUnbox2;
        ShippingAddressModifyAdapter value;
        BindingTitleBean value2;
        a aVarA;
        synchronized (this) {
            j = this.f10439a;
            this.f10439a = 0L;
        }
        ShippingAddressModifyVM shippingAddressModifyVM = ((MallActivityShippingAddressModifyBinding) this).f10437a;
        ShippingAddressModifyActivity.a aVar = ((MallActivityShippingAddressModifyBinding) this).f10436a;
        if ((183 & j) != 0) {
            if ((j & 161) != 0) {
                MutableLiveData<Boolean> mutableLiveDataO = shippingAddressModifyVM != null ? shippingAddressModifyVM.o() : null;
                updateLiveDataRegistration(0, mutableLiveDataO);
                zSafeUnbox = ViewDataBinding.safeUnbox(Boolean.valueOf(!ViewDataBinding.safeUnbox(mutableLiveDataO != null ? mutableLiveDataO.getValue() : null)));
            } else {
                zSafeUnbox = false;
            }
            if ((j & 162) == 0) {
                value2 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = shippingAddressModifyVM != null ? shippingAddressModifyVM.i() : null;
                updateLiveDataRegistration(1, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value2 = mutableLiveDataI.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 164) != 0) {
                MutableLiveData<Boolean> mutableLiveDataK = shippingAddressModifyVM != null ? shippingAddressModifyVM.k() : null;
                updateLiveDataRegistration(2, mutableLiveDataK);
                zSafeUnbox2 = ViewDataBinding.safeUnbox(mutableLiveDataK != null ? mutableLiveDataK.getValue() : null);
            } else {
                zSafeUnbox2 = false;
            }
            if ((j & 176) == 0) {
                value = null;
            } else {
                MutableLiveData<ShippingAddressModifyAdapter> mutableLiveDataJ = shippingAddressModifyVM != null ? shippingAddressModifyVM.j() : null;
                updateLiveDataRegistration(4, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value = mutableLiveDataJ.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            zSafeUnbox = false;
            zSafeUnbox2 = false;
            value = null;
            value2 = null;
        }
        long j2 = j & 192;
        if (j2 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f10443a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f10443a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if ((j & 161) != 0) {
            CommonBindingAdapter.l0(((MallActivityShippingAddressModifyBinding) this).f34872a, zSafeUnbox);
            CommonBindingAdapter.l0(this.f10444a, zSafeUnbox);
        }
        if ((176 & j) != 0) {
            CommonBindingAdapter.g(this.f10442a, value, false, false);
        }
        if ((164 & j) != 0) {
            CommonBindingAdapter.e0(this.f10440a, zSafeUnbox2);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f10440a, aVarA, null);
        }
        if ((j & 162) != 0) {
            ((MallActivityShippingAddressModifyBinding) this).f10435a.k(value2);
        }
        ViewDataBinding.executeBindingsOn(((MallActivityShippingAddressModifyBinding) this).f10435a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10439a != 0) {
                return true;
            }
            return ((MallActivityShippingAddressModifyBinding) this).f10435a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10439a = 128L;
        }
        ((MallActivityShippingAddressModifyBinding) this).f10435a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityShippingAddressModifyBinding
    public void l(@Nullable ShippingAddressModifyActivity.a aVar) {
        ((MallActivityShippingAddressModifyBinding) this).f10436a = aVar;
        synchronized (this) {
            this.f10439a |= 64;
        }
        notifyPropertyChanged(hk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityShippingAddressModifyBinding
    public void m(@Nullable ShippingAddressModifyVM shippingAddressModifyVM) {
        ((MallActivityShippingAddressModifyBinding) this).f10437a = shippingAddressModifyVM;
        synchronized (this) {
            this.f10439a |= 32;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean n(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10439a |= 8;
        }
        return true;
    }

    public final boolean o(MutableLiveData<ShippingAddressModifyAdapter> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10439a |= 16;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return q((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return r((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 3) {
            return n((LayoutToolbarBindingBinding) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return o((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10439a |= 4;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10439a |= 1;
        }
        return true;
    }

    public final boolean r(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10439a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((MallActivityShippingAddressModifyBinding) this).f10435a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 == i) {
            m((ShippingAddressModifyVM) obj);
        } else {
            if (hk0.k != i) {
                return false;
            }
            l((ShippingAddressModifyActivity.a) obj);
        }
        return true;
    }

    public MallActivityShippingAddressModifyBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (FrameLayout) objArr[2], (LayoutToolbarBindingBinding) objArr[5]);
        this.f10439a = -1L;
        ((MallActivityShippingAddressModifyBinding) this).f34872a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f10441a = constraintLayout;
        constraintLayout.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[1];
        this.f10442a = recyclerView;
        recyclerView.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.f10440a = textView;
        textView.setTag(null);
        BLView bLView = (BLView) objArr[4];
        this.f10444a = bLView;
        bLView.setTag(null);
        setContainedBinding(((MallActivityShippingAddressModifyBinding) this).f10435a);
        setRootTag(view);
        invalidateAll();
    }
}
