package com.huachenjie.im.databinding;

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
import com.huachenjie.common.R;
import com.huachenjie.common.base.data_binding.BaseTitleVM;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.zj.adlib.yk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ActivityChatBindingImpl extends ActivityChatBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34402a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9635a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9636a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f9637a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f9638a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(4);
        f9635a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{2}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34402a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.im.R.id.flContainer, 3);
    }

    public ActivityChatBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f9635a, f34402a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f9636a;
            this.f9636a = 0L;
        }
        BaseTitleVM baseTitleVM = ((ActivityChatBinding) this).f9634a;
        long j2 = j & 7;
        int statusBarHeight = 0;
        BindingTitleBean value = null;
        if (j2 != 0) {
            MutableLiveData<BindingTitleBean> mutableLiveData = baseTitleVM != null ? baseTitleVM.i : null;
            updateLiveDataRegistration(0, mutableLiveData);
            value = mutableLiveData != null ? mutableLiveData.getValue() : null;
            if (value != null) {
                statusBarHeight = value.getStatusBarHeight();
            }
        }
        int i = statusBarHeight;
        if (j2 != 0) {
            CommonBindingAdapter.I(((ActivityChatBinding) this).f9633a, 0, i, 0, 0, null);
            this.f9638a.k(value);
        }
        ViewDataBinding.executeBindingsOn(this.f9638a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9636a != 0) {
                return true;
            }
            return this.f9638a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9636a = 4L;
        }
        this.f9638a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.im.databinding.ActivityChatBinding
    public void k(@Nullable BaseTitleVM baseTitleVM) {
        ((ActivityChatBinding) this).f9634a = baseTitleVM;
        synchronized (this) {
            this.f9636a |= 2;
        }
        notifyPropertyChanged(yk0.L);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != yk0.f46050a) {
            return false;
        }
        synchronized (this) {
            this.f9636a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return l((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f9638a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (yk0.L != i) {
            return false;
        }
        k((BaseTitleVM) obj);
        return true;
    }

    public ActivityChatBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (FrameLayout) objArr[3], (ImageView) objArr[1]);
        this.f9636a = -1L;
        ((ActivityChatBinding) this).f9633a.setTag(null);
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[2];
        this.f9638a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f9637a = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
