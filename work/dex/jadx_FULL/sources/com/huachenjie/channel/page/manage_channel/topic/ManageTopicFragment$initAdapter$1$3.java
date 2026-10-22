package com.huachenjie.channel.page.manage_channel.topic;

import com.huachenjie.channel.bean.my_channel.MyChannelTopic;
import com.huachenjie.channel.bean.my_channel.MyChannelTopicGroup;
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
public /* synthetic */ class ManageTopicFragment$initAdapter$1$3 extends FunctionReferenceImpl implements Function2<MyChannelTopicGroup, MyChannelTopic, Unit> {
    public ManageTopicFragment$initAdapter$1$3(Object obj) {
        super(2, obj, ManageTopicFragment.class, "editTopic", "editTopic(Lcom/huachenjie/channel/bean/my_channel/MyChannelTopicGroup;Lcom/huachenjie/channel/bean/my_channel/MyChannelTopic;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((MyChannelTopicGroup) obj, (MyChannelTopic) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull MyChannelTopicGroup myChannelTopicGroup, @NotNull MyChannelTopic myChannelTopic) {
        Intrinsics.checkNotNullParameter(myChannelTopicGroup, bo.g);
        Intrinsics.checkNotNullParameter(myChannelTopic, "p1");
        ((ManageTopicFragment) ((CallableReference) this).receiver).editTopic(myChannelTopicGroup, myChannelTopic);
    }
}
