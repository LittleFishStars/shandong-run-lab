package com.huachenjie.login.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.CompoundButtonBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.login.R;
import com.huachenjie.login.page.base.BaseLoginVM;
import com.zj.adlib.zk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class LoginLayoutProtocolCheckboxBindingImpl extends LoginLayoutProtocolCheckboxBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34686a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10087a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10088a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10089a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f10090a;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            boolean zIsChecked = ((LoginLayoutProtocolCheckboxBinding) LoginLayoutProtocolCheckboxBindingImpl.this).f34685a.isChecked();
            BaseLoginVM baseLoginVM = ((LoginLayoutProtocolCheckboxBinding) LoginLayoutProtocolCheckboxBindingImpl.this).f10086a;
            if (baseLoginVM != null) {
                MutableLiveData<Boolean> mutableLiveDataL = baseLoginVM.l();
                if (mutableLiveDataL != null) {
                    mutableLiveDataL.setValue(Boolean.valueOf(zIsChecked));
                }
            }
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34686a = sparseIntArray;
        sparseIntArray.put(R.id.tv_protocol, 2);
    }

    public LoginLayoutProtocolCheckboxBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f10087a, f34686a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f10088a;
            this.f10088a = 0L;
        }
        BaseLoginVM baseLoginVM = ((LoginLayoutProtocolCheckboxBinding) this).f10086a;
        long j2 = 7 & j;
        boolean zSafeUnbox = false;
        if (j2 != 0) {
            MutableLiveData<Boolean> mutableLiveDataL = baseLoginVM != null ? baseLoginVM.l() : null;
            updateLiveDataRegistration(0, mutableLiveDataL);
            zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataL != null ? mutableLiveDataL.getValue() : null);
        }
        if (j2 != 0) {
            CompoundButtonBindingAdapter.setChecked(((LoginLayoutProtocolCheckboxBinding) this).f34685a, zSafeUnbox);
        }
        if ((j & 4) != 0) {
            CompoundButtonBindingAdapter.setListeners(((LoginLayoutProtocolCheckboxBinding) this).f34685a, null, this.f10090a);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10088a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10088a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.login.databinding.LoginLayoutProtocolCheckboxBinding
    public void k(@Nullable BaseLoginVM baseLoginVM) {
        ((LoginLayoutProtocolCheckboxBinding) this).f10086a = baseLoginVM;
        synchronized (this) {
            this.f10088a |= 2;
        }
        notifyPropertyChanged(zk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f10088a |= 1;
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
        if (zk0.p0 != i) {
            return false;
        }
        k((BaseLoginVM) obj);
        return true;
    }

    public LoginLayoutProtocolCheckboxBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (CheckBox) objArr[1], (TextView) objArr[2]);
        this.f10090a = new a();
        this.f10088a = -1L;
        ((LoginLayoutProtocolCheckboxBinding) this).f34685a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f10089a = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
