package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.viewpager2.widget.ViewPager2;
import com.flyco.tablayout.SlidingTabLayout2;
import com.google.android.material.appbar.AppBarLayout;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.MallBannerBean;
import com.huachenjie.mall.page.home_tab.MallActivity;
import com.huachenjie.mall.page.home_tab.MallHomeVM;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLLinearLayout;
import com.youth.banner.Banner;
import com.zj.adlib.hk0;
import com.zj.adlib.jj8;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallActivityMallBindingImpl extends MallActivityMallBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34805a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10258a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10259a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f10260a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f10261a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f10262a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f10263a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f10264a;

    @NonNull
    public final LinearLayout b;

    @NonNull
    public final LinearLayout c;

    @NonNull
    public final LinearLayout d;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MallActivity.a f34806a;

        public a a(MallActivity.a aVar) {
            this.f34806a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34806a.h(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MallActivity.a f34807a;

        public b a(MallActivity.a aVar) {
            this.f34807a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34807a.g(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MallActivity.a f34808a;

        public c a(MallActivity.a aVar) {
            this.f34808a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34808a.c(view);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MallActivity.a f34809a;

        public d a(MallActivity.a aVar) {
            this.f34809a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34809a.d(view);
        }
    }

    public static class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MallActivity.a f34810a;

        public e a(MallActivity.a aVar) {
            this.f34810a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34810a.i(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34805a = sparseIntArray;
        sparseIntArray.put(R.id.vp_search, 8);
        sparseIntArray.put(R.id.app_bar, 9);
        sparseIntArray.put(R.id.v_split_line, 10);
        sparseIntArray.put(R.id.bl_LinearLayout, 11);
        sparseIntArray.put(R.id.tabLayout, 12);
        sparseIntArray.put(R.id.viewPager, 13);
    }

    public MallActivityMallBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 14, f10258a, f34805a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        List<MallBannerBean> value;
        int iSafeUnbox;
        boolean z;
        int i;
        d dVarA;
        c cVarA;
        a aVarA;
        b bVarA;
        e eVarA;
        long j2;
        boolean z2;
        boolean z3;
        int iSafeUnbox2;
        synchronized (this) {
            j = this.f10259a;
            this.f10259a = 0L;
        }
        MallHomeVM mallHomeVM = ((MallActivityMallBinding) this).f10253a;
        MallActivity.a aVar = ((MallActivityMallBinding) this).f10252a;
        if ((47 & j) != 0) {
            if ((j & 43) != 0) {
                BaseViewModel.b bVarE = mallHomeVM != null ? mallHomeVM.e() : null;
                if ((j & 41) != 0) {
                    MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                    updateLiveDataRegistration(0, mutableLiveDataB);
                    iSafeUnbox2 = ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null);
                } else {
                    iSafeUnbox2 = 0;
                }
                if ((j & 42) != 0) {
                    MutableLiveData<Integer> mutableLiveDataC = bVarE != null ? bVarE.c() : null;
                    updateLiveDataRegistration(1, mutableLiveDataC);
                    iSafeUnbox = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(mutableLiveDataC != null ? mutableLiveDataC.getValue() : null) + jj8.a(60.0f)));
                } else {
                    iSafeUnbox = 0;
                }
            } else {
                iSafeUnbox = 0;
                iSafeUnbox2 = 0;
            }
            long j3 = j & 44;
            if (j3 != 0) {
                MutableLiveData<List<MallBannerBean>> mutableLiveDataK = mallHomeVM != null ? mallHomeVM.k() : null;
                updateLiveDataRegistration(2, mutableLiveDataK);
                value = mutableLiveDataK != null ? mutableLiveDataK.getValue() : null;
                z = value != null;
                if (j3 != 0) {
                    j = z ? j | 128 : j | 64;
                }
                i = iSafeUnbox2;
            } else {
                value = null;
                i = iSafeUnbox2;
                z = false;
            }
        } else {
            value = null;
            iSafeUnbox = 0;
            z = false;
            i = 0;
        }
        long j4 = j & 48;
        if (j4 == 0 || aVar == null) {
            dVarA = null;
            cVarA = null;
            aVarA = null;
            bVarA = null;
            eVarA = null;
        } else {
            e eVar = this.f10264a;
            if (eVar == null) {
                eVar = new e();
                this.f10264a = eVar;
            }
            eVarA = eVar.a(aVar);
            a aVar2 = this.f10260a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f10260a = aVar2;
            }
            aVarA = aVar2.a(aVar);
            b bVar = this.f10261a;
            if (bVar == null) {
                bVar = new b();
                this.f10261a = bVar;
            }
            bVarA = bVar.a(aVar);
            c cVar = this.f10262a;
            if (cVar == null) {
                cVar = new c();
                this.f10262a = cVar;
            }
            cVarA = cVar.a(aVar);
            d dVar = this.f10263a;
            if (dVar == null) {
                dVar = new d();
                this.f10263a = dVar;
            }
            dVarA = dVar.a(aVar);
        }
        if ((j & 128) != 0) {
            z2 = (value != null ? value.size() : 0) > 0;
            j2 = 44;
        } else {
            j2 = 44;
            z2 = false;
        }
        long j5 = j & j2;
        if (j5 != 0) {
            z3 = z ? z2 : false;
        } else {
            z3 = false;
        }
        if (j5 != 0) {
            CommonBindingAdapter.l0(((MallActivityMallBinding) this).f10256a, z3);
        }
        if (j4 != 0) {
            CommonBindingAdapter.q(((MallActivityMallBinding) this).f10247a, cVarA, null);
            CommonBindingAdapter.q(((MallActivityMallBinding) this).f10255a, eVarA, null);
            CommonBindingAdapter.q(this.c, aVarA, null);
            CommonBindingAdapter.q(this.d, bVarA, null);
            CommonBindingAdapter.q(((MallActivityMallBinding) this).b, dVarA, null);
        }
        if ((42 & j) != 0) {
            CommonBindingAdapter.G(((MallActivityMallBinding) this).f10254a, iSafeUnbox);
        }
        if ((j & 41) != 0) {
            CommonBindingAdapter.O(((MallActivityMallBinding) this).f10254a, 0, i, 0, 0, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10259a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10259a = 32L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityMallBinding
    public void l(@Nullable MallActivity.a aVar) {
        ((MallActivityMallBinding) this).f10252a = aVar;
        synchronized (this) {
            this.f10259a |= 16;
        }
        notifyPropertyChanged(hk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityMallBinding
    public void m(@Nullable MallHomeVM mallHomeVM) {
        ((MallActivityMallBinding) this).f10253a = mallHomeVM;
        synchronized (this) {
            this.f10259a |= 8;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<List<MallBannerBean>> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10259a |= 4;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10259a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return o((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return p((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10259a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 == i) {
            m((MallHomeVM) obj);
        } else {
            if (hk0.k != i) {
                return false;
            }
            l((MallActivity.a) obj);
        }
        return true;
    }

    public MallActivityMallBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (AppBarLayout) objArr[9], (Banner) objArr[6], (LinearLayout) objArr[11], (ImageView) objArr[2], (BLLinearLayout) objArr[3], (BLConstraintLayout) objArr[1], (ImageView) objArr[7], (SlidingTabLayout2) objArr[12], (View) objArr[10], (ViewPager2) objArr[13], (Banner) objArr[8]);
        this.f10259a = -1L;
        ((MallActivityMallBinding) this).f10256a.setTag(null);
        ((MallActivityMallBinding) this).f10247a.setTag(null);
        ((MallActivityMallBinding) this).f10255a.setTag(null);
        ((MallActivityMallBinding) this).f10254a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.b = linearLayout;
        linearLayout.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[4];
        this.c = linearLayout2;
        linearLayout2.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) objArr[5];
        this.d = linearLayout3;
        linearLayout3.setTag(null);
        ((MallActivityMallBinding) this).b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
