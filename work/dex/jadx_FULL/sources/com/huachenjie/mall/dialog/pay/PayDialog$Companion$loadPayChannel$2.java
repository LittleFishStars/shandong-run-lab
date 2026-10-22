package com.huachenjie.mall.dialog.pay;

import android.app.Dialog;
import com.huachenjie.mall.bean.MallPaySwitchConfig;
import com.zj.adlib.fv5;
import com.zj.adlib.jo2;
import com.zj.adlib.pm1;
import com.zj.adlib.v41;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lcom/zj/adlib/pm1;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mall.dialog.pay.PayDialog$Companion$loadPayChannel$2", f = "PayDialog.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
public final class PayDialog$Companion$loadPayChannel$2 extends SuspendLambda implements Function2<pm1, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<MallPaySwitchConfig, Unit> $callback;
    final /* synthetic */ Dialog $dialog;
    final /* synthetic */ String $shopNo;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PayDialog$Companion$loadPayChannel$2(Dialog dialog, Function1<? super MallPaySwitchConfig, Unit> function1, String str, Continuation<? super PayDialog$Companion$loadPayChannel$2> continuation) {
        super(2, continuation);
        this.$dialog = dialog;
        this.$callback = function1;
        this.$shopNo = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PayDialog$Companion$loadPayChannel$2(this.$dialog, this.$callback, this.$shopNo, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull pm1 pm1Var, @Nullable Continuation<? super Unit> continuation) {
        return create(pm1Var, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.$dialog.show();
            CoroutineDispatcher coroutineDispatcherC = jo2.c();
            PayDialog$Companion$loadPayChannel$2$result$1 payDialog$Companion$loadPayChannel$2$result$1 = new PayDialog$Companion$loadPayChannel$2$result$1(this.$shopNo, null);
            this.label = 1;
            obj = v41.h(coroutineDispatcherC, payDialog$Companion$loadPayChannel$2$result$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        MallPaySwitchConfig mallPaySwitchConfig = (MallPaySwitchConfig) obj;
        this.$dialog.dismiss();
        if (mallPaySwitchConfig == null || mallPaySwitchConfig.getList().isEmpty()) {
            fv5.b("当前商品暂不支持购买");
            return Unit.INSTANCE;
        }
        this.$callback.invoke(mallPaySwitchConfig);
        return Unit.INSTANCE;
    }
}
