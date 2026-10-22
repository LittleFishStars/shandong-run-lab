package com.huachenjie.home.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.viewpager2.widget.ViewPager2;
import com.flyco.tablayout.SlidingTabLayout2;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.home.R;
import com.huachenjie.home.page.rebate_goods_list.RebateGoodsListActivity;
import com.huachenjie.home.page.rebate_goods_list.RebateGoodsListVM;
import com.noober.background.view.BLView;
import com.zj.adlib.jj8;
import com.zj.adlib.xk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class HomeActivityRebateGoodsListBindingImpl extends HomeActivityRebateGoodsListBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34211a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9302a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9303a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f9304a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f9305a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9306a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f9307a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f9308a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RebateGoodsListActivity.a f34212a;

        public a a(RebateGoodsListActivity.a aVar) {
            this.f34212a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34212a.a(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34211a = sparseIntArray;
        sparseIntArray.put(R.id.tab_layout, 4);
        sparseIntArray.put(R.id.view_pager, 5);
    }

    public HomeActivityRebateGoodsListBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f9302a, f34211a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int iSafeUnbox;
        int i;
        a aVarA;
        int iSafeUnbox2;
        synchronized (this) {
            j = this.f9303a;
            this.f9303a = 0L;
        }
        RebateGoodsListVM rebateGoodsListVM = ((HomeActivityRebateGoodsListBinding) this).f9301a;
        RebateGoodsListActivity.a aVar = ((HomeActivityRebateGoodsListBinding) this).f9300a;
        int iSafeUnbox3 = 0;
        if ((23 & j) != 0) {
            BaseViewModel.b bVarE = rebateGoodsListVM != null ? rebateGoodsListVM.e() : null;
            if ((j & 21) != 0) {
                MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                updateLiveDataRegistration(0, mutableLiveDataB);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null);
                iSafeUnbox2 = ViewDataBinding.safeUnbox(Integer.valueOf(iSafeUnbox + 8));
            } else {
                iSafeUnbox = 0;
                iSafeUnbox2 = 0;
            }
            if ((j & 22) != 0) {
                MutableLiveData<Integer> mutableLiveDataC = bVarE != null ? bVarE.c() : null;
                updateLiveDataRegistration(1, mutableLiveDataC);
                iSafeUnbox3 = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(mutableLiveDataC != null ? mutableLiveDataC.getValue() : null) + jj8.a(44.0f)));
            }
            i = iSafeUnbox2;
        } else {
            iSafeUnbox = 0;
            i = 0;
        }
        long j2 = 24 & j;
        if (j2 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f9307a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f9307a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if ((22 & j) != 0) {
            CommonBindingAdapter.G(this.f9308a, iSafeUnbox3);
        }
        if ((j & 21) != 0) {
            CommonBindingAdapter.I(this.f9306a, 0, i, 0, 0, null);
            CommonBindingAdapter.I(this.f9305a, 0, iSafeUnbox, 0, 0, null);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f9305a, aVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9303a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9303a = 16L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeActivityRebateGoodsListBinding
    public void l(@Nullable RebateGoodsListActivity.a aVar) {
        ((HomeActivityRebateGoodsListBinding) this).f9300a = aVar;
        synchronized (this) {
            this.f9303a |= 8;
        }
        notifyPropertyChanged(xk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeActivityRebateGoodsListBinding
    public void m(@Nullable RebateGoodsListVM rebateGoodsListVM) {
        ((HomeActivityRebateGoodsListBinding) this).f9301a = rebateGoodsListVM;
        synchronized (this) {
            this.f9303a |= 4;
        }
        notifyPropertyChanged(xk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9303a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9303a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((MutableLiveData) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return o((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (xk0.p0 == i) {
            m((RebateGoodsListVM) obj);
        } else {
            if (xk0.k != i) {
                return false;
            }
            l((RebateGoodsListActivity.a) obj);
        }
        return true;
    }

    public HomeActivityRebateGoodsListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (SlidingTabLayout2) objArr[4], (ViewPager2) objArr[5]);
        this.f9303a = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f9304a = frameLayout;
        frameLayout.setTag(null);
        BLView bLView = (BLView) objArr[1];
        this.f9308a = bLView;
        bLView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[2];
        this.f9306a = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[3];
        this.f9305a = imageView;
        imageView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
