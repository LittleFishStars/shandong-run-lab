package com.huachenjie.channel.page.manage_channel.topic;

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
public /* synthetic */ class ManageTopicFragment$initAdapter$1$1 extends FunctionReferenceImpl implements Function2<MyChannelTopicGroup, Integer, Unit> {
    public ManageTopicFragment$initAdapter$1$1(Object obj) {
        super(2, obj, ManageTopicFragment.class, "editTopicGroup", "editTopicGroup(Lcom/huachenjie/channel/bean/my_channel/MyChannelTopicGroup;I)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((MyChannelTopicGroup) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull MyChannelTopicGroup myChannelTopicGroup, int i) {
        Intrinsics.checkNotNullParameter(myChannelTopicGroup, bo.g);
        ((ManageTopicFragment) ((CallableReference) this).receiver).editTopicGroup(myChannelTopicGroup, i);
    }
}
