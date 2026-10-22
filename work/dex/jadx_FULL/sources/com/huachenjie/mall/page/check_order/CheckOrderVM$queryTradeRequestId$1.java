package com.huachenjie.mall.page.check_order;

import com.alibaba.fastjson.JSONObject;
import com.huachenjie.mall.api.MallModel;
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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mall.page.check_order.CheckOrderVM$queryTradeRequestId$1", f = "CheckOrderVM.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
public final class CheckOrderVM$queryTradeRequestId$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ CheckOrderVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckOrderVM$queryTradeRequestId$1(CheckOrderVM checkOrderVM, Continuation<? super CheckOrderVM$queryTradeRequestId$1> continuation) {
        super(2, continuation);
        this.this$0 = checkOrderVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CheckOrderVM$queryTradeRequestId$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        CheckOrderVM checkOrderVM;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CheckOrderVM checkOrderVM2 = this.this$0;
            MallModel mallModel = MallModel.f34763a;
            this.L$0 = checkOrderVM2;
            this.label = 1;
            Object objD0 = mallModel.d0(this);
            if (objD0 == coroutine_suspended) {
                return coroutine_suspended;
            }
            checkOrderVM = checkOrderVM2;
            obj = objD0;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            checkOrderVM = (CheckOrderVM) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        JSONObject jSONObject = (JSONObject) obj;
        checkOrderVM.requestId = jSONObject != null ? jSONObject.getString("requestId") : null;
        return Unit.INSTANCE;
    }
}
