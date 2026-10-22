package com.huachenjie.run.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.run.page.sun_run.SunshineRunVM;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunLayoutSunRunDebugInfoBindingImpl extends RunLayoutSunRunDebugInfoBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35714a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12204a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12205a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f12206a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f12207a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public RunLayoutSunRunDebugInfoBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 5, f12204a, f35714a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0039  */
    /* JADX WARN: Code duplicated, block: B:36:0x0091  */
    /* JADX WARN: Code duplicated, block: B:51:0x00df  */
    /* JADX WARN: Code duplicated, block: B:54:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:57:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:60:0x0107  */
    /* JADX WARN: Code duplicated, block: B:67:? A[RETURN, SYNTHETIC] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        long j2;
        String str;
        String value;
        String str2;
        String value2;
        boolean z;
        boolean zIsEmpty;
        synchronized (this) {
            j = this.f12205a;
            this.f12205a = 0L;
        }
        SunshineRunVM sunshineRunVM = ((RunLayoutSunRunDebugInfoBinding) this).f35713a;
        if ((63 & j) != 0) {
            if ((j & 49) == 0) {
                value = null;
            } else {
                MutableLiveData<String> mutableLiveDataS = sunshineRunVM != null ? sunshineRunVM.s() : null;
                updateLiveDataRegistration(0, mutableLiveDataS);
                if (mutableLiveDataS != null) {
                    value = mutableLiveDataS.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 50) != 0) {
                MutableLiveData<String> mutableLiveDataR = sunshineRunVM != null ? sunshineRunVM.r() : null;
                updateLiveDataRegistration(1, mutableLiveDataR);
                String value3 = mutableLiveDataR != null ? mutableLiveDataR.getValue() : null;
                boolean zIsEmpty2 = TextUtils.isEmpty(value3);
                str2 = "i：" + value3;
                z = !zIsEmpty2;
            } else {
                str2 = null;
                z = false;
            }
            if ((j & 52) == 0) {
                value2 = null;
            } else {
                MutableLiveData<String> mutableLiveDataK = sunshineRunVM != null ? sunshineRunVM.k() : null;
                updateLiveDataRegistration(2, mutableLiveDataK);
                if (mutableLiveDataK != null) {
                    value2 = mutableLiveDataK.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 56) != 0) {
                MutableLiveData<String> mutableLiveDataQ = sunshineRunVM != null ? sunshineRunVM.Q() : null;
                updateLiveDataRegistration(3, mutableLiveDataQ);
                String value4 = mutableLiveDataQ != null ? mutableLiveDataQ.getValue() : null;
                zIsEmpty = true ^ TextUtils.isEmpty(value4);
                str = "s：" + value4;
                j2 = 49;
            } else {
                str = null;
                j2 = 49;
            }
            if ((j2 & j) != 0) {
                TextViewBindingAdapter.setText(this.f12207a, value);
            }
            if ((j & 52) != 0) {
                TextViewBindingAdapter.setText(this.b, value2);
            }
            if ((56 & j) != 0) {
                TextViewBindingAdapter.setText(this.c, str);
                CommonBindingAdapter.l0(this.c, zIsEmpty);
            }
            if ((j & 50) != 0) {
                TextViewBindingAdapter.setText(this.d, str2);
                CommonBindingAdapter.l0(this.d, z);
            }
        }
        j2 = 49;
        str = null;
        value = null;
        str2 = null;
        value2 = null;
        z = false;
        zIsEmpty = false;
        if ((j2 & j) != 0) {
            TextViewBindingAdapter.setText(this.f12207a, value);
        }
        if ((j & 52) != 0) {
            TextViewBindingAdapter.setText(this.b, value2);
        }
        if ((56 & j) != 0) {
            TextViewBindingAdapter.setText(this.c, str);
            CommonBindingAdapter.l0(this.c, zIsEmpty);
        }
        if ((j & 50) != 0) {
            TextViewBindingAdapter.setText(this.d, str2);
            CommonBindingAdapter.l0(this.d, z);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12205a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12205a = 32L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunLayoutSunRunDebugInfoBinding
    public void k(@Nullable SunshineRunVM Vm) {
        ((RunLayoutSunRunDebugInfoBinding) this).f35713a = Vm;
        synchronized (this) {
            this.f12205a |= 16;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<String> VmAccuracyText, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12205a |= 4;
        }
        return true;
    }

    public final boolean m(MutableLiveData<String> VmInterstitialAdShowResult, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12205a |= 2;
        }
        return true;
    }

    public final boolean n(MutableLiveData<String> VmLocationResult, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12205a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<String> VmSplashAdShowResult, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12205a |= 8;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return n((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 1) {
            return m((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 2) {
            return l((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 3) {
            return false;
        }
        return o((MutableLiveData) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 != variableId) {
            return false;
        }
        k((SunshineRunVM) variable);
        return true;
    }

    public RunLayoutSunRunDebugInfoBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 4);
        this.f12205a = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f12206a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) bindings[1];
        this.f12207a = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[2];
        this.b = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) bindings[3];
        this.c = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) bindings[4];
        this.d = textView4;
        textView4.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
