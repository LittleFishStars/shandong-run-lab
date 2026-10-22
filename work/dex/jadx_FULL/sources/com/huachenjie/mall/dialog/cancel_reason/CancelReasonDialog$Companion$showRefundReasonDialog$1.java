package com.huachenjie.mall.dialog.cancel_reason;

import androidx.fragment.app.FragmentManager;
import com.huachenjie.mall.api.MallModel;
import com.huachenjie.mall.bean.OrderReasonBean;
import com.huachenjie.mall.bean.OrderReasonListBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mall.dialog.cancel_reason.CancelReasonDialog$Companion$showRefundReasonDialog$1", f = "CancelReasonDialog.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
public final class CancelReasonDialog$Companion$showRefundReasonDialog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<OrderReasonBean, Unit> $callback;
    final /* synthetic */ FragmentManager $manager;
    final /* synthetic */ OrderReasonBean $preReasonBean;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CancelReasonDialog$Companion$showRefundReasonDialog$1(FragmentManager fragmentManager, OrderReasonBean orderReasonBean, Function1<? super OrderReasonBean, Unit> function1, Continuation<? super CancelReasonDialog$Companion$showRefundReasonDialog$1> continuation) {
        super(2, continuation);
        this.$manager = fragmentManager;
        this.$preReasonBean = orderReasonBean;
        this.$callback = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CancelReasonDialog$Companion$showRefundReasonDialog$1(this.$manager, this.$preReasonBean, this.$callback, continuation);
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
            this.label = 1;
            obj = mallModel.Y(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        OrderReasonListBean orderReasonListBean = (OrderReasonListBean) obj;
        if (orderReasonListBean == null) {
            return Unit.INSTANCE;
        }
        CancelReasonDialog.INSTANCE.b(orderReasonListBean, this.$manager, 2, this.$preReasonBean, this.$callback);
        return Unit.INSTANCE;
    }
}
