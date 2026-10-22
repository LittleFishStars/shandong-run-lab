package com.huachenjie.channel.page.manage_channel.topic_chat;

import com.chad.library.adapter.base.BaseNodeAdapter;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.manage_topic_chat.ManageTopic;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u0007\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\b¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/channel/page/manage_channel/topic_chat/ManageTopicChatAdapter;", "Lcom/chad/library/adapter/base/BaseNodeAdapter;", "", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "data", "", "position", "getItemType", "", "j", "i", "<init>", "()V", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class ManageTopicChatAdapter extends BaseNodeAdapter {
    public static final int K = 0;
    public static final int L = 1;

    public ManageTopicChatAdapter() {
        super(null, 1, null);
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public int getItemType(@NotNull List<? extends BaseNode> data, int position) {
        Intrinsics.checkNotNullParameter(data, "data");
        return !(data.get(position) instanceof ManageTopic) ? 1 : 0;
    }

    public final void i() {
        removeEmptyView();
    }

    public final void j() {
        setEmptyView(R.layout.channel_view_manage_topic_chat_empty);
    }
}
