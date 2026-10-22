package com.huachenjie.channel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.huachenjie.channel.adapter.notify.NotifyFavoritesAdapter;
import com.huachenjie.channel.page.notify.broad_build.NotifyBroadLikeVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.zj.adlib.tk0;
import com.zj.adlib.xq8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelFragmentNotifyLikeBindingImpl extends ChannelFragmentNotifyLikeBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33208a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7878a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7879a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnRefreshListenerImpl f7880a;

    public static class OnRefreshListenerImpl implements SwipeRefreshLayout.OnRefreshListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SwipeRefreshLayout.OnRefreshListener f33209a;

        public OnRefreshListenerImpl a(SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
            this.f33209a = onRefreshListener;
            if (onRefreshListener == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            this.f33209a.onRefresh();
        }
    }

    public ChannelFragmentNotifyLikeBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f7878a, f33208a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0036  */
    /* JADX WARN: Code duplicated, block: B:36:0x0076  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zSafeUnbox;
        NotifyFavoritesAdapter value;
        Integer value2;
        OnRefreshListenerImpl onRefreshListenerImplA;
        synchronized (this) {
            j = this.f7879a;
            this.f7879a = 0L;
        }
        NotifyBroadLikeVM notifyBroadLikeVM = ((ChannelFragmentNotifyLikeBinding) this).f7876a;
        SwipeRefreshLayout.OnRefreshListener onRefreshListener = ((ChannelFragmentNotifyLikeBinding) this).f7874a;
        if ((47 & j) != 0) {
            if ((j & 41) == 0) {
                value2 = null;
            } else {
                MutableLiveData<Integer> mutableLiveDataR = notifyBroadLikeVM != null ? notifyBroadLikeVM.r() : null;
                updateLiveDataRegistration(0, mutableLiveDataR);
                if (mutableLiveDataR != null) {
                    value2 = mutableLiveDataR.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 42) != 0) {
                MutableLiveData<Boolean> mutableLiveDataV = notifyBroadLikeVM != null ? notifyBroadLikeVM.v() : null;
                updateLiveDataRegistration(1, mutableLiveDataV);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataV != null ? mutableLiveDataV.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 44) == 0) {
                value = null;
            } else {
                MutableLiveData<NotifyFavoritesAdapter> mutableLiveDataB = notifyBroadLikeVM != null ? notifyBroadLikeVM.B() : null;
                updateLiveDataRegistration(2, mutableLiveDataB);
                if (mutableLiveDataB != null) {
                    value = mutableLiveDataB.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            zSafeUnbox = false;
            value = null;
            value2 = null;
        }
        long j2 = j & 48;
        if (j2 == 0 || onRefreshListener == null) {
            onRefreshListenerImplA = null;
        } else {
            OnRefreshListenerImpl onRefreshListenerImpl = this.f7880a;
            if (onRefreshListenerImpl == null) {
                onRefreshListenerImpl = new OnRefreshListenerImpl();
                this.f7880a = onRefreshListenerImpl;
            }
            onRefreshListenerImplA = onRefreshListenerImpl.a(onRefreshListener);
        }
        if (j2 != 0) {
            ((ChannelFragmentNotifyLikeBinding) this).f7875a.setOnRefreshListener(onRefreshListenerImplA);
        }
        if ((42 & j) != 0) {
            ((ChannelFragmentNotifyLikeBinding) this).f7875a.setRefreshing(zSafeUnbox);
        }
        if ((44 & j) != 0) {
            CommonBindingAdapter.g(((ChannelFragmentNotifyLikeBinding) this).f33207a, value, false, false);
        }
        if ((j & 41) != 0) {
            xq8.a(((ChannelFragmentNotifyLikeBinding) this).f7877a, value2, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7879a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7879a = 32L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelFragmentNotifyLikeBinding
    public void l(@Nullable NotifyBroadLikeVM notifyBroadLikeVM) {
        ((ChannelFragmentNotifyLikeBinding) this).f7876a = notifyBroadLikeVM;
        synchronized (this) {
            this.f7879a |= 8;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean m(MutableLiveData<NotifyFavoritesAdapter> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7879a |= 4;
        }
        return true;
    }

    public final boolean n(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7879a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7879a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return o((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return n((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return m((MutableLiveData) obj, i2);
    }

    @Override // com.huachenjie.channel.databinding.ChannelFragmentNotifyLikeBinding
    public void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        ((ChannelFragmentNotifyLikeBinding) this).f7874a = onRefreshListener;
        synchronized (this) {
            this.f7879a |= 16;
        }
        notifyPropertyChanged(tk0.R);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 == i) {
            l((NotifyBroadLikeVM) obj);
        } else {
            if (tk0.R != i) {
                return false;
            }
            setRefresh((SwipeRefreshLayout.OnRefreshListener) obj);
        }
        return true;
    }

    public ChannelFragmentNotifyLikeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (SwipeRefreshLayout) objArr[0], (RecyclerView) objArr[2], (StateLayout) objArr[1]);
        this.f7879a = -1L;
        ((ChannelFragmentNotifyLikeBinding) this).f7875a.setTag(null);
        ((ChannelFragmentNotifyLikeBinding) this).f33207a.setTag(null);
        ((ChannelFragmentNotifyLikeBinding) this).f7877a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
