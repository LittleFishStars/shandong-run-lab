package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.ViewStubProxy;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.mall.bean.MyRefundDetailBean;
import com.huachenjie.mall.page.refund_detail.RefundDetailActivity;
import com.huachenjie.mall.page.refund_detail.RefundDetailFileAdapter;
import com.huachenjie.mall.page.refund_detail.RefundDetailVM;
import com.huachenjie.mall.widget.OrderDetailServiceView;
import com.noober.background.view.BLButton;
import com.zj.adlib.hk0;
import com.zj.adlib.ju3;
import com.zj.adlib.xq8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallActivityRefundDetailBindingImpl extends MallActivityRefundDetailBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34840a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10347a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10348a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CardView f10349a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f10350a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f10351a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f10352a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f10353a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final OrderDetailServiceView f10354a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLButton f10355a;

    @NonNull
    public final BLButton b;

    @NonNull
    public final BLButton c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final LinearLayout f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    @NonNull
    public final TextView f10356f;

    @NonNull
    public final LinearLayout g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    @NonNull
    public final TextView f10357g;

    @NonNull
    public final LinearLayout h;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    @NonNull
    public final TextView f10358h;

    @NonNull
    public final TextView i;

    @NonNull
    public final TextView j;

    @NonNull
    public final TextView k;

    @NonNull
    public final TextView l;

    @NonNull
    public final TextView m;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RefundDetailActivity.ClickProxy f34841a;

        public a a(RefundDetailActivity.ClickProxy clickProxy) {
            this.f34841a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34841a.d(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RefundDetailActivity.ClickProxy f34842a;

        public b a(RefundDetailActivity.ClickProxy clickProxy) {
            this.f34842a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34842a.a(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RefundDetailActivity.ClickProxy f34843a;

        public c a(RefundDetailActivity.ClickProxy clickProxy) {
            this.f34843a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34843a.c(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(31);
        f10347a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{23}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34840a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.mall.R.id.vs_address, 24);
        sparseIntArray.put(com.huachenjie.mall.R.id.tv_sub_info, 25);
        sparseIntArray.put(com.huachenjie.mall.R.id.ll_info_price, 26);
        sparseIntArray.put(com.huachenjie.mall.R.id.ll_info_num, 27);
        sparseIntArray.put(com.huachenjie.mall.R.id.ll_info_reason, 28);
        sparseIntArray.put(com.huachenjie.mall.R.id.ll_info_time, 29);
        sparseIntArray.put(com.huachenjie.mall.R.id.ll_info_cert, 30);
    }

    public MallActivityRefundDetailBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 31, f10347a, f34840a));
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003d  */
    /* JADX WARN: Code duplicated, block: B:46:0x0151 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:47:0x0153  */
    /* JADX WARN: Code duplicated, block: B:48:0x0158  */
    /* JADX WARN: Code duplicated, block: B:51:0x015f  */
    /* JADX WARN: Code duplicated, block: B:52:0x0186  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String refundReason;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String goodsImage;
        String refundOrderNo;
        boolean z;
        String shopAccId;
        BindingTitleBean value;
        RefundDetailFileAdapter refundDetailFileAdapter;
        Integer value2;
        boolean zHideStatusSubDesc;
        String str6;
        String str7;
        boolean zShowChangeAddress;
        boolean zCanCancelRefund;
        String str8;
        String logisticSid;
        String goodsSpec;
        String goodsName;
        String logisticCoName;
        boolean zShowFillAddress;
        boolean z2;
        c cVar;
        b bVar;
        a aVar;
        Long l;
        String str9;
        String str10;
        String str11;
        String str12;
        String applyDesc;
        String shopNo;
        long j2;
        MutableLiveData<BindingTitleBean> mutableLiveDataI;
        int i;
        int i2;
        String str13;
        String refundAmount;
        synchronized (this) {
            j = this.f10348a;
            this.f10348a = 0L;
        }
        RefundDetailVM refundDetailVM = ((MallActivityRefundDetailBinding) this).f10344a;
        RefundDetailActivity.ClickProxy clickProxy = ((MallActivityRefundDetailBinding) this).f10343a;
        long j3 = 162 & j;
        RequestOptions requestOptions = j3 != 0 ? ju3.m : null;
        if ((183 & j) != 0) {
            if ((j & 161) == 0) {
                value2 = null;
            } else {
                MutableLiveData<Integer> mutableLiveDataN = refundDetailVM != null ? refundDetailVM.n() : null;
                updateLiveDataRegistration(0, mutableLiveDataN);
                if (mutableLiveDataN != null) {
                    value2 = mutableLiveDataN.getValue();
                } else {
                    value2 = null;
                }
            }
            if (j3 != 0) {
                MutableLiveData<MyRefundDetailBean> mutableLiveDataL = refundDetailVM != null ? refundDetailVM.l() : null;
                updateLiveDataRegistration(1, mutableLiveDataL);
                MyRefundDetailBean value3 = mutableLiveDataL != null ? mutableLiveDataL.getValue() : null;
                if (value3 != null) {
                    shopAccId = value3.getShopAccId();
                    str8 = value3.formatterStatusColor();
                    zHideStatusSubDesc = value3.hideStatusSubDesc();
                    goodsImage = value3.getGoodsImage();
                    str6 = value3.formatterStatusDesc();
                    logisticSid = value3.getLogisticSid();
                    applyDesc = value3.getApplyDesc();
                    goodsSpec = value3.getGoodsSpec();
                    goodsName = value3.getGoodsName();
                    refundAmount = value3.getRefundAmount();
                    int handleTime = value3.getHandleTime();
                    String memo = value3.getMemo();
                    logisticCoName = value3.getLogisticCoName();
                    zCanCancelRefund = value3.canCancelRefund();
                    refundOrderNo = value3.getRefundOrderNo();
                    shopNo = value3.getShopNo();
                    refundReason = value3.getRefundReason();
                    zShowFillAddress = value3.showFillAddress();
                    int applyTime = value3.getApplyTime();
                    boolean zShowBottomMenu = value3.showBottomMenu();
                    zShowChangeAddress = value3.showChangeAddress();
                    i = handleTime;
                    str13 = memo;
                    i2 = applyTime;
                    z = zShowBottomMenu;
                } else {
                    i = 0;
                    zShowChangeAddress = false;
                    i2 = 0;
                    z = false;
                    zHideStatusSubDesc = false;
                    zCanCancelRefund = false;
                    zShowFillAddress = false;
                    str13 = null;
                    shopAccId = null;
                    str8 = null;
                    goodsImage = null;
                    str6 = null;
                    logisticSid = null;
                    applyDesc = null;
                    goodsSpec = null;
                    goodsName = null;
                    refundAmount = null;
                    logisticCoName = null;
                    refundOrderNo = null;
                    shopNo = null;
                    refundReason = null;
                }
                z2 = !zHideStatusSubDesc;
                String str14 = str13;
                String str15 = String.format("¥%s", refundAmount);
                str9 = MyRefundDetailBean.formatterTime(i);
                str12 = MyRefundDetailBean.formatterTime(i2);
                j2 = 164;
                str11 = str15;
                str10 = str14;
            } else {
                str9 = null;
                str10 = null;
                str11 = null;
                str12 = null;
                zShowChangeAddress = false;
                z = false;
                shopAccId = null;
                str8 = null;
                zHideStatusSubDesc = false;
                goodsImage = null;
                str6 = null;
                logisticSid = null;
                applyDesc = null;
                goodsSpec = null;
                goodsName = null;
                logisticCoName = null;
                zCanCancelRefund = false;
                refundOrderNo = null;
                shopNo = null;
                refundReason = null;
                zShowFillAddress = false;
                j2 = 164;
                z2 = false;
            }
            if ((j & j2) != 0) {
                MutableLiveData<RefundDetailFileAdapter> mutableLiveDataK = refundDetailVM != null ? refundDetailVM.k() : null;
                updateLiveDataRegistration(2, mutableLiveDataK);
                RefundDetailFileAdapter value4 = mutableLiveDataK != null ? mutableLiveDataK.getValue() : null;
                if ((j & 176) == 0) {
                    value = null;
                } else {
                    if (refundDetailVM != null) {
                        mutableLiveDataI = refundDetailVM.i();
                    } else {
                        mutableLiveDataI = null;
                    }
                    updateLiveDataRegistration(4, mutableLiveDataI);
                    if (mutableLiveDataI != null) {
                        value = mutableLiveDataI.getValue();
                    } else {
                        value = null;
                    }
                }
                refundDetailFileAdapter = value4;
                str5 = str12;
                str = applyDesc;
                str7 = str9;
                str4 = str11;
                str3 = str10;
                str2 = shopNo;
            } else {
                str9 = str9;
            }
            if ((j & 176) == 0) {
                value = null;
            } else {
                if (refundDetailVM != null) {
                    mutableLiveDataI = refundDetailVM.i();
                } else {
                    mutableLiveDataI = null;
                }
                updateLiveDataRegistration(4, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value = mutableLiveDataI.getValue();
                } else {
                    value = null;
                }
            }
            refundDetailFileAdapter = value4;
            str5 = str12;
            str = applyDesc;
            str7 = str9;
            str4 = str11;
            str3 = str10;
            str2 = shopNo;
        } else {
            requestOptions = requestOptions;
            refundReason = null;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            goodsImage = null;
            refundOrderNo = null;
            z = false;
            shopAccId = null;
            value = null;
            refundDetailFileAdapter = null;
            value2 = null;
            zHideStatusSubDesc = false;
            str6 = null;
            str7 = null;
            zShowChangeAddress = false;
            zCanCancelRefund = false;
            str8 = null;
            logisticSid = null;
            goodsSpec = null;
            goodsName = null;
            logisticCoName = null;
            zShowFillAddress = false;
            z2 = false;
        }
        long j4 = j & 192;
        if (j4 == 0 || clickProxy == null) {
            cVar = null;
            bVar = null;
            aVar = null;
        } else {
            c cVar2 = this.f10353a;
            if (cVar2 == null) {
                cVar2 = new c();
                this.f10353a = cVar2;
            }
            c cVarA = cVar2.a(clickProxy);
            a aVar2 = this.f10351a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f10351a = aVar2;
            }
            a aVarA = aVar2.a(clickProxy);
            b bVar2 = this.f10352a;
            if (bVar2 == null) {
                bVar2 = new b();
                this.f10352a = bVar2;
            }
            b bVarA = bVar2.a(clickProxy);
            aVar = aVarA;
            bVar = bVarA;
            cVar = cVarA;
        }
        if (j3 != 0) {
            CommonBindingAdapter.b0(((MallActivityRefundDetailBinding) this).f34839a, goodsImage, requestOptions, false);
            TextViewBindingAdapter.setText(this.d, str4);
            TextViewBindingAdapter.setText(this.e, refundOrderNo);
            TextViewBindingAdapter.setText(this.f10356f, refundReason);
            TextViewBindingAdapter.setText(this.f10357g, str5);
            TextViewBindingAdapter.setText(this.f10358h, str);
            OrderDetailServiceView.setOrderDetailAccid(this.f10354a, shopAccId, str2);
            CommonBindingAdapter.l0(this.f10349a, z);
            TextViewBindingAdapter.setText(this.i, str3);
            CommonBindingAdapter.W(this.i, str8);
            CommonBindingAdapter.l0(this.f10355a, zCanCancelRefund);
            CommonBindingAdapter.l0(this.b, zShowFillAddress);
            CommonBindingAdapter.l0(this.c, zShowChangeAddress);
            TextViewBindingAdapter.setText(this.j, str7);
            CommonBindingAdapter.l0(this.k, z2);
            TextViewBindingAdapter.setText(this.k, str6);
            boolean z3 = zHideStatusSubDesc;
            CommonBindingAdapter.l0(this.g, z3);
            TextViewBindingAdapter.setText(this.l, logisticCoName);
            CommonBindingAdapter.l0(this.h, z3);
            TextViewBindingAdapter.setText(this.m, logisticSid);
            TextViewBindingAdapter.setText(((MallActivityRefundDetailBinding) this).f10339a, goodsName);
            TextViewBindingAdapter.setText(((MallActivityRefundDetailBinding) this).f10345b, goodsSpec);
        }
        if ((j & 161) != 0) {
            l = null;
            xq8.a(this.f10350a, value2, null);
        } else {
            l = null;
        }
        if (j4 != 0) {
            CommonBindingAdapter.q(this.e, cVar, l);
            CommonBindingAdapter.q(this.f10355a, bVar, l);
            a aVar3 = aVar;
            CommonBindingAdapter.q(this.b, aVar3, l);
            CommonBindingAdapter.q(this.c, aVar3, l);
        }
        if ((j & 164) != 0) {
            CommonBindingAdapter.g(((MallActivityRefundDetailBinding) this).f10341a, refundDetailFileAdapter, false, false);
        }
        if ((j & 176) != 0) {
            ((MallActivityRefundDetailBinding) this).f10342a.k(value);
        }
        ViewDataBinding.executeBindingsOn(((MallActivityRefundDetailBinding) this).f10342a);
        if (((MallActivityRefundDetailBinding) this).f10340a.getBinding() != null) {
            ViewDataBinding.executeBindingsOn(((MallActivityRefundDetailBinding) this).f10340a.getBinding());
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10348a != 0) {
                return true;
            }
            return ((MallActivityRefundDetailBinding) this).f10342a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10348a = 128L;
        }
        ((MallActivityRefundDetailBinding) this).f10342a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityRefundDetailBinding
    public void l(@Nullable RefundDetailActivity.ClickProxy clickProxy) {
        ((MallActivityRefundDetailBinding) this).f10343a = clickProxy;
        synchronized (this) {
            this.f10348a |= 64;
        }
        notifyPropertyChanged(hk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityRefundDetailBinding
    public void m(@Nullable RefundDetailVM refundDetailVM) {
        ((MallActivityRefundDetailBinding) this).f10344a = refundDetailVM;
        synchronized (this) {
            this.f10348a |= 32;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean n(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10348a |= 8;
        }
        return true;
    }

    public final boolean o(MutableLiveData<RefundDetailFileAdapter> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10348a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return q((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return o((MutableLiveData) obj, i2);
        }
        if (i == 3) {
            return n((LayoutToolbarBindingBinding) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return r((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<MyRefundDetailBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10348a |= 2;
        }
        return true;
    }

    public final boolean q(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10348a |= 1;
        }
        return true;
    }

    public final boolean r(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10348a |= 16;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((MallActivityRefundDetailBinding) this).f10342a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 == i) {
            m((RefundDetailVM) obj);
        } else {
            if (hk0.k != i) {
                return false;
            }
            l((RefundDetailActivity.ClickProxy) obj);
        }
        return true;
    }

    public MallActivityRefundDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (ImageView) objArr[9], (LinearLayout) objArr[30], (LinearLayout) objArr[27], (LinearLayout) objArr[26], (LinearLayout) objArr[28], (LinearLayout) objArr[29], (RecyclerView) objArr[17], (LayoutToolbarBindingBinding) objArr[23], (TextView) objArr[10], (TextView) objArr[11], (TextView) objArr[25], new ViewStubProxy((ViewStub) objArr[24]));
        this.f10348a = -1L;
        ((MallActivityRefundDetailBinding) this).f34839a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f = linearLayout;
        linearLayout.setTag(null);
        StateLayout stateLayout = (StateLayout) objArr[1];
        this.f10350a = stateLayout;
        stateLayout.setTag(null);
        TextView textView = (TextView) objArr[12];
        this.d = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[13];
        this.e = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[14];
        this.f10356f = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[15];
        this.f10357g = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[16];
        this.f10358h = textView5;
        textView5.setTag(null);
        OrderDetailServiceView orderDetailServiceView = (OrderDetailServiceView) objArr[18];
        this.f10354a = orderDetailServiceView;
        orderDetailServiceView.setTag(null);
        CardView cardView = (CardView) objArr[19];
        this.f10349a = cardView;
        cardView.setTag(null);
        TextView textView6 = (TextView) objArr[2];
        this.i = textView6;
        textView6.setTag(null);
        BLButton bLButton = (BLButton) objArr[20];
        this.f10355a = bLButton;
        bLButton.setTag(null);
        BLButton bLButton2 = (BLButton) objArr[21];
        this.b = bLButton2;
        bLButton2.setTag(null);
        BLButton bLButton3 = (BLButton) objArr[22];
        this.c = bLButton3;
        bLButton3.setTag(null);
        TextView textView7 = (TextView) objArr[3];
        this.j = textView7;
        textView7.setTag(null);
        TextView textView8 = (TextView) objArr[4];
        this.k = textView8;
        textView8.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[5];
        this.g = linearLayout2;
        linearLayout2.setTag(null);
        TextView textView9 = (TextView) objArr[6];
        this.l = textView9;
        textView9.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) objArr[7];
        this.h = linearLayout3;
        linearLayout3.setTag(null);
        TextView textView10 = (TextView) objArr[8];
        this.m = textView10;
        textView10.setTag(null);
        ((MallActivityRefundDetailBinding) this).f10341a.setTag(null);
        setContainedBinding(((MallActivityRefundDetailBinding) this).f10342a);
        ((MallActivityRefundDetailBinding) this).f10339a.setTag(null);
        ((MallActivityRefundDetailBinding) this).f10345b.setTag(null);
        ((MallActivityRefundDetailBinding) this).f10340a.setContainingBinding(this);
        setRootTag(view);
        invalidateAll();
    }
}
