package com.huachenjie.mall.page.order_detail;

import com.huachenjie.base.bean.mall.OrderDetailBean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mall.page.order_detail.OrderDetailVM$startCountDown$1", f = "OrderDetailVM.kt", i = {0}, l = {86}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class OrderDetailVM$startCountDown$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OrderDetailBean $detailBean;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ OrderDetailVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderDetailVM$startCountDown$1(OrderDetailBean orderDetailBean, OrderDetailVM orderDetailVM, Continuation<? super OrderDetailVM$startCountDown$1> continuation) {
        super(2, continuation);
        this.$detailBean = orderDetailBean;
        this.this$0 = orderDetailVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        OrderDetailVM$startCountDown$1 orderDetailVM$startCountDown$1 = new OrderDetailVM$startCountDown$1(this.$detailBean, this.this$0, continuation);
        orderDetailVM$startCountDown$1.L$0 = obj;
        return orderDetailVM$startCountDown$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002b  */
    /* JADX WARN: Code duplicated, block: B:13:0x0034  */
    /* JADX WARN: Code duplicated, block: B:15:0x004b  */
    /* JADX WARN: Code duplicated, block: B:18:0x0064 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0062 -> B:19:0x0065). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L1c
            if (r1 != r2) goto L14
            java.lang.Object r1 = r6.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = r6
            goto L65
        L14:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1c:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.Object r7 = r6.L$0
            kotlinx.coroutines.CoroutineScope r7 = (kotlinx.coroutines.CoroutineScope) r7
            r1 = r7
            r7 = r6
        L25:
            boolean r3 = kotlinx.coroutines.f.k(r1)
            if (r3 == 0) goto L89
            com.huachenjie.base.bean.mall.OrderDetailBean r3 = r7.$detailBean
            int r3 = r3.getPayRemainTime()
            r4 = 0
            if (r3 < 0) goto L71
            com.huachenjie.mall.page.order_detail.OrderDetailVM r3 = r7.this$0
            androidx.lifecycle.MutableLiveData r3 = r3.t()
            com.huachenjie.base.bean.mall.OrderDetailBean r5 = r7.$detailBean
            java.lang.String r5 = r5.getRemainPayTime()
            r3.setValue(r5)
            com.huachenjie.base.bean.mall.OrderDetailBean r3 = r7.$detailBean
            int r3 = r3.getPayRemainTime()
            if (r3 != 0) goto L58
            com.huachenjie.mall.page.order_detail.OrderDetailVM r3 = r7.this$0
            androidx.lifecycle.MutableLiveData r3 = r3.v()
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            r3.setValue(r4)
        L58:
            r7.L$0 = r1
            r7.label = r2
            r3 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r3 = kotlinx.coroutines.DelayKt.b(r3, r7)
            if (r3 != r0) goto L65
            return r0
        L65:
            com.huachenjie.base.bean.mall.OrderDetailBean r3 = r7.$detailBean
            int r4 = r3.getPayRemainTime()
            int r4 = r4 + (-1)
            r3.setPayRemainTime(r4)
            goto L25
        L71:
            com.huachenjie.mall.page.order_detail.OrderDetailVM r0 = r7.this$0
            kotlinx.coroutines.Job r0 = com.huachenjie.mall.page.order_detail.OrderDetailVM.k(r0)
            r1 = 0
            if (r0 == 0) goto L7d
            kotlinx.coroutines.Job.a.b(r0, r1, r2, r1)
        L7d:
            com.huachenjie.mall.page.order_detail.OrderDetailVM r0 = r7.this$0
            com.huachenjie.base.bean.mall.OrderDetailBean r7 = r7.$detailBean
            java.lang.String r7 = r7.getOrderNo()
            r2 = 2
            com.huachenjie.mall.page.order_detail.OrderDetailVM.y(r0, r7, r4, r2, r1)
        L89:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huachenjie.mall.page.order_detail.OrderDetailVM$startCountDown$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
