package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import com.flyco.tablayout.SlideTabLayout;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.works.R;
import com.huachenjie.works.page.alumni.AlumniVM;
import com.noober.background.view.BLView;
import com.zj.adlib.jj8;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksFragmentAlumniBindingImpl extends WorksFragmentAlumniBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36893a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14154a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14155a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14156a;

    @NonNull
    public final FrameLayout b;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36893a = sparseIntArray;
        sparseIntArray.put(R.id.fragment_sub_container, 3);
        sparseIntArray.put(R.id.header_tab_layout, 4);
    }

    public WorksFragmentAlumniBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 5, f14154a, f36893a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int i;
        int iSafeUnbox;
        synchronized (this) {
            j = this.f14155a;
            this.f14155a = 0L;
        }
        AlumniVM alumniVM = ((WorksFragmentAlumniBinding) this).f14152a;
        int iSafeUnbox2 = 0;
        if ((15 & j) != 0) {
            BaseViewModel.b bVarE = alumniVM != null ? alumniVM.e() : null;
            if ((j & 13) != 0) {
                MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                updateLiveDataRegistration(0, mutableLiveDataB);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null);
            } else {
                iSafeUnbox = 0;
            }
            if ((j & 14) != 0) {
                MutableLiveData<Integer> mutableLiveDataC = bVarE != null ? bVarE.c() : null;
                updateLiveDataRegistration(1, mutableLiveDataC);
                iSafeUnbox2 = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(mutableLiveDataC != null ? mutableLiveDataC.getValue() : null) + jj8.a(44.0f)));
            }
            i = iSafeUnbox;
        } else {
            i = 0;
        }
        if ((13 & j) != 0) {
            CommonBindingAdapter.I(this.f14156a, 0, i, 0, 0, null);
        }
        if ((j & 14) != 0) {
            CommonBindingAdapter.G(((WorksFragmentAlumniBinding) this).f14153a, iSafeUnbox2);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14155a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14155a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksFragmentAlumniBinding
    public void k(@Nullable AlumniVM Vm) {
        ((WorksFragmentAlumniBinding) this).f14152a = Vm;
        synchronized (this) {
            this.f14155a |= 4;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<Integer> VmUiLiveDataStatusBarHeight, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14155a |= 1;
        }
        return true;
    }

    public final boolean m(MutableLiveData<Integer> VmUiLiveDataStatusBarHeightPx, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14155a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return l((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 1) {
            return false;
        }
        return m((MutableLiveData) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 != variableId) {
            return false;
        }
        k((AlumniVM) variable);
        return true;
    }

    public WorksFragmentAlumniBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (FrameLayout) bindings[3], (SlideTabLayout) bindings[4], (BLView) bindings[1]);
        this.f14155a = -1L;
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.b = frameLayout;
        frameLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[2];
        this.f14156a = linearLayout;
        linearLayout.setTag(null);
        ((WorksFragmentAlumniBinding) this).f14153a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
