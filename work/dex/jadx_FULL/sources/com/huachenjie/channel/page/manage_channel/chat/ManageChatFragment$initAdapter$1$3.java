package com.huachenjie.channel.page.manage_channel.chat;

import com.huachenjie.channel.bean.my_channel.MyChannelChatTeam;
import com.huachenjie.channel.bean.my_channel.MyChannelChatTeamGroup;
import com.kuaishou.weapon.p0.bo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class ManageChatFragment$initAdapter$1$3 extends FunctionReferenceImpl implements Function2<MyChannelChatTeamGroup, MyChannelChatTeam, Unit> {
    public ManageChatFragment$initAdapter$1$3(Object obj) {
        super(2, obj, ManageChatFragment.class, "editChatTeam", "editChatTeam(Lcom/huachenjie/channel/bean/my_channel/MyChannelChatTeamGroup;Lcom/huachenjie/channel/bean/my_channel/MyChannelChatTeam;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((MyChannelChatTeamGroup) obj, (MyChannelChatTeam) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull MyChannelChatTeamGroup myChannelChatTeamGroup, @NotNull MyChannelChatTeam myChannelChatTeam) {
        Intrinsics.checkNotNullParameter(myChannelChatTeamGroup, bo.g);
        Intrinsics.checkNotNullParameter(myChannelChatTeam, "p1");
        ((ManageChatFragment) ((CallableReference) this).receiver).editChatTeam(myChannelChatTeamGroup, myChannelChatTeam);
    }
}
