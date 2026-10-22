package com.huachenjie.mine.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.SlidingTabLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.huachenjie.base.bean.UserInfoBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.mine.R;
import com.huachenjie.mine.page.home.MineFragment;
import com.huachenjie.mine.page.home.MineVM;
import com.huachenjie.works.external.widget.UserLaoButton;
import com.zj.adlib.ik0;
import com.zj.adlib.zv9;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MineFragmentHomeBindingImpl extends MineFragmentHomeBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35324a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11276a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11277a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CoordinatorLayout f11278a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CollapsingToolbarLayout f11279a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f11280a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f11281a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f11282a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f11283a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MineFragment.a f35325a;

        public a a(MineFragment.a aVar) {
            this.f35325a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35325a.p(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MineFragment.a f35326a;

        public b a(MineFragment.a aVar) {
            this.f35326a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35326a.e(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MineFragment.a f35327a;

        public c a(MineFragment.a aVar) {
            this.f35327a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35327a.q(view);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MineFragment.a f35328a;

        public d a(MineFragment.a aVar) {
            this.f35328a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35328a.m(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(14);
        f11276a = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"mine_layout_mine_header"}, new int[]{8}, new int[]{R.layout.mine_layout_mine_header});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35324a = sparseIntArray;
        sparseIntArray.put(R.id.app_bar, 9);
        sparseIntArray.put(R.id.tool_bar, 10);
        sparseIntArray.put(R.id.bl_LinearLayout, 11);
        sparseIntArray.put(R.id.tabLayout, 12);
        sparseIntArray.put(R.id.viewPager, 13);
    }

    public MineFragmentHomeBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 14, f11276a, f35324a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x003a  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        UserInfoBean value;
        boolean zSafeUnbox;
        boolean zSafeUnbox2;
        MutableLiveData<Boolean> mutableLiveDataQ;
        Boolean value2;
        boolean zSafeUnbox3;
        int iSafeUnbox;
        c cVarA;
        a aVarA;
        d dVarA;
        b bVarA;
        boolean z;
        synchronized (this) {
            j = this.f11277a;
            this.f11277a = 0L;
        }
        MineVM mineVM = ((MineFragmentHomeBinding) this).f11274a;
        MineFragment.a aVar = ((MineFragmentHomeBinding) this).f11273a;
        if ((175 & j) != 0) {
            if ((j & 161) == 0) {
                value = null;
            } else {
                MutableLiveData<UserInfoBean> mutableLiveDataP = mineVM != null ? mineVM.p() : null;
                updateLiveDataRegistration(0, mutableLiveDataP);
                if (mutableLiveDataP != null) {
                    value = mutableLiveDataP.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 162) != 0) {
                mutableLiveDataQ = mineVM != null ? mineVM.q() : null;
                updateLiveDataRegistration(1, mutableLiveDataQ);
                value2 = mutableLiveDataQ != null ? mutableLiveDataQ.getValue() : null;
                zSafeUnbox3 = ViewDataBinding.safeUnbox(value2);
            } else {
                zSafeUnbox3 = false;
                mutableLiveDataQ = null;
                value2 = null;
            }
            if ((j & 168) != 0) {
                BaseViewModel.b bVarE = mineVM != null ? mineVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                updateLiveDataRegistration(3, mutableLiveDataB);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null);
            } else {
                iSafeUnbox = 0;
            }
            long j2 = j & 166;
            if (j2 != 0) {
                MutableLiveData<Boolean> mutableLiveDataO = mineVM != null ? mineVM.o() : null;
                updateLiveDataRegistration(2, mutableLiveDataO);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataO != null ? mutableLiveDataO.getValue() : null);
                if (j2 != 0) {
                    j = zSafeUnbox ? j | 512 : j | 256;
                }
                if ((j & 164) != 0) {
                    zSafeUnbox2 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox));
                    iSafeUnbox = iSafeUnbox;
                }
            } else {
                zSafeUnbox = false;
            }
            zSafeUnbox2 = false;
        } else {
            value = null;
            zSafeUnbox = false;
            zSafeUnbox2 = false;
            mutableLiveDataQ = null;
            value2 = null;
            zSafeUnbox3 = false;
            iSafeUnbox = 0;
        }
        long j3 = j & 192;
        if (j3 == 0 || aVar == null) {
            cVarA = null;
            aVarA = null;
            dVarA = null;
            bVarA = null;
        } else {
            d dVar = this.f11283a;
            if (dVar == null) {
                dVar = new d();
                this.f11283a = dVar;
            }
            dVarA = dVar.a(aVar);
            a aVar2 = this.f11280a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f11280a = aVar2;
            }
            aVarA = aVar2.a(aVar);
            b bVar = this.f11281a;
            if (bVar == null) {
                bVar = new b();
                this.f11281a = bVar;
            }
            bVarA = bVar.a(aVar);
            c cVar = this.f11282a;
            if (cVar == null) {
                cVar = new c();
                this.f11282a = cVar;
            }
            cVarA = cVar.a(aVar);
        }
        if ((j & 512) != 0) {
            if (mineVM != null) {
                mutableLiveDataQ = mineVM.q();
            }
            updateLiveDataRegistration(1, mutableLiveDataQ);
            if (mutableLiveDataQ != null) {
                value2 = mutableLiveDataQ.getValue();
            }
            zSafeUnbox3 = ViewDataBinding.safeUnbox(value2);
        }
        boolean z2 = zSafeUnbox3;
        long j4 = j & 166;
        if (j4 != 0) {
            z = zSafeUnbox ? z2 : false;
        } else {
            z = false;
        }
        if ((j & 162) != 0) {
            CommonBindingAdapter.l0(((MineFragmentHomeBinding) this).f11275a, z2);
        }
        if ((j & 161) != 0) {
            zv9.a(((MineFragmentHomeBinding) this).f11275a, value, 3, 5);
        }
        if ((168 & j) != 0) {
            CommonBindingAdapter.O(((MineFragmentHomeBinding) this).f11268a, 0, iSafeUnbox, 0, 0, null);
        }
        if (j3 != 0) {
            ((MineFragmentHomeBinding) this).f11272a.l(aVar);
            CommonBindingAdapter.q(((MineFragmentHomeBinding) this).f35323a, bVarA, null);
            CommonBindingAdapter.q(this.b, aVarA, null);
            CommonBindingAdapter.q(this.c, dVarA, null);
            CommonBindingAdapter.q(this.d, cVarA, null);
        }
        if ((160 & j) != 0) {
            ((MineFragmentHomeBinding) this).f11272a.m(mineVM);
        }
        if ((j & 164) != 0) {
            CommonBindingAdapter.l0(((MineFragmentHomeBinding) this).f35323a, zSafeUnbox);
            CommonBindingAdapter.l0(this.b, zSafeUnbox2);
            CommonBindingAdapter.l0(this.d, zSafeUnbox2);
        }
        if (j4 != 0) {
            CommonBindingAdapter.l0(this.c, z);
        }
        ViewDataBinding.executeBindingsOn(((MineFragmentHomeBinding) this).f11272a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11277a != 0) {
                return true;
            }
            return ((MineFragmentHomeBinding) this).f11272a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11277a = 128L;
        }
        ((MineFragmentHomeBinding) this).f11272a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.mine.databinding.MineFragmentHomeBinding
    public void l(@Nullable MineFragment.a aVar) {
        ((MineFragmentHomeBinding) this).f11273a = aVar;
        synchronized (this) {
            this.f11277a |= 64;
        }
        notifyPropertyChanged(ik0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mine.databinding.MineFragmentHomeBinding
    public void m(@Nullable MineVM mineVM) {
        ((MineFragmentHomeBinding) this).f11274a = mineVM;
        synchronized (this) {
            this.f11277a |= 32;
        }
        notifyPropertyChanged(ik0.p0);
        super.requestRebind();
    }

    public final boolean n(MineLayoutMineHeaderBinding mineLayoutMineHeaderBinding, int i) {
        if (i != ik0.f42374a) {
            return false;
        }
        synchronized (this) {
            this.f11277a |= 16;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != ik0.f42374a) {
            return false;
        }
        synchronized (this) {
            this.f11277a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return r((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return o((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 3) {
            return q((MutableLiveData) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return n((MineLayoutMineHeaderBinding) obj, i2);
    }

    public final boolean p(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != ik0.f42374a) {
            return false;
        }
        synchronized (this) {
            this.f11277a |= 4;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != ik0.f42374a) {
            return false;
        }
        synchronized (this) {
            this.f11277a |= 8;
        }
        return true;
    }

    public final boolean r(MutableLiveData<UserInfoBean> mutableLiveData, int i) {
        if (i != ik0.f42374a) {
            return false;
        }
        synchronized (this) {
            this.f11277a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((MineFragmentHomeBinding) this).f11272a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ik0.p0 == i) {
            m((MineVM) obj);
        } else {
            if (ik0.k != i) {
                return false;
            }
            l((MineFragment.a) obj);
        }
        return true;
    }

    public MineFragmentHomeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (AppBarLayout) objArr[9], (LinearLayout) objArr[11], (UserLaoButton) objArr[7], (ConstraintLayout) objArr[2], (MineLayoutMineHeaderBinding) objArr[8], (ImageView) objArr[3], (ImageView) objArr[4], (ImageView) objArr[6], (ImageView) objArr[5], (SlidingTabLayout) objArr[12], (Toolbar) objArr[10], (ViewPager) objArr[13]);
        this.f11277a = -1L;
        ((MineFragmentHomeBinding) this).f11275a.setTag(null);
        ((MineFragmentHomeBinding) this).f11268a.setTag(null);
        setContainedBinding(((MineFragmentHomeBinding) this).f11272a);
        ((MineFragmentHomeBinding) this).f35323a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) objArr[0];
        this.f11278a = coordinatorLayout;
        coordinatorLayout.setTag(null);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) objArr[1];
        this.f11279a = collapsingToolbarLayout;
        collapsingToolbarLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
