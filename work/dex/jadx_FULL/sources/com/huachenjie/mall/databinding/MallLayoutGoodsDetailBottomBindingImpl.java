package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailBean;
import com.huachenjie.mall.page.goods_detail.GoodsDetailActivity;
import com.huachenjie.mall.page.goods_detail.GoodsDetailVM;
import com.noober.background.view.BLTextView;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallLayoutGoodsDetailBottomBindingImpl extends MallLayoutGoodsDetailBottomBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35056a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10971a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10972a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10973a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10974a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f10975a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f10976a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f10977a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f10978a;

    @NonNull
    public final TextView b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public GoodsDetailActivity.ClickProxy f35057a;

        public a a(GoodsDetailActivity.ClickProxy clickProxy) {
            this.f35057a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35057a.c(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public GoodsDetailActivity.ClickProxy f35058a;

        public b a(GoodsDetailActivity.ClickProxy clickProxy) {
            this.f35058a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35058a.g(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public GoodsDetailActivity.ClickProxy f35059a;

        public c a(GoodsDetailActivity.ClickProxy clickProxy) {
            this.f35059a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35059a.f(view);
        }
    }

    public MallLayoutGoodsDetailBottomBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f10971a, f35056a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int i;
        String strO;
        b bVarA;
        c cVarA;
        a aVarA;
        boolean z;
        synchronized (this) {
            j = this.f10972a;
            this.f10972a = 0L;
        }
        GoodsDetailVM goodsDetailVM = ((MallLayoutGoodsDetailBottomBinding) this).f10970a;
        GoodsDetailActivity.ClickProxy clickProxy = ((MallLayoutGoodsDetailBottomBinding) this).f10969a;
        boolean z2 = false;
        int iSafeUnbox = 0;
        if ((23 & j) != 0) {
            if ((j & 21) != 0) {
                MutableLiveData<GoodsDetailBean> mutableLiveDataU = goodsDetailVM != null ? goodsDetailVM.u() : null;
                updateLiveDataRegistration(0, mutableLiveDataU);
                GoodsDetailBean value = mutableLiveDataU != null ? mutableLiveDataU.getValue() : null;
                z = !(value != null ? value.getOutOfStock() : false);
            } else {
                z = false;
            }
            strO = ((j & 20) == 0 || goodsDetailVM == null) ? null : goodsDetailVM.o();
            if ((j & 22) != 0) {
                BaseViewModel.b bVarE = goodsDetailVM != null ? goodsDetailVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataA = bVarE != null ? bVarE.a() : null;
                updateLiveDataRegistration(1, mutableLiveDataA);
                iSafeUnbox = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(mutableLiveDataA != null ? mutableLiveDataA.getValue() : null) + 8));
            }
            i = iSafeUnbox;
            z2 = z;
        } else {
            i = 0;
            strO = null;
        }
        long j2 = j & 24;
        if (j2 == 0 || clickProxy == null) {
            bVarA = null;
            cVarA = null;
            aVarA = null;
        } else {
            c cVar = this.f10977a;
            if (cVar == null) {
                cVar = new c();
                this.f10977a = cVar;
            }
            cVarA = cVar.a(clickProxy);
            a aVar = this.f10975a;
            if (aVar == null) {
                aVar = new a();
                this.f10975a = aVar;
            }
            aVarA = aVar.a(clickProxy);
            b bVar = this.f10976a;
            if (bVar == null) {
                bVar = new b();
                this.f10976a = bVar;
            }
            bVarA = bVar.a(clickProxy);
        }
        if ((j & 22) != 0) {
            CommonBindingAdapter.I(this.f10973a, 16, 8, 16, i, null);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f10974a, cVarA, null);
            CommonBindingAdapter.q(this.b, aVarA, null);
            CommonBindingAdapter.q(this.f10978a, bVarA, null);
        }
        if ((21 & j) != 0) {
            CommonBindingAdapter.e0(this.f10978a, z2);
        }
        if ((j & 20) != 0) {
            TextViewBindingAdapter.setText(this.f10978a, strO);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10972a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10972a = 16L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallLayoutGoodsDetailBottomBinding
    public void l(@Nullable GoodsDetailActivity.ClickProxy clickProxy) {
        ((MallLayoutGoodsDetailBottomBinding) this).f10969a = clickProxy;
        synchronized (this) {
            this.f10972a |= 8;
        }
        notifyPropertyChanged(hk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallLayoutGoodsDetailBottomBinding
    public void m(@Nullable GoodsDetailVM goodsDetailVM) {
        ((MallLayoutGoodsDetailBottomBinding) this).f10970a = goodsDetailVM;
        synchronized (this) {
            this.f10972a |= 4;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<GoodsDetailBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10972a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10972a |= 2;
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

    public MallLayoutGoodsDetailBottomBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (CardView) objArr[0]);
        this.f10972a = -1L;
        ((MallLayoutGoodsDetailBottomBinding) this).f35055a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[1];
        this.f10973a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f10974a = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[3];
        this.b = textView2;
        textView2.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[4];
        this.f10978a = bLTextView;
        bLTextView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
