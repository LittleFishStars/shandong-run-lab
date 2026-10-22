package com.huachenjie.mall.page.check_order;

import com.huachenjie.base.bean.mall.ShippingAddressBean;
import com.huachenjie.mall.api.MallModel;
import com.huachenjie.mall.bean.TradeBaseInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mall.page.check_order.CheckOrderVM$queryTradeBaseInfo$1", f = "CheckOrderVM.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
public final class CheckOrderVM$queryTradeBaseInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CheckOrderVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckOrderVM$queryTradeBaseInfo$1(CheckOrderVM checkOrderVM, Continuation<? super CheckOrderVM$queryTradeBaseInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = checkOrderVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CheckOrderVM$queryTradeBaseInfo$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MallModel mallModel = MallModel.f34763a;
            Integer value = this.this$0.m().getValue();
            Intrinsics.checkNotNull(value);
            int iIntValue = value.intValue();
            String strQ = this.this$0.q();
            String strN = this.this$0.n();
            ShippingAddressBean value2 = this.this$0.l().getValue();
            String addressNo = value2 != null ? value2.getAddressNo() : null;
            this.label = 1;
            obj = mallModel.m(iIntValue, strQ, strN, addressNo, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        TradeBaseInfo tradeBaseInfo = (TradeBaseInfo) obj;
        if (tradeBaseInfo == null) {
            return Unit.INSTANCE;
        }
        this.this$0.r().setValue(tradeBaseInfo);
        return Unit.INSTANCE;
    }
}
