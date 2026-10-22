package com.zj.adlib;

import android.view.View;
import androidx.coroutines.DataBindingUtil;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.my_channel.MyChannelChatTeam;
import com.huachenjie.channel.databinding.ChannelItemMyChannelChatTeamBinding;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J(\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0010\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/zj/adlib/mj1;", "Lcom/chad/library/adapter/base/provider/BaseNodeProvider;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "helper", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "item", "", "a", "Landroid/view/View;", "view", "data", "", "position", "b", "getItemViewType", "()I", "itemViewType", "getLayoutId", "layoutId", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class mj1 extends BaseNodeProvider {
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void convert(@NotNull BaseViewHolder helper, @NotNull BaseNode item) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(item, "item");
        ChannelItemMyChannelChatTeamBinding channelItemMyChannelChatTeamBinding = (ChannelItemMyChannelChatTeamBinding) DataBindingUtil.bind(helper.itemView);
        if (channelItemMyChannelChatTeamBinding != null) {
            channelItemMyChannelChatTeamBinding.setVariable(tk0.g, item);
            channelItemMyChannelChatTeamBinding.executePendingBindings();
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onClick(@NotNull BaseViewHolder helper, @NotNull View view, @NotNull BaseNode data, int position) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        MyChannelChatTeam myChannelChatTeam = (MyChannelChatTeam) data;
        ARouter.getInstance().build(RoutePathConstants.IM.d).withString("accountId", myChannelChatTeam.getRoomId()).withString(UserConstants.CHAT_ROOM_PARAMS.b, myChannelChatTeam.getTeamTitle()).withString(UserConstants.CHAT_ROOM_PARAMS.c, myChannelChatTeam.getLogoUrl()).navigation();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getItemViewType() {
        return 2;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getLayoutId() {
        return R.layout.channel_item_my_channel_chat_team;
    }
}
