package com.huachenjie.channel.api;

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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\u008a@"}, d2 = {"Lcom/huachenjie/common/reconfig/net/IResponse;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.channel.api.RequestModel$setOrganizeAdminUser$2", f = "RequestModel.kt", i = {}, l = {800}, m = "invokeSuspend", n = {}, s = {})
public final class RequestModel$setOrganizeAdminUser$2 extends SuspendLambda implements Function1<Continuation<? super IResponse<Object>>, Object> {
    final /* synthetic */ String $appUserCode;
    final /* synthetic */ String $channelNo;
    final /* synthetic */ String $clubCode;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestModel$setOrganizeAdminUser$2(String str, String str2, String str3, Continuation<? super RequestModel$setOrganizeAdminUser$2> continuation) {
        super(1, continuation);
        this.$channelNo = str;
        this.$appUserCode = str2;
        this.$clubCode = str3;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new RequestModel$setOrganizeAdminUser$2(this.$channelNo, this.$appUserCode, this.$clubCode, continuation);
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
            ChannelApi channelApiA = RequestModel.f33012a.a();
            String str = this.$channelNo;
            String str2 = this.$appUserCode;
            String str3 = this.$clubCode;
            this.label = 1;
            obj = channelApiA.u0(str, str2, str3, this);
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
