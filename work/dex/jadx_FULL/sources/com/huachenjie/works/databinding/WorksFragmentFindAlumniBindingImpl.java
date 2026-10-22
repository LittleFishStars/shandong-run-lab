package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.works.R;
import com.huachenjie.works.page.alumni.find_alumni.FindAlumniAdapter;
import com.huachenjie.works.page.alumni.find_alumni.FindAlumniVM;
import com.huachenjie.works.widget.FindAlumniPicker;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksFragmentFindAlumniBindingImpl extends WorksFragmentFindAlumniBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36906a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14191a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14192a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final View f14193a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14194a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f14195a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnRefreshListenerImpl f14196a;

    public static class OnRefreshListenerImpl implements SwipeRefreshLayout.OnRefreshListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SwipeRefreshLayout.OnRefreshListener f36907a;

        public OnRefreshListenerImpl a(SwipeRefreshLayout.OnRefreshListener value) {
            this.f36907a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            this.f36907a.onRefresh();
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36906a = sparseIntArray;
        sparseIntArray.put(R.id.fap_sex, 4);
        sparseIntArray.put(R.id.fap_grade, 5);
        sparseIntArray.put(R.id.fap_tag, 6);
    }

    public WorksFragmentFindAlumniBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 7, f14191a, f36906a));
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:54:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:57:0x00be  */
    /* JADX WARN: Code duplicated, block: B:59:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:62:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:69:? A[RETURN, SYNTHETIC] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zSafeUnbox;
        int i;
        FindAlumniAdapter value;
        long j2;
        OnRefreshListenerImpl onRefreshListenerImplA;
        int iSafeUnbox;
        synchronized (this) {
            j = this.f14192a;
            this.f14192a = 0L;
        }
        FindAlumniVM findAlumniVM = ((WorksFragmentFindAlumniBinding) this).f14189a;
        SwipeRefreshLayout.OnRefreshListener onRefreshListener = ((WorksFragmentFindAlumniBinding) this).f36905a;
        if ((47 & j) != 0) {
            if ((j & 42) != 0) {
                MutableLiveData<Boolean> mutableLiveDataS = findAlumniVM != null ? findAlumniVM.s() : null;
                updateLiveDataRegistration(1, mutableLiveDataS);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataS != null ? mutableLiveDataS.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 41) != 0) {
                BaseViewModel.b bVarE = findAlumniVM != null ? findAlumniVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                updateLiveDataRegistration(0, mutableLiveDataB);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null);
            } else {
                iSafeUnbox = 0;
            }
            if ((j & 44) != 0) {
                MutableLiveData<FindAlumniAdapter> mutableLiveDataQ = findAlumniVM != null ? findAlumniVM.q() : null;
                updateLiveDataRegistration(2, mutableLiveDataQ);
                if (mutableLiveDataQ != null) {
                    value = mutableLiveDataQ.getValue();
                    i = iSafeUnbox;
                }
                j2 = 48 & j;
                if (j2 != 0 || onRefreshListener == null) {
                    onRefreshListenerImplA = null;
                } else {
                    OnRefreshListenerImpl onRefreshListenerImpl = this.f14196a;
                    if (onRefreshListenerImpl == null) {
                        onRefreshListenerImpl = new OnRefreshListenerImpl();
                        this.f14196a = onRefreshListenerImpl;
                    }
                    onRefreshListenerImplA = onRefreshListenerImpl.a(onRefreshListener);
                }
                if ((41 & j) != 0) {
                    CommonBindingAdapter.I(this.f14193a, 0, i, 0, 0, null);
                }
                if ((44 & j) != 0) {
                    CommonBindingAdapter.g(this.f14195a, value, false, false);
                }
                if (j2 != 0) {
                    ((WorksFragmentFindAlumniBinding) this).f14188a.setOnRefreshListener(onRefreshListenerImplA);
                }
                if ((j & 42) != 0) {
                    ((WorksFragmentFindAlumniBinding) this).f14188a.setRefreshing(zSafeUnbox);
                }
            }
            i = iSafeUnbox;
        } else {
            zSafeUnbox = false;
            i = 0;
        }
        value = null;
        j2 = 48 & j;
        if (j2 != 0) {
            onRefreshListenerImplA = null;
        } else {
            onRefreshListenerImplA = null;
        }
        if ((41 & j) != 0) {
            CommonBindingAdapter.I(this.f14193a, 0, i, 0, 0, null);
        }
        if ((44 & j) != 0) {
            CommonBindingAdapter.g(this.f14195a, value, false, false);
        }
        if (j2 != 0) {
            ((WorksFragmentFindAlumniBinding) this).f14188a.setOnRefreshListener(onRefreshListenerImplA);
        }
        if ((j & 42) != 0) {
            ((WorksFragmentFindAlumniBinding) this).f14188a.setRefreshing(zSafeUnbox);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14192a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14192a = 32L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksFragmentFindAlumniBinding
    public void l(@Nullable FindAlumniVM Vm) {
        ((WorksFragmentFindAlumniBinding) this).f14189a = Vm;
        synchronized (this) {
            this.f14192a |= 8;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean m(MutableLiveData<FindAlumniAdapter> VmAdapter, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14192a |= 4;
        }
        return true;
    }

    public final boolean n(MutableLiveData<Boolean> VmIsRefreshing, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14192a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> VmUiLiveDataStatusBarHeight, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f14192a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return o((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 1) {
            return n((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 2) {
            return false;
        }
        return m((MutableLiveData) object, fieldId);
    }

    @Override // com.huachenjie.works.databinding.WorksFragmentFindAlumniBinding
    public void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener Refresh) {
        ((WorksFragmentFindAlumniBinding) this).f36905a = Refresh;
        synchronized (this) {
            this.f14192a |= 16;
        }
        notifyPropertyChanged(qk0.R);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 == variableId) {
            l((FindAlumniVM) variable);
        } else {
            if (qk0.R != variableId) {
                return false;
            }
            setRefresh((SwipeRefreshLayout.OnRefreshListener) variable);
        }
        return true;
    }

    public WorksFragmentFindAlumniBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3, (FindAlumniPicker) bindings[5], (FindAlumniPicker) bindings[4], (FindAlumniPicker) bindings[6], (SwipeRefreshLayout) bindings[2]);
        this.f14192a = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f14194a = linearLayout;
        linearLayout.setTag(null);
        View view = (View) bindings[1];
        this.f14193a = view;
        view.setTag(null);
        RecyclerView recyclerView = (RecyclerView) bindings[3];
        this.f14195a = recyclerView;
        recyclerView.setTag(null);
        ((WorksFragmentFindAlumniBinding) this).f14188a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
