package com.huachenjie.channel.page.manage_channel.topic_chat;

import com.huachenjie.channel.bean.manage_topic_chat.ManageTopicChat;
import com.kuaishou.weapon.p0.bo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class ManageTopicChatFragment$initAdapter$1$1 extends FunctionReferenceImpl implements Function1<ManageTopicChat, Unit> {
    public ManageTopicChatFragment$initAdapter$1$1(Object obj) {
        super(1, obj, ManageTopicChatFragment.class, "manageTeam", "manageTeam(Lcom/huachenjie/channel/bean/manage_topic_chat/ManageTopicChat;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ManageTopicChat) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ManageTopicChat manageTopicChat) {
        Intrinsics.checkNotNullParameter(manageTopicChat, bo.g);
        ((ManageTopicChatFragment) ((CallableReference) this).receiver).manageTeam(manageTopicChat);
    }
}
