package com.huachenjie.mall.api;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huachenjie.common.reconfig.net.IResponse;
import com.huachenjie.mall.bean.OrderPayBean;
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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\u008a@"}, d2 = {"Lcom/huachenjie/common/reconfig/net/IResponse;", "Lcom/huachenjie/mall/bean/OrderPayBean;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mall.api.MallModel$orderTradePay$2", f = "MallModel.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_FORCE_CLOSE_CODEC}, m = "invokeSuspend", n = {}, s = {})
public final class MallModel$orderTradePay$2 extends SuspendLambda implements Function1<Continuation<? super IResponse<OrderPayBean>>, Object> {
    final /* synthetic */ int $payType;
    final /* synthetic */ String $tradeNo;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MallModel$orderTradePay$2(String str, int i, Continuation<? super MallModel$orderTradePay$2> continuation) {
        super(1, continuation);
        this.$tradeNo = str;
        this.$payType = i;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new MallModel$orderTradePay$2(this.$tradeNo, this.$payType, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super IResponse<OrderPayBean>> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MallApi mallApiA = MallModel.f34763a.a();
            String str = this.$tradeNo;
            int i2 = this.$payType;
            this.label = 1;
            obj = mallApiA.g(str, i2, this);
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
