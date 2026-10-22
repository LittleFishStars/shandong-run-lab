package com.huachenjie.mall.page.check_order;

import com.huachenjie.base.bean.mall.ShippingAddressBean;
import com.huachenjie.mall.api.MallModel;
import com.huachenjie.mall.bean.TradeBaseInfo;
import com.huachenjie.mall.bean.TradeOrderResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mall.page.check_order.CheckOrderVM$submitTradeOrder$2", f = "CheckOrderVM.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nCheckOrderVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CheckOrderVM.kt\ncom/huachenjie/mall/page/check_order/CheckOrderVM$submitTradeOrder$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,95:1\n1#2:96\n*E\n"})
public final class CheckOrderVM$submitTradeOrder$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $exchangeCode;
    final /* synthetic */ String $source;
    final /* synthetic */ String $traceNo;
    int label;
    final /* synthetic */ CheckOrderVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckOrderVM$submitTradeOrder$2(CheckOrderVM checkOrderVM, String str, String str2, String str3, Continuation<? super CheckOrderVM$submitTradeOrder$2> continuation) {
        super(2, continuation);
        this.this$0 = checkOrderVM;
        this.$source = str;
        this.$traceNo = str2;
        this.$exchangeCode = str3;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CheckOrderVM$submitTradeOrder$2(this.this$0, this.$source, this.$traceNo, this.$exchangeCode, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        TradeBaseInfo value;
        Object objK0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ShippingAddressBean value2 = this.this$0.l().getValue();
            if (value2 != null && (value = this.this$0.r().getValue()) != null) {
                MallModel mallModel = MallModel.f34763a;
                String addressNo = value2.getAddressNo();
                String shopNo = value.getGoodsInfo().getShopNo();
                String goodsNo = value.getGoodsInfo().getGoodsNo();
                String skuNo = value.getGoodsInfo().getSkuNo();
                Integer value3 = this.this$0.m().getValue();
                if (value3 == null) {
                    value3 = Boxing.boxInt(1);
                }
                int iIntValue = value3.intValue();
                String goodsPriceTotal = value.getTotalPrice().getGoodsPriceTotal();
                int payPointsTotal = value.getTotalPrice().getPayPointsTotal();
                String orderAmount = value.getTotalPrice().getOrderAmount();
                String postage = value.getTotalPrice().getPostage();
                String value4 = this.this$0.p().getValue();
                String str = value4 == null ? "" : value4;
                String goodsUnitPrice = value.getGoodsInfo().getGoodsUnitPrice();
                int payPointsUnit = value.getGoodsInfo().getPayPointsUnit();
                String str2 = this.this$0.requestId;
                String str3 = str2 == null ? "" : str2;
                String str4 = this.$source;
                String str5 = this.$traceNo;
                String str6 = this.$exchangeCode;
                this.label = 1;
                objK0 = mallModel.k0(addressNo, shopNo, goodsNo, skuNo, iIntValue, goodsPriceTotal, payPointsTotal, orderAmount, postage, str, goodsUnitPrice, payPointsUnit, str3, str4, str5, str6, this);
                if (objK0 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        objK0 = obj;
        TradeOrderResult tradeOrderResult = (TradeOrderResult) objK0;
        if (tradeOrderResult != null) {
            this.this$0.s().setValue(tradeOrderResult);
        }
        return Unit.INSTANCE;
    }
}
