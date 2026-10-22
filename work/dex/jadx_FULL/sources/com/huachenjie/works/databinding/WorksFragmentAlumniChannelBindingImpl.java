package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.works.external.adapter.WorksAdapter;
import com.huachenjie.works.page.alumni.channel.AlumniChannelVM;
import com.noober.background.view.BLView;
import com.zj.adlib.jj8;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksFragmentAlumniChannelBindingImpl extends WorksFragmentAlumniChannelBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36895a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14162a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14163a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f14164a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnRefreshListenerImpl f14165a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f14166a;

    public static class OnRefreshListenerImpl implements SwipeRefreshLayout.OnRefreshListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SwipeRefreshLayout.OnRefreshListener f36896a;

        public OnRefreshListenerImpl a(SwipeRefreshLayout.OnRefreshListener value) {
            this.f36896a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            this.f36896a.onRefresh();
        }
    }

    public WorksFragmentAlumniChannelBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 7, f14162a, f36895a));
    }

    /* JADX WARN: Code duplicated, block: B:61:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:69:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:71:0x0102  */
    /* JADX WARN: Code duplicated, block: B:74:0x010e  */
    /* JADX WARN: Code duplicated, block: B:77:0x011a  */
    /* JADX WARN: Code duplicated, block: B:84:? A[RETURN, SYNTHETIC] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int iSafeUnbox;
        int iSafeUnbox2;
        boolean zSafeUnbox;
        WorksAdapter value;
        long j2;
        OnRefreshListenerImpl onRefreshListenerImplA;
        synchronized (this) {
            j = this.f14163a;
            this.f14163a = 0L;
        }
        AlumniChannelVM alumniChannelVM = ((WorksFragmentAlumniChannelBinding) this).f14161a;
        SwipeRefreshLayout.OnRefreshListener onRefreshListener = ((WorksFragmentAlumniChannelBinding) this).f14159a;
        if ((95 & j) != 0) {
            if ((j & 82) != 0) {
                BaseViewModel.b bVarE = alumniChannelVM != null ? alumniChannelVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataC = bVarE != null ? bVarE.c() : null;
                updateLiveDataRegistration(1, mutableLiveDataC);
                iSafeUnbox = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(mutableLiveDataC != null ? mutableLiveDataC.getValue() : null) + jj8.a(44.0f)));
            } else {
                iSafeUnbox = 0;
            }
            if ((j & 81) != 0) {
                MutableLiveData<Integer> mutableLiveDataR = alumniChannelVM != null ? alumniChannelVM.r() : null;
                updateLiveDataRegistration(0, mutableLiveDataR);
                iSafeUnbox2 = ViewDataBinding.safeUnbox(mutableLiveDataR != null ? mutableLiveDataR.getValue() : null);
            } else {
                iSafeUnbox2 = 0;
            }
            if ((j & 84) != 0) {
                MutableLiveData<Boolean> mutableLiveDataS = alumniChannelVM != null ? alumniChannelVM.s() : null;
                updateLiveDataRegistration(2, mutableLiveDataS);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataS != null ? mutableLiveDataS.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 88) != 0) {
                MutableLiveData<WorksAdapter> mutableLiveDataN = alumniChannelVM != null ? alumniChannelVM.n() : null;
                updateLiveDataRegistration(3, mutableLiveDataN);
                value = mutableLiveDataN != null ? mutableLiveDataN.getValue() : null;
            }
            j2 = j & 96;
            if (j2 != 0 || onRefreshListener == null) {
                onRefreshListenerImplA = null;
            } else {
                OnRefreshListenerImpl onRefreshListenerImpl = this.f14165a;
                if (onRefreshListenerImpl == null) {
                    onRefreshListenerImpl = new OnRefreshListenerImpl();
                    this.f14165a = onRefreshListenerImpl;
                }
                onRefreshListenerImplA = onRefreshListenerImpl.a(onRefreshListener);
            }
            if ((j & 81) != 0 && ViewDataBinding.getBuildSdkInt() >= 11) {
                float f = iSafeUnbox2;
                ((WorksFragmentAlumniChannelBinding) this).f14157a.setTranslationY(f);
                this.f14166a.setTranslationY(f);
                ((WorksFragmentAlumniChannelBinding) this).f36894a.setTranslationY(f);
            }
            if ((88 & j) != 0) {
                CommonBindingAdapter.g(((WorksFragmentAlumniChannelBinding) this).f14158a, value, false, false);
            }
            if (j2 != 0) {
                ((WorksFragmentAlumniChannelBinding) this).f14160a.setOnRefreshListener(onRefreshListenerImplA);
            }
            if ((84 & j) != 0) {
                ((WorksFragmentAlumniChannelBinding) this).f14160a.setRefreshing(zSafeUnbox);
            }
            if ((j & 82) != 0) {
                CommonBindingAdapter.G(this.b, iSafeUnbox);
            }
        }
        iSafeUnbox = 0;
        iSafeUnbox2 = 0;
        zSafeUnbox = false;
        j2 = j & 96;
        if (j2 != 0) {
            onRefreshListenerImplA = null;
        } else {
            onRefreshListenerImplA = null;
        }
        if ((j & 81) != 0) {
            float f2 = iSafeUnbox2;
            ((WorksFragmentAlumniChannelBinding) this).f14157a.setTranslationY(f2);
            this.f14166a.setTranslationY(f2);
            ((WorksFragmentAlumniChannelBinding) this).f36894a.setTranslationY(f2);
        }
        if ((88 & j) != 0) {
            CommonBindingAdapter.g(((WorksFragmentAlumniChannelBinding) this).f14158a, value, false, false);
        }
        if (j2 != 0) {
            ((WorksFragmentAlumniChannelBinding) this).f14160a.setOnRefreshListener(onRefreshListenerImplA);
        }
        if ((84 & j) != 0) {
            ((WorksFragmentAlumniChannelBinding) this).f14160a.setRefreshing(zSafeUnbox);
        }
        if ((j & 82) != 0) {
            CommonBindingAdapter.G(this.b, iSafeUnbox);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14163a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14163a = 64L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksFragmentAlumniChannelBinding
    public void l(@Nullable AlumniChannelVM Vm) {
        ((WorksFragmentAlumniChannelBinding) this).f14161a = Vm;
        synchronized (this) {
            this.f14163a |= 16;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean m(MutableLiveData<WorksAdapter> VmAdapter, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14163a |= 8;
        }
        return true;
    }

    public final boolean n(MutableLiveData<Boolean> VmIsRefreshing, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14163a |= 4;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> VmUiLiveDataStatusBarHeightPx, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14163a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return p((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 1) {
            return o((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 2) {
            return n((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 3) {
            return false;
        }
        return m((MutableLiveData) object, fieldId);
    }

    public final boolean p(MutableLiveData<Integer> VmVerticalOffset, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14163a |= 1;
        }
        return true;
    }

    @Override // com.huachenjie.works.databinding.WorksFragmentAlumniChannelBinding
    public void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener Refresh) {
        ((WorksFragmentAlumniChannelBinding) this).f14159a = Refresh;
        synchronized (this) {
            this.f14163a |= 32;
        }
        notifyPropertyChanged(qk0.R);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 == variableId) {
            l((AlumniChannelVM) variable);
        } else {
            if (qk0.R != variableId) {
                return false;
            }
            setRefresh((SwipeRefreshLayout.OnRefreshListener) variable);
        }
        return true;
    }

    public WorksFragmentAlumniChannelBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 4, (ImageView) bindings[1], (RecyclerView) bindings[6], (SwipeRefreshLayout) bindings[5], (View) bindings[2], (View) bindings[4]);
        this.f14163a = -1L;
        ((WorksFragmentAlumniChannelBinding) this).f14157a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.f14164a = constraintLayout;
        constraintLayout.setTag(null);
        BLView bLView = (BLView) bindings[3];
        this.f14166a = bLView;
        bLView.setTag(null);
        ((WorksFragmentAlumniChannelBinding) this).f14158a.setTag(null);
        ((WorksFragmentAlumniChannelBinding) this).f14160a.setTag(null);
        ((WorksFragmentAlumniChannelBinding) this).f36894a.setTag(null);
        this.b.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
