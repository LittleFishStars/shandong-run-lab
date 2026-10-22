package com.huachenjie.base.interact;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.base.interact.WorksInteractEvents$initInteractEvents$1$1", f = "WorksInteractEvents.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class WorksInteractEvents$initInteractEvents$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $interactJson;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorksInteractEvents$initInteractEvents$1$1(String str, Continuation<? super WorksInteractEvents$initInteractEvents$1$1> continuation) {
        super(2, continuation);
        this.$interactJson = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        WorksInteractEvents$initInteractEvents$1$1 worksInteractEvents$initInteractEvents$1$1 = new WorksInteractEvents$initInteractEvents$1$1(this.$interactJson, continuation);
        worksInteractEvents$initInteractEvents$1$1.L$0 = obj;
        return worksInteractEvents$initInteractEvents$1$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        WorksInteractEvents worksInteractEvents = WorksInteractEvents.f7217a;
        WorksInteractEvents.retryTimes = 0;
        String str = this.$interactJson;
        Intrinsics.checkNotNullExpressionValue(str, "interactJson");
        worksInteractEvents.w(coroutineScope, str);
        return Unit.INSTANCE;
    }
}
