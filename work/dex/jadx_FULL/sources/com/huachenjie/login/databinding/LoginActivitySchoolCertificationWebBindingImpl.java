package com.huachenjie.login.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.login.page.school_certification.SchoolCertificationWebWM;
import com.zj.adlib.zk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class LoginActivitySchoolCertificationWebBindingImpl extends LoginActivitySchoolCertificationWebBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34667a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10038a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10039a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10040a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(3);
        f10038a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{1}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34667a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.login.R.id.web_view, 2);
    }

    public LoginActivitySchoolCertificationWebBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f10038a, f34667a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f10039a;
            this.f10039a = 0L;
        }
        SchoolCertificationWebWM schoolCertificationWebWM = ((LoginActivitySchoolCertificationWebBinding) this).f10037a;
        long j2 = j & 13;
        BindingTitleBean value = null;
        if (j2 != 0) {
            MutableLiveData<BindingTitleBean> mutableLiveDataI = schoolCertificationWebWM != null ? schoolCertificationWebWM.i() : null;
            updateLiveDataRegistration(0, mutableLiveDataI);
            if (mutableLiveDataI != null) {
                value = mutableLiveDataI.getValue();
            }
        }
        if (j2 != 0) {
            ((LoginActivitySchoolCertificationWebBinding) this).f10036a.k(value);
        }
        ViewDataBinding.executeBindingsOn(((LoginActivitySchoolCertificationWebBinding) this).f10036a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10039a != 0) {
                return true;
            }
            return ((LoginActivitySchoolCertificationWebBinding) this).f10036a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10039a = 8L;
        }
        ((LoginActivitySchoolCertificationWebBinding) this).f10036a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.login.databinding.LoginActivitySchoolCertificationWebBinding
    public void k(@Nullable SchoolCertificationWebWM schoolCertificationWebWM) {
        ((LoginActivitySchoolCertificationWebBinding) this).f10037a = schoolCertificationWebWM;
        synchronized (this) {
            this.f10039a |= 4;
        }
        notifyPropertyChanged(zk0.p0);
        super.requestRebind();
    }

    public final boolean l(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f10039a |= 2;
        }
        return true;
    }

    public final boolean m(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != zk0.f46280a) {
            return false;
        }
        synchronized (this) {
            this.f10039a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return m((MutableLiveData) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return l((LayoutToolbarBindingBinding) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((LoginActivitySchoolCertificationWebBinding) this).f10036a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (zk0.p0 != i) {
            return false;
        }
        k((SchoolCertificationWebWM) obj);
        return true;
    }

    public LoginActivitySchoolCertificationWebBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (LayoutToolbarBindingBinding) objArr[1], (WebView) objArr[2]);
        this.f10039a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f10040a = linearLayout;
        linearLayout.setTag(null);
        setContainedBinding(((LoginActivitySchoolCertificationWebBinding) this).f10036a);
        setRootTag(view);
        invalidateAll();
    }
}
