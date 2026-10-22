package com.huachenjie.channel.databinding;

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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.huachenjie.channel.page.notify.base.BaseNotifyNextModel;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelActivityNotifyNextBindingImpl extends ChannelActivityNotifyNextBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33101a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7614a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7615a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f7616a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnRefreshListenerImpl f7617a;

    public static class OnRefreshListenerImpl implements SwipeRefreshLayout.OnRefreshListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SwipeRefreshLayout.OnRefreshListener f33102a;

        public OnRefreshListenerImpl a(SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
            this.f33102a = onRefreshListener;
            if (onRefreshListener == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            this.f33102a.onRefresh();
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(4);
        f7614a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{3}, new int[]{R.layout.layout_toolbar_binding});
        f33101a = null;
    }

    public ChannelActivityNotifyNextBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f7614a, f33101a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0036  */
    /* JADX WARN: Code duplicated, block: B:36:0x0076  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zSafeUnbox;
        BaseQuickAdapter<?, ?> value;
        BindingTitleBean value2;
        OnRefreshListenerImpl onRefreshListenerImplA;
        synchronized (this) {
            j = this.f7615a;
            this.f7615a = 0L;
        }
        BaseNotifyNextModel baseNotifyNextModel = ((ChannelActivityNotifyNextBinding) this).f7612a;
        SwipeRefreshLayout.OnRefreshListener onRefreshListener = ((ChannelActivityNotifyNextBinding) this).f7610a;
        if ((93 & j) != 0) {
            if ((j & 81) == 0) {
                value2 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = baseNotifyNextModel != null ? baseNotifyNextModel.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value2 = mutableLiveDataI.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 84) != 0) {
                MutableLiveData<Boolean> mutableLiveDataV = baseNotifyNextModel != null ? baseNotifyNextModel.v() : null;
                updateLiveDataRegistration(2, mutableLiveDataV);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataV != null ? mutableLiveDataV.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 88) == 0) {
                value = null;
            } else {
                MutableLiveData<BaseQuickAdapter<?, ?>> mutableLiveDataB = baseNotifyNextModel != null ? baseNotifyNextModel.B() : null;
                updateLiveDataRegistration(3, mutableLiveDataB);
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
        long j2 = j & 96;
        if (j2 == 0 || onRefreshListener == null) {
            onRefreshListenerImplA = null;
        } else {
            OnRefreshListenerImpl onRefreshListenerImpl = this.f7617a;
            if (onRefreshListenerImpl == null) {
                onRefreshListenerImpl = new OnRefreshListenerImpl();
                this.f7617a = onRefreshListenerImpl;
            }
            onRefreshListenerImplA = onRefreshListenerImpl.a(onRefreshListener);
        }
        if (j2 != 0) {
            ((ChannelActivityNotifyNextBinding) this).f7611a.setOnRefreshListener(onRefreshListenerImplA);
        }
        if ((84 & j) != 0) {
            ((ChannelActivityNotifyNextBinding) this).f7611a.setRefreshing(zSafeUnbox);
        }
        if ((88 & j) != 0) {
            CommonBindingAdapter.g(((ChannelActivityNotifyNextBinding) this).f33100a, value, false, false);
        }
        if ((j & 81) != 0) {
            ((ChannelActivityNotifyNextBinding) this).f7613a.k(value2);
        }
        ViewDataBinding.executeBindingsOn(((ChannelActivityNotifyNextBinding) this).f7613a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f7615a != 0) {
                return true;
            }
            return ((ChannelActivityNotifyNextBinding) this).f7613a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7615a = 64L;
        }
        ((ChannelActivityNotifyNextBinding) this).f7613a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityNotifyNextBinding
    public void l(@Nullable BaseNotifyNextModel baseNotifyNextModel) {
        ((ChannelActivityNotifyNextBinding) this).f7612a = baseNotifyNextModel;
        synchronized (this) {
            this.f7615a |= 16;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean m(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7615a |= 2;
        }
        return true;
    }

    public final boolean n(MutableLiveData mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7615a |= 8;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7615a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return m((LayoutToolbarBindingBinding) obj, i2);
        }
        if (i == 2) {
            return o((MutableLiveData) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7615a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((ChannelActivityNotifyNextBinding) this).f7613a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityNotifyNextBinding
    public void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        ((ChannelActivityNotifyNextBinding) this).f7610a = onRefreshListener;
        synchronized (this) {
            this.f7615a |= 32;
        }
        notifyPropertyChanged(tk0.R);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 == i) {
            l((BaseNotifyNextModel) obj);
        } else {
            if (tk0.R != i) {
                return false;
            }
            setRefresh((SwipeRefreshLayout.OnRefreshListener) obj);
        }
        return true;
    }

    public ChannelActivityNotifyNextBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (SwipeRefreshLayout) objArr[1], (RecyclerView) objArr[2], (LayoutToolbarBindingBinding) objArr[3]);
        this.f7615a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f7616a = linearLayout;
        linearLayout.setTag(null);
        ((ChannelActivityNotifyNextBinding) this).f7611a.setTag(null);
        ((ChannelActivityNotifyNextBinding) this).f33100a.setTag(null);
        setContainedBinding(((ChannelActivityNotifyNextBinding) this).f7613a);
        setRootTag(view);
        invalidateAll();
    }
}
