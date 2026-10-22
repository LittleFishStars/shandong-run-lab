package com.huachenjie.mall.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.ImageViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.mall.page.express.ExpressLogisticsAdapter;
import com.huachenjie.mall.page.express.ExpressLogisticsVm;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallActivityExpressLogisticsBindingImpl extends MallActivityExpressLogisticsBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34796a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10220a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10221a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f10222a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f10223a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10224a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(5);
        f10220a = includedLayouts;
        includedLayouts.setIncludes(2, new String[]{"layout_toolbar_binding"}, new int[]{4}, new int[]{R.layout.layout_toolbar_binding});
        f34796a = null;
    }

    public MallActivityExpressLogisticsBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f10220a, f34796a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0034  */
    /* JADX WARN: Code duplicated, block: B:45:0x0098  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        ExpressLogisticsAdapter value;
        BindingTitleBean value2;
        Drawable drawable;
        Drawable drawable2;
        Context context;
        int i;
        synchronized (this) {
            j = this.f10221a;
            this.f10221a = 0L;
        }
        ExpressLogisticsVm expressLogisticsVm = ((MallActivityExpressLogisticsBinding) this).f10219a;
        if ((59 & j) != 0) {
            if ((j & 49) == 0) {
                value2 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataM = expressLogisticsVm != null ? expressLogisticsVm.m() : null;
                updateLiveDataRegistration(0, mutableLiveDataM);
                if (mutableLiveDataM != null) {
                    value2 = mutableLiveDataM.getValue();
                } else {
                    value2 = null;
                }
            }
            long j2 = j & 50;
            if (j2 != 0) {
                MutableLiveData<Boolean> mutableLiveDataN = expressLogisticsVm != null ? expressLogisticsVm.n() : null;
                updateLiveDataRegistration(1, mutableLiveDataN);
                boolean zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataN != null ? mutableLiveDataN.getValue() : null);
                if (j2 != 0) {
                    j |= zSafeUnbox ? 128L : 64L;
                }
                if (zSafeUnbox) {
                    context = this.f10223a.getContext();
                    i = com.huachenjie.mall.R.drawable.mall_bg_reward_express_logistics_head;
                } else {
                    context = this.f10223a.getContext();
                    i = com.huachenjie.mall.R.drawable.mall_bg_express_logistics_head;
                }
                drawable2 = AppCompatResources.getDrawable(context, i);
            } else {
                drawable2 = null;
            }
            if ((j & 56) == 0) {
                drawable = drawable2;
                value = null;
            } else {
                MutableLiveData<ExpressLogisticsAdapter> mutableLiveDataJ = expressLogisticsVm != null ? expressLogisticsVm.j() : null;
                updateLiveDataRegistration(3, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value = mutableLiveDataJ.getValue();
                    drawable = drawable2;
                } else {
                    drawable = drawable2;
                    value = null;
                }
            }
        } else {
            value = null;
            value2 = null;
            drawable = null;
        }
        if ((j & 50) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.f10223a, drawable);
        }
        if ((56 & j) != 0) {
            CommonBindingAdapter.g(((MallActivityExpressLogisticsBinding) this).f34795a, value, false, false);
        }
        if ((j & 49) != 0) {
            ((MallActivityExpressLogisticsBinding) this).f10218a.k(value2);
        }
        ViewDataBinding.executeBindingsOn(((MallActivityExpressLogisticsBinding) this).f10218a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10221a != 0) {
                return true;
            }
            return ((MallActivityExpressLogisticsBinding) this).f10218a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10221a = 32L;
        }
        ((MallActivityExpressLogisticsBinding) this).f10218a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityExpressLogisticsBinding
    public void k(@Nullable ExpressLogisticsVm expressLogisticsVm) {
        ((MallActivityExpressLogisticsBinding) this).f10219a = expressLogisticsVm;
        synchronized (this) {
            this.f10221a |= 16;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean l(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10221a |= 4;
        }
        return true;
    }

    public final boolean m(MutableLiveData<ExpressLogisticsAdapter> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10221a |= 8;
        }
        return true;
    }

    public final boolean n(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10221a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10221a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return o((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return n((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return l((LayoutToolbarBindingBinding) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return m((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((MallActivityExpressLogisticsBinding) this).f10218a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 != i) {
            return false;
        }
        k((ExpressLogisticsVm) obj);
        return true;
    }

    public MallActivityExpressLogisticsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (RecyclerView) objArr[3], (LayoutToolbarBindingBinding) objArr[4]);
        this.f10221a = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f10222a = frameLayout;
        frameLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f10223a = imageView;
        imageView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[2];
        this.f10224a = linearLayout;
        linearLayout.setTag(null);
        ((MallActivityExpressLogisticsBinding) this).f34795a.setTag(null);
        setContainedBinding(((MallActivityExpressLogisticsBinding) this).f10218a);
        setRootTag(view);
        invalidateAll();
    }
}
