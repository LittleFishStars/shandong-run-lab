package com.huachenjie.mall.dialog.pay;

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
@DebugMetadata(c = "com.huachenjie.mall.dialog.pay.PayVM$startCountDown$1", f = "PayVM.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, s = {})
public final class PayVM$startCountDown$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PayVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PayVM$startCountDown$1(PayVM payVM, Continuation<? super PayVM$startCountDown$1> continuation) {
        super(2, continuation);
        this.this$0 = payVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PayVM$startCountDown$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:14:0x003f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:12:0x002c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:11:0x002b
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L18
            if (r1 != r2) goto L10
            kotlin.ResultKt.throwOnFailure(r6)
            r6 = r5
            goto L2c
        L10:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L18:
            kotlin.ResultKt.throwOnFailure(r6)
            r6 = r5
        L1c:
            com.huachenjie.mall.dialog.pay.PayVM r1 = r6.this$0
            com.huachenjie.mall.dialog.pay.PayVM.k(r1)
            r6.label = r2
            r3 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r1 = kotlinx.coroutines.DelayKt.b(r3, r6)
            if (r1 != r0) goto L2c
            return r0
        L2c:
            com.huachenjie.mall.dialog.pay.PayVM r1 = r6.this$0
            int r3 = com.huachenjie.mall.dialog.pay.PayVM.i(r1)
            int r3 = r3 + (-1)
            com.huachenjie.mall.dialog.pay.PayVM.j(r1, r3)
            com.huachenjie.mall.dialog.pay.PayVM r1 = r6.this$0
            int r1 = com.huachenjie.mall.dialog.pay.PayVM.i(r1)
            if (r1 > 0) goto L1c
            com.huachenjie.mall.dialog.pay.PayVM r0 = r6.this$0
            com.huachenjie.mall.dialog.pay.PayVM.k(r0)
            com.huachenjie.mall.dialog.pay.PayVM r6 = r6.this$0
            androidx.lifecycle.MutableLiveData r6 = r6.m()
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            r6.setValue(r0)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huachenjie.mall.dialog.pay.PayVM$startCountDown$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
