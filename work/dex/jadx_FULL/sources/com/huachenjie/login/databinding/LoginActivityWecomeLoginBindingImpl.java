package com.huachenjie.login.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.login.R;
import com.huachenjie.login.page.welcome.WelcomeLoginActivity;
import com.huachenjie.login.page.welcome.WelcomeLoginVM;
import com.zj.adlib.zk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class LoginActivityWecomeLoginBindingImpl extends LoginActivityWecomeLoginBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34676a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10062a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10063a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f10064a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10065a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10066a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f10067a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f10068a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LoginLayoutThirdLoginBinding f10069a;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((LoginActivityWecomeLoginBinding) LoginActivityWecomeLoginBindingImpl.this).f34675a);
            WelcomeLoginVM welcomeLoginVM = ((LoginActivityWecomeLoginBinding) LoginActivityWecomeLoginBindingImpl.this).f10061a;
            if (welcomeLoginVM != null) {
                MutableLiveData<String> mutableLiveDataO = welcomeLoginVM.o();
                if (mutableLiveDataO != null) {
                    mutableLiveDataO.setValue(textString);
                }
            }
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WelcomeLoginActivity.a f34678a;

        public b a(WelcomeLoginActivity.a aVar) {
            this.f34678a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34678a.m(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(6);
        f10062a = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"login_layout_protocol_checkbox", "login_layout_third_login"}, new int[]{4, 5}, new int[]{R.layout.login_layout_protocol_checkbox, R.layout.login_layout_third_login});
        f34676a = null;
    }

    public LoginActivityWecomeLoginBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f10062a, f34676a));
    }

    /* JADX WARN: Code duplicated, block: B:56:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:65:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:68:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:70:0x00f9  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        String value;
        boolean z;
        int iSafeUnbox;
        long j2;
        b bVarA;
        boolean z2;
        synchronized (this) {
            j = this.f10063a;
            this.f10063a = 0L;
        }
        WelcomeLoginVM welcomeLoginVM = ((LoginActivityWecomeLoginBinding) this).f10061a;
        WelcomeLoginActivity.a aVar = ((LoginActivityWecomeLoginBinding) this).f10060a;
        if ((46 & j) != 0) {
            long j3 = j & 42;
            if (j3 != 0) {
                MutableLiveData<String> mutableLiveDataO = welcomeLoginVM != null ? welcomeLoginVM.o() : null;
                updateLiveDataRegistration(1, mutableLiveDataO);
                value = mutableLiveDataO != null ? mutableLiveDataO.getValue() : null;
                z2 = (value != null ? value.length() : 0) > 4;
                if (j3 != 0) {
                    j |= z2 ? 128L : 64L;
                }
                str = z2 ? "#0BD3FF" : "#FFFFFF";
            } else {
                str = null;
                value = null;
                z2 = false;
            }
            if ((j & 44) != 0) {
                BaseViewModel.b bVarE = welcomeLoginVM != null ? welcomeLoginVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                updateLiveDataRegistration(2, mutableLiveDataB);
                iSafeUnbox = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null) + 120));
                z = z2;
            } else {
                z = z2;
            }
            j2 = 48 & j;
            if (j2 != 0 || aVar == null) {
                bVarA = null;
            } else {
                b bVar = this.f10068a;
                if (bVar == null) {
                    bVar = new b();
                    this.f10068a = bVar;
                }
                bVarA = bVar.a(aVar);
            }
            if ((42 & j) != 0) {
                TextViewBindingAdapter.setText(((LoginActivityWecomeLoginBinding) this).f34675a, value);
                CommonBindingAdapter.e0(this.f10066a, z);
                CommonBindingAdapter.W(this.f10066a, str);
            }
            if ((32 & j) != 0) {
                TextViewBindingAdapter.setTextWatcher(((LoginActivityWecomeLoginBinding) this).f34675a, null, null, null, this.f10067a);
            }
            if ((40 & j) != 0) {
                ((LoginActivityWecomeLoginBinding) this).f10059a.k(welcomeLoginVM);
            }
            if ((j & 44) != 0) {
                CommonBindingAdapter.I(this.f10065a, 0, iSafeUnbox, 0, 0, null);
            }
            if (j2 != 0) {
                this.f10069a.k(aVar);
                CommonBindingAdapter.q(this.f10066a, bVarA, null);
            }
            ViewDataBinding.executeBindingsOn(((LoginActivityWecomeLoginBinding) this).f10059a);
            ViewDataBinding.executeBindingsOn(this.f10069a);
        }
        str = null;
        value = null;
        z = false;
        iSafeUnbox = 0;
        j2 = 48 & j;
        if (j2 != 0) {
            bVarA = null;
        } else {
            bVarA = null;
        }
        if ((42 & j) != 0) {
            TextViewBindingAdapter.setText(((LoginActivityWecomeLoginBinding) this).f34675a, value);
            CommonBindingAdapter.e0(this.f10066a, z);
            CommonBindingAdapter.W(this.f10066a, str);
        }
        if ((32 & j) != 0) {
            TextViewBindingAdapter.setTextWatcher(((LoginActivityWecomeLoginBinding) this).f34675a, null, null, null, this.f10067a);
        }
        if ((40 & j) != 0) {
            ((LoginActivityWecomeLoginBinding) this).f10059a.k(welcomeLoginVM);
        }
        if ((j & 44) != 0) {
            CommonBindingAdapter.I(this.f10065a, 0, iSafeUnbox, 0, 0, null);
        }
        if (j2 != 0) {
            this.f10069a.k(aVar);
            CommonBindingAdapter.q(this.f10066a, bVarA, null);
        }
        ViewDataBinding.executeBindingsOn(((LoginActivityWecomeLoginBinding) this).f10059a);
        ViewDataBinding.executeBindingsOn(this.f10069a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10063a != 0) {
                return true;
            }
            return ((LoginActivityWecomeLoginBinding) this).f10059a.hasPendingBindings() || this.f10069a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10063a = 32L;
        }
        ((LoginActivityWecomeLoginBinding) this).f10059a.invalidateAll();
        this.f10069a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.login.databinding.LoginActivityWecomeLoginBinding
    public void l(@Nullable WelcomeLoginActivity.a aVar) {
        ((LoginActivityWecomeLoginBinding) this).f10060a = aVar;
        synchronized (this) {
            this.f10063a |= 16;
        }
        notifyPropertyChanged(zk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.login.databinding.LoginActivityWecomeLoginBinding
    public void m(@Nullable WelcomeLoginVM welcomeLoginVM) {
        ((LoginActivityWecomeLoginBinding) this).f10061a = welcomeLoginVM;
        synchronized (this) {
            this.f10063a |= 8;
        }
        notifyPropertyChanged(zk0.p0);
        super.requestRebind();
    }

    public final boolean n(LoginLayoutProtocolCheckboxBinding loginLayoutProtocolCheckboxBinding, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f10063a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<String> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f10063a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((LoginLayoutProtocolCheckboxBinding) obj, i2);
        }
        if (i == 1) {
            return o((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return p((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f10063a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((LoginActivityWecomeLoginBinding) this).f10059a.setLifecycleOwner(lifecycleOwner);
        this.f10069a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (zk0.p0 == i) {
            m((WelcomeLoginVM) obj);
        } else {
            if (zk0.k != i) {
                return false;
            }
            l((WelcomeLoginActivity.a) obj);
        }
        return true;
    }

    public LoginActivityWecomeLoginBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (EditText) objArr[2], (LoginLayoutProtocolCheckboxBinding) objArr[4]);
        this.f10067a = new a();
        this.f10063a = -1L;
        ((LoginActivityWecomeLoginBinding) this).f34675a.setTag(null);
        setContainedBinding(((LoginActivityWecomeLoginBinding) this).f10059a);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f10064a = frameLayout;
        frameLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[1];
        this.f10065a = linearLayout;
        linearLayout.setTag(null);
        LoginLayoutThirdLoginBinding loginLayoutThirdLoginBinding = (LoginLayoutThirdLoginBinding) objArr[5];
        this.f10069a = loginLayoutThirdLoginBinding;
        setContainedBinding(loginLayoutThirdLoginBinding);
        TextView textView = (TextView) objArr[3];
        this.f10066a = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
