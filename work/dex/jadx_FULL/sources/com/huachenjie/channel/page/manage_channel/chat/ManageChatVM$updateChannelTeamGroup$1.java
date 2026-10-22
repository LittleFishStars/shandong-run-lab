package com.huachenjie.channel.page.manage_channel.chat;

import android.app.Dialog;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.huachenjie.channel.api.RequestModel;
import com.huachenjie.channel.bean.my_channel.MyChannelChatTeamGroup;
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
@DebugMetadata(c = "com.huachenjie.channel.page.manage_channel.chat.ManageChatVM$updateChannelTeamGroup$1", f = "ManageChatVM.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
public final class ManageChatVM$updateChannelTeamGroup$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MyChannelChatTeamGroup $bean;
    final /* synthetic */ String $channelNo;
    final /* synthetic */ Dialog $dialog;
    final /* synthetic */ int $position;
    final /* synthetic */ String $teamGroupTitle;
    int label;
    final /* synthetic */ ManageChatVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManageChatVM$updateChannelTeamGroup$1(String str, String str2, MyChannelChatTeamGroup myChannelChatTeamGroup, ManageChatVM manageChatVM, int i, Dialog dialog, Continuation<? super ManageChatVM$updateChannelTeamGroup$1> continuation) {
        super(2, continuation);
        this.$channelNo = str;
        this.$teamGroupTitle = str2;
        this.$bean = myChannelChatTeamGroup;
        this.this$0 = manageChatVM;
        this.$position = i;
        this.$dialog = dialog;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ManageChatVM$updateChannelTeamGroup$1(this.$channelNo, this.$teamGroupTitle, this.$bean, this.this$0, this.$position, this.$dialog, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RequestModel requestModel = RequestModel.f33012a;
            String str = this.$channelNo;
            String str2 = this.$teamGroupTitle;
            String teamGroupCode = this.$bean.getTeamGroupCode();
            this.label = 1;
            if (requestModel.K0(str, str2, teamGroupCode, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.$bean.setTeamGroupTitle(this.$teamGroupTitle);
        ManageChatAdapter value = this.this$0.n().getValue();
        if (value != null) {
            value.setData(this.$position, (BaseNode) this.$bean);
        }
        this.$dialog.dismiss();
        this.this$0.o().setValue(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    }
}
