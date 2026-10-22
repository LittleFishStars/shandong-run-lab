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
import androidx.viewpager2.widget.ViewPager2;
import com.huachenjie.channel.page.notify.broad_build.NotifyBroadBuildVM;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.widget.SelectBoldTabLayout;
import com.noober.background.view.BLView;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelActivityNotifyBuildBindingImpl extends ChannelActivityNotifyBuildBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33099a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7607a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7608a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f7609a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(5);
        f7607a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{1}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33099a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.channel.R.id.tab_layout, 2);
        sparseIntArray.put(com.huachenjie.channel.R.id.view_pager, 3);
        sparseIntArray.put(com.huachenjie.channel.R.id.v_line, 4);
    }

    public ChannelActivityNotifyBuildBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f7607a, f33099a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f7608a;
            this.f7608a = 0L;
        }
        NotifyBroadBuildVM notifyBroadBuildVM = ((ChannelActivityNotifyBuildBinding) this).f7603a;
        long j2 = j & 13;
        BindingTitleBean value = null;
        if (j2 != 0) {
            MutableLiveData<BindingTitleBean> mutableLiveDataI = notifyBroadBuildVM != null ? notifyBroadBuildVM.i() : null;
            updateLiveDataRegistration(0, mutableLiveDataI);
            if (mutableLiveDataI != null) {
                value = mutableLiveDataI.getValue();
            }
        }
        if (j2 != 0) {
            ((ChannelActivityNotifyBuildBinding) this).f7604a.k(value);
        }
        ViewDataBinding.executeBindingsOn(((ChannelActivityNotifyBuildBinding) this).f7604a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f7608a != 0) {
                return true;
            }
            return ((ChannelActivityNotifyBuildBinding) this).f7604a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7608a = 8L;
        }
        ((ChannelActivityNotifyBuildBinding) this).f7604a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityNotifyBuildBinding
    public void k(@Nullable NotifyBroadBuildVM notifyBroadBuildVM) {
        ((ChannelActivityNotifyBuildBinding) this).f7603a = notifyBroadBuildVM;
        synchronized (this) {
            this.f7608a |= 4;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean l(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7608a |= 2;
        }
        return true;
    }

    public final boolean m(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7608a |= 1;
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
        ((ChannelActivityNotifyBuildBinding) this).f7604a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 != i) {
            return false;
        }
        k((NotifyBroadBuildVM) obj);
        return true;
    }

    public ChannelActivityNotifyBuildBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (SelectBoldTabLayout) objArr[2], (LayoutToolbarBindingBinding) objArr[1], (BLView) objArr[4], (ViewPager2) objArr[3]);
        this.f7608a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f7609a = linearLayout;
        linearLayout.setTag(null);
        setContainedBinding(((ChannelActivityNotifyBuildBinding) this).f7604a);
        setRootTag(view);
        invalidateAll();
    }
}
