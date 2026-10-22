package com.huachenjie.channel.api;

import com.huachenjie.channel.bean.ChannelTopicBean;
import com.huachenjie.common.reconfig.net.IResponse;
import huachenjie.sdk.http.PageEntity;
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
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0000H\u008a@"}, d2 = {"Lcom/huachenjie/common/reconfig/net/IResponse;", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/channel/bean/ChannelTopicBean;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.channel.api.RequestModel$querySubjectList$2", f = "RequestModel.kt", i = {}, l = {111}, m = "invokeSuspend", n = {}, s = {})
public final class RequestModel$querySubjectList$2 extends SuspendLambda implements Function1<Continuation<? super IResponse<PageEntity<ChannelTopicBean>>>, Object> {
    final /* synthetic */ String $channelNo;
    final /* synthetic */ int $pageNum;
    final /* synthetic */ int $pageSize;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestModel$querySubjectList$2(String str, int i, int i2, Continuation<? super RequestModel$querySubjectList$2> continuation) {
        super(1, continuation);
        this.$channelNo = str;
        this.$pageNum = i;
        this.$pageSize = i2;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new RequestModel$querySubjectList$2(this.$channelNo, this.$pageNum, this.$pageSize, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super IResponse<PageEntity<ChannelTopicBean>>> continuation) {
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
            int i2 = this.$pageNum;
            int i3 = this.$pageSize;
            this.label = 1;
            obj = channelApiA.l(str, i2, i3, this);
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
