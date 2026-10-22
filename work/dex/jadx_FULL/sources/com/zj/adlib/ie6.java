package com.zj.adlib;

import android.view.View;
import androidx.coroutines.DataBindingUtil;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.triver.triver_render.view.canvas.tinyapp.c;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.OrganizeTeamBean;
import com.huachenjie.channel.databinding.ChannelItemMyChannelOrganizeChatBinding;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.im.DefaultCallback;
import com.netease.nimlib.sdk.team.model.Team;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J(\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0010\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/zj/adlib/ie6;", "Lcom/chad/library/adapter/base/provider/BaseNodeProvider;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "helper", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "item", "", "a", "Landroid/view/View;", "view", "data", "", "position", "b", "getItemViewType", "()I", "itemViewType", "getLayoutId", "layoutId", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class ie6 extends BaseNodeProvider {

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, d2 = {"com/zj/adlib/ie6$a", "Lcom/huachenjie/im/DefaultCallback;", "Lcom/netease/nimlib/sdk/team/model/Team;", "", "code", "result", "", c.f25231a, "", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DefaultCallback<Team> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OrganizeTeamBean f42345a;

        public a(OrganizeTeamBean organizeTeamBean) {
            this.f42345a = organizeTeamBean;
        }

        @Override // com.huachenjie.im.DefaultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int code, @Nullable Team result, @Nullable Throwable exception) {
            if (code == 200) {
                ARouter.getInstance().build(RoutePathConstants.IM.e).withString("accountId", this.f42345a.getTeamId()).withString(UserConstants.CHAT_TEAM_PARAMS.b, this.f42345a.getTeamTitle()).navigation();
                return;
            }
            if (code == 801) {
                fv5.b("来迟一步，群人数已满~");
            } else if (code != 803) {
                fv5.b("加入群聊失败");
            } else {
                fv5.b("群不存在");
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.chad.library.adapter.base.BaseNodeAdapter] */
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void convert(@NotNull BaseViewHolder helper, @NotNull BaseNode item) {
        BaseProviderMultiAdapter<BaseNode> adapter2;
        BaseNode item2;
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(item, "item");
        ?? adapter3 = getAdapter2();
        int iFindParentNode = adapter3 != 0 ? adapter3.findParentNode(item) : -1;
        if (iFindParentNode < 0 || (adapter2 = getAdapter2()) == null || (item2 = adapter2.getItem(iFindParentNode)) == null) {
            return;
        }
        List<BaseNode> childNode = item2.getChildNode();
        boolean zAreEqual = Intrinsics.areEqual(childNode != null ? (BaseNode) CollectionsKt.last(childNode) : null, item);
        ChannelItemMyChannelOrganizeChatBinding channelItemMyChannelOrganizeChatBinding = (ChannelItemMyChannelOrganizeChatBinding) DataBindingUtil.bind(helper.itemView);
        if (channelItemMyChannelOrganizeChatBinding != null) {
            channelItemMyChannelOrganizeChatBinding.setVariable(tk0.g, item);
            channelItemMyChannelOrganizeChatBinding.setVariable(tk0.C, Boolean.valueOf(zAreEqual));
            channelItemMyChannelOrganizeChatBinding.executePendingBindings();
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onClick(@NotNull BaseViewHolder helper, @NotNull View view, @NotNull BaseNode data, int position) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        super.onClick(helper, view, data, position);
        OrganizeTeamBean organizeTeamBean = (OrganizeTeamBean) data;
        z19.g(organizeTeamBean.getTeamId(), new a(organizeTeamBean));
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getItemViewType() {
        return 2;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getLayoutId() {
        return R.layout.channel_item_my_channel_organize_chat;
    }
}
