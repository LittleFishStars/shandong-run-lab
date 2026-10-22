package com.huachenjie.channel.page.my_channel.topic;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.channel.bean.my_channel.MyChannelTopicChat;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.kuaishou.weapon.p0.t;
import com.netease.nimlib.sdk.msg.model.RecentContact;
import com.zj.adlib.j64;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00128\u0006¢\u0006\f\n\u0004\b\r\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/channel/page/my_channel/topic/TopicVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "channelNo", "", "k", "Lcom/huachenjie/channel/bean/my_channel/MyChannelTopicChat;", "chat", "Lcom/netease/nimlib/sdk/msg/model/RecentContact;", "recent", t.d, "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/channel/page/my_channel/topic/TopicAdapter;", "a", "Landroidx/lifecycle/MutableLiveData;", "i", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "", "Ljava/util/Map;", "j", "()Ljava/util/Map;", "topicChatMap", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class TopicVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<TopicAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Map<String, MyChannelTopicChat> topicChatMap = new LinkedHashMap();

    @NotNull
    public final MutableLiveData<TopicAdapter> i() {
        return this.adapter;
    }

    @NotNull
    public final Map<String, MyChannelTopicChat> j() {
        return this.topicChatMap;
    }

    public final void k(@NotNull String channelNo) {
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        this.topicChatMap.clear();
        BaseViewModelExtKt.b(this, false, false, null, null, new TopicVM$querySubjectList$1(channelNo, this, null), 15, null);
    }

    public final void l(@NotNull MyChannelTopicChat chat, @NotNull RecentContact recent) {
        Intrinsics.checkNotNullParameter(chat, "chat");
        Intrinsics.checkNotNullParameter(recent, "recent");
        String strB = j64.b(recent.getMsgType(), recent.getContent(), recent.getAttachment(), Boolean.FALSE);
        Intrinsics.checkNotNullExpressionValue(strB, "convertMessageContent(\n …          false\n        )");
        chat.setMessage(strB);
        chat.setMessageCount(recent.getUnreadCount());
    }
}
