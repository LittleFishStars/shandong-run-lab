package com.huachenjie.shandong_school.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.p002lifecycle.LifecycleOwner;
import com.huachenjie.shandong_school.R;
import com.huachenjie.shandong_school.home.HomeActivity;
import com.huachenjie.shandong_school.home.HomeVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class ActivityHomeBindingImpl extends ActivityHomeBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36020a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12628a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12629a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f12630a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutHomeSlideBinding f12631a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(5);
        f12628a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_home_slide"}, new int[]{3}, new int[]{R.layout.layout_home_slide});
        includedLayouts.setIncludes(1, new String[]{"layout_home_tab_bar"}, new int[]{2}, new int[]{R.layout.layout_home_tab_bar});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36020a = sparseIntArray;
        sparseIntArray.put(2131363101, 4);
    }

    public ActivityHomeBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f12628a, f36020a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f12629a;
            this.f12629a = 0L;
        }
        HomeVM homeVM = ((ActivityHomeBinding) this).f12627a;
        HomeActivity.a aVar = ((ActivityHomeBinding) this).f12626a;
        long j2 = 10 & j;
        if ((j & 12) != 0) {
            this.f12631a.l(aVar);
            ((ActivityHomeBinding) this).f12625a.k(aVar);
        }
        if (j2 != 0) {
            this.f12631a.m(homeVM);
        }
        ViewDataBinding.executeBindingsOn(((ActivityHomeBinding) this).f12625a);
        ViewDataBinding.executeBindingsOn(this.f12631a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f12629a != 0) {
                return true;
            }
            return ((ActivityHomeBinding) this).f12625a.hasPendingBindings() || this.f12631a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12629a = 8L;
        }
        ((ActivityHomeBinding) this).f12625a.invalidateAll();
        this.f12631a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.shandong_school.databinding.ActivityHomeBinding
    public void l(@Nullable HomeActivity.a aVar) {
        ((ActivityHomeBinding) this).f12626a = aVar;
        synchronized (this) {
            this.f12629a |= 4;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // com.huachenjie.shandong_school.databinding.ActivityHomeBinding
    public void m(@Nullable HomeVM homeVM) {
        ((ActivityHomeBinding) this).f12627a = homeVM;
        synchronized (this) {
            this.f12629a |= 2;
        }
        notifyPropertyChanged(67);
        super.requestRebind();
    }

    public final boolean n(LayoutHomeTabBarBinding layoutHomeTabBarBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f12629a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return n((LayoutHomeTabBarBinding) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((ActivityHomeBinding) this).f12625a.setLifecycleOwner(lifecycleOwner);
        this.f12631a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (67 == i) {
            m((HomeVM) obj);
        } else {
            if (10 != i) {
                return false;
            }
            l((HomeActivity.a) obj);
        }
        return true;
    }

    public ActivityHomeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (DrawerLayout) objArr[0], (FrameLayout) objArr[4], (LayoutHomeTabBarBinding) objArr[2]);
        this.f12629a = -1L;
        ((ActivityHomeBinding) this).f12624a.setTag(null);
        LayoutHomeSlideBinding layoutHomeSlideBinding = (LayoutHomeSlideBinding) objArr[3];
        this.f12631a = layoutHomeSlideBinding;
        setContainedBinding(layoutHomeSlideBinding);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[1];
        this.f12630a = relativeLayout;
        relativeLayout.setTag(null);
        setContainedBinding(((ActivityHomeBinding) this).f12625a);
        setRootTag(view);
        invalidateAll();
    }
}
