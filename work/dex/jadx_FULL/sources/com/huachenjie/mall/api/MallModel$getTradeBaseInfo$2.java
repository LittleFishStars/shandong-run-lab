package com.huachenjie.mall.api;

import com.huachenjie.common.reconfig.net.IResponse;
import com.huachenjie.mall.bean.TradeBaseInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\u008a@"}, d2 = {"Lcom/huachenjie/common/reconfig/net/IResponse;", "Lcom/huachenjie/mall/bean/TradeBaseInfo;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mall.api.MallModel$getTradeBaseInfo$2", f = "MallModel.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
public final class MallModel$getTradeBaseInfo$2 extends SuspendLambda implements Function1<Continuation<? super IResponse<TradeBaseInfo>>, Object> {
    final /* synthetic */ String $addressNo;
    final /* synthetic */ int $goodsCount;
    final /* synthetic */ String $goodsUnitPrice;
    final /* synthetic */ String $skuNo;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MallModel$getTradeBaseInfo$2(int i, String str, String str2, String str3, Continuation<? super MallModel$getTradeBaseInfo$2> continuation) {
        super(1, continuation);
        this.$goodsCount = i;
        this.$skuNo = str;
        this.$goodsUnitPrice = str2;
        this.$addressNo = str3;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new MallModel$getTradeBaseInfo$2(this.$goodsCount, this.$skuNo, this.$goodsUnitPrice, this.$addressNo, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super IResponse<TradeBaseInfo>> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MallApi mallApiA = MallModel.f34763a.a();
            int i2 = this.$goodsCount;
            String str = this.$skuNo;
            String str2 = this.$goodsUnitPrice;
            String str3 = this.$addressNo;
            this.label = 1;
            obj = mallApiA.i0(i2, str, str2, str3, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
