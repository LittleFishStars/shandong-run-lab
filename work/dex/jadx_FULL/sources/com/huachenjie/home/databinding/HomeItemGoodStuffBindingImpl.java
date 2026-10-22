package com.huachenjie.home.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.home.R;
import com.huachenjie.home.bean.GoodStuffBean;
import com.noober.background.view.BLTextView;
import com.zj.adlib.ju3;
import com.zj.adlib.xk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class HomeItemGoodStuffBindingImpl extends HomeItemGoodStuffBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34270a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9468a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9469a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CardView f9470a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f9471a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34270a = sparseIntArray;
        sparseIntArray.put(R.id.tv_name, 8);
        sparseIntArray.put(R.id.ll_price, 9);
    }

    public HomeItemGoodStuffBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, f9468a, f34270a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        boolean z3;
        RequestOptions requestOptions;
        CharSequence charSequence;
        CharSequence charSequence2;
        String saleCount;
        String strFindTag;
        boolean zShowTag;
        boolean zShowStrike;
        CharSequence strikePrice;
        String strFindGoodsCover;
        synchronized (this) {
            j = this.f9469a;
            this.f9469a = 0L;
        }
        GoodStuffBean goodStuffBean = ((HomeItemGoodStuffBinding) this).f9467a;
        long j2 = j & 3;
        CharSequence price = null;
        if (j2 != 0) {
            requestOptions = ju3.s;
            if (goodStuffBean != null) {
                price = goodStuffBean.formatPrice();
                zShowTag = goodStuffBean.showTag();
                zShowStrike = goodStuffBean.showStrike();
                saleCount = goodStuffBean.formatSaleCount();
                strFindTag = goodStuffBean.findTag();
                strFindGoodsCover = goodStuffBean.findGoodsCover();
                strikePrice = goodStuffBean.formatStrikePrice();
            } else {
                zShowTag = false;
                zShowStrike = false;
                strikePrice = null;
                saleCount = null;
                strFindTag = null;
                strFindGoodsCover = null;
            }
            z3 = !TextUtils.isEmpty(price);
            CharSequence charSequence3 = strikePrice;
            charSequence = price;
            price = strFindGoodsCover;
            z2 = zShowStrike;
            z = zShowTag;
            charSequence2 = charSequence3;
        } else {
            z = false;
            z2 = false;
            z3 = false;
            requestOptions = null;
            charSequence = null;
            charSequence2 = null;
            saleCount = null;
            strFindTag = null;
        }
        if (j2 != 0) {
            CommonBindingAdapter.b0(((HomeItemGoodStuffBinding) this).f34269a, price, requestOptions, false);
            CommonBindingAdapter.l0(((HomeItemGoodStuffBinding) this).f9464a, z);
            TextViewBindingAdapter.setText(this.f9471a, strFindTag);
            CommonBindingAdapter.l0(((HomeItemGoodStuffBinding) this).f9465a, z3);
            TextViewBindingAdapter.setText(this.c, saleCount);
            TextViewBindingAdapter.setText(this.d, charSequence);
            CommonBindingAdapter.l0(this.e, z2);
            TextViewBindingAdapter.setText(this.e, charSequence2);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9469a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9469a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeItemGoodStuffBinding
    public void k(@Nullable GoodStuffBean goodStuffBean) {
        ((HomeItemGoodStuffBinding) this).f9467a = goodStuffBean;
        synchronized (this) {
            this.f9469a |= 1;
        }
        notifyPropertyChanged(xk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (xk0.g != i) {
            return false;
        }
        k((GoodStuffBean) obj);
        return true;
    }

    public HomeItemGoodStuffBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (ConstraintLayout) objArr[9], (LinearLayout) objArr[2], (TextView) objArr[4], (TextView) objArr[8], (TextView) objArr[7], (TextView) objArr[5], (TextView) objArr[6]);
        this.f9469a = -1L;
        ((HomeItemGoodStuffBinding) this).f34269a.setTag(null);
        ((HomeItemGoodStuffBinding) this).f9464a.setTag(null);
        CardView cardView = (CardView) objArr[0];
        this.f9470a = cardView;
        cardView.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[3];
        this.f9471a = bLTextView;
        bLTextView.setTag(null);
        ((HomeItemGoodStuffBinding) this).f9465a.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
