package com.huachenjie.channel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.huachenjie.channel.page.organize.OrganizeActivity;
import com.huachenjie.channel.page.organize.OrganizeAdapter;
import com.huachenjie.channel.page.organize.OrganizeVM;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelActivityOrganizeBindingImpl extends ChannelActivityOrganizeBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33106a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7632a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7633a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f7634a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnRefreshListenerImpl f7635a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f7636a;

    public static class OnRefreshListenerImpl implements SwipeRefreshLayout.OnRefreshListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SwipeRefreshLayout.OnRefreshListener f33107a;

        public OnRefreshListenerImpl a(SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
            this.f33107a = onRefreshListener;
            if (onRefreshListener == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            this.f33107a.onRefresh();
        }
    }

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OrganizeActivity.a f33108a;

        public a a(OrganizeActivity.a aVar) {
            this.f33108a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33108a.a(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(6);
        f7632a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{4}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33106a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.channel.R.id.v_line, 5);
    }

    public ChannelActivityOrganizeBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f7632a, f33106a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0037  */
    /* JADX WARN: Code duplicated, block: B:36:0x0077  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        OrganizeAdapter value;
        BindingTitleBean value2;
        boolean zSafeUnbox;
        OnRefreshListenerImpl onRefreshListenerImplA;
        a aVarA;
        synchronized (this) {
            j = this.f7633a;
            this.f7633a = 0L;
        }
        OrganizeVM organizeVM = ((ChannelActivityOrganizeBinding) this).f7628a;
        SwipeRefreshLayout.OnRefreshListener onRefreshListener = ((ChannelActivityOrganizeBinding) this).f7625a;
        OrganizeActivity.a aVar = ((ChannelActivityOrganizeBinding) this).f7627a;
        if ((157 & j) != 0) {
            if ((j & 145) == 0) {
                value2 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = organizeVM != null ? organizeVM.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value2 = mutableLiveDataI.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 148) != 0) {
                MutableLiveData<Boolean> mutableLiveDataN = organizeVM != null ? organizeVM.n() : null;
                updateLiveDataRegistration(2, mutableLiveDataN);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataN != null ? mutableLiveDataN.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 152) == 0) {
                value = null;
            } else {
                MutableLiveData<OrganizeAdapter> mutableLiveDataL = organizeVM != null ? organizeVM.l() : null;
                updateLiveDataRegistration(3, mutableLiveDataL);
                if (mutableLiveDataL != null) {
                    value = mutableLiveDataL.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            value = null;
            value2 = null;
            zSafeUnbox = false;
        }
        long j2 = 160 & j;
        if (j2 == 0 || onRefreshListener == null) {
            onRefreshListenerImplA = null;
        } else {
            OnRefreshListenerImpl onRefreshListenerImpl = this.f7635a;
            if (onRefreshListenerImpl == null) {
                onRefreshListenerImpl = new OnRefreshListenerImpl();
                this.f7635a = onRefreshListenerImpl;
            }
            onRefreshListenerImplA = onRefreshListenerImpl.a(onRefreshListener);
        }
        long j3 = j & 192;
        if (j3 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f7636a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f7636a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(((ChannelActivityOrganizeBinding) this).f7630a, aVarA, null);
        }
        if ((152 & j) != 0) {
            CommonBindingAdapter.g(((ChannelActivityOrganizeBinding) this).f33105a, value, false, false);
        }
        if (j2 != 0) {
            ((ChannelActivityOrganizeBinding) this).f7626a.setOnRefreshListener(onRefreshListenerImplA);
        }
        if ((148 & j) != 0) {
            ((ChannelActivityOrganizeBinding) this).f7626a.setRefreshing(zSafeUnbox);
        }
        if ((j & 145) != 0) {
            ((ChannelActivityOrganizeBinding) this).f7629a.k(value2);
        }
        ViewDataBinding.executeBindingsOn(((ChannelActivityOrganizeBinding) this).f7629a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f7633a != 0) {
                return true;
            }
            return ((ChannelActivityOrganizeBinding) this).f7629a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7633a = 128L;
        }
        ((ChannelActivityOrganizeBinding) this).f7629a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityOrganizeBinding
    public void m(@Nullable OrganizeActivity.a aVar) {
        ((ChannelActivityOrganizeBinding) this).f7627a = aVar;
        synchronized (this) {
            this.f7633a |= 64;
        }
        notifyPropertyChanged(tk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityOrganizeBinding
    public void n(@Nullable OrganizeVM organizeVM) {
        ((ChannelActivityOrganizeBinding) this).f7628a = organizeVM;
        synchronized (this) {
            this.f7633a |= 16;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean o(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7633a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return r((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return o((LayoutToolbarBindingBinding) obj, i2);
        }
        if (i == 2) {
            return q((MutableLiveData) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return p((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<OrganizeAdapter> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7633a |= 8;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7633a |= 4;
        }
        return true;
    }

    public final boolean r(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7633a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((ChannelActivityOrganizeBinding) this).f7629a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityOrganizeBinding
    public void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        ((ChannelActivityOrganizeBinding) this).f7625a = onRefreshListener;
        synchronized (this) {
            this.f7633a |= 32;
        }
        notifyPropertyChanged(tk0.R);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 == i) {
            n((OrganizeVM) obj);
        } else if (tk0.R == i) {
            setRefresh((SwipeRefreshLayout.OnRefreshListener) obj);
        } else {
            if (tk0.k != i) {
                return false;
            }
            m((OrganizeActivity.a) obj);
        }
        return true;
    }

    public ChannelActivityOrganizeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (BLTextView) objArr[3], (RecyclerView) objArr[2], (SwipeRefreshLayout) objArr[1], (LayoutToolbarBindingBinding) objArr[4], (BLView) objArr[5]);
        this.f7633a = -1L;
        ((ChannelActivityOrganizeBinding) this).f7630a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f7634a = constraintLayout;
        constraintLayout.setTag(null);
        ((ChannelActivityOrganizeBinding) this).f33105a.setTag(null);
        ((ChannelActivityOrganizeBinding) this).f7626a.setTag(null);
        setContainedBinding(((ChannelActivityOrganizeBinding) this).f7629a);
        setRootTag(view);
        invalidateAll();
    }
}
