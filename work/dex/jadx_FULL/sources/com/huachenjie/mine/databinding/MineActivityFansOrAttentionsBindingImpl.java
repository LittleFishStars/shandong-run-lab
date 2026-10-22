package com.huachenjie.mine.databinding;

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
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.mine.adapter.FansAndAttentionsAdapter;
import com.huachenjie.mine.page.FansAndAttentionsModel;
import com.zj.adlib.ik0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MineActivityFansOrAttentionsBindingImpl extends MineActivityFansOrAttentionsBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35291a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11187a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11188a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f11189a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnRefreshListenerImpl f11190a;

    public static class OnRefreshListenerImpl implements SwipeRefreshLayout.OnRefreshListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SwipeRefreshLayout.OnRefreshListener f35292a;

        public OnRefreshListenerImpl a(SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
            this.f35292a = onRefreshListener;
            if (onRefreshListener == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            this.f35292a.onRefresh();
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(4);
        f11187a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{3}, new int[]{R.layout.layout_toolbar_binding});
        f35291a = null;
    }

    public MineActivityFansOrAttentionsBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f11187a, f35291a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0036  */
    /* JADX WARN: Code duplicated, block: B:36:0x0076  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zSafeUnbox;
        FansAndAttentionsAdapter value;
        BindingTitleBean value2;
        OnRefreshListenerImpl onRefreshListenerImplA;
        synchronized (this) {
            j = this.f11188a;
            this.f11188a = 0L;
        }
        FansAndAttentionsModel fansAndAttentionsModel = ((MineActivityFansOrAttentionsBinding) this).f11186a;
        SwipeRefreshLayout.OnRefreshListener onRefreshListener = ((MineActivityFansOrAttentionsBinding) this).f11183a;
        if ((93 & j) != 0) {
            if ((j & 81) == 0) {
                value2 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = fansAndAttentionsModel != null ? fansAndAttentionsModel.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value2 = mutableLiveDataI.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 84) != 0) {
                MutableLiveData<Boolean> mutableLiveDataV = fansAndAttentionsModel != null ? fansAndAttentionsModel.v() : null;
                updateLiveDataRegistration(2, mutableLiveDataV);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataV != null ? mutableLiveDataV.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 88) == 0) {
                value = null;
            } else {
                MutableLiveData<FansAndAttentionsAdapter> mutableLiveDataB = fansAndAttentionsModel != null ? fansAndAttentionsModel.B() : null;
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
            OnRefreshListenerImpl onRefreshListenerImpl = this.f11190a;
            if (onRefreshListenerImpl == null) {
                onRefreshListenerImpl = new OnRefreshListenerImpl();
                this.f11190a = onRefreshListenerImpl;
            }
            onRefreshListenerImplA = onRefreshListenerImpl.a(onRefreshListener);
        }
        if (j2 != 0) {
            ((MineActivityFansOrAttentionsBinding) this).f11184a.setOnRefreshListener(onRefreshListenerImplA);
        }
        if ((84 & j) != 0) {
            ((MineActivityFansOrAttentionsBinding) this).f11184a.setRefreshing(zSafeUnbox);
        }
        if ((88 & j) != 0) {
            CommonBindingAdapter.g(((MineActivityFansOrAttentionsBinding) this).f35290a, value, false, false);
        }
        if ((j & 81) != 0) {
            ((MineActivityFansOrAttentionsBinding) this).f11185a.k(value2);
        }
        ViewDataBinding.executeBindingsOn(((MineActivityFansOrAttentionsBinding) this).f11185a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11188a != 0) {
                return true;
            }
            return ((MineActivityFansOrAttentionsBinding) this).f11185a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11188a = 64L;
        }
        ((MineActivityFansOrAttentionsBinding) this).f11185a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.mine.databinding.MineActivityFansOrAttentionsBinding
    public void l(@Nullable FansAndAttentionsModel fansAndAttentionsModel) {
        ((MineActivityFansOrAttentionsBinding) this).f11186a = fansAndAttentionsModel;
        synchronized (this) {
            this.f11188a |= 16;
        }
        notifyPropertyChanged(ik0.p0);
        super.requestRebind();
    }

    public final boolean m(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != ik0.f42374a) {
            return false;
        }
        synchronized (this) {
            this.f11188a |= 2;
        }
        return true;
    }

    public final boolean n(MutableLiveData<FansAndAttentionsAdapter> mutableLiveData, int i) {
        if (i != ik0.f42374a) {
            return false;
        }
        synchronized (this) {
            this.f11188a |= 8;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != ik0.f42374a) {
            return false;
        }
        synchronized (this) {
            this.f11188a |= 4;
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
        if (i != ik0.f42374a) {
            return false;
        }
        synchronized (this) {
            this.f11188a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((MineActivityFansOrAttentionsBinding) this).f11185a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // com.huachenjie.mine.databinding.MineActivityFansOrAttentionsBinding
    public void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        ((MineActivityFansOrAttentionsBinding) this).f11183a = onRefreshListener;
        synchronized (this) {
            this.f11188a |= 32;
        }
        notifyPropertyChanged(ik0.R);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ik0.p0 == i) {
            l((FansAndAttentionsModel) obj);
        } else {
            if (ik0.R != i) {
                return false;
            }
            setRefresh((SwipeRefreshLayout.OnRefreshListener) obj);
        }
        return true;
    }

    public MineActivityFansOrAttentionsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (SwipeRefreshLayout) objArr[1], (RecyclerView) objArr[2], (LayoutToolbarBindingBinding) objArr[3]);
        this.f11188a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f11189a = linearLayout;
        linearLayout.setTag(null);
        ((MineActivityFansOrAttentionsBinding) this).f11184a.setTag(null);
        ((MineActivityFansOrAttentionsBinding) this).f35290a.setTag(null);
        setContainedBinding(((MineActivityFansOrAttentionsBinding) this).f11185a);
        setRootTag(view);
        invalidateAll();
    }
}
