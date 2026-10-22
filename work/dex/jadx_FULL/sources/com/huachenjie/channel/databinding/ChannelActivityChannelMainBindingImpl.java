package com.huachenjie.channel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.viewpager2.widget.ViewPager2;
import com.flyco.tablayout.SlidingTabLayout2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.huachenjie.channel.R;
import com.huachenjie.channel.page.channel_main.ChannelMainActivity;
import com.huachenjie.channel.page.channel_main.ChannelMainVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.noober.background.view.BLImageView;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelActivityChannelMainBindingImpl extends ChannelActivityChannelMainBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33050a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7462a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7463a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CoordinatorLayout f7464a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f7465a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f7466a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ChannelMainActivity.a f33051a;

        public a a(ChannelMainActivity.a aVar) {
            this.f33051a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33051a.f(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ChannelMainActivity.a f33052a;

        public b a(ChannelMainActivity.a aVar) {
            this.f33052a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33052a.c(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(9);
        f7462a = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"channel_layout_channel_main_header"}, new int[]{5}, new int[]{R.layout.channel_layout_channel_main_header});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33050a = sparseIntArray;
        sparseIntArray.put(R.id.app_bar, 6);
        sparseIntArray.put(R.id.tabLayout, 7);
        sparseIntArray.put(R.id.viewPager, 8);
    }

    public ChannelActivityChannelMainBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, f7462a, f33050a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int iSafeUnbox;
        a aVarA;
        b bVar;
        synchronized (this) {
            j = this.f7463a;
            this.f7463a = 0L;
        }
        ChannelMainVM channelMainVM = ((ChannelActivityChannelMainBinding) this).f7460a;
        ChannelMainActivity.a aVar = ((ChannelActivityChannelMainBinding) this).f7459a;
        long j2 = 22 & j;
        if (j2 != 0) {
            BaseViewModel.b bVarE = channelMainVM != null ? channelMainVM.e() : null;
            MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
            updateLiveDataRegistration(1, mutableLiveDataB);
            iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null);
        } else {
            iSafeUnbox = 0;
        }
        int i = iSafeUnbox;
        long j3 = 24 & j;
        if (j3 == 0 || aVar == null) {
            aVarA = null;
            bVar = null;
        } else {
            b bVar2 = this.f7466a;
            if (bVar2 == null) {
                bVar2 = new b();
                this.f7466a = bVar2;
            }
            b bVarA = bVar2.a(aVar);
            a aVar2 = this.f7465a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f7465a = aVar2;
            }
            bVar = bVarA;
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            CommonBindingAdapter.O(((ChannelActivityChannelMainBinding) this).f33049a, 0, i, 0, 0, null);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(((ChannelActivityChannelMainBinding) this).f7461a, bVar, null);
            CommonBindingAdapter.q(this.b, aVarA, null);
            ((ChannelActivityChannelMainBinding) this).f7458a.l(aVar);
        }
        if ((j & 20) != 0) {
            ((ChannelActivityChannelMainBinding) this).f7458a.m(channelMainVM);
        }
        ViewDataBinding.executeBindingsOn(((ChannelActivityChannelMainBinding) this).f7458a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f7463a != 0) {
                return true;
            }
            return ((ChannelActivityChannelMainBinding) this).f7458a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7463a = 16L;
        }
        ((ChannelActivityChannelMainBinding) this).f7458a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityChannelMainBinding
    public void l(@Nullable ChannelMainActivity.a aVar) {
        ((ChannelActivityChannelMainBinding) this).f7459a = aVar;
        synchronized (this) {
            this.f7463a |= 8;
        }
        notifyPropertyChanged(tk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityChannelMainBinding
    public void m(@Nullable ChannelMainVM channelMainVM) {
        ((ChannelActivityChannelMainBinding) this).f7460a = channelMainVM;
        synchronized (this) {
            this.f7463a |= 4;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean n(ChannelLayoutChannelMainHeaderBinding channelLayoutChannelMainHeaderBinding, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7463a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7463a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((ChannelLayoutChannelMainHeaderBinding) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return o((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((ChannelActivityChannelMainBinding) this).f7458a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 == i) {
            m((ChannelMainVM) obj);
        } else {
            if (tk0.k != i) {
                return false;
            }
            l((ChannelMainActivity.a) obj);
        }
        return true;
    }

    public ChannelActivityChannelMainBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (AppBarLayout) objArr[6], (ConstraintLayout) objArr[2], (CollapsingToolbarLayout) objArr[1], (BLImageView) objArr[3], (BLImageView) objArr[4], (ChannelLayoutChannelMainHeaderBinding) objArr[5], (SlidingTabLayout2) objArr[7], (ViewPager2) objArr[8]);
        this.f7463a = -1L;
        ((ChannelActivityChannelMainBinding) this).f33049a.setTag(null);
        ((ChannelActivityChannelMainBinding) this).f7457a.setTag(null);
        ((ChannelActivityChannelMainBinding) this).f7461a.setTag(null);
        this.b.setTag(null);
        setContainedBinding(((ChannelActivityChannelMainBinding) this).f7458a);
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) objArr[0];
        this.f7464a = coordinatorLayout;
        coordinatorLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
