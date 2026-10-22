package com.huachenjie.common.reconfig.net;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00030\u0002H\u008a@"}, d2 = {"S", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/huachenjie/common/reconfig/net/IResponse;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.common.reconfig.net.BaseRepositoryExtKt$request$2", f = "BaseRepositoryExt.kt", i = {}, l = {18, 18}, m = "invokeSuspend", n = {}, s = {})
public final class BaseRepositoryExtKt$request$2<T> extends SuspendLambda implements Function2<FlowCollector<? super IResponse<T>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super IResponse<T>>, Object> $block;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseRepositoryExtKt$request$2(Function1<? super Continuation<? super IResponse<T>>, ? extends Object> function1, Continuation<? super BaseRepositoryExtKt$request$2> continuation) {
        super(2, continuation);
        this.$block = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        BaseRepositoryExtKt$request$2 baseRepositoryExtKt$request$2 = new BaseRepositoryExtKt$request$2(this.$block, continuation);
        baseRepositoryExtKt$request$2.L$0 = obj;
        return baseRepositoryExtKt$request$2;
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super IResponse<T>> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        FlowCollector flowCollector;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                flowCollector = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        flowCollector = (FlowCollector) this.L$0;
        Function1<Continuation<? super IResponse<T>>, Object> function1 = this.$block;
        this.L$0 = flowCollector;
        this.label = 1;
        obj = function1.invoke(this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.L$0 = null;
        this.label = 2;
        if (flowCollector.emit(obj, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
