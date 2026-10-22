package com.huachenjie.channel.page.my_channel.communication;

import com.chad.library.adapter.base.BaseNodeAdapter;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.huachenjie.channel.bean.my_channel.MyChannelChatTeam;
import com.huachenjie.channel.bean.my_channel.MyChannelChatTeamGroup;
import com.zj.adlib.kj1;
import com.zj.adlib.mj1;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0007\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/channel/page/my_channel/communication/CommunicationAdapter;", "Lcom/chad/library/adapter/base/BaseNodeAdapter;", "", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "data", "", "position", "getItemType", "<init>", "()V", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class CommunicationAdapter extends BaseNodeAdapter {
    public static final int K = 1;
    public static final int L = 2;

    public CommunicationAdapter() {
        super(null, 1, null);
        addNodeProvider(new kj1());
        addNodeProvider(new mj1());
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public int getItemType(@NotNull List<? extends BaseNode> data, int position) {
        Intrinsics.checkNotNullParameter(data, "data");
        BaseNode baseNode = data.get(position);
        if (baseNode instanceof MyChannelChatTeamGroup) {
            return 1;
        }
        if (baseNode instanceof MyChannelChatTeam) {
            return 2;
        }
        throw new IllegalArgumentException("Invalid type of data " + position);
    }
}
