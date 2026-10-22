package com.huachenjie.mall.page.check_order;

import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.base.bean.mall.ShippingAddressBean;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.mall.bean.TradeBaseInfo;
import com.huachenjie.mall.bean.TradeOrderResult;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b0\u00101J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J$\u0010\n\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006R\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00068\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001c\u001a\u00020\u00068\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u000b8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001f\u0010\u0010R\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020!0\u000b8\u0006¢\u0006\f\n\u0004\b\"\u0010\u000e\u001a\u0004\b#\u0010\u0010R\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b8\u0006¢\u0006\f\n\u0004\b%\u0010\u000e\u001a\u0004\b&\u0010\u0010R\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020(0\u000b8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b)\u0010\u0010R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020+0\u000b8\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b,\u0010\u0010R\u0018\u0010/\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010\u0013¨\u00062"}, d2 = {"Lcom/huachenjie/mall/page/check_order/CheckOrderVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "u", "t", "v", "", "source", "traceNo", "exchangeCode", "y", "Landroidx/lifecycle/MutableLiveData;", "", "b", "Landroidx/lifecycle/MutableLiveData;", "m", "()Landroidx/lifecycle/MutableLiveData;", "goodsCount", "f", "Ljava/lang/String;", "q", "()Ljava/lang/String;", "x", "(Ljava/lang/String;)V", "skuNo", y6b.f, "n", "w", "goodsUnitPrice", "Lcom/huachenjie/base/bean/mall/ShippingAddressBean;", "c", t.d, "addressBean", "Lcom/huachenjie/mall/bean/TradeBaseInfo;", "d", "r", "tradeBaseInfo", "e", "p", "remark", "Lcom/huachenjie/mall/bean/TradeOrderResult;", "s", "tradeOrderResult", "", j.b, "refreshFlag", y6b.g, "requestId", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class CheckOrderVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: f, reason: collision with other field name and from kotlin metadata */
    public String skuNo;

    /* JADX INFO: renamed from: g, reason: collision with other field name and from kotlin metadata */
    public String goodsUnitPrice;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @Nullable
    public String requestId;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> goodsCount = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<ShippingAddressBean> addressBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<TradeBaseInfo> tradeBaseInfo = new MutableLiveData<>();

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> remark = new MutableLiveData<>();

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<TradeOrderResult> tradeOrderResult = new MutableLiveData<>();

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> refreshFlag = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<ShippingAddressBean> l() {
        return this.addressBean;
    }

    @NotNull
    public final MutableLiveData<Integer> m() {
        return this.goodsCount;
    }

    @NotNull
    public final String n() {
        String str = this.goodsUnitPrice;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("goodsUnitPrice");
        return null;
    }

    @NotNull
    public final MutableLiveData<Boolean> o() {
        return this.refreshFlag;
    }

    @NotNull
    public final MutableLiveData<String> p() {
        return this.remark;
    }

    @NotNull
    public final String q() {
        String str = this.skuNo;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("skuNo");
        return null;
    }

    @NotNull
    public final MutableLiveData<TradeBaseInfo> r() {
        return this.tradeBaseInfo;
    }

    @NotNull
    public final MutableLiveData<TradeOrderResult> s() {
        return this.tradeOrderResult;
    }

    public final void t() {
        BaseViewModelExtKt.b(this, false, false, null, null, new CheckOrderVM$queryDefaultAddress$1(this, null), 15, null);
    }

    public final void u() {
        BaseViewModelExtKt.b(this, true, false, null, null, new CheckOrderVM$queryTradeBaseInfo$1(this, null), 14, null);
    }

    public final void v() {
        BaseViewModelExtKt.b(this, false, false, null, null, new CheckOrderVM$queryTradeRequestId$1(this, null), 15, null);
    }

    public final void w(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.goodsUnitPrice = str;
    }

    public final void x(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.skuNo = str;
    }

    public final void y(@Nullable String source, @Nullable String traceNo, @Nullable String exchangeCode) {
        BaseViewModelExtKt.b(this, true, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.mall.page.check_order.CheckOrderVM$submitTradeOrder$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                this.this$0.v();
                this.this$0.u();
                if (resultException.getCode() == 9310101) {
                    this.this$0.o().setValue(Boolean.TRUE);
                }
                return Boolean.FALSE;
            }
        }, null, new CheckOrderVM$submitTradeOrder$2(this, source, traceNo, exchangeCode, null), 10, null);
    }
}
