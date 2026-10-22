package com.huachenjie.home.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.viewpager2.widget.ViewPager2;
import com.bumptech.glide.request.RequestOptions;
import com.flyco.tablayout.SlidingTabLayout2;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.widget.StrokeTextView;
import com.huachenjie.home.bean.reward.ChangeRewardBean;
import com.huachenjie.home.bean.reward.LotteryThemeConfig;
import com.huachenjie.home.page.change_reward.ChangeRewardActivity;
import com.huachenjie.home.page.change_reward.ChangeRewardVM;
import com.noober.background.view.BLRelativeLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.ju3;
import com.zj.adlib.xk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class HomeActivityChangeRewardBindingImpl extends HomeActivityChangeRewardBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34200a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9272a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9273a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f9274a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f9275a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f9276a;

    @NonNull
    public final BLTextView c;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ChangeRewardActivity.a f34201a;

        public a a(ChangeRewardActivity.a aVar) {
            this.f34201a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34201a.c(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ChangeRewardActivity.a f34202a;

        public b a(ChangeRewardActivity.a aVar) {
            this.f34202a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34202a.b(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(11);
        f9272a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{5}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34200a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.home.R.id.rl_bottom, 6);
        sparseIntArray.put(com.huachenjie.home.R.id.tabLayout, 7);
        sparseIntArray.put(com.huachenjie.home.R.id.tv_tip, 8);
        sparseIntArray.put(com.huachenjie.home.R.id.v_ind, 9);
        sparseIntArray.put(com.huachenjie.home.R.id.viewPager, 10);
    }

    public HomeActivityChangeRewardBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, f9272a, f34200a));
    }

    /* JADX WARN: Code duplicated, block: B:25:0x004e  */
    /* JADX WARN: Code duplicated, block: B:34:0x006b  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        BindingTitleBean value;
        String logoUrl;
        String themeDesc;
        a aVarA;
        b bVarA;
        synchronized (this) {
            j = this.f9273a;
            this.f9273a = 0L;
        }
        ChangeRewardVM changeRewardVM = ((HomeActivityChangeRewardBinding) this).f9268a;
        ChangeRewardActivity.a aVar = ((HomeActivityChangeRewardBinding) this).f9267a;
        long j2 = 42 & j;
        RequestOptions requestOptions = j2 != 0 ? ju3.h : null;
        if ((46 & j) != 0) {
            if (j2 == 0) {
                logoUrl = null;
                themeDesc = null;
            } else {
                MutableLiveData<ChangeRewardBean> mutableLiveDataJ = changeRewardVM != null ? changeRewardVM.j() : null;
                updateLiveDataRegistration(1, mutableLiveDataJ);
                ChangeRewardBean value2 = mutableLiveDataJ != null ? mutableLiveDataJ.getValue() : null;
                LotteryThemeConfig lotteryThemeConfig = value2 != null ? value2.getLotteryThemeConfig() : null;
                if (lotteryThemeConfig != null) {
                    themeDesc = lotteryThemeConfig.getThemeDesc();
                    logoUrl = lotteryThemeConfig.getLogoUrl();
                } else {
                    logoUrl = null;
                    themeDesc = null;
                }
            }
            if ((j & 44) == 0) {
                value = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = changeRewardVM != null ? changeRewardVM.i() : null;
                updateLiveDataRegistration(2, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value = mutableLiveDataI.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            value = null;
            logoUrl = null;
            themeDesc = null;
        }
        long j3 = 48 & j;
        if (j3 == 0 || aVar == null) {
            aVarA = null;
            bVarA = null;
        } else {
            b bVar = this.f9276a;
            if (bVar == null) {
                bVar = new b();
                this.f9276a = bVar;
            }
            bVarA = bVar.a(aVar);
            a aVar2 = this.f9275a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f9275a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            CommonBindingAdapter.b0(((HomeActivityChangeRewardBinding) this).f34199a, logoUrl, requestOptions, false);
            TextViewBindingAdapter.setText(((HomeActivityChangeRewardBinding) this).f9266a, themeDesc);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.c, bVarA, null);
            CommonBindingAdapter.q(((HomeActivityChangeRewardBinding) this).f9270a, aVarA, null);
        }
        if ((j & 44) != 0) {
            ((HomeActivityChangeRewardBinding) this).f9265a.k(value);
        }
        ViewDataBinding.executeBindingsOn(((HomeActivityChangeRewardBinding) this).f9265a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9273a != 0) {
                return true;
            }
            return ((HomeActivityChangeRewardBinding) this).f9265a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9273a = 32L;
        }
        ((HomeActivityChangeRewardBinding) this).f9265a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeActivityChangeRewardBinding
    public void l(@Nullable ChangeRewardActivity.a aVar) {
        ((HomeActivityChangeRewardBinding) this).f9267a = aVar;
        synchronized (this) {
            this.f9273a |= 16;
        }
        notifyPropertyChanged(xk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeActivityChangeRewardBinding
    public void m(@Nullable ChangeRewardVM changeRewardVM) {
        ((HomeActivityChangeRewardBinding) this).f9268a = changeRewardVM;
        synchronized (this) {
            this.f9273a |= 8;
        }
        notifyPropertyChanged(xk0.p0);
        super.requestRebind();
    }

    public final boolean n(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9273a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<ChangeRewardBean> mutableLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9273a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((LayoutToolbarBindingBinding) obj, i2);
        }
        if (i == 1) {
            return o((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return p((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9273a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((HomeActivityChangeRewardBinding) this).f9265a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (xk0.p0 == i) {
            m((ChangeRewardVM) obj);
        } else {
            if (xk0.k != i) {
                return false;
            }
            l((ChangeRewardActivity.a) obj);
        }
        return true;
    }

    public HomeActivityChangeRewardBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (ImageView) objArr[1], (BLRelativeLayout) objArr[6], (SlidingTabLayout2) objArr[7], (LayoutToolbarBindingBinding) objArr[5], (StrokeTextView) objArr[2], (BLTextView) objArr[3], (BLTextView) objArr[8], (ImageView) objArr[9], (ViewPager2) objArr[10]);
        this.f9273a = -1L;
        ((HomeActivityChangeRewardBinding) this).f34199a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f9274a = constraintLayout;
        constraintLayout.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[4];
        this.c = bLTextView;
        bLTextView.setTag(null);
        setContainedBinding(((HomeActivityChangeRewardBinding) this).f9265a);
        ((HomeActivityChangeRewardBinding) this).f9266a.setTag(null);
        ((HomeActivityChangeRewardBinding) this).f9270a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
