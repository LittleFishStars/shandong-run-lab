package com.huachenjie.run.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.binding_adapter.DrawablesBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.widget.ShadowFrameLayout;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import com.huachenjie.run.page.sun_run.SunshineRunVM;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunLayoutSunRunPaceInfoBindingImpl extends RunLayoutSunRunPaceInfoBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35716a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12209a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12210a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f12211a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f12212a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f12213a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f12214a;

    @NonNull
    public final TextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final ShadowFrameLayout f12215b;

    public RunLayoutSunRunPaceInfoBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 7, f12209a, f35716a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        long j2;
        String value;
        int iSafeUnbox;
        int i6;
        int i7;
        int i8;
        int i9;
        long j3;
        long j4;
        synchronized (this) {
            j = this.f12210a;
            this.f12210a = 0L;
        }
        SunshineRunVM sunshineRunVM = ((RunLayoutSunRunPaceInfoBinding) this).f12208a;
        String value2 = null;
        if ((63 & j) != 0) {
            if ((j & 52) != 0) {
                BaseViewModel.b bVarE = sunshineRunVM != null ? sunshineRunVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                updateLiveDataRegistration(2, mutableLiveDataB);
                iSafeUnbox = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null) + 20));
            } else {
                iSafeUnbox = 0;
            }
            long j5 = j & 49;
            if (j5 != 0) {
                MutableLiveData<String> mutableLiveDataY = sunshineRunVM != null ? sunshineRunVM.y() : null;
                updateLiveDataRegistration(0, mutableLiveDataY);
                value = mutableLiveDataY != null ? mutableLiveDataY.getValue() : null;
                boolean zIsEmpty = TextUtils.isEmpty(value);
                if (j5 != 0) {
                    j |= zIsEmpty ? 8192L : 4096L;
                }
                i6 = zIsEmpty ? 8 : 0;
            } else {
                i6 = 0;
                value = null;
            }
            long j6 = j & 50;
            if (j6 != 0) {
                MutableLiveData<Boolean> mutableLiveDataZ = sunshineRunVM != null ? sunshineRunVM.z() : null;
                updateLiveDataRegistration(1, mutableLiveDataZ);
                boolean zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataZ != null ? mutableLiveDataZ.getValue() : null);
                if (j6 != 0) {
                    if (zSafeUnbox) {
                        j3 = j | 128 | 512;
                        j4 = 2048;
                    } else {
                        j3 = j | 64 | 256;
                        j4 = 1024;
                    }
                    j = j3 | j4;
                }
                int i10 = zSafeUnbox ? -12858007 : RunIndexRecordAdapter.L;
                i8 = zSafeUnbox ? 8 : 20;
                i9 = zSafeUnbox ? 8 : 0;
                i7 = i10;
            } else {
                i7 = 0;
                i8 = 0;
                i9 = 0;
            }
            if ((j & 56) != 0) {
                MutableLiveData<String> mutableLiveDataA = sunshineRunVM != null ? sunshineRunVM.A() : null;
                updateLiveDataRegistration(3, mutableLiveDataA);
                if (mutableLiveDataA != null) {
                    value2 = mutableLiveDataA.getValue();
                }
            }
            i3 = i6;
            i = i7;
            str = value2;
            i4 = iSafeUnbox;
            i2 = i9;
            i5 = i8;
            j2 = 52;
        } else {
            str = null;
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            j2 = 52;
            value = null;
        }
        if ((j & j2) != 0) {
            CommonBindingAdapter.I(this.f12213a, 0, i4, 16, 0, null);
        }
        if ((50 & j) != 0) {
            DrawablesBindingAdapter.h(this.f12212a, 0, Integer.valueOf(i), -1, 1.0f, 0.0f, 0.0f, 8.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            CommonBindingAdapter.O(this.f12212a, i5, 4, 8, 4, null);
            this.f12211a.setVisibility(i2);
            ((RunLayoutSunRunPaceInfoBinding) this).f35715a.setBgColor(i);
        }
        if ((j & 56) != 0) {
            TextViewBindingAdapter.setText(this.f12214a, str);
        }
        if ((j & 49) != 0) {
            this.f12215b.setVisibility(i3);
            TextViewBindingAdapter.setText(this.b, value);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12210a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12210a = 32L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunLayoutSunRunPaceInfoBinding
    public void k(@Nullable SunshineRunVM Vm) {
        ((RunLayoutSunRunPaceInfoBinding) this).f12208a = Vm;
        synchronized (this) {
            this.f12210a |= 16;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<String> VmPaceLimitText, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12210a |= 1;
        }
        return true;
    }

    public final boolean m(MutableLiveData<Boolean> VmPaceNormal, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12210a |= 2;
        }
        return true;
    }

    public final boolean n(MutableLiveData<String> VmPaceText, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12210a |= 8;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> VmUiLiveDataStatusBarHeight, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12210a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return l((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 1) {
            return m((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 2) {
            return o((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 3) {
            return false;
        }
        return n((MutableLiveData) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 != variableId) {
            return false;
        }
        k((SunshineRunVM) variable);
        return true;
    }

    public RunLayoutSunRunPaceInfoBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 4, (ShadowFrameLayout) bindings[1]);
        this.f12210a = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.f12213a = relativeLayout;
        relativeLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[2];
        this.f12212a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) bindings[3];
        this.f12214a = textView;
        textView.setTag(null);
        ImageView imageView = (ImageView) bindings[4];
        this.f12211a = imageView;
        imageView.setTag(null);
        ShadowFrameLayout shadowFrameLayout = (ShadowFrameLayout) bindings[5];
        this.f12215b = shadowFrameLayout;
        shadowFrameLayout.setTag(null);
        TextView textView2 = (TextView) bindings[6];
        this.b = textView2;
        textView2.setTag(null);
        ((RunLayoutSunRunPaceInfoBinding) this).f35715a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
