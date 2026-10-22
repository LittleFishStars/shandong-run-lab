package com.huachenjie.channel.page.notify.friend_apply;

import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.base.adapter.BaseRefreshAdapter;
import com.huachenjie.base.view.ExpandableTextView;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.FriendApplyBean;
import com.huachenjie.channel.databinding.ChannelItemFriendApplyBinding;
import com.huachenjie.channel.page.notify.friend_apply.FriendApplyListAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/channel/page/notify/friend_apply/FriendApplyListAdapter;", "Lcom/huachenjie/base/adapter/BaseRefreshAdapter;", "Lcom/huachenjie/channel/bean/FriendApplyBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/channel/databinding/ChannelItemFriendApplyBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "()V", "convert", "", "holder", "item", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FriendApplyListAdapter extends BaseRefreshAdapter<FriendApplyBean, BaseDataBindingHolder<ChannelItemFriendApplyBinding>> implements LoadMoreModule {
    public FriendApplyListAdapter() {
        super(R.layout.channel_item_friend_apply);
    }

    public static final void t(FriendApplyBean friendApplyBean, boolean z) {
        Intrinsics.checkNotNullParameter(friendApplyBean, "$item");
        friendApplyBean.setTextExpand(z);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<ChannelItemFriendApplyBinding> holder, @NotNull final FriendApplyBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ChannelItemFriendApplyBinding channelItemFriendApplyBinding = (ChannelItemFriendApplyBinding) holder.getDataBinding();
        if (channelItemFriendApplyBinding != null) {
            channelItemFriendApplyBinding.k(item);
            channelItemFriendApplyBinding.f7968a.setExpandText(item.getCloseContent(), item.getExpandContent());
            channelItemFriendApplyBinding.f7968a.setOnExpandChangeListener(new ExpandableTextView.OnExpandChangeListener() { // from class: com.zj.adlib.un3
                @Override // com.huachenjie.base.view.ExpandableTextView.OnExpandChangeListener
                public final void a(boolean z) {
                    FriendApplyListAdapter.t(item, z);
                }
            });
            channelItemFriendApplyBinding.executePendingBindings();
        }
    }
}
