package com.huachenjie.channel.api;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huachenjie.channel.bean.ChannelMemberBean;
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
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0000H\u008a@"}, d2 = {"Lcom/huachenjie/common/reconfig/net/IResponse;", "Lcom/huachenjie/works/bean/publish/PubWorksMenuPageEntity;", "Lcom/huachenjie/channel/bean/ChannelMemberBean;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.channel.api.RequestModel$queryChannelMemberList$2", f = "RequestModel.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_TRAN_CONNECT_TIME}, m = "invokeSuspend", n = {}, s = {})
public final class RequestModel$queryChannelMemberList$2 extends SuspendLambda implements Function1<Continuation<? super IResponse<PubWorksMenuPageEntity<ChannelMemberBean>>>, Object> {
    final /* synthetic */ String $channelNo;
    final /* synthetic */ String $nickName;
    final /* synthetic */ int $pageNum;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestModel$queryChannelMemberList$2(int i, String str, String str2, Continuation<? super RequestModel$queryChannelMemberList$2> continuation) {
        super(1, continuation);
        this.$pageNum = i;
        this.$nickName = str;
        this.$channelNo = str2;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new RequestModel$queryChannelMemberList$2(this.$pageNum, this.$nickName, this.$channelNo, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super IResponse<PubWorksMenuPageEntity<ChannelMemberBean>>> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ChannelApi channelApiA = RequestModel.f33012a.a();
            int i2 = this.$pageNum;
            String str = this.$nickName;
            String str2 = this.$channelNo;
            this.label = 1;
            obj = channelApiA.s0(i2, 15, str, str2, this);
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
