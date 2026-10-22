package com.huachenjie.channel.page.manage_channel.topic;

import com.chad.library.adapter.base.BaseNodeAdapter;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.huachenjie.channel.bean.my_channel.MyChannelTopic;
import com.huachenjie.channel.bean.my_channel.MyChannelTopicGroup;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0007\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/channel/page/manage_channel/topic/ManageTopicAdapter;", "Lcom/chad/library/adapter/base/BaseNodeAdapter;", "", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "data", "", "position", "getItemType", "<init>", "()V", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class ManageTopicAdapter extends BaseNodeAdapter {
    public static final int K = 0;
    public static final int L = 1;
    public static final int M = 2;

    public ManageTopicAdapter() {
        super(null, 1, null);
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public int getItemType(@NotNull List<? extends BaseNode> data, int position) {
        Intrinsics.checkNotNullParameter(data, "data");
        BaseNode baseNode = data.get(position);
        if (baseNode instanceof MyChannelTopicGroup) {
            return 0;
        }
        return baseNode instanceof MyChannelTopic ? 1 : 2;
    }
}
