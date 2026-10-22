package com.huachenjie.mall.page.order_detail;

import com.huachenjie.base.bean.OrderGoodsBean;
import com.huachenjie.base.bean.mall.OrderDetailBean;
import com.huachenjie.mall.api.MallModel;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mall.page.order_detail.OrderDetailVM$queryOrderDetail$2", f = "OrderDetailVM.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
public final class OrderDetailVM$queryOrderDetail$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $orderNo;
    int label;
    final /* synthetic */ OrderDetailVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderDetailVM$queryOrderDetail$2(String str, OrderDetailVM orderDetailVM, Continuation<? super OrderDetailVM$queryOrderDetail$2> continuation) {
        super(2, continuation);
        this.$orderNo = str;
        this.this$0 = orderDetailVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new OrderDetailVM$queryOrderDetail$2(this.$orderNo, this.this$0, continuation);
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
            String str = this.$orderNo;
            this.label = 1;
            obj = mallModel.R(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        OrderDetailBean orderDetailBean = (OrderDetailBean) obj;
        if (orderDetailBean == null) {
            return Unit.INSTANCE;
        }
        OrderGoodsBean orderGoodsBean = (OrderGoodsBean) CollectionsKt.firstOrNull(orderDetailBean.getGoodsList());
        orderDetailBean.setAfterSaleStatus(orderGoodsBean != null ? orderGoodsBean.getAfterSaleStatus() : 0);
        this.this$0.q().setValue(orderDetailBean);
        this.this$0.v().setValue(Boxing.boxBoolean(true));
        this.this$0.u().setValue(Boxing.boxInt(1));
        Job job = this.this$0.countDownTask;
        if (job != null) {
            Job.a.b(job, (CancellationException) null, 1, (Object) null);
        }
        if (orderDetailBean.getOrderStatus() == 0 || orderDetailBean.getOrderStatus() == 5) {
            this.this$0.C(orderDetailBean);
        }
        return Unit.INSTANCE;
    }
}
