package com.huachenjie.login.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.login.page.school_certification.SchoolCertificationAdapter;
import com.huachenjie.login.page.school_certification.SchoolCertificationVM;
import com.zj.adlib.zk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class LoginActivitySchoolCertificationBindingImpl extends LoginActivitySchoolCertificationBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34665a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10032a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10033a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10034a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f10035a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(3);
        f10032a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{2}, new int[]{R.layout.layout_toolbar_binding});
        f34665a = null;
    }

    public LoginActivitySchoolCertificationBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f10032a, f34665a));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0031  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        BindingTitleBean value;
        synchronized (this) {
            j = this.f10033a;
            this.f10033a = 0L;
        }
        SchoolCertificationVM schoolCertificationVM = ((LoginActivitySchoolCertificationBinding) this).f10031a;
        SchoolCertificationAdapter value2 = null;
        if ((29 & j) != 0) {
            if ((j & 25) == 0) {
                value = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = schoolCertificationVM != null ? schoolCertificationVM.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value = mutableLiveDataI.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 28) != 0) {
                MutableLiveData<SchoolCertificationAdapter> mutableLiveDataJ = schoolCertificationVM != null ? schoolCertificationVM.j() : null;
                updateLiveDataRegistration(2, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value2 = mutableLiveDataJ.getValue();
                }
            }
        } else {
            value = null;
        }
        if ((28 & j) != 0) {
            CommonBindingAdapter.g(this.f10035a, value2, false, false);
        }
        if ((j & 25) != 0) {
            ((LoginActivitySchoolCertificationBinding) this).f34664a.k(value);
        }
        ViewDataBinding.executeBindingsOn(((LoginActivitySchoolCertificationBinding) this).f34664a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10033a != 0) {
                return true;
            }
            return ((LoginActivitySchoolCertificationBinding) this).f34664a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10033a = 16L;
        }
        ((LoginActivitySchoolCertificationBinding) this).f34664a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.login.databinding.LoginActivitySchoolCertificationBinding
    public void k(@Nullable SchoolCertificationVM schoolCertificationVM) {
        ((LoginActivitySchoolCertificationBinding) this).f10031a = schoolCertificationVM;
        synchronized (this) {
            this.f10033a |= 8;
        }
        notifyPropertyChanged(zk0.p0);
        super.requestRebind();
    }

    public final boolean l(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f10033a |= 2;
        }
        return true;
    }

    public final boolean m(MutableLiveData<SchoolCertificationAdapter> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f10033a |= 4;
        }
        return true;
    }

    public final boolean n(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f10033a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return l((LayoutToolbarBindingBinding) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return m((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((LoginActivitySchoolCertificationBinding) this).f34664a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (zk0.p0 != i) {
            return false;
        }
        k((SchoolCertificationVM) obj);
        return true;
    }

    public LoginActivitySchoolCertificationBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (LayoutToolbarBindingBinding) objArr[2]);
        this.f10033a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f10034a = linearLayout;
        linearLayout.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[1];
        this.f10035a = recyclerView;
        recyclerView.setTag(null);
        setContainedBinding(((LoginActivitySchoolCertificationBinding) this).f34664a);
        setRootTag(view);
        invalidateAll();
    }
}
