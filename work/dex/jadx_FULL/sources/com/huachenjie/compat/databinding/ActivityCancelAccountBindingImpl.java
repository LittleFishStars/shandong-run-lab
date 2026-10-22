package com.huachenjie.compat.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
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
import com.huachenjie.compat.page.account.CancelAccountActivity;
import com.huachenjie.compat.page.account.CancelAccountVM;
import com.zj.adlib.wk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class ActivityCancelAccountBindingImpl extends ActivityCancelAccountBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34011a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9058a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9059a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f9060a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f9061a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f9062a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f9063a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f9064a;
    public InverseBindingListener b;

    @NonNull
    public final TextView d;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((ActivityCancelAccountBinding) ActivityCancelAccountBindingImpl.this).f9052a);
            CancelAccountVM cancelAccountVM = ((ActivityCancelAccountBinding) ActivityCancelAccountBindingImpl.this).f9056a;
            if (cancelAccountVM != null) {
                MutableLiveData<String> mutableLiveDataH = cancelAccountVM.h();
                if (mutableLiveDataH != null) {
                    mutableLiveDataH.setValue(textString);
                }
            }
        }
    }

    public class b implements InverseBindingListener {
        public b() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((ActivityCancelAccountBinding) ActivityCancelAccountBindingImpl.this).b);
            CancelAccountVM cancelAccountVM = ((ActivityCancelAccountBinding) ActivityCancelAccountBindingImpl.this).f9056a;
            if (cancelAccountVM != null) {
                MutableLiveData<String> mutableLiveDataI = cancelAccountVM.i();
                if (mutableLiveDataI != null) {
                    mutableLiveDataI.setValue(textString);
                }
            }
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CancelAccountActivity.a f34014a;

        public c a(CancelAccountActivity.a aVar) {
            this.f34014a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34014a.b(view);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CancelAccountActivity.a f34015a;

        public d a(CancelAccountActivity.a aVar) {
            this.f34015a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34015a.a(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(10);
        f9058a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{5}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34011a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.compat.R.id.ll_title, 6);
        sparseIntArray.put(com.huachenjie.compat.R.id.tv_phone, 7);
        sparseIntArray.put(com.huachenjie.compat.R.id.v_line, 8);
        sparseIntArray.put(com.huachenjie.compat.R.id.tv_sms_code, 9);
    }

    public ActivityCancelAccountBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, f9058a, f34011a));
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0147 A[PHI: r10
      0x0147: PHI (r10v4 java.lang.String) = (r10v3 java.lang.String), (r10v6 java.lang.String) binds: [B:93:0x0126, B:103:0x0144] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:31:0x0068  */
    /* JADX WARN: Code duplicated, block: B:62:0x00cf  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        BindingTitleBean value;
        MutableLiveData<String> mutableLiveDataI;
        String value2;
        String value3;
        boolean z;
        c cVarA;
        d dVarA;
        boolean z2;
        boolean z3;
        boolean z4;
        synchronized (this) {
            j = this.f9059a;
            this.f9059a = 0L;
        }
        CancelAccountVM cancelAccountVM = ((ActivityCancelAccountBinding) this).f9056a;
        CancelAccountActivity.a aVar = ((ActivityCancelAccountBinding) this).f9055a;
        if ((47 & j) != 0) {
            long j2 = j & 45;
            if (j2 != 0) {
                MutableLiveData<String> mutableLiveDataH = cancelAccountVM != null ? cancelAccountVM.h() : null;
                updateLiveDataRegistration(0, mutableLiveDataH);
                value2 = mutableLiveDataH != null ? mutableLiveDataH.getValue() : null;
                z = !TextUtils.isEmpty(value2);
                if (j2 != 0) {
                    j = z ? j | 128 : j | 64;
                }
            } else {
                z = false;
                value2 = null;
            }
            if ((j & 42) == 0) {
                value = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataJ = cancelAccountVM != null ? cancelAccountVM.j() : null;
                updateLiveDataRegistration(1, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value = mutableLiveDataJ.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 44) != 0) {
                mutableLiveDataI = cancelAccountVM != null ? cancelAccountVM.i() : null;
                updateLiveDataRegistration(2, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value3 = mutableLiveDataI.getValue();
                }
            } else {
                mutableLiveDataI = null;
            }
            value3 = null;
        } else {
            value = null;
            mutableLiveDataI = null;
            value2 = null;
            value3 = null;
            z = false;
        }
        if ((j & 48) == 0 || aVar == null) {
            cVarA = null;
            dVarA = null;
        } else {
            d dVar = this.f9064a;
            if (dVar == null) {
                dVar = new d();
                this.f9064a = dVar;
            }
            dVarA = dVar.a(aVar);
            c cVar = this.f9063a;
            if (cVar == null) {
                cVar = new c();
                this.f9063a = cVar;
            }
            cVarA = cVar.a(aVar);
        }
        if ((128 & j) == 0) {
            z2 = false;
        } else {
            if ((value2 != null ? value2.length() : 0) == 11) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        long j3 = j & 45;
        if (j3 != 0) {
            if (!z) {
                z2 = false;
            }
            if (j3 != 0) {
                j = z2 ? j | 2048 : j | 1024;
            }
        } else {
            z2 = false;
        }
        if ((j & 2048) != 0) {
            if (cancelAccountVM != null) {
                mutableLiveDataI = cancelAccountVM.i();
            }
            updateLiveDataRegistration(2, mutableLiveDataI);
            if (mutableLiveDataI != null) {
                value3 = mutableLiveDataI.getValue();
            }
            z3 = true;
            z4 = !TextUtils.isEmpty(value3);
        } else {
            z3 = true;
            z4 = false;
        }
        long j4 = j & 45;
        if (j4 != 0) {
            if (!z2) {
                z4 = false;
            }
            if (j4 != 0) {
                j = z4 ? j | 512 : j | 256;
            }
        } else {
            z4 = false;
        }
        if ((j & 512) == 0) {
            z3 = false;
        } else {
            if (cancelAccountVM != null) {
                mutableLiveDataI = cancelAccountVM.i();
            }
            updateLiveDataRegistration(2, mutableLiveDataI);
            if (mutableLiveDataI != null) {
                value3 = mutableLiveDataI.getValue();
            }
            if ((value3 != null ? value3.length() : 0) != 4) {
                z3 = false;
            }
        }
        long j5 = 45 & j;
        boolean z5 = (j5 == 0 || !z4) ? false : z3;
        if ((41 & j) != 0) {
            TextViewBindingAdapter.setText(((ActivityCancelAccountBinding) this).f9052a, value2);
        }
        if ((32 & j) != 0) {
            TextViewBindingAdapter.setTextWatcher(((ActivityCancelAccountBinding) this).f9052a, null, null, null, this.f9061a);
            TextViewBindingAdapter.setTextWatcher(((ActivityCancelAccountBinding) this).b, null, null, null, this.b);
        }
        if ((44 & j) != 0) {
            TextViewBindingAdapter.setText(((ActivityCancelAccountBinding) this).b, value3);
        }
        if ((42 & j) != 0) {
            this.f9062a.k(value);
        }
        if (j5 != 0) {
            CommonBindingAdapter.e0(this.d, z5);
        }
        if ((j & 48) != 0) {
            CommonBindingAdapter.q(this.d, dVarA, null);
            CommonBindingAdapter.q(((ActivityCancelAccountBinding) this).f9054a, cVarA, null);
        }
        ViewDataBinding.executeBindingsOn(this.f9062a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9059a != 0) {
                return true;
            }
            return this.f9062a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9059a = 32L;
        }
        this.f9062a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.compat.databinding.ActivityCancelAccountBinding
    public void l(@Nullable CancelAccountActivity.a aVar) {
        ((ActivityCancelAccountBinding) this).f9055a = aVar;
        synchronized (this) {
            this.f9059a |= 16;
        }
        notifyPropertyChanged(wk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.compat.databinding.ActivityCancelAccountBinding
    public void m(@Nullable CancelAccountVM cancelAccountVM) {
        ((ActivityCancelAccountBinding) this).f9056a = cancelAccountVM;
        synchronized (this) {
            this.f9059a |= 8;
        }
        notifyPropertyChanged(wk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<String> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9059a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<String> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9059a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return p((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return o((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9059a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f9062a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (wk0.p0 == i) {
            m((CancelAccountVM) obj);
        } else {
            if (wk0.k != i) {
                return false;
            }
            l((CancelAccountActivity.a) obj);
        }
        return true;
    }

    public ActivityCancelAccountBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (EditText) objArr[1], (EditText) objArr[2], (LinearLayout) objArr[6], (TextView) objArr[3], (TextView) objArr[7], (TextView) objArr[9], (View) objArr[8]);
        this.f9061a = new a();
        this.b = new b();
        this.f9059a = -1L;
        ((ActivityCancelAccountBinding) this).f9052a.setTag(null);
        ((ActivityCancelAccountBinding) this).b.setTag(null);
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[5];
        this.f9062a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f9060a = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.d = textView;
        textView.setTag(null);
        ((ActivityCancelAccountBinding) this).f9054a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
