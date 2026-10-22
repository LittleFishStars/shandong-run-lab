package com.huachenjie.login.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.CompoundButtonBindingAdapter;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.login.page.password.PasswordActivity;
import com.huachenjie.login.page.password.PasswordVM;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.zk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class LoginActivityPasswordBindingImpl extends LoginActivityPasswordBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34648a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10001a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10002a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CheckBox f10003a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f10004a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f10005a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10006a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f10007a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f10008a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f10009a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f10010a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f10011a;

    @NonNull
    public final TextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public InverseBindingListener f10012b;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((LoginActivityPasswordBinding) LoginActivityPasswordBindingImpl.this).f34647a);
            PasswordVM passwordVM = ((LoginActivityPasswordBinding) LoginActivityPasswordBindingImpl.this).f10000a;
            if (passwordVM != null) {
                MutableLiveData<String> mutableLiveDataL = passwordVM.l();
                if (mutableLiveDataL != null) {
                    mutableLiveDataL.setValue(textString);
                }
            }
        }
    }

    public class b implements InverseBindingListener {
        public b() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            boolean zIsChecked = LoginActivityPasswordBindingImpl.this.f10003a.isChecked();
            PasswordVM passwordVM = ((LoginActivityPasswordBinding) LoginActivityPasswordBindingImpl.this).f10000a;
            if (passwordVM != null) {
                MutableLiveData<Boolean> mutableLiveDataM = passwordVM.m();
                if (mutableLiveDataM != null) {
                    mutableLiveDataM.setValue(Boolean.valueOf(zIsChecked));
                }
            }
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PasswordActivity.a f34651a;

        public c a(PasswordActivity.a aVar) {
            this.f34651a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34651a.a(view);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PasswordActivity.a f34652a;

        public d a(PasswordActivity.a aVar) {
            this.f34652a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34652a.c(view);
        }
    }

    public static class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PasswordActivity.a f34653a;

        public e a(PasswordActivity.a aVar) {
            this.f34653a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34653a.b(view);
        }
    }

    public LoginActivityPasswordBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f10001a, f34648a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String value;
        boolean z;
        String str;
        int iSafeUnbox;
        boolean z2;
        int i;
        d dVarA;
        e eVarA;
        c cVarA;
        boolean zSafeUnbox;
        int iSafeUnbox2;
        synchronized (this) {
            j = this.f10002a;
            this.f10002a = 0L;
        }
        PasswordVM passwordVM = ((LoginActivityPasswordBinding) this).f10000a;
        PasswordActivity.a aVar = ((LoginActivityPasswordBinding) this).f9999a;
        if ((47 & j) != 0) {
            if ((j & 41) != 0) {
                MutableLiveData<Boolean> mutableLiveDataM = passwordVM != null ? passwordVM.m() : null;
                updateLiveDataRegistration(0, mutableLiveDataM);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataM != null ? mutableLiveDataM.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 44) != 0) {
                BaseViewModel.b bVarE = passwordVM != null ? passwordVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                updateLiveDataRegistration(2, mutableLiveDataB);
                iSafeUnbox2 = ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null);
                iSafeUnbox = ViewDataBinding.safeUnbox(Integer.valueOf(iSafeUnbox2 + 16));
            } else {
                iSafeUnbox2 = 0;
                iSafeUnbox = 0;
            }
            long j2 = j & 42;
            if (j2 != 0) {
                MutableLiveData<String> mutableLiveDataL = passwordVM != null ? passwordVM.l() : null;
                updateLiveDataRegistration(1, mutableLiveDataL);
                value = mutableLiveDataL != null ? mutableLiveDataL.getValue() : null;
                boolean z3 = (value != null ? value.length() : 0) > 5;
                if (j2 != 0) {
                    j |= z3 ? 128L : 64L;
                }
                str = z3 ? "#0BD3FF" : "#FFFFFF";
                z2 = zSafeUnbox;
                i = iSafeUnbox2;
                z = z3;
            } else {
                z2 = zSafeUnbox;
                i = iSafeUnbox2;
                value = null;
                z = false;
                str = null;
            }
        } else {
            value = null;
            z = false;
            str = null;
            iSafeUnbox = 0;
            z2 = false;
            i = 0;
        }
        long j3 = j & 48;
        if (j3 == 0 || aVar == null) {
            dVarA = null;
            eVarA = null;
            cVarA = null;
        } else {
            e eVar = this.f10010a;
            if (eVar == null) {
                eVar = new e();
                this.f10010a = eVar;
            }
            eVarA = eVar.a(aVar);
            c cVar = this.f10008a;
            if (cVar == null) {
                cVar = new c();
                this.f10008a = cVar;
            }
            cVarA = cVar.a(aVar);
            d dVar = this.f10009a;
            if (dVar == null) {
                dVar = new d();
                this.f10009a = dVar;
            }
            dVarA = dVar.a(aVar);
        }
        if ((j & 42) != 0) {
            TextViewBindingAdapter.setText(((LoginActivityPasswordBinding) this).f34647a, value);
            CommonBindingAdapter.e0(this.f10006a, z);
            CommonBindingAdapter.W(this.f10006a, str);
        }
        if ((32 & j) != 0) {
            TextViewBindingAdapter.setTextWatcher(((LoginActivityPasswordBinding) this).f34647a, null, null, null, this.f10007a);
            CompoundButtonBindingAdapter.setListeners(this.f10003a, null, this.f10012b);
        }
        if ((44 & j) != 0) {
            CommonBindingAdapter.I(this.f10011a, 0, i, 0, 0, null);
            CommonBindingAdapter.I(this.f10005a, 0, iSafeUnbox, 0, 0, null);
        }
        if ((j & 41) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.f10003a, z2);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.f10006a, eVarA, null);
            CommonBindingAdapter.q(this.b, dVarA, null);
            CommonBindingAdapter.q(this.f10005a, cVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10002a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10002a = 32L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.login.databinding.LoginActivityPasswordBinding
    public void l(@Nullable PasswordActivity.a aVar) {
        ((LoginActivityPasswordBinding) this).f9999a = aVar;
        synchronized (this) {
            this.f10002a |= 16;
        }
        notifyPropertyChanged(zk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.login.databinding.LoginActivityPasswordBinding
    public void m(@Nullable PasswordVM passwordVM) {
        ((LoginActivityPasswordBinding) this).f10000a = passwordVM;
        synchronized (this) {
            this.f10002a |= 8;
        }
        notifyPropertyChanged(zk0.p0);
        super.requestRebind();
    }

    public final boolean o(MutableLiveData<String> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f10002a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return o((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return q((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f10002a |= 1;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f10002a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (zk0.p0 == i) {
            m((PasswordVM) obj);
        } else {
            if (zk0.k != i) {
                return false;
            }
            l((PasswordActivity.a) obj);
        }
        return true;
    }

    public LoginActivityPasswordBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (EditText) objArr[2]);
        this.f10007a = new a();
        this.f10012b = new b();
        this.f10002a = -1L;
        ((LoginActivityPasswordBinding) this).f34647a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f10004a = frameLayout;
        frameLayout.setTag(null);
        BLLinearLayout bLLinearLayout = (BLLinearLayout) objArr[1];
        this.f10011a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        CheckBox checkBox = (CheckBox) objArr[3];
        this.f10003a = checkBox;
        checkBox.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.f10006a = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[5];
        this.b = textView2;
        textView2.setTag(null);
        ImageView imageView = (ImageView) objArr[6];
        this.f10005a = imageView;
        imageView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
