package com.huachenjie.compat.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
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
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.compat.page.personal.ModifyAddressActivity;
import com.huachenjie.compat.page.personal.ModifyAddressVM;
import com.noober.background.view.BLButton;
import com.zj.adlib.wk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class ActivityModifyAddressBindingImpl extends ActivityModifyAddressBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34035a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9113a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9114a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9115a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f9116a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f9117a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f9118a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f9119a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLButton f9120a;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((ActivityModifyAddressBinding) ActivityModifyAddressBindingImpl.this).f9106a);
            ModifyAddressVM modifyAddressVM = ((ActivityModifyAddressBinding) ActivityModifyAddressBindingImpl.this).f9110a;
            if (modifyAddressVM != null) {
                MutableLiveData<String> mutableLiveDataI = modifyAddressVM.i();
                if (mutableLiveDataI != null) {
                    mutableLiveDataI.setValue(textString);
                }
            }
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ModifyAddressActivity.a f34037a;

        public b a(ModifyAddressActivity.a aVar) {
            this.f34037a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34037a.b(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ModifyAddressActivity.a f34038a;

        public c a(ModifyAddressActivity.a aVar) {
            this.f34038a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34038a.a(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(11);
        f9113a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{5}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34035a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.compat.R.id.tv_location_name, 6);
        sparseIntArray.put(com.huachenjie.compat.R.id.iv_location_name, 7);
        sparseIntArray.put(com.huachenjie.compat.R.id.v_line_first, 8);
        sparseIntArray.put(com.huachenjie.compat.R.id.tv_address_detail, 9);
        sparseIntArray.put(com.huachenjie.compat.R.id.v_line_end, 10);
    }

    public ActivityModifyAddressBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, f9113a, f34035a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0037  */
    /* JADX WARN: Code duplicated, block: B:25:0x0053  */
    /* JADX WARN: Code duplicated, block: B:34:0x006f  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String value;
        BindingTitleBean value2;
        String value3;
        b bVarA;
        c cVarA;
        synchronized (this) {
            j = this.f9114a;
            this.f9114a = 0L;
        }
        ModifyAddressVM modifyAddressVM = ((ActivityModifyAddressBinding) this).f9110a;
        ModifyAddressActivity.a aVar = ((ActivityModifyAddressBinding) this).f9109a;
        if ((47 & j) != 0) {
            if ((j & 41) == 0) {
                value2 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataL = modifyAddressVM != null ? modifyAddressVM.l() : null;
                updateLiveDataRegistration(0, mutableLiveDataL);
                if (mutableLiveDataL != null) {
                    value2 = mutableLiveDataL.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 42) == 0) {
                value3 = null;
            } else {
                MutableLiveData<String> mutableLiveDataI = modifyAddressVM != null ? modifyAddressVM.i() : null;
                updateLiveDataRegistration(1, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value3 = mutableLiveDataI.getValue();
                } else {
                    value3 = null;
                }
            }
            if ((j & 44) == 0) {
                value = null;
            } else {
                MutableLiveData<String> mutableLiveDataJ = modifyAddressVM != null ? modifyAddressVM.j() : null;
                updateLiveDataRegistration(2, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value = mutableLiveDataJ.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            value = null;
            value2 = null;
            value3 = null;
        }
        long j2 = j & 48;
        if (j2 == 0 || aVar == null) {
            bVarA = null;
            cVarA = null;
        } else {
            c cVar = this.f9119a;
            if (cVar == null) {
                cVar = new c();
                this.f9119a = cVar;
            }
            cVarA = cVar.a(aVar);
            b bVar = this.f9118a;
            if (bVar == null) {
                bVar = new b();
                this.f9118a = bVar;
            }
            bVarA = bVar.a(aVar);
        }
        if ((j & 42) != 0) {
            TextViewBindingAdapter.setText(((ActivityModifyAddressBinding) this).f9106a, value3);
        }
        if ((32 & j) != 0) {
            TextViewBindingAdapter.setTextWatcher(((ActivityModifyAddressBinding) this).f9106a, null, null, null, this.f9116a);
        }
        if ((41 & j) != 0) {
            this.f9117a.k(value2);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f9120a, cVarA, null);
            CommonBindingAdapter.q(((ActivityModifyAddressBinding) this).c, bVarA, null);
        }
        if ((j & 44) != 0) {
            TextViewBindingAdapter.setText(((ActivityModifyAddressBinding) this).f9111b, value);
        }
        ViewDataBinding.executeBindingsOn(this.f9117a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9114a != 0) {
                return true;
            }
            return this.f9117a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9114a = 32L;
        }
        this.f9117a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.compat.databinding.ActivityModifyAddressBinding
    public void l(@Nullable ModifyAddressActivity.a aVar) {
        ((ActivityModifyAddressBinding) this).f9109a = aVar;
        synchronized (this) {
            this.f9114a |= 16;
        }
        notifyPropertyChanged(wk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.compat.databinding.ActivityModifyAddressBinding
    public void m(@Nullable ModifyAddressVM modifyAddressVM) {
        ((ActivityModifyAddressBinding) this).f9110a = modifyAddressVM;
        synchronized (this) {
            this.f9114a |= 8;
        }
        notifyPropertyChanged(wk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<String> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9114a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<String> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9114a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return n((MutableLiveData) obj, i2);
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
            this.f9114a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f9117a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (wk0.p0 == i) {
            m((ModifyAddressVM) obj);
        } else {
            if (wk0.k != i) {
                return false;
            }
            l((ModifyAddressActivity.a) obj);
        }
        return true;
    }

    public ActivityModifyAddressBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (EditText) objArr[3], (ImageView) objArr[7], (TextView) objArr[9], (TextView) objArr[1], (TextView) objArr[6], (View) objArr[10], (View) objArr[8], (View) objArr[2]);
        this.f9116a = new a();
        this.f9114a = -1L;
        ((ActivityModifyAddressBinding) this).f9106a.setTag(null);
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[5];
        this.f9117a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f9115a = linearLayout;
        linearLayout.setTag(null);
        BLButton bLButton = (BLButton) objArr[4];
        this.f9120a = bLButton;
        bLButton.setTag(null);
        ((ActivityModifyAddressBinding) this).f9111b.setTag(null);
        ((ActivityModifyAddressBinding) this).c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
