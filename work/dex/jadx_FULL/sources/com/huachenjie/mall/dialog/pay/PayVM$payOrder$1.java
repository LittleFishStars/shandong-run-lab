package com.huachenjie.mall.dialog.pay;

import com.huachenjie.mall.api.MallModel;
import com.huachenjie.mall.bean.OrderPayBean;
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
@DebugMetadata(c = "com.huachenjie.mall.dialog.pay.PayVM$payOrder$1", f = "PayVM.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
public final class PayVM$payOrder$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $type;
    int label;
    final /* synthetic */ PayVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PayVM$payOrder$1(PayVM payVM, int i, Continuation<? super PayVM$payOrder$1> continuation) {
        super(2, continuation);
        this.this$0 = payVM;
        this.$type = i;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PayVM$payOrder$1(this.this$0, this.$type, continuation);
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
            String value = this.this$0.r().getValue();
            if (value == null) {
                value = "";
            }
            int i2 = this.$type;
            this.label = 1;
            obj = mallModel.n(value, i2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        OrderPayBean orderPayBean = (OrderPayBean) obj;
        if (orderPayBean != null) {
            this.this$0.n().setValue(orderPayBean);
        }
        return Unit.INSTANCE;
    }
}
