package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.view.ExpandableTextView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailBean;
import com.huachenjie.mall.page.goods_detail.GoodsDetailActivity;
import com.huachenjie.mall.page.goods_detail.GoodsDetailVM;
import com.huachenjie.mall.widget.PriceView;
import com.noober.background.view.BLRelativeLayout;
import com.zj.adlib.aw9;
import com.zj.adlib.hk0;
import com.zj.adlib.ju3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallViewGoodsDetailHeaderActivityContentBindingImpl extends MallViewGoodsDetailHeaderActivityContentBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35080a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11029a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11030a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f11031a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f11032a;

    @NonNull
    public final View b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final ExpandableTextView f11033b;

    @NonNull
    public final TextView c;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public GoodsDetailActivity.ClickProxy f35081a;

        public a a(GoodsDetailActivity.ClickProxy clickProxy) {
            this.f35081a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35081a.a(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35080a = sparseIntArray;
        sparseIntArray.put(R.id.v_line, 9);
        sparseIntArray.put(R.id.rl_info, 10);
    }

    public MallViewGoodsDetailHeaderActivityContentBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, f11029a, f35080a));
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003f  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        String value;
        String str5;
        String goodsName;
        a aVarA;
        String activityBg;
        String salePoint;
        String activityPriceLabel;
        String saleCount;
        synchronized (this) {
            j = this.f11030a;
            this.f11030a = 0L;
        }
        GoodsDetailVM goodsDetailVM = ((MallViewGoodsDetailHeaderActivityContentBinding) this).f11026a;
        GoodsDetailActivity.ClickProxy clickProxy = ((MallViewGoodsDetailHeaderActivityContentBinding) this).f11025a;
        long j2 = 42 & j;
        RequestOptions requestOptions = j2 != 0 ? ju3.h : null;
        if ((47 & j) != 0) {
            if ((j & 41) == 0) {
                value = null;
            } else {
                MutableLiveData<String> mutableLiveDataV = goodsDetailVM != null ? goodsDetailVM.v() : null;
                updateLiveDataRegistration(0, mutableLiveDataV);
                if (mutableLiveDataV != null) {
                    value = mutableLiveDataV.getValue();
                } else {
                    value = null;
                }
            }
            if (j2 != 0) {
                MutableLiveData<GoodsDetailBean> mutableLiveDataU = goodsDetailVM != null ? goodsDetailVM.u() : null;
                updateLiveDataRegistration(1, mutableLiveDataU);
                GoodsDetailBean value2 = mutableLiveDataU != null ? mutableLiveDataU.getValue() : null;
                if (value2 != null) {
                    saleCount = value2.getSaleCount();
                    activityBg = value2.getActivityBg();
                    salePoint = value2.getSalePoint();
                    activityPriceLabel = value2.getActivityPriceLabel();
                    goodsName = value2.getGoodsName();
                } else {
                    goodsName = null;
                    saleCount = null;
                    activityBg = null;
                    salePoint = null;
                    activityPriceLabel = null;
                }
                str2 = String.format("已售  %s", saleCount);
            } else {
                str2 = null;
                goodsName = null;
                activityBg = null;
                salePoint = null;
                activityPriceLabel = null;
            }
            if ((j & 44) != 0) {
                MutableLiveData<String> mutableLiveDataW = goodsDetailVM != null ? goodsDetailVM.w() : null;
                updateLiveDataRegistration(2, mutableLiveDataW);
                str = String.format("日常价  %s", mutableLiveDataW != null ? mutableLiveDataW.getValue() : null);
                str3 = activityBg;
                str4 = salePoint;
                str5 = activityPriceLabel;
            } else {
                str3 = activityBg;
                str4 = salePoint;
                str5 = activityPriceLabel;
                str = null;
            }
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            value = null;
            str5 = null;
            goodsName = null;
        }
        long j3 = j & 48;
        if (j3 == 0 || clickProxy == null) {
            aVarA = null;
        } else {
            a aVar = this.f11032a;
            if (aVar == null) {
                aVar = new a();
                this.f11032a = aVar;
            }
            aVarA = aVar.a(clickProxy);
        }
        if (j2 != 0) {
            CommonBindingAdapter.b0(this.f11031a, str3, requestOptions, false);
            TextViewBindingAdapter.setText(this.c, str2);
            aw9.f(this.f11033b, str4);
            aw9.f(((MallViewGoodsDetailHeaderActivityContentBinding) this).f11024a, goodsName);
            TextViewBindingAdapter.setText(((MallViewGoodsDetailHeaderActivityContentBinding) this).b, str5);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.b, aVarA, null);
        }
        if ((44 & j) != 0) {
            TextViewBindingAdapter.setText(((MallViewGoodsDetailHeaderActivityContentBinding) this).f11023a, str);
        }
        if ((j & 41) != 0) {
            TextViewBindingAdapter.setText(((MallViewGoodsDetailHeaderActivityContentBinding) this).f11027a, value);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11030a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11030a = 32L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallViewGoodsDetailHeaderActivityContentBinding
    public void l(@Nullable GoodsDetailActivity.ClickProxy clickProxy) {
        ((MallViewGoodsDetailHeaderActivityContentBinding) this).f11025a = clickProxy;
        synchronized (this) {
            this.f11030a |= 16;
        }
        notifyPropertyChanged(hk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallViewGoodsDetailHeaderActivityContentBinding
    public void m(@Nullable GoodsDetailVM goodsDetailVM) {
        ((MallViewGoodsDetailHeaderActivityContentBinding) this).f11026a = goodsDetailVM;
        synchronized (this) {
            this.f11030a |= 8;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<GoodsDetailBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f11030a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<String> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f11030a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return o((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return n((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return p((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<String> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f11030a |= 4;
        }
        return true;
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

    public MallViewGoodsDetailHeaderActivityContentBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (RelativeLayout) objArr[0], (BLRelativeLayout) objArr[10], (ExpandableTextView) objArr[7], (TextView) objArr[4], (PriceView) objArr[3], (TextView) objArr[2], (View) objArr[9]);
        this.f11030a = -1L;
        ImageView imageView = (ImageView) objArr[1];
        this.f11031a = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[5];
        this.c = textView;
        textView.setTag(null);
        View view2 = (View) objArr[6];
        this.b = view2;
        view2.setTag(null);
        ExpandableTextView expandableTextView = (ExpandableTextView) objArr[8];
        this.f11033b = expandableTextView;
        expandableTextView.setTag(null);
        ((MallViewGoodsDetailHeaderActivityContentBinding) this).f11022a.setTag(null);
        ((MallViewGoodsDetailHeaderActivityContentBinding) this).f11024a.setTag(null);
        ((MallViewGoodsDetailHeaderActivityContentBinding) this).f11023a.setTag(null);
        ((MallViewGoodsDetailHeaderActivityContentBinding) this).f11027a.setTag(null);
        ((MallViewGoodsDetailHeaderActivityContentBinding) this).b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
