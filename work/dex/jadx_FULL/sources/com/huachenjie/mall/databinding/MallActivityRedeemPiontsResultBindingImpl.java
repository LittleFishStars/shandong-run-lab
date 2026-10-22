package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.mall.page.redeem_points.RedeemPointsResultActivity;
import com.noober.background.view.BLTextView;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallActivityRedeemPiontsResultBindingImpl extends MallActivityRedeemPiontsResultBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34837a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10334a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10335a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f10336a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f10337a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RedeemPointsResultActivity.a f34838a;

        public a a(RedeemPointsResultActivity.a aVar) {
            this.f34838a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34838a.a(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(4);
        f10334a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{2}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34837a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.mall.R.id.tv_desc, 3);
    }

    public MallActivityRedeemPiontsResultBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f10334a, f34837a));
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0029  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        BindingTitleBean value;
        a aVarA;
        synchronized (this) {
            j = this.f10335a;
            this.f10335a = 0L;
        }
        BaseTitleViewModel baseTitleViewModel = ((MallActivityRedeemPiontsResultBinding) this).f10331a;
        RedeemPointsResultActivity.a aVar = ((MallActivityRedeemPiontsResultBinding) this).f10332a;
        long j2 = 21 & j;
        if (j2 == 0) {
            value = null;
        } else {
            MutableLiveData<BindingTitleBean> mutableLiveDataI = baseTitleViewModel != null ? baseTitleViewModel.i() : null;
            updateLiveDataRegistration(0, mutableLiveDataI);
            if (mutableLiveDataI != null) {
                value = mutableLiveDataI.getValue();
            } else {
                value = null;
            }
        }
        long j3 = j & 24;
        if (j3 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f10337a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f10337a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            ((MallActivityRedeemPiontsResultBinding) this).f10330a.k(value);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(((MallActivityRedeemPiontsResultBinding) this).f10333a, aVarA, null);
        }
        ViewDataBinding.executeBindingsOn(((MallActivityRedeemPiontsResultBinding) this).f10330a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10335a != 0) {
                return true;
            }
            return ((MallActivityRedeemPiontsResultBinding) this).f10330a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10335a = 16L;
        }
        ((MallActivityRedeemPiontsResultBinding) this).f10330a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityRedeemPiontsResultBinding
    public void l(@Nullable RedeemPointsResultActivity.a aVar) {
        ((MallActivityRedeemPiontsResultBinding) this).f10332a = aVar;
        synchronized (this) {
            this.f10335a |= 8;
        }
        notifyPropertyChanged(hk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityRedeemPiontsResultBinding
    public void m(@Nullable BaseTitleViewModel baseTitleViewModel) {
        ((MallActivityRedeemPiontsResultBinding) this).f10331a = baseTitleViewModel;
        synchronized (this) {
            this.f10335a |= 4;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean n(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10335a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10335a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return o((MutableLiveData) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return n((LayoutToolbarBindingBinding) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((MallActivityRedeemPiontsResultBinding) this).f10330a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 == i) {
            m((BaseTitleViewModel) obj);
        } else {
            if (hk0.k != i) {
                return false;
            }
            l((RedeemPointsResultActivity.a) obj);
        }
        return true;
    }

    public MallActivityRedeemPiontsResultBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (LayoutToolbarBindingBinding) objArr[2], (TextView) objArr[3], (BLTextView) objArr[1]);
        this.f10335a = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f10336a = relativeLayout;
        relativeLayout.setTag(null);
        setContainedBinding(((MallActivityRedeemPiontsResultBinding) this).f10330a);
        ((MallActivityRedeemPiontsResultBinding) this).f10333a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
