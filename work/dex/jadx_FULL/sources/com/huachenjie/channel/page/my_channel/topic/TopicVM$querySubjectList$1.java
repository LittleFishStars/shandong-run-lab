package com.huachenjie.channel.page.my_channel.topic;

import com.huachenjie.channel.api.RequestModel;
import com.huachenjie.channel.bean.my_channel.MyChannelTopic;
import com.huachenjie.channel.bean.my_channel.MyChannelTopicChat;
import com.huachenjie.channel.bean.my_channel.MyChannelTopicGroup;
import com.netease.nimlib.sdk.msg.model.RecentContact;
import com.zj.adlib.wt1;
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
@DebugMetadata(c = "com.huachenjie.channel.page.my_channel.topic.TopicVM$querySubjectList$1", f = "TopicVM.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nTopicVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TopicVM.kt\ncom/huachenjie/channel/page/my_channel/topic/TopicVM$querySubjectList$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,54:1\n1855#2:55\n1855#2:56\n1855#2,2:57\n1856#2:59\n1856#2:60\n*S KotlinDebug\n*F\n+ 1 TopicVM.kt\ncom/huachenjie/channel/page/my_channel/topic/TopicVM$querySubjectList$1\n*L\n28#1:55\n29#1:56\n30#1:57,2\n29#1:59\n28#1:60\n*E\n"})
public final class TopicVM$querySubjectList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $channelNo;
    int label;
    final /* synthetic */ TopicVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicVM$querySubjectList$1(String str, TopicVM topicVM, Continuation<? super TopicVM$querySubjectList$1> continuation) {
        super(2, continuation);
        this.$channelNo = str;
        this.this$0 = topicVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TopicVM$querySubjectList$1(this.$channelNo, this.this$0, continuation);
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
            obj = requestModel.m0(str, true, this);
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
            TopicVM topicVM = this.this$0;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Iterator<T> it2 = ((MyChannelTopicGroup) it.next()).getSubjectList().iterator();
                while (it2.hasNext()) {
                    for (MyChannelTopicChat myChannelTopicChat : ((MyChannelTopic) it2.next()).getSubjectGroupList()) {
                        RecentContact recentContactH = wt1.h().k().h(myChannelTopicChat.getTid());
                        if (recentContactH != null) {
                            topicVM.l(myChannelTopicChat, recentContactH);
                        }
                        topicVM.j().put(myChannelTopicChat.getTid(), myChannelTopicChat);
                    }
                }
            }
            TopicAdapter value = topicVM.i().getValue();
            if (value != null) {
                value.setList(list);
            }
        }
        return Unit.INSTANCE;
    }
}
