package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailBean;
import com.huachenjie.mall.page.goods_detail.GoodsDetailActivity;
import com.huachenjie.mall.page.goods_detail.GoodsDetailVM;
import com.noober.background.view.BLConstraintLayout;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallLayoutGoodsDetailBottomDistributingBindingImpl extends MallLayoutGoodsDetailBottomDistributingBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35061a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10984a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10985a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f10986a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f10987a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f10988a;

    @NonNull
    public final BLConstraintLayout b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public GoodsDetailActivity.ClickProxy f35062a;

        public a a(GoodsDetailActivity.ClickProxy clickProxy) {
            this.f35062a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35062a.e(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public GoodsDetailActivity.ClickProxy f35063a;

        public b a(GoodsDetailActivity.ClickProxy clickProxy) {
            this.f35063a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35063a.g(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35061a = sparseIntArray;
        sparseIntArray.put(R.id.iv_direct_selling, 5);
        sparseIntArray.put(R.id.tv_direct_selling, 6);
        sparseIntArray.put(R.id.iv_goods_direct_share, 7);
        sparseIntArray.put(R.id.tv_goods_direct_share, 8);
    }

    public MallLayoutGoodsDetailBottomDistributingBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, f10984a, f35061a));
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0048  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        CharSequence commission;
        b bVarA;
        a aVarA;
        MutableLiveData<Integer> mutableLiveDataD;
        MutableLiveData<GoodsDetailBean> mutableLiveDataU;
        synchronized (this) {
            j = this.f10985a;
            this.f10985a = 0L;
        }
        GoodsDetailVM goodsDetailVM = ((MallLayoutGoodsDetailBottomDistributingBinding) this).f10982a;
        GoodsDetailActivity.ClickProxy clickProxy = ((MallLayoutGoodsDetailBottomDistributingBinding) this).f10981a;
        long j2 = 23 & j;
        if (j2 == 0) {
            commission = null;
        } else {
            if (goodsDetailVM != null) {
                mutableLiveDataU = goodsDetailVM.u();
                mutableLiveDataD = goodsDetailVM.D();
            } else {
                mutableLiveDataD = null;
                mutableLiveDataU = null;
            }
            updateLiveDataRegistration(0, mutableLiveDataU);
            updateLiveDataRegistration(1, mutableLiveDataD);
            GoodsDetailBean value = mutableLiveDataU != null ? mutableLiveDataU.getValue() : null;
            int iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataD != null ? mutableLiveDataD.getValue() : null);
            if (value != null) {
                commission = value.formatCommission(iSafeUnbox);
            } else {
                commission = null;
            }
        }
        long j3 = j & 24;
        if (j3 == 0 || clickProxy == null) {
            bVarA = null;
            aVarA = null;
        } else {
            b bVar = this.f10987a;
            if (bVar == null) {
                bVar = new b();
                this.f10987a = bVar;
            }
            bVarA = bVar.a(clickProxy);
            a aVar = this.f10986a;
            if (aVar == null) {
                aVar = new a();
                this.f10986a = aVar;
            }
            aVarA = aVar.a(clickProxy);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.f10988a, bVarA, null);
            CommonBindingAdapter.q(this.b, aVarA, null);
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.c, commission);
            TextViewBindingAdapter.setText(this.d, commission);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10985a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10985a = 16L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallLayoutGoodsDetailBottomDistributingBinding
    public void l(@Nullable GoodsDetailActivity.ClickProxy clickProxy) {
        ((MallLayoutGoodsDetailBottomDistributingBinding) this).f10981a = clickProxy;
        synchronized (this) {
            this.f10985a |= 8;
        }
        notifyPropertyChanged(hk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallLayoutGoodsDetailBottomDistributingBinding
    public void m(@Nullable GoodsDetailVM goodsDetailVM) {
        ((MallLayoutGoodsDetailBottomDistributingBinding) this).f10982a = goodsDetailVM;
        synchronized (this) {
            this.f10985a |= 4;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<GoodsDetailBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10985a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10985a |= 2;
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
        if (hk0.p0 == i) {
            m((GoodsDetailVM) obj);
        } else {
            if (hk0.k != i) {
                return false;
            }
            l((GoodsDetailActivity.ClickProxy) obj);
        }
        return true;
    }

    public MallLayoutGoodsDetailBottomDistributingBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (CardView) objArr[0], (ImageView) objArr[5], (ImageView) objArr[7], (TextView) objArr[6], (TextView) objArr[8]);
        this.f10985a = -1L;
        ((MallLayoutGoodsDetailBottomDistributingBinding) this).f10980a.setTag(null);
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) objArr[1];
        this.f10988a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.c = textView;
        textView.setTag(null);
        BLConstraintLayout bLConstraintLayout2 = (BLConstraintLayout) objArr[3];
        this.b = bLConstraintLayout2;
        bLConstraintLayout2.setTag(null);
        TextView textView2 = (TextView) objArr[4];
        this.d = textView2;
        textView2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
