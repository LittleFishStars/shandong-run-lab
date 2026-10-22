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
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.bean.SchoolInfo;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.binding_adapter.DrawablesBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.widget.ClearFocusConstraintLayout;
import com.huachenjie.compat.page.login.AuthorizeActivity;
import com.huachenjie.compat.page.login.vm.AuthorizeVM;
import com.zj.adlib.wk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class ActivityAuthorizeBindingImpl extends ActivityAuthorizeBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33997a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9014a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9015a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f9016a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f9017a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f9018a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ClearFocusConstraintLayout f9019a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f9020a;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(((ActivityAuthorizeBinding) ActivityAuthorizeBindingImpl.this).f33996a);
            AuthorizeVM authorizeVM = ((ActivityAuthorizeBinding) ActivityAuthorizeBindingImpl.this).f9013a;
            if (authorizeVM != null) {
                MutableLiveData<String> mutableLiveData = authorizeVM.k;
                if (mutableLiveData != null) {
                    mutableLiveData.setValue(textString);
                }
            }
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AuthorizeActivity.a f33999a;

        public b a(AuthorizeActivity.a aVar) {
            this.f33999a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33999a.a(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(9);
        f9014a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{4}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33997a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.compat.R.id.iv_tip, 5);
        sparseIntArray.put(com.huachenjie.compat.R.id.tv_tip, 6);
        sparseIntArray.put(com.huachenjie.compat.R.id.tv_school, 7);
        sparseIntArray.put(com.huachenjie.compat.R.id.tv_study_id, 8);
    }

    public ActivityAuthorizeBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, f9014a, f33997a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0035  */
    /* JADX WARN: Code duplicated, block: B:25:0x004f  */
    /* JADX WARN: Code duplicated, block: B:37:0x0071  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String schoolName;
        String value;
        BindingTitleBean value2;
        b bVarA;
        synchronized (this) {
            j = this.f9015a;
            this.f9015a = 0L;
        }
        AuthorizeVM authorizeVM = ((ActivityAuthorizeBinding) this).f9013a;
        AuthorizeActivity.a aVar = ((ActivityAuthorizeBinding) this).f9012a;
        if ((47 & j) != 0) {
            if ((j & 41) == 0) {
                value = null;
            } else {
                MutableLiveData<String> mutableLiveData = authorizeVM != null ? authorizeVM.k : null;
                updateLiveDataRegistration(0, mutableLiveData);
                if (mutableLiveData != null) {
                    value = mutableLiveData.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 42) == 0) {
                value2 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveData2 = authorizeVM != null ? authorizeVM.i : null;
                updateLiveDataRegistration(1, mutableLiveData2);
                if (mutableLiveData2 != null) {
                    value2 = mutableLiveData2.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 44) == 0) {
                schoolName = null;
            } else {
                MutableLiveData<SchoolInfo> mutableLiveData3 = authorizeVM != null ? authorizeVM.j : null;
                updateLiveDataRegistration(2, mutableLiveData3);
                SchoolInfo value3 = mutableLiveData3 != null ? mutableLiveData3.getValue() : null;
                if (value3 != null) {
                    schoolName = value3.getSchoolName();
                } else {
                    schoolName = null;
                }
            }
        } else {
            schoolName = null;
            value = null;
            value2 = null;
        }
        long j2 = j & 48;
        if (j2 == 0 || aVar == null) {
            bVarA = null;
        } else {
            b bVar = this.f9020a;
            if (bVar == null) {
                bVar = new b();
                this.f9020a = bVar;
            }
            bVarA = bVar.a(aVar);
        }
        if ((42 & j) != 0) {
            this.f9018a.k(value2);
        }
        if ((32 & j) != 0) {
            ClearFocusConstraintLayout clearFocusConstraintLayout = this.f9019a;
            DrawablesBindingAdapter.h(clearFocusConstraintLayout, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(clearFocusConstraintLayout, com.huachenjie.compat.R.color.white)), 0, 0.0f, 0.0f, 0.0f, 26.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            TextViewBindingAdapter.setTextWatcher(((ActivityAuthorizeBinding) this).f33996a, null, null, null, this.f9017a);
        }
        if ((44 & j) != 0) {
            TextViewBindingAdapter.setText(this.b, schoolName);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.b, bVarA, null);
        }
        if ((j & 41) != 0) {
            TextViewBindingAdapter.setText(((ActivityAuthorizeBinding) this).f33996a, value);
        }
        ViewDataBinding.executeBindingsOn(this.f9018a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9015a != 0) {
                return true;
            }
            return this.f9018a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9015a = 32L;
        }
        this.f9018a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.compat.databinding.ActivityAuthorizeBinding
    public void l(@Nullable AuthorizeActivity.a aVar) {
        ((ActivityAuthorizeBinding) this).f9012a = aVar;
        synchronized (this) {
            this.f9015a |= 16;
        }
        notifyPropertyChanged(wk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.compat.databinding.ActivityAuthorizeBinding
    public void m(@Nullable AuthorizeVM authorizeVM) {
        ((ActivityAuthorizeBinding) this).f9013a = authorizeVM;
        synchronized (this) {
            this.f9015a |= 8;
        }
        notifyPropertyChanged(wk0.L);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<SchoolInfo> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9015a |= 4;
        }
        return true;
    }

    public final boolean o(MutableLiveData<String> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9015a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return o((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return p((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9015a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f9018a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (wk0.L == i) {
            m((AuthorizeVM) obj);
        } else {
            if (wk0.k != i) {
                return false;
            }
            l((AuthorizeActivity.a) obj);
        }
        return true;
    }

    public ActivityAuthorizeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (ImageView) objArr[5], (TextView) objArr[7], (TextView) objArr[2], (TextView) objArr[8], (EditText) objArr[3], (TextView) objArr[6]);
        this.f9017a = new a();
        this.f9015a = -1L;
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[4];
        this.f9018a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f9016a = constraintLayout;
        constraintLayout.setTag(null);
        ClearFocusConstraintLayout clearFocusConstraintLayout = (ClearFocusConstraintLayout) objArr[1];
        this.f9019a = clearFocusConstraintLayout;
        clearFocusConstraintLayout.setTag(null);
        this.b.setTag(null);
        ((ActivityAuthorizeBinding) this).f33996a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
