package com.huachenjie.mall.page.order_detail;

import com.huachenjie.base.bean.mall.OrderDetailBean;
import com.huachenjie.mall.api.MallModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mall.page.order_detail.OrderDetailVM$confirmReceive$1", f = "OrderDetailVM.kt", i = {}, l = {116}, m = "invokeSuspend", n = {}, s = {})
public final class OrderDetailVM$confirmReceive$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ OrderDetailVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderDetailVM$confirmReceive$1(OrderDetailVM orderDetailVM, Continuation<? super OrderDetailVM$confirmReceive$1> continuation) {
        super(2, continuation);
        this.this$0 = orderDetailVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new OrderDetailVM$confirmReceive$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String orderNo;
        String orderNo2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        String str = "";
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MallModel mallModel = MallModel.f34763a;
            OrderDetailBean value = this.this$0.q().getValue();
            if (value == null || (orderNo = value.getOrderNo()) == null) {
                orderNo = "";
            }
            this.label = 1;
            if (mallModel.i(orderNo, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        OrderDetailVM orderDetailVM = this.this$0;
        OrderDetailBean value2 = orderDetailVM.q().getValue();
        if (value2 != null && (orderNo2 = value2.getOrderNo()) != null) {
            str = orderNo2;
        }
        OrderDetailVM.y(orderDetailVM, str, false, 2, null);
        this.this$0.s().setValue(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    }
}
