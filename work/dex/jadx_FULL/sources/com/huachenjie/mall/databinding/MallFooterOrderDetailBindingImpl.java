package com.huachenjie.mall.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.base.bean.mall.OrderDetailBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.order_detail.OrderDetailActivity;
import com.huachenjie.mall.page.order_detail.OrderDetailVM;
import com.huachenjie.mall.widget.OrderDetailServiceView;
import com.huachenjie.mall.widget.PriceView;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallFooterOrderDetailBindingImpl extends MallFooterOrderDetailBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34937a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10630a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10631a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f10632a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f10633a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final OrderDetailServiceView f10634a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final PriceView f10635a;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final LinearLayout e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @NonNull
    public final TextView f10636e;

    @NonNull
    public final LinearLayout f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    @NonNull
    public final TextView f10637f;

    @NonNull
    public final LinearLayout g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    @NonNull
    public final TextView f10638g;

    @NonNull
    public final LinearLayout h;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    @NonNull
    public final TextView f10639h;

    @NonNull
    public final LinearLayout i;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    @NonNull
    public final TextView f10640i;

    @NonNull
    public final LinearLayout j;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    @NonNull
    public final TextView f10641j;

    @NonNull
    public final LinearLayout k;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    @NonNull
    public final TextView f10642k;

    @NonNull
    public final TextView l;

    @NonNull
    public final TextView m;

    @NonNull
    public final TextView n;

    @NonNull
    public final TextView o;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OrderDetailActivity.ClickProxy f34938a;

        public a a(OrderDetailActivity.ClickProxy clickProxy) {
            this.f34938a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34938a.k(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public OrderDetailActivity.ClickProxy f34939a;

        public b a(OrderDetailActivity.ClickProxy clickProxy) {
            this.f34939a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34939a.d(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34937a = sparseIntArray;
        sparseIntArray.put(R.id.v_line, 23);
        sparseIntArray.put(R.id.ll_price, 24);
        sparseIntArray.put(R.id.ll_freight, 25);
        sparseIntArray.put(R.id.tv_freight, 26);
        sparseIntArray.put(R.id.tv_point, 27);
        sparseIntArray.put(R.id.ll_all_pay, 28);
    }

    public MallFooterOrderDetailBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 29, f10630a, f34937a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        boolean payStatus;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        OrderDetailBean value;
        String str;
        String string;
        String str2;
        String shopAccId;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        a aVarA;
        b bVarA;
        String str13;
        String str14;
        long finishTime;
        long payTime;
        long cancelTime;
        long submitTime;
        long deliveryTime;
        int payPointsTotal;
        String postage;
        String payTypeDesc;
        String orderNo;
        String goodsPriceTotal;
        String shopNo;
        String cancelReason;
        synchronized (this) {
            j = this.f10631a;
            this.f10631a = 0L;
        }
        OrderDetailVM orderDetailVM = ((MallFooterOrderDetailBinding) this).f10628a;
        OrderDetailActivity.ClickProxy clickProxy = ((MallFooterOrderDetailBinding) this).f10627a;
        long j2 = j & 11;
        if (j2 != 0) {
            MutableLiveData<OrderDetailBean> mutableLiveDataQ = orderDetailVM != null ? orderDetailVM.q() : null;
            updateLiveDataRegistration(0, mutableLiveDataQ);
            value = mutableLiveDataQ != null ? mutableLiveDataQ.getValue() : null;
            if (value != null) {
                finishTime = value.getFinishTime();
                shopAccId = value.getShopAccId();
                postage = value.getPostage();
                payTime = value.getPayTime();
                payTypeDesc = value.getPayTypeDesc();
                payPointsTotal = value.getPayPointsTotal();
                orderNo = value.getOrderNo();
                goodsPriceTotal = value.getGoodsPriceTotal();
                payStatus = value.getPayStatus();
                shopNo = value.getShopNo();
                cancelReason = value.getCancelReason();
                cancelTime = value.getCancelTime();
                submitTime = value.getSubmitTime();
                deliveryTime = value.getDeliveryTime();
            } else {
                finishTime = 0;
                payTime = 0;
                cancelTime = 0;
                submitTime = 0;
                deliveryTime = 0;
                payPointsTotal = 0;
                payStatus = false;
                shopAccId = null;
                postage = null;
                payTypeDesc = null;
                orderNo = null;
                goodsPriceTotal = null;
                shopNo = null;
                cancelReason = null;
            }
            if (j2 != 0) {
                j = payStatus ? j | 32 | 128 : j | 16 | 64;
            }
            str3 = OrderDetailBean.formatterTime(finishTime);
            boolean z7 = finishTime > 0;
            str2 = String.format("¥ %s", postage);
            z = payTime > 0;
            str4 = OrderDetailBean.formatterTime(payTime);
            boolean zIsEmpty = TextUtils.isEmpty(payTypeDesc);
            boolean z8 = payPointsTotal > 0;
            str5 = String.format(this.l.getResources().getString(R.string.mall_order_detail_point_formatter), Integer.valueOf(payPointsTotal));
            str = String.format("¥ %s", goodsPriceTotal);
            string = this.m.getResources().getString(payStatus ? R.string.mall_my_order_pay_pre2 : R.string.mall_my_order_pay_pre1);
            str6 = OrderDetailBean.formatterTime(cancelTime);
            boolean z9 = cancelTime > 0;
            z2 = z7;
            z3 = !zIsEmpty;
            z4 = z8;
            z5 = z9;
            str7 = payTypeDesc;
            str8 = OrderDetailBean.formatterTime(submitTime);
            str9 = orderNo;
            z6 = deliveryTime > 0;
            str10 = shopNo;
            str11 = cancelReason;
            str12 = OrderDetailBean.formatterTime(deliveryTime);
        } else {
            z = false;
            payStatus = false;
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
            z6 = false;
            value = null;
            str = null;
            string = null;
            str2 = null;
            shopAccId = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
            str9 = null;
            str10 = null;
            str11 = null;
            str12 = null;
        }
        long j3 = j & 12;
        if (j3 == 0 || clickProxy == null) {
            aVarA = null;
            bVarA = null;
        } else {
            b bVar = this.f10633a;
            if (bVar == null) {
                bVar = new b();
                this.f10633a = bVar;
            }
            bVarA = bVar.a(clickProxy);
            a aVar = this.f10632a;
            if (aVar == null) {
                aVar = new a();
                this.f10632a = aVar;
            }
            aVarA = aVar.a(clickProxy);
        }
        if ((j & 64) != 0) {
            str13 = String.format("¥%s", value != null ? value.getOrderAmount() : null);
        } else {
            bVarA = bVarA;
            str13 = null;
        }
        if ((128 & j) != 0) {
            str14 = String.format("¥%s", value != null ? value.getPayAmount() : null);
        } else {
            str14 = null;
        }
        long j4 = j & 11;
        if (j4 == 0) {
            str13 = null;
        } else if (payStatus) {
            str13 = str14;
        }
        if (j4 != 0) {
            CommonBindingAdapter.l0(super.c, z4);
            TextViewBindingAdapter.setText(this.c, str);
            TextViewBindingAdapter.setText(this.d, str8);
            CommonBindingAdapter.l0(this.f, z);
            TextViewBindingAdapter.setText(this.f10636e, str4);
            CommonBindingAdapter.l0(this.g, z6);
            TextViewBindingAdapter.setText(this.f10637f, str12);
            CommonBindingAdapter.l0(this.h, z2);
            TextViewBindingAdapter.setText(this.f10638g, str3);
            boolean z10 = z5;
            CommonBindingAdapter.l0(this.i, z10);
            TextViewBindingAdapter.setText(this.f10639h, str6);
            CommonBindingAdapter.l0(this.j, z10);
            TextViewBindingAdapter.setText(this.f10640i, str2);
            TextViewBindingAdapter.setText(this.f10641j, str11);
            OrderDetailServiceView.setOrderDetailAccid(this.f10634a, shopAccId, str10);
            TextViewBindingAdapter.setText(this.l, str5);
            TextViewBindingAdapter.setText(this.m, string);
            TextViewBindingAdapter.setText(this.f10635a, str13);
            TextViewBindingAdapter.setText(this.n, str9);
            CommonBindingAdapter.l0(this.k, z3);
            TextViewBindingAdapter.setText(this.o, str7);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.f10642k, aVarA, null);
            CommonBindingAdapter.q(this.n, bVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10631a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10631a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallFooterOrderDetailBinding
    public void l(@Nullable OrderDetailActivity.ClickProxy clickProxy) {
        ((MallFooterOrderDetailBinding) this).f10627a = clickProxy;
        synchronized (this) {
            this.f10631a |= 4;
        }
        notifyPropertyChanged(hk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallFooterOrderDetailBinding
    public void m(@Nullable OrderDetailVM orderDetailVM) {
        ((MallFooterOrderDetailBinding) this).f10628a = orderDetailVM;
        synchronized (this) {
            this.f10631a |= 2;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<OrderDetailBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10631a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 == i) {
            m((OrderDetailVM) obj);
        } else {
            if (hk0.k != i) {
                return false;
            }
            l((OrderDetailActivity.ClickProxy) obj);
        }
        return true;
    }

    public MallFooterOrderDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (LinearLayout) objArr[28], (LinearLayout) objArr[25], (LinearLayout) objArr[3], (LinearLayout) objArr[24], (TextView) objArr[26], (TextView) objArr[27], (View) objArr[23]);
        this.f10631a = -1L;
        super.c.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.e = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.c = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[10];
        this.d = textView2;
        textView2.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[11];
        this.f = linearLayout2;
        linearLayout2.setTag(null);
        TextView textView3 = (TextView) objArr[12];
        this.f10636e = textView3;
        textView3.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) objArr[13];
        this.g = linearLayout3;
        linearLayout3.setTag(null);
        TextView textView4 = (TextView) objArr[14];
        this.f10637f = textView4;
        textView4.setTag(null);
        LinearLayout linearLayout4 = (LinearLayout) objArr[15];
        this.h = linearLayout4;
        linearLayout4.setTag(null);
        TextView textView5 = (TextView) objArr[16];
        this.f10638g = textView5;
        textView5.setTag(null);
        LinearLayout linearLayout5 = (LinearLayout) objArr[17];
        this.i = linearLayout5;
        linearLayout5.setTag(null);
        TextView textView6 = (TextView) objArr[18];
        this.f10639h = textView6;
        textView6.setTag(null);
        LinearLayout linearLayout6 = (LinearLayout) objArr[19];
        this.j = linearLayout6;
        linearLayout6.setTag(null);
        TextView textView7 = (TextView) objArr[2];
        this.f10640i = textView7;
        textView7.setTag(null);
        TextView textView8 = (TextView) objArr[20];
        this.f10641j = textView8;
        textView8.setTag(null);
        TextView textView9 = (TextView) objArr[21];
        this.f10642k = textView9;
        textView9.setTag(null);
        OrderDetailServiceView orderDetailServiceView = (OrderDetailServiceView) objArr[22];
        this.f10634a = orderDetailServiceView;
        orderDetailServiceView.setTag(null);
        TextView textView10 = (TextView) objArr[4];
        this.l = textView10;
        textView10.setTag(null);
        TextView textView11 = (TextView) objArr[5];
        this.m = textView11;
        textView11.setTag(null);
        PriceView priceView = (PriceView) objArr[6];
        this.f10635a = priceView;
        priceView.setTag(null);
        TextView textView12 = (TextView) objArr[7];
        this.n = textView12;
        textView12.setTag(null);
        LinearLayout linearLayout7 = (LinearLayout) objArr[8];
        this.k = linearLayout7;
        linearLayout7.setTag(null);
        TextView textView13 = (TextView) objArr[9];
        this.o = textView13;
        textView13.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
