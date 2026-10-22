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
import com.huachenjie.channel.page.my_channel.organize_message.OrganizeMessageAdapter;
import com.huachenjie.channel.page.my_channel.organize_message.OrganizeMessageVM;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.zj.adlib.tk0;
import com.zj.adlib.xq8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelActivityOrganizeMessageBindingImpl extends ChannelActivityOrganizeMessageBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33119a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7666a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7667a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f7668a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnRefreshListenerImpl f7669a;

    public static class OnRefreshListenerImpl implements SwipeRefreshLayout.OnRefreshListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SwipeRefreshLayout.OnRefreshListener f33120a;

        public OnRefreshListenerImpl a(SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
            this.f33120a = onRefreshListener;
            if (onRefreshListener == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            this.f33120a.onRefresh();
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(5);
        f7666a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{4}, new int[]{R.layout.layout_toolbar_binding});
        f33119a = null;
    }

    public ChannelActivityOrganizeMessageBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f7666a, f33119a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0036  */
    /* JADX WARN: Code duplicated, block: B:25:0x0054  */
    /* JADX WARN: Code duplicated, block: B:45:0x0094  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zSafeUnbox;
        OrganizeMessageAdapter value;
        Integer value2;
        BindingTitleBean value3;
        OnRefreshListenerImpl onRefreshListenerImplA;
        synchronized (this) {
            j = this.f7667a;
            this.f7667a = 0L;
        }
        OrganizeMessageVM organizeMessageVM = ((ChannelActivityOrganizeMessageBinding) this).f7663a;
        SwipeRefreshLayout.OnRefreshListener onRefreshListener = ((ChannelActivityOrganizeMessageBinding) this).f7661a;
        if ((187 & j) != 0) {
            if ((j & 161) == 0) {
                value2 = null;
            } else {
                MutableLiveData<Integer> mutableLiveDataR = organizeMessageVM != null ? organizeMessageVM.r() : null;
                updateLiveDataRegistration(0, mutableLiveDataR);
                if (mutableLiveDataR != null) {
                    value2 = mutableLiveDataR.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 162) == 0) {
                value3 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = organizeMessageVM != null ? organizeMessageVM.i() : null;
                updateLiveDataRegistration(1, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value3 = mutableLiveDataI.getValue();
                } else {
                    value3 = null;
                }
            }
            if ((j & 168) != 0) {
                MutableLiveData<Boolean> mutableLiveDataV = organizeMessageVM != null ? organizeMessageVM.v() : null;
                updateLiveDataRegistration(3, mutableLiveDataV);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataV != null ? mutableLiveDataV.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 176) == 0) {
                value = null;
            } else {
                MutableLiveData<OrganizeMessageAdapter> mutableLiveDataC = organizeMessageVM != null ? organizeMessageVM.C() : null;
                updateLiveDataRegistration(4, mutableLiveDataC);
                if (mutableLiveDataC != null) {
                    value = mutableLiveDataC.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            zSafeUnbox = false;
            value = null;
            value2 = null;
            value3 = null;
        }
        long j2 = j & 192;
        if (j2 == 0 || onRefreshListener == null) {
            onRefreshListenerImplA = null;
        } else {
            OnRefreshListenerImpl onRefreshListenerImpl = this.f7669a;
            if (onRefreshListenerImpl == null) {
                onRefreshListenerImpl = new OnRefreshListenerImpl();
                this.f7669a = onRefreshListenerImpl;
            }
            onRefreshListenerImplA = onRefreshListenerImpl.a(onRefreshListener);
        }
        if ((176 & j) != 0) {
            CommonBindingAdapter.g(((ChannelActivityOrganizeMessageBinding) this).f33118a, value, false, false);
        }
        if (j2 != 0) {
            ((ChannelActivityOrganizeMessageBinding) this).f7662a.setOnRefreshListener(onRefreshListenerImplA);
        }
        if ((168 & j) != 0) {
            ((ChannelActivityOrganizeMessageBinding) this).f7662a.setRefreshing(zSafeUnbox);
        }
        if ((161 & j) != 0) {
            xq8.a(((ChannelActivityOrganizeMessageBinding) this).f7665a, value2, null);
        }
        if ((j & 162) != 0) {
            ((ChannelActivityOrganizeMessageBinding) this).f7664a.k(value3);
        }
        ViewDataBinding.executeBindingsOn(((ChannelActivityOrganizeMessageBinding) this).f7664a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f7667a != 0) {
                return true;
            }
            return ((ChannelActivityOrganizeMessageBinding) this).f7664a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7667a = 128L;
        }
        ((ChannelActivityOrganizeMessageBinding) this).f7664a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityOrganizeMessageBinding
    public void l(@Nullable OrganizeMessageVM organizeMessageVM) {
        ((ChannelActivityOrganizeMessageBinding) this).f7663a = organizeMessageVM;
        synchronized (this) {
            this.f7667a |= 32;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean m(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7667a |= 4;
        }
        return true;
    }

    public final boolean n(MutableLiveData<OrganizeMessageAdapter> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7667a |= 16;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7667a |= 8;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return q((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return m((LayoutToolbarBindingBinding) obj, i2);
        }
        if (i == 3) {
            return o((MutableLiveData) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7667a |= 1;
        }
        return true;
    }

    public final boolean q(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7667a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((ChannelActivityOrganizeMessageBinding) this).f7664a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityOrganizeMessageBinding
    public void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        ((ChannelActivityOrganizeMessageBinding) this).f7661a = onRefreshListener;
        synchronized (this) {
            this.f7667a |= 64;
        }
        notifyPropertyChanged(tk0.R);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 == i) {
            l((OrganizeMessageVM) obj);
        } else {
            if (tk0.R != i) {
                return false;
            }
            setRefresh((SwipeRefreshLayout.OnRefreshListener) obj);
        }
        return true;
    }

    public ChannelActivityOrganizeMessageBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (RecyclerView) objArr[3], (SwipeRefreshLayout) objArr[1], (StateLayout) objArr[2], (LayoutToolbarBindingBinding) objArr[4]);
        this.f7667a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f7668a = linearLayout;
        linearLayout.setTag(null);
        ((ChannelActivityOrganizeMessageBinding) this).f33118a.setTag(null);
        ((ChannelActivityOrganizeMessageBinding) this).f7662a.setTag(null);
        ((ChannelActivityOrganizeMessageBinding) this).f7665a.setTag(null);
        setContainedBinding(((ChannelActivityOrganizeMessageBinding) this).f7664a);
        setRootTag(view);
        invalidateAll();
    }
}
