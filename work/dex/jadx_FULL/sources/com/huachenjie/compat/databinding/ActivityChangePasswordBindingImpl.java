package com.huachenjie.compat.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.compat.page.account.ChangePasswordActivity;
import com.huachenjie.compat.page.account.ChangePasswordVM;
import com.zj.adlib.wk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class ActivityChangePasswordBindingImpl extends ActivityChangePasswordBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34029a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9100a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9101a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f9102a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f9103a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f9104a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f9105a;
    public InverseBindingListener b;
    public InverseBindingListener c;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((ActivityChangePasswordBinding) ActivityChangePasswordBindingImpl.this).f9094a);
            ChangePasswordVM changePasswordVM = ((ActivityChangePasswordBinding) ActivityChangePasswordBindingImpl.this).f9097a;
            if (changePasswordVM != null) {
                MutableLiveData<String> mutableLiveDataJ = changePasswordVM.j();
                if (mutableLiveDataJ != null) {
                    mutableLiveDataJ.setValue(textString);
                }
            }
        }
    }

    public class b implements InverseBindingListener {
        public b() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((ActivityChangePasswordBinding) ActivityChangePasswordBindingImpl.this).f9098b);
            ChangePasswordVM changePasswordVM = ((ActivityChangePasswordBinding) ActivityChangePasswordBindingImpl.this).f9097a;
            if (changePasswordVM != null) {
                MutableLiveData<String> mutableLiveDataK = changePasswordVM.k();
                if (mutableLiveDataK != null) {
                    mutableLiveDataK.setValue(textString);
                }
            }
        }
    }

    public class c implements InverseBindingListener {
        public c() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((ActivityChangePasswordBinding) ActivityChangePasswordBindingImpl.this).c);
            ChangePasswordVM changePasswordVM = ((ActivityChangePasswordBinding) ActivityChangePasswordBindingImpl.this).f9097a;
            if (changePasswordVM != null) {
                MutableLiveData<String> mutableLiveDataL = changePasswordVM.l();
                if (mutableLiveDataL != null) {
                    mutableLiveDataL.setValue(textString);
                }
            }
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ChangePasswordActivity.a f34033a;

        public d a(ChangePasswordActivity.a aVar) {
            this.f34033a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34033a.a(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(9);
        f9100a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{6}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34029a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.compat.R.id.cb_password, 7);
        sparseIntArray.put(com.huachenjie.compat.R.id.cb_confirm_password, 8);
    }

    public ActivityChangePasswordBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, f9100a, f34029a));
    }

    /* JADX WARN: Code duplicated, block: B:26:0x005c  */
    /* JADX WARN: Code duplicated, block: B:35:0x0078  */
    /* JADX WARN: Code duplicated, block: B:44:0x0094  */
    /* JADX WARN: Code duplicated, block: B:53:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:62:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:71:0x00ea  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String value;
        BindingTitleBean value2;
        String value3;
        String value4;
        String value5;
        String value6;
        d dVarA;
        synchronized (this) {
            j = this.f9101a;
            this.f9101a = 0L;
        }
        ChangePasswordVM changePasswordVM = ((ActivityChangePasswordBinding) this).f9097a;
        ChangePasswordActivity.a aVar = ((ActivityChangePasswordBinding) this).f9096a;
        boolean zSafeUnbox = false;
        if ((767 & j) != 0) {
            if ((j & 641) != 0) {
                MutableLiveData<Boolean> mutableLiveDataI = changePasswordVM != null ? changePasswordVM.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataI != null ? mutableLiveDataI.getValue() : null);
            }
            if ((j & 642) == 0) {
                value2 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataQ = changePasswordVM != null ? changePasswordVM.q() : null;
                updateLiveDataRegistration(1, mutableLiveDataQ);
                if (mutableLiveDataQ != null) {
                    value2 = mutableLiveDataQ.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 644) == 0) {
                value5 = null;
            } else {
                MutableLiveData<String> mutableLiveDataN = changePasswordVM != null ? changePasswordVM.n() : null;
                updateLiveDataRegistration(2, mutableLiveDataN);
                if (mutableLiveDataN != null) {
                    value5 = mutableLiveDataN.getValue();
                } else {
                    value5 = null;
                }
            }
            if ((j & 648) == 0) {
                value6 = null;
            } else {
                MutableLiveData<String> mutableLiveDataL = changePasswordVM != null ? changePasswordVM.l() : null;
                updateLiveDataRegistration(3, mutableLiveDataL);
                if (mutableLiveDataL != null) {
                    value6 = mutableLiveDataL.getValue();
                } else {
                    value6 = null;
                }
            }
            if ((j & 656) == 0) {
                value3 = null;
            } else {
                MutableLiveData<String> mutableLiveDataJ = changePasswordVM != null ? changePasswordVM.j() : null;
                updateLiveDataRegistration(4, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value3 = mutableLiveDataJ.getValue();
                } else {
                    value3 = null;
                }
            }
            if ((j & 672) == 0) {
                value4 = null;
            } else {
                MutableLiveData<String> mutableLiveDataO = changePasswordVM != null ? changePasswordVM.o() : null;
                updateLiveDataRegistration(5, mutableLiveDataO);
                if (mutableLiveDataO != null) {
                    value4 = mutableLiveDataO.getValue();
                } else {
                    value4 = null;
                }
            }
            if ((j & 704) == 0) {
                value = null;
            } else {
                MutableLiveData<String> mutableLiveDataK = changePasswordVM != null ? changePasswordVM.k() : null;
                updateLiveDataRegistration(6, mutableLiveDataK);
                if (mutableLiveDataK != null) {
                    value = mutableLiveDataK.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            value = null;
            value2 = null;
            value3 = null;
            value4 = null;
            value5 = null;
            value6 = null;
        }
        long j2 = j & 768;
        if (j2 == 0 || aVar == null) {
            dVarA = null;
        } else {
            d dVar = this.f9105a;
            if (dVar == null) {
                dVar = new d();
                this.f9105a = dVar;
            }
            dVarA = dVar.a(aVar);
        }
        if ((j & 656) != 0) {
            TextViewBindingAdapter.setText(((ActivityChangePasswordBinding) this).f9094a, value3);
        }
        if ((512 & j) != 0) {
            TextViewBindingAdapter.setTextWatcher(((ActivityChangePasswordBinding) this).f9094a, null, null, null, this.f9103a);
            TextViewBindingAdapter.setTextWatcher(((ActivityChangePasswordBinding) this).f9098b, null, null, null, this.b);
            TextViewBindingAdapter.setTextWatcher(super.c, null, null, null, this.c);
        }
        if ((704 & j) != 0) {
            TextViewBindingAdapter.setText(((ActivityChangePasswordBinding) this).f9098b, value);
        }
        if ((648 & j) != 0) {
            TextViewBindingAdapter.setText(super.c, value6);
        }
        if ((j & 642) != 0) {
            this.f9104a.k(value2);
        }
        if ((644 & j) != 0) {
            TextView textView = ((ActivityChangePasswordBinding) this).f9095a;
            CommonBindingAdapter.P(textView, value5, textView.getResources().getString(com.huachenjie.compat.R.string.mine_phone));
        }
        if ((j & 641) != 0) {
            CommonBindingAdapter.e0(((ActivityChangePasswordBinding) this).f9099b, zSafeUnbox);
        }
        if ((j & 672) != 0) {
            TextViewBindingAdapter.setText(((ActivityChangePasswordBinding) this).f9099b, value4);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(((ActivityChangePasswordBinding) this).f9099b, dVarA, null);
        }
        ViewDataBinding.executeBindingsOn(this.f9104a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9101a != 0) {
                return true;
            }
            return this.f9104a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9101a = 512L;
        }
        this.f9104a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.compat.databinding.ActivityChangePasswordBinding
    public void l(@Nullable ChangePasswordActivity.a aVar) {
        ((ActivityChangePasswordBinding) this).f9096a = aVar;
        synchronized (this) {
            this.f9101a |= 256;
        }
        notifyPropertyChanged(wk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.compat.databinding.ActivityChangePasswordBinding
    public void m(@Nullable ChangePasswordVM changePasswordVM) {
        ((ActivityChangePasswordBinding) this).f9097a = changePasswordVM;
        synchronized (this) {
            this.f9101a |= 128;
        }
        notifyPropertyChanged(wk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9101a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<String> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9101a |= 16;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return n((MutableLiveData) obj, i2);
            case 1:
                return t((MutableLiveData) obj, i2);
            case 2:
                return r((MutableLiveData) obj, i2);
            case 3:
                return q((MutableLiveData) obj, i2);
            case 4:
                return o((MutableLiveData) obj, i2);
            case 5:
                return s((MutableLiveData) obj, i2);
            case 6:
                return p((MutableLiveData) obj, i2);
            default:
                return false;
        }
    }

    public final boolean p(MutableLiveData<String> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9101a |= 64;
        }
        return true;
    }

    public final boolean q(MutableLiveData<String> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9101a |= 8;
        }
        return true;
    }

    public final boolean r(MutableLiveData<String> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9101a |= 4;
        }
        return true;
    }

    public final boolean s(MutableLiveData<String> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9101a |= 32;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f9104a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (wk0.p0 == i) {
            m((ChangePasswordVM) obj);
        } else {
            if (wk0.k != i) {
                return false;
            }
            l((ChangePasswordActivity.a) obj);
        }
        return true;
    }

    public final boolean t(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9101a |= 2;
        }
        return true;
    }

    public ActivityChangePasswordBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 7, (CheckBox) objArr[8], (CheckBox) objArr[7], (EditText) objArr[5], (EditText) objArr[4], (EditText) objArr[2], (TextView) objArr[1], (TextView) objArr[3]);
        this.f9103a = new a();
        this.b = new b();
        this.c = new c();
        this.f9101a = -1L;
        ((ActivityChangePasswordBinding) this).f9094a.setTag(null);
        ((ActivityChangePasswordBinding) this).f9098b.setTag(null);
        super.c.setTag(null);
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[6];
        this.f9104a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f9102a = constraintLayout;
        constraintLayout.setTag(null);
        ((ActivityChangePasswordBinding) this).f9095a.setTag(null);
        ((ActivityChangePasswordBinding) this).f9099b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
