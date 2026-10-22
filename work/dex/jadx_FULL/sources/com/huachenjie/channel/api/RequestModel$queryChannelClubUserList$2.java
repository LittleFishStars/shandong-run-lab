package com.huachenjie.channel.api;

import com.huachenjie.channel.bean.OrganizeTeamUserBean;
import com.huachenjie.common.reconfig.net.IResponse;
import com.huachenjie.works.bean.publish.PubWorksMenuPageEntity;
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
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u008a@"}, d2 = {"Lcom/huachenjie/common/reconfig/net/IResponse;", "Lcom/huachenjie/works/bean/publish/PubWorksMenuPageEntity;", "Lcom/huachenjie/channel/bean/OrganizeTeamUserBean;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.channel.api.RequestModel$queryChannelClubUserList$2", f = "RequestModel.kt", i = {}, l = {844}, m = "invokeSuspend", n = {}, s = {})
public final class RequestModel$queryChannelClubUserList$2 extends SuspendLambda implements Function1<Continuation<? super IResponse<PubWorksMenuPageEntity<OrganizeTeamUserBean>>>, Object> {
    final /* synthetic */ String $clubCode;
    final /* synthetic */ String $clubUserName;
    final /* synthetic */ int $pageNum;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestModel$queryChannelClubUserList$2(String str, String str2, int i, Continuation<? super RequestModel$queryChannelClubUserList$2> continuation) {
        super(1, continuation);
        this.$clubCode = str;
        this.$clubUserName = str2;
        this.$pageNum = i;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new RequestModel$queryChannelClubUserList$2(this.$clubCode, this.$clubUserName, this.$pageNum, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super IResponse<PubWorksMenuPageEntity<OrganizeTeamUserBean>>> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ChannelApi channelApiA = RequestModel.f33012a.a();
            String str = this.$clubCode;
            String str2 = this.$clubUserName;
            int i2 = this.$pageNum;
            this.label = 1;
            obj = channelApiA.p(str, str2, i2, 10, this);
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
