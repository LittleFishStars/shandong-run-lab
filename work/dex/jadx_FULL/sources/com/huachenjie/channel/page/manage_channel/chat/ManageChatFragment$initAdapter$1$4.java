package com.huachenjie.channel.page.manage_channel.chat;

import com.huachenjie.channel.bean.my_channel.MyChannelChatTeamGroup;
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
public /* synthetic */ class ManageChatFragment$initAdapter$1$4 extends FunctionReferenceImpl implements Function1<MyChannelChatTeamGroup, Unit> {
    public ManageChatFragment$initAdapter$1$4(Object obj) {
        super(1, obj, ManageChatFragment.class, "addChatTeam", "addChatTeam(Lcom/huachenjie/channel/bean/my_channel/MyChannelChatTeamGroup;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((MyChannelChatTeamGroup) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull MyChannelChatTeamGroup myChannelChatTeamGroup) {
        Intrinsics.checkNotNullParameter(myChannelChatTeamGroup, bo.g);
        ((ManageChatFragment) ((CallableReference) this).receiver).addChatTeam(myChannelChatTeamGroup);
    }
}
