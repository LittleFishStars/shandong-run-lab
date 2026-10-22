package com.huachenjie.compat.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MediatorLiveData;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.compat.page.personal.ChangeNickNameActivity;
import com.huachenjie.compat.page.personal.ChangeNickNameVM;
import com.zj.adlib.wk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class ActivityChangeNickNameBindingImpl extends ActivityChangeNickNameBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34025a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9087a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9088a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f9089a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f9090a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f9091a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f9092a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f9093a;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((ActivityChangeNickNameBinding) ActivityChangeNickNameBindingImpl.this).f34024a);
            ChangeNickNameVM changeNickNameVM = ((ActivityChangeNickNameBinding) ActivityChangeNickNameBindingImpl.this).f9086a;
            if (changeNickNameVM != null) {
                MutableLiveData<String> mutableLiveData = changeNickNameVM.j;
                if (mutableLiveData != null) {
                    mutableLiveData.setValue(textString);
                }
            }
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ChangeNickNameActivity.b f34027a;

        public b a(ChangeNickNameActivity.b bVar) {
            this.f34027a = bVar;
            if (bVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34027a.a(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(5);
        f9087a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{4}, new int[]{R.layout.layout_toolbar_binding});
        f34025a = null;
    }

    public ActivityChangeNickNameBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f9087a, f34025a));
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0067  */
    /* JADX WARN: Code duplicated, block: B:45:0x0083  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        BindingTitleBean value;
        String value2;
        String value3;
        b bVarA;
        synchronized (this) {
            j = this.f9088a;
            this.f9088a = 0L;
        }
        ChangeNickNameVM changeNickNameVM = ((ActivityChangeNickNameBinding) this).f9086a;
        ChangeNickNameActivity.b bVar = ((ActivityChangeNickNameBinding) this).f9085a;
        int i = 0;
        if ((47 & j) != 0) {
            int i2 = ((j & 40) == 0 || changeNickNameVM == null) ? 0 : changeNickNameVM.K;
            if ((j & 41) != 0) {
                MutableLiveData<String> mutableLiveData = changeNickNameVM != null ? changeNickNameVM.j : null;
                updateLiveDataRegistration(0, mutableLiveData);
                value3 = mutableLiveData != null ? mutableLiveData.getValue() : null;
                if ((value3 != null ? value3.length() : 0) > 0) {
                    i = 1;
                }
            } else {
                value3 = null;
            }
            if ((j & 42) == 0) {
                value2 = null;
            } else {
                MediatorLiveData<String> mediatorLiveData = changeNickNameVM != null ? changeNickNameVM.f34130a : null;
                updateLiveDataRegistration(1, mediatorLiveData);
                if (mediatorLiveData != null) {
                    value2 = mediatorLiveData.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 44) == 0) {
                value = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveData2 = changeNickNameVM != null ? changeNickNameVM.i : null;
                updateLiveDataRegistration(2, mutableLiveData2);
                if (mutableLiveData2 != null) {
                    value = mutableLiveData2.getValue();
                } else {
                    value = null;
                }
            }
            int i3 = i;
            i = i2;
            z = i3;
        } else {
            z = 0;
            value = null;
            value2 = null;
            value3 = null;
        }
        long j2 = j & 48;
        if (j2 == 0 || bVar == null) {
            bVarA = null;
        } else {
            b bVar2 = this.f9093a;
            if (bVar2 == null) {
                bVar2 = new b();
                this.f9093a = bVar2;
            }
            bVarA = bVar2.a(bVar);
        }
        if ((j & 40) != 0) {
            TextViewBindingAdapter.setMaxLength(((ActivityChangeNickNameBinding) this).f34024a, i);
        }
        if ((41 & j) != 0) {
            TextViewBindingAdapter.setText(((ActivityChangeNickNameBinding) this).f34024a, value3);
            CommonBindingAdapter.l0(this.f9089a, z);
        }
        if ((32 & j) != 0) {
            TextViewBindingAdapter.setTextWatcher(((ActivityChangeNickNameBinding) this).f34024a, null, null, null, this.f9091a);
        }
        if ((44 & j) != 0) {
            this.f9092a.k(value);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f9089a, bVarA, null);
        }
        if ((j & 42) != 0) {
            TextViewBindingAdapter.setText(((ActivityChangeNickNameBinding) this).f9084a, value2);
        }
        ViewDataBinding.executeBindingsOn(this.f9092a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9088a != 0) {
                return true;
            }
            return this.f9092a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9088a = 32L;
        }
        this.f9092a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.compat.databinding.ActivityChangeNickNameBinding
    public void l(@Nullable ChangeNickNameActivity.b bVar) {
        ((ActivityChangeNickNameBinding) this).f9085a = bVar;
        synchronized (this) {
            this.f9088a |= 16;
        }
        notifyPropertyChanged(wk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.compat.databinding.ActivityChangeNickNameBinding
    public void m(@Nullable ChangeNickNameVM changeNickNameVM) {
        ((ActivityChangeNickNameBinding) this).f9086a = changeNickNameVM;
        synchronized (this) {
            this.f9088a |= 8;
        }
        notifyPropertyChanged(wk0.L);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<String> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9088a |= 1;
        }
        return true;
    }

    public final boolean o(MediatorLiveData<String> mediatorLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9088a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return o((MediatorLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return p((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9088a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f9092a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (wk0.L == i) {
            m((ChangeNickNameVM) obj);
        } else {
            if (wk0.k != i) {
                return false;
            }
            l((ChangeNickNameActivity.b) obj);
        }
        return true;
    }

    public ActivityChangeNickNameBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (EditText) objArr[1], (TextView) objArr[3]);
        this.f9091a = new a();
        this.f9088a = -1L;
        ((ActivityChangeNickNameBinding) this).f34024a.setTag(null);
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[4];
        this.f9092a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f9090a = constraintLayout;
        constraintLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.f9089a = imageView;
        imageView.setTag(null);
        ((ActivityChangeNickNameBinding) this).f9084a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
