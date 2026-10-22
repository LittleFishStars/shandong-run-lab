package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.flyco.tablayout.CommonTabLayout;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.goods_detail.GoodsDetailActivity;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallLayoutGoodsDetailToolbarBindingImpl extends MallLayoutGoodsDetailToolbarBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35070a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11004a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11005a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f11006a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f11007a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f11008a;

    @NonNull
    public final FrameLayout b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public GoodsDetailActivity.ClickProxy f35071a;

        public a a(GoodsDetailActivity.ClickProxy clickProxy) {
            this.f35071a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35071a.e(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public GoodsDetailActivity.ClickProxy f35072a;

        public b a(GoodsDetailActivity.ClickProxy clickProxy) {
            this.f35072a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35072a.b(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35070a = sparseIntArray;
        sparseIntArray.put(R.id.fl_tab, 5);
    }

    public MallLayoutGoodsDetailToolbarBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f11004a, f35070a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int iSafeUnbox;
        int i;
        b bVarA;
        a aVarA;
        synchronized (this) {
            j = this.f11005a;
            this.f11005a = 0L;
        }
        Integer num = ((MallLayoutGoodsDetailToolbarBinding) this).f11003a;
        GoodsDetailActivity.ClickProxy clickProxy = ((MallLayoutGoodsDetailToolbarBinding) this).f11002a;
        long j2 = 5 & j;
        if (j2 != 0) {
            int iSafeUnbox2 = ViewDataBinding.safeUnbox(num);
            i = iSafeUnbox2;
            iSafeUnbox = ViewDataBinding.safeUnbox(Integer.valueOf(iSafeUnbox2 - 8));
        } else {
            iSafeUnbox = 0;
            i = 0;
        }
        long j3 = j & 6;
        if (j3 == 0 || clickProxy == null) {
            bVarA = null;
            aVarA = null;
        } else {
            b bVar = this.f11008a;
            if (bVar == null) {
                bVar = new b();
                this.f11008a = bVar;
            }
            bVarA = bVar.a(clickProxy);
            a aVar = this.f11007a;
            if (aVar == null) {
                aVar = new a();
                this.f11007a = aVar;
            }
            aVarA = aVar.a(clickProxy);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(((MallLayoutGoodsDetailToolbarBinding) this).f11000a, bVarA, null);
            CommonBindingAdapter.q(super.b, aVarA, null);
        }
        if (j2 != 0) {
            CommonBindingAdapter.O(this.f11006a, 0, i, 0, 0, null);
            CommonBindingAdapter.I(((MallLayoutGoodsDetailToolbarBinding) this).f11001a, 0, iSafeUnbox, 0, 0, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11005a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11005a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallLayoutGoodsDetailToolbarBinding
    public void l(@Nullable GoodsDetailActivity.ClickProxy clickProxy) {
        ((MallLayoutGoodsDetailToolbarBinding) this).f11002a = clickProxy;
        synchronized (this) {
            this.f11005a |= 2;
        }
        notifyPropertyChanged(hk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallLayoutGoodsDetailToolbarBinding
    public void m(@Nullable Integer num) {
        ((MallLayoutGoodsDetailToolbarBinding) this).f11003a = num;
        synchronized (this) {
            this.f11005a |= 1;
        }
        notifyPropertyChanged(hk0.g0);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.g0 == i) {
            m((Integer) obj);
        } else {
            if (hk0.k != i) {
                return false;
            }
            l((GoodsDetailActivity.ClickProxy) obj);
        }
        return true;
    }

    public MallLayoutGoodsDetailToolbarBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[5], (ImageView) objArr[3], (ImageView) objArr[4], (CommonTabLayout) objArr[1]);
        this.f11005a = -1L;
        ((MallLayoutGoodsDetailToolbarBinding) this).f11000a.setTag(null);
        super.b.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.b = frameLayout;
        frameLayout.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[2];
        this.f11006a = relativeLayout;
        relativeLayout.setTag(null);
        ((MallLayoutGoodsDetailToolbarBinding) this).f11001a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
