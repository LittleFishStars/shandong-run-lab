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
import com.huachenjie.channel.page.all_topic.AllTopicAdapter;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mine.page.home.topic.MyTopicVM;
import com.zj.adlib.ik0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MineFragmentMyTopicBindingImpl extends MineFragmentMyTopicBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35333a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11292a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11293a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f11294a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f11295a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwipeRefreshLayout f11296a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnRefreshListenerImpl f11297a;

    public static class OnRefreshListenerImpl implements SwipeRefreshLayout.OnRefreshListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SwipeRefreshLayout.OnRefreshListener f35334a;

        public OnRefreshListenerImpl a(SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
            this.f35334a = onRefreshListener;
            if (onRefreshListener == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            this.f35334a.onRefresh();
        }
    }

    public MineFragmentMyTopicBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f11292a, f35333a));
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
        AllTopicAdapter value;
        long j2;
        OnRefreshListenerImpl onRefreshListenerImpl;
        synchronized (this) {
            j = this.f11293a;
            this.f11293a = 0L;
        }
        MyTopicVM myTopicVM = ((MineFragmentMyTopicBinding) this).f11291a;
        SwipeRefreshLayout.OnRefreshListener onRefreshListener = ((MineFragmentMyTopicBinding) this).f35332a;
        OnRefreshListenerImpl onRefreshListenerImplA = null;
        if ((23 & j) != 0) {
            if ((j & 21) != 0) {
                MutableLiveData<Boolean> mutableLiveDataO = myTopicVM != null ? myTopicVM.o() : null;
                updateLiveDataRegistration(0, mutableLiveDataO);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataO != null ? mutableLiveDataO.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 22) != 0) {
                MutableLiveData<AllTopicAdapter> mutableLiveDataN = myTopicVM != null ? myTopicVM.n() : null;
                updateLiveDataRegistration(1, mutableLiveDataN);
                if (mutableLiveDataN != null) {
                    value = mutableLiveDataN.getValue();
                }
            }
            j2 = 24 & j;
            if (j2 != 0 && onRefreshListener != null) {
                onRefreshListenerImpl = this.f11297a;
                if (onRefreshListenerImpl == null) {
                    onRefreshListenerImpl = new OnRefreshListenerImpl();
                    this.f11297a = onRefreshListenerImpl;
                }
                onRefreshListenerImplA = onRefreshListenerImpl.a(onRefreshListener);
            }
            if (j2 != 0) {
                this.f11296a.setOnRefreshListener(onRefreshListenerImplA);
            }
            if ((21 & j) != 0) {
                this.f11296a.setRefreshing(zSafeUnbox);
            }
            if ((j & 22) != 0) {
                CommonBindingAdapter.g(this.f11295a, value, false, false);
            }
        }
        zSafeUnbox = false;
        value = null;
        j2 = 24 & j;
        if (j2 != 0) {
            onRefreshListenerImpl = this.f11297a;
            if (onRefreshListenerImpl == null) {
                onRefreshListenerImpl = new OnRefreshListenerImpl();
                this.f11297a = onRefreshListenerImpl;
            }
            onRefreshListenerImplA = onRefreshListenerImpl.a(onRefreshListener);
        }
        if (j2 != 0) {
            this.f11296a.setOnRefreshListener(onRefreshListenerImplA);
        }
        if ((21 & j) != 0) {
            this.f11296a.setRefreshing(zSafeUnbox);
        }
        if ((j & 22) != 0) {
            CommonBindingAdapter.g(this.f11295a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11293a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11293a = 16L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mine.databinding.MineFragmentMyTopicBinding
    public void l(@Nullable MyTopicVM myTopicVM) {
        ((MineFragmentMyTopicBinding) this).f11291a = myTopicVM;
        synchronized (this) {
            this.f11293a |= 4;
        }
        notifyPropertyChanged(ik0.p0);
        super.requestRebind();
    }

    public final boolean m(MutableLiveData<AllTopicAdapter> mutableLiveData, int i) {
        if (i != ik0.f42374a) {
            return false;
        }
        synchronized (this) {
            this.f11293a |= 2;
        }
        return true;
    }

    public final boolean n(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != ik0.f42374a) {
            return false;
        }
        synchronized (this) {
            this.f11293a |= 1;
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

    @Override // com.huachenjie.mine.databinding.MineFragmentMyTopicBinding
    public void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        ((MineFragmentMyTopicBinding) this).f35332a = onRefreshListener;
        synchronized (this) {
            this.f11293a |= 8;
        }
        notifyPropertyChanged(ik0.R);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ik0.p0 == i) {
            l((MyTopicVM) obj);
        } else {
            if (ik0.R != i) {
                return false;
            }
            setRefresh((SwipeRefreshLayout.OnRefreshListener) obj);
        }
        return true;
    }

    public MineFragmentMyTopicBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2);
        this.f11293a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f11294a = linearLayout;
        linearLayout.setTag(null);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) objArr[1];
        this.f11296a = swipeRefreshLayout;
        swipeRefreshLayout.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[2];
        this.f11295a = recyclerView;
        recyclerView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
