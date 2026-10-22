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
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.mall.page.pay.RewardPaySucActivity;
import com.huachenjie.mall.page.pay.RewardPaySucVM;
import com.noober.background.view.BLTextView;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallActivityRewardPaySucBindingImpl extends MallActivityRewardPaySucBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34847a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10365a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10366a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f10367a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10368a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f10369a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f10370a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f10371a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RewardPaySucActivity.a f34848a;

        public a a(RewardPaySucActivity.a aVar) {
            this.f34848a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34848a.a(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RewardPaySucActivity.a f34849a;

        public b a(RewardPaySucActivity.a aVar) {
            this.f34849a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34849a.b(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(5);
        f10365a = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"layout_toolbar_binding"}, new int[]{4}, new int[]{R.layout.layout_toolbar_binding});
        f34847a = null;
    }

    public MallActivityRewardPaySucBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f10365a, f34847a));
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0029  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        BindingTitleBean value;
        b bVarA;
        a aVarA;
        synchronized (this) {
            j = this.f10366a;
            this.f10366a = 0L;
        }
        RewardPaySucVM rewardPaySucVM = ((MallActivityRewardPaySucBinding) this).f10363a;
        RewardPaySucActivity.a aVar = ((MallActivityRewardPaySucBinding) this).f34846a;
        long j2 = 11 & j;
        if (j2 == 0) {
            value = null;
        } else {
            MutableLiveData<BindingTitleBean> mutableLiveDataI = rewardPaySucVM != null ? rewardPaySucVM.i() : null;
            updateLiveDataRegistration(0, mutableLiveDataI);
            if (mutableLiveDataI != null) {
                value = mutableLiveDataI.getValue();
            } else {
                value = null;
            }
        }
        long j3 = j & 12;
        if (j3 == 0 || aVar == null) {
            bVarA = null;
            aVarA = null;
        } else {
            b bVar = this.f10371a;
            if (bVar == null) {
                bVar = new b();
                this.f10371a = bVar;
            }
            bVarA = bVar.a(aVar);
            a aVar2 = this.f10370a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f10370a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            this.f10369a.k(value);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(((MallActivityRewardPaySucBinding) this).f10364a, aVarA, null);
            CommonBindingAdapter.q(this.b, bVarA, null);
        }
        ViewDataBinding.executeBindingsOn(this.f10369a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10366a != 0) {
                return true;
            }
            return this.f10369a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10366a = 8L;
        }
        this.f10369a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityRewardPaySucBinding
    public void l(@Nullable RewardPaySucActivity.a aVar) {
        ((MallActivityRewardPaySucBinding) this).f34846a = aVar;
        synchronized (this) {
            this.f10366a |= 4;
        }
        notifyPropertyChanged(hk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityRewardPaySucBinding
    public void m(@Nullable RewardPaySucVM rewardPaySucVM) {
        ((MallActivityRewardPaySucBinding) this).f10363a = rewardPaySucVM;
        synchronized (this) {
            this.f10366a |= 2;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10366a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f10369a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 == i) {
            m((RewardPaySucVM) obj);
        } else {
            if (hk0.k != i) {
                return false;
            }
            l((RewardPaySucActivity.a) obj);
        }
        return true;
    }

    public MallActivityRewardPaySucBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (BLTextView) objArr[3], (BLTextView) objArr[2]);
        this.f10366a = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f10367a = frameLayout;
        frameLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[1];
        this.f10368a = linearLayout;
        linearLayout.setTag(null);
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[4];
        this.f10369a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        ((MallActivityRewardPaySucBinding) this).f10364a.setTag(null);
        this.b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
