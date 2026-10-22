package com.huachenjie.base.interact;

import com.huachenjie.base.interact.database.WorksInteractDatabase;
import com.zj.adlib.jo2;
import com.zj.adlib.v41;
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
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.base.interact.RankingInteractEvents$uploadRunner$1$1", f = "RankingInteractEvents.kt", i = {0}, l = {76}, m = "invokeSuspend", n = {"$this$runBlocking"}, s = {"L$0"})
public final class RankingInteractEvents$uploadRunner$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public RankingInteractEvents$uploadRunner$1$1(Continuation<? super RankingInteractEvents$uploadRunner$1$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        RankingInteractEvents$uploadRunner$1$1 rankingInteractEvents$uploadRunner$1$1 = new RankingInteractEvents$uploadRunner$1$1(continuation);
        rankingInteractEvents$uploadRunner$1$1.L$0 = obj;
        return rankingInteractEvents$uploadRunner$1$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        CoroutineScope coroutineScope;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            MainCoroutineDispatcher mainCoroutineDispatcherE = jo2.e();
            RankingInteractEvents$uploadRunner$1$1$interactJson$1 rankingInteractEvents$uploadRunner$1$1$interactJson$1 = new RankingInteractEvents$uploadRunner$1$1$interactJson$1(null);
            this.L$0 = coroutineScope2;
            this.label = 1;
            Object objH = v41.h(mainCoroutineDispatcherE, rankingInteractEvents$uploadRunner$1$1$interactJson$1, this);
            if (objH == coroutine_suspended) {
                return coroutine_suspended;
            }
            coroutineScope = coroutineScope2;
            obj = objH;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        String str = (String) obj;
        WorksInteractDatabase.INSTANCE.a().a();
        RankingInteractEvents rankingInteractEvents = RankingInteractEvents.f7211a;
        RankingInteractEvents.retryTimes = 0;
        Intrinsics.checkNotNullExpressionValue(str, "interactJson");
        rankingInteractEvents.y(coroutineScope, str);
        return Unit.INSTANCE;
    }
}
