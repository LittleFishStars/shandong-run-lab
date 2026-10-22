package com.huachenjie.social_contact.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.adapter.WorldLetterAdapter;
import com.huachenjie.social_contact.vm.WorldLetterVM;
import com.zj.adlib.nk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ActivityWorldLetterBindingImpl extends ActivityWorldLetterBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36125a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12838a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12839a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f12840a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f12841a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwipeRefreshLayout f12842a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnRefreshListenerImpl f12843a;

    public static class OnRefreshListenerImpl implements SwipeRefreshLayout.OnRefreshListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SwipeRefreshLayout.OnRefreshListener f36126a;

        public OnRefreshListenerImpl a(SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
            this.f36126a = onRefreshListener;
            if (onRefreshListener == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            this.f36126a.onRefresh();
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36125a = sparseIntArray;
        sparseIntArray.put(R.id.tvTitle, 3);
    }

    public ActivityWorldLetterBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f12838a, f36125a));
    }

    /* JADX WARN: Code duplicated, block: B:38:0x007a  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        WorldLetterAdapter value;
        boolean zSafeUnbox;
        int i;
        OnRefreshListenerImpl onRefreshListenerImplA;
        int iSafeUnbox;
        synchronized (this) {
            j = this.f12839a;
            this.f12839a = 0L;
        }
        WorldLetterVM worldLetterVM = ((ActivityWorldLetterBinding) this).f12837a;
        SwipeRefreshLayout.OnRefreshListener onRefreshListener = ((ActivityWorldLetterBinding) this).f12836a;
        if ((47 & j) != 0) {
            if ((j & 41) != 0) {
                MutableLiveData<Boolean> mutableLiveDataO = worldLetterVM != null ? worldLetterVM.o() : null;
                updateLiveDataRegistration(0, mutableLiveDataO);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataO != null ? mutableLiveDataO.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 42) != 0) {
                MutableLiveData<Integer> mutableLiveData = worldLetterVM != null ? ((BaseVM) worldLetterVM).f33644a : null;
                updateLiveDataRegistration(1, mutableLiveData);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveData != null ? mutableLiveData.getValue() : null);
            } else {
                iSafeUnbox = 0;
            }
            if ((j & 44) == 0) {
                i = iSafeUnbox;
                value = null;
            } else {
                MutableLiveData<WorldLetterAdapter> mutableLiveDataJ = worldLetterVM != null ? worldLetterVM.j() : null;
                updateLiveDataRegistration(2, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value = mutableLiveDataJ.getValue();
                    i = iSafeUnbox;
                } else {
                    i = iSafeUnbox;
                    value = null;
                }
            }
        } else {
            value = null;
            zSafeUnbox = false;
            i = 0;
        }
        long j2 = 48 & j;
        if (j2 == 0 || onRefreshListener == null) {
            onRefreshListenerImplA = null;
        } else {
            OnRefreshListenerImpl onRefreshListenerImpl = this.f12843a;
            if (onRefreshListenerImpl == null) {
                onRefreshListenerImpl = new OnRefreshListenerImpl();
                this.f12843a = onRefreshListenerImpl;
            }
            onRefreshListenerImplA = onRefreshListenerImpl.a(onRefreshListener);
        }
        if ((42 & j) != 0) {
            CommonBindingAdapter.O(this.f12840a, 0, i, 0, 0, null);
        }
        if (j2 != 0) {
            this.f12842a.setOnRefreshListener(onRefreshListenerImplA);
        }
        if ((j & 41) != 0) {
            this.f12842a.setRefreshing(zSafeUnbox);
        }
        if ((j & 44) != 0) {
            CommonBindingAdapter.g(this.f12841a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12839a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12839a = 32L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.social_contact.databinding.ActivityWorldLetterBinding
    public void l(@Nullable WorldLetterVM worldLetterVM) {
        ((ActivityWorldLetterBinding) this).f12837a = worldLetterVM;
        synchronized (this) {
            this.f12839a |= 8;
        }
        notifyPropertyChanged(nk0.p0);
        super.requestRebind();
    }

    public final boolean m(MutableLiveData<WorldLetterAdapter> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12839a |= 4;
        }
        return true;
    }

    public final boolean n(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12839a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != nk0.f43540a) {
            return false;
        }
        synchronized (this) {
            this.f12839a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return o((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return m((MutableLiveData) obj, i2);
    }

    @Override // com.huachenjie.social_contact.databinding.ActivityWorldLetterBinding
    public void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        ((ActivityWorldLetterBinding) this).f12836a = onRefreshListener;
        synchronized (this) {
            this.f12839a |= 16;
        }
        notifyPropertyChanged(nk0.R);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (nk0.p0 == i) {
            l((WorldLetterVM) obj);
        } else {
            if (nk0.R != i) {
                return false;
            }
            setRefresh((SwipeRefreshLayout.OnRefreshListener) obj);
        }
        return true;
    }

    public ActivityWorldLetterBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (TextView) objArr[3]);
        this.f12839a = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12840a = constraintLayout;
        constraintLayout.setTag(null);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) objArr[1];
        this.f12842a = swipeRefreshLayout;
        swipeRefreshLayout.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[2];
        this.f12841a = recyclerView;
        recyclerView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
