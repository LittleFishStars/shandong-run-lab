package com.huachenjie.channel.page.manage_channel.topic;

import com.huachenjie.channel.bean.my_channel.MyChannelTopicGroup;
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
public /* synthetic */ class ManageTopicFragment$initAdapter$1$4 extends FunctionReferenceImpl implements Function1<MyChannelTopicGroup, Unit> {
    public ManageTopicFragment$initAdapter$1$4(Object obj) {
        super(1, obj, ManageTopicFragment.class, "addTopic", "addTopic(Lcom/huachenjie/channel/bean/my_channel/MyChannelTopicGroup;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((MyChannelTopicGroup) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull MyChannelTopicGroup myChannelTopicGroup) {
        Intrinsics.checkNotNullParameter(myChannelTopicGroup, bo.g);
        ((ManageTopicFragment) ((CallableReference) this).receiver).addTopic(myChannelTopicGroup);
    }
}
