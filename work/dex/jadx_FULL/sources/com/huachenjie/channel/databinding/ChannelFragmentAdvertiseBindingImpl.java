package com.huachenjie.channel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.huachenjie.channel.page.advertise.AdvertiseAdapter;
import com.huachenjie.channel.page.advertise.AdvertiseVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelFragmentAdvertiseBindingImpl extends ChannelFragmentAdvertiseBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33159a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7768a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7769a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f7770a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnRefreshListenerImpl f7771a;

    public static class OnRefreshListenerImpl implements SwipeRefreshLayout.OnRefreshListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SwipeRefreshLayout.OnRefreshListener f33160a;

        public OnRefreshListenerImpl a(SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
            this.f33160a = onRefreshListener;
            if (onRefreshListener == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            this.f33160a.onRefresh();
        }
    }

    public ChannelFragmentAdvertiseBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f7768a, f33159a));
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0064  */
    /* JADX WARN: Code duplicated, block: B:37:0x0074  */
    /* JADX WARN: Code duplicated, block: B:39:0x007b  */
    /* JADX WARN: Code duplicated, block: B:42:0x0085  */
    /* JADX WARN: Code duplicated, block: B:49:? A[RETURN, SYNTHETIC] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zSafeUnbox;
        AdvertiseAdapter value;
        long j2;
        OnRefreshListenerImpl onRefreshListenerImpl;
        synchronized (this) {
            j = this.f7769a;
            this.f7769a = 0L;
        }
        AdvertiseVM advertiseVM = ((ChannelFragmentAdvertiseBinding) this).f7767a;
        SwipeRefreshLayout.OnRefreshListener onRefreshListener = ((ChannelFragmentAdvertiseBinding) this).f7765a;
        OnRefreshListenerImpl onRefreshListenerImplA = null;
        if ((23 & j) != 0) {
            if ((j & 21) != 0) {
                MutableLiveData<Boolean> mutableLiveDataQ = advertiseVM != null ? advertiseVM.q() : null;
                updateLiveDataRegistration(0, mutableLiveDataQ);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataQ != null ? mutableLiveDataQ.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 22) != 0) {
                MutableLiveData<AdvertiseAdapter> mutableLiveDataN = advertiseVM != null ? advertiseVM.n() : null;
                updateLiveDataRegistration(1, mutableLiveDataN);
                if (mutableLiveDataN != null) {
                    value = mutableLiveDataN.getValue();
                }
            }
            j2 = 24 & j;
            if (j2 != 0 && onRefreshListener != null) {
                onRefreshListenerImpl = this.f7771a;
                if (onRefreshListenerImpl == null) {
                    onRefreshListenerImpl = new OnRefreshListenerImpl();
                    this.f7771a = onRefreshListenerImpl;
                }
                onRefreshListenerImplA = onRefreshListenerImpl.a(onRefreshListener);
            }
            if ((22 & j) != 0) {
                CommonBindingAdapter.g(((ChannelFragmentAdvertiseBinding) this).f33158a, value, false, false);
            }
            if (j2 != 0) {
                ((ChannelFragmentAdvertiseBinding) this).f7766a.setOnRefreshListener(onRefreshListenerImplA);
            }
            if ((j & 21) != 0) {
                ((ChannelFragmentAdvertiseBinding) this).f7766a.setRefreshing(zSafeUnbox);
            }
        }
        zSafeUnbox = false;
        value = null;
        j2 = 24 & j;
        if (j2 != 0) {
            onRefreshListenerImpl = this.f7771a;
            if (onRefreshListenerImpl == null) {
                onRefreshListenerImpl = new OnRefreshListenerImpl();
                this.f7771a = onRefreshListenerImpl;
            }
            onRefreshListenerImplA = onRefreshListenerImpl.a(onRefreshListener);
        }
        if ((22 & j) != 0) {
            CommonBindingAdapter.g(((ChannelFragmentAdvertiseBinding) this).f33158a, value, false, false);
        }
        if (j2 != 0) {
            ((ChannelFragmentAdvertiseBinding) this).f7766a.setOnRefreshListener(onRefreshListenerImplA);
        }
        if ((j & 21) != 0) {
            ((ChannelFragmentAdvertiseBinding) this).f7766a.setRefreshing(zSafeUnbox);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7769a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7769a = 16L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelFragmentAdvertiseBinding
    public void l(@Nullable AdvertiseVM advertiseVM) {
        ((ChannelFragmentAdvertiseBinding) this).f7767a = advertiseVM;
        synchronized (this) {
            this.f7769a |= 4;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean m(MutableLiveData<AdvertiseAdapter> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7769a |= 2;
        }
        return true;
    }

    public final boolean n(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7769a |= 1;
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

    @Override // com.huachenjie.channel.databinding.ChannelFragmentAdvertiseBinding
    public void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        ((ChannelFragmentAdvertiseBinding) this).f7765a = onRefreshListener;
        synchronized (this) {
            this.f7769a |= 8;
        }
        notifyPropertyChanged(tk0.R);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 == i) {
            l((AdvertiseVM) obj);
        } else {
            if (tk0.R != i) {
                return false;
            }
            setRefresh((SwipeRefreshLayout.OnRefreshListener) obj);
        }
        return true;
    }

    public ChannelFragmentAdvertiseBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (RecyclerView) objArr[2], (SwipeRefreshLayout) objArr[1]);
        this.f7769a = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f7770a = constraintLayout;
        constraintLayout.setTag(null);
        ((ChannelFragmentAdvertiseBinding) this).f33158a.setTag(null);
        ((ChannelFragmentAdvertiseBinding) this).f7766a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
