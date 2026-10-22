package com.huachenjie.common.reconfig.coroutine;

import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.common.reconfig.net.exception.b;
import com.zj.adlib.fv5;
import com.zj.adlib.pm1;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.common.reconfig.coroutine.CoroutineExtKt$launchCatching$2", f = "CoroutineExt.kt", i = {2}, l = {36, 45, 39, 45, 45}, m = "invokeSuspend", n = {"e"}, s = {"L$0"})
public final class CoroutineExtKt$launchCatching$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<pm1, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ Function2<ResultException, Continuation<? super Boolean>, Object> $errorFun;
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $onCompletion;
    final /* synthetic */ boolean $showError;
    final /* synthetic */ pm1 $this_launchCatching;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CoroutineExtKt$launchCatching$2(Function2<? super pm1, ? super Continuation<? super Unit>, ? extends Object> function2, pm1 pm1Var, Function2<? super ResultException, ? super Continuation<? super Boolean>, ? extends Object> function3, Function1<? super Continuation<? super Unit>, ? extends Object> function1, boolean z, Continuation<? super CoroutineExtKt$launchCatching$2> continuation) {
        super(2, continuation);
        this.$block = function2;
        this.$this_launchCatching = pm1Var;
        this.$errorFun = function3;
        this.$onCompletion = function1;
        this.$showError = z;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CoroutineExtKt$launchCatching$2(this.$block, this.$this_launchCatching, this.$errorFun, this.$onCompletion, this.$showError, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        Throwable th;
        ResultException resultExceptionA;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            try {
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i == 3) {
                                resultExceptionA = (ResultException) this.L$0;
                                ResultKt.throwOnFailure(obj);
                                boolean z = this.$showError;
                                if (!((Boolean) obj).booleanValue() && z) {
                                    fv5.b(resultExceptionA.getMessage());
                                }
                                Function1<Continuation<? super Unit>, Object> function1 = this.$onCompletion;
                                if (function1 != null) {
                                    this.L$0 = null;
                                    this.label = 4;
                                    if (function1.invoke(this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            } else if (i != 4) {
                                if (i != 5) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                th = (Throwable) this.L$0;
                                ResultKt.throwOnFailure(obj);
                                throw th;
                            }
                        }
                        ResultKt.throwOnFailure(obj);
                    } else {
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                Function2<pm1, Continuation<? super Unit>, Object> function2 = this.$block;
                pm1 pm1Var = this.$this_launchCatching;
                this.label = 1;
                if (function2.invoke(pm1Var, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Function1<Continuation<? super Unit>, Object> function3 = this.$onCompletion;
                if (function3 != null) {
                    this.label = 2;
                    if (function3.invoke(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } catch (Exception e) {
                resultExceptionA = b.f33873a.a(e);
                Function2<ResultException, Continuation<? super Boolean>, Object> function4 = this.$errorFun;
                this.L$0 = resultExceptionA;
                this.label = 3;
                obj = function4.invoke(resultExceptionA, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            Function1<Continuation<? super Unit>, Object> function5 = this.$onCompletion;
            if (function5 == null) {
                throw th2;
            }
            this.L$0 = th2;
            this.label = 5;
            if (function5.invoke(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            th = th2;
        }
    }
}
