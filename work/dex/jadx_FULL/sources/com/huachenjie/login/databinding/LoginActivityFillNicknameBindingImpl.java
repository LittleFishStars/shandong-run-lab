package com.huachenjie.login.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
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
import com.huachenjie.login.page.info.nickname.FillNicknameActivity;
import com.huachenjie.login.page.info.nickname.FillNicknameVM;
import com.noober.background.view.BLEditText;
import com.zj.adlib.zk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class LoginActivityFillNicknameBindingImpl extends LoginActivityFillNicknameBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34641a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9980a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9981a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f9982a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9983a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9984a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f9985a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f9986a;

    @NonNull
    public final TextView b;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((LoginActivityFillNicknameBinding) LoginActivityFillNicknameBindingImpl.this).f9979a);
            FillNicknameVM fillNicknameVM = ((LoginActivityFillNicknameBinding) LoginActivityFillNicknameBindingImpl.this).f9978a;
            if (fillNicknameVM != null) {
                MutableLiveData<String> mutableLiveDataL = fillNicknameVM.l();
                if (mutableLiveDataL != null) {
                    mutableLiveDataL.setValue(textString);
                }
            }
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public FillNicknameActivity.a f34643a;

        public b a(FillNicknameActivity.a aVar) {
            this.f34643a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34643a.a(view);
        }
    }

    public LoginActivityFillNicknameBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f9980a, f34641a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0037  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String value;
        String value2;
        String str;
        boolean z;
        int i;
        b bVarA;
        int iSafeUnbox;
        synchronized (this) {
            j = this.f9981a;
            this.f9981a = 0L;
        }
        FillNicknameVM fillNicknameVM = ((LoginActivityFillNicknameBinding) this).f9978a;
        FillNicknameActivity.a aVar = ((LoginActivityFillNicknameBinding) this).f34640a;
        if ((47 & j) != 0) {
            if ((j & 41) == 0) {
                value2 = null;
            } else {
                MutableLiveData<String> mutableLiveDataK = fillNicknameVM != null ? fillNicknameVM.k() : null;
                updateLiveDataRegistration(0, mutableLiveDataK);
                if (mutableLiveDataK != null) {
                    value2 = mutableLiveDataK.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 44) != 0) {
                BaseViewModel.b bVarE = fillNicknameVM != null ? fillNicknameVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                updateLiveDataRegistration(2, mutableLiveDataB);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null);
            } else {
                iSafeUnbox = 0;
            }
            long j2 = j & 42;
            if (j2 != 0) {
                MutableLiveData<String> mutableLiveDataL = fillNicknameVM != null ? fillNicknameVM.l() : null;
                updateLiveDataRegistration(1, mutableLiveDataL);
                value = mutableLiveDataL != null ? mutableLiveDataL.getValue() : null;
                String strTrim = value != null ? value.trim() : null;
                z = (strTrim != null ? strTrim.length() : 0) > 0;
                if (j2 != 0) {
                    j |= z ? 128L : 64L;
                }
                str = z ? "#0BD3FF" : "#FFFFFF";
                i = iSafeUnbox;
            } else {
                i = iSafeUnbox;
                value = null;
                str = null;
                z = false;
            }
        } else {
            value = null;
            value2 = null;
            str = null;
            z = false;
            i = 0;
        }
        long j3 = j & 48;
        if (j3 == 0 || aVar == null) {
            bVarA = null;
        } else {
            b bVar = this.f9986a;
            if (bVar == null) {
                bVar = new b();
                this.f9986a = bVar;
            }
            bVarA = bVar.a(aVar);
        }
        if ((j & 42) != 0) {
            TextViewBindingAdapter.setText(((LoginActivityFillNicknameBinding) this).f9979a, value);
            CommonBindingAdapter.e0(this.b, z);
            CommonBindingAdapter.W(this.b, str);
        }
        if ((32 & j) != 0) {
            TextViewBindingAdapter.setTextWatcher(((LoginActivityFillNicknameBinding) this).f9979a, null, null, null, this.f9985a);
        }
        if ((44 & j) != 0) {
            CommonBindingAdapter.I(this.f9983a, 0, i, 0, 0, null);
        }
        if ((j & 41) != 0) {
            TextViewBindingAdapter.setText(this.f9984a, value2);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.b, bVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9981a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9981a = 32L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.login.databinding.LoginActivityFillNicknameBinding
    public void l(@Nullable FillNicknameActivity.a aVar) {
        ((LoginActivityFillNicknameBinding) this).f34640a = aVar;
        synchronized (this) {
            this.f9981a |= 16;
        }
        notifyPropertyChanged(zk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.login.databinding.LoginActivityFillNicknameBinding
    public void m(@Nullable FillNicknameVM fillNicknameVM) {
        ((LoginActivityFillNicknameBinding) this).f9978a = fillNicknameVM;
        synchronized (this) {
            this.f9981a |= 8;
        }
        notifyPropertyChanged(zk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<String> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f9981a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<String> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f9981a |= 2;
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
            this.f9981a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (zk0.p0 == i) {
            m((FillNicknameVM) obj);
        } else {
            if (zk0.k != i) {
                return false;
            }
            l((FillNicknameActivity.a) obj);
        }
        return true;
    }

    public LoginActivityFillNicknameBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (BLEditText) objArr[3]);
        this.f9985a = new a();
        this.f9981a = -1L;
        ((LoginActivityFillNicknameBinding) this).f9979a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f9982a = frameLayout;
        frameLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[1];
        this.f9983a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f9984a = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[4];
        this.b = textView2;
        textView2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
