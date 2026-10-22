package com.huachenjie.compat.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.CompoundButtonBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.compat.page.account.CancelAccountTipActivity;
import com.huachenjie.compat.page.account.CancelAccountTipVM;
import com.zj.adlib.wk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class ActivityCancelAccountTipBindingImpl extends ActivityCancelAccountTipBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34020a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9075a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9076a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CheckBox f9077a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f9078a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f9079a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f9080a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f9081a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f9082a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f9083a;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            boolean zIsChecked = ActivityCancelAccountTipBindingImpl.this.f9077a.isChecked();
            CancelAccountTipVM cancelAccountTipVM = ((ActivityCancelAccountTipBinding) ActivityCancelAccountTipBindingImpl.this).f9074a;
            if (cancelAccountTipVM != null) {
                MutableLiveData<Boolean> mutableLiveDataH = cancelAccountTipVM.h();
                if (mutableLiveDataH != null) {
                    mutableLiveDataH.setValue(Boolean.valueOf(zIsChecked));
                }
            }
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CancelAccountTipActivity.a f34022a;

        public b a(CancelAccountTipActivity.a aVar) {
            this.f34022a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34022a.b(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CancelAccountTipActivity.a f34023a;

        public c a(CancelAccountTipActivity.a aVar) {
            this.f34023a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34023a.a(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(7);
        f9075a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{4}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34020a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.compat.R.id.ll_title, 5);
        sparseIntArray.put(com.huachenjie.compat.R.id.tv_title_sub, 6);
    }

    public ActivityCancelAccountTipBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f9075a, f34020a));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0033  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        BindingTitleBean value;
        b bVarA;
        c cVarA;
        synchronized (this) {
            j = this.f9076a;
            this.f9076a = 0L;
        }
        CancelAccountTipVM cancelAccountTipVM = ((ActivityCancelAccountTipBinding) this).f9074a;
        CancelAccountTipActivity.a aVar = ((ActivityCancelAccountTipBinding) this).f9073a;
        boolean zSafeUnbox = false;
        if ((23 & j) != 0) {
            if ((j & 21) == 0) {
                value = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = cancelAccountTipVM != null ? cancelAccountTipVM.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value = mutableLiveDataI.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 22) != 0) {
                MutableLiveData<Boolean> mutableLiveDataH = cancelAccountTipVM != null ? cancelAccountTipVM.h() : null;
                updateLiveDataRegistration(1, mutableLiveDataH);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataH != null ? mutableLiveDataH.getValue() : null);
            }
        } else {
            value = null;
        }
        long j2 = 24 & j;
        if (j2 == 0 || aVar == null) {
            bVarA = null;
            cVarA = null;
        } else {
            c cVar = this.f9083a;
            if (cVar == null) {
                cVar = new c();
                this.f9083a = cVar;
            }
            cVarA = cVar.a(aVar);
            b bVar = this.f9082a;
            if (bVar == null) {
                bVar = new b();
                this.f9082a = bVar;
            }
            bVarA = bVar.a(aVar);
        }
        if ((21 & j) != 0) {
            this.f9081a.k(value);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f9078a, cVarA, null);
            CommonBindingAdapter.q(((ActivityCancelAccountTipBinding) this).f9072a, bVarA, null);
        }
        if ((j & 22) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.f9077a, zSafeUnbox);
        }
        if ((j & 16) != 0) {
            CompoundButtonBindingAdapter.setListeners(this.f9077a, null, this.f9080a);
        }
        ViewDataBinding.executeBindingsOn(this.f9081a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9076a != 0) {
                return true;
            }
            return this.f9081a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9076a = 16L;
        }
        this.f9081a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.compat.databinding.ActivityCancelAccountTipBinding
    public void l(@Nullable CancelAccountTipActivity.a aVar) {
        ((ActivityCancelAccountTipBinding) this).f9073a = aVar;
        synchronized (this) {
            this.f9076a |= 8;
        }
        notifyPropertyChanged(wk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.compat.databinding.ActivityCancelAccountTipBinding
    public void m(@Nullable CancelAccountTipVM cancelAccountTipVM) {
        ((ActivityCancelAccountTipBinding) this).f9074a = cancelAccountTipVM;
        synchronized (this) {
            this.f9076a |= 4;
        }
        notifyPropertyChanged(wk0.p0);
        super.requestRebind();
    }

    public final boolean o(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9076a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return p((MutableLiveData) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return o((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9076a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f9081a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (wk0.p0 == i) {
            m((CancelAccountTipVM) obj);
        } else {
            if (wk0.k != i) {
                return false;
            }
            l((CancelAccountTipActivity.a) obj);
        }
        return true;
    }

    public ActivityCancelAccountTipBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (LinearLayout) objArr[5], (TextView) objArr[1], (TextView) objArr[6]);
        this.f9080a = new a();
        this.f9076a = -1L;
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[4];
        this.f9081a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f9079a = constraintLayout;
        constraintLayout.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[2];
        this.f9078a = frameLayout;
        frameLayout.setTag(null);
        CheckBox checkBox = (CheckBox) objArr[3];
        this.f9077a = checkBox;
        checkBox.setTag(null);
        ((ActivityCancelAccountTipBinding) this).f9072a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
