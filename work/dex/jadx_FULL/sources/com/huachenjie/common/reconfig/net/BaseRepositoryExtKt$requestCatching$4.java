package com.huachenjie.common.reconfig.net;

import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.common.reconfig.net.exception.b;
import com.igexin.push.g.o;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u008a@"}, d2 = {"S", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "", o.f, "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.common.reconfig.net.BaseRepositoryExtKt$requestCatching$4", f = "BaseRepositoryExt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class BaseRepositoryExtKt$requestCatching$4<T> extends SuspendLambda implements Function3<FlowCollector<? super T>, Throwable, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ResultException.ApiException, Unit> $onApiError;
    final /* synthetic */ Function1<ResultException.NetException, Unit> $onNetError;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BaseRepositoryExtKt$requestCatching$4(Function1<? super ResultException.ApiException, Unit> function1, Function1<? super ResultException.NetException, Unit> function2, Continuation<? super BaseRepositoryExtKt$requestCatching$4> continuation) {
        super(3, continuation);
        this.$onApiError = function1;
        this.$onNetError = function2;
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super T> flowCollector, @NotNull Throwable th, @Nullable Continuation<? super Unit> continuation) {
        BaseRepositoryExtKt$requestCatching$4 baseRepositoryExtKt$requestCatching$4 = new BaseRepositoryExtKt$requestCatching$4(this.$onApiError, this.$onNetError, continuation);
        baseRepositoryExtKt$requestCatching$4.L$0 = th;
        return baseRepositoryExtKt$requestCatching$4.invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ResultException resultExceptionA = b.f33873a.a((Throwable) this.L$0);
        Unit unit = null;
        if (resultExceptionA instanceof ResultException.ApiException) {
            Function1<ResultException.ApiException, Unit> function1 = this.$onApiError;
            if (function1 != null) {
                function1.invoke(resultExceptionA);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                throw resultExceptionA;
            }
        } else if (resultExceptionA instanceof ResultException.NetException) {
            Function1<ResultException.NetException, Unit> function2 = this.$onNetError;
            if (function2 != null) {
                function2.invoke(resultExceptionA);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                throw resultExceptionA;
            }
        }
        return Unit.INSTANCE;
    }
}
