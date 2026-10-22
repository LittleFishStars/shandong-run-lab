package com.huachenjie.mine.databinding;

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
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.mine.R;
import com.huachenjie.mine.page.history.fragment.HistoryChannelViewModel;
import com.huachenjie.works.external.adapter.AllChannelListAdapter;
import com.zj.adlib.ik0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MineFragmentHistoryChannelBindingImpl extends MineFragmentHistoryChannelBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35318a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11252a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11253a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f11254a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f11255a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwipeRefreshLayout f11256a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnRefreshListenerImpl f11257a;

    public static class OnRefreshListenerImpl implements SwipeRefreshLayout.OnRefreshListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SwipeRefreshLayout.OnRefreshListener f35319a;

        public OnRefreshListenerImpl a(SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
            this.f35319a = onRefreshListener;
            if (onRefreshListener == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            this.f35319a.onRefresh();
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35318a = sparseIntArray;
        sparseIntArray.put(R.id.state_layout, 3);
    }

    public MineFragmentHistoryChannelBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f11252a, f35318a));
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0064  */
    /* JADX WARN: Code duplicated, block: B:36:0x0071  */
    /* JADX WARN: Code duplicated, block: B:39:0x007b  */
    /* JADX WARN: Code duplicated, block: B:42:0x0085  */
    /* JADX WARN: Code duplicated, block: B:49:? A[RETURN, SYNTHETIC] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zSafeUnbox;
        AllChannelListAdapter value;
        long j2;
        OnRefreshListenerImpl onRefreshListenerImpl;
        synchronized (this) {
            j = this.f11253a;
            this.f11253a = 0L;
        }
        HistoryChannelViewModel historyChannelViewModel = ((MineFragmentHistoryChannelBinding) this).f11251a;
        SwipeRefreshLayout.OnRefreshListener onRefreshListener = ((MineFragmentHistoryChannelBinding) this).f35317a;
        OnRefreshListenerImpl onRefreshListenerImplA = null;
        if ((23 & j) != 0) {
            if ((j & 21) != 0) {
                MutableLiveData<Boolean> mutableLiveDataV = historyChannelViewModel != null ? historyChannelViewModel.v() : null;
                updateLiveDataRegistration(0, mutableLiveDataV);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataV != null ? mutableLiveDataV.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 22) != 0) {
                MutableLiveData<AllChannelListAdapter> mutableLiveDataB = historyChannelViewModel != null ? historyChannelViewModel.B() : null;
                updateLiveDataRegistration(1, mutableLiveDataB);
                if (mutableLiveDataB != null) {
                    value = mutableLiveDataB.getValue();
                }
            }
            j2 = 24 & j;
            if (j2 != 0 && onRefreshListener != null) {
                onRefreshListenerImpl = this.f11257a;
                if (onRefreshListenerImpl == null) {
                    onRefreshListenerImpl = new OnRefreshListenerImpl();
                    this.f11257a = onRefreshListenerImpl;
                }
                onRefreshListenerImplA = onRefreshListenerImpl.a(onRefreshListener);
            }
            if (j2 != 0) {
                this.f11256a.setOnRefreshListener(onRefreshListenerImplA);
            }
            if ((21 & j) != 0) {
                this.f11256a.setRefreshing(zSafeUnbox);
            }
            if ((j & 22) != 0) {
                CommonBindingAdapter.g(this.f11255a, value, false, false);
            }
        }
        zSafeUnbox = false;
        value = null;
        j2 = 24 & j;
        if (j2 != 0) {
            onRefreshListenerImpl = this.f11257a;
            if (onRefreshListenerImpl == null) {
                onRefreshListenerImpl = new OnRefreshListenerImpl();
                this.f11257a = onRefreshListenerImpl;
            }
            onRefreshListenerImplA = onRefreshListenerImpl.a(onRefreshListener);
        }
        if (j2 != 0) {
            this.f11256a.setOnRefreshListener(onRefreshListenerImplA);
        }
        if ((21 & j) != 0) {
            this.f11256a.setRefreshing(zSafeUnbox);
        }
        if ((j & 22) != 0) {
            CommonBindingAdapter.g(this.f11255a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11253a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11253a = 16L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mine.databinding.MineFragmentHistoryChannelBinding
    public void l(@Nullable HistoryChannelViewModel historyChannelViewModel) {
        ((MineFragmentHistoryChannelBinding) this).f11251a = historyChannelViewModel;
        synchronized (this) {
            this.f11253a |= 4;
        }
        notifyPropertyChanged(ik0.p0);
        super.requestRebind();
    }

    public final boolean m(MutableLiveData<AllChannelListAdapter> mutableLiveData, int i) {
        if (i != ik0.f42374a) {
            return false;
        }
        synchronized (this) {
            this.f11253a |= 2;
        }
        return true;
    }

    public final boolean n(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != ik0.f42374a) {
            return false;
        }
        synchronized (this) {
            this.f11253a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((MutableLiveData) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return m((MutableLiveData) obj, i2);
    }

    @Override // com.huachenjie.mine.databinding.MineFragmentHistoryChannelBinding
    public void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        ((MineFragmentHistoryChannelBinding) this).f35317a = onRefreshListener;
        synchronized (this) {
            this.f11253a |= 8;
        }
        notifyPropertyChanged(ik0.R);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ik0.p0 == i) {
            l((HistoryChannelViewModel) obj);
        } else {
            if (ik0.R != i) {
                return false;
            }
            setRefresh((SwipeRefreshLayout.OnRefreshListener) obj);
        }
        return true;
    }

    public MineFragmentHistoryChannelBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (StateLayout) objArr[3]);
        this.f11253a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f11254a = linearLayout;
        linearLayout.setTag(null);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) objArr[1];
        this.f11256a = swipeRefreshLayout;
        swipeRefreshLayout.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[2];
        this.f11255a = recyclerView;
        recyclerView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
