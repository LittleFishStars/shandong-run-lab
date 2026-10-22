package com.huachenjie.channel.page.manage_channel.topic_chat;

import com.huachenjie.channel.api.RequestModel;
import com.huachenjie.channel.bean.manage_topic_chat.ManageTopic;
import com.huachenjie.channel.bean.manage_topic_chat.ManageTopicChat;
import com.netease.nimlib.sdk.team.model.Team;
import com.zj.adlib.z19;
import huachenjie.sdk.http.PageEntity;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.channel.page.manage_channel.topic_chat.ManageTopicChatVM$loadData$2", f = "ManageTopicChatVM.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nManageTopicChatVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ManageTopicChatVM.kt\ncom/huachenjie/channel/page/manage_channel/topic_chat/ManageTopicChatVM$loadData$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,59:1\n1855#2:60\n1855#2,2:61\n1856#2:63\n*S KotlinDebug\n*F\n+ 1 ManageTopicChatVM.kt\ncom/huachenjie/channel/page/manage_channel/topic_chat/ManageTopicChatVM$loadData$2\n*L\n32#1:60\n33#1:61,2\n32#1:63\n*E\n"})
public final class ManageTopicChatVM$loadData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $channelNo;
    int label;
    final /* synthetic */ ManageTopicChatVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManageTopicChatVM$loadData$2(String str, ManageTopicChatVM manageTopicChatVM, Continuation<? super ManageTopicChatVM$loadData$2> continuation) {
        super(2, continuation);
        this.$channelNo = str;
        this.this$0 = manageTopicChatVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ManageTopicChatVM$loadData$2(this.$channelNo, this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        List list;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RequestModel requestModel = RequestModel.f33012a;
            String str = this.$channelNo;
            this.label = 1;
            obj = requestModel.k0(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        PageEntity pageEntity = (PageEntity) obj;
        if (pageEntity != null && (list = pageEntity.getList()) != null) {
            ManageTopicChatVM manageTopicChatVM = this.this$0;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                for (ManageTopicChat manageTopicChat : ((ManageTopic) it.next()).getSubjectGroupList()) {
                    Team teamS = z19.s(manageTopicChat.getTid());
                    manageTopicChat.setTeamCount(teamS != null ? teamS.getMemberCount() : 0);
                }
            }
            ManageTopicChatAdapter value = manageTopicChatVM.i().getValue();
            if (value != null) {
                value.i();
                value.setList(list);
            }
        }
        return Unit.INSTANCE;
    }
}
