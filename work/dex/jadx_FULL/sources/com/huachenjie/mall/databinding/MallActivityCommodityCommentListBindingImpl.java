package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.SlidingTabLayout;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallActivityCommodityCommentListBindingImpl extends MallActivityCommodityCommentListBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34784a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10180a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10181a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10182a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(4);
        f10180a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{1}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34784a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.mall.R.id.tabLayout, 2);
        sparseIntArray.put(com.huachenjie.mall.R.id.viewPager, 3);
    }

    public MallActivityCommodityCommentListBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f10180a, f34784a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f10181a;
            this.f10181a = 0L;
        }
        BaseTitleViewModel baseTitleViewModel = ((MallActivityCommodityCommentListBinding) this).f10179a;
        long j2 = j & 13;
        BindingTitleBean value = null;
        if (j2 != 0) {
            MutableLiveData<BindingTitleBean> mutableLiveDataI = baseTitleViewModel != null ? baseTitleViewModel.i() : null;
            updateLiveDataRegistration(0, mutableLiveDataI);
            if (mutableLiveDataI != null) {
                value = mutableLiveDataI.getValue();
            }
        }
        if (j2 != 0) {
            ((MallActivityCommodityCommentListBinding) this).f10178a.k(value);
        }
        ViewDataBinding.executeBindingsOn(((MallActivityCommodityCommentListBinding) this).f10178a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10181a != 0) {
                return true;
            }
            return ((MallActivityCommodityCommentListBinding) this).f10178a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10181a = 8L;
        }
        ((MallActivityCommodityCommentListBinding) this).f10178a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityCommodityCommentListBinding
    public void k(@Nullable BaseTitleViewModel baseTitleViewModel) {
        ((MallActivityCommodityCommentListBinding) this).f10179a = baseTitleViewModel;
        synchronized (this) {
            this.f10181a |= 4;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean l(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10181a |= 2;
        }
        return true;
    }

    public final boolean m(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10181a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return m((MutableLiveData) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return l((LayoutToolbarBindingBinding) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((MallActivityCommodityCommentListBinding) this).f10178a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 != i) {
            return false;
        }
        k((BaseTitleViewModel) obj);
        return true;
    }

    public MallActivityCommodityCommentListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (SlidingTabLayout) objArr[2], (LayoutToolbarBindingBinding) objArr[1], (ViewPager) objArr[3]);
        this.f10181a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f10182a = linearLayout;
        linearLayout.setTag(null);
        setContainedBinding(((MallActivityCommodityCommentListBinding) this).f10178a);
        setRootTag(view);
        invalidateAll();
    }
}
