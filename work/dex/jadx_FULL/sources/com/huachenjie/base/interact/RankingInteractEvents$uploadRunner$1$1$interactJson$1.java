package com.huachenjie.base.interact;

import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.zj.adlib.cq;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "kotlin.jvm.PlatformType", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.base.interact.RankingInteractEvents$uploadRunner$1$1$interactJson$1", f = "RankingInteractEvents.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RankingInteractEvents$uploadRunner$1$1$interactJson$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    int label;

    public RankingInteractEvents$uploadRunner$1$1$interactJson$1(Continuation<? super RankingInteractEvents$uploadRunner$1$1$interactJson$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RankingInteractEvents$uploadRunner$1$1$interactJson$1(continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super String> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("signTimestamp", Boxing.boxLong(System.currentTimeMillis()));
        StringBuilder sb = new StringBuilder();
        RankingInteractEvents rankingInteractEvents = RankingInteractEvents.f7211a;
        sb.append(rankingInteractEvents.q());
        sb.append('|');
        sb.append(linkedHashMap.get("signTimestamp"));
        String strC = cq.c(sb.toString(), "YfYxpXfhBqSMpkn5x523TtPEydcS8JznrAnY5nRNSTA=");
        Intrinsics.checkNotNullExpressionValue(strC, "encrypt(\"${signUserId}|$…fig.RANKING_INTERACT_KEY)");
        linkedHashMap.put(UserTrackConstant.SIGN, strC);
        linkedHashMap.put("eventList", rankingInteractEvents.x(rankingInteractEvents.p().getEventList()));
        String json = rankingInteractEvents.o().toJson(linkedHashMap);
        rankingInteractEvents.p().getEventList().clear();
        return json;
    }
}
