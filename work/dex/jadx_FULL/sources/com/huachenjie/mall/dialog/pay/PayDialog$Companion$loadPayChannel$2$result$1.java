package com.huachenjie.mall.dialog.pay;

import com.huachenjie.mall.api.MallModel;
import com.huachenjie.mall.bean.MallPaySwitchConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/huachenjie/mall/bean/MallPaySwitchConfig;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mall.dialog.pay.PayDialog$Companion$loadPayChannel$2$result$1", f = "PayDialog.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {})
public final class PayDialog$Companion$loadPayChannel$2$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super MallPaySwitchConfig>, Object> {
    final /* synthetic */ String $shopNo;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PayDialog$Companion$loadPayChannel$2$result$1(String str, Continuation<? super PayDialog$Companion$loadPayChannel$2$result$1> continuation) {
        super(2, continuation);
        this.$shopNo = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PayDialog$Companion$loadPayChannel$2$result$1(this.$shopNo, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super MallPaySwitchConfig> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MallModel mallModel = MallModel.f34763a;
            String str = this.$shopNo;
            this.label = 1;
            obj = mallModel.T(str, this);
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
