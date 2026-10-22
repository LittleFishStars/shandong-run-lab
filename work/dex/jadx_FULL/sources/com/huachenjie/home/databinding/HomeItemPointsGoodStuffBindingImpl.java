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
import com.huachenjie.home.bean.PointsGoodsBean;
import com.noober.background.view.BLTextView;
import com.zj.adlib.ju3;
import com.zj.adlib.xk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class HomeItemPointsGoodStuffBindingImpl extends HomeItemPointsGoodStuffBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34286a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9517a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9518a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CardView f9519a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f9520a;

    @NonNull
    public final BLTextView b;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34286a = sparseIntArray;
        sparseIntArray.put(R.id.tv_name, 8);
        sparseIntArray.put(R.id.ll_price, 9);
    }

    public HomeItemPointsGoodStuffBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, f9517a, f34286a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        RequestOptions requestOptions;
        String strFindDeduction;
        CharSequence charSequence;
        String strFindBargainPrice;
        String strFindTag;
        int neededPoints;
        String strFindGoodsCover;
        synchronized (this) {
            j = this.f9518a;
            this.f9518a = 0L;
        }
        PointsGoodsBean pointsGoodsBean = ((HomeItemPointsGoodStuffBinding) this).f9516a;
        long j2 = j & 3;
        CharSequence price = null;
        if (j2 != 0) {
            requestOptions = ju3.s;
            if (pointsGoodsBean != null) {
                price = pointsGoodsBean.formatPrice();
                neededPoints = pointsGoodsBean.getNeededPoints();
                strFindBargainPrice = pointsGoodsBean.findBargainPrice();
                strFindTag = pointsGoodsBean.findTag();
                strFindGoodsCover = pointsGoodsBean.findGoodsCover();
                strFindDeduction = pointsGoodsBean.findDeduction();
            } else {
                neededPoints = 0;
                strFindDeduction = null;
                strFindBargainPrice = null;
                strFindTag = null;
                strFindGoodsCover = null;
            }
            z2 = !TextUtils.isEmpty(price);
            boolean z3 = neededPoints > 0;
            charSequence = price;
            price = strFindGoodsCover;
            z = z3;
        } else {
            z = false;
            z2 = false;
            requestOptions = null;
            strFindDeduction = null;
            charSequence = null;
            strFindBargainPrice = null;
            strFindTag = null;
        }
        if (j2 != 0) {
            CommonBindingAdapter.b0(((HomeItemPointsGoodStuffBinding) this).f34285a, price, requestOptions, false);
            CommonBindingAdapter.l0(((HomeItemPointsGoodStuffBinding) this).f9513a, z);
            TextViewBindingAdapter.setText(this.f9520a, strFindBargainPrice);
            TextViewBindingAdapter.setText(this.b, strFindTag);
            CommonBindingAdapter.l0(((HomeItemPointsGoodStuffBinding) this).f9514a, z2);
            TextViewBindingAdapter.setText(this.c, strFindDeduction);
            TextViewBindingAdapter.setText(this.d, charSequence);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9518a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9518a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeItemPointsGoodStuffBinding
    public void k(@Nullable PointsGoodsBean pointsGoodsBean) {
        ((HomeItemPointsGoodStuffBinding) this).f9516a = pointsGoodsBean;
        synchronized (this) {
            this.f9518a |= 1;
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
        k((PointsGoodsBean) obj);
        return true;
    }

    public HomeItemPointsGoodStuffBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageView) objArr[1], (ConstraintLayout) objArr[9], (LinearLayout) objArr[3], (TextView) objArr[5], (TextView) objArr[8], (TextView) objArr[7], (TextView) objArr[6]);
        this.f9518a = -1L;
        ((HomeItemPointsGoodStuffBinding) this).f34285a.setTag(null);
        ((HomeItemPointsGoodStuffBinding) this).f9513a.setTag(null);
        CardView cardView = (CardView) objArr[0];
        this.f9519a = cardView;
        cardView.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[2];
        this.f9520a = bLTextView;
        bLTextView.setTag(null);
        BLTextView bLTextView2 = (BLTextView) objArr[4];
        this.b = bLTextView2;
        bLTextView2.setTag(null);
        ((HomeItemPointsGoodStuffBinding) this).f9514a.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
