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
import com.huachenjie.channel.adapter.AllOrMyOrganizeAdapter;
import com.huachenjie.channel.page.my_channel.my_organize.MyOrganizeActivity;
import com.huachenjie.channel.page.my_channel.my_organize.MyOrganizeVM;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.tk0;
import com.zj.adlib.xq8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelActivityMyOrganizeBindingImpl extends ChannelActivityMyOrganizeBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33093a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7593a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7594a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f7595a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnRefreshListenerImpl f7596a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f7597a;

    public static class OnRefreshListenerImpl implements SwipeRefreshLayout.OnRefreshListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SwipeRefreshLayout.OnRefreshListener f33094a;

        public OnRefreshListenerImpl a(SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
            this.f33094a = onRefreshListener;
            if (onRefreshListener == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            this.f33094a.onRefresh();
        }
    }

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MyOrganizeActivity.a f33095a;

        public a a(MyOrganizeActivity.a aVar) {
            this.f33095a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33095a.a(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(6);
        f7593a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{5}, new int[]{R.layout.layout_toolbar_binding});
        f33093a = null;
    }

    public ChannelActivityMyOrganizeBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f7593a, f33093a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0039  */
    /* JADX WARN: Code duplicated, block: B:25:0x0057  */
    /* JADX WARN: Code duplicated, block: B:45:0x0097  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zSafeUnbox;
        AllOrMyOrganizeAdapter value;
        Integer value2;
        BindingTitleBean value3;
        OnRefreshListenerImpl onRefreshListenerImplA;
        a aVarA;
        synchronized (this) {
            j = this.f7594a;
            this.f7594a = 0L;
        }
        MyOrganizeVM myOrganizeVM = ((ChannelActivityMyOrganizeBinding) this).f7589a;
        SwipeRefreshLayout.OnRefreshListener onRefreshListener = ((ChannelActivityMyOrganizeBinding) this).f7586a;
        MyOrganizeActivity.a aVar = ((ChannelActivityMyOrganizeBinding) this).f7588a;
        if ((317 & j) != 0) {
            if ((j & 289) == 0) {
                value2 = null;
            } else {
                MutableLiveData<Integer> mutableLiveDataR = myOrganizeVM != null ? myOrganizeVM.r() : null;
                updateLiveDataRegistration(0, mutableLiveDataR);
                if (mutableLiveDataR != null) {
                    value2 = mutableLiveDataR.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 292) == 0) {
                value3 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = myOrganizeVM != null ? myOrganizeVM.i() : null;
                updateLiveDataRegistration(2, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value3 = mutableLiveDataI.getValue();
                } else {
                    value3 = null;
                }
            }
            if ((j & 296) != 0) {
                MutableLiveData<Boolean> mutableLiveDataV = myOrganizeVM != null ? myOrganizeVM.v() : null;
                updateLiveDataRegistration(3, mutableLiveDataV);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataV != null ? mutableLiveDataV.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 304) == 0) {
                value = null;
            } else {
                MutableLiveData<AllOrMyOrganizeAdapter> mutableLiveDataB = myOrganizeVM != null ? myOrganizeVM.B() : null;
                updateLiveDataRegistration(4, mutableLiveDataB);
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
            value3 = null;
        }
        long j2 = 320 & j;
        if (j2 == 0 || onRefreshListener == null) {
            onRefreshListenerImplA = null;
        } else {
            OnRefreshListenerImpl onRefreshListenerImpl = this.f7596a;
            if (onRefreshListenerImpl == null) {
                onRefreshListenerImpl = new OnRefreshListenerImpl();
                this.f7596a = onRefreshListenerImpl;
            }
            onRefreshListenerImplA = onRefreshListenerImpl.a(onRefreshListener);
        }
        long j3 = 384 & j;
        if (j3 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f7597a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f7597a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(((ChannelActivityMyOrganizeBinding) this).f7592a, aVarA, null);
        }
        if ((304 & j) != 0) {
            CommonBindingAdapter.g(((ChannelActivityMyOrganizeBinding) this).f33092a, value, false, false);
        }
        if (j2 != 0) {
            ((ChannelActivityMyOrganizeBinding) this).f7587a.setOnRefreshListener(onRefreshListenerImplA);
        }
        if ((296 & j) != 0) {
            ((ChannelActivityMyOrganizeBinding) this).f7587a.setRefreshing(zSafeUnbox);
        }
        if ((289 & j) != 0) {
            xq8.a(((ChannelActivityMyOrganizeBinding) this).f7591a, value2, null);
        }
        if ((j & 292) != 0) {
            ((ChannelActivityMyOrganizeBinding) this).f7590a.k(value3);
        }
        ViewDataBinding.executeBindingsOn(((ChannelActivityMyOrganizeBinding) this).f7590a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f7594a != 0) {
                return true;
            }
            return ((ChannelActivityMyOrganizeBinding) this).f7590a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7594a = 256L;
        }
        ((ChannelActivityMyOrganizeBinding) this).f7590a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityMyOrganizeBinding
    public void m(@Nullable MyOrganizeActivity.a aVar) {
        ((ChannelActivityMyOrganizeBinding) this).f7588a = aVar;
        synchronized (this) {
            this.f7594a |= 128;
        }
        notifyPropertyChanged(tk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityMyOrganizeBinding
    public void n(@Nullable MyOrganizeVM myOrganizeVM) {
        ((ChannelActivityMyOrganizeBinding) this).f7589a = myOrganizeVM;
        synchronized (this) {
            this.f7594a |= 32;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean o(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7594a |= 2;
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
            return s((MutableLiveData) obj, i2);
        }
        if (i == 3) {
            return q((MutableLiveData) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return p((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<AllOrMyOrganizeAdapter> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7594a |= 16;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7594a |= 8;
        }
        return true;
    }

    public final boolean r(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7594a |= 1;
        }
        return true;
    }

    public final boolean s(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7594a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((ChannelActivityMyOrganizeBinding) this).f7590a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityMyOrganizeBinding
    public void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        ((ChannelActivityMyOrganizeBinding) this).f7586a = onRefreshListener;
        synchronized (this) {
            this.f7594a |= 64;
        }
        notifyPropertyChanged(tk0.R);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 == i) {
            n((MyOrganizeVM) obj);
        } else if (tk0.R == i) {
            setRefresh((SwipeRefreshLayout.OnRefreshListener) obj);
        } else {
            if (tk0.k != i) {
                return false;
            }
            m((MyOrganizeActivity.a) obj);
        }
        return true;
    }

    public ChannelActivityMyOrganizeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (BLTextView) objArr[4], (RecyclerView) objArr[3], (SwipeRefreshLayout) objArr[1], (StateLayout) objArr[2], (LayoutToolbarBindingBinding) objArr[5]);
        this.f7594a = -1L;
        ((ChannelActivityMyOrganizeBinding) this).f7592a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f7595a = linearLayout;
        linearLayout.setTag(null);
        ((ChannelActivityMyOrganizeBinding) this).f33092a.setTag(null);
        ((ChannelActivityMyOrganizeBinding) this).f7587a.setTag(null);
        ((ChannelActivityMyOrganizeBinding) this).f7591a.setTag(null);
        setContainedBinding(((ChannelActivityMyOrganizeBinding) this).f7590a);
        setRootTag(view);
        invalidateAll();
    }
}
