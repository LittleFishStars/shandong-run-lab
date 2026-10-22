package com.huachenjie.mall.api;

import com.huachenjie.common.reconfig.net.IResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\u008a@"}, d2 = {"Lcom/huachenjie/common/reconfig/net/IResponse;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mall.api.MallModel$reportWatchedProgress$2", f = "MallModel.kt", i = {}, l = {732}, m = "invokeSuspend", n = {}, s = {})
public final class MallModel$reportWatchedProgress$2 extends SuspendLambda implements Function1<Continuation<? super IResponse<Object>>, Object> {
    final /* synthetic */ String $episodeItemNo;
    final /* synthetic */ String $orderItemNo;
    final /* synthetic */ int $sort;
    final /* synthetic */ long $watchDuration;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MallModel$reportWatchedProgress$2(String str, String str2, int i, long j, Continuation<? super MallModel$reportWatchedProgress$2> continuation) {
        super(1, continuation);
        this.$orderItemNo = str;
        this.$episodeItemNo = str2;
        this.$sort = i;
        this.$watchDuration = j;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new MallModel$reportWatchedProgress$2(this.$orderItemNo, this.$episodeItemNo, this.$sort, this.$watchDuration, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super IResponse<Object>> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MallApi mallApiA = MallModel.f34763a.a();
            String str = this.$orderItemNo;
            String str2 = this.$episodeItemNo;
            int i2 = this.$sort;
            long j = this.$watchDuration;
            this.label = 1;
            obj = mallApiA.W(str, str2, i2, j, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
