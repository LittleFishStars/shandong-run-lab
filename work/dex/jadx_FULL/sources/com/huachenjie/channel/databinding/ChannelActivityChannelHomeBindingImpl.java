package com.huachenjie.channel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.huachenjie.base.adapter.BaseViewPager2Adapter;
import com.huachenjie.channel.bean.ChannelHomeItemBean;
import com.huachenjie.channel.page.channel_home.ChannelHomeActivity;
import com.huachenjie.channel.page.channel_home.ChannelHomeAdapter;
import com.huachenjie.channel.page.channel_home.ChannelHomeVM;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.noober.background.view.BLView;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelActivityChannelHomeBindingImpl extends ChannelActivityChannelHomeBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33046a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7449a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7450a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f7451a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f7452a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f7453a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ChannelHomeActivity.a f33047a;

        public a a(ChannelHomeActivity.a aVar) {
            this.f33047a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33047a.a(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ChannelHomeActivity.a f33048a;

        public b a(ChannelHomeActivity.a aVar) {
            this.f33048a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33048a.b(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(10);
        f7449a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{5}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33046a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.channel.R.id.fl_ad, 6);
        sparseIntArray.put(com.huachenjie.channel.R.id.joinChannelIcon, 7);
        sparseIntArray.put(com.huachenjie.channel.R.id.createChannelIcon, 8);
        sparseIntArray.put(com.huachenjie.channel.R.id.vSplitLine, 9);
    }

    public ChannelActivityChannelHomeBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, f7449a, f33046a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0037  */
    /* JADX WARN: Code duplicated, block: B:25:0x0055  */
    /* JADX WARN: Code duplicated, block: B:34:0x0071  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        BaseViewPager2Adapter<ChannelHomeItemBean> value;
        BindingTitleBean value2;
        ChannelHomeAdapter value3;
        a aVarA;
        b bVarA;
        synchronized (this) {
            j = this.f7450a;
            this.f7450a = 0L;
        }
        ChannelHomeVM channelHomeVM = ((ChannelActivityChannelHomeBinding) this).f7445a;
        ChannelHomeActivity.a aVar = ((ChannelActivityChannelHomeBinding) this).f7444a;
        if ((93 & j) != 0) {
            if ((j & 81) == 0) {
                value2 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataW = channelHomeVM != null ? channelHomeVM.w() : null;
                updateLiveDataRegistration(0, mutableLiveDataW);
                if (mutableLiveDataW != null) {
                    value2 = mutableLiveDataW.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 84) == 0) {
                value3 = null;
            } else {
                MutableLiveData<ChannelHomeAdapter> mutableLiveDataP = channelHomeVM != null ? channelHomeVM.p() : null;
                updateLiveDataRegistration(2, mutableLiveDataP);
                if (mutableLiveDataP != null) {
                    value3 = mutableLiveDataP.getValue();
                } else {
                    value3 = null;
                }
            }
            if ((j & 88) == 0) {
                value = null;
            } else {
                MutableLiveData<BaseViewPager2Adapter<ChannelHomeItemBean>> mutableLiveDataX = channelHomeVM != null ? channelHomeVM.x() : null;
                updateLiveDataRegistration(3, mutableLiveDataX);
                if (mutableLiveDataX != null) {
                    value = mutableLiveDataX.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            value = null;
            value2 = null;
            value3 = null;
        }
        long j2 = j & 96;
        if (j2 == 0 || aVar == null) {
            aVarA = null;
            bVarA = null;
        } else {
            b bVar = this.f7453a;
            if (bVar == null) {
                bVar = new b();
                this.f7453a = bVar;
            }
            bVarA = bVar.a(aVar);
            a aVar2 = this.f7452a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f7452a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(((ChannelActivityChannelHomeBinding) this).f7447a, aVarA, null);
            CommonBindingAdapter.q(((ChannelActivityChannelHomeBinding) this).f7448b, bVarA, null);
        }
        if ((j & 84) != 0) {
            CommonBindingAdapter.g(((ChannelActivityChannelHomeBinding) this).f7442a, value3, false, false);
        }
        if ((81 & j) != 0) {
            ((ChannelActivityChannelHomeBinding) this).f7446a.k(value2);
        }
        if ((j & 88) != 0) {
            CommonBindingAdapter.t(((ChannelActivityChannelHomeBinding) this).f7443a, value);
        }
        ViewDataBinding.executeBindingsOn(((ChannelActivityChannelHomeBinding) this).f7446a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f7450a != 0) {
                return true;
            }
            return ((ChannelActivityChannelHomeBinding) this).f7446a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7450a = 64L;
        }
        ((ChannelActivityChannelHomeBinding) this).f7446a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityChannelHomeBinding
    public void l(@Nullable ChannelHomeActivity.a aVar) {
        ((ChannelActivityChannelHomeBinding) this).f7444a = aVar;
        synchronized (this) {
            this.f7450a |= 32;
        }
        notifyPropertyChanged(tk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityChannelHomeBinding
    public void m(@Nullable ChannelHomeVM channelHomeVM) {
        ((ChannelActivityChannelHomeBinding) this).f7445a = channelHomeVM;
        synchronized (this) {
            this.f7450a |= 16;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean n(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7450a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<ChannelHomeAdapter> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7450a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return n((LayoutToolbarBindingBinding) obj, i2);
        }
        if (i == 2) {
            return o((MutableLiveData) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return q((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7450a |= 1;
        }
        return true;
    }

    public final boolean q(MutableLiveData<BaseViewPager2Adapter<ChannelHomeItemBean>> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7450a |= 8;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((ChannelActivityChannelHomeBinding) this).f7446a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 == i) {
            m((ChannelHomeVM) obj);
        } else {
            if (tk0.k != i) {
                return false;
            }
            l((ChannelHomeActivity.a) obj);
        }
        return true;
    }

    public ChannelActivityChannelHomeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (BLView) objArr[3], (ImageView) objArr[8], (FrameLayout) objArr[6], (BLView) objArr[2], (ImageView) objArr[7], (RecyclerView) objArr[1], (LayoutToolbarBindingBinding) objArr[5], (BLView) objArr[9], (ViewPager2) objArr[4]);
        this.f7450a = -1L;
        ((ChannelActivityChannelHomeBinding) this).f7447a.setTag(null);
        ((ChannelActivityChannelHomeBinding) this).f7448b.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f7451a = constraintLayout;
        constraintLayout.setTag(null);
        ((ChannelActivityChannelHomeBinding) this).f7442a.setTag(null);
        setContainedBinding(((ChannelActivityChannelHomeBinding) this).f7446a);
        ((ChannelActivityChannelHomeBinding) this).f7443a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
