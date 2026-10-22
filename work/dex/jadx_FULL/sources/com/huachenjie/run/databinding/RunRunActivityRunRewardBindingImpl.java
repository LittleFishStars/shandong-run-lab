package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.CommonTabLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.run.page.run_reward.RunRewardVM;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunRunActivityRunRewardBindingImpl extends RunRunActivityRunRewardBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35742a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12298a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12299a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CoordinatorLayout f12300a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(20);
        f12298a = includedLayouts;
        includedLayouts.setIncludes(4, new String[]{"layout_toolbar_binding"}, new int[]{5}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35742a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.run.R.id.app_bar, 6);
        sparseIntArray.put(com.huachenjie.run.R.id.iv_mask, 7);
        sparseIntArray.put(com.huachenjie.run.R.id.iv_star, 8);
        sparseIntArray.put(com.huachenjie.run.R.id.tv_page_title, 9);
        sparseIntArray.put(com.huachenjie.run.R.id.tv_distance_label, 10);
        sparseIntArray.put(com.huachenjie.run.R.id.tv_distance_unit, 11);
        sparseIntArray.put(com.huachenjie.run.R.id.v_stats_divider, 12);
        sparseIntArray.put(com.huachenjie.run.R.id.tv_times_label, 13);
        sparseIntArray.put(com.huachenjie.run.R.id.tv_times_unit, 14);
        sparseIntArray.put(com.huachenjie.run.R.id.ll_tab_sticky, 15);
        sparseIntArray.put(com.huachenjie.run.R.id.ll_content, 16);
        sparseIntArray.put(com.huachenjie.run.R.id.ll_tab_header, 17);
        sparseIntArray.put(com.huachenjie.run.R.id.tabLayout, 18);
        sparseIntArray.put(com.huachenjie.run.R.id.viewPager, 19);
    }

    public RunRunActivityRunRewardBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 20, f12298a, f35742a));
    }

    /* JADX WARN: Code duplicated, block: B:29:0x006a  */
    /* JADX WARN: Code duplicated, block: B:38:0x0086  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a7  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int i;
        String value;
        String value2;
        BindingTitleBean bindingTitleBean;
        BindingTitleBean value3;
        synchronized (this) {
            j = this.f12299a;
            this.f12299a = 0L;
        }
        RunRewardVM runRewardVM = ((RunRunActivityRunRewardBinding) this).f12294a;
        int iSafeUnbox = 0;
        if ((126 & j) != 0) {
            if ((j & 112) != 0) {
                BaseViewModel.b bVarE = runRewardVM != null ? runRewardVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                updateLiveDataRegistration(4, mutableLiveDataB);
                iSafeUnbox = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null) + 24));
            }
            if ((j & 98) == 0) {
                value2 = null;
            } else {
                MutableLiveData<String> mutableLiveDataK = runRewardVM != null ? runRewardVM.k() : null;
                updateLiveDataRegistration(1, mutableLiveDataK);
                if (mutableLiveDataK != null) {
                    value2 = mutableLiveDataK.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 100) == 0) {
                value3 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = runRewardVM != null ? runRewardVM.i() : null;
                updateLiveDataRegistration(2, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value3 = mutableLiveDataI.getValue();
                } else {
                    value3 = null;
                }
            }
            if ((j & 104) == 0) {
                bindingTitleBean = value3;
                i = iSafeUnbox;
                value = null;
            } else {
                MutableLiveData<String> mutableLiveDataJ = runRewardVM != null ? runRewardVM.j() : null;
                updateLiveDataRegistration(3, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value = mutableLiveDataJ.getValue();
                    i = iSafeUnbox;
                    bindingTitleBean = value3;
                } else {
                    bindingTitleBean = value3;
                    i = iSafeUnbox;
                    value = null;
                }
            }
        } else {
            i = 0;
            value = null;
            value2 = null;
            bindingTitleBean = null;
        }
        if ((j & 112) != 0) {
            CommonBindingAdapter.O(((RunRunActivityRunRewardBinding) this).f12287a, 0, i, 0, 0, null);
        }
        if ((j & 100) != 0) {
            ((RunRunActivityRunRewardBinding) this).f12293a.k(bindingTitleBean);
        }
        if ((104 & j) != 0) {
            TextViewBindingAdapter.setText(((RunRunActivityRunRewardBinding) this).f12288a, value);
        }
        if ((j & 98) != 0) {
            TextViewBindingAdapter.setText(this.e, value2);
        }
        ViewDataBinding.executeBindingsOn(((RunRunActivityRunRewardBinding) this).f12293a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f12299a != 0) {
                return true;
            }
            return ((RunRunActivityRunRewardBinding) this).f12293a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12299a = 64L;
        }
        ((RunRunActivityRunRewardBinding) this).f12293a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunRunActivityRunRewardBinding
    public void k(@Nullable RunRewardVM Vm) {
        ((RunRunActivityRunRewardBinding) this).f12294a = Vm;
        synchronized (this) {
            this.f12299a |= 32;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean l(LayoutToolbarBindingBinding Toolbar, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12299a |= 1;
        }
        return true;
    }

    public final boolean m(MutableLiveData<String> VmRewardDistance, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12299a |= 8;
        }
        return true;
    }

    public final boolean n(MutableLiveData<String> VmRewardTimes, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12299a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<BindingTitleBean> VmTitleBean, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12299a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return l((LayoutToolbarBindingBinding) object, fieldId);
        }
        if (localFieldId == 1) {
            return n((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 2) {
            return o((MutableLiveData) object, fieldId);
        }
        if (localFieldId == 3) {
            return m((MutableLiveData) object, fieldId);
        }
        if (localFieldId != 4) {
            return false;
        }
        return p((MutableLiveData) object, fieldId);
    }

    public final boolean p(MutableLiveData<Integer> VmUiLiveDataStatusBarHeight, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12299a |= 16;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((RunRunActivityRunRewardBinding) this).f12293a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 != variableId) {
            return false;
        }
        k((RunRewardVM) variable);
        return true;
    }

    public RunRunActivityRunRewardBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 5, (AppBarLayout) bindings[6], (RelativeLayout) bindings[1], (ImageView) bindings[7], (ImageView) bindings[8], (BLLinearLayout) bindings[16], (LinearLayout) bindings[17], (LinearLayout) bindings[15], (CommonTabLayout) bindings[18], (Toolbar) bindings[4], (LayoutToolbarBindingBinding) bindings[5], (TextView) bindings[2], (TextView) bindings[10], (TextView) bindings[11], (TextView) bindings[9], (TextView) bindings[3], (TextView) bindings[13], (TextView) bindings[14], (View) bindings[12], (ViewPager) bindings[19]);
        this.f12299a = -1L;
        ((RunRunActivityRunRewardBinding) this).f12287a.setTag(null);
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) bindings[0];
        this.f12300a = coordinatorLayout;
        coordinatorLayout.setTag(null);
        ((RunRunActivityRunRewardBinding) this).f12289a.setTag(null);
        setContainedBinding(((RunRunActivityRunRewardBinding) this).f12293a);
        ((RunRunActivityRunRewardBinding) this).f12288a.setTag(null);
        this.e.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
