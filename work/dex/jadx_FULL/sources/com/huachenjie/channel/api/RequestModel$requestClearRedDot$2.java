package com.huachenjie.channel.api;

import com.google.gson.JsonObject;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\u008a@"}, d2 = {"Lcom/huachenjie/common/reconfig/net/IResponse;", "Lcom/google/gson/JsonObject;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.channel.api.RequestModel$requestClearRedDot$2", f = "RequestModel.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
public final class RequestModel$requestClearRedDot$2 extends SuspendLambda implements Function1<Continuation<? super IResponse<JsonObject>>, Object> {
    final /* synthetic */ int $messageType;
    final /* synthetic */ String $msgId;
    final /* synthetic */ int $readType;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestModel$requestClearRedDot$2(int i, String str, int i2, Continuation<? super RequestModel$requestClearRedDot$2> continuation) {
        super(1, continuation);
        this.$messageType = i;
        this.$msgId = str;
        this.$readType = i2;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new RequestModel$requestClearRedDot$2(this.$messageType, this.$msgId, this.$readType, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super IResponse<JsonObject>> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ChannelApi channelApiA = RequestModel.f33012a.a();
            int i2 = this.$messageType;
            String str = this.$msgId;
            int i3 = this.$readType;
            this.label = 1;
            obj = channelApiA.C0(i2, str, i3, this);
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
