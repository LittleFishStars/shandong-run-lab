package com.huachenjie.login.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.login.page.bind.BindPhoneActivity;
import com.huachenjie.login.page.bind.BindPhoneVM;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.zk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class LoginActivityBindPhoneBindingImpl extends LoginActivityBindPhoneBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34618a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9930a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9931a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f9932a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9933a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f9934a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f9935a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f9936a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f9937a;

    @NonNull
    public final TextView b;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((LoginActivityBindPhoneBinding) LoginActivityBindPhoneBindingImpl.this).f34617a);
            BindPhoneVM bindPhoneVM = ((LoginActivityBindPhoneBinding) LoginActivityBindPhoneBindingImpl.this).f9929a;
            if (bindPhoneVM != null) {
                MutableLiveData<String> mutableLiveDataI = bindPhoneVM.i();
                if (mutableLiveDataI != null) {
                    mutableLiveDataI.setValue(textString);
                }
            }
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BindPhoneActivity.ClickProxy f34620a;

        public b a(BindPhoneActivity.ClickProxy clickProxy) {
            this.f34620a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34620a.b(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BindPhoneActivity.ClickProxy f34621a;

        public c a(BindPhoneActivity.ClickProxy clickProxy) {
            this.f34621a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34621a.a(view);
        }
    }

    public LoginActivityBindPhoneBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f9930a, f34618a));
    }

    /* JADX WARN: Code duplicated, block: B:57:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:66:0x00db  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:75:? A[RETURN, SYNTHETIC] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        boolean z;
        String value;
        int iSafeUnbox;
        long j2;
        b bVarA;
        c cVarA;
        synchronized (this) {
            j = this.f9931a;
            this.f9931a = 0L;
        }
        BindPhoneVM bindPhoneVM = ((LoginActivityBindPhoneBinding) this).f9929a;
        BindPhoneActivity.ClickProxy clickProxy = ((LoginActivityBindPhoneBinding) this).f9928a;
        if ((23 & j) != 0) {
            long j3 = j & 21;
            if (j3 != 0) {
                MutableLiveData<String> mutableLiveDataI = bindPhoneVM != null ? bindPhoneVM.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                value = mutableLiveDataI != null ? mutableLiveDataI.getValue() : null;
                z = (value != null ? value.length() : 0) > 5;
                if (j3 != 0) {
                    j |= z ? 64L : 32L;
                }
                str = z ? "#0BD3FF" : "#FFFFFF";
            } else {
                str = null;
                z = false;
                value = null;
            }
            if ((j & 22) != 0) {
                BaseViewModel.b bVarE = bindPhoneVM != null ? bindPhoneVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                updateLiveDataRegistration(1, mutableLiveDataB);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null);
            }
            j2 = 24 & j;
            if (j2 != 0 || clickProxy == null) {
                bVarA = null;
                cVarA = null;
            } else {
                c cVar = this.f9936a;
                if (cVar == null) {
                    cVar = new c();
                    this.f9936a = cVar;
                }
                cVarA = cVar.a(clickProxy);
                b bVar = this.f9935a;
                if (bVar == null) {
                    bVar = new b();
                    this.f9935a = bVar;
                }
                bVarA = bVar.a(clickProxy);
            }
            if ((21 & j) != 0) {
                TextViewBindingAdapter.setText(((LoginActivityBindPhoneBinding) this).f34617a, value);
                CommonBindingAdapter.e0(this.f9933a, z);
                CommonBindingAdapter.W(this.f9933a, str);
            }
            if ((16 & j) != 0) {
                TextViewBindingAdapter.setTextWatcher(((LoginActivityBindPhoneBinding) this).f34617a, null, null, null, this.f9934a);
            }
            if ((j & 22) != 0) {
                CommonBindingAdapter.I(this.f9937a, 0, iSafeUnbox, 0, 0, null);
            }
            if (j2 != 0) {
                CommonBindingAdapter.q(this.f9933a, bVarA, null);
                CommonBindingAdapter.q(this.b, cVarA, null);
            }
        }
        str = null;
        z = false;
        value = null;
        iSafeUnbox = 0;
        j2 = 24 & j;
        if (j2 != 0) {
            bVarA = null;
            cVarA = null;
        } else {
            bVarA = null;
            cVarA = null;
        }
        if ((21 & j) != 0) {
            TextViewBindingAdapter.setText(((LoginActivityBindPhoneBinding) this).f34617a, value);
            CommonBindingAdapter.e0(this.f9933a, z);
            CommonBindingAdapter.W(this.f9933a, str);
        }
        if ((16 & j) != 0) {
            TextViewBindingAdapter.setTextWatcher(((LoginActivityBindPhoneBinding) this).f34617a, null, null, null, this.f9934a);
        }
        if ((j & 22) != 0) {
            CommonBindingAdapter.I(this.f9937a, 0, iSafeUnbox, 0, 0, null);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f9933a, bVarA, null);
            CommonBindingAdapter.q(this.b, cVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9931a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9931a = 16L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.login.databinding.LoginActivityBindPhoneBinding
    public void l(@Nullable BindPhoneActivity.ClickProxy clickProxy) {
        ((LoginActivityBindPhoneBinding) this).f9928a = clickProxy;
        synchronized (this) {
            this.f9931a |= 8;
        }
        notifyPropertyChanged(zk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.login.databinding.LoginActivityBindPhoneBinding
    public void m(@Nullable BindPhoneVM bindPhoneVM) {
        ((LoginActivityBindPhoneBinding) this).f9929a = bindPhoneVM;
        synchronized (this) {
            this.f9931a |= 4;
        }
        notifyPropertyChanged(zk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<String> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f9931a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f9931a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((MutableLiveData) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return o((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (zk0.p0 == i) {
            m((BindPhoneVM) obj);
        } else {
            if (zk0.k != i) {
                return false;
            }
            l((BindPhoneActivity.ClickProxy) obj);
        }
        return true;
    }

    public LoginActivityBindPhoneBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (EditText) objArr[2]);
        this.f9934a = new a();
        this.f9931a = -1L;
        ((LoginActivityBindPhoneBinding) this).f34617a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f9932a = frameLayout;
        frameLayout.setTag(null);
        BLLinearLayout bLLinearLayout = (BLLinearLayout) objArr[1];
        this.f9937a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.f9933a = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[4];
        this.b = textView2;
        textView2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
