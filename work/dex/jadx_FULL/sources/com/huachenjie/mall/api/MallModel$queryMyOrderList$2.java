package com.huachenjie.mall.api;

import com.huachenjie.base.bean.MyOrderBean;
import com.huachenjie.common.reconfig.net.IResponse;
import huachenjie.sdk.http.PageEntity;
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
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0000H\u008a@"}, d2 = {"Lcom/huachenjie/common/reconfig/net/IResponse;", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/base/bean/MyOrderBean;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mall.api.MallModel$queryMyOrderList$2", f = "MallModel.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {})
public final class MallModel$queryMyOrderList$2 extends SuspendLambda implements Function1<Continuation<? super IResponse<PageEntity<MyOrderBean>>>, Object> {
    final /* synthetic */ Integer $commentStatus;
    final /* synthetic */ Integer $orderStatus;
    final /* synthetic */ int $pageNum;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MallModel$queryMyOrderList$2(int i, Integer num, Integer num2, Continuation<? super MallModel$queryMyOrderList$2> continuation) {
        super(1, continuation);
        this.$pageNum = i;
        this.$orderStatus = num;
        this.$commentStatus = num2;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new MallModel$queryMyOrderList$2(this.$pageNum, this.$orderStatus, this.$commentStatus, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super IResponse<PageEntity<MyOrderBean>>> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MallApi mallApiA = MallModel.f34763a.a();
            int i2 = this.$pageNum;
            Integer num = this.$orderStatus;
            Integer num2 = this.$commentStatus;
            this.label = 1;
            obj = mallApiA.M(i2, 10, num, num2, this);
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
