package com.huachenjie.channel.page.manage_channel.chat;

import com.huachenjie.channel.api.RequestModel;
import com.huachenjie.channel.bean.my_channel.MyChannelChatTeam;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.channel.page.manage_channel.chat.CreateChatTeamVM$editChannelTeam$1", f = "CreateChatTeamVM.kt", i = {}, l = {59}, m = "invokeSuspend", n = {}, s = {})
public final class CreateChatTeamVM$editChannelTeam$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $channelNo;
    int label;
    final /* synthetic */ CreateChatTeamVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateChatTeamVM$editChannelTeam$1(String str, CreateChatTeamVM createChatTeamVM, Continuation<? super CreateChatTeamVM$editChannelTeam$1> continuation) {
        super(2, continuation);
        this.$channelNo = str;
        this.this$0 = createChatTeamVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CreateChatTeamVM$editChannelTeam$1(this.$channelNo, this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String logoUrl;
        String teamTitle;
        String teamCode;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RequestModel requestModel = RequestModel.f33012a;
            String str = this.$channelNo;
            MyChannelChatTeam value = this.this$0.m().getValue();
            String str2 = (value == null || (teamCode = value.getTeamCode()) == null) ? "" : teamCode;
            MyChannelChatTeam value2 = this.this$0.m().getValue();
            String str3 = (value2 == null || (teamTitle = value2.getTeamTitle()) == null) ? "" : teamTitle;
            MyChannelChatTeam value3 = this.this$0.m().getValue();
            String str4 = (value3 == null || (logoUrl = value3.getLogoUrl()) == null) ? "" : logoUrl;
            this.label = 1;
            if (requestModel.J0(str, str2, str3, str4, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.this$0.o().setValue(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    }
}
