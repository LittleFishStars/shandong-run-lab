package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
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
import com.huachenjie.mall.page.address.reward.RewardShippingAddressActivity;
import com.huachenjie.mall.page.address.reward.RewardShippingAddressAdapter;
import com.huachenjie.mall.page.address.reward.RewardShippingAddressVM;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallActivityRewardShippingAddressBindingImpl extends MallActivityRewardShippingAddressBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34851a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10376a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10377a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f10378a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10379a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwipeRefreshLayout f10380a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnRefreshListenerImpl f10381a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f10382a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f10383a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f10384a;

    public static class OnRefreshListenerImpl implements SwipeRefreshLayout.OnRefreshListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SwipeRefreshLayout.OnRefreshListener f34852a;

        public OnRefreshListenerImpl a(SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
            this.f34852a = onRefreshListener;
            if (onRefreshListener == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            this.f34852a.onRefresh();
        }
    }

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RewardShippingAddressActivity.a f34853a;

        public a a(RewardShippingAddressActivity.a aVar) {
            this.f34853a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34853a.a(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(7);
        f10376a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{6}, new int[]{R.layout.layout_toolbar_binding});
        f34851a = null;
    }

    public MallActivityRewardShippingAddressBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f10376a, f34851a));
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0065  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a5  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zSafeUnbox;
        boolean zSafeUnbox2;
        RewardShippingAddressAdapter value;
        BindingTitleBean value2;
        OnRefreshListenerImpl onRefreshListenerImplA;
        a aVarA;
        synchronized (this) {
            j = this.f10377a;
            this.f10377a = 0L;
        }
        RewardShippingAddressVM rewardShippingAddressVM = ((MallActivityRewardShippingAddressBinding) this).f10375a;
        SwipeRefreshLayout.OnRefreshListener onRefreshListener = ((MallActivityRewardShippingAddressBinding) this).f10372a;
        RewardShippingAddressActivity.a aVar = ((MallActivityRewardShippingAddressBinding) this).f10374a;
        if ((315 & j) != 0) {
            if ((j & 289) != 0) {
                MutableLiveData<Boolean> mutableLiveDataO = rewardShippingAddressVM != null ? rewardShippingAddressVM.o() : null;
                updateLiveDataRegistration(0, mutableLiveDataO);
                zSafeUnbox = ViewDataBinding.safeUnbox(Boolean.valueOf(!ViewDataBinding.safeUnbox(mutableLiveDataO != null ? mutableLiveDataO.getValue() : null)));
            } else {
                zSafeUnbox = false;
            }
            if ((j & 290) == 0) {
                value2 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = rewardShippingAddressVM != null ? rewardShippingAddressVM.i() : null;
                updateLiveDataRegistration(1, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value2 = mutableLiveDataI.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 296) != 0) {
                MutableLiveData<Boolean> mutableLiveDataP = rewardShippingAddressVM != null ? rewardShippingAddressVM.p() : null;
                updateLiveDataRegistration(3, mutableLiveDataP);
                zSafeUnbox2 = ViewDataBinding.safeUnbox(mutableLiveDataP != null ? mutableLiveDataP.getValue() : null);
            } else {
                zSafeUnbox2 = false;
            }
            if ((j & 304) == 0) {
                value = null;
            } else {
                MutableLiveData<RewardShippingAddressAdapter> mutableLiveDataK = rewardShippingAddressVM != null ? rewardShippingAddressVM.k() : null;
                updateLiveDataRegistration(4, mutableLiveDataK);
                if (mutableLiveDataK != null) {
                    value = mutableLiveDataK.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            zSafeUnbox = false;
            zSafeUnbox2 = false;
            value = null;
            value2 = null;
        }
        long j2 = j & 320;
        if (j2 == 0 || onRefreshListener == null) {
            onRefreshListenerImplA = null;
        } else {
            OnRefreshListenerImpl onRefreshListenerImpl = this.f10381a;
            if (onRefreshListenerImpl == null) {
                onRefreshListenerImpl = new OnRefreshListenerImpl();
                this.f10381a = onRefreshListenerImpl;
            }
            onRefreshListenerImplA = onRefreshListenerImpl.a(onRefreshListener);
        }
        long j3 = j & 384;
        if (j3 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f10382a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f10382a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            this.f10380a.setOnRefreshListener(onRefreshListenerImplA);
        }
        if ((296 & j) != 0) {
            this.f10380a.setRefreshing(zSafeUnbox2);
        }
        if ((289 & j) != 0) {
            CommonBindingAdapter.l0(this.f10384a, zSafeUnbox);
            CommonBindingAdapter.l0(this.f10378a, zSafeUnbox);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.f10383a, aVarA, null);
        }
        if ((304 & j) != 0) {
            CommonBindingAdapter.g(((MallActivityRewardShippingAddressBinding) this).f34850a, value, false, false);
        }
        if ((j & 290) != 0) {
            ((MallActivityRewardShippingAddressBinding) this).f10373a.k(value2);
        }
        ViewDataBinding.executeBindingsOn(((MallActivityRewardShippingAddressBinding) this).f10373a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10377a != 0) {
                return true;
            }
            return ((MallActivityRewardShippingAddressBinding) this).f10373a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10377a = 256L;
        }
        ((MallActivityRewardShippingAddressBinding) this).f10373a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityRewardShippingAddressBinding
    public void m(@Nullable RewardShippingAddressActivity.a aVar) {
        ((MallActivityRewardShippingAddressBinding) this).f10374a = aVar;
        synchronized (this) {
            this.f10377a |= 128;
        }
        notifyPropertyChanged(hk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityRewardShippingAddressBinding
    public void n(@Nullable RewardShippingAddressVM rewardShippingAddressVM) {
        ((MallActivityRewardShippingAddressBinding) this).f10375a = rewardShippingAddressVM;
        synchronized (this) {
            this.f10377a |= 32;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean o(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10377a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return r((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return s((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return o((LayoutToolbarBindingBinding) obj, i2);
        }
        if (i == 3) {
            return q((MutableLiveData) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return p((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<RewardShippingAddressAdapter> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10377a |= 16;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10377a |= 8;
        }
        return true;
    }

    public final boolean r(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10377a |= 1;
        }
        return true;
    }

    public final boolean s(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10377a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((MallActivityRewardShippingAddressBinding) this).f10373a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // com.huachenjie.mall.databinding.MallActivityRewardShippingAddressBinding
    public void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        ((MallActivityRewardShippingAddressBinding) this).f10372a = onRefreshListener;
        synchronized (this) {
            this.f10377a |= 64;
        }
        notifyPropertyChanged(hk0.R);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 == i) {
            n((RewardShippingAddressVM) obj);
        } else if (hk0.R == i) {
            setRefresh((SwipeRefreshLayout.OnRefreshListener) obj);
        } else {
            if (hk0.k != i) {
                return false;
            }
            m((RewardShippingAddressActivity.a) obj);
        }
        return true;
    }

    public MallActivityRewardShippingAddressBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (RecyclerView) objArr[2], (LayoutToolbarBindingBinding) objArr[6]);
        this.f10377a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f10379a = linearLayout;
        linearLayout.setTag(null);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) objArr[1];
        this.f10380a = swipeRefreshLayout;
        swipeRefreshLayout.setTag(null);
        BLView bLView = (BLView) objArr[3];
        this.f10384a = bLView;
        bLView.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[4];
        this.f10378a = frameLayout;
        frameLayout.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[5];
        this.f10383a = bLTextView;
        bLTextView.setTag(null);
        ((MallActivityRewardShippingAddressBinding) this).f34850a.setTag(null);
        setContainedBinding(((MallActivityRewardShippingAddressBinding) this).f10373a);
        setRootTag(view);
        invalidateAll();
    }
}
